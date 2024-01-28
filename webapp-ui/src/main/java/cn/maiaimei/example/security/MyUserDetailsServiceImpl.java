package cn.maiaimei.example.security;

import cn.maiaimei.example.config.ApiServiceConfig;
import cn.maiaimei.example.model.dto.UserInfo;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class MyUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ApiServiceConfig apiServiceConfig;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String url = apiServiceConfig.buildUrl("/user/info?username=".concat(username));
    final UserInfo userInfo = restTemplate.getForObject(url, UserInfo.class);
    if (Objects.isNull(userInfo)) {
      throw new UsernameNotFoundException("账户或密码错误");
    }
    return null;
  }
}
