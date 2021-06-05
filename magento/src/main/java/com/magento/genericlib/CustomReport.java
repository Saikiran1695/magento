package com.magento.genericlib;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomReport {
	
	@Test
	public void runReports() {
		ExtentReports repo=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("F:\\Selenium\\magento//MyReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Document");
		spark.config().setReportName("Customized Report");
		repo.attachReporter(spark);
		
		ExtentTest test1=repo.createTest("Login TestCase").assignAuthor("Sai")
				.assignCategory("Smoke Testing").assignDevice("Windows chrome 90");
		test1.info("Open the browser");
		test1.info("Enter test URL");
		test1.info("Enter Username");
		test1.info("Enter Password");
		test1.skip("Click rem pwd checkbox");
		test1.info("Click On Login Button");
		test1.pass("Login Successful");
		repo.flush();
		
		ExtentTest test2=repo.createTest("Logout TestCase").assignAuthor("Sai")
				.assignCategory("Regression Testing").assignDevice("Windows chrome 90");
		test2.info("Open the browser");
		test2.info("Enter test URL");
		test2.info("Enter Username");
		test2.info("Enter Password");
		test2.skip("Click rem pwd checkbox");
		test2.info("Click On Login Button");
		test2.pass("Login Successful");
		test2.fail("LogOut Failed");
		
		repo.flush();
	}

}
