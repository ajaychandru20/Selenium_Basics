@SmokeTest
Feature: Sample Feature to demonstrate Cucumber tags

  @RegressionTest
  Scenario: Verify addition functionality
    Given I have two numbers 2 and 3
    When I add them
    Then the result should be 5

  @SmokeTest @RegressionTest
  Scenario: Verify subtraction functionality
    Given I have two numbers 5 and 2
    When I subtract them
    Then the result should be 3