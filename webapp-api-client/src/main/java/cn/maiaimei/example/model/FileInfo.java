package cn.maiaimei.example.model;

import java.math.BigDecimal;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FileInfo {

  private BigDecimal id;
  private String filename;
  private String filetype;
  private Integer filesize;
  private String filepath;
}
