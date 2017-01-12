package com.ftc.fia.business.impl;

import com.ftc.fia.business.IEquipmentTypeBuisness;
import com.ftc.fia.business.IWebsiteRoleBusiness;
import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.repository.IWebsiteRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ABarrero on 1/3/2017.
 */
@Component
public class WebsiteRoleBusinessImpl implements IWebsiteRoleBusiness {
  @Autowired
  IWebsiteRoleRepository websiteRoleRepository;
  @Override
  public WebsiteRole findById(int id) {
    return websiteRoleRepository.findById(id);
  }

  @Override
  public WebsiteRole findByType(String type) {
    return websiteRoleRepository.findByType(type);
  }

  @Override
  public List<WebsiteRole> findAll() {
    return websiteRoleRepository.findAll();
  }
}
