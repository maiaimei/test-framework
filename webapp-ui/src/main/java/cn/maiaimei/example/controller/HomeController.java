package cn.maiaimei.example.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class HomeController {

  @RequestMapping(value = {"", "/"})
  public String home() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();
    String username = authentication.getName();
    Object principal = authentication.getPrincipal();
    final List<String> authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).toList();
    log.info("username: {}", username);
    log.info("principal: {}", principal);
    log.info("authorities: {}", StringUtils.collectionToCommaDelimitedString(authorities));
    String targetUrl = "forward:/index";
    if (authorities.contains("ROLE_admin")) {
      targetUrl = "forward:/dashboard";
    } else if (authorities.contains("ROLE_user")) {
      targetUrl = "forward:/index";
    }
    return targetUrl;
  }

  @PreAuthorize("hasAuthority('/index')")
  @RequestMapping(value = {"/index"})
  public String index() {
    return "index";
  }

  @PreAuthorize("hasAuthority('/dashboard')")
  @RequestMapping("dashboard")
  public String dashboard() {
    return "dashboard";
  }

}
