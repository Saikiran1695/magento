package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.genericlib.BaseTest;

public class TVPage {
	@FindBy(xpath="//a[text()=\"LG LCD\"]/parent::h2/following-sibling::div[3]//ul//li[1]") private WebElement addToWishListLink;
	
	
	public TVPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	 public void clickOnAddToWishList() {
		 addToWishListLink.click();
	}

	public WebElement getAddToWishListLink() {
		return addToWishListLink;
	}

}
