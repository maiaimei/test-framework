package cn.maiaimei.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingSeleniumTest {

  @Test
  public void eightComponents() {
    // 1. 使用驱动实例开启会话
    WebDriver driver = new ChromeDriver();
    // 2. 在浏览器上执行操作
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    // 3. 请求浏览器信息，包括窗口句柄、浏览器尺寸/位置、cookie、警报等
    String title = driver.getTitle();
    assertEquals("Web form", title);
    // 4. 建立等待策略。在尝试定位元素之前, 确保该元素位于页面上, 并且在尝试与该元素交互之前, 该元素处于可交互状态。
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    // 5. 发送命令 查找元素
    WebElement textBox = driver.findElement(By.name("my-text"));
    WebElement submitButton = driver.findElement(By.cssSelector("button"));
    // 6. 操作元素
    textBox.sendKeys("Selenium");
    submitButton.click();
    // 7. 获取元素信息
    WebElement message = driver.findElement(By.id("message"));
    String value = message.getText();
    assertEquals("Received!", value);
    // 8. 结束会话
    driver.quit();
  }

}
