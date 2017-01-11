package com.ftc.fia.business.impl;

import com.ftc.fia.business.IEquipmentTypeBusiness;
import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.repository.IEquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */

@Component
public class EquipmentTypeBusinessImpl implements IEquipmentTypeBusiness {

    @Autowired
    IEquipmentTypeRepository equipmentTypeRepository;

    @Override
    public EquipmentType getEquipmentTypeById(int id) {
        return equipmentTypeRepository.getEquipmentTypeById(id);
    }

    @Override
    public EquipmentType getEquipmentTypeByDescription(String description) {
        return equipmentTypeRepository.getEquipmentTypeByDesc(description);
    }

    @Override
    public List<EquipmentType> findAll() {

        return equipmentTypeRepository.findAll();
    }

    @Override
    public EquipmentType createEquipmentType(EquipmentType equipmentType) {

        return equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public void updateEquipmentType(EquipmentType equipmentType) {
        createEquipmentType(equipmentType);
    }

    @Override
    public void deleteEquipmentType(EquipmentType equipmentType) {
        equipmentTypeRepository.delete(equipmentType);
    }
}
