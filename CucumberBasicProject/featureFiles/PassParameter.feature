Feature: Passing the Argument and parameter to login portal without scenario outline
  Scenario: See the result for the argument and parameter
    Given login into the HMRC portal
    Then enter the username "Admin" and password "admin123"
    Then click the Login button

