package cn.maiaimei.example.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

  private Long id;
  private String nickname;
  private String username;
  private String password;
  private Boolean enabled;
}
