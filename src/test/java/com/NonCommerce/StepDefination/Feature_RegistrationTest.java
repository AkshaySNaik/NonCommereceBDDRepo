package com.NonCommerce.StepDefination;

import org.testng.Assert;

import com.NonCommerce.PageObject.NonCommerceRegistrationPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Feature_RegistrationTest extends BaseClass {

	@When("Selected customer option from menu bar")
	public void selected_customer_option_from_menu_bar() throws InterruptedException {

		regpg = new NonCommerceRegistrationPage(driver);
		regpg.clickOnCustMenuOpt();
		regpg.clickCustomeFromCustOptn();
		Thread.sleep(3000);

	}

	@When("click on new user and create a new user")
	public void click_on_new_user_and_create_a_new_user() {

		regpg.clickOnAddNew();
		regpg.enterNewEmail(getRandomStringValue() + "@gmail.com");
		regpg.enterNewPassWord("A123a");
		regpg.enterFirstName("Akshay");
		regpg.enterLastName("Naik");
		regpg.clickGnderMale();
		regpg.chooseDobByCalender("18", "May 2022");
		regpg.enterCompanyName("L&T");
		regpg.clickNewLetter();
		regpg.clickOnTestStore();
		regpg.selectVendor("Vendor 1");
		regpg.enterAdminComm("Admin Comments");

	}

	@When("Save the newely created customer details")
	public void save_the_newely_created_customer_details() {

		regpg.clickSaveNewlyDetails();
	}

	@Then("Success message should be displayed {string}")
	public void success_message_should_be_displayed(String string) {

		boolean success = regpg.getNewCustSucessMess();
		Assert.assertTrue(success);

	}

}
