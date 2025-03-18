package com.registrationsteps;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinitions {
    WebDriver webDriver;
    RegistrationPage registrationPage;

    public RegistrationStepDefinitions() {
        this.webDriver = Hooks.getDriver();
        if (this.webDriver == null) {
            throw new RuntimeException("WebDriver initialization failed! Verify the Hooks setup.");
        }
        this.registrationPage = new RegistrationPage(webDriver);
    }

    @Given("I navigate to the registration page")
    public void navigateToRegistrationPage() {
        webDriver.get("https://demowebshop.tricentis.com/register");
    }

    @When("I provide the following valid details:")
    public void enterValidRegistrationDetails(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        registrationPage.setFirstName(data.get("First Name"));
        registrationPage.setLastName(data.get("Last Name"));
        registrationPage.setEmail(data.get("Email"));
        registrationPage.setPassword(data.get("Password"));
        registrationPage.setConfirmPassword(data.get("Confirm Password"));
    }
 
    @When("I provide the following details:")
    public void enterRegistrationDetails(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        registrationPage.setFirstName(data.get("First Name"));
        registrationPage.setLastName(data.get("Last Name"));
        registrationPage.setEmail(data.get("Email"));
        registrationPage.setPassword(data.get("Password"));
        registrationPage.setConfirmPassword(data.get("Confirm Password"));
    }

    @When("I click the {string} button")
    public void clickRegisterButton(String button) {
        if (button.equalsIgnoreCase("Register")) {
            registrationPage.click();
        }
    }

    @Then("I should see a confirmation message {string}")
    public void verifySuccessMessage(String string) {
    	registrationPage.getSuccessMsg();
    }
    
    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
    	registrationPage.getWrongEmailMsg();
	}
    
    @Then("I should see an error message indicating the email already exists")
    public void verifyAlreadyRegisteredEmailErrorMessage() {
    	registrationPage.getErrorMessage();
    }

    
    @When("I enter {string} into the Email field")
    public void enterEmail(String email) {
        registrationPage.setEmail(email);
    }

    @When("I enter {string} into the Password field")
    public void enterPassword(String password) {
        registrationPage.setPassword(password);
    }

    @When("I enter {string} into the Confirm Password field")
    public void enterConfirmPassword(String confirmPassword) {
        registrationPage.setConfirmPassword(confirmPassword);
    }
}
