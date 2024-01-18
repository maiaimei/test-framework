Feature: Scenario Outline
  The Scenario Outline keyword can be used to run the same Scenario multiple times,
  with different combinations of values.
  The Scenario Outline is run once for each row in the Examples section
  beneath it (not counting the first header row).
  The steps can use <> delimited parameters that reference headers in the examples table.
  Cucumber will replace these parameters with values from the table
  before it tries to match the step against a step definition.

  Scenario Outline: eating
    Given there are <start> cucumbers
    When I eat <eat> cucumbers
    Then I should have <left> cucumbers

    Examples:
      | start | eat | left |
      | 12    | 5   | 7    |
      | 20    | 5   | 15   |
