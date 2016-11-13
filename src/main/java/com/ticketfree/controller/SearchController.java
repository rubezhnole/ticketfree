package com.ticketfree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ticketfree.entity.bean.Event;
import com.ticketfree.service.dao.BaseDao;
import com.ticketfree.service.jdbc.JDBCTemplate;
import com.ticketfree.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    JDBCTemplate jdbcTemplate;
    @Autowired BaseDao baseDao;

    @RequestMapping(value = "search", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String search(@RequestParam("searchText") String searchText) {

        if (StringUtils.isEmpty(searchText)) {
            return "";
        }

        List<Integer> eventByText = jdbcTemplate.findEventByText(searchText);
        List<Event> events = new ArrayList<>();

        for (Integer integer : eventByText) {
            events.add(baseDao.findById(Event.class, integer));
        }

        String resp = null;
        try {
            resp = JacksonUtil.toJson(events);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resp;
    }
}
