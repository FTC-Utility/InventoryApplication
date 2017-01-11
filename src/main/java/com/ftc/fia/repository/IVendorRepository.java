package com.ftc.fia.repository;

import com.ftc.fia.domain.Hardware;
import com.ftc.fia.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Eyuel Tadesse on 1/11/2017.
 */
@Repository
public interface IVendorRepository extends JpaRepository<Vendor,Long> {
    @Query("FROM Vendor v WHERE v.id = :vendorId")
    Vendor findVendorById(@Param("vendorId") int vendorId);
}
