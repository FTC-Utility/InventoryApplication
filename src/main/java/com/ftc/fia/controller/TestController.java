package com.ftc.fia.controller;

import com.ftc.fia.business.IPersistentLoginBusiness;
import com.ftc.fia.domain.PersistentLogin;
import com.ftc.fia.domain.TestMe;
import com.ftc.fia.domain.User;
import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.service.IPersistentLoginService;
import com.ftc.fia.service.ITestMeService;
import com.ftc.fia.service.IUserService;
import com.ftc.fia.service.IWebsiteRoleService;
import com.ftc.fia.service.impl.PersistentLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 import com.ftc.fia.domain.*;
 import com.ftc.fia.repository.*;
 import com.ftc.fia.service.ITestMeService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.transaction.annotation.Transactional;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
 import javax.persistence.ManyToOne;
 import java.time.LocalDate;


@Controller
 @Transactional // This will open the hibernate session for lazy fetching.
public class TestController {

  @Autowired
  ITestMeService iTestMeService;

  @Autowired
  IPersistentLoginService iPersistentLoginService;

  @Autowired
  IUserService iUserService;

  @Autowired
  IWebsiteRoleService iWebsiteRoleService;

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test(Model model) {

    // Test services for Spring Security.
    PersistentLogin p1 = iPersistentLoginService.getPersistentLoginBySeries("gfd");
    System.out.println("PersistentLogin series: " + p1.getSeries());
    PersistentLogin p2 = iPersistentLoginService.getPersistentLoginByUserId(1);
    System.out.println("PersistentLogin series: " + p2.getSeries());

    User u = iUserService.findBySSO("hfg");
    System.out.println("\nUser email: " + u.getEmail());
    List<User> l = iUserService.findAllUsers();
    for(User u1:l){
      System.out.println("User email: " + u1.getEmail());
    }
    boolean b = iUserService.isUserSSOUnique(1, "hfg");
    System.out.println("\nUser with id: " + 1 + " and email: hfg unique:" + b);

    WebsiteRole w1 = iWebsiteRoleService.findById(7);
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

    return "test";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public String signup() {

    //model.addAttribute("signup", "");
    return "newUserSignUp";
  }

  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public String testPost(TestMe testMe) {
    iTestMeService.createTest(testMe);
    return "redirect:/";
  }

}
