package com.NonCommerce.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NonCommerceRegistrationPage {

	WebDriver ldriver;

	public NonCommerceRegistrationPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement cust;

	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']//li[1]//a[1]")
	WebElement cust1;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement newCtr;

	@FindBy(id = "Email")
	WebElement newemail;

	@FindBy(id = "Password")
	WebElement newpass;

	@FindBy(id = "FirstName")
	WebElement frstname;

	@FindBy(id = "LastName")
	WebElement lstname;

	@FindBy(id = "Gender_Male")
	WebElement gnml;

	@FindBy(id = "Gender_Female")
	WebElement gnfe;

	@FindBy(id = "DateOfBirth")
	WebElement dob;

	@FindBy(id = "Company")
	WebElement comp;

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement newletter;

	@FindBy(xpath = "//span[@title='delete']")
	WebElement cancelReg;

	@FindBy(xpath = "//li[normalize-space()='Test store 2']")
	WebElement teststore;

	@FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']")
	WebElement selectCustRole;

	@FindBy(id = "VendorId")
	WebElement vendor;

	@FindBy(id = "AdminComment")
	WebElement adminiComm;

	@FindBy(name = "save")
	WebElement saveNewDetail;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement dispMess;

	@FindBy(xpath = "//div[@class='input-group-append input-group-required']")
	WebElement customerRole;

	@FindBy(xpath = "//span[@class='k-icon k-i-calendar']")
	WebElement calender2;

	@FindBy(xpath = "//a[@class='k-link k-nav-fast']")
	WebElement YearMonth;

	@FindBy(xpath = "//a[@title='Wednesday, March 9, 2022']")
	WebElement datee;

	@FindBy(xpath = "//span[@class='k-icon k-i-arrow-60-left']")
	WebElement clickpre;
	
	@FindBy(xpath = "//table//tbody//tr//td")
	List<WebElement> dates;
	
	

////////Methods ////////////////	

	public void clickOnCustMenuOpt() {

		cust.click();
	}

	public void clickCustomeFromCustOptn() {

		cust1.click();
	}

	public void clickOnAddNew() {

		newCtr.click();
	}

	public void enterNewEmail(String email) {

		newemail.sendKeys(email);
	}

	public void enterNewPassWord(String pass) {

		newpass.sendKeys(pass);
	}

	public void enterFirstName(String fname) {

		frstname.sendKeys(fname);
	}

	public void enterLastName(String lname) {

		lstname.sendKeys(lname);
	}

	public void clickGnderMale() {

		gnml.click();
	}

	public void clickGnderFemale() {

		gnfe.click();
	}

	public void enterDob(String dob1) {

		dob.sendKeys(dob1);
	}

	public void chooseDobByCalender(String date, String monthyrs) {

		calender2.click();

		while (true) {

			String monthYear = YearMonth.getText();

			if (monthYear.equalsIgnoreCase(monthyrs)) {

				for (WebElement data : dates) {

					if (data.getText().equalsIgnoreCase(date)) {

						data.click();
						break;
					}
				}
				break;
			}

			else {

				clickpre.click();
			}
		}
	}

	public void enterCompanyName(String cname) {

		comp.sendKeys(cname);
	}

	public void clickNewLetter() {

		newletter.click();
	}

	public void clickTodeSelectReg(String value) {

		Select select = new Select(selectCustRole);
		select.deselectByVisibleText(value);
	}

	public void clickOnTestStore() {

		teststore.click();

	}

	public void clickOnCustomerRole() {

		customerRole.click();
	}

	public void selectCustomerRole(String value) {

		Select select = new Select(selectCustRole);
		select.selectByVisibleText(value);
	}

	public void selectVendor(String venn) {

		Select select = new Select(vendor);
		select.selectByVisibleText(venn);
	}

	public void enterAdminComm(String addcomm) {

		adminiComm.sendKeys(addcomm);
	}

	public void clickSaveNewlyDetails() {

		saveNewDetail.click();
	}

	public boolean getNewCustSucessMess() {

		return dispMess.isDisplayed();
	}

}
