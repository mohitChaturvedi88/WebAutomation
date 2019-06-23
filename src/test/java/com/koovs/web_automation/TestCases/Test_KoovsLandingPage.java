/**
 * 
 */
package com.koovs.web_automation.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.koovs.web_automation.PageObjects.PO_KoovsLandingPage;
import com.koovs.web_automation.PageObjects.PO_Shipping_Return_Information;
import com.koovs.web_automation.TestUtils.DriverManager;
import com.koovs.web_automation.TestUtils.TestUtils;
import com.koovs.web_automation.setUp.TestSetUp;

/**
 * @author Mohit
 *
 */
public class Test_KoovsLandingPage extends TestSetUp {

	
	@Test
	public void verifyKoovsLogoTest() {
		assignAuthor("Mohit Chaturvedi");
		assignCategory("Regression");
		PO_KoovsLandingPage po_koovslandingPage = new PO_KoovsLandingPage().open();
		Assert.assertTrue(po_koovslandingPage.verifyKoovsLogo());
	}

	@Test
	public void verifyCODbannerLinkTest() {
		assignAuthor("Mohit Chaturvedi");
		assignCategory("Regression");
		PO_KoovsLandingPage po_koovslandingPage = new PO_KoovsLandingPage().open();
		PO_Shipping_Return_Information shipping_return_information = po_koovslandingPage.verifyCODbannerLink();
		Assert.assertTrue(
				shipping_return_information.shipping_retunrn_heading().contains("SHIPPING & RETURN INFORMATION"));

	}
	
	
	/*
	@Test(dataProviderClass = TestUtils.class, dataProvider = "MenuBarData")
	public void verifyMenuBarWomenTest(Hashtable<String, String> data) throws Exception {
		assignAuthor("Mohit Chaturvedi");
		assignCategory("Regression");
		
		String finalUrl = configProperty.getProperty("url") + data.get("Link");
		String label = data.get("Label");
		String action = data.get("Action");


		if(!action.contains("DROP_DOWN")){
		
		
		PO_KoovsLandingPage po_koovslandingPage = new PO_KoovsLandingPage().open();
	po_koovslandingPage.verifyMenuBarWomen(action, label, finalUrl);

//		
	WebElement SubMenulink = DriverManager.getDriver().findElement(By.linkText(label));
		SubMenulink.getAttribute("href");
//		
		System.out.println("Element Link  : "+SubMenulink.getText());
	System.out.println("Attribute Value  : "+SubMenulink.getAttribute("href"));
//		
		
	}
			
	}
		
		*/
		
	}


