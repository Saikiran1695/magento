package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.genericlib.BaseTest;

public class ProductComparisionListPage {
	@FindBy(xpath="//h1") private WebElement compareproductTitle;
	@FindBy(xpath="//a[text()='Sony Xperia']") private WebElement sonyXperiaProduct;
	@FindBy(xpath="//a[text()='IPHONE']") private WebElement iphoneProduct;
	public WebElement getSonyXperiaProduct() {
		return sonyXperiaProduct;
	}

	public WebElement getIphoneProduct() {
		return iphoneProduct;
	}

	public ProductComparisionListPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getCompareproductTitle() {
		return compareproductTitle;
	}
	
}
