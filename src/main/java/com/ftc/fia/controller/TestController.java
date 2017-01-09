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

 import java.time.LocalDate;


 @Controller
 @Transactional // This will open the hibernate session for lazy fetching.
public class TestController {

     @Autowired
     ITestMeService iTestMeService;

     @Autowired
     AuditRepository auditRepository;

     @Autowired
     LicenseTypeRepository licenceTypeRepository;

     @Autowired
     SoftwareLicenceRepository softwareLicenceRepository;

     @Autowired
     AssignedRepository assignedRepository;

     @Autowired
     IssueRepository issueRepository;

     @Autowired
     SoftwareRepository softwareRepository;
     @Autowired
     UserRepository userRepository;

     @Autowired
     HardwareRepository hardwareRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
     public String test(Model model) {

         model.addAttribute("tests", iTestMeService.getTests());

        LicenseType licenseType = new LicenseType("office License");
        LicenseType licenseType1 = new LicenseType("IntelliJ License");

        Audit audit = new Audit();
        Audit audit1 = new Audit();

        User user = new User("zee", "bel", "@gmail");
        User user1 = new User("Vam", "Kri", "@yahoo");

        SoftwareLicense softwareLicense = new SoftwareLicense("dsfsd5fd",45, LocalDate.now());
        SoftwareLicense softwareLicense1 = new SoftwareLicense("gfdyhthdh",455, LocalDate.now());

        Assigned assigned = new Assigned(LocalDate.now(), LocalDate.now());
        Assigned assigned1 = new Assigned(LocalDate.now(), LocalDate.now());

        Software software = new Software("Office 2017");
        Software software1 = new Software("IntelliJ 2017");

        Hardware hardware = new Hardware("TV", "des","fsdf4513","A10", LocalDate.now());
        Hardware hardware1 = new Hardware("laptop", "des","Addd456441f1f","A10", LocalDate.now());

        Issue issue = new Issue();
        Issue issue1 = new Issue();

        audit.setLicenseType(licenseType);
        audit1.setLicenseType(licenseType);
        licenseType.getAudits().add(audit);
        licenseType.getAudits().add(audit1);

        licenseType.getSoftwareLicences().add(softwareLicense);
        licenseType.getSoftwareLicences().add(softwareLicense1);
        softwareLicense.setLicenseType(licenseType);
        softwareLicense1.setLicenseType(licenseType);

        softwareLicense.getAssigneds().add(assigned);
        softwareLicense.getAssigneds().add(assigned1);
        assigned.setSoftwareLicense(softwareLicense);
        assigned1.setSoftwareLicense(softwareLicense);

        issue.setSoftwareLicense(softwareLicense);
        issue1.setSoftwareLicense(softwareLicense);
        softwareLicense.getIssues().add(issue);
        softwareLicense.getIssues().add(issue1);

        software.getSoftwareLicenses().add(softwareLicense);
        software.getSoftwareLicenses().add(softwareLicense1);
        softwareLicense.setSoftware(software);
        softwareLicense1.setSoftware(software);

        softwareLicense.getAudits().add(audit);
        softwareLicense.getAudits().add(audit1);
        audit.setSoftwareLicense(softwareLicense);
        audit1.setSoftwareLicense(softwareLicense);

        assigned.getAudits().add(audit);
        assigned.getAudits().add(audit1);
        audit.setAssigned(assigned);
        audit1.setAssigned(assigned);

        user.getAssigneds().add(assigned);
        user.getAssigneds().add(assigned1);
        assigned.setUser(user);
        assigned1.setUser(user);

        user1.getRequestedissues().add(issue);
        user1.getResolvedissues().add(issue1);
        issue.setRequestor(user);
        issue1.setRequestor(user);
        issue.setResolvedBy(user1);
        issue1.setResolvedBy(user1);

        hardware.getAssigneds().add(assigned);
        hardware.getAssigneds().add(assigned1);
        assigned.setHardware(hardware);
        assigned1.setHardware(hardware);

        hardware.getIssues().add(issue);
        hardware.getIssues().add(issue1);
        issue.setHardware(hardware);
        issue1.setHardware(hardware);

        issue.getAudits().add(audit);
        issue.getAudits().add(audit1);
        audit.setIssue(issue);
        audit1.setIssue(issue);

        hardwareRepository.save(hardware);

//        issueRepository.save(issue);
//        issueRepository.save(issue1);

        System.out.println("wwww"+softwareLicense.getIssues().size());
        model.addAttribute("data", softwareLicenceRepository.findOne(softwareLicense.getId()).getIssues());
         return "test";
     }

     @RequestMapping(value = "/signup", method = RequestMethod.GET)
     public String signup() {

         //model.addAttribute("signup", "");
         return "newUserSignUp";
     }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPost(TestMe testMe)
    {
        iTestMeService.createTest(testMe);
        return "redirect:/";
    }

}
