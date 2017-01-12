package com.ftc.fia.business.impl;

import com.ftc.fia.business.IPersistentLoginBusiness;
import com.ftc.fia.domain.PersistentLogin;
import com.ftc.fia.repository.IPersistentLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by ABarrero on 1/4/2017.
 */
@Component
public class PersistentLoginBusinessImpl implements IPersistentLoginBusiness {
  @Autowired
  IPersistentLoginRepository iPersistentLoginRepository;

  public PersistentLoginBusinessImpl() {
  }

  @Override
  public void createPersistentLogin(PersistentLogin persistentLogin) {
    iPersistentLoginRepository.save(persistentLogin);
  }

  @Override
  public void deletePersistentLogin(PersistentLogin persistentLogin) {
    iPersistentLoginRepository.delete(persistentLogin);
  }

  @Override
  public void updatePersistentLogin(PersistentLogin persistentLogin) {
    iPersistentLoginRepository.save(persistentLogin);

  }

  @Override
  public PersistentLogin getPersistentLoginBySeries(String series) {
    return iPersistentLoginRepository.getPersistentLoginBySeries(series);
  }

  @Override
  public PersistentLogin getPersistentLoginByUserId(int id) {
    return iPersistentLoginRepository.getPersistentLoginByUserId(id);
  }

}
