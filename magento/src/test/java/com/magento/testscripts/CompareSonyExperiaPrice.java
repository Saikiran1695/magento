package com.magento.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.magento.genericlib.BaseTest;
import com.magento.genericlib.FileLib;
import com.magento.genericlib.MyListeners;
import com.magento.genericlib.WebDriverCommonLib;
import com.magento.pages.HomePage;
import com.magento.pages.MobilePage;
import com.magento.pages.SonyXperiaMobilePage;
@Listeners(com.magento.genericlib.MyListeners.class)
public class CompareSonyExperiaPrice extends BaseTest{	
	@Test
	public void verifySonyXperiaPrice() throws Throwable {
		MyListeners.test=MyListeners.repo.createTest("Verify Sony Xperia Price");
		HomePage hp=new HomePage();
		FileLib flib=new FileLib();
		MobilePage mp=new MobilePage();
		SonyXperiaMobilePage smp=new SonyXperiaMobilePage();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		WebDriverCommonLib.elementStatus("displayed", hp.getMobilebtn(), "Mobile Button");
		hp.clickMobileBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "mobileTitle"), "Mobile Page");
		WebDriverCommonLib.elementStatus("displayed", mp.getSonyXperiaProductPrice(), "Sony Xperia Product Price Text");
		mp.getSonyXperiaProductPriceFromMobilePage();
		WebDriverCommonLib.elementStatus("displayed", mp.getSonyXperiaProduct(), "Sony Xperia Product Button");
		mp.clickOnSonyXperiaProduct();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "sonyXperiaTitle"),"Sony Xperia Page");
		WebDriverCommonLib.elementStatus("displayed", smp.getSonyXperiaProductPriceInSonyXperiaPage(), "Get the price of Sony Xperia Product ");
		smp.getSonyXperiaPriceFromSonyXperiaPage();
		String text1=mp.getSonyXperiaPriceFromMobilePage();
		String text2=smp.getSonyXperiaProductPriceFromSonyXperiaPage();
		Assert.assertEquals(text1, text2);
	}
}
