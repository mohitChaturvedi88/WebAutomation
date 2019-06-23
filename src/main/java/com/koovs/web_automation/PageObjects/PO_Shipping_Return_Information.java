package com.koovs.web_automation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.koovs.web_automation.TestUtils.BasePage;

public class PO_Shipping_Return_Information extends BasePage {

	
	@FindBy(className = "header-logo")
	public WebElement koovs_logo;
	
	@FindBy(xpath="//h1[@id='top']")
	public WebElement shipping_retunr_heading;

	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
				return ExpectedConditions.textToBePresentInElement(shipping_retunr_heading, "SHIPPING & RETURN INFORMATION");
	}

	
public String shipping_retunrn_heading() {
	String flag = shipping_retunr_heading.getText();
			return flag;
	}
	
	
}
