package com.test.Atomation.UIAutomation.homePage;

import org.testng.annotations.Test;

import com.test.Atomation.UIAutomation.PageLibrary.Signin;
import com.test.Atomation.UIAutomation.testBase.TestBase;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC001_TestLogin extends TestBase {
	
	String title="My account - My Store";
	Signin sin;
	
	@Test
	public void testLogin() throws InterruptedException {

		
		sin.ClickOnSignIn();
		waitForSecond(10);
		sin.enterAlreadyRegisterUserEmail("rammaina@gmail.com");
		sin.enterAlreadyRegisterUserPass("password1");
		sin.ClickOnSignInToAccount();
		waitForSecond(10);
		 Assert.assertEquals(true,sin.getLogOut()); 
	}

	@BeforeClass
	public void setup() throws IOException {
		init();
		sin = new Signin(driver);

	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();

	}

}
