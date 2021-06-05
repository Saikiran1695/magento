package com.magento.testscripts;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.magento.genericlib.BaseTest;
import com.magento.genericlib.FileLib;
import com.magento.genericlib.MyListeners;

//@Listeners(com.magento.genericlib.MyListeners.class)
public class Reporttest extends BaseTest {
	
	public static ExtentReports repo;
	public static ExtentSparkReporter spark;
	

	@BeforeTest
	public void setUp() {
		
		
		 repo= new ExtentReports();
		// spark=new ExtentSparkReporter(BaseTest.reportPath+ "/reports/extentreport.html");
		 spark=new ExtentSparkReporter("F:\\Selenium\\magento\\extentreport.html");
		 
			
		 spark.config().setDocumentTitle("Magento Automation Document");
		 spark.config().setReportName("Extent Report 5.0");
		 spark.config().setTheme(Theme.DARK);
		 repo.attachReporter(spark);
	}
	@Test
	public void run() {
		ExtentTest test = repo.createTest("Login");
		  test.info("Login Done");
	}
	
	@AfterTest
	public void save() {
		repo.flush();
	}
	
}
