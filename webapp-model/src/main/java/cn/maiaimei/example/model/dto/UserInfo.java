package cn.maiaimei.example.model.dto;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {

  private Long id;
  private String nickname;
  private String username;
  private Boolean enabled;
  private List<String> roles;
  private List<String> authorities;
}
