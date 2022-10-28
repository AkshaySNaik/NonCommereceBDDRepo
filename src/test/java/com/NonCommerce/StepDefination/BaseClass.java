package com.NonCommerce.StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.NonCommerce.PageObject.NonCommerceCustomerSearch;
import com.NonCommerce.PageObject.NonCommerceLoginPage;
import com.NonCommerce.PageObject.NonCommerceOrderSearch;
import com.NonCommerce.PageObject.NonCommerceRegistrationPage;
import com.NonCommerce.Utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logg;
	public NonCommerceLoginPage loginpg;
	public NonCommerceRegistrationPage regpg;
	public NonCommerceCustomerSearch custserch;
	public NonCommerceOrderSearch orderserch;

	ReadConfig readcon = new ReadConfig();

	String browser = readcon.getBrowser();
	String URL = readcon.getUrl();

	public String getRandomStringValue() {

		return RandomStringUtils.randomAlphabetic(5);
	}

}
