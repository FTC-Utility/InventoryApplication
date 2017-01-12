package com.ftc.fia.service;

import com.ftc.fia.domain.User;

import java.util.List;

/**
 * Created by ABarrero on 1/3/2017.
 */
public interface IUserService {
  public User findBySSO(String sso);
  public void saveUser(User user);
  public void updateUser(User user);
  public void deleteUserBySSO(String sso);
  public List<User> findAllUsers();
  public boolean isUserSSOUnique(Integer id, String sso);
}
