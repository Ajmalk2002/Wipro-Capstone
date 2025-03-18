Feature: Verify Product Details and Add to Cart

  Scenario: Check specifications of the 14.1-inch Laptop
    Given The user is on the homepage
    And Selects the product
    Then The product details for the 14.1-inch Laptop should be verified

  Scenario: Add the 14.1-inch Laptop to the shopping cart
    Given The user is on the homepage
    When The user adds the 14.1-inch Laptop to the cart
    Then The product should be successfully added to the cart
