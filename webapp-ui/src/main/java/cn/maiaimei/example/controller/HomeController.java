package cn.maiaimei.example.controller;

import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class HomeController {

  @GetMapping(value = {"", "/", "/index"})
  public String index() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();
    String username = authentication.getName();
    Object principal = authentication.getPrincipal();
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    log.info("username: {}", username);
    log.info("principal: {}", principal);
    log.info("authorities: {}", StringUtils.collectionToCommaDelimitedString(authorities));
    return "index";
  }
}
