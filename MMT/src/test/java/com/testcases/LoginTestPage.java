package com.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.login.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginTestPage extends TestBase {

	LoginPage lp;
	DashboardPage dp;

	@BeforeTest
	public void reportSetup() {
		extentReportSetup();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void validateTitleTest() {

		String expectedtitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String actuatitle = lp.validateTitle();
		AssertJUnit.assertEquals(actuatitle, expectedtitle);
	}

	@Test(priority = 2)
	public void validateLoginTest() throws InterruptedException {
		String a = prop.getProperty("email");
		String b = prop.getProperty("key");
		dp = lp.validatemail(a, b);
		if (dp != null)
			AssertJUnit.assertTrue(true);
		else
			AssertJUnit.assertTrue(false);
	}

	@Test(priority = 3)
	public void validateLogin2Test() {
		String a = prop.getProperty("email");
		String b = prop.getProperty("key1");
		String actual = lp.validatpassword(a, b);
		String expected = "Either Username or Password is incorrect.";
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void validatelogin3() {
		String a = prop.getProperty("Phone");
		dp = lp.validateNumber(a);
	}

	@Test(priority = 5)
	public void validatelogin4() {
		String a = prop.getProperty("in_phone");
		String actual = lp.validateNumber1(a);
		String expected = "Invalid phone number";
		AssertJUnit.assertEquals(actual, expected);
	}


	@AfterMethod
	public void closesetup() throws InterruptedException {
		Thread.sleep(3000);
		tearDown();
	}
	
	@AfterTest
	public void generateReport() {
		closeReportSetup();
	}


}
