package com.ftc.fia.business.impl;

import com.ftc.fia.business.IUserBusiness;
import com.ftc.fia.domain.User;
import com.ftc.fia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ABarrero on 1/3/2017.
 */
@Component
public class UserBusinessImpl implements IUserBusiness {
  @Autowired
  IUserRepository iUserRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public User findBySSO(String sso) {
    return iUserRepository.findByEmail(sso);
  }

  @Override
  public void saveUser(User user) {
    iUserRepository.save(user);
  }

  @Override
  public void updateUser(User user) {
    iUserRepository.save(user);
  }

  @Override
  public void deleteUserBySSO(String sso) {
    User user = findBySSO(sso);
    iUserRepository.delete(user);
  }

  @Override
  public List<User> findAllUsers() {
    return iUserRepository.findAll();
  }

  @Override
  public boolean isUserSSOUnique(Integer id, String sso) {
    User user = findBySSO(sso);
    return (user == null || ((id != null) && (user.getId() == id)));
  }
}
