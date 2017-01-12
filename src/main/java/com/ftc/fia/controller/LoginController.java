package com.ftc.fia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

  @Autowired
  AuthenticationTrustResolver authenticationTrustResolver;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String login(Model model) {
    // Modified by Barrero on 1/9/201 to work with Spring Security.
    if (isCurrentAuthenticationAnonymous()) {
      return "login";
    } else {
      return "redirect:/test";
    }
  }

  /**
   * This method returns true if users is already authenticated [logged-in], else false.
   */
  private boolean isCurrentAuthenticationAnonymous() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if(authentication == null){
      return true;
    }
    return authenticationTrustResolver.isAnonymous(authentication);
  }

  @RequestMapping(value = "/signIn", method = RequestMethod.POST)
  public String signIn(@RequestParam("email") String email, @RequestParam("pwd") String password,
                       @RequestParam(value = "rememberMe", defaultValue = "off") String rememberMe) {
    // This is just stub code for now. This will have to change in a future sub-task that will do the real
    // processing.
    System.out.println("email = [" + email + "], password = [" + password + "], rememberMe = [" + rememberMe + "]");
    return "test";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String newUserRegisterHere(Model model) {
    // model.addAttribute();
    System.out.println("Method Executed: newUserRegisterHere");
    return "newUserSignUp";
  }

  @RequestMapping(value = "/lostPassword", method = RequestMethod.GET)
  public String lostPassword(Model model) {

    System.out.println("Method Executed: lostPassword");
    return "lostPasswordReset";
  }
}
