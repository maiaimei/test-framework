package cn.maiaimei.example.config;

import cn.maiaimei.example.security.MyUserDetailsServiceImpl;
import cn.maiaimei.example.security.SecurityFilterChainUtils;
import java.util.UUID;
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

  //@Bean
  public UserDetailsService inMemoryUserDetailsService() {
    String password = UUID.randomUUID().toString();
    System.out.println();
    System.out.println("Using generated security password: " + password);
    System.out.println();
    System.out.println(
        "This generated password is for development use only. Your security configuration must be"
            + " updated before running your application in production.");
    System.out.println();
    UserDetails userDetails = User.withUsername("user")
        .password(password)
        .build();
    return new InMemoryUserDetailsManager(userDetails);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
