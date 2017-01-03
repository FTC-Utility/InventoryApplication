package com.ftc.fia.business;

import com.ftc.fia.domain.EquipmentType;

import java.util.List;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */
public interface IEquipmentTypeBuisness {
    EquipmentType getEquipmentTypeById(int id);
    List<EquipmentType> findAll();
    EquipmentType createEquipmentType(EquipmentType equipmentType);
    void updateEquipmentType(EquipmentType equipmentType);
    void deleteEquipmentType(EquipmentType equipmentType);
}
