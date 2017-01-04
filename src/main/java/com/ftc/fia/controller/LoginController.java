package com.ftc.fia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by FPerez on 12/30/2016.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@RequestParam("email") String email, @RequestParam("pwd") String password,
                         @RequestParam(value = "rememberMe", defaultValue = "off") String rememberMe) {
        // This is just stub code for now. This will have to change in a future sub-task that will do the real
        // processing.
        System.out.println("email = [" + email + "], password = [" + password + "], rememberMe = [" + rememberMe + "]");
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String newUserRegisterHere(Model model) {

        System.out.println("Method Executed: newUserRegisterHere");
        return "newUserSignUp";
    }

    @RequestMapping(value = "/lostPassword", method = RequestMethod.GET)
    public String lostPassword(Model model) {

        System.out.println("Method Executed: lostPassword");
        return "lostPasswordReset";
    }
}
