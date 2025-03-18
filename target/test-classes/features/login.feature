Feature: Login and Forgot Password Functionality

  Scenario Outline: User logs in successfully with valid credentials
    Given The user is on the login page
    When The user enters a valid email "<email>" and password "<password>"
    And The user clicks the Login button
    Then The user should be logged in successfully
    And The user should see the message "<message>"

    Examples: 
      | email               | password    | message              |
      | ajmaldemo12@gmail.com | Password123 | Welcome to our store |

  Scenario Outline: User fails to log in with invalid credentials
    Given The user is on the login page
    When The user enters an invalid email "<email>" and password "<password>"
    And The user clicks the Login button
    Then The user should see an error message "<error_message>"

    Examples: 
      | email               | password    | error_message                                                                              |
      | invaliduser@gmail.com | invalidpass | Login was unsuccessful. Please correct the errors and try again. No customer account found |