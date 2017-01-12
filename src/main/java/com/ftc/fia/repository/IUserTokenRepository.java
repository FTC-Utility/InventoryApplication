package com.ftc.fia.repository;

import com.ftc.fia.domain.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by FPerez on 1/6/2017.
 */
@Repository
public interface IUserTokenRepository extends JpaRepository<UserToken, Integer>   {

    List<UserToken> findByValue(String value);
}
