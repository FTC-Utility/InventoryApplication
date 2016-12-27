 package com.ftc.fia.controller;

 import com.ftc.fia.domain.TestMe;
 import com.ftc.fia.service.ITestMeService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;



 @Controller
public class TestController {

    @Autowired
    ITestMeService iTestMeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {

        model.addAttribute("tests", iTestMeService.getTests());
        return "test";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPost(TestMe testMe) {
        iTestMeService.createTest(testMe);
        return "redirect:/";
    }

}
