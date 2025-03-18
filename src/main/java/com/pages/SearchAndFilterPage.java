package com.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndFilterPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchAndFilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-item']")
    List<WebElement> productList;

    @FindBy(id = "products-orderby")
    WebElement sortByDropdown;

    public void enterSearchTerm(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(product);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isProductListDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        return !productList.isEmpty();
    }

    public void selectSortingOption(String option) {
        wait.until(ExpectedConditions.visibilityOf(sortByDropdown)).sendKeys(option);
    }
}
