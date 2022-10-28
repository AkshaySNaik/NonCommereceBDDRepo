package com.NonCommerce.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NonCommerceOrderSearch {

	WebDriver ldriver;

	public NonCommerceOrderSearch(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//p[normalize-space()='Sales']")
	WebElement searchOp;

	@FindBy(xpath = "//a[@class='nav-link']//p[contains(text(),'Orders')]")
	WebElement orders;

	@FindBy(xpath = "//span[@aria-controls='EndDate_dateview']//span[@class='k-icon k-i-calendar']")
	WebElement calndr;

	@FindBy(xpath = "//a[@class='k-link k-nav-fast']")
	WebElement monthyrs;

	@FindBy(xpath = "//table//tbody//tr[@role='row']//td")
	List<WebElement> date;

	@FindBy(xpath = "//span[@class='k-icon k-i-arrow-60-left']")
	WebElement previosmontyrs;

	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[2]/div[1]/div[1]/div[5]/div[2]/div")
	WebElement orderstatus;

	@FindBy(xpath = "//li[normalize-space()='Processing']")
	WebElement process;

	@FindBy(xpath = "//*[@id='OrderStatusIds_listbox']//li[2]")
	WebElement pending;

	@FindBy(xpath = "//*[@id='OrderStatusIds_listbox']//li[4]")
	WebElement complete;

	@FindBy(xpath = "//*[@id='OrderStatusIds_listbox']//li[5]")
	WebElement cancelled;

	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[2]/div[1]/div[1]/div[6]/div[2]/div/div")
	WebElement paystatus;

	@FindBy(xpath = "//*[@id=\"PaymentStatusIds_listbox\"]/li[4]")
	WebElement paid;

	@FindBy(xpath = "//*[@id='PaymentStatusIds_listbox']//li[3]")
	WebElement authorized;

	@FindBy(xpath = "//*[@id='PaymentStatusIds_listbox']//li[5]")
	WebElement partiallypaid;

	@FindBy(xpath = "//*[@id='775da1a5-bcc7-4016-9c73-0d562585a37f']")
	WebElement refunded;

	@FindBy(id = "PaymentMethodSystemName")
	WebElement paymethod;

	@FindBy(id = "search-orders")
	WebElement searchOrder;

	@FindBy(xpath = "//table//tbody//tr//td[6]")
	List<WebElement> tabledata;

	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[2]/div[1]/div[1]/div[7]/div[2]/div")
	WebElement shipstatus;
	
	@FindBy(xpath = "//div[@id='ShippingStatusIds-list']//li[5]")
	WebElement shipped;
	
	@FindBy(xpath = "//*[@id='ShippingStatusIds_listbox']/li[3]")
	WebElement notshipped;
	
	
	
	

///////////////////////////  Methods  //////////////////////////////////

	public void clickSearchOption() {

		searchOp.click();
	}

	public void clickSearchOrdersOption() {

		orders.click();
	}

	public void enterOnEndDateCalnder(String dates, String monthyr) {

		calndr.click();

		while (true) {

			if (monthyrs.getText().equalsIgnoreCase(monthyr)) {

				for (WebElement data : date) {

					if (data.getText().equalsIgnoreCase(dates)) {

						data.click();
						break;
					}
				}

				break;
			} else {

				previosmontyrs.click();
			}
		}
	}

	public void clickOrderStatus() {

		orderstatus.click();
	}

	public void selectOrderStatus(String text) {

		if (process.getText().equalsIgnoreCase(text)) {
			process.click();
		}

		else if (pending.getText().equalsIgnoreCase(text)) {
			pending.click();
		}

		else if (complete.getText().equalsIgnoreCase(text)) {
			complete.click();
		}

		else if (cancelled.getText().equalsIgnoreCase(text)) {
			cancelled.click();
		}

	}

	public void clickPaymentStatus() {

		paystatus.click();
	}

	public void selectPaymentStatus(String text) {

		if (partiallypaid.getText().equalsIgnoreCase(text)) {
			partiallypaid.click();
		}

		else if (authorized.getText().equalsIgnoreCase(text)) {
			authorized.click();
		}

		else if (paid.getText().equalsIgnoreCase(text)) {
			paid.click();
		}

		else if (refunded.getText().equalsIgnoreCase(text)) {
			refunded.click();
		}

	}

	public void selectPayMethod(String text) {

		Select select = new Select(paymethod);
		select.selectByVisibleText(text);

	}

	public void clickSearchOrder() {

		searchOrder.click();

	}

	public void clickShippingStatus() {

		shipstatus.click();

	}
	
	public void selectShippingStatus(String text) {

		if (shipped.getText().equalsIgnoreCase(text)) {
			shipped.click();
		}

		else if (notshipped.getText().equalsIgnoreCase(text)) {
			notshipped.click();
		}

	}
	

	public String getOrderStatus() {
		
		String name = null;

		for (WebElement data : tabledata) {

			name = data.getText();
			break;
		}

		return name;
	}

	public String getPageTitle() {

		return (ldriver.getTitle());
	}

}
