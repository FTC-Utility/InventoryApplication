package com.ftc.fia.repository;

import com.ftc.fia.domain.EquipmentType;
import com.ftc.fia.domain.PersistentLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ABarrero on 1/4/2017.
 */

@Repository
public interface IPersistentLoginRepository extends JpaRepository<PersistentLogin, String> {

  @Query("FROM PersistentLogin p WHERE p.series = :series")
  PersistentLogin getPersistentLoginBySeries(@Param("series") String series);

  @Query("FROM PersistentLogin p WHERE p.user.id = :user_id")
  PersistentLogin getPersistentLoginByUserId(@Param("user_id") int user_id);
}
