package com.magento.genericlib;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListeners extends BaseTest implements ITestListener  {
	
	public static ExtentReports repo;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" Started ", true);
			}
	public void onTestSuccess(ITestResult result) {
		test.pass(MarkupHelper.createLabel(result.getName()+ " is passed", ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult result) {
		test.fail(MarkupHelper.createLabel(result.getName()+ " is failed due to following reason",
				ExtentColor.RED));
		test.fail(result.getThrowable());
		test.fail("Testcase  failure and the screenshot is attached below" );
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		try {
			wlib.getFullScreenshot("F:\\Selenium\\magento\\src\\test\\resources\\Screenshots\\abc.png");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath("./Screenshots/xyz.png");
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test.skip(MarkupHelper.createLabel(result.getName()+ " is skipped ", ExtentColor.YELLOW));
		test.skip(result.getThrowable());
	}
	
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" Test Runner Started ", true);
		FileLib flib= new FileLib();
		 repo= new ExtentReports();
		spark=new ExtentSparkReporter(BaseTest.reportPath+ "/reports/extentreport.html");
		 // spark=new ExtentSparkReporter("F:\\Selenium\\magento\\reports\\extentreport.html");
		 
		 // Setting the system information
		 repo.setSystemInfo("author", "Sai Kiran");
		 repo.setSystemInfo("OS", "Windows 10");
		 try {
			repo.setSystemInfo("browser",flib.readPropData(PROP_PATH, "browser") );
		} catch (Throwable e) {
			e.printStackTrace();
		}
		 // Customizing the report view
		 spark.config().setDocumentTitle("Magento Automation Document");
		 spark.config().setReportName("Extent Report 5.0");
		 spark.config().setTheme(Theme.DARK);
		 repo.attachReporter(spark);

	}
	
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+" Test Runner Completed ", true);
		
		// Saving or writing all the logs into the reports
		repo.flush();
	}
}
