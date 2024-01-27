package cn.maiaimei.example.model.dto;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class BaseQueryResult<T> {

  private List<T> records;
  private long total;
  private long size;
  private long current;
}
