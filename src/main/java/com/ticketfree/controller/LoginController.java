package com.ticketfree.controller;

import com.google.gson.JsonObject;
import com.ticketfree.entity.bean.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

/*    @RequestMapping({"", "/", "index"})
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
    }*/


    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String homePage(ModelAndView model) {
//        model.addAttribute("greeting", "Hi, Welcome to mysite. ");
//        return "welcome";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            model.setViewName("forward:/mainPage");
        }
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "welcome";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping("mainPage")
    public String mainPage() {
        return "mainPage";
    }

    @RequestMapping("404")
    public String NotFoundPage() {
        return "404";
    }
}
