package cn.maiaimei.example.utils;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;

public class DBUtils {

  public static Connection getConnection() {
    try (HikariDataSource dataSource = new HikariDataSource()) {
      return dataSource.getConnection();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
