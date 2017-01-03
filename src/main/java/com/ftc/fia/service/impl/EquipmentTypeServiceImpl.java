package com.ftc.fia.service.impl;

import com.ftc.fia.business.IEquipmentTypeBuisness;
import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.service.IEquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */
@Service
@Transactional
public class EquipmentTypeServiceImpl implements IEquipmentTypeService {

    @Autowired
    IEquipmentTypeBuisness equipmentTypeBuisness;


    @Override
    public EquipmentType getEquipmentTypeById(int id) {
        return equipmentTypeBuisness.getEquipmentTypeById(id);
    }

    @Override
    public EquipmentType getEquipmentByDescription(String description) {
        return equipmentTypeBuisness.getEquipmentTypeByDescription(description);
    }

    public List<EquipmentType> findAll() {
        return equipmentTypeBuisness.findAll();
    }

    @Override
    public EquipmentType createEquipmentType(EquipmentType equipmentType) {
        return equipmentTypeBuisness.createEquipmentType(equipmentType);
    }

    @Override
    public void updateEquipmentType(EquipmentType equipmentType) {
        createEquipmentType(equipmentType);
    }

    @Override
    public void deleteEquipmentType(EquipmentType equipmentType) {
        equipmentTypeBuisness.deleteEquipmentType(equipmentType);
    }
}
