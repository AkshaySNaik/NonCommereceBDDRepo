package com.NonCommerce.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NonCommerceLoginPage {

	WebDriver ldriver;

	public NonCommerceLoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement emailadd;

	@FindBy(id = "Password")
	WebElement passwrd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	@FindBy(xpath = "//img[@class='brand-image-xl logo-xl']")
	WebElement nclogo;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath ="//li[normalize-space()='No customer account found']")
	WebElement errormsg;

//////// Methods ////////////////	

	public void enterRegEmailId(String email) {

		emailadd.clear();
		emailadd.sendKeys(email);
	}

	public void enterRegPassword(String Pass) {

		passwrd.clear();
		passwrd.sendKeys(Pass);
	}

	public void clickOnLogin() {

		login.click();
	}

	public String getPageTitle() {

		return ldriver.getTitle();
	}

	public boolean displayedLogo() {

		return nclogo.isDisplayed();
	}

	public void clickOnLogout() {
		
		logout.click();
	}
	
	public String getLoginErrorMessg() {
		
		return (errormsg.getText());
	}

}
