package cn.maiaimei.example.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class BaseQueryParam {

  private Integer current;
  private Integer size;
}
