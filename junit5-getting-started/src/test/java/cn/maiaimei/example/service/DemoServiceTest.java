package cn.maiaimei.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cn.maiaimei.example.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

  @InjectMocks
  private DemoService demoService;

  @Mock
  private DemoRepository demoRepository;

  @BeforeAll
  public static void setUpOnce() {
    log.info("run once before any of the test methods in the class");
  }

  @AfterAll
  public static void tearDownOnce() {
    log.info("run once after all the tests in the class");
  }

  @BeforeEach
  public void setUp() {
    log.info("run before each test in the class");
  }

  @AfterEach
  public void tearDown() {
    log.info("run after each test in the class");
  }

  @Test
  public void testInsert() {
    log.info("run testInsert");
    Mockito.when(demoRepository.insert()).thenReturn("failed");
    assertEquals("failed", demoService.insert());
  }

  @Test
  public void testUpdate() {
    log.info("run testUpdate");
    Mockito.when(demoRepository.update()).thenReturn("error");
    assertEquals("error", demoService.update());
  }
}
