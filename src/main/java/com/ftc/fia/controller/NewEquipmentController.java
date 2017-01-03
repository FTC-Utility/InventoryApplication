package com.ftc.fia.controller;

import com.ftc.fia.service.IEquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */
@Controller
public class NewEquipmentController {

    @Autowired
    IEquipmentTypeService equipmentTypeService;

}
