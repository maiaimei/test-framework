package cn.maiaimei.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/self")
public class SelfController {

  @GetMapping("/change-password")
  public String changePassword() {
    return "self/change-password";
  }
}
