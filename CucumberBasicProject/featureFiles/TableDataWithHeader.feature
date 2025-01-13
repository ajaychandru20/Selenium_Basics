Feature: Pass data using a table with header

  Scenario: Login to the platform using table data with header
    Given login into the Orange portal hd
    Then Enter the UserName and Password with header
      | username | password  |
      | Admin    | admin123  |
    Then click the Login button and validate Dashboard then close hd
