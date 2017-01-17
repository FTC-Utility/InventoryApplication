package com.ftc.fia.repository;

import com.ftc.fia.domain.User;
import com.ftc.fia.domain.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ABarrero on 1/8/2017.
 */

@Repository
public interface IUserPasswordRepository extends JpaRepository<UserPassword, Long> {

  @Query("FROM UserPassword u WHERE u.user.id = :user_id")
  UserPassword findByUserId(@Param("user_id") int user_id);

  public List<UserPassword> findByUser(User user);
}
