package cn.maiaimei.example.controller;

import cn.maiaimei.example.config.WebMvcConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class LoginController {

  /**
   * refer to {@link WebMvcConfig#addViewControllers(ViewControllerRegistry)}
   */
  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
