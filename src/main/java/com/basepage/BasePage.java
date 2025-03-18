package com.basepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver webDriver;

	public BasePage(WebDriver webDriver) {
		this.setWebDriver(webDriver);
	}

	public WebElement findWebElement(By locator) {
		return getWebDriver().findElement(locator);
	}
	
	public List<WebElement> findWebElements(By locator){
		return getWebDriver().findElements(locator);
	}

	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void onClick(WebElement element) {
		element.click();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
}