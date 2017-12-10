package com.test.Atomation.UIAutomation.PageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddToCart {

	WebDriver driver;
	static final Logger logger = Logger.getLogger(AddToCart.class.getName());

	@FindBy(xpath = ".//*[@id='center_column']/div/div/div[3]/p[7]/button[1]")
	private WebElement tweet;

	@FindBy(xpath = ".//*[@id='center_column']/div/div/div[3]/p[7]/button[2]")
	private WebElement fShare;
	
	@FindBy(xpath = "//div[contains(text(),'Log in to your Facebook account to share...')]")
	private WebElement fmsg;

	@FindBy(xpath = ".//*[@id='center_column']/div/div/div[3]/p[7]/button[3]")
	private WebElement googlePlus;

	@FindBy(xpath = ".//*[@id='center_column']/div/div/div[3]/p[7]/button[4]")
	private WebElement printerest;

	@FindBy(css = "#add_to_cart")
	private WebElement addToCart;
	
	
	public void log(String data) {
		logger.info(data);
		Reporter.log(data);
	}
	
	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnFacebookLink() {
		fShare.click();
		log("***clicked on facebook**");
	}

	public void clickOnAddToCart() {
		addToCart.click();
		log("***clicked on addToCart**");
	}

	public void clickOnTweetLink() {
		tweet.click();
		log("***clicked on tweet**");
	}

	public void clickOnGoogleLink() {
		googlePlus.click();
		log("***clicked on googlePlus**");
	}

	public void clickOnPrenterestLink() {
		printerest.click();
		log("***clicked on printerest**");
	}
	
	public boolean verifyFacebookMSG(){

		try {
			fmsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
