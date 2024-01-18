Feature: Data Tables
  Data Tables are handy for passing a list of values to a step definition:
  Just like Doc Strings, Data Tables will be passed to the step definition as the last argument.

  Scenario: Authorization With Data Tables

    Given the following users exist:
      | name   | email              | twitter         |
      | Aslak  | aslak@cucumber.io  | @aslak_hellesoy |
      | Julien | julien@cucumber.io | @jbpros         |
      | Matt   | matt@cucumber.io   | @mattwynne      |
    
