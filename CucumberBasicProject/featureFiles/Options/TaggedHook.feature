@CartFeature
Feature: Online Shopping Cart

  Scenario: Add items to the cart
    Given I am on the product page
    When I add a product to the cart
    Then the product should be added successfully

  @CheckoutFeature
  Feature: Online Checkout

  Scenario: Checkout items in the cart
    Given I have items in the cart
    When I proceed to checkout
    Then I should see the payment page
