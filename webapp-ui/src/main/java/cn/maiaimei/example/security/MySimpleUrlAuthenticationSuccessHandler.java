package cn.maiaimei.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class MySimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws ServletException, IOException {
    // 获取当前已认证的用户信息
    String username =
        ((org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal()).getUsername();

    // 根据用户跳转到相应的页面
    if ("admin".equals(username)) {
      setDefaultTargetUrl("/dashboard");
    } else if ("user".equals(username)) {
      setDefaultTargetUrl("/index");
    } else {
      setDefaultTargetUrl("/login?error=unauthorized");
    }

    super.onAuthenticationSuccess(request, response, authentication);
  }
}
