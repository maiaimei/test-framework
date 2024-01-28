package cn.maiaimei.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    final String targetUrl = getTargetUrl(request, response, authentication);
    this.redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  private String getTargetUrl(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
    String targetUrl = "/";

    final List<String> authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).toList();
    if (authorities.contains("ROLE_admin")) {
      targetUrl = "dashboard";
    } else if (authorities.contains("ROLE_user")) {
      targetUrl = "index";
    } else {
      final HttpSessionRequestCache cache = new HttpSessionRequestCache();
      final SavedRequest savedRequest = cache.getRequest(request, response);
      if (Objects.nonNull(savedRequest)
          && StringUtils.hasText(savedRequest.getRedirectUrl())
          && !savedRequest.getRedirectUrl().contains("/login")) {
        targetUrl = savedRequest.getRedirectUrl();
      }
    }
    return targetUrl;
  }
}
