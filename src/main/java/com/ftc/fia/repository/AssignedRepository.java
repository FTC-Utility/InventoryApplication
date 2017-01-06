package com.ftc.fia.repository;

import com.ftc.fia.domain.Assigned;
import com.ftc.fia.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssignedRepository extends JpaRepository<Assigned, Integer> {

}
