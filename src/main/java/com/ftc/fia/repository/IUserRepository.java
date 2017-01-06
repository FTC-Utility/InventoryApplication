package com.ftc.fia.repository;

import com.ftc.fia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by FPerez on 1/6/2017.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
