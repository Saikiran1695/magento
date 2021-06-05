package com.magento.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.genericlib.BaseTest;
import com.magento.genericlib.FileLib;
import com.magento.genericlib.MyListeners;
import com.magento.genericlib.WebDriverCommonLib;
import com.magento.pages.HomePage;
import com.magento.pages.MobilePage;
import com.magento.pages.ShoppingCartPage;
import com.magento.pages.SonyXperiaMobilePage;

@Listeners(com.magento.genericlib.MyListeners.class)
public class VerifyShoppingCartIsEmpty extends BaseTest {
	@Test
	public void checkCartIsEmpty() throws Throwable {
		MyListeners.test=MyListeners.repo.createTest("Verify Shopping cart is empty");
		HomePage hp=new HomePage();
		MobilePage mp=new MobilePage();
		ShoppingCartPage sp=new ShoppingCartPage();
		SonyXperiaMobilePage smp=new SonyXperiaMobilePage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		WebDriverCommonLib.elementStatus("displayed", hp.getMobilebtn(), "Mobile Button");
		hp.clickMobileBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "mobileTitle"), "Mobile Page");
		WebDriverCommonLib.elementStatus("displayed", mp.getSonyXperiaAddToCartBtn(),
				"Sony Xperia Add To Cart Button ");
		mp.clickOnSonyXperiaAddToCartBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "shoppingTitle"), "Shopping Cart Page");
		WebDriverCommonLib.elementStatus("displayed", sp.getQuantityTxtBox(), "Quantity Text Box");
		sp.verifyQuantityTxtBox("1000");
	}
	

}
