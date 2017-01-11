package com.ftc.fia.controller;

import java.util.ArrayList;
import java.util.List;

import com.ftc.fia.dto.UserInventoryEquipmentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by FPerez on 1/10/2017.
 */
@Controller
public class UserInventoryHomePageController {

    @RequestMapping(value = "/userInventory", method = RequestMethod.GET)
    public String userInventoryHomePage(@RequestParam("userEmail") String userEmail, Model model) {

        if (userEmail.isEmpty()) {
            String errorMessage = "The \"userEmail\" parameter in the URL has no value!";
            model.addAttribute("errorMessage", errorMessage);
            return "errorPage";
        }

        List<UserInventoryEquipmentDto> userEquipmentList = getUserEquipmentList(userEmail);
        model.addAttribute("userEquipmentList", userEquipmentList);

        return "userInventory";
    }

    private List<UserInventoryEquipmentDto> getUserEquipmentList(String userEmail) {
        List<UserInventoryEquipmentDto> userEquipmentList = new ArrayList<UserInventoryEquipmentDto>();

        // Dummy code for now. No database lookup yet.
        if (userEmail.equals("hasEquipment@gmail.com")) {
            UserInventoryEquipmentDto equipment = new UserInventoryEquipmentDto();
            equipment.setAssignedTo("Joseph Kobrosky");
            equipment.setCondition("New");
            equipment.setDefective("false");
            equipment.setDescription("24 \" Monitor");
            equipment.setLocation("Melbourne, FL");
            equipment.setSerialNumber("123321");
            equipment.setVendor("Asus");
            userEquipmentList.add(equipment);

            equipment = new UserInventoryEquipmentDto();
            equipment.setAssignedTo("Joseph Kobrosky");
            equipment.setCondition("Used");
            equipment.setDefective("true");
            equipment.setDescription("30 \" Monitor");
            equipment.setLocation("Melbourne, FL");
            equipment.setSerialNumber("123555");
            equipment.setVendor("Toshiba");
            userEquipmentList.add(equipment);

            equipment = new UserInventoryEquipmentDto();
            equipment.setAssignedTo("Joseph Kobrosky");
            equipment.setCondition("Used");
            equipment.setDefective("false");
            equipment.setDescription("Docking Station");
            equipment.setLocation("Melbourne, FL");
            equipment.setSerialNumber("666555");
            equipment.setVendor("Dell");
            userEquipmentList.add(equipment);

            equipment = new UserInventoryEquipmentDto();
            equipment.setAssignedTo("Joseph Kobrosky");
            equipment.setCondition("New");
            equipment.setDefective("false");
            equipment.setDescription("Laptop");
            equipment.setLocation("Melbourne, FL");
            equipment.setSerialNumber("9876543");
            equipment.setVendor("Asus");
            userEquipmentList.add(equipment);
        }

        return userEquipmentList;
    }
}
