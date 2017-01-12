package com.ftc.fia.repository;

import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Eyuel Tadesse on 1/10/2017.
 */
@Repository
public interface IHardwareRepository extends JpaRepository<Hardware, Integer> {
    @Query("FROM Hardware h WHERE h.id = :hardwareId")
    Hardware getHardwareById(@Param("hardwareId") int hardwareId);

    @Query("FROM Hardware h WHERE h.location.id = :locationId")
    Hardware findHardwareByLocation(@Param("locationId") int locationId);
}
