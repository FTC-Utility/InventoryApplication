package com.ftc.fia.util;

import com.ftc.fia.domain.WebsiteRole;
import com.ftc.fia.service.IWebsiteRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by ABarrero on 1/9/2017.
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter  implements Converter<Object, WebsiteRole> {
  @Autowired
  IWebsiteRoleService iWebsiteRoleService;

  /**
   * Gets UserProfile by Id
   * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
   */
  public WebsiteRole convert(Object element) {
    Integer id = Integer.parseInt((String)element);
    WebsiteRole profile= iWebsiteRoleService.findById(id);
    return profile;
  }
}
