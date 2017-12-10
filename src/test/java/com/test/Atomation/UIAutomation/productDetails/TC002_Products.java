package com.test.Atomation.UIAutomation.productDetails;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.Atomation.UIAutomation.PageLibrary.ProductDetails;
import com.test.Atomation.UIAutomation.testBase.TestBase;

public class TC002_Products extends TestBase {
	
	ProductDetails productdetails;

	@Test
	public void productSelection() throws InterruptedException {
		waitForSecond(5);
		productdetails.selectProduct(productdetails.faded_Short_Sleeve_Tshirts);
	}

	@BeforeClass
	public void setup() throws IOException {
		init();
		productdetails=new ProductDetails(driver);
	}

	@AfterClass
	public void endTest() {
		closeBrowser();
	}

}
