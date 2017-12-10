package com.test.Atomation.UIAutomation.customListener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	private int retrycount = 0;
	private int maxretrycount = 3;

	public static Logger logger = Logger.getLogger(Retry.class.getName());

	public boolean retry(ITestResult result) {

		if (retrycount < maxretrycount) {
			log("Retry test" + result.getName() + "With Status" + getresultStatusName(result.getStatus())
					+ "for the" + "time(s).");
			retrycount++;
			return true;
		}
		return false;
	}

	public String getresultStatusName(int status){
		String resultName = null;

		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}

	public void log(String data) {
		logger.info(data);
		Reporter.log(data);
	}

}
