package cn.maiaimei.example.junit4;

import cn.maiaimei.example.repository.DemoRepository;
import cn.maiaimei.example.utils.DBUtils;
import java.sql.Connection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DemoRepositoryTest {

  @InjectMocks
  private DemoRepository demoRepository;

  MockedStatic<DBUtils> mockedStatic;

  @Before
  public void setUp() {
    mockedStatic = Mockito.mockStatic(DBUtils.class);
    final Connection mockConnection = Mockito.mock(Connection.class);
    mockedStatic.when(DBUtils::getConnection).thenReturn(mockConnection);
  }

  @After
  public void tearDown() {
    mockedStatic.close();
  }

  @Test
  public void testInsert() {
    Assert.assertEquals("success", demoRepository.insert());
  }

  @Test
  public void testUpdate() {
    Assert.assertEquals("success", demoRepository.update());
  }
}
