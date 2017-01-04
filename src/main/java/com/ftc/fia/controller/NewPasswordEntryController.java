package com.ftc.fia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by FPerez on 1/4/2017.
 */
@Controller
public class NewPasswordEntryController {

    @RequestMapping(value = "/newPasswordEntry", method = RequestMethod.GET)
    public String newPasswordEntry(Model model) {
        return "newPasswordEntry";
    }

    @RequestMapping(value = "/setPassword", method = RequestMethod.POST)
    public String setPassword(@RequestParam("pin") String pin, @RequestParam("pwd") String password,
                              @RequestParam("confirmPwd") String confirmPassword) {
        // This is just stub code for now. This will have to change in a future sub-task that will do the real
        // processing.
        System.out.println("PIN = [" + pin + "], password = [" + password + "], confirmPasswsord = [" + confirmPassword + "]");
        return "newPasswordEntry";
    }
}
