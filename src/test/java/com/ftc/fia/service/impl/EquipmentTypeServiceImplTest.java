package com.ftc.fia.service.impl;

import com.ftc.fia.business.IEquipmentTypeBuisness;
import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.service.IEquipmentTypeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.ExpectedCount;

import static org.junit.Assert.*;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.ftc.fia.config.AppConfig.class)
@ActiveProfiles("local")
@WebAppConfiguration
public class EquipmentTypeServiceImplTest {

    @Autowired
    private IEquipmentTypeService equipmentTypeService;


    @Test
    public void getEquipmentTypeById() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void createEquipmentType() throws Exception {
        EquipmentType equipmentType = new EquipmentType("Monitoooooor");
        EquipmentType equipmentTypeResult = equipmentTypeService.createEquipmentType(equipmentType);
        assertEquals(equipmentType, equipmentTypeResult);
    }

    @Test
    public void updateEquipmentType() throws Exception {
        int id = 0;
        EquipmentType result = equipmentTypeService.getEquipmentByDescription("Monitoooooor");
        EquipmentType expected = new EquipmentType("Monitor");
        if(result != null) {
            result.setDescription("Monitor");
        } else {
            EquipmentType newEquipmentType = new EquipmentType("Monitoooooor");
            result = equipmentTypeService.createEquipmentType(expected);
        }
        equipmentTypeService.updateEquipmentType(result);
        assertEquals(expected, result);
    }

    @Test
    public void deleteEquipmentType() throws Exception {

    }

}