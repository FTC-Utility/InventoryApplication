package com.ftc.fia.repository;

import com.ftc.fia.domain.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Eyuel Tadesse on 1/3/2017.
 */
@Repository
public interface IEquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {

    @Query("FROM EquipmentType e WHERE e.id = :equipment_type_id")
    EquipmentType getEquipmentTypeById(@Param("equipment_type_id") int equipment_type_id);

    @Query("FROM EquipmentType e WHERE e.description = :equipTypeDesc")
    EquipmentType getEquipmentTypeByDesc(@Param("equipTypeDesc") String equipTypeDesc);

}
