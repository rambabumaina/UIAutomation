package com.test.Atomation.UIAutomation.customListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListner implements IAnnotationTransformer{

	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {

		IRetryAnalyzer result=arg0.getRetryAnalyzer();
		
			if(result==null){
				
				arg0.setRetryAnalyzer(Retry.class);
			}
		
	}

}
