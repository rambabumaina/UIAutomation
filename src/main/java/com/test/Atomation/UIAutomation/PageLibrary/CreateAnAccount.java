package com.test.Atomation.UIAutomation.PageLibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccount {

	// rammaina@gmail.com

	WebDriver driver;

	static Logger log = Logger.getLogger(CreateAnAccount.class.getName());

	By MrRadioButton = By.xpath(".//*[@id='id_gender1']");
	By MrsRadioButton = By.xpath(".//*[@id='id_gender2']");
	By FirstName = By.xpath(".//*[@id='customer_firstname']");
	By lastname = By.xpath(".//*[@id='customer_lastname']");
	By password=By.xpath("//input[@id='passwd']");

	By CreateAnAccount = By.xpath(".//*[@id='noSlide']/h1");
	By YourpersonalInfo = By.xpath("//*[contains(text(),'personal information')]");

	By email = By.xpath(".//*[@id='email']");
	By days = By.xpath(".//*[@id='days']");
	By months = By.xpath(".//*[@id='months']");
	By years = By.xpath(".//*[@id='years']");

	By signuUpForNewSetler = By.xpath(".//*[@id='newsletter']");
	By receiveSpecialOffers = By.xpath(".//*[@id='optin']");

	By yourAddressFirstname = By.id("firstname");
	By yourAddressLastname = By.id("lastname");
	By yourAddressCompany = By.id("company");
	By yourAddressPrimary = By.id("address1");
	By yourAddressSecondry = By.id("address2");
	By yourAddressCity = By.id("city");
	By yourAddressState = By.id("id_state");
	By yourAddresCountry = By.id("id_country");
	By yourAddressPostalCode = By.id("postcode");
	By yourAddressPhoneNumber = By.id("phone_mobile");
	By yourAddressAlias = By.id("alias");
	By clickOnRegister = By.id("submitAccount");

	/**
	 * Driver initialization for class CreateAnAccount
	 */
	public CreateAnAccount(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * This method will click on MrRadioButton In Create An Account Page
	 */
	public void clickOnMrRadioButton() {
		log.info("Clicking on MrRadioButton");
		driver.findElement(MrRadioButton).click();
	}

	/**
	 * This method will click on MrsRadioButton In Create An Account Page
	 */
	public void clickOnMrsRadioButton() {
		log.info("Clicking on MrsRadioButton");
		driver.findElement(MrsRadioButton).click();
	}

	/**
	 * This method will Enter the First Name on the text Box In Create An
	 * Account Page
	 */
	public void enterFirstName(String firstname) {
		log.info("Entring First Name On The text box");
		driver.findElement(FirstName).sendKeys(firstname);
	}

	/**
	 * This method will Enter Last Name on the text Box In Create An Account
	 * Page
	 */
	public void ententerLastName(String lastName) {
		log.info("Entring First Name On The text box");
		driver.findElement(lastname).sendKeys(lastName);
	}

	/**
	 * This method will Enter Password on the text Box In Create An Account Page
	 */
	public void ententerPassword(String pass) {
		log.info("Entring Password On The text box");
		driver.findElement(password).sendKeys(pass);
	}

	/**
	 * This method will Enter Last Name on the text Box In Create An Account
	 * Page
	 */
	public boolean yourPersonalInfo() {
		log.info("Verifiying your Personal info Label displayed on UI");

		try {
			driver.findElement(YourpersonalInfo).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method will verify Create an account label In Create An Account Page
	 */

	public boolean createAnAccount() {
		log.info("Verifiying your create An Account info Lable displayed on UI");

		try {
			driver.findElement(CreateAnAccount).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method will give you days from dropDown list
	 */
	public void selectDaysInDropDown(String day) {

		log.info("Clicking on the dropDown");
		driver.findElement(days).click();

		String day1 = ".//*[@id='days']/option[";
		String day2 = "]";
		String day3 = day1 + day + day2;
		log.info("Selecting day from dropDown");
		driver.findElement(By.xpath(day3)).click();

	}

	/**
	 * This method will give you months from dropDown list
	 * 
	 * @throws InterruptedException
	 */
	public void selectMonthInDropDown(String month) throws InterruptedException {

		log.info("Clicking on the Month DropDown");
		driver.findElement(months).click();
		Thread.sleep(2000);
		List<WebElement> monthsdata = driver.findElements(By.xpath(".//*[@id='months']/option"));

		for (WebElement mon : monthsdata) {
			if (mon.getText().contains(month)) {

				log.info("Selecting months in DropDown");
				mon.click();
			}
		}
	}

	/**
	 * This method will give you months from dropDown list
	 * 
	 * @throws InterruptedException
	 */
	public void selectYearInDropDown(String year) throws InterruptedException {

		log.info("Clicking on the year DropDown");
		driver.findElement(years).click();
		Thread.sleep(1000);
		List<WebElement> yeardata = driver.findElements(By.xpath(".//select[@id='years']/option"));

		for (WebElement mon : yeardata) {
			if (mon.getText().contains(year)) {

				log.info("Selecting year in DropDown");
				mon.click();
			}
		}
	}

	/**
	 * This method will Enter your address FirstName on the text Box In Create
	 * An Account Page
	 */
	public void enteryourAddFirstName(String yfirstname) {
		log.info("Entring your address First Name On The text box");
		driver.findElement(yourAddressFirstname).sendKeys(yfirstname);
	}

	/**
	 * This method will Enter your address LastName on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddLastName(String ylastname) {
		log.info("Entring your address Last Name On The text box");
		driver.findElement(yourAddressLastname).sendKeys(ylastname);
	}

	/**
	 * This method will Enter your address Company on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddCompany(String company) {
		log.info("Entring your address company On The text box");
		driver.findElement(yourAddressCompany).sendKeys(company);
	}

	/**
	 * This method will Enter your address Primary Address on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddPrimaryAddress(String primary) {
		log.info("Entring your Primary Address On The text box");
		driver.findElement(yourAddressPrimary).sendKeys(primary);
	}

	/**
	 * This method will Enter your address Secondary Address on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddSecondaryAddress(String secondary) {
		log.info("Entring your Secondary Address On The text box");
		driver.findElement(yourAddressSecondry).sendKeys(secondary);
	}

	/**
	 * This method will Enter your address City Name on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddCityName(String city) {
		log.info("Entring your City name On The text box");
		driver.findElement(yourAddressCity).sendKeys(city);
	}

	/**
	 * This method will Enter your address State on the text Box In
	 * CreateAnAccount Page
	 * 
	 * @throws InterruptedException
	 */
	public void enteryourAddState(String state) throws InterruptedException {
		log.info("Selecting your State At DropDown");
		new Select(driver.findElement(yourAddressState)).selectByVisibleText(state);
	}

	/**
	 * This method will Enter your Address Postal Code on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddPostalCode() {
		log.info("Entring your Postal code On The text box");
		driver.findElement(yourAddressPostalCode).sendKeys("00000");
	}

	/**
	 * This method will Select your Address Country from dropdown
	 * CreateAnAccount Page
	 * 
	 * @throws InterruptedException
	 */
	public void selectyourAddCountry() throws InterruptedException {
		log.info(" Clicking on the country");
		driver.findElement(yourAddresCountry).click();
		Thread.sleep(3000);
		
		log.info("Selecting country At DropDown");
		driver.findElement(By.xpath("//*[@id='id_country']/option[2]")).click();
	}

	/**
	 * This method will Enter your Address Mobile Number on the text Box In
	 * CreateAnAccount Page
	 */
	public void enteryourAddPhoneNumber() {
		log.info("Entring Phone Number On The text box");
		driver.findElement(yourAddressPhoneNumber).sendKeys("9999999999");
	}

	/**
	 * This method will Enter your Address Alias on the text Box In
	 * CreateAnAccount Page
	 * 
	 */
	public void enteryourAddAlias() {
		log.info("Entring Alias On The text box");
		driver.findElement(yourAddressAlias).sendKeys("Testing");
	}

	/**
	 * This method will Click On the register Button at CreateAnAccount Page
	 */
	public void clieckOnRegister() {
		log.info("Clicking on the Register button");
		driver.findElement(clickOnRegister).click();
	}

	public boolean verifyRegistrationmsg() {
		String Expectedmsg = driver.findElement(By.xpath(".//*[@id='center_column']/p")).getText();
		String actualMsg = "..Welcome to your account. Here you can manage all of your personal information and orders.";
		if (Expectedmsg.equals(actualMsg)) {
			return true;
		} else
			return false;

	}
}
