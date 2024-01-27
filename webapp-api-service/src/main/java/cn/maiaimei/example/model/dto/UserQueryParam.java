package cn.maiaimei.example.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserQueryParam extends BaseQueryParam {

  private String nickname;
  private String username;
}
