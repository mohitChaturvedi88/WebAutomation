package com.koovs.web_automation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.koovs.web_automation.TestUtils.BasePage;

public class FacebookLandingPage extends BasePage{


	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginButton;
	
	public  FacebookLandingPage open()
	{
		return (FacebookLandingPage) openPage(FacebookLandingPage.class);
	}
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginButton);
	}
	
	

	public FacebookHomepage doLoginWithValidCredentials(String email,String pass)
	{
		type(userName, email, "userName");
		type(password, pass, "password");
		click(loginButton, "loginButton");
		return (FacebookHomepage) openPage(FacebookHomepage.class);
	}
	
	public FacebookLandingPage doLoginWithInValidCredentials(String email,String pass)
	{
		type(userName, email, "userName");
		type(password, pass, "password");
		click(loginButton, "loginButton");
		return this;
	}
	

	
}
