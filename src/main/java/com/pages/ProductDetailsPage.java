package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.basepage.BasePage;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    @FindBy(xpath = "//h2[@class='product-title']/a[contains(text(),'14.1-inch Laptop')]")
    WebElement productTitle;

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement productTitleonPage;

    @FindBy(xpath = "//div[@class='short-description']")
    WebElement productDescription;

    @FindBy(xpath = "//span[@itemprop='price']")
    WebElement productPrice;

    @FindBy(id = "main-product-img-31")
    WebElement productImage;

    @FindBy(xpath = "//span[@class='label']")
    WebElement productAvailability;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")
    WebElement addToCartButton;

    @FindBy(xpath = "//p[@class='content']")
    WebElement confirmationMessage;

    public void validateProductDetails() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productTitleonPage));
            wait.until(ExpectedConditions.visibilityOf(productDescription));
            wait.until(ExpectedConditions.visibilityOf(productPrice));
            wait.until(ExpectedConditions.visibilityOf(productImage));
            wait.until(ExpectedConditions.visibilityOf(productAvailability));

            Assert.assertTrue(productTitleonPage.isDisplayed(), "Product title is not displayed");
            Assert.assertTrue(productDescription.isDisplayed(), "Product description is not displayed");
            Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed");
            Assert.assertTrue(productImage.isDisplayed(), "Product image is not displayed");
            Assert.assertTrue(productAvailability.isDisplayed(), "Product availability is not displayed");

            System.out.println("Validation successful for product details");
        } catch (TimeoutException e) {
            Assert.fail("Product details validation failed: Element not found within timeout.");
        }
    }

    public void addToCart() {
        try {
            
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

           
            try {
                addToCartButton.click();
            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("arguments[0].click();", addToCartButton);
            }

           
            WebElement confirmationMessageElement = wait.until(
                ExpectedConditions.visibilityOf(confirmationMessage)
            );

            Assert.assertTrue(
                confirmationMessageElement.getText().contains("The product has been added to your shopping cart"),
                "Add to cart confirmation message is not displayed"
            );
            System.out.println("Product successfully added to the cart");
        } catch (TimeoutException e) {
            Assert.fail("Add to cart failed: Confirmation message not displayed within timeout.");
        } catch (NoSuchElementException e) {
            Assert.fail("Add to cart failed: Elements not found.");
        }
    }

    public void clickOnProduct() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productTitle)).click();
        } catch (TimeoutException e) {
            Assert.fail("Failed to click on product: Product title not found within timeout.");
        }
    }

    public void displayMsg() {
        try {
            WebElement confirmationMessageElement = wait.until(
                ExpectedConditions.visibilityOf(confirmationMessage)
            );

            String actualText = confirmationMessageElement.getText();
            String expectedText = "The product has been added to your shopping cart";

            Assert.assertEquals(actualText, expectedText, "Confirmation message does not match.");
        } catch (TimeoutException e) {
            Assert.fail("Confirmation message did not appear within timeout.");
        }
    }
}
