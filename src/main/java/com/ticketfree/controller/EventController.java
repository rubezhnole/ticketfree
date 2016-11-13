package com.ticketfree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.Date;

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
    @ResponseStatus(HttpStatus.OK)
    public String save(String json) {

        try {
            User byId = baseDao.findById(User.class, 1);

            Event event = JacksonUtil.toObj(json, Event.class);
            event.setMainUser(byId);
            event.setDateStart(new Date());
            event.setDateEnd(new Date());

            baseDao.save(event, byId);

            System.out.println(event
            );

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }


}
