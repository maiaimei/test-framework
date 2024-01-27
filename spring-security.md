# Spring Security

[https://docs.spring.io/spring-security/reference/index.html](https://docs.spring.io/spring-security/reference/index.html)

## Getting Spring Security

[https://docs.spring.io/spring-security/reference/getting-spring-security.html](https://docs.spring.io/spring-security/reference/getting-spring-security.html)

### Spring Boot with Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

#### Servlet Applications

[https://docs.spring.io/spring-security/reference/servlet/getting-started.html](https://docs.spring.io/spring-security/reference/servlet/getting-started.html)

在 pom.xml 添加配置

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.1</version>
</parent>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
```

启动应用，在浏览器访问应用会跳转登录页面，控制台会输出随机密码，用户名为 user

```
Using generated security password: 5c7bfa8a-c9e5-4611-86a2-2c3137921890

This generated password is for development use only. Your security configuration must be updated before running your application in production.
```

```java
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
```

可以在 application.yml 中设置登录用户和密码

```yaml
spring:
  security:
    user:
      name: guest
      password: 12345
```

自定义认证逻辑

## SecurityContextHolder

The `SecurityContextHolder` is where Spring Security stores the details of who is [authenticated](https://docs.spring.io/spring-security/reference/features/authentication/index.html#authentication).

By default, `SecurityContextHolder` uses a `ThreadLocal` to store these details, which means that the `SecurityContext` is always available to methods in the same thread, even if the `SecurityContext` is not explicitly passed around as an argument to those methods. Using a `ThreadLocal` in this way is quite safe if you take care to clear the thread after the present principal’s request is processed. Spring Security’s [FilterChainProxy](https://docs.spring.io/spring-security/reference/servlet/architecture.html#servlet-filterchainproxy) ensures that the `SecurityContext` is always cleared.

![](./images/securitycontextholder.png)