Feature: Open Google in Chrome

  Scenario: Google Search Scenario
    Given Open Chrome then search google
    When user click the search field
    Then enter this name "chennai" and press enter
    Then close the browser
