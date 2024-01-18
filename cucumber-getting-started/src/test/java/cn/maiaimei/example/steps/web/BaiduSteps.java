package cn.maiaimei.example.steps.web;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaiduSteps {

  @When("search in Baidu, input keyword {string}")
  public void searchInBaidu(String keyword) throws InterruptedException {
    final ChromeDriver chromeDriver = ChromeSteps.getChromeDriver();
    // 获取搜索框
    final WebElement wdElement = chromeDriver.findElement(By.name("wd"));
    // 点击输入框
    wdElement.click();
    // 清空输入框
    wdElement.clear();
    // 输入关键字
    wdElement.sendKeys(keyword);
    // 点击“百度一下”
    final WebElement suElement = chromeDriver.findElement(By.id("su"));
    suElement.click();
    // 等待5秒
    Thread.sleep(3000);
  }
}
