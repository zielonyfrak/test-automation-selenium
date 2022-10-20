@ui
Feature: Bar Booking Page
  Tests checking just page title to have more simple tests, to test multithreaded execution

  Scenario: Bar Booking page title
    Given I'm on Brew Dog main page
    When  I navigate to Bars booking page
    Then Page title should be like 'Bar Locator'
