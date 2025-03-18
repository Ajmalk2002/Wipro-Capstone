package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Forgot password?")
    WebElement forgotPasswordLink;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(css = "input[value='Recover']")
    WebElement recoverButton;

    @FindBy(className = "result")
    WebElement confirmationMessage;

    @FindBy(xpath = "//div[@class=\"result\"]")
    WebElement errorMessage;

    @FindBy(xpath = "//span[@for=\"Email\"]")
    WebElement validationMessage;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
        emailField.sendKeys(email);
    }

    public void clickRecoverButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recoverButton)).click();
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(confirmationMessage)).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public String getValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(validationMessage)).getText();
    }
}
