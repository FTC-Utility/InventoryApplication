package com.ftc.fia.repository;

import com.ftc.fia.domain.PersistentLogin;
import com.ftc.fia.domain.User;
import com.ftc.fia.service.IPersistentLoginService;
import com.ftc.fia.service.IUserService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/*
  An object of this class is passed to Spring in methods configure and  getPersistentTokenBasedRememberMeServices of
  class WebMvcConfig; it is used in the functionality of the "Remember Me" option of the login page to skip the
  login page in the future for the user requesting it.
 */
@Repository
@Transactional
public class TokenRepository implements PersistentTokenRepository  {

  @Autowired
  IUserService userService;

  @Autowired
  IPersistentLoginService iPersistentLoginService;

  @Override
  public void createNewToken(PersistentRememberMeToken token) {
    /*
      This method is called from a Spring class to create a PersistentLogin object (a row in the persistent_login table)
      that represents a user that has selected the "Remember Me" option in the login page.
     */
    PersistentLogin persistentLogin = new PersistentLogin();
    /*
      token.getUsername() has the user name (which in this application is eMail) we have to create a row in table
      persistent_login that references the user name; we have to associate the user_id foreign key in the table with the
      id of the user that has that eMail.
        */
    String eMail = token.getUsername();
    User user = userService.findBySSO(eMail);
    persistentLogin.setUser(user);
    persistentLogin.setSeries(token.getSeries());
    persistentLogin.setToken(token.getTokenValue());
    /*
      PersistentLogin.setLastUsed() requires an argument of type java.time.LocalDateTime, but we have token.getDate()
       which is of type java.util.Date; we must use a conversion.
     */
    Instant instant = token.getDate().toInstant();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    persistentLogin.setLastUsed(localDateTime);
    iPersistentLoginService.createPersistentLogin(persistentLogin);
  }

  @Override
  public void updateToken(String series, String tokenValue, Date lastUsed) {
    PersistentLogin persistentLogin = iPersistentLoginService.getPersistentLoginBySeries(series);
    persistentLogin.setToken(tokenValue);
    /*
      PersistentLogin.setLastUsed() requires an argument of type java.time.LocalDateTime, but we have token.getDate()
       which is of type java.util.Date; we must use a conversion.
     */
    Instant instant = lastUsed.toInstant();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    persistentLogin.setLastUsed(localDateTime);
  }

  @Override
  public PersistentRememberMeToken getTokenForSeries(String seriesId) {
    // The PersistentLogin is identified by the series primary key column in the database.

    try
    {
      PersistentLogin persistentLogin = iPersistentLoginService.getPersistentLoginBySeries(seriesId);
    /*
     The first argument in the PersistentRememberMeToken constructor is the name associated with persistentLogin, but
     the name is the name (EMail) of the user and the user is obtained from persistentLogin.

     Additionally, the last used date should be java.util.Date, but persistentLogin gives a LocalDateTime object, so it
     has to be converted.
      */
      String userName = persistentLogin.getUser().getEmail();
      LocalDateTime localDateTime = persistentLogin.getLastUsed();
      Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
      java.util.Date lastUsed = Date.from(instant);
      PersistentRememberMeToken persistentRememberMeToken = new PersistentRememberMeToken(userName, persistentLogin
              .getSeries(),
              persistentLogin.getToken(), lastUsed);
      return persistentRememberMeToken;
    }catch (Exception e){
      return null;
    }
  }

  @Override
  public void removeUserTokens(String username) {
    /*
      This method requires removing the PersistentLogin associated with a user name (which is an email in this
      application). In this application, the user name
      is in the User table  and the user is identified by a foreign key, user_id, in the persistent_login table.
      Therefore, to identify the persistentlogin it is necessary to fing first the id of the user associated with a
      user name (eMail).
     */
    User user = userService.findBySSO(username);
    int id = user.getId();
    PersistentLogin persistentLogin = iPersistentLoginService.getPersistentLoginByUserId(id);

    if(persistentLogin!=null)
    iPersistentLoginService.deletePersistentLogin(persistentLogin);
  }
}
