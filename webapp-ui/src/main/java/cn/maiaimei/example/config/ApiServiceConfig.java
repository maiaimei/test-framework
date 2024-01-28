package cn.maiaimei.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api-service")
public class ApiServiceConfig {

  private String baseUrl;

  public String buildUrl(String url) {
    return this.baseUrl.concat(url);
  }
}
