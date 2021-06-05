package com.x2crm.entail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.x2crm.genericlib.BaseTest;
import com.x2crm.genericlib.FileLib;
import com.x2crm.genericlib.WebDriverCommonLib;
import com.x2crm.pages.DisplayCustomViewPage;
import com.x2crm.pages.HomePage;
import com.x2crm.pages.LoginPage;

@Listeners(com.x2crm.genericlib.MyListeners.class)
public class ValidSearchEntail extends BaseTest{
	@Test
	public void searchFindEntail() throws Throwable {
		LoginPage lp=new LoginPage();
		HomePage hp=new HomePage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		hp.clickEntailTab();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details Page");
		DisplayCustomViewPage dc=new DisplayCustomViewPage();
		dc.searchFindEntail(flib.readDataFromExcel(EXCEL_PATH, "find entail", 1, 0), "Sai Kiran");
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "displayCustomViewDetailsTitle"), "Display custom view details Page");
		
	}

}
