package com.test.Atomation.UIAutomation.PageLibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {

	static final Logger log = Logger.getLogger(ProductDetails.class.getName());

	WebDriver driver;

	public final String blouse = "Blouse";
	public final String faded_Short_Sleeve_Tshirts = "Faded Short Sleeve T-shirts";

	@FindBy(xpath = ".//*[@id='homefeatured']/li/div/div[2]/h5/a")
	List<WebElement> products;

	public ProductDetails(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	/*
	 * This method will allow you to select products in the Home Page.
	 */
	public void selectProduct(String product) {
		driver.findElement(By.xpath(".//*[contains(text(),'" + product + "')]")).click();
		log.info(product + "has been selected");
	}

	/**
	 * This will return list of all products...
	 */
	public List<WebElement> selectProduct() {
		List<WebElement> element = products;
		return element;

	}

}
