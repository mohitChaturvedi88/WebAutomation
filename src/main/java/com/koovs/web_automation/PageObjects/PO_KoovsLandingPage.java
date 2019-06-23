package com.koovs.web_automation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.koovs.web_automation.TestUtils.BasePage;

public class PO_KoovsLandingPage extends BasePage {

	@FindBy(className = "header-logo")
	public WebElement koovs_logo;

	@FindBy(className = "header-strip-banner")
	public WebElement header_banner_COD;

	@FindBy(className = "hoptions contact-us")
	public WebElement header_icon_contact_us;

	@FindBy(className = "sprite-item h_dwnldApp")
	public WebElement header_icon_dwnldApp;

	@FindBy(className = "sprite-item h_trackOrder")
	public WebElement header_icon_trackOrder;

	@FindBy(className = "sprite-item h_myaccount")
	public WebElement header_icon_myaccount;

	@FindBy(className = "sprite-item h_bag")
	public WebElement header_icon_mybag;

	@FindBy(className = "brand-menu__heading")
	public WebElement menu_headings;

	@FindBy(className = "search-input-field")
	public WebElement search_input;

	@FindBy(className = "koovs-search-btn")
	public WebElement search_btn;

	
	@FindBy(partialLinkText="/men")
	public WebElement menlink;
	
	@FindBy(partialLinkText="/women")
	public WebElement womenlink;
	
	
	public PO_KoovsLandingPage open() {
		return (PO_KoovsLandingPage) openPage(PO_KoovsLandingPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(koovs_logo);

	}

	public boolean verifyKoovsLogo() {
		boolean flag = koovs_logo.isDisplayed();
		return flag;
	}

	public PO_Shipping_Return_Information verifyCODbannerLink() {
		click(header_banner_COD, "COD Banner");
		return (PO_Shipping_Return_Information) openPage(PO_Shipping_Return_Information.class);
	}

	public void verifyMenuBarWomen(String action, String label, String finalUrl) {
		if (!action.contains("DROP_DOWN")) {
			System.out.println("Printing Action: " + action);
			System.out.println("Printing Label: " + label);
			System.out.println("Printing FinalUrl: " + finalUrl);

		}

	}
}
