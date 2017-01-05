package com.ftc.fia.repository;

import com.ftc.fia.domain.SoftwareLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SoftwareLicenceRepository extends JpaRepository<SoftwareLicense, Integer> {

}
