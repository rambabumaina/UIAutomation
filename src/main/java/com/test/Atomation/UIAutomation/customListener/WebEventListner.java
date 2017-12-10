package com.test.Atomation.UIAutomation.customListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListner implements WebDriverEventListener {

	public static final Logger log = Logger.getLogger(WebEventListner.class.getName());

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log("Trying to click on:" + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log("clicked on:" + element.toString());

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log("Trying to find element by:" + by.toString());

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log("found element by" + by.toString());

	}

	public void beforeNavigateBack(WebDriver driver) {
		log("navigating back to the privious page");

	}

	public void afterNavigateBack(WebDriver driver) {
		log("navigated back to the privious page");

	}

	public void beforeNavigateForward(WebDriver driver) {
		log("Navigating forword to the next page");

	}

	public void afterNavigateForward(WebDriver driver) {
		log("Navigated forword to the next page");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		log("After referesh");

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		log("Before Navigate to" + url + "'");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log("After Navigate to" + url + "'");

	}

	public void onException(Throwable error, WebDriver driver) {
		log("Exception Occured:" + error);

	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

}
