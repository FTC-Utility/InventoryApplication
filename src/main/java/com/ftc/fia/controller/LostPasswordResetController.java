package com.ftc.fia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by FPerez on 1/3/2017.
 */
@Controller
public class LostPasswordResetController {

    @RequestMapping(value = "/sendNow", method = RequestMethod.POST)
    public String sendNow(@RequestParam("email") String email) {

        // This is just stub code for now. This will have to change in a future sub-task that will do the real
        // processing.
        System.out.println("email = [" + email + "]");
        return "lostPasswordReset";
    }
}
