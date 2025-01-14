Feature: Cucumber Options DryRun and Strict
  Scenario: Test with the dryrun and strict
    Given login into the Orange portal dr
    Then Enter the UserName and Password with dr
      | username | password  |
      | Admin    | admin123  |
    Then click the Login button and validate Dashboard then close dr