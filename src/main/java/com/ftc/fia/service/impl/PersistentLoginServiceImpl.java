package com.ftc.fia.service.impl;

import com.ftc.fia.business.impl.PersistentLoginBusinessImpl;
import com.ftc.fia.domain.PersistentLogin;
import com.ftc.fia.service.IPersistentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ABarrero on 1/4/2017.
 */
@Service
@Transactional
public class PersistentLoginServiceImpl implements IPersistentLoginService {
  @Autowired
  PersistentLoginBusinessImpl persistentLoginBusinessImpl;

  public PersistentLoginServiceImpl() {
  }

  @Override
  public void createPersistentLogin(PersistentLogin persistentLogin) {
    persistentLoginBusinessImpl.createPersistentLogin(persistentLogin);
  }

  @Override
  public void deletePersistentLogin(PersistentLogin persistentLogin) {
    persistentLoginBusinessImpl.deletePersistentLogin(persistentLogin);
  }

  @Override
  public void updatePersistentLogin(PersistentLogin persistentLogin) {
    persistentLoginBusinessImpl.updatePersistentLogin(persistentLogin);
  }

  @Override
  public PersistentLogin getPersistentLoginBySeries(String series) {
    return persistentLoginBusinessImpl.getPersistentLoginBySeries(series);
  }

  @Override
  public PersistentLogin getPersistentLoginByUserId(int id) {
    return persistentLoginBusinessImpl.getPersistentLoginByUserId(id);
  }
}
