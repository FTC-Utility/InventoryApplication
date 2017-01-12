package com.ftc.fia.converter;

import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.service.IWebsiteRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by ABarrero on 1/4/2017.
 */

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component("roleToWebsiteRoleConverter")
public class RoleToWebsiteRoleConverter implements Converter<Object, WebsiteRole> {

  @Autowired
  IWebsiteRoleService websiteRoleServiceImpl;

  /**
   * Gets WebsiteRole by Id
   *
   * @see Converter#convert(Object)
   */
  public WebsiteRole convert(Object element) {
    Integer id = Integer.parseInt((String) element);
    WebsiteRole profile = websiteRoleServiceImpl.findById(id);
    return profile;
  }

}