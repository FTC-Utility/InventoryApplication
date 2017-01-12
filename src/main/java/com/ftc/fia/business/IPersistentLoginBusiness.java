package com.ftc.fia.business;

import com.ftc.fia.domain.PersistentLogin;

/**
 * Created by ABarrero on 1/4/2017.
 */
public interface IPersistentLoginBusiness {
  public void createPersistentLogin(PersistentLogin persistentLogin);
  public void deletePersistentLogin(PersistentLogin persistentLogin);
  public void updatePersistentLogin(PersistentLogin persistentLogin);
  public PersistentLogin getPersistentLoginBySeries(String series);
  public PersistentLogin getPersistentLoginByUserId(int id);
}
