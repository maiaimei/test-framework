package cn.maiaimei.example.steps.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeSteps {

  private static ChromeDriver chromeDriver = null;

  {
    System.setProperty("webdriver.chrome.driver",
        "E:\\software\\chromedriver-win64\\chromedriver.exe");
    // 打开浏览器
    chromeDriver = new ChromeDriver();
    // 浏览器最大化
    chromeDriver.manage().window().maximize();
    // 超时等待30秒
    final Duration duration = Duration.ofSeconds(30);
    chromeDriver.manage().timeouts().implicitlyWait(duration);
  }

  @Given("open chrome, input url {string}")
  public void openBrowser(String url) {
    chromeDriver.get(url);
  }

  @When("close chrome")
  public void closeBrowser() {
    chromeDriver.quit();
  }

  public static ChromeDriver getChromeDriver() {
    return chromeDriver;
  }
}
