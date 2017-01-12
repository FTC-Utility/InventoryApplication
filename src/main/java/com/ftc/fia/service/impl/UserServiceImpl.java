package com.ftc.fia.service.impl;

import com.ftc.fia.business.impl.UserBusinessImpl;
import com.ftc.fia.domain.User;
import com.ftc.fia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ABarrero on 1/3/2017.
 */
@Transactional
@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  UserBusinessImpl userBusinessImpl;

  @Override
  public User findBySSO(String sso) {
    return userBusinessImpl.findBySSO(sso);
  }

  @Override
  public void saveUser(User user) {
    userBusinessImpl.saveUser(user);
  }

  @Override
  public void updateUser(User user) {
    userBusinessImpl.updateUser(user);
  }

  @Override
  public void deleteUserBySSO(String sso) {
    userBusinessImpl.deleteUserBySSO(sso);
  }

  @Override
  public List<User> findAllUsers() {
    return userBusinessImpl.findAllUsers();
  }

  @Override
  public boolean isUserSSOUnique(Integer id, String sso) {
    return userBusinessImpl.isUserSSOUnique(id, sso);
  }
}
