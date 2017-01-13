package com.ftc.fia.config.web;

/**
 * Created by ABarrero on 1/11/2017.
 */
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
  /*
    Automatically register the springSecurityFilterChain Filter for every URL in the application.
    Add a ContextLoaderListener that loads the SecurityConfiguration.
   */
  public SecurityWebApplicationInitializer() {
    super(SecurityConfiguration.class);
  }
}
