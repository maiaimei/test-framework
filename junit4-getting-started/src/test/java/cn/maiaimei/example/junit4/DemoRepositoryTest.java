package cn.maiaimei.example.junit4;

import cn.maiaimei.example.repository.DemoRepository;
import cn.maiaimei.example.utils.DBUtils;
import java.sql.Connection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(DBUtils.class)
@RunWith(PowerMockRunner.class)
public class DemoRepositoryTest {

  @InjectMocks
  private DemoRepository demoRepository;

  @Before
  public void setUp() {
    PowerMockito.mockStatic(DBUtils.class);
    final Connection mockConnection = PowerMockito.mock(Connection.class);
    PowerMockito.when(DBUtils.getConnection()).thenReturn(mockConnection);
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
