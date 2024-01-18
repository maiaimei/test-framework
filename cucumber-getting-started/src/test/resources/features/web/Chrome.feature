Feature: Chrome

  Scenario: Baidu Search
    Given open chrome, input url "https://www.baidu.com/"
    When search in Baidu, input keyword "大王饶命"
    When search in Baidu, input keyword "炼气十万年"
    Then close chrome
