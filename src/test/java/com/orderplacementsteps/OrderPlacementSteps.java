package com.orderplacementsteps;

import com.pages.OrderPlacementPage;
import com.hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderPlacementSteps {
	WebDriver driver = Hooks.getDriver();
	OrderPlacementPage op = new OrderPlacementPage(driver);

	@Given("The user opens the website in a browser")
	public void open_website() {
		driver.get("http://demowebshop.tricentis.com");
	}

	@When("The user clicks the login link")
	public void click_login_link() {
		op.clickLoginLink();
	}

	@When("Enters valid credentials with email {string} and password {string}")
	public void enter_credentials(String email, String password) {
		op.enterLoginDetails(email, password);
	}

	@When("Navigates to the Computer section and selects Desktops")
	public void navigate_to_desktops() {
		op.navigateToDesktops();
	}

	@When("Chooses the second desktop from the list")
	public void select_second_desktop() {
		op.selectSecondDesktop();
	}

	@When("Configures RAM and HDD preferences")
	public void configure_ram_hdd() {
		op.selectRAMAndHDD();
	}

	@When("Clicks the {string} button")
	public void click_button(String button) {
		op.clickButton(button);
	}

	@When("Accesses the shopping cart menu")
	public void open_cart_menu() {
		op.openShoppingCart();
	}

	@When("Accepts the terms and conditions")
	public void accept_terms_conditions() {
		op.selectCheckbox("I agree with terms");
	}
	
	@When("Selects or adds a new billing address")
	public void select_or_add_billing_address() {
	    if (op.isBillingAddressDropdownPresent()) {
	        op.selectOrAddBillingAddress("New Address");
	    } else {
	        throw new RuntimeException("Billing address dropdown is missing.");
	    }
	}

	@When("Fills in the required billing details")
	public void fill_billing_details() throws InterruptedException {
		op.fillBillingDetails("", "", "", "United States", "New York City", "123 Main Street", "10001", "1234567890");
	}

	@When("Proceeds with the shipping address")
	public void continue_shipping_address() throws InterruptedException {
		op.continueShipping();
	}

	@When("Confirms the shipping method")
	public void confirm_shipping_method() throws InterruptedException {
		op.confirmShippingMethod();
	}

	@When("Chooses {string} as the payment option")
	public void select_payment_option(String method) throws InterruptedException {
		op.selectPaymentMethod(method);
	}

	@When("Verifies payment information")
	public void confirm_payment_info() throws InterruptedException {
		op.confirmPaymentInformation();
	}

	@Then("A success message should be displayed")
	public void verify_success_message() {
		Assert.assertTrue(op.verifyOrderSuccess(), "Order success message not displayed!");
	}

	@Then("The user logs out")
	public void logout_user() {
		op.logout();
	}
}
