package cn.maiaimei.example.config;

import cn.maiaimei.example.controller.LoginController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  /**
   * refer to {@link LoginController#login()}
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    //registry.addViewController("/login").setViewName("login");
  }
}
