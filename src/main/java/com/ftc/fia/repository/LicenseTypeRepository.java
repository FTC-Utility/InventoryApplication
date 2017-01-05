package com.ftc.fia.repository;

import com.ftc.fia.domain.LicenseType;
import com.ftc.fia.domain.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LicenseTypeRepository extends JpaRepository<LicenseType, Integer> {

}
