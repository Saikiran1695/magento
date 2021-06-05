package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.magento.genericlib.BaseTest;

public class MyWishListPage {
	
	@FindBy(xpath="//span[text()='Share Wishlist']") private WebElement shareWishlistBtn;
	@FindBy(xpath="//span[text()='Your Wishlist has been shared.']") private WebElement confirmationMsg;
	@FindBy(xpath="//span[text()='Add to Cart']") private WebElement addToCartBtn;
	
	
	public MyWishListPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickOnShareWishlistBtn() {
		shareWishlistBtn.click();
	}
	
	public WebElement getShareWishlistBtn() {
		return shareWishlistBtn;
	}

	public WebElement getConfirmationMsg() {
		return confirmationMsg;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public void confirmMsg() {
		Reporter.log(confirmationMsg.getText(), true);
	}
	
	public void clickOnAddToCartBtn() {
		addToCartBtn.click();
	}

}
