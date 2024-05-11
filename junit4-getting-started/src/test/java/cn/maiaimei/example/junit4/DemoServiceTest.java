package cn.maiaimei.example.junit4;

import cn.maiaimei.example.repository.DemoRepository;
import cn.maiaimei.example.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class DemoServiceTest {

  @InjectMocks
  private DemoService demoService;

  @Mock
  private DemoRepository demoRepository;

  @BeforeClass
  public static void setUpOnce() {
    log.info("run once before any of the test methods in the class");
  }

  @AfterClass
  public static void tearDownOnce() {
    log.info("run once after all the tests in the class");
  }

  @Before
  public void setUp() {
    log.info("run before each test in the class");
  }

  @After
  public void tearDown() {
    log.info("run after each test in the class");
  }

  @Test
  public void testInsert() {
    log.info("run testInsert");
    Mockito.when(demoRepository.insert()).thenReturn("failed");
    Assert.assertEquals("failed", demoService.insert());
  }

  @Test
  public void testUpdate() {
    log.info("run testUpdate");
    Mockito.when(demoRepository.update()).thenReturn("error");
    Assert.assertEquals("error", demoService.update());
  }
}
