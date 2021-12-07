package com.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.login.TestBase;
import com.pages.Hotel_Search;

public class Hotel_SearchTest extends TestBase {

	Hotel_Search hs = new Hotel_Search();

	@BeforeTest
	public void reportSetup() {
		extentReportSetup();
	}

	@BeforeMethod
	public void setup1() {
		initialization();
		hs = new Hotel_Search();
	}

	@Test(priority = 1)
	public void validatesearchhotelTest() throws InterruptedException {
		String city = prop.getProperty("cityName");
		String actual = hs.validateSearchhotel(city);
		String expected = "MakeMyTrip";
		AssertJUnit.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void hotelselectionTest() throws InterruptedException {
		String city = prop.getProperty("cityName");
		String actual = hs.validateSearchhotel(city);
		String actualtitle = hs.hotelselection();
		System.out.println(actualtitle);
	}

	@Test(priority = 3)
	public void hotelbookTest() throws InterruptedException {
		String city = prop.getProperty("cityName");
		String actual = hs.validateSearchhotel(city);
		String actualtitle = hs.hotelselection();
		String name = prop.getProperty("firstname");
		String initial = prop.getProperty("lastname");
		hs.hotelbook(name, initial);
	}

	@Test(priority = 4)
	public void invalidfirstnameTest() throws InterruptedException {
		String city = prop.getProperty("cityName");
		String actual = hs.validateSearchhotel(city);
		String actualtitle = hs.hotelselection();
		String name = prop.getProperty("in_name");
		String initial = prop.getProperty("lastname");
		hs.hotelbookinvalid(name, initial);
		TestBase.captureScreenshot(driver, "invalidfirstname");
	}

	@Test(priority = 5)
	public void invalidlastnameTest() throws InterruptedException {
		String city = prop.getProperty("cityName");
		String actual = hs.validateSearchhotel(city);
		String actualtitle = hs.hotelselection();
		String name = prop.getProperty("firstname");
		String initial = prop.getProperty("in_name");
		hs.hotelbookinvalid(name, initial);
		TestBase.captureScreenshot(driver, "invalidlastname");
	}

	@Test(priority = 6)
	public void invalidmailTest() throws InterruptedException {
		String city = prop.getProperty("cityName");
		String actual = hs.validateSearchhotel(city);
		String actualtitle = hs.hotelselection();
		String name = prop.getProperty("firstname");
		String initial = prop.getProperty("lastname");
		String mail = prop.getProperty("mail");
		String phone = prop.getProperty("in_phone");
		hs.hotelbook1(name, initial, mail, phone);
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
