package com.ftc.fia.repository;

import com.ftc.fia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ABarrero on 1/3/2017.
 */

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

  //@Query("FROM User u WHERE u.email = :email")
  User findByEmail(@Param("email") String email);
}