package com.shoppingcartsteps;

import com.pages.ShoppingCartPage;
import com.hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCartSteps {
    private WebDriver driver = Hooks.getDriver();
    private ShoppingCartPage cartPage = new ShoppingCartPage(driver);

    // Step 1: Navigate to the homepage
    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {
        driver.get("http://demowebshop.tricentis.com/");
    }

    // Step 2: Search for a product
    @When("The user searches for {string}")
    public void the_user_searches_for(String product) {
        cartPage.searchForProduct(product);
    }

    // Step 3: Select the desired computer product
    @When("The user selects the desired computer product")
    public void the_user_selects_the_desired_computer_product() {
        cartPage.selectComputer();
    }

    // Step 4: Click the "Add to Cart" button
    @When("The user clicks the {string} button")
    public void the_user_clicks_the_button(String button) {
    	cartPage.clickAddToCart();
    }

    // Step 5: Update the quantity
    @When("The user updates the quantity to {string}")
    public void the_user_updates_the_quantity_to(String quantity) {
        cartPage.updateQuantity(quantity);
    }
    
    @When("The user clicks the final {string} button")
    public void the_user_clicks_the_final_button(String string) {
    	cartPage.finalAddToCart();
    }
    
    // Step 6: Verify the success message
    @Then("The user should see a confirmation message indicating the product was added successfully")
    public void the_user_should_see_a_confirmation_message_indicating_the_product_was_added_successfully() {
        Assert.assertTrue(cartPage.isProductAdded(), "Product was not added successfully.");
    }

    // Step 7: Navigate to the shopping cart
    @When("The user navigates to the shopping cart")
    public void the_user_navigates_to_the_shopping_cart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Close the notification bar if it appears
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement closeButton = notification.findElement(By.className("close"));
            closeButton.click();

            // Wait for the notification to disappear
            wait.until(ExpectedConditions.invisibilityOf(notification));

            // Navigate to the shopping cart
            WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
            shoppingCart.click();
        } catch (Exception e) {
            System.out.println("Error navigating to shopping cart: " + e.getMessage());
            throw new RuntimeException("Failed to navigate to the shopping cart.", e);
        }
    }

    // Step 8: Accept terms and proceed to checkout
    @When("The user accepts the terms and proceeds to checkout")
    public void the_user_accepts_the_terms_and_proceeds_to_checkout() {
        cartPage.acceptTermsAndCheckout();
    }

    // Step 9: Verify the user is on the checkout page
    @Then("The user should be directed to the checkout page")
    public void the_user_should_be_directed_to_the_checkout_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "User is not on the checkout page.");
    }
}