package com.ticketfree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ticketfree.entity.bean.Ticket;
import com.ticketfree.entity.bean.User;
import com.ticketfree.service.dao.BaseDao;
import com.ticketfree.util.JacksonUtil;
import com.ticketfree.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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
        List<Ticket> tickets = baseDao.loadTicketByUser(userId);
        String json = null;
        try {
            json = JacksonUtil.toJson(tickets);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
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
    @ResponseBody
    public String loadTicket(String uuid) {
        return baseDao.findTicketByUUID(uuid)
                .map(ticket -> {
                    return "ticket uuid is " +  ticket.getUuid();
                }).orElse("not exist");
    }
}