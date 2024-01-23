"""
Locator strategies: Ways to identify one or more specific elements in the DOM.
定位策略：在DOM中标识一个或多个特定元素的方法.
https://www.selenium.dev/documentation/webdriver/elements/locators/
https://www.selenium.dev/zh-cn/documentation/webdriver/elements/locators/
"""
import time

from selenium.webdriver.common.by import By
from webdriver_helper import get_webdriver


# 根据文本定位a标签
# Locates anchor elements whose visible text matches the search value
# 定位link text可视文本与搜索值完全匹配的锚元素
def test_link_text():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    newsEl = driver.find_element(By.LINK_TEXT, "新闻")
    newsEl.click()
    time.sleep(3)


# 根据文本定位a标签（模糊匹配）
# Locates anchor elements whose visible text contains the search value. 
# If multiple elements are matching, only the first one will be selected.
# 定位link text可视文本部分与搜索值部分匹配的锚点元素。如果匹配多个元素，则只选择第一个元素。
def test_partial_link_text():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    newsEl = driver.find_element(By.PARTIAL_LINK_TEXT, "新")
    newsEl.click()
    time.sleep(3)


# 根据标签定位任意元素
def test_tag_name():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    els = driver.find_elements(By.TAG_NAME, "a")
    for el in els:
      print(el.text)


# 根据属性id定位任意元素
def test_id():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    kwEl = driver.find_element(By.ID, "kw")
    kwEl.send_keys("selenium web 自动化测试")
    time.sleep(3)


# 根据属性name定位任意元素
def test_name():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    kwEl = driver.find_element(By.NAME, "wd")
    kwEl.send_keys("selenium web 自动化测试")
    time.sleep(3)


# 根据属性class定位任意元素
def test_class_name():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    el = driver.find_element(By.CLASS_NAME, "hot-refresh-text")
    time.sleep(5)
    el.click()
    time.sleep(5)


# 通用定位策略：By.CSS_SELECTOR定位任意元素
def test_class_selector():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    kwEl = driver.find_element(By.NAME, "wd")
    kwEl.send_keys("selenium web 自动化测试")
    # el = driver.find_element(By.CSS_SELECTOR, "#head_wrapper .s_btn")
    el = driver.find_element(By.CSS_SELECTOR, ".bg .s_btn")
    el.click()
    time.sleep(5)


# 通用定位策略：By.XPATH定位任意元素
def test_xpath():
  with get_webdriver() as driver:
    driver.get("https://baidu.com")
    time.sleep(5)


if __name__ == '__main__':
  test_xpath()
