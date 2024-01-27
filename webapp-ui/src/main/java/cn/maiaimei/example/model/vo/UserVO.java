package cn.maiaimei.example.model.vo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserVO {
  
  private BigDecimal id;
  private String nickname;
  private String username;
  private String password;
}
