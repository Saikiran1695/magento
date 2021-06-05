package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.magento.genericlib.BaseTest;

public class SonyXperiaMobilePage {
	
	@FindBy(id="product-price-1") private WebElement sonyXperiaProductPriceInSonyXperiaPage;
	
	public SonyXperiaMobilePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void getSonyXperiaPriceFromSonyXperiaPage() {
		String text2=sonyXperiaProductPriceInSonyXperiaPage.getText();
		Reporter.log(text2, true);
	}
	
	public WebElement getSonyXperiaProductPriceInSonyXperiaPage() {
		return sonyXperiaProductPriceInSonyXperiaPage;
	}

	public String getSonyXperiaProductPriceFromSonyXperiaPage() {
		String text=sonyXperiaProductPriceInSonyXperiaPage.getText();
		return text;
	}

}
