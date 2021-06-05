package com.x2crm.promote;

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
public class validPromoteDisplayedInPromoteDetailsPage extends BaseTest {

	@Test
	public void verifyCampaignDetailsPage() throws Throwable {
		LoginPage lp = new LoginPage();
		HomePage hp=new HomePage();
		FileLib flib= new FileLib();
		WebDriverCommonLib wLib = new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		hp.clickCampaignTab();
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view page");
		DisplayCustomViewPage dc=new DisplayCustomViewPage();
		dc.clickNewCampaignBtn();
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "createPromoteTitle"), "Create Promote page");
		CreatePromotePage cp= new CreatePromotePage();
		cp.createPromote(flib.readDataFromExcel(EXCEL_PATH, "sheet2", 1, 0));
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "promoteDetailsPage"), "Promote Details page");
		wLib.getFullScreenshot("F:\\Selenium\\x2crm\\src\\test\\resources\\Screenshot\\CampaignDetailsPageSS.png");
		
	}
}
