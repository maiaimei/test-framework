package cn.maiaimei.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @GetMapping("/list")
  @PreAuthorize("hasAuthority('/user/list')")
  public String list() {
    return "user/list";
  }
}
