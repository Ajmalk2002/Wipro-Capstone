package com.searchandfiltersteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.hooks.Hooks;
import com.pages.SearchAndFilterPage;
import io.cucumber.java.en.*;

public class SearchFilterStepDefintions {
    WebDriver driver = Hooks.getDriver();
    SearchAndFilterPage searchAndFilterPage = new SearchAndFilterPage(driver);

    @Given("The user is on the homepage")
    public void navigateToHomepage() {
        driver.get("http://demowebshop.tricentis.com");
    }

    @When("The user searches for {string} using the search bar")
    public void searchForProduct(String product) {
        searchAndFilterPage.enterSearchTerm(product);
    }

    @When("Clicks the {string} button")
    public void clickSearchButton(String button) {
        if (button.equalsIgnoreCase("Search")) {
            searchAndFilterPage.clickSearchButton();
        }
    }

    @Then("The user should see relevant product results")
    public void verifySearchResults() {
        Assert.assertTrue(searchAndFilterPage.isProductListDisplayed(), "Search results are not displayed.");
    }

    @When("The user sorts the products by price from low to high")
    public void sortProductsByPrice() {
        searchAndFilterPage.selectSortingOption("Price: Low to High");
    }

    @Then("The displayed products should be sorted accordingly")
    public void verifySortedByPrice() {
    	driver.quit();
    }

    @When("The user sorts the products alphabetically from A to Z")
    public void sortProductsAlphabetically() {
        searchAndFilterPage.selectSortingOption("Name: A to Z");
    }

    @Then("The displayed products should appear in alphabetical order")
    public void verifySortedAlphabetically() {
    	driver.quit();
    }
    

    @Given("The user has searched for {string}")
    public void userHasSearchedFor(String productName) {
        searchForProduct(productName);
        clickSearchButton("Search");
    }
}
