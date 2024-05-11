package cn.maiaimei.example.junit4;

import cn.maiaimei.example.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit4中测试用例无需继承TestCase类，只需标记@Test注解即可 一个JUnit4的单元测试用例执行顺序为：
 *
 * @BeforeClass -> @Before -> @Test -> @After -> @AfterClass
 * @BeforeClass 和 @AfterClass 仅执行一次
 */
@Slf4j
public class StringUtilsTest {

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
  public void testHasText() {
    log.info("run testHasText");
    Assert.assertTrue(StringUtils.hasText("test"));
    Assert.assertTrue(StringUtils.hasText(" test "));
    Assert.assertFalse(StringUtils.hasText("  "));
    Assert.assertFalse(StringUtils.hasText(""));
    Assert.assertFalse(StringUtils.hasText(null));
  }

  @Test
  public void testHasLength() {
    log.info("run testHasLength");
    Assert.assertTrue(StringUtils.hasLength("test"));
    Assert.assertTrue(StringUtils.hasLength(" test "));
    Assert.assertTrue(StringUtils.hasLength("  "));
    Assert.assertFalse(StringUtils.hasLength(""));
    Assert.assertFalse(StringUtils.hasLength(null));
  }

  @Ignore("StringUtils.isEmpty is deprecated")
  @Test
  public void testIsEmpty() {
    log.info("run testIsEmpty");
    Assert.assertFalse(StringUtils.isEmpty("test"));
    Assert.assertFalse(StringUtils.isEmpty(" test "));
    Assert.assertFalse(StringUtils.isEmpty("  "));
    Assert.assertTrue(StringUtils.isEmpty(""));
    Assert.assertTrue(StringUtils.isEmpty(null));
  }
}
