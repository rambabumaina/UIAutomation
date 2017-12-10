package com.test.Atomation.UIAutomation.productDetails;

import org.testng.annotations.Test;
import com.test.Atomation.UIAutomation.PageLibrary.TestNavigation;
import com.test.Atomation.UIAutomation.testBase.TestBase;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;

public class TC001_ProductSelection extends TestBase {

	TestNavigation nav;

	@Test
	public void productSelection() throws InterruptedException {
		waitForSecond(5);
		nav.selectTopManu("Dresses");

	}

	@BeforeClass
	public void setup() throws IOException {
		init();
		nav = new TestNavigation(driver);
	}

	@AfterClass
	public void endTest() {
		//closeBrowser();
	}

}
