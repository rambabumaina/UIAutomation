package com.test.Atomation.UIAutomation.homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.Atomation.UIAutomation.PageLibrary.CreateAnAccount;
import com.test.Atomation.UIAutomation.PageLibrary.Signin;
import com.test.Atomation.UIAutomation.testBase.TestBase;

public class TC002_CreateAnAccount extends TestBase {

	
	Signin sigin;
	CreateAnAccount createAnAccount;
	String firstname="Ramu";
	String lastName="Mmmm";
	String password="Ramu123!";
	String emailAddress="ram"+System.currentTimeMillis()+"@gmail.com";
	
	@BeforeClass
	public void stup() throws IOException {

		init();
	}

	@Test
	public void testRegistration() throws IOException, InterruptedException {
		
		createAnAccount=new CreateAnAccount(driver);
		sigin=new Signin(driver);
		
		sigin.ClickOnSignIn();
		waitForSecond(5);
		sigin.enterEmailToCreateAccount(emailAddress);
		//waitForAnElement(emailAddress, 10)
		sigin.CreateAnAccount();
		
		waitForSecond(5);
		createAnAccount.clickOnMrRadioButton();
		createAnAccount.enterFirstName(firstname);
		createAnAccount.ententerLastName(lastName);
		createAnAccount.ententerPassword(password);
		createAnAccount.selectDaysInDropDown("10");
		createAnAccount.selectMonthInDropDown("July");
		createAnAccount.selectYearInDropDown("2010");
		createAnAccount.enteryourAddFirstName(firstname);
		createAnAccount.enteryourAddLastName(lastName);
		createAnAccount.enteryourAddPrimaryAddress("BTM");
		createAnAccount.enteryourAddSecondaryAddress("Tavarekere");
		createAnAccount.enteryourAddCityName("Bangalore");
		createAnAccount.enteryourAddState("Indiana");
		createAnAccount.enteryourAddPostalCode();
		//createAnAccount.selectyourAddCountry();
		createAnAccount.enteryourAddPhoneNumber();
		createAnAccount.clieckOnRegister();
		
		waitForSecond(10);
		boolean isSuccess=createAnAccount.verifyRegistrationmsg();
		if(isSuccess){
			
			Assert.assertTrue(true, "Ragistration is Pass");
		}else
		{
			Assert.assertTrue(false, "Ragistration is Fail");
		}
	}
	
	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
