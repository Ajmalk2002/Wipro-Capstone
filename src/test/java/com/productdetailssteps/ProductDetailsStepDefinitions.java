package com.productdetailssteps;

import com.pages.ProductDetailsPage;
import com.hooks.Hooks;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsStepDefinitions {
    WebDriver driver;
    ProductDetailsPage productPage;

    public ProductDetailsStepDefinitions() {
        this.driver = Hooks.getDriver();
        productPage = new ProductDetailsPage(driver);
    }

    @Given("The user is on the homepage")
    public void user_on_homepage() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Given("Selects the product")
    public void select_product() throws InterruptedException {
        productPage.clickOnProduct();
    }

    @Then("The product details for the {double}-inch Laptop should be verified")
    public void the_product_details_for_the_inch_laptop_should_be_verified(Double double1) {
    	productPage.validateProductDetails();
    }

    @When("The user adds the {double}-inch Laptop to the cart")
    public void add_laptop_to_cart(Double screenSize) throws InterruptedException {
        productPage.addToCart();
    }

    @Then("The product should be successfully added to the cart")
    public void verify_product_added_to_cart() {
        productPage.displayMsg();
    }
}
