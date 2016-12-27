package com.ftc.fia.repository;

import com.ftc.fia.domain.TestMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITestRepository extends JpaRepository<TestMe, Integer> {

}
