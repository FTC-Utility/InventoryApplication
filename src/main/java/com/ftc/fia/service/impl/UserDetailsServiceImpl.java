package com.ftc.fia.service.impl;

import com.ftc.fia.business.IUserDetailsBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ABarrero on 1/7/2017.
 * UserDetailsService is a Spring Interface.
 */
@Transactional
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

  @Autowired
  IUserDetailsBusiness userDetailsBusinessImpl;

  public UserDetails loadUserByUsername(String ssoId){

      UserDetails userDetails = userDetailsBusinessImpl.loadUserByUsername(ssoId);
    return userDetails;
  }

}
