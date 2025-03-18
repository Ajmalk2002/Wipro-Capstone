package com.advancedsearchsteps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import com.hooks.Hooks;
import com.pages.AdvancedSearchPage;
import org.testng.Assert;

public class AdvancedSearchStepDefintions {
    WebDriver driver = Hooks.getDriver();
    AdvancedSearchPage as = new AdvancedSearchPage(driver);

    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {
        driver.get("http://demowebshop.tricentis.com");
    }

    @When("The user enters {string} in the search bar")
    public void the_user_enters_in_the_search_bar(String product) {
        as.enterSearchTerm(product);
    }

    @When("The user clicks the search button")
    public void the_user_clicks_the_search_button() {
        as.clickSearchButton();
    }

    @Then("The user should see the related products")
    public void the_user_should_see_the_related_products() {
        Assert.assertTrue(as.isProductGridDisplayed(), "Related products are not displayed.");
    }

    @When("The user enables advanced search")
    public void the_user_enables_advanced_search() {
        as.enableAdvancedSearch();
    }

    @When("The user filters the category to {string}")
    public void the_user_filters_the_category_to(String category) {
        as.selectCategory(category);
    }

    @When("The user ticks the {string} checkbox")
    public void the_user_ticks_the_automatically_search_sub_categories_checkbox(String checkbox) {
        if (checkbox.equals("Automatically search sub categories")) {
            as.tickSearchSubCategories();
        } else if (checkbox.equals("Search in product descriptions")) {
            as.tickSearchInProductDescription();
        }
    }

    @When("The user sets the price range from {string} to {string}")
    public void the_user_sets_the_price_range_from_to(String from, String to) {
        as.setPriceRange(from, to);
    }

    @When("The user clicks the advanced search button")
    public void the_user_clicks_the_advanced_search_button() {
        as.clickFinalSearchButton();
    }

    @Then("The user should see products matching the advanced search criteria")
    public void the_user_should_see_products_matching_the_advanced_search_criteria() {
        Assert.assertTrue(as.isProductGridDisplayed(), "Products matching the advanced search criteria are not displayed.");
    }
}