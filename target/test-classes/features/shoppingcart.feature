Feature: Shopping Cart Functionality

  Scenario: Add a product to the cart and proceed to checkout
    Given The user is on the homepage
    When The user searches for "computer"
    And The user selects the desired computer product
    And The user clicks the "Add to Cart" button
    And The user updates the quantity to "3"
    And The user clicks the final "Add to Cart" button
    Then The user should see a confirmation message indicating the product was added successfully
    When The user navigates to the shopping cart
    And The user accepts the terms and proceeds to checkout
    Then The user should be directed to the checkout page