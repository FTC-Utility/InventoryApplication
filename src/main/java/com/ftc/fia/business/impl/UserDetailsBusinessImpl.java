package com.ftc.fia.business.impl;

import com.ftc.fia.business.IUserDetailsBusiness;
import com.ftc.fia.domain.User;
import com.ftc.fia.domain.UserPassword;
import com.ftc.fia.domain.UserRole;
import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.repository.IUserPasswordRepository;
import com.ftc.fia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABarrero on 1/7/2017.
 */
@Component
public class UserDetailsBusinessImpl implements IUserDetailsBusiness {
  @Autowired
  IUserRepository iUserRepository;

  @Autowired
  IUserPasswordRepository iUserPasswordRepository;

  @Override
  public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
    User user = iUserRepository.findBySSO(ssoId);
    System.out.println("UserDetailsBusinessImpl loadUserByUsername");
    if(user==null){
      throw new UsernameNotFoundException("Username not found");
    }
    int userId = user.getId();
    UserPassword userPassword = iUserPasswordRepository.findByUserId(userId);
    String password = userPassword.getPasswordHash();
    return new org.springframework.security.core.userdetails.User(user.getEmail(), password,
        true, true, true, true, getGrantedAuthorities(user));
  }

  private List<GrantedAuthority> getGrantedAuthorities(User user){
    List<GrantedAuthority> authorities = new ArrayList<>();

    for(UserRole userRoleObj : user.getUser_roles()){
      WebsiteRole websiteRole = userRoleObj.getWebsiteRole();
      String userRole = websiteRole.getDescription();
      authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole));
    }
    return authorities;
  }
}
