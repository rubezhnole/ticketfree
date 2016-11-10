package com.ticketfree.controller;

import com.google.gson.JsonObject;
import com.ticketfree.entity.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping({"", "/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {

        User user = new User();

        if (true) {
//            request.getSession().setAttribute(user.getUsername(), user);
            return "mainPage";
        } else {
            return "index";
        }
    }

    @RequestMapping("register")
    public String register() {
        return "";
    }

    @RequestMapping("logout")
    public String logout() {
        return "index";
    }


/*    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }*/
}
