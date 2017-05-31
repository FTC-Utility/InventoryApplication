package com.ftc.fia.service.impl;


import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.service.IEquipmentTypeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Eyuel Tadesse on 1/3/2017.*/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.ftc.fia.config.AppConfig.class)
@WebAppConfiguration
public class EquipmentTypeServiceImplTest {

    @Autowired
    private IEquipmentTypeService equipmentTypeService;
/*
    @Test
    public void getEquipmentTypeById() throws Exception {
        EquipmentType equipmentTypeById = equipmentTypeService.getEquipmentTypeById(8);
        Assert.assertNotNull(equipmentTypeById);
    }

    @Test
    public void findAll() throws Exception {
        List<EquipmentType> allEquipmentType = equipmentTypeService.findAll();
        Assert.assertNotNull(allEquipmentType);
    }

    @Test
    public void createEquipmentType() throws Exception {
        EquipmentType equipmentType = new EquipmentType("MousexxxTessts");
        EquipmentType equipmentTypeResult = equipmentTypeService.createEquipmentType(equipmentType);
        assertEquals(equipmentType, equipmentTypeResult);
    }

    @Test
    public void updateEquipmentType() throws Exception {
        int id = 0;
        EquipmentType result = equipmentTypeService.getEquipmentByDescription("Monitoooooor");
        EquipmentType expected = new EquipmentType("Monitor");
        if(result != null) {
            result.setName("Monitor");
        } else {
            EquipmentType newEquipmentType = new EquipmentType("Monitoooooor");
            result = equipmentTypeService.createEquipmentType(expected);
        }
        equipmentTypeService.updateEquipmentType(result);
        assertEquals(expected, result);
    }

    @Test
    public void deleteEquipmentType() throws Exception {
        EquipmentType equipmentTypeToDelete = new EquipmentType(8,"MouseTest");
        equipmentTypeService.deleteEquipmentType(equipmentTypeToDelete);

        try {
            EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeById(8);
            Assert.assertNull(equipmentType);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
*/
}
