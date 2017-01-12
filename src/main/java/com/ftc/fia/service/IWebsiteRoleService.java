package com.ftc.fia.service;

import com.ftc.fia.domain.WebsiteRole;

import java.util.List;

/**
 * Created by ABarrero on 1/3/2017.
 */
public interface IWebsiteRoleService {

  WebsiteRole findById(int id);

  WebsiteRole findByType(String type);

  List<WebsiteRole> findAll();
}
