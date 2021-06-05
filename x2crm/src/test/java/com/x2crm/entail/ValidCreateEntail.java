package com.x2crm.entail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.x2crm.genericlib.BaseTest;
import com.x2crm.genericlib.FileLib;
import com.x2crm.genericlib.WebDriverCommonLib;
import com.x2crm.pages.CreateEntailPage;
import com.x2crm.pages.DisplayCustomViewPage;
import com.x2crm.pages.EntailDetailsPage;
import com.x2crm.pages.HomePage;
import com.x2crm.pages.LoginPage;

@Listeners(com.x2crm.genericlib.MyListeners.class)
public class ValidCreateEntail extends BaseTest {
	@Test
	public void createEntail() throws Throwable {
		LoginPage lp=new LoginPage();
		HomePage hp=new HomePage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		hp.clickEntailTab();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details Page");
		DisplayCustomViewPage dc=new DisplayCustomViewPage();
		dc.clickNewEntailBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createEntailTitle"), "Create Entail Page");
		CreateEntailPage ce= new CreateEntailPage();
		ce.createEntail(flib.readDataFromExcel(EXCEL_PATH, "Lead detail", 1, 0), flib.readDataFromExcel(EXCEL_PATH, "Lead detail", 1, 1));
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "entailDetailsPage"), "Entail Details Page");
		EntailDetailsPage ed= new EntailDetailsPage();
		ed.clickLeadsTab();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details Page");
		dc.verifyCreationCapture("Sai Kiran");
		dc.captureAllCreated();
		wlib.getFullScreenshot("F:\\\\Selenium\\\\x2crm\\\\src\\\\test\\\\resources\\\\Screenshot\\\\CreatedEntailSS.png");
	}

}
