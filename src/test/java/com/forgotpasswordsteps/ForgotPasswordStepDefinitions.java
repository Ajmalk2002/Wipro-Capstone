package com.forgotpasswordsteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.hooks.Hooks;
import com.pages.ForgotPasswordPage;
import io.cucumber.java.en.*;

public class ForgotPasswordStepDefinitions {
    private WebDriver driver = Hooks.getDriver();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    @Given("The user is on the login page")
    public void user_is_on_login_page() {
        driver.get("http://demowebshop.tricentis.com/login");
    }

    @When("They navigate to the Forgot Password page")
    public void user_navigates_to_forgot_password_page() {
        forgotPasswordPage.navigateToForgotPassword();
    }

    @When("They enter a registered email {string}")
    public void user_enters_registered_email(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    @When("They enter an unregistered email {string}")
    public void user_enters_unregistered_email(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    @When("They leave the email field blank")
    public void user_leaves_email_field_blank() {
        forgotPasswordPage.enterEmail("");
    }

    @When("Click the {string} button")
    public void user_clicks_recover_button(String buttonName) {
        forgotPasswordPage.clickRecoverButton();
    }

    @Then("A confirmation message {string} should be displayed")
    public void confirmation_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(forgotPasswordPage.getConfirmationMessage(), expectedMessage);
    }

    @Then("An error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(), expectedMessage);
    }

    @Then("A validation message {string} should be displayed")
    public void validation_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(forgotPasswordPage.getValidationMessage(), expectedMessage);
    }
}
