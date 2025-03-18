package com.pages;

import com.basepage.BasePage;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPlacementPage extends BasePage {
    
    private WebDriverWait wait;

    public OrderPlacementPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // 10-second timeout for waits
    }

    @FindBy(linkText = "Log in")
    private WebElement loginLink;
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(css = "input[value='Log in']")
    private WebElement loginButton;

    @FindBy(linkText = "Computers")
    private WebElement computersMenu;
    @FindBy(linkText = "Desktops")
    private WebElement desktopsMenu;
    @FindBy(xpath = "(//h2[@class='product-title']/a)[1]") 
    private WebElement secondDesktop;

    @FindBy(id = "product_attribute_72_5_18_65")
    private WebElement ramDropdown;
    @FindBy(id = "product_attribute_72_6_19_55")
    private WebElement hddOption;
    @FindBy(id = "add-to-cart-button-72")
    private WebElement addToCartButton;

    @FindBy(className = "cart-label")
    private WebElement shoppingCartMenu;
    @FindBy(xpath = "//span[text()='Shopping cart']")
    private WebElement goToCartButton;

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstName;
    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastName;
    @FindBy(id = "BillingNewAddress_Email")
    private WebElement billingEmail;
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryDropdown;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    private WebElement stateDropdown;
    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityField;
    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1Field;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCodeField;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@onClick=\"Billing.save()\"]")
    private WebElement billingContinueButton;
    @FindBy(xpath = "//input[@onClick=\"Shipping.save()\"]")
    private WebElement continueShipping;
    @FindBy(xpath = "//input[@id='shippingoption_0']")
    private WebElement shippingOption;
    @FindBy(xpath = "//input[@onClick=\"ShippingMethod.save()\"]")
    private WebElement shippingContinue;
    @FindBy(xpath = "//input[@id='paymentmethod_0']")
    private WebElement cashOnDelivery;
    @FindBy(xpath = "//input[@onClick=\"PaymentMethod.save()\"]")
    private WebElement paymentContinueButton;
    @FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
    private WebElement paymentInfoContinueButton;

    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
    private WebElement confirmButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")
    private WebElement successMessage;

    @FindBy(linkText = "Log out")
    private WebElement logoutButton;
    
    @FindBy(id = "billing-address-select")
    private WebElement billingAddressDropdown;

    @FindBy(xpath = "//option[text()='New Address']")
    private WebElement newAddressOption;

    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void enterLoginDetails(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void navigateToDesktops() {
        wait.until(ExpectedConditions.elementToBeClickable(computersMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(desktopsMenu)).click();
    }

    public void selectSecondDesktop() {
        wait.until(ExpectedConditions.elementToBeClickable(secondDesktop)).click();
    }

    public void selectRAMAndHDD() {
    	
        wait.until(ExpectedConditions.elementToBeClickable(ramDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hddOption)).click();
    }

    public void clickButton(String button) {
        switch (button) {
            case "Add to Cart":
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
                break;
            case "Go to Cart":
                wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
                break;
            case "Checkout":
                wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
                break;
            case "Confirm":
                wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
                break;
        }
    }

    public void openShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartMenu)).click();
    }

    public void selectCheckbox(String checkbox) {
        if (checkbox.equals("I agree with terms")) {
            wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
        }
    }
    
 // Method to check if billing address dropdown is present
    public boolean isBillingAddressDropdownPresent() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(billingAddressDropdown)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to select or add a new billing address
    public void selectOrAddBillingAddress(String addressOption) {
        Select dropdown = new Select(billingAddressDropdown);
        if (addressOption.equals("New Address")) {
            dropdown.selectByVisibleText("New Address");
        } else {
            dropdown.selectByVisibleText(addressOption);
        }
    }
    
    public boolean isNewAddressFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(firstName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillBillingDetails(String fName, String lName, String email, String country, String city, String address1, String zipCode, String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(fName);
        lastName.sendKeys(lName);
        billingEmail.sendKeys(email);

        new Select(wait.until(ExpectedConditions.visibilityOf(countryDropdown))).selectByVisibleText(country);
//        new Select(wait.until(ExpectedConditions.visibilityOf(stateDropdown))).selectByVisibleText(state);

        cityField.sendKeys(city);
        address1Field.sendKeys(address1);
        zipCodeField.sendKeys(zipCode);
        phoneNumberField.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(billingContinueButton)).click();
    }

    public void continueShipping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShipping)).click();
    }

    public void confirmShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinue)).click();
    }

    public void selectPaymentMethod(String method) {
        if (method.equals("Cash on Delivery")) {
            wait.until(ExpectedConditions.elementToBeClickable(cashOnDelivery)).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(paymentContinueButton)).click();
    }

    public void confirmPaymentInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueButton)).click();
    }

    public boolean verifyOrderSuccess() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText().contains("Your order has been successfully processed!");
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
