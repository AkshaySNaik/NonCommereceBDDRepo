package com.NonCommerce.StepDefination;

import org.testng.Assert;

import com.NonCommerce.PageObject.NonCommerceCustomerSearch;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Feature_CustSearchTest extends BaseClass {

	@When("Enter lastname as {string} and click on search button")
	public void enter_lastname_as_and_click_on_search_button(String lsname) {

		custserch = new NonCommerceCustomerSearch(driver);
		custserch.enterSearchLastName(lsname);
		custserch.clickSearchButton();
	}

	@Then("Registed customer details needs to display")
	public void registed_customer_details_needs_to_display() throws InterruptedException {

		Thread.sleep(2000);

		String actualResult = custserch.getSearchedOption("Smith");

		if (actualResult.contains("Smith")) {

			Assert.assertTrue(true);

		} else {

			Assert.assertFalse(true);
		}

	}

}
