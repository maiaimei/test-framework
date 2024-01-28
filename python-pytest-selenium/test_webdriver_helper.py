from webdriver_helper import get_webdriver


def test_get_webdriver():
  # 自动下载合适的浏览器驱动，然后实例化selenium，默认是chrome，也支持firefox
  driver = get_webdriver()

  # 在浏览器上执行操作
  driver.get("https://qq.com")

  # 关闭浏览器，结束会话
  driver.quit()


def test_get_webdriver_by_with_statement():
  with get_webdriver() as driver:
    driver.get("https://qq.com")


if __name__ == '__main__':
  test_get_webdriver_by_with_statement()
