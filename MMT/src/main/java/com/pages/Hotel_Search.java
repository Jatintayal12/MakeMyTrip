package com.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.login.TestBase;

public class Hotel_Search extends TestBase {

	public Hotel_Search() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@data-cy='menu_Hotels']")
	WebElement hotelbutton;

	@FindBy(xpath = "//span[@class='lbl_input latoBold  appendBottom5']")
	WebElement citybutton;
	@FindBy(xpath = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	WebElement data;

//		@FindBy(xpath = "//ul[@role='listbox']/li")
	@FindBy(xpath = "//p[text()='Bangalore, Karnataka, India']")
	WebElement select;
	@FindBy(id = "checkin")
	WebElement checkindate;
	@FindBy(xpath = "//div[@class='DayPicker-Day'][contains(@aria-label,'Dec 14 2021')]")
	WebElement indate;

	@FindBy(id = "checkout")
	WebElement checkoutdate;
	@FindBy(xpath = "//div[@class='DayPicker-Day'][contains(@aria-label,'Dec 15 2021')]")
	WebElement outdate;
	@FindBy(id = "guest")
	WebElement travellers;
	@FindBy(xpath = "//li[@data-cy='adults-3']")
	WebElement adults;
	@FindBy(xpath = "//li[@data-cy='children-1']")
	WebElement children;
	@FindBy(xpath = "//select[@class='ageSelectBox']")
	WebElement age;
	@FindBy(xpath = "//option[@data-cy='childAgeValue-5']")
	WebElement childage;
	@FindBy(xpath = "//button[text()='APPLY']")
	WebElement apply;
	@FindBy(id = "hsw_search_button")
	WebElement search;
	@FindBy(xpath = "//div[@class='makeFlex flexOne padding20 relative lftCol']")
	WebElement hotel;
	@FindBy(xpath = "//a[@class='primaryBtn ']")
	WebElement room;
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;
	@FindBy(xpath = "//input[@placeholder='Email ID']")
	WebElement email;
	@FindBy(xpath = "//input[@placeholder='Contact Number']")
	WebElement number;
	@FindBy(xpath = "//label[@for='bookEntireNow']")
	WebElement paymentoption;
	@FindBy(xpath = "//a[@class='btnContinuePayment primaryBtn capText  ']")
	WebElement pay;

	public String validateSearchhotel(String a) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='login__card makeFlex hrtlCenter cursorPointer appendBottom10']"))
				.click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("17241a0@gmail.com");
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123@abc$9");
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();

		Thread.sleep(3000);
		hotelbutton.click();
		citybutton.click();
		data.sendKeys(a);
		select.click();

		indate.click();
		outdate.click();
		travellers.click();
		adults.click();
		children.click();
		age.click();
		childage.click();
		apply.click();
		TestBase.captureScreenshot(driver, "searchpage");
		search.click();
		Thread.sleep(3000);
		TestBase.captureScreenshot(driver, "aftersearch");
		String title = driver.getTitle();
		return title;

		/*
		 * List<WebElement>
		 * listofcities=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		 * for(WebElement element:listofcities) { if(element.getText().trim().equals(a))
		 * { element.click(); break; } } checkindate.click(); date.click(); //
		 * checkoutdate.click(); returndate.click(); travellers.click(); count.click();
		 * 
		 * apply.click();
		 */

	}

	public String hotelselection() throws InterruptedException {
		String ParentWindow = driver.getWindowHandle();

		hotel.click();
		Thread.sleep(3000);
		TestBase.captureScreenshot(driver, "hotelselected");
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();
		it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='primaryBtn ']")));
		room.click();
		Thread.sleep(3000);
		TestBase.captureScreenshot(driver, "hotelbookingpage");
		String title = driver.getTitle();
		return title;

	}

	public void hotelbook(String a, String b) throws InterruptedException {
		firstname.sendKeys(a);
		lastname.sendKeys(b);

		//paymentoption.click();
		pay.click();
		Thread.sleep(3000);
		TestBase.captureScreenshot(driver, "paymentpage");

	}

	public void hotelbookinvalid(String a, String b) throws InterruptedException {
		firstname.sendKeys(a);
		lastname.sendKeys(b);

		//paymentoption.click();
		pay.click();
		Thread.sleep(3000);

	}

	public void hotelbook1(String a, String b, String c, String d) throws InterruptedException {
		firstname.sendKeys(a);
		lastname.sendKeys(b);
		email.clear();
		Thread.sleep(3000);
		email.sendKeys(c);
		number.clear();
		Thread.sleep(3000);
		number.sendKeys(d);
		//paymentoption.click();
		pay.click();
		Thread.sleep(3000);
		TestBase.captureScreenshot(driver, "invalid mail and mobile");

	}

	public static void teardown() {
		driver.quit();
	}

}
