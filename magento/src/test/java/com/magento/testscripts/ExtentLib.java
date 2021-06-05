package com.magento.testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentLib {
		 ExtentReports extent;
		 ExtentSparkReporter spark;
		 @BeforeTest
		 public void startRepo()
		 {
		 extent=new ExtentReports();
		 spark=new ExtentSparkReporter("./Nowrepo.html");
		 spark.config().setTheme(Theme.DARK);
		 spark.config().setDocumentTitle("Automation Doc Title");
		 spark.config().setReportName("Extent Report Name");
		 extent.attachReporter(spark);
		 }
		 
		 @Test
		 public void run()
		 {
		  ExtentTest test = extent.createTest("Login");
		  test.info("Login Done");
		 }
		 
		 @AfterTest
		 public void endReport()
		 {
		  extent.flush();
		 }
}
