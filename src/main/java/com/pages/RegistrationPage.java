package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basepage.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(webDriver,this);
	}
	
	@FindBy(id = "FirstName")
	 WebElement firstnameWebElement;
	@FindBy(id = "LastName")
	 WebElement lastnameWebElement;
	@FindBy(id = "Email")
	 WebElement emailWebElement;
	@FindBy(id = "Password")
	 WebElement passwordWebElement;
	@FindBy(id = "ConfirmPassword")
	 WebElement confirmpasswordWebElement;
	@FindBy(id = "register-button")
	 WebElement registerbuttonWebElement;
	@FindBy(xpath="//span[@For=\"ConfirmPassword\"]")
	WebElement passwordnotmatchWebElement;
	@FindBy(xpath = "//span[@For=\"FirstName\"]")
	WebElement firstnameerrorWebElement;
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement wrongemailWebElement;
	@FindBy(xpath ="//div[@class=\"result\"]")
	WebElement successWebElement;
	@FindBy(xpath = "//div[@class='validation-summary-errors']")
	WebElement errorMessageWebElement;
	public void setFirstName(String fn) {

		enterText(firstnameWebElement,fn);
	}
	public void setLastName(String ln) {
		enterText(lastnameWebElement,ln);
		
	}
	public void setEmail(String email) {
		enterText(emailWebElement,email);
	}
	public void setPassword(String password) {
		enterText(passwordWebElement,password);
	}
	public void setConfirmPassword(String confirmpassword) {
		enterText(confirmpasswordWebElement,confirmpassword);
	}
	public void click() {
		onClick(registerbuttonWebElement);
	}
	public void getPasswordDoNotMatchMsg() {
		passwordnotmatchWebElement.getText();
	}
	public void getFirstNameErrorMsg() {
		firstnameerrorWebElement.getText();
	}
	public void getWrongEmailMsg() {
		wrongemailWebElement.getText();
	}
	public void getSuccessMsg() {
		successWebElement.getText();
	}
	
	public void getErrorMessage() {
		errorMessageWebElement.getText();
	}
	
	
}
