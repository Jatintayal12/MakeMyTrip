package com.login;

import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/setting/setting.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("disable-gpu");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("microsoftedge")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
	}

	public static void captureScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extentReportSetup() {
		// configuring extent report
		String reportpath = System.getProperty("user.dir") + "/extentreport/index1.html";
		reporter = new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public void closeReportSetup() {
		extent.flush();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
