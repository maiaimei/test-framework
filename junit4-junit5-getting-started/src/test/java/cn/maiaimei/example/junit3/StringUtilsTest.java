package cn.maiaimei.example.junit3;

import cn.maiaimei.example.utils.StringUtils;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

/**
 * JUnit3中测试用例需要继承TestCase类
 */
@Slf4j
public class StringUtilsTest extends TestCase {

  @Override
  protected void setUp() {
    log.info("run before each test in the class");
  }

  @Override
  protected void tearDown() {
    log.info("run after each test in the class");
  }

  public void testHasText() {
    log.info("run testHasText");
    Assert.assertTrue(StringUtils.hasText("test"));
    Assert.assertTrue(StringUtils.hasText(" test "));
    Assert.assertFalse(StringUtils.hasText("  "));
    Assert.assertFalse(StringUtils.hasText(""));
    Assert.assertFalse(StringUtils.hasText(null));
  }

  public void testHasLength() {
    log.info("run testHasLength");
    Assert.assertTrue(StringUtils.hasLength("test"));
    Assert.assertTrue(StringUtils.hasLength(" test "));
    Assert.assertTrue(StringUtils.hasLength("  "));
    Assert.assertFalse(StringUtils.hasLength(""));
    Assert.assertFalse(StringUtils.hasLength(null));
  }
}
