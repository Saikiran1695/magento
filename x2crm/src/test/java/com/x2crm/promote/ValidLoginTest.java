package com.x2crm.promote;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.x2crm.genericlib.BaseTest;
import com.x2crm.genericlib.FileLib;
import com.x2crm.genericlib.WebDriverCommonLib;
import com.x2crm.pages.LoginPage;
@Listeners(com.x2crm.genericlib.MyListeners.class)
public class ValidLoginTest extends BaseTest{
	
	@Test
	public void loginToApp() throws Throwable {
		LoginPage lp =new LoginPage();
		FileLib fl= new FileLib();
		lp.login(fl.readPropData(PROP_PATH, "username"), fl.readPropData(PROP_PATH, "password"));
		WebDriverCommonLib wd =new WebDriverCommonLib();
		wd.verify(wd.getPageTitle(), fl.readPropData(PROP_PATH, "homeTitle"), "Home page");
	}

}
