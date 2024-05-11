package cn.maiaimei.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cn.maiaimei.example.utils.DBUtils;
import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DemoRepositoryTest {

  @InjectMocks
  private DemoRepository demoRepository;

  MockedStatic<DBUtils> mockedStatic;

  @BeforeEach
  public void setUp() {
    mockedStatic = Mockito.mockStatic(DBUtils.class);
    final Connection mockConnection = Mockito.mock(Connection.class);
    mockedStatic.when(DBUtils::getConnection).thenReturn(mockConnection);
  }

  @AfterEach
  public void tearDown() {
    mockedStatic.close();
  }

  @Test
  public void testInsert() {
    assertEquals("success", demoRepository.insert());
  }

  @Test
  public void testUpdate() {
    assertEquals("success", demoRepository.update());
  }
}
