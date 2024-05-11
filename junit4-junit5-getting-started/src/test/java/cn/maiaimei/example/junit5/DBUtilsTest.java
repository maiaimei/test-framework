package cn.maiaimei.example.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cn.maiaimei.example.utils.DBUtils;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DBUtilsTest {

  @Test
  public void getConnectionException() {
    assertThrows(RuntimeException.class, DBUtils::getConnection);
  }

  @Test
  public void testGetConnectionSuccess() {
    try (MockedStatic<DBUtils> mockedStatic = Mockito.mockStatic(DBUtils.class)) {
      final Connection mockConnection = Mockito.mock(Connection.class);
      mockedStatic.when(DBUtils::getConnection).thenReturn(mockConnection);
      //Mockito.when(DBUtils.getConnection()).thenReturn(mockConnection);
      final Connection connection = DBUtils.getConnection();
      assertEquals(mockConnection, connection);
    }
  }

  @Test
  public void testGetConnection() {
    final Connection mockConnection = Mockito.mock(Connection.class);
    MockedConstruction<HikariDataSource> mockedConstruction = Mockito.mockConstruction(
        HikariDataSource.class, ((mockHikariDataSource, context) -> {
          Mockito.when(mockHikariDataSource.getConnection()).thenReturn(mockConnection);
        }));
    final Connection connection = DBUtils.getConnection();
    assertEquals(mockConnection, connection);
    mockedConstruction.close();
  }
}
