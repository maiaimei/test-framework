package cn.maiaimei.example.repository;

import cn.maiaimei.example.utils.DBUtils;
import java.sql.Connection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoRepository {

  public String insert() {
    final Connection connection = DBUtils.getConnection();
    log.info("connection is {}", connection);
    return "success";
  }

  public String update() {
    final Connection connection = DBUtils.getConnection();
    log.info("connection is {}", connection);
    return "success";
  }
}
