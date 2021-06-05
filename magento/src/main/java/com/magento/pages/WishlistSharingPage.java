package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.genericlib.BaseTest;

public class WishlistSharingPage {
	
	@FindBy(id="email_address") private WebElement emailTextArea;

	public WishlistSharingPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	public WebElement getEmailTextArea() {
		return emailTextArea;
	}


	public void enterEmailAddress(String emal) {
		emailTextArea.clear();
		emailTextArea.sendKeys(emal);
	}
}
