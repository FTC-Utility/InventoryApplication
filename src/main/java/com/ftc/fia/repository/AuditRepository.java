package com.ftc.fia.repository;

import com.ftc.fia.domain.Audit;
import com.ftc.fia.domain.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

}
