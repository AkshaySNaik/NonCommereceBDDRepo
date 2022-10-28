package com.NonCommerce.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NonCommerceCustomerSearch {

	WebDriver ldriver;

	public NonCommerceCustomerSearch(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "SearchFirstName")
	WebElement firstname;

	@FindBy(id = "SearchLastName")
	WebElement lastname;

	@FindBy(id = "search-customers")
	WebElement searchname;
	
	@FindBy(xpath = "//table//tbody//tr//td[3]")
	List<WebElement> SearchedOpton;
	
	
	
	
	///////////////////////////////////// Methods /////////////////////////////////////
	
	
	
	public void enterSearchFirstName(String name) {

		firstname.sendKeys(name);
	}

	public void enterSearchLastName(String name) {

		lastname.sendKeys(name);
	}
	
	public void clickSearchButton() {

		searchname.click();
	}
	
	public String getSearchedOption(String serachname) {
		
		String actualtext = null;
		
		for(WebElement datas : SearchedOpton) {
			
		 actualtext = datas.getText();
			
			if(actualtext.contains(serachname)) {
				
				break;
			}
		}
		return actualtext;
	}
	
}
