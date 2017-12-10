package com.test.Atomation.UIAutomation.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TC001_VeryfyLoginWithInvalidCredentials {

	WebDriver driver;


	@BeforeTest
	public void setup() {
		
		String browser="chrome";
	
		if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://automationpractice.com/index.php");
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
		
		}
	}

	

	@AfterTest
	public void endTest() {

		driver.quit();
	}

}
