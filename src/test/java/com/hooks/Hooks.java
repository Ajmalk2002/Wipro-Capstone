package com.hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
	private static WebDriver driver;

	 @Before
	    public void setup() {
	        String browser = System.getProperty("browser", "edge").toLowerCase(); 

	        System.out.println("Launching browser: " + browser);

	        switch (browser) {
	            case "firefox":
	                driver = new FirefoxDriver();
	                break;
	            case "edge":
	                driver = new EdgeDriver();
	                break;
	            case "chrome":
	            default:
	                driver = new ChromeDriver();
	                break;
	        }

	        driver.manage().window().maximize();
	 }
	 @After
		public void teardown(Scenario scenario) {
			if (scenario.isFailed()) {
				captureScreenshot(scenario.getName());
			}
			System.out.println("Closing browser...");
			if (driver != null) {
				driver.quit();
			}
		}

	public static WebDriver getDriver() {
		return driver;
	}

	public void captureScreenshot(String scenarioName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";

		File destFile = new File("target/screenshots/" + screenshotName);

		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
