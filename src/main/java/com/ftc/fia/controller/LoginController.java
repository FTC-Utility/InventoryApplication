package com.ftc.fia.controller;

import com.ftc.fia.domain.PersistentLogin;
import com.ftc.fia.domain.User;
import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.service.IEquipmentTypeService;
import com.ftc.fia.service.IPersistentLoginService;
import com.ftc.fia.service.IUserService;
import com.ftc.fia.service.IWebsiteRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by FPerez on 12/30/2016.
 */
@Controller
public class LoginController {

  @Autowired
  AuthenticationTrustResolver authenticationTrustResolver;

  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  IPersistentLoginService iPersistentLoginService;

  @Autowired
  IUserService iUserService;

  @Autowired
  IWebsiteRoleService iWebsiteRoleService;

  @Autowired
  IEquipmentTypeService iEquipmentTypeService;

  @Autowired
  PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model) {
    // Modified by Barrero on 1/9/2017 to work with Spring Security.
    if (isCurrentAuthenticationAnonymous()) {
//      testJPA();
      return "login";
    } else {
      return "redirect:/test";
    }
  }



  @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
  public String testList(ModelMap model) {

    List<User> users = iUserService.findAllUsers();
    model.addAttribute("users", users);
    model.addAttribute("loggedinuser", getPrincipal());
    return "test";
  }

  private String getPrincipal(){
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      userName = ((UserDetails)principal).getUsername();
    } else {
      userName = principal.toString();
    }
    return userName + "Role: "+ ((UserDetails)principal).getAuthorities();
  }


  private void testJPA() {
    PersistentLogin p1 = iPersistentLoginService.getPersistentLoginBySeries("gfd");
    System.out.println("PersistentLogin series: " + p1.getSeries());
    PersistentLogin p2 = iPersistentLoginService.getPersistentLoginByUserId(1);
    System.out.println("PersistentLogin series: " + p2.getSeries());

    User u = iUserService.findBySSO("handro1104@gmail.com");
    System.out.println("\nUser email: " + u.getEmail());
    List<User> l = iUserService.findAllUsers();
    for(User u1:l){
      System.out.println("User email: " + u1.getEmail());
    }
    boolean b = iUserService.isUserSSOUnique(1, "hfg");
    System.out.println("\nUser with id: " + 1 + " and email: hfg unique:" + b);

    WebsiteRole w1 = iWebsiteRoleService.findById(1);
    System.out.println("\nWebsiteRole1 description: " + w1.getDescription());
    List<WebsiteRole> l2 = iWebsiteRoleService.findAll();
    for(WebsiteRole w3:l2){
      System.out.println("WebsiteRole2 description: " + w3.getDescription());
    }
    WebsiteRole w2 = iWebsiteRoleService.findByType("ADMIN");
    if(w2 != null){
      System.out.println("WebsiteRole3 description: " + w2.getDescription());}
    else{
      System.out.println("WebsiteRole3 is null for description ADMIN");
    }
  }


  @RequestMapping(value="/logout", method = RequestMethod.GET)
  public String logoutPage (HttpServletRequest request, HttpServletResponse response){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
      //new SecurityContextLogoutHandler().logout(request, response, auth);
      persistentTokenBasedRememberMeServices.logout(request, response, auth);
      SecurityContextHolder.getContext().setAuthentication(null);
    }
    return "redirect:/login?logout";
  }



  /**
   * This method returns true if users is already authenticated [logged-in], else false.
   */
  private boolean isCurrentAuthenticationAnonymous() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if(authentication == null){
//      return true;
//    }
    return authenticationTrustResolver.isAnonymous(authentication);
  }

//  @RequestMapping(value = "/signIn", method = RequestMethod.GET)
//  public String signIn(@RequestParam("email") String email, @RequestParam("pwd") String password,
//                       @RequestParam(value = "rememberMe", defaultValue = "off") String rememberMe) {
//    // This is just stub code for now. This will have to change in a future sub-task that will do the real
//    // processing.
//
//
//    System.out.println("email = [" + email + "], password = [" + password + "], rememberMe = [" + rememberMe + "]");
//    return "test";
//  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String newUserRegisterHere(Model model) {
    // model.addAttribute();
    System.out.println("Method Executed: newUserRegisterHere");
    return "newUserSignUp";
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public String list(Model model) {
    // model.addAttribute();
    model.addAttribute("test",iEquipmentTypeService.findAll());

    return "list";
  }

  @RequestMapping(value = "/lostPassword", method = RequestMethod.GET)
  public String lostPassword(Model model) {

    System.out.println("Method Executed: lostPassword");
    return "lostPasswordReset";
  }
}
