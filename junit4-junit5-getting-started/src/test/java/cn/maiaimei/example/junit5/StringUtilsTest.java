package cn.maiaimei.example.junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.maiaimei.example.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/***
 * @BeforeAll -> @Before -> @Test -> @After -> @AfterAll
 * @BeforeAll 和 @AfterAll 仅执行一次
 */
@Slf4j
public class StringUtilsTest {

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
  public void testHasText() {
    log.info("run testHasText");
    assertTrue(StringUtils.hasText("test"));
    assertTrue(StringUtils.hasText(" test "));
    assertFalse(StringUtils.hasText("  "));
    assertFalse(StringUtils.hasText(""));
    assertFalse(StringUtils.hasText(null));
  }

  @Test
  public void testHasLength() {
    log.info("run testHasLength");
    assertTrue(StringUtils.hasLength("test"));
    assertTrue(StringUtils.hasLength(" test "));
    assertTrue(StringUtils.hasLength("  "));
    assertFalse(StringUtils.hasLength(""));
    assertFalse(StringUtils.hasLength(null));
  }

  @Disabled("StringUtils.isEmpty is deprecated")
  @Test
  public void testIsEmpty() {
    log.info("run testIsEmpty");
    assertFalse(StringUtils.isEmpty("test"));
    assertFalse(StringUtils.isEmpty(" test "));
    assertFalse(StringUtils.isEmpty("  "));
    assertTrue(StringUtils.isEmpty(""));
    assertTrue(StringUtils.isEmpty(null));
  }
}
