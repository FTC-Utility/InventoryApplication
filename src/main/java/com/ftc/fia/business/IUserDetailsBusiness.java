package com.ftc.fia.business;

import com.ftc.fia.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ABarrero on 1/7/2017.
 */

public interface IUserDetailsBusiness {
  public UserDetails loadUserByUsername(String ssoId)throws UsernameNotFoundException ;
}
