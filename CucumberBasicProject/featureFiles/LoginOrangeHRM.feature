Feature: Login into Orange HRM Platform
  Scenario: Verify the Orange HRM portal successfully allows the user login
    Given Open Chrome then navigate to the Login page
    Then Enter the username and password
    And Click the login button
    Then Validate the dashboard page, after login