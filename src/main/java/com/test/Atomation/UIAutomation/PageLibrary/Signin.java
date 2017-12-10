package com.test.Atomation.UIAutomation.PageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.Atomation.UIAutomation.testBase.TestBase;

public class Signin {

	/**
	 * http://automationpractice.com/index.php
	 * UserName: rammaina@gmail.com
	 * Password: password
	 */

	WebDriver driver;
	TestBase testbase;

	static final Logger log = Logger.getLogger(Signin.class.getName());

	By SignIN = By.xpath("//a[contains(text(),'Sign in')]");

	By CreateAccEmailAddr = By.xpath("//*[@id='email_create']");
	By CreateAnAccount = By.xpath(".//*[@id='SubmitCreate']");

	By AlreadyRegUserEmailAddr = By.xpath(".//*[@id='email']");
	By AlreadyRegUserPassword = By.xpath(".//*[@id='passwd']");
	By SubmitButton = By.xpath("//*[@id='SubmitLogin']");
	By FrogotYourPass = By.xpath(".//*[text()='Forgot your password?']");
	
	By SignOut=By.xpath(".//*[text()='Sign out']");
	
	
	/**
	 *  Driver initialization for class Signin
	 */
	public Signin(WebDriver driver){
		
		this.driver=driver;
		testbase=new TestBase();
	}

	
	/**
	 * This method will click on Sign in link In SignIN Page
	 */
	public void ClickOnSignIn() {
		log.info("clicking on SignIn Button");
		driver.findElement(SignIN).click();
	}

	/**
	 * This method will enter email address to the create an account text box In
	 * SignIN Page
	 * 
	 * @param emailAddress
	 */
	public void enterEmailToCreateAccount(String emailAddress) {
		log.info("Enter Email Address to create an account");
		driver.findElement(CreateAccEmailAddr).sendKeys(emailAddress);
	}

	/**
	 * This Method will Click on CreateAnAccount Button In SignIN Page
	 */
	public void CreateAnAccount() {
		log.info("Clicking on the Submit Button To Create An Account");
		driver.findElement(CreateAnAccount).click();
	}

	/**
	 * This method will enter email address to the text box In SignIN Page
	 * 
	 * @param emailAddress
	 */
	public void enterAlreadyRegisterUserEmail(String emailAddress) {
		log.info("Entring Email adress to the text box");
		driver.findElement(AlreadyRegUserEmailAddr).sendKeys(emailAddress);
	}
	
	/*
	 * This will Verify Sign out is displayed or not
	 */
	public boolean getLogOut(){
		
		try {
			driver.findElement(SignOut).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method will enter Password to the text box In SignIN Page
	 * 
	 * @param Password
	 */
	public void enterAlreadyRegisterUserPass(String Password) {
		log.info("Entring Password to the text box");
		driver.findElement(AlreadyRegUserPassword).sendKeys(Password);
	}

	/**
	 * This method will Click on the SignIn Button to LogIN In SignIN Page
	 */
	public void ClickOnSignInToAccount() {
		log.info("clicking on SignIn to the account");
		driver.findElement(SubmitButton).click();
	}

	/**
	 * This method will click on the Forgot Password lick In SignIN Page
	 */
	public void ClickOnForgotPassword() {
		log.info("Clicking on Forgot Password");
		driver.findElement(FrogotYourPass).click();
	}

	/**
	 * This method used to login to the application
	 */
	public void signingToApplication() throws InterruptedException{
		testbase.waitForSecond(3);
		ClickOnSignIn();
		
		testbase.waitForAnElement(driver.findElement(AlreadyRegUserEmailAddr), 10);
		enterAlreadyRegisterUserEmail("rammaina@gmail.com");
		enterAlreadyRegisterUserPass("password");
		ClickOnSignInToAccount();
	}
}
