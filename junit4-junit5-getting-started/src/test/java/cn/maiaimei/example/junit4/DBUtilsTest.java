package cn.maiaimei.example.junit4;

import static org.junit.Assert.assertEquals;

import cn.maiaimei.example.utils.DBUtils;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DBUtilsTest {

  @Test(expected = RuntimeException.class)
  public void getConnectionException() {
    DBUtils.getConnection();
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
