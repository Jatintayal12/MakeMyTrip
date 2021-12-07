package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.login.TestBase;

public class FlightPage extends TestBase {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	Actions actions = new Actions(driver);

	public FlightPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='From']")
	WebElement from;
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromsearch;
	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement select;

	@FindBy(xpath = "//span[text()='To']")
	WebElement to;
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement tosearch;
	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement select1;

	@FindBy(xpath = "//label[@for='departure']")
	WebElement departure;
	@FindBy(xpath = "//div[@aria-label='Fri Dec 10 2021']")
	WebElement date;
	// @FindBy(xpath =
	// "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Day']") WebElement
	// date;

	@FindBy(xpath = "//label[@for='travellers']")
	WebElement psngrdetails;
	@FindBy(xpath = "//li[@data-cy='adults-1']")
	WebElement psngrno;
	@FindBy(xpath = "//li[text()='Business']")
	WebElement travelclass;

	@FindBy(xpath = "//button[text()='APPLY']")
	WebElement apply;

	// @FindBy(xpath = "//li[@class='font12 blackText latoBold wrapFilter activeItem
	// ']") WebElement select2;
	@FindBy(xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")
	WebElement searchbtn;
	// @FindBy(xpath = "//button[@class='button actionBtn']")
	// WebElement viewallbtn;
	@FindBy(xpath = "//button[@class='ViewFareBtn  text-uppercase ']/span")
	WebElement ViewButton;
	@FindBy(xpath = "//button[contains(text(), 'Book')]")
	WebElement Bookbutton;

	@FindBy(xpath = "//b[text()='Yes, Secure my trip. ']")
	WebElement insurancebtn;
	@FindBy(xpath = "//div[@class='flightBody']//following-sibling::div[@id='TRAVELLER_DETAIL']//following-sibling::div[@class='otherList']//child::button[@class='addTravellerBtn']")
	WebElement addnewbtn;
	@FindBy(xpath = "//input[@placeholder='First & Middle Name']")
	WebElement name;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;
	@FindBy(xpath = "//label[@tabindex='0']")
	WebElement gender;
	@FindBy(xpath = "//input[@placeholder='Mobile No']")
	WebElement mobileno;
	@FindBy(xpath = "//p[@class='transparentOverlay']")
	WebElement enteremail;
	@FindBy(xpath = "//button[@class='lato-black button buttonPrimary extraPadBtn fontSize16 ']")
	WebElement continuebtn;
	@FindBy(xpath = "//button[@class='button buttonPrimary buttonBig fontSize14']")
	WebElement confirmbtn;
	@FindBy(xpath = "//button[@class='lato-black button buttonPrimary buttonBig fontSize12']")
	WebElement yesbtn;
	@FindBy(xpath = "//button[@class='lato-black button buttonPrimary extraPadBtn fontSize16 ']")
	WebElement confbtn;
	@FindBy(xpath = "//button[@class='lato-black button buttonPrimary extraPadBtn fontSize16']")
	WebElement proceeedtopaybtn;

	public void validateFlightBooking(String a, String b, String c, String d, String e, String f)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='login__card makeFlex hrtlCenter cursorPointer appendBottom10']"))
				.click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("17241a0@gmail.com");
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123@abc$9");
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();

		Thread.sleep(3000);
		from.click();
		wait.until(ExpectedConditions.visibilityOf(fromsearch)).sendKeys(a);
		fromsearch.sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(select)).click();
		select.click();

		to.click();
		wait.until(ExpectedConditions.elementToBeClickable(tosearch)).sendKeys(b);
		tosearch.sendKeys(b);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(select1)).click();

		departure.click();
		date.click();

		Thread.sleep(3000);
		psngrdetails.click();
		psngrno.click();
		travelclass.click();
		Thread.sleep(3000);
		apply.click();

		WebElement menuOption = driver.findElement(By.xpath("//span[text()='Trending Searches:']"));
		actions.moveToElement(menuOption).perform();
		Thread.sleep(3000);
		searchbtn.click();

		Thread.sleep(3000);

		// wait.until(ExpectedConditions.elementToBeClickable(viewallbtn)).click();
		// viewallbtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(ViewButton)).click();
		ViewButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(Bookbutton)).click();
		Bookbutton.click();

		driver.getWindowHandle();
		for (String childTab : driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}

		// WebElement menuOption1 =
		// driver.findElement(By.xpath("//button[@class='addTravellerBtn' and text()='+
		// ADD NEW ADULT']"));
		// actions.moveToElement(menuOption1).perform();
//		if(insurancebtn.isDisplayed()) {
//			insurancebtn.click();
//		}else {
//			addnewbtn.click();
//		}

		// wait.until(ExpectedConditions.elementToBeClickable(insurancebtn)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(addnewbtn)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys(c);
//		wait.until(ExpectedConditions.elementToBeClickable(lastname)).sendKeys(d);
//		wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(mobileno)).sendKeys(e);
//		wait.until(ExpectedConditions.elementToBeClickable(enteremail)).sendKeys(f);
//		wait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();
		// wait.until(ExpectedConditions.elementToBeClickable(confirmbtn)).click();
		// wait.until(ExpectedConditions.elementToBeClickable(yesbtn)).click();
		// wait.until(ExpectedConditions.elementToBeClickable(confbtn)).click();
		// wait.until(ExpectedConditions.elementToBeClickable(proceeedtopaybtn)).click();

	}

	public void validateBooking() {

	}
}
