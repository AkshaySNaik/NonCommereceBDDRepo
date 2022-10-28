package com.NonCommerce.StepDefination;

import org.testng.Assert;

import com.NonCommerce.PageObject.NonCommerceOrderSearch;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Feature_OrderSearchTest extends BaseClass {

	@When("Selected sales option from menu bar")
	public void selected_sales_option_from_menu_bar() {

		orderserch = new NonCommerceOrderSearch(driver);
		orderserch.clickSearchOption();
	}

	@When("User clicks on orders option")
	public void user_clicks_on_orders_option() {

		orderserch.clickSearchOrdersOption();
	}

	@Then("Orders page should be displayed with pagetitle {string}")
	public void orders_page_should_be_displayed_with_pagetitle(String string) {

		String title = orderserch.getPageTitle();
		Assert.assertEquals(title, string);

	}

	@When("Entered all the deatlis for OrderSearch")
	public void entered_all_the_deatlis_for_order_search() {

		orderserch.enterOnEndDateCalnder("13", "March 2020");
		orderserch.clickOrderStatus();
		orderserch.selectOrderStatus("Processing");
		orderserch.clickPaymentStatus();
		orderserch.selectPaymentStatus("Paid");
		orderserch.selectPayMethod("Check / Money Order");
	}

	@When("User clicks on searchbutton")
	public void user_clicks_on_searchbutton() {

		orderserch.clickShippingStatus();
		orderserch.selectShippingStatus("Not yet shipped");
		orderserch.clickSearchOrder();

	}

	@Then("Verify the Shipping status of the order")
	public void verify_the_shipping_status_of_the_order() throws InterruptedException {

		Thread.sleep(3000);

		String Email = orderserch.getOrderStatus();

		if (Email.equalsIgnoreCase("steve_gates@nopCommerce.com")) {

			Assert.assertTrue(true);
		} else {

			Assert.fail();
		}

	}

}
