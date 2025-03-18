Feature: Validate Demo Web Shop Homepage

  Scenario: Ensure the homepage loads correctly
    Given The user is on the homepage
    Then The page title should be "Demo Web Shop"
    And The logo should be visible
    And The search bar should be accessible

  Scenario: Perform a successful product search
    Given The user is on the homepage
    When They enter "<search>" in the search bar
    And Click the search button
    Then Search results related to "computer" should be displayed

    Examples:
    | search    |
    | computer  |
    
