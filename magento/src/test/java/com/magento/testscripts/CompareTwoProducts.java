package com.magento.testscripts;

import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.genericlib.BaseTest;
import com.magento.genericlib.FileLib;
import com.magento.genericlib.WebDriverCommonLib;
import com.magento.pages.HomePage;
import com.magento.pages.MobilePage;
import com.magento.pages.ProductComparisionListPage;
import com.magento.pages.ShoppingCartPage;
import com.magento.pages.SonyXperiaMobilePage;


@Listeners(com.magento.genericlib.MyListeners.class)
public class CompareTwoProducts extends BaseTest {
	
	@Test
	public void verifyCompareProducts() throws Throwable {
		HomePage hp=new HomePage();
		MobilePage mp=new MobilePage();
		ShoppingCartPage sp=new ShoppingCartPage();
		SonyXperiaMobilePage smp=new SonyXperiaMobilePage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		hp.clickMobileBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "mobileTitle"), "Mobile Page");
		//compare two products
		mp.compareTwoProducts();
		String parent=BaseTest.driver.getWindowHandle();

		Set<String>s=BaseTest.driver.getWindowHandles();

		for(String s1:s) {
			//WebDriverCommonLib wlib=new WebDriverCommonLib();
			String title=BaseTest.driver.switchTo().window(s1).getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase("Products Comparison List - Magento Commerce")) {
				ProductComparisionListPage pc=new ProductComparisionListPage();
				System.out.println(pc.getCompareproductTitle());;
				System.out.println(pc.getSonyXperiaProduct());;
				System.out.println(pc.getIphoneProduct());;
				driver.switchTo().defaultContent();
			}
				
				
	}
		
	}

}
