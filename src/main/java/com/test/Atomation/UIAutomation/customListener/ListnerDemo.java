package com.test.Atomation.UIAutomation.customListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.Atomation.UIAutomation.testBase.TestBase;

public class ListnerDemo extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log("Test is Started" + result.getMethod().getMethodName() + "at:" + result.getStartMillis());

	}

	public void onTestFailure(ITestResult result) {
		if (!result.isSuccess()) {

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");

			String methodName = result.getName();

			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {

				String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/main/java/com/test/Atomation/UIAutomation/";
				File dest = new File((String) reportdirectory + "/onFailureScreenshot/" + methodName + "_"
						+ formater.format(cal.getTime()) + ".png");

				FileUtils.copyFile(srcfile, dest);

				// this will help to link screenshot in the report

				Reporter.log("<a href='" + dest.getAbsolutePath() + "'> <img src='" + dest.getAbsolutePath()
						+ "' height='100' width='100'/> </a>");

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	
	public void onTestSuccess(ITestResult result) {
		
		if (result.isSuccess()) {

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");

			String methodName = result.getName();

			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {

				String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/main/java/com/test/Atomation/UIAutomation/";
				File dest = new File((String) reportdirectory + "/onSuccessScreenshot/" + methodName + "_"
						+ formater.format(cal.getTime()) + ".png");

				FileUtils.copyFile(srcfile, dest);

				// this will help to link screenshot in the report

				Reporter.log("<a href='" + dest.getAbsolutePath() + "'> <img src='" + dest.getAbsolutePath()
						+ "' height='100' width='100'/> </a>");

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}
	
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test is Skipped" + result.getMethod().getMethodName() + "at:" + result.getStartMillis());

	}


	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
