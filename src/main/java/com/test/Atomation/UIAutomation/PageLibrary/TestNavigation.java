package com.test.Atomation.UIAutomation.PageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestNavigation {

	WebDriver driver;
	Logger logger = Logger.getLogger("Navigate");

	/*
	 * Driver initialization for class Navigate
	 */
	public TestNavigation(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * This Method will select top-Manu at Navigate class
	 * @throws InterruptedException 
	 */
	public void selectTopManu(String manu) throws InterruptedException {
		
		logger.info("****Selecting the manu*****");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/child::li/a[contains(text(),'"+manu+"')]"))
				.click();

	}

}
