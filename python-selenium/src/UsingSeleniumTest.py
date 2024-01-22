from selenium import webdriver
from selenium.webdriver.common.by import By


def test_eight_components():
  # 1. 使用驱动实例开启会话
  driver = webdriver.Chrome()
  # 2. 在浏览器上执行操作
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  # 3. 请求浏览器信息，包括窗口句柄、浏览器尺寸/位置、cookie、警报等
  title = driver.title
  assert title == "Web form"
  # 4. 建立等待策略。在尝试定位元素之前, 确保该元素位于页面上, 并且在尝试与该元素交互之前, 该元素处于可交互状态。
  driver.implicitly_wait(0.5)
  # 5. 发送命令 查找元素
  text_box = driver.find_element(by=By.NAME, value="my-text")
  submit_button = driver.find_element(by=By.CSS_SELECTOR, value="button")
  # 6. 操作元素
  text_box.send_keys("Selenium")
  submit_button.click()
  # 7. 获取元素信息
  message = driver.find_element(by=By.ID, value="message")
  value = message.text
  assert value == "Received!"
  # 8. 结束会话
  driver.quit()


if __name__ == '__main__':
  test_eight_components()
