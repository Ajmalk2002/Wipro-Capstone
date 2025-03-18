package com.pages;

import com.basepage.BasePage; 

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {  
	WebDriverWait wait;

    @FindBy(css = "#bar-notification .content")  
    private WebElement successMessage;

  
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("input.button-1.search-box-button");
    private By computerProduct = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/h2/a");
    private By addToCartButton = By.xpath("//input[@class='button-2 product-box-add-to-cart-button']");
    private By quantityField = By.id("addtocart_72_EnteredQuantity");
    private By finalAddToCartButton = By.xpath("//input[@id='add-to-cart-button-72']");
    @SuppressWarnings("unused")
	private By cartSuccessMessage = By.xpath("//div[@id='bar-notification']//p[@class='content']");
    private By shoppingCartLink = By.xpath("//span[contains(text(),'Shopping cart')]");
    private By termsOfServiceCheckbox = By.xpath("//input[@id=\"termsofservice\"]");
    private By checkoutButton = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        findWebElement(searchBox).sendKeys(productName);
        findWebElement(searchButton).click();
    }

    public void selectComputer() {
        findWebElement(computerProduct).click();
    }

    public void clickAddToCart() {
        findWebElement(addToCartButton).click();

     
        wait.until(ExpectedConditions.urlContains("simple-computer"));
        getWebDriver().navigate().back();  
    }

    public void updateQuantity(String quantity) {
        WebElement qtyField = findWebElement(quantityField);
        qtyField.clear();
        qtyField.sendKeys(quantity);
    }

    public void finalAddToCart() {
        findWebElement(finalAddToCartButton).click();
    }

    public boolean isProductAdded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Success message not found: " + e.getMessage());
            return false;
        }
    }

    public void goToShoppingCart() {
        findWebElement(shoppingCartLink).click();
    }

    public void acceptTermsAndCheckout() {
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceCheckbox));
        termsCheckbox.click();

        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutBtn.click();
    }
}