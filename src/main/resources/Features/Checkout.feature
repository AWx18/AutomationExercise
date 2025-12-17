Feature: Checkout Process

  Scenario: TC11 - Complete checkout and place order
    Given the user has added products to the cart
    When the user proceeds to checkout
    And the user enters payment information
    Then the order should be placed successfully
