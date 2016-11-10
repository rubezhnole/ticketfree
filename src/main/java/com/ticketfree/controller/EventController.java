package com.ticketfree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ticketfree.entity.bean.Event;
import com.ticketfree.util.JacksonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("event")
public class EventController {

    @RequestMapping("load")
    public ModelAndView load(@RequestParam("eventId") Integer eventId,
            ModelAndView mav) {

        mav.addObject("eventId", eventId);
        mav.setViewName("eventMain");
        return mav;
    }


    @RequestMapping(value = "load/{id}", produces = "application/json")
    @ResponseBody
    public String loadEvent(@PathVariable("id") Integer eventId) throws Exception {

        Event event = new Event();
        event.setEntityId(1);
        event.setTitle("first event");
        event.setDescription("super event");
        event.setVenue("my home");
        event.setDateStart(new Date());
        event.setDateEnd(new Date(new Date().getTime() + 100000));

       return JacksonUtil.toJson(event);
    }

    @RequestMapping("create")
    public String create() {

        return "eventCreate";
    }

    @RequestMapping("save")
    public String save(String json) {


        return "";
    }


}
