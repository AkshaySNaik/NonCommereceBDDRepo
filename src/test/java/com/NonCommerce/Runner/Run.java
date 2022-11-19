package com.NonCommerce.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty","html:BDDReports/reports1.html" },
                 features = {"./Features//NCLoginTest.feature", 
                		     "./Features//Registration.feature",
                		     "./Features//CustomerSearch.feature",
                		     "./Features//OrdersSearch.feature"},
                            glue = "com.NonCommerce.StepDefination", 
                            dryRun = false, 
			                monochrome = true)
public class Run {

	/* Class Not Used */
	
	/* Code That Can be Used Only in BDD(Data Driven) :
	 
	 (DataTable data)
	Map<String, String> hMAp = data.asMap(String.class, String.class);
	
	hMAp.get("String");
	
	
	////////// Javascript code /////////////
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("document.getElementById('OrderStatusIds').value='Processing';");
		 */
}
