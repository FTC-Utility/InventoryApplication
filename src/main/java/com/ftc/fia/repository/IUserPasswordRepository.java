package com.ftc.fia.repository;

import com.ftc.fia.domain.User;
import com.ftc.fia.domain.UserPassword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by FPerez on 1/6/2017.
 */
@Repository
public interface IUserPasswordRepository extends JpaRepository<UserPassword, Integer> {

   List<UserPassword> findByUser(User user);
}
