package com.ftc.fia.service;

import com.ftc.fia.domain.EquipmentType;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */
public interface IEquipmentTypeService {
    EquipmentType getEquipmentTypeById(int id);
    EquipmentType getEquipmentByDescription(String description);
    List<EquipmentType> findAll();
    EquipmentType createEquipmentType(EquipmentType equipmentType);
    void updateEquipmentType(EquipmentType equipmentType);
    void deleteEquipmentType(EquipmentType equipmentType);
}
