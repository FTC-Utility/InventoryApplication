package com.ftc.fia.controller;

import com.ftc.fia.dto.NewPasswordEntryDto;
import com.ftc.fia.service.ISetPasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by FPerez on 1/4/2017.
 */
@Controller
public class NewPasswordEntryController {

    @Autowired
    ISetPasswordService iSetPasswordService;

    @RequestMapping(value = "/newPasswordEntry", method = RequestMethod.GET)
    public String newPasswordEntry(@RequestParam("token") String token, Model model) {

        System.out.println("token = " + token);
        model.addAttribute("tokenValue", token);
        return "newPasswordEntry";
    }

    @RequestMapping(value = "/setPassword", method = RequestMethod.POST)
    public String setPassword(@RequestParam("pin") String pin, @RequestParam("pwd") String password,
                              @RequestParam("confirmPwd") String confirmPassword, @RequestParam("token") String token,
                              Model model) {

        System.out.println("PIN = [" + pin + "], password = [" + password + "], confirmPassword = [" + confirmPassword + "]");
        System.out.println("token = " + token);

        NewPasswordEntryDto dataDto = new NewPasswordEntryDto();
        dataDto.setPin(pin);
        dataDto.setPwd(password);
        dataDto.setConfirmPwd(confirmPassword);
        dataDto.setToken(token);

        Map returnedMap = null;
        try {
            returnedMap = iSetPasswordService.setPassword(dataDto);
        } catch (Exception ex) {
            String errorMessage = "Exception occurred: " + ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "errorPage";
        }

        if (returnedMap.containsKey("errorMessage")) {
            String errorMessage = (String) returnedMap.get("errorMessage");
            model.addAttribute("errorMessage", errorMessage);
            return "errorPage";
        }

        System.out.println("NewPasswordEntryController.setPassword: Forward to \"login\"");
        return "redirect:/login";
    }
}
