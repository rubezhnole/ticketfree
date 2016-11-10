package com.ticketfree.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

    @RequestMapping(value = "search", produces = "application/json")
    @ResponseBody
    public String search(@RequestParam("searchText") String searchText) {

        if (StringUtils.isEmpty(searchText)) {
            return "";
        }

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < 10; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", i);
            jsonObject.addProperty("title", "title "  + searchText + " " +  i);
            jsonArray.add(jsonObject);
        }

        return jsonArray.toString();
    }
}
