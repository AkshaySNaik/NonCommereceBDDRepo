package com.NonCommerce.StepDefination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

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
	public static Logger log;
	public NonCommerceLoginPage loginpg;
	public NonCommerceRegistrationPage regpg;
	public NonCommerceCustomerSearch custserch;
	public NonCommerceOrderSearch orderserch;

	ReadConfig readcon = new ReadConfig();

	String browser = readcon.getBrowser();
	String URL = readcon.getUrl();

	// Get Random String Values From RandomStringUtils
	public String getRandomStringValue(int number) {

		return RandomStringUtils.randomAlphabetic(number);
	}

	// Get Random Integer Values From Random Class
	public int getRandomIntValue(int number) {

		Random random = new Random();
		return (random.nextInt(number));

	}

	// JDBC Connection For DataBase Testing
	public void JDBCTest(String connection, String sqlstatment) {

		try {

			Connection conection = DriverManager.getConnection(connection);

			Statement statement = conection.createStatement();
			statement.execute(sqlstatment);

			conection.close();

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}


}
