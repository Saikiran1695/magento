package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.magento.genericlib.BaseTest;

public class MyAccountPage {
	@FindBy(xpath="//h1//parent::div/following-sibling::ul") private WebElement confirmMsg;
	@FindBy(xpath="//a[text()=\"TV\"]") private WebElement tvLink;
	@FindBy(xpath="//a[text()='My Wishlist']") private WebElement myWishlistLink;
	
	
	public MyAccountPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public WebElement getConfirmMsg() {
		return confirmMsg;
	}

	public WebElement getTvLink() {
		return tvLink;
	}

	public WebElement getMyWishlistLink() {
		return myWishlistLink;
	}

	public void accountCreationConfirmatin() {
		Reporter.log(confirmMsg.getText(), true);
		tvLink.click();
	}
	
	public void clickOnMyWishList() {
		myWishlistLink.click();
	}
}
