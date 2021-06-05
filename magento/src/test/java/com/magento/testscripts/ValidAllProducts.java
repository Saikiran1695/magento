package com.magento.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.genericlib.BaseTest;
import com.magento.genericlib.FileLib;
import com.magento.genericlib.MyListeners;
import com.magento.genericlib.WebDriverCommonLib;
import com.magento.pages.HomePage;
import com.magento.pages.MobilePage;

@Listeners(com.magento.genericlib.MyListeners.class)
public class ValidAllProducts extends BaseTest {
	
	@Test
	public void verifyAllProductsSortedByName() throws Throwable {
		MyListeners.test=MyListeners.repo.createTest("Verify Sony Xperia Price");
		HomePage hp=new HomePage();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		FileLib flib=new FileLib();
		WebDriverCommonLib.elementStatus("displayed", hp.getMobilebtn(), "Mobile Button");
		hp.clickMobileBtn();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "mobileTitle"), "Mobile Page");
		MobilePage mp=new MobilePage();
		WebDriverCommonLib.elementStatus("displayed", mp.getSortByDropDown(), "Sort By DropDown");
		mp.sortByName();
		wlib.getFullScreenshot("F:\\Selenium\\magento\\src\\test\\resources\\Screenshots\\ProductsSortedbyname.png");
	}

}
