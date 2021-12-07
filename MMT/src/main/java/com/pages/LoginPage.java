package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.login.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//div[@class='login__card makeFlex hrtlCenter cursorPointer appendBottom10']"))
	WebElement loginWithPhoneEmail;
	@FindBy(xpath = "//input[@id='username']")
	WebElement data;
	@FindBy(xpath = "//button[@class='capText font16']")
	WebElement continuee;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(id = "otp")
	WebElement otp;

	@FindBy(xpath = "//button[@class='capText font16']")
	WebElement login;
	@FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
	WebElement cross;

	@FindBy(xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")
	WebElement searchbtn;

	@FindBy(xpath = "//span[text()='Hotels']")
	WebElement Hotels;
	@FindBy(xpath = "//button[text()='Search']")
	WebElement hotelssearchbtn;
	@FindBy(xpath = "//span[text()='Invalid phone number']")
	WebElement message;
	@FindBy(xpath = "//span[text()='Either Username or Password is incorrect.']")
	WebElement message1;

	public String validateTitle() {

		return driver.getTitle();
	}

	public DashboardPage validatemail(String user, String pass) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginWithPhoneEmail.click();
		data.sendKeys(user);
		TestBase.captureScreenshot(driver, "email");
		continuee.click();
		password.sendKeys(pass);
		TestBase.captureScreenshot(driver, "Password");
		login.click();
		Thread.sleep(3000);
		TestBase.captureScreenshot(driver, "loginpage");
		return new DashboardPage();
	}

	public String validatpassword(String user, String pass) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginWithPhoneEmail.click();
		data.sendKeys(user);
		continuee.click();

		password.sendKeys(pass);
		login.click();
		// TestBase.captureScreenshot(driver, "invalid_pass");
		String text = message1.getText();
		TestBase.captureScreenshot(driver, "invalid_pass");
		System.out.println(text);
		return text;

	}

	public DashboardPage validateNumber(String user) {
		loginWithPhoneEmail.click();
		data.sendKeys(user);

		TestBase.captureScreenshot(driver, "Phoneno");
		continuee.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		return new DashboardPage();
	}

	public String validateNumber1(String user) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginWithPhoneEmail.click();
		data.sendKeys(user);
		TestBase.captureScreenshot(driver, "invalid_Phoneno");
		continuee.click();
//		Thread.sleep(3000);
		String text = message.getText();
		System.out.println(text);
		return text;
	}

	public static void teardown() {
		driver.quit();
	}

}
