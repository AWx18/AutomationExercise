Feature: Cart Management

  Scenario: TC14 - Update quantity in cart
    Given the user is viewing a product detail
    When the user increases the quantity to 3
    And the user adds the product to the cart
    Then the cart should show quantity 3
