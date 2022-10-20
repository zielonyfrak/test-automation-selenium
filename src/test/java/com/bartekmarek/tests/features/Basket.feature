@ui
Feature: Basket
  Tests checking whether the goods added to the cart are in it at the end of the transaction.
  Added to fill a Page Objects a bit.

  Scenario: Cart content check - one beer
    Given I'm on Brew Dog main page
    And I navigate to all beers selection page
    And I add to basket 1 pcs of first beer from the page
    When I navigate to my basket
    Then Ordered beers should be in my basket
    And Total price should match what I ordered

  Scenario: Cart content - more beers
    Given I'm on Brew Dog main page
    And I navigate to all beers selection page
    And I add to basket 3 pcs of first beer from the page
    And I add to basket 2 pcs of last beer from the page
    When I navigate to my basket
    Then Ordered beers should be in my basket
    And Total price should match what I ordered