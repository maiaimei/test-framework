package cn.maiaimei.example.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityFilterChainUtils
 */
public final class SecurityFilterChainUtils {

  /**
   * 禁用 formLogin & 启用默认 httpBasic
   */
  public static SecurityFilterChain securityFilterChain01(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .formLogin(AbstractHttpConfigurer::disable);

    return http.build();
  }

  /**
   * 禁用 httpBasic & 启用默认 formLogin
   */
  public static SecurityFilterChain securityFilterChain02(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            .anyRequest().authenticated()
        )
        .httpBasic(AbstractHttpConfigurer::disable)
        .formLogin(Customizer.withDefaults());

    return http.build();
  }

  /**
   * 启用默认 httpBasic & 启用默认 formLogin
   */
  public static SecurityFilterChain securityFilterChain03(HttpSecurity http) throws Exception {
    http
        /*
        anyRequest() 任何请求
        permitAll() 指定任何人都允许使用URL。没有认证也可以访问。
        denyAll() 指定任何人都不允许使用URL。通过认证也不能访问。
        authenticated() 指定任何经过身份验证的用户都允许使用URL。
         */
        .authorizeHttpRequests((authorize) -> authorize
            // 除了登录请求，其他请求必须授权访问，即通过认证后才能访问。
            .anyRequest().authenticated()
        )
        // Spring Security 支持两种不同的认证方式。
        // 一是可以通过 HttpBasic 来认证
        .httpBasic(Customizer.withDefaults())
        // 二是可以通过 form 表单来认证
        .formLogin(Customizer.withDefaults());

    return http.build();
  }

  /**
   * 自定义登录逻辑
   */
  public static SecurityFilterChain securityFilterChain04(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            // By default, Spring Boot serves static content from a directory called 
            // /static 
            // /public
            // /resources
            // /META-INF/resources
            // in the classpath or from the root of the ServletContext. 
            // 放行静态资源
            //.requestMatchers("/css/**").permitAll()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(AbstractHttpConfigurer::disable)
        .formLogin(form -> form
                // 自定义登录页面。需要添加permitAll()和配置视图控制器，否则会报重定向的次数过多
                .loginPage("/login").permitAll()
                //.loginProcessingUrl("/login")
                //.defaultSuccessUrl("/index")
                //.successForwardUrl("/index")
                //.failureForwardUrl()
                .successHandler(new MyAuthenticationSuccessHandler())
            //.successHandler(new MySimpleUrlAuthenticationSuccessHandler())
            //.failureHandler()
        )
        //.logout(Customizer.withDefaults())
        //.rememberMe(Customizer.withDefaults())
        //.passwordManagement(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable);

    return http.build();
  }
}
