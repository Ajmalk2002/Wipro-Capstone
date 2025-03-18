package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomepagePage {
    WebDriver driver;
    WebDriverWait wait;

    
    public HomepagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
        PageFactory.initElements(driver, this);
    }

   
    @FindBy(css = ".header-logo img")
    private WebElement logo;

    @FindBy(id = "small-searchterms")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;

    
    public void navigateToHomepage() {
        driver.get("http://demowebshop.tricentis.com");
    }

    public boolean isLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(logo)); 
        return logo.isDisplayed();
    }

    public boolean isSearchBarAvailable() {
        wait.until(ExpectedConditions.visibilityOf(searchBar)); 
        return searchBar.isDisplayed();
    }

    public void enterSearchText(String query) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).clear(); 
        searchBar.sendKeys(query);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click(); 
    }

    public boolean isSearchResultsDisplayed(String query) {
        wait.until(ExpectedConditions.urlContains("search")); 
        return driver.getPageSource().contains(query);
    }
}
