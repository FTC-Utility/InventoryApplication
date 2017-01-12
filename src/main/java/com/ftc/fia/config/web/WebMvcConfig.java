package com.ftc.fia.config.web;

import java.util.Properties;

import com.ftc.fia.util.RoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"com.ftc.fia"})
@EnableWebMvc
@Import({SecurityConfiguration.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter {
  @Bean
  public InternalResourceViewResolver resolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Bean(name = "messageSource")
  public MessageSource configureMessageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages");
    messageSource.setCacheSeconds(5);
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }


  @Bean
  public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
    Properties mappings = new Properties();
    mappings.put("org.springframework.dao.DataAccessException", "error");
    b.setExceptionMappings(mappings);
    return b;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  /*
    Created by ABarrero on 1/8/2017.
    Methods for Spring Security.
   */
  @Autowired
  RoleToUserProfileConverter roleToUserProfileConverter;

  /**
   * Configure Converter to be used.
   * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
   */
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(roleToUserProfileConverter);
  }

  /**
   * Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last
   * '.' in @PathVaidables argument.
   * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
   * This is a workaround for this issue.
   */
  @Override
  public void configurePathMatch(PathMatchConfigurer matcher) {
    matcher.setUseRegisteredSuffixPatternMatch(true);
  }
}
