package cn.maiaimei.example.model;

import java.math.BigDecimal;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

  private BigDecimal id;
  private String username;
  private String password;
}
