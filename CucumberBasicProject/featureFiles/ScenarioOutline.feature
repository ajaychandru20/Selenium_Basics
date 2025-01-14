Feature: This is for the example of Scenario Outline

  Scenario Outline: Login the Orange HMR using Examples
    Given login into the Orange portal so
    Then Enter the "<UserName>" and "<Password>" with so
    Then click the Login button and validate Dashboard then close so
    Examples:
      | UserName | Password |
      | Admin    | admin123 |
      | Admins   | admin123 |