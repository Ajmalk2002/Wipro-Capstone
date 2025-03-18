package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(css = "input[value='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//h2[@class=\"topic-html-content-header\"]")
    WebElement accountInfo;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    WebElement errorMessage;

    public void navigateToLoginPage() {
        driver.get("http://demowebshop.tricentis.com/login");
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isUserLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOf(accountInfo)).isDisplayed();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(accountInfo)).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }
}
