Feature: Pass data using a table without header

  Scenario: Login to the platform using table data
    Given login into the Orange portal
    Then Enter the UserName and Password without header
      | Admin | admin123 |
    Then click the Login button and validate Dashboard then close
