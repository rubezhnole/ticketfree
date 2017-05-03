package com.ticketfree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ticketfree.entity.bean.Event;
import com.ticketfree.entity.bean.Ticket;
import com.ticketfree.entity.bean.User;
import com.ticketfree.service.dao.BaseDao;
import com.ticketfree.util.JacksonUtil;
import com.ticketfree.util.SessionUtil;
import com.ticketfree.util.TicketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private BaseDao baseDao;

    @RequestMapping(value = "order", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void order(Integer eventId, Integer number) {

        User user = SessionUtil.getUser(baseDao);

        baseDao.buyTicket(eventId, number, user);
    }

    @RequestMapping("load")
    public ModelAndView load(ModelAndView mav) {
        User user = SessionUtil.getUser(baseDao);
        mav.addObject("userId", user.getEntityId());
        mav.setViewName("ticketPage");
        return mav;
    }

    @RequestMapping(value = "loadByEvent", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadByEvent(Integer eventId) {
        List<Ticket> tickets = baseDao.loadTicketByEvent(eventId);
        String json = null;
        try {
            json = JacksonUtil.toJson(tickets);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "loadByUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadByUser(Integer userId) {
        Map<Event, List<Ticket>> tickets = baseDao.loadTicketByUser(userId)
                .stream()
                .collect(Collectors.groupingBy(Ticket::getEvent))
                .entrySet()
                .stream()
                .sorted((t1, t2) -> t2.getKey().getDateStart().compareTo(t1.getKey().getDateStart()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        JsonArray jsonArray = new JsonArray();
        for (Map.Entry<Event, List<Ticket>> entry : tickets.entrySet()) {
            JsonObject eventTickets = new JsonObject();
            eventTickets.add("event", entry.getKey().toJson());

            JsonArray jsonTickets = new JsonArray();
            entry.getValue().forEach(t -> jsonTickets.add(t.toJson()));

            eventTickets.add("tickets", jsonTickets);
            jsonArray.add(eventTickets);
        }
        return jsonArray.toString();
    }

    @RequestMapping(value = "loadByEventAndUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadByEventAndUser(Integer eventId, Integer userId) {
        List<Ticket> tickets = baseDao.loadTicketByEventAndUser(eventId, userId);
        String json = null;
        try {
            json = JacksonUtil.toJson(tickets);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("loadTicket")
    public void loadTicket(String uuid, HttpServletResponse response) {
        byte[] data = TicketUtil.generateTicket(uuid, baseDao);
        try {
            streamReport(response, data, uuid + ".pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void streamReport(HttpServletResponse response, byte[] data, String name)
            throws IOException {

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);

        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    }
}