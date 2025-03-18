package com.loginsteps;

import org.testng.Assert;
import com.hooks.Hooks;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions {
    private LoginPage loginPage = new LoginPage(Hooks.getDriver());

    // Step 1: Navigate to the login page
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.navigateToLoginPage();
    }

    // Step 2: Enter valid email and password
    @When("The user enters a valid email {string} and password {string}")
    public void the_user_enters_a_valid_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    // Step 3: Enter invalid email and password
    @When("The user enters an invalid email {string} and password {string}")
    public void the_user_enters_an_invalid_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    // Step 4: Click the Login button
    @When("The user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    // Step 5: Verify successful login
    @Then("The user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in.");
    }

    // Step 6: Verify success message
    @Then("The user should see the message {string}")
    public void the_user_should_see_the_message(String message) {
        Assert.assertEquals(loginPage.getSuccessMessage(), message, "Success message does not match.");
    }

    // Step 7: Verify error message
    @Then("The user should see an error message {string}")
    public void the_user_should_see_an_error_message(String errorMessage) {
        String actualMessage = loginPage.getErrorMessage().trim(); // Remove leading/trailing spaces
        String expectedMessage = errorMessage.trim(); // Remove leading/trailing spaces

        // Normalize spaces in the error message
        Assert.assertEquals(
            actualMessage.replaceAll("\\s+", " "), 
            expectedMessage.replaceAll("\\s+", " "), 
            "Error message does not match."
        );
    }
}