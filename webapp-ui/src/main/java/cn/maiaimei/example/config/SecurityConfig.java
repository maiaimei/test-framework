package cn.maiaimei.example.config;

import cn.maiaimei.example.service.MyUserDetailsServiceImpl;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
    http
        .authorizeHttpRequests((authorize) -> authorize
            // 登录请求可以匿名访问
            //.requestMatchers("/").permitAll()
            // 其他请求必须授权后才能访问
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
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

}
