Feature: Product Browsing and Search

  Scenario: TC8 - View products and product details
    Given the user is on the products page
    Then all products should be visible
    When the user opens a product
    Then the product details should be displayed

  Scenario: TC9 - Search for a product
    Given the user is on the products page
    When the user searches for a valid product name
    Then matching search results should be displayed
