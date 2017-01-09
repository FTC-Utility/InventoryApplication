 package com.ftc.fia.controller;

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

 import javax.persistence.ManyToOne;
 import java.time.LocalDate;


 @Controller
 @Transactional // This will open the hibernate session for lazy fetching.
public class TestController {

     @Autowired
     ITestMeService iTestMeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
     public String test(Model model) {

         return "test";
     }

     @RequestMapping(value = "/signup", method = RequestMethod.GET)
     public String signup() {

         return "newUserSignUp";
     }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPost(TestMe testMe)
    {
        iTestMeService.createTest(testMe);
        return "redirect:/";
    }

}
