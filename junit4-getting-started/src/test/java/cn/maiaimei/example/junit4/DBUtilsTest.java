package cn.maiaimei.example.junit4;

import static org.junit.Assert.assertEquals;

import cn.maiaimei.example.utils.DBUtils;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(DBUtils.class)
@RunWith(PowerMockRunner.class)
public class DBUtilsTest {

  @Test(expected = RuntimeException.class)
  public void getConnectionException() {
    DBUtils.getConnection();
  }

  @Test
  public void testGetConnectionSuccess() {
    PowerMockito.mockStatic(DBUtils.class);
    final Connection mockConnection = PowerMockito.mock(Connection.class);
    PowerMockito.when(DBUtils.getConnection()).thenReturn(mockConnection);
    final Connection connection = DBUtils.getConnection();
    assertEquals(mockConnection, connection);
  }

  @Test
  public void testGetConnection() throws Exception {
    final HikariDataSource mockHikariDataSource = PowerMockito.mock(HikariDataSource.class);
    final Connection mockConnection = PowerMockito.mock(Connection.class);
    PowerMockito.whenNew(HikariDataSource.class).withNoArguments()
        .thenReturn(mockHikariDataSource);
    Mockito.when(mockHikariDataSource.getConnection()).thenReturn(mockConnection);
    final Connection connection = DBUtils.getConnection();
    assertEquals(mockConnection, connection);
  }
}
