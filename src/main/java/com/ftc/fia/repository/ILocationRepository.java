package com.ftc.fia.repository;

import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {
    @Query("FROM Location l WHERE l.id = :locationId")
    Location findLocationById(@Param("locationId") int locationId);
}
