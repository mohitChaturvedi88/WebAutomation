package com.koovs.web_automation.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.koovs.web_automation.PageObjects.FacebookHomepage;
import com.koovs.web_automation.PageObjects.FacebookLandingPage;
import com.koovs.web_automation.TestUtils.TestUtils;
import com.koovs.web_automation.setUp.TestSetUp;

public class ValidateFacebookLogin extends TestSetUp {
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void validateFBLoginWIthValidCred(Hashtable<String, String> data)
	{
		
		assignAuthor("Mohit Chaturvedi");
		assignCategory("Sanity");
		System.out.println(data.get("username"));
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
		
	}
	
	/*@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void tc_02(Hashtable<String, String> data)
	{
		//System.out.println("tc_02");
		FacebookLandingPage landingPage= new FacebookLandingPage().open();
		FacebookHomepage homePage=landingPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
		
	}
*/
}
