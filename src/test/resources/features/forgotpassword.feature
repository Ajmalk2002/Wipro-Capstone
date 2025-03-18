Feature: Forgot Password Functionality

  Scenario: Successfully reset password using a registered email
    Given The user is on the login page
    When They navigate to the Forgot Password page
    And They enter a registered email "ajmaldemo@gmail.com"
    And Click the "Recover" button
    Then A confirmation message "Email with instructions has been sent to you." should be displayed

  Scenario: Attempt to reset password using an unregistered email
    Given The user is on the login page
    When They navigate to the Forgot Password page
    And They enter an unregistered email "invaliduser@example.com"
    And Click the "Recover" button
    Then An error message "Email not found." should be displayed

  Scenario: Attempt to reset password without entering an email
    Given The user is on the login page
    When They navigate to the Forgot Password page
    And They leave the email field blank
    And Click the "Recover" button
    Then A validation message "Enter your email" should be displayed
