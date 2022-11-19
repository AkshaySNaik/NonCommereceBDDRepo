package com.NonCommerce.StepDefination;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.NonCommerce.PageObject.NonCommerceLoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Feature_LoginTest extends BaseClass {

	@Before
	public void setUp() {

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "internetexplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			driver = null;
			break;
		}

		log = LogManager.getLogger(BaseClass.class.getName());

		driver.manage().window().maximize();
		log.info("Window Maximized");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Time Out Set For 10sec");

	}

    @After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed() == true) {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				String srcpath = System.getProperty("user.dir") + "//Screenshot//index.png";
				FileUtils.copyFile(src, new File(srcpath));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		driver.quit();
	}

	@Given("User lanches browser")
	public void user_lanches_browser() {

	}

	@When("User opens URL")
	public void user_opens_url() {

		driver.get(URL);
		log.info("URL Opened");

	}

	@And("Enters username as {string} and password as {string} into the fields")
	public void enters_username_as_admin_yourstore_com_and_password_as_admin_into_the_fields(String username,
			String password) {

		loginpg = new NonCommerceLoginPage(driver);
		loginpg.enterRegEmailId(username);
		loginpg.enterRegPassword(password);

	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {

		loginpg.clickOnLogin();
		log.info("User logedIn");

	}

	@Then("Admin page should be displayed")
	public void admin_page_should_be_displayed() {

		String title = loginpg.getPageTitle();

		Assert.assertEquals(title, "Dashboard / nopCommerce administration");

	}

	@Then("Logout and close the browser")
	public void logout_and_close_the_browser() {

		loginpg.clickOnLogout();
		log.info("User logedOut");
	}

/////////////////////// Scenario 2 For Invalid Credentials /////////////////////// ///////////////////////

	@Then("Admin page should not be displayed")
	public void admin_page_should_not_be_displayed() {

		String actloginerrormsg = loginpg.getPageTitle();

		log.info("Error Message :" + actloginerrormsg);

		String expectloginerrormsg = "Your store. Login";

		Assert.assertEquals(actloginerrormsg, expectloginerrormsg);

	}

}
