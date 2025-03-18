Feature: Advanced Search Filter Products

  Scenario: Perform advanced search
    Given The user is on the homepage
    When The user enters "Cam" in the search bar
    And The user clicks the search button
    Then The user should see the related products
    When The user enables advanced search
    And The user filters the category to "Electronics >> Camera,photo"
    And The user ticks the "Automatically search sub categories" checkbox
    And The user sets the price range from "500" to "2000"
    And The user ticks the "Search in product descriptions" checkbox
    And The user clicks the advanced search button
    Then The user should see products matching the advanced search criteria