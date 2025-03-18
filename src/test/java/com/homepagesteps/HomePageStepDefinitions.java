package com.homepagesteps;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.HomepagePage;
import io.cucumber.java.en.*;

public class HomePageStepDefinitions {
    WebDriver driver = Hooks.getDriver();
    HomepagePage homepage = new HomepagePage(driver);

    @Given("The user is on the homepage")
    public void user_is_on_homepage() {
        driver.get("https://demowebshop.tricentis.com");
    }

    @Then("The page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }

    @Then("The logo should be visible")
    public void logo_should_be_visible() {
        Assert.assertTrue(homepage.isLogoDisplayed(), "Logo is not visible!");
    }

    @Then("The search bar should be accessible")
    public void search_bar_should_be_accessible() {
        Assert.assertTrue(homepage.isSearchBarAvailable(), "Search bar is not accessible!");
    }

    @When("They enter {string} in the search bar")
    public void user_enters_text_in_search_bar(String query) {
        homepage.enterSearchText(query);
    }

    @And("Click the search button")
    public void user_clicks_search_button() {
        homepage.clickSearchButton();
    }

    @Then("Search results related to {string} should be displayed")
    public void search_results_should_be_displayed(String query) {
        Assert.assertTrue(homepage.isSearchResultsDisplayed(query), "Search results are not displayed!");
    }
}
