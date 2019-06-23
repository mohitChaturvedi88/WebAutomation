package com.koovs.web_automation.setUp;
import com.koovs.web_automation.TestUtils.ExcelReader;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.koovs.web_automation.TestUtils.DriverFactory;
import com.koovs.web_automation.TestUtils.DriverManager;
import com.koovs.web_automation.TestUtils.ExtentManager;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class TestSetUp {

	// public WebDriver driver;
	public static Properties configProperty;
	public static Properties ORProperty;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testCaseLogger = new ThreadLocal<ExtentTest>();

	//
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\simple.xlsx");

	@BeforeSuite
	public synchronized void beforeSuite() {
		try {
			FileInputStream fi = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\propertyFiles\\config.properties"));
			configProperty = new Properties();
			try {
				configProperty.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent = ExtentManager.GetExtent();

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		// extent reporting
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		parentTest.set(parent);
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {

		WebDriver driver = null;

		if (driver == null) {
			// configProperty = PropertyFileManager.createConfigFileProperty();
			driver = DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
			//System.out.println("Driver-->" + DriverManager.getDriver());
			DriverManager.getDriver().navigate().to(configProperty.getProperty("url"));

			
		}

		/*
		 * ExtentTest child =
		 * classLevelReport.get().createNode(method.getName());
		 * testLevelReport.set(child); testLevelReport.get().log(Status.INFO,
		 * "Execution of Test Case-"+" "+method.getName()+" started");
		 */
	}

	@AfterMethod
	public void afterMethod() {
		extent.flush();
		DriverFactory.destroyDriver();
	}

	@AfterClass
	public void afterClass() {
		//
	}

	@AfterTest
	public void afterTest() {

	}
	//

	@AfterSuite
	public void afterSuite() {
		//
	}
	
	public void assignAuthor(String authorName)
	{
		testCaseLogger.get().assignAuthor(authorName);
	}
	
	public void assignCategory(String category)
	{
		testCaseLogger.get().assignCategory(category);
	}

}
