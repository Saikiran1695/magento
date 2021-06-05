package com.x2crm.promote;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.x2crm.genericlib.BaseTest;
import com.x2crm.genericlib.FileLib;
import com.x2crm.genericlib.WebDriverCommonLib;
import com.x2crm.pages.PromoteDetailsPage;
import com.x2crm.pages.CreatePromotePage;
import com.x2crm.pages.DisplayCustomViewPage;
import com.x2crm.pages.HomePage;
import com.x2crm.pages.LoginPage;

@Listeners(com.x2crm.genericlib.MyListeners.class)
public class ValidCreatePromote extends BaseTest {
	
	
	
	@Test
	public void createCampaign() throws Throwable {
		LoginPage lp=new LoginPage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wLib= new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		wLib.verify(wLib.getPageTitle(),flib.readPropData(PROP_PATH, "homeTitle"), " Home Page");
		HomePage hp=new HomePage();
		hp.clickCampaignTab();
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details Page");
		DisplayCustomViewPage dc=new DisplayCustomViewPage();
		dc.clickNewCampaignBtn();
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "createPromoteTitle"), " Create Promote Page");
		CreatePromotePage CreateCamp= new CreatePromotePage ();
		CreateCamp.createPromote(flib.readDataFromExcel(EXCEL_PATH, "sheet2", 1, 0));
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "promoteDetailsPage"), " Promote Details Page");
		PromoteDetailsPage campDetail= new PromoteDetailsPage();
		campDetail.clickPromoteTab();;
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details Page");
		dc.verifyCreationCapture("Cap");
		dc.captureAllCreated();
		wLib.getFullScreenshot("F:\\Selenium\\x2crm\\src\\test\\resources\\Screenshot\\snap.png");
		
		
	}
}
