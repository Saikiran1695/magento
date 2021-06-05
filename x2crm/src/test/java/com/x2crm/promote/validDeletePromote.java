package com.x2crm.promote;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.x2crm.genericlib.BaseTest;
import com.x2crm.genericlib.FileLib;
import com.x2crm.genericlib.WebDriverCommonLib;
import com.x2crm.pages.CreatePromotePage;
import com.x2crm.pages.DisplayCustomViewPage;
import com.x2crm.pages.HomePage;
import com.x2crm.pages.LoginPage;
import com.x2crm.pages.PromoteDetailsPage;

@Listeners(com.x2crm.genericlib.MyListeners.class)
public class validDeletePromote extends BaseTest{
	
	@Test
	public void deletePromote() throws Throwable {
		LoginPage lp=new LoginPage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wLib= new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		wLib.verify(wLib.getPageTitle(),flib.readPropData(PROP_PATH, "homeTitle"), " Home Page");
		HomePage hp=new HomePage();
		hp.clickCampaignTab();
		DisplayCustomViewPage dc=new DisplayCustomViewPage();
		dc.clickNewCampaignBtn();
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "createPromoteTitle"), " Create Promote Page");
		CreatePromotePage CreateCamp= new CreatePromotePage ();
		CreateCamp.createPromote(flib.readDataFromExcel(EXCEL_PATH, "sheet2", 1, 0));
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "promoteDetailsPage"), " Promote Details Page");
		PromoteDetailsPage campDetail= new PromoteDetailsPage();
		campDetail.clickdeleteBtn();
		wLib.switchToPopupAndClickOnOkBtn();
		wLib.waitForPage("Zoho CRM - Displaying Custom View Details");
		wLib.verify(wLib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details page");
	

	}

}
