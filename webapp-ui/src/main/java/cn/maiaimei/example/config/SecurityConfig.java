package cn.maiaimei.example.config;

import cn.maiaimei.example.security.MyUserDetailsServiceImpl;
import cn.maiaimei.example.security.SecurityFilterChainUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return SecurityFilterChainUtils.securityFilterChain04(http);
  }

  //@Bean
  public MyUserDetailsServiceImpl myUserDetailsServiceImpl() {
    return new MyUserDetailsServiceImpl();
  }

  @Bean
  public UserDetailsService inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
    UserDetails admin = User.withUsername("admin")
        .password(passwordEncoder.encode("12345"))
        .authorities("ROLE_admin", "/dashboard",
            "/user/list", "/user/get", "/user/insert", "/user/update", "/user/delete",
            "/user/password/reset", "/user/password/change", "/self/password/change")
        .build();
    UserDetails user = User.withUsername("user")
        .password(passwordEncoder.encode("12345"))
        .authorities("ROLE_user", "/index", "/self/password/change")
        .build();
    return new InMemoryUserDetailsManager(user, admin);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
