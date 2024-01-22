# Selenium

[https://www.selenium.dev/zh-cn/documentation/webdriver/getting_started/](https://www.selenium.dev/zh-cn/documentation/webdriver/getting_started/)

Selenium 通过使用 WebDriver 支持市场上所有主流浏览器的自动化。 Webdriver 是一个 API 和协议，它定义了一个语言中立的接口，用于控制 web 浏览器的行为。 每个浏览器都有一个特定的 WebDriver 实现，称为驱动程序。 驱动程序是负责委派给浏览器的组件，并处理与 Selenium 和浏览器之间的通信。

## Selenium IDE

Open source record and playback test automation for the web.

Selenium IDE是一个记录和回放用户操作的浏览器扩展.

Selenium的集成开发环境 ([Selenium IDE](https://selenium.dev/selenium-ide)) 是一个易于使用的浏览器扩展, 利用既定的Selenium命令记录用户的浏览器行为, 参数由每个元素的上下文定义. 它提供了一种学习Selenium语法的极好方法. 其适用于谷歌Chrome、Mozilla火狐以及微软Edge浏览器.

有关更多信息, 请访问完整的 [Selenium IDE 文档](https://www.selenium.dev/selenium-ide/docs/en/introduction/getting-started)

[https://www.selenium.dev/selenium-ide/](https://www.selenium.dev/selenium-ide/)

[https://github.com/SeleniumHQ/selenium-ide/releases](https://github.com/SeleniumHQ/selenium-ide/releases)

## Java+Selenium

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.16.1</version>
</dependency>
```

## Python+Selenium

```shell
pip install selenium 
pip install webdriver-helper
```

webdriver-helper 是一个 python 第三方库，用来更加便捷的使用 selenium，完成浏览器自动化控制的辅助工具。

因为 chrome 频繁自动更新，浏览器驱动随时可能失效，导致代码跑不起来。

有了 webdriver-helper 就再也不用关心浏览器和浏览器驱动的匹配问题了。

目前有两个版本：

第一个是免费版，版本代号 1.*, 这个版本可以帮助你免去寻找、匹配、下载合适的浏览器驱动。

```shell
pip install webdriver-helper==1.*
```

第二个是付费版本，版本代号 2.*，是在免费版的基础上进行了改进和增强。

## Eight Basic Components

Selenium所做的一切, 就是发送给浏览器命令, 用以执行某些操作或为信息发送请求。

Java sample code

```java
// 1. 使用驱动实例开启会话
WebDriver driver = new ChromeDriver();
// 2. 在浏览器上执行操作
driver.get("https://www.selenium.dev/selenium/web/web-form.html");
// 3. 请求浏览器信息，包括窗口句柄、浏览器尺寸/位置、cookie、警报等
driver.getTitle();
// 4. 建立等待策略。在尝试定位元素之前, 确保该元素位于页面上, 并且在尝试与该元素交互之前, 该元素处于可交互状态。
driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
// 5. 发送命令 查找元素
WebElement textBox = driver.findElement(By.name("my-text"));
WebElement submitButton = driver.findElement(By.cssSelector("button"));
// 6. 操作元素
textBox.sendKeys("Selenium");
submitButton.click();
// 7. 获取元素信息
message.getText();
// 8. 结束会话
driver.quit();
```
Python sample code
```python
# 1. 使用驱动实例开启会话
driver = webdriver.Chrome()
# 2. 在浏览器上执行操作
driver.get("https://www.selenium.dev/selenium/web/web-form.html")
# 3. 请求浏览器信息，包括窗口句柄、浏览器尺寸/位置、cookie、警报等
title = driver.title
# 4. 建立等待策略。在尝试定位元素之前, 确保该元素位于页面上, 并且在尝试与该元素交互之前, 该元素处于可交互状态。
driver.implicitly_wait(0.5)
# 5. 发送命令 查找元素
text_box = driver.find_element(by=By.NAME, value="my-text")
submit_button = driver.find_element(by=By.CSS_SELECTOR, value="button")
# 6. 操作元素
text_box.send_keys("Selenium")
submit_button.click()
# 7. 获取元素信息
text = message.text
# 8. 结束会话
driver.quit()
```

