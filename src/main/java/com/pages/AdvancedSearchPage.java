package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AdvancedSearchPage {
    WebDriver driver;
    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-item']")
    List<WebElement> productList;

    @FindBy(xpath = "//input[@id='As']")
    WebElement advancedSearchCheckbox;

    @FindBy(xpath = "//select[@id='Cid']")
    WebElement categoryDropdown;

    @FindBy(xpath = "//input[@id='Isc']")
    WebElement searchSubCategoriesCheckbox;

    @FindBy(xpath = "//input[@id='Pf']")
    WebElement priceFromInput;

    @FindBy(xpath = "//input[@id='Pt']")
    WebElement priceToInput;

    @FindBy(xpath = "//input[@id='Sid']")
    WebElement searchInProductDescriptionCheckbox;

    @FindBy(xpath = "//input[@class='button-1 search-button']")
    WebElement finalSearchButton;

    @FindBy(xpath = "//div[@class='product-grid']")
    WebElement productGrid;

    public void enterSearchTerm(String product) {
        searchBox.sendKeys(product);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enableAdvancedSearch() {
        advancedSearchCheckbox.click();
    }

    public void selectCategory(String category) {
        categoryDropdown.sendKeys(category);
    }

    public void tickSearchSubCategories() {
        searchSubCategoriesCheckbox.click();
    }

    public void setPriceRange(String from, String to) {
        priceFromInput.sendKeys(from);
        priceToInput.sendKeys(to);
    }

    public void tickSearchInProductDescription() {
        searchInProductDescriptionCheckbox.click();
    }

    public void clickFinalSearchButton() {
        finalSearchButton.click();
    }

    public boolean isProductGridDisplayed() {
        return productGrid.isDisplayed();
    }
}