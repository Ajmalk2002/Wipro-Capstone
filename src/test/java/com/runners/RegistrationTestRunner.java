package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/registration.feature",
        glue = {"com.registrationsteps","com.hooks"},
        plugin = {
        		    		"pretty",
        		    		"html:target/Cucumber-Reports/cucumber_report.html",
        		    		"json:target/Cucumber-Reports/cucumber_report.json",
        		    		"junit:target/Cucumber-Reports/cucumber_report.xml",
        		    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/Cucumber-Reports" // Extent Report Adapter
        		    	      
        		    }
)
public class RegistrationTestRunner extends AbstractTestNGCucumberTests {
}
