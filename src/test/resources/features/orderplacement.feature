Feature: Order Processing on Demo Web Shop

  Scenario: Successfully placing an order
    Given The user opens the website in a browser
    When The user clicks the login link
    And Enters valid credentials with email "ajmaldemo12@gmail.com" and password "Password123"
    And Navigates to the Computer section and selects Desktops
    And Chooses the second desktop from the list
    And Configures RAM and HDD preferences
    And Clicks the "Add to Cart" button
    And Accesses the shopping cart menu
    And Clicks the "Go to Cart" button
    And Accepts the terms and conditions
    And Clicks the "Checkout" button
    And Selects or adds a new billing address
    And Fills in the required billing details
    And Proceeds with the shipping address
    And Confirms the shipping method
    And Chooses "Cash on Delivery" as the payment option
    And Verifies payment information
    And Clicks the "Confirm" button
    Then A success message should be displayed
    And The user logs out
