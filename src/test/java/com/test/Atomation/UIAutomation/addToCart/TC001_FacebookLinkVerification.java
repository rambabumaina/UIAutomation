package com.test.Atomation.UIAutomation.addToCart;

import java.io.IOException;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.Atomation.UIAutomation.PageLibrary.AddToCart;
import com.test.Atomation.UIAutomation.PageLibrary.ProductDetails;
import com.test.Atomation.UIAutomation.testBase.TestBase;

public class TC001_FacebookLinkVerification extends TestBase {

	AddToCart add;
	ProductDetails pd;

	@Test
	public void addToCart() {

		log("======Facebook MSG verification Started=========");
		try {
			waitForSecond(5);
			pd = new ProductDetails(driver);
			pd.selectProduct(pd.faded_Short_Sleeve_Tshirts);
			waitForSecond(10);
			add.clickOnFacebookLink();
			waitForSecond(10);
			Iterator<String> itr = getAllWindows();
			String parentwindow = itr.next();
			String childwindow = itr.next();
			log("--Switching the window--");
			driver.switchTo().window(childwindow);
			boolean status = add.verifyFacebookMSG();
			waitForSecond(5);
//		driver.switchTo().window(child window).close();
			driver.switchTo().window(parentwindow);
			Assert.assertEquals(true, status);
		} catch (Exception e) {
			log(e.fillInStackTrace().toString());
		}
		log("=======Facebook MSG verification end==========");
		
	}

	@BeforeClass
	public void setup() throws IOException {

		init();
		add = new AddToCart(driver);

	}

	@AfterClass
	public void endTest() {
	 closeBrowser();

	}

}
