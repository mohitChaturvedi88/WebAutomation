package com.koovs.web_automation.CustomListeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.koovs.web_automation.TestUtils.TestUtils;
import com.koovs.web_automation.setUp.TestSetUp;

public class RetryListeners extends TestSetUp implements IRetryAnalyzer {

	private int count = 0;
    private static int maxTry = 1; //Run the failed test 2 times
 
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxTry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed and take base64Screenshot

        		
        		try {
        			TestUtils.captureScreenshot();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        		String excepionMessage=Arrays.toString(iTestResult.getThrowable().getStackTrace());
        		testCaseLogger.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
        				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
        		
        		try {

        			testCaseLogger.get().fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>",
        					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.screenshotPath + TestUtils.screenshotName)
        							.build());
        		} catch (IOException e) {

        		}
        		
        		String failureLogg="This Test case got Failed";
        		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        		testCaseLogger.get().log(Status.FAIL, m);
        		
        		
        	    //ExtentReports fail operations
                return true;                                 //Tells TestNG to re-run the test
            }
        }
        else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
	

}
