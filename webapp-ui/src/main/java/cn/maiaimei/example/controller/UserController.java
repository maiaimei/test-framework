package cn.maiaimei.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/list")
  public String list() {
    return "list";
  }
}
