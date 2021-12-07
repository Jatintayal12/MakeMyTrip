package com.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.login.TestBase;
import com.pages.FlightPage;

public class FlightTestPage extends TestBase {

	FlightPage fp;

	@BeforeTest
	public void reportSetup() {
		extentReportSetup();
	}

	@BeforeMethod
	public void setup1() {
		// validateloginTest();
		initialization();
		fp = new FlightPage();
	}

	@Test(priority = 2)
	public void validatingFlightBookingTest() throws InterruptedException {
		String from = prop.getProperty("fromsearch");
		String to = prop.getProperty("tosearch");
		String name = prop.getProperty("name");
		String lastname = prop.getProperty("lastname");
		String mobileNo = prop.getProperty("mobileno");
		String enteremail = prop.getProperty("enteremail");
		fp.validateFlightBooking(from, to, name, lastname, mobileNo, enteremail);
	}

	@AfterMethod
	public void closesetup() {
		tearDown();
	}

	@AfterTest
	public void generateReport() {
		closeReportSetup();
	}

}
