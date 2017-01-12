package com.ftc.fia.service.impl;

import com.ftc.fia.business.impl.UserDetailsBusinessImpl;
import com.ftc.fia.domain.User;
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
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserDetailsBusinessImpl userDetailsBusinessImpl;

  @Override
  public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
    return userDetailsBusinessImpl.loadUserByUsername(ssoId);
  }
}
