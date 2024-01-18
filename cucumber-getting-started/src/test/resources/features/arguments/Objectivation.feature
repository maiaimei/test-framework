Feature: Objectivation

  Scenario: Authorization with objectivation

    Given the following accounts exist:
      | username        | role      | project    |
      | waiting1@qq.com | admin     | default    |
      | waiting2@qq.com | analyst   | production |
      | waiting3@qq.com | developer | default    |
