package com.ftc.fia.service.impl;

import com.ftc.fia.business.impl.WebsiteRoleBusinessImpl;
import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.service.IWebsiteRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ABarrero on 1/3/2017.
 */
@Transactional
@Service
public class WebsiteRoleServiceImpl implements IWebsiteRoleService {
  @Autowired
  WebsiteRoleBusinessImpl websiteRoleBusinessImpl;
  @Override
  public WebsiteRole findById(int id) {
    return websiteRoleBusinessImpl.findById(id);
  }

  @Override
  public WebsiteRole findByType(String type) {
     return websiteRoleBusinessImpl.findByType(type);
  }

  @Override
  public List<WebsiteRole> findAll() {
    return websiteRoleBusinessImpl.findAll();
  }
}
