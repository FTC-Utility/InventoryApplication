 package com.ftc.fia.controller;

 import com.ftc.fia.domain.*;
 import com.ftc.fia.repository.AssignedRepository;
 import com.ftc.fia.repository.AuditRepository;
 import com.ftc.fia.repository.LicenseTypeRepository;
 import com.ftc.fia.repository.SoftwareLicenceRepository;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
     public String test(Model model, @RequestParam("data") String data) {

         model.addAttribute("tests", iTestMeService.getTests());
         model.addAttribute("data", data);
         return "test";
     }

     @RequestMapping(value = "/signup", method = RequestMethod.GET)
     public String signup() {

         //model.addAttribute("signup", "");
         return "newUserSignUp";
     }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPost(RedirectAttributes redirectAttributes, TestMe testMe)
    {
        iTestMeService.createTest(testMe);

        LicenseType licenseType = new LicenseType("deshjj");
        LicenseType licenseType1 = new LicenseType("des5464");

        Audit audit = new Audit();
        Audit audit1 = new Audit();

        SoftwareLicense softwareLicense = new SoftwareLicense("dsfsd5fd",45, LocalDate.now());
        SoftwareLicense softwareLicense1 = new SoftwareLicense("gfdyhthdh",455, LocalDate.now());

        Assigned assigned = new Assigned(LocalDate.now(), LocalDate.now());
        Assigned assigned1 = new Assigned(LocalDate.now(), LocalDate.now());

        Software software = new Software("Office 2017");
        Software software1 = new Software("IntelliJ 2017");

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

//        licenceTypeRepository.save(licenseType);

//        softwareLicenceRepository.save(softwareLicense);

        redirectAttributes.addAttribute("data", softwareLicenceRepository.findOne(214).getAssigneds().size()+"--"+ softwareLicenceRepository.findOne(214).getLicenseType().getDescription());
        return "redirect:/";
    }

}
