package com.ftc.fia.service.impl;

import com.ftc.fia.business.IEquipmentTypeBuisness;
import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.service.IEquipmentTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    static final Logger logger = LoggerFactory.getLogger(EquipmentTypeServiceImpl.class);

    @Autowired
    IEquipmentTypeBuisness equipmentTypeBuisness;


    @Override
    public EquipmentType getEquipmentTypeById(int id) {
        return equipmentTypeBuisness.getEquipmentTypeById(id);
    }

    @Override
    public EquipmentType getEquipmentByDescription(String description) {
        logger.info("Getting EquipmentType By Description : {}",description);
        return equipmentTypeBuisness.getEquipmentTypeByDescription(description);
    }

    public List<EquipmentType> findAll() {
        logger.info("Getting all EquipmentType","findallEquipmentType");
        return equipmentTypeBuisness.findAll();
    }

    @Override
    public EquipmentType createEquipmentType(EquipmentType equipmentType) {
        logger.info("Creating EquipmentType {}",equipmentType);
        return equipmentTypeBuisness.createEquipmentType(equipmentType);
    }

    @Override
    public void updateEquipmentType(EquipmentType equipmentType) {
        logger.info("Updating EquipmentType {}",equipmentType);
        createEquipmentType(equipmentType);
    }

    @Override
    public void deleteEquipmentType(EquipmentType equipmentType) {
        logger.info("Deleting EquipmentType",equipmentType);
        equipmentTypeBuisness.deleteEquipmentType(equipmentType);
    }
}
