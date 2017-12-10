package com.test.Atomation.UIAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.test.Atomation.UIAutomation.customListener.WebEventListner;

public class TestBase {
	
	public WebDriver dr;
	public EventFiringWebDriver driver;
	public WebEventListner elementListner;
	public static Properties pro;
	public FileInputStream file;
	
	public static Logger logger = Logger.getLogger(TestBase.class.getName());
		
	
	/*
	 * This will print log...
	 */

	public void log(String data){
		logger.info(data);
		Reporter.log(data);
	}

	/**
	 * This Method is used to call, Select Browser And loadPropertyFiles methods
	 * 
	 * @throws IOException
	 */
	public void init() throws IOException {
		log("*******InIT Start**********");
		PropertyConfigurator.configure("Log4j.properties");

		pro = new Properties();
		loadPropertyFiles();

		selectBrowser(pro.getProperty("browser"));
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();

		log("Application URL loaded");
		log("*******InIT end**********");
	}

	/**
	 * This Method will close the browser...
	 */
	public void closeBrowser() {

		driver.quit();
		log("***Browser Closed***");
	}

	/**
	 * This Method will get you property files
	 * 
	 * @throws IOException
	 */
	public void loadPropertyFiles() throws IOException {

		file = new FileInputStream(new File(System.getProperty("user.dir")
				+ "/src/main/java/com/test/Atomation/UIAutomation/config/config.properties"));
		pro.load(file);
	}

	/**
	 * This method will give you all windows...
	 * 
	 * @return
	 */
	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}

	/**
	 * This Method of TestBase will allow you to select Browser
	 * 
	 * @param browser
	 * @return
	 */
	public void selectBrowser(String browser) {
		log("*******Select Browser started**********");
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			System.out.println("FireFox Browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			log("Creating object of" + browser);
			dr = new FirefoxDriver();
			// *******Webelement Listner*************
			driver = new EventFiringWebDriver(dr);
			elementListner = new WebEventListner();
			driver.register(elementListner);
			// *******Webelement Listner*************
			// return driver;
		}

		if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("Chrome Browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			log("Creating object of" + browser);
			dr = new ChromeDriver();
			// *******Webelement Listner*************
			driver = new EventFiringWebDriver(dr);
			elementListner = new WebEventListner();
			driver.register(elementListner);
			// *******Webelement Listner*************
			driver = new EventFiringWebDriver(dr);
			
			// return driver;
		}

		if (browser.equals("IE") || browser.equals("ie")) {
			System.out.println("Chrome Browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/");
			dr = new InternetExplorerDriver();
			// *******Webelement Listner*************
			driver = new EventFiringWebDriver(dr);
			elementListner = new WebEventListner();
			driver.register(elementListner);
			// *******Webelement Listner*************
			// return driver;
		}
		// return null;
	}

	/**
	 * This method will allow you to wait for given time in Seconds
	 * 
	 * @param sec
	 * @throws InterruptedException
	 */
	public void waitForSecond(int sec) {
		try {
			log(sec + "**Second sleep time***");
			Thread.sleep(sec * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will wait For an Element visible
	 */
	public WebElement waitForAnElement(WebElement element, long time) {
		log(time + "***waiting for an element to be appeared***");
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will will return title of the page
	 */
	public String getTitle() {
		log("***getting title***");
		return driver.getTitle();
	} 

	/**
	 * This method will capture Screenshot
	 */

	public void getScreenshot(String imgname) {
		log("***Capturing ScreenShot***");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/test/Atomation/UIAutomation/screenshot/";
			File dest = new File((String) reportdirectory + imgname + "_" + formater.format(cal.getTime()) + ".png");
			FileUtils.copyFile(srcfile, dest);

			log("*** ScreenShot Captured***");

			// this will help to link screenshot in the report

			Reporter.log("<a href='" + dest.getAbsolutePath() + "'> <img src='" + dest.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	

}
