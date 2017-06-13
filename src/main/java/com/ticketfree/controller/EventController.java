package com.ticketfree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.ticketfree.entity.bean.Event;
import com.ticketfree.entity.bean.User;
import com.ticketfree.service.dao.BaseDao;
import com.ticketfree.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("event")
public class EventController {

    @Autowired private BaseDao baseDao;

    @RequestMapping("load")
    public ModelAndView load(@RequestParam("eventId") Integer eventId,
            ModelAndView mav) {

        mav.addObject("eventId", eventId);
        mav.setViewName("eventMain");
        return mav;
    }


    @RequestMapping(value = "load/{id}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String loadEvent(@PathVariable("id") Integer eventId) throws Exception {
        Event event = baseDao.findById(Event.class, eventId);
        return JacksonUtil.toJson(event);
    }

    @RequestMapping("create")
    public String create() {

        return "eventCreate";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(String json) {
        try {
            User byId = baseDao.findById(User.class, 1);

            Event event = JacksonUtil.toObj(json, Event.class);
            event.setMainUser(byId);

            return baseDao.save(event, byId).toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("loadForUser")
    public ModelAndView loadForUser(ModelAndView mav) {

        mav.setViewName("eventPage");
        return mav;
    }

    @RequestMapping("loadForUserData")
    @ResponseBody
    public String loadForUserData() {
        User byId = baseDao.findById(User.class, 1);
        List<Event> events = baseDao.loadEventByUser(byId.getEntityId())
                .stream()
                .sorted(Comparator.comparing(Event::getDateStart).reversed())
                .collect(Collectors.toList());

        JsonArray result = new JsonArray();
        events.forEach(t -> result.add(t.toJson()));
        return result.toString();
    }


    @RequestMapping("update")
    @ResponseBody
    public String update() {
        User byId = baseDao.findById(User.class, 1);

        Event event = new Event();

        if (!event.getMainUser().equals(byId)) {
            throw new IllegalArgumentException("This user not modify event.");
        }
        return "";
    }
}
