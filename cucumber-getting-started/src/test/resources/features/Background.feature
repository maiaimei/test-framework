Feature: Background
  The purpose of the Background keyword is to group the same Given steps.
  It can contain one or more Given steps, which are run before each scenario, but after any Before hooks.
  A Background is placed before the first Scenario/Example, at the same level of indentation.

  Rule: Multiple site support
  Only blog owners can post to a blog, except administrators,
  who can post to all blogs.

    Background:
      Given a global administrator named "Greg"
      And a blog named "Greg's anti-tax rants"
      And a customer named "Dr. Bill"
      And a blog named "Expensive Therapy" owned by "Dr. Bill"

    Scenario: Dr. Bill posts to his own blog
      Given I am logged in as "Dr. Bill"
      When I try to post to "Expensive Therapy"
      Then I should see "Your article was published."

    Scenario: Dr. Bill tries to post to somebody else's blog, and fails
      Given I am logged in as "Dr. Bill"
      When I try to post to "Greg's anti-tax rants"
      Then I should see "Hey! That's not your blog!"

    Scenario: Greg posts to a client's blog
      Given I am logged in as "Greg"
      When I try to post to "Expensive Therapy"
      Then I should see "Your article was published."
