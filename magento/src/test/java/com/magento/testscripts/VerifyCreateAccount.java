package com.magento.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.magento.genericlib.BaseTest;
import com.magento.genericlib.FileLib;
import com.magento.genericlib.MyListeners;
import com.magento.genericlib.WebDriverCommonLib;
import com.magento.pages.CreateNewCustomerAccountPage;
import com.magento.pages.CustomerLoginPage;
import com.magento.pages.HomePage;
import com.magento.pages.MyAccountPage;
import com.magento.pages.MyWishListPage;
import com.magento.pages.TVPage;
import com.magento.pages.WishlistSharingPage;


@Listeners(com.magento.genericlib.MyListeners.class)
public class VerifyCreateAccount extends BaseTest {
	
	
	@Test
	public void verifyAccountCreation() throws Throwable {
		HomePage hp=new HomePage();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		FileLib flib=new FileLib();
		
		MyListeners.test=MyListeners.repo.createTest("Verify Account creation of end user");
		
		WebDriverCommonLib.elementStatus("displayed", hp.getAccountLink(), "Account Link");
		hp.clickOnAccount();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "customerLoginTitle"),
				"Customer Login Page");
		CustomerLoginPage cp=new CustomerLoginPage();
		WebDriverCommonLib.elementStatus("displayed", cp.getCreateAnAccountBtn(), 
				"Create Account Button");
		cp.clickOnCreateAnAccount();
		MyAccountPage mp=new MyAccountPage();
		
		
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createNewCustomerTitle"), "Create New Customer Page");
		CreateNewCustomerAccountPage ca=new CreateNewCustomerAccountPage();
		
		WebDriverCommonLib.elementStatus("displayed", ca.getFname(), "First name Text box");
		WebDriverCommonLib.elementStatus("displayed", ca.getLname(),  "Last name  Text box");
		WebDriverCommonLib.elementStatus("displayed", ca.getEmail()
				, "Email Text box");
		WebDriverCommonLib.elementStatus("displayed", ca.getPassword(), "Password Text box");
		WebDriverCommonLib.elementStatus("displayed", ca.getConfirmPassword(), "Confirm Password Text box");
		WebDriverCommonLib.elementStatus("displayed", ca.getRegisterBtn(), "Register Button");
		ca.createCustomerAccount(flib.readDataFromExcel(EXCEL_PATH, "sheet1", 1, 0), 
				flib.readDataFromExcel(EXCEL_PATH, "sheet1", 1, 1),
				flib.readDataFromExcel(EXCEL_PATH, "sheet1", 1, 2),
				flib.readDataFromExcel(EXCEL_PATH, "sheet1", 1, 3), 
				flib.readDataFromExcel(EXCEL_PATH, "sheet1", 1, 4));
		
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "myAccountTitle"), "My Account Page");
		mp.accountCreationConfirmatin();
		WebDriverCommonLib.elementStatus("displayed", hp.getTvbtn(), "TV Button");
		hp.clickTVBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "tvTitle"), "TV Page");
		TVPage tp=new TVPage();
		WebDriverCommonLib.elementStatus("displayed", tp.getAddToWishListLink(), "Add to WishList link");
		tp.clickOnAddToWishList();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "myWishListTitle"), "My WishList Page");
		MyWishListPage mwp=new MyWishListPage();
		WebDriverCommonLib.elementStatus("displayed", mwp.getShareWishlistBtn(), "Share WishList Button");
		mwp.clickOnShareWishlistBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "wishlistSharingTitle"), "Wishlist Sharing Page");
		WishlistSharingPage wp=new WishlistSharingPage();
		WebDriverCommonLib.elementStatus("displayed", wp.getEmailTextArea(), "Email Text Area");
		wp.enterEmailAddress(flib.readDataFromExcel(EXCEL_PATH, "sheet2", 1, 0));
		WebDriverCommonLib.elementStatus("displayed", mwp.getShareWishlistBtn(), "Share WishList Button");
		mwp.clickOnShareWishlistBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "myWishListTitle"), "My WishList Page");
		WebDriverCommonLib.elementStatus("displayed", mwp.getConfirmationMsg(), "Confirmation message text");
		mwp.confirmMsg();
		
	}

}
