package com.ftc.fia.repository;

import com.ftc.fia.domain.Software;
import com.ftc.fia.domain.TestMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SoftwareRepository extends JpaRepository<Software, Integer> {

}
