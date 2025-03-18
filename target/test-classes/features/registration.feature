Feature: User Account Registration  
  As a new user,  
  I want to create an account,  
  So that I can access the webshop.  

  Scenario: Successful Account Registration  
    Given I navigate to the registration page  
    When I provide the following valid details:  
      | Field          | Value                  |  
      | First Name     | Ajmal                  |  
      | Last Name      | Aju                    |  
      | Email          | ajmaldemo00@gmail.com  |  
      | Password       | Password123            |  
      | Confirm Password | Password123          |  
    And I click the "Register" button  
    Then I should see a confirmation message "Your registration completed"  

  Scenario: Registration with an Invalid Email  
    Given I navigate to the registration page  
    When I enter "invalid-email" into the Email field  
    And I click the "Register" button  
    Then I should see an error message "Wrong email"  

    Scenario: Registration with an Already Registered Email  
    Given I navigate to the registration page  
    When I provide the following details:  
      | Field          | Value                  |  
      | First Name     | Ajmal                  |  
      | Last Name      | Aju                    |  
      | Email          | ajmaldemo@gmail.com  |  
      | Password       | Password123            |  
      | Confirm Password | Password123          |  
    And I click the "Register" button  
    Then I should see an error message "The specified email already exists"