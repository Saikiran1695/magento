package com.magento.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.magento.genericlib.BaseTest;
import com.magento.genericlib.WebDriverCommonLib;

public class MobilePage {
	
	@FindBy(xpath="//select[@title='Sort By']") private WebElement sortByDropDown;
	@FindBy(id="product-price-1") private WebElement sonyXperiaProductPrice;
	@FindBy(xpath="//a[@title='Sony Xperia']") private WebElement sonyXperiaProduct;
	@FindBy(xpath="//span[@id='product-price-1']/parent::div/following-sibling::div[2]//button[@class='button btn-cart']")
	private WebElement sonyXperiaAddToCartBtn;
	@FindBy(xpath="//a[@title=\"Sony Xperia\"]/parent::h2/following-sibling::div[3]//ul//li[2]//a[@class='link-compare']")
	private WebElement sonyXperiaAddToCompareBtn;
	@FindBy(xpath="//a[@title=\"IPhone\"]/parent::h2/following-sibling::div[3]//ul//li[2]//a[@class='link-compare']")
	private WebElement iphoneAddToCompareBtn;
	@FindBy(xpath="//span[text()=\"Compare\"]") private WebElement compareBtn;
	@FindBy(xpath="//h1") private WebElement text;
	
	
	public  MobilePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void sortByName() {
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.selectOption(sortByDropDown, "Name");
	}
	
	public void setSortByDropDown(WebElement sortByDropDown) {
		this.sortByDropDown = sortByDropDown;
	}

	public void setSonyXperiaProductPrice(WebElement sonyXperiaProductPrice) {
		this.sonyXperiaProductPrice = sonyXperiaProductPrice;
	}

	public void setSonyXperiaProduct(WebElement sonyXperiaProduct) {
		this.sonyXperiaProduct = sonyXperiaProduct;
	}

	public void setSonyXperiaAddToCartBtn(WebElement sonyXperiaAddToCartBtn) {
		this.sonyXperiaAddToCartBtn = sonyXperiaAddToCartBtn;
	}

	public void setSonyXperiaAddToCompareBtn(WebElement sonyXperiaAddToCompareBtn) {
		this.sonyXperiaAddToCompareBtn = sonyXperiaAddToCompareBtn;
	}

	public void setIphoneAddToCompareBtn(WebElement iphoneAddToCompareBtn) {
		this.iphoneAddToCompareBtn = iphoneAddToCompareBtn;
	}

	public void setCompareBtn(WebElement compareBtn) {
		this.compareBtn = compareBtn;
	}

	public void setText(WebElement text) {
		this.text = text;
	}

	public void getSonyXperiaProductPriceFromMobilePage() {
		String text1=sonyXperiaProductPrice.getText();
		Reporter.log(text1, true);
	}
	
	public String getSonyXperiaPriceFromMobilePage() {
		String text=sonyXperiaProductPrice.getText();
		return text;
	}
	
	public void clickOnSonyXperiaProduct() {
		sonyXperiaProduct.click();
	}
	
	public void clickOnSonyXperiaAddToCartBtn() {
		sonyXperiaAddToCartBtn.click();
	}
	
	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}

	public WebElement getSonyXperiaProductPrice() {
		return sonyXperiaProductPrice;
	}

	public WebElement getSonyXperiaProduct() {
		return sonyXperiaProduct;
	}

	public WebElement getSonyXperiaAddToCartBtn() {
		return sonyXperiaAddToCartBtn;
	}

	public WebElement getSonyXperiaAddToCompareBtn() {
		return sonyXperiaAddToCompareBtn;
	}

	public WebElement getIphoneAddToCompareBtn() {
		return iphoneAddToCompareBtn;
	}

	public WebElement getCompareBtn() {
		return compareBtn;
	}

	public WebElement getText() {
		return text;
	}

	public void compareTwoProducts() {
		sonyXperiaAddToCompareBtn.click();
		iphoneAddToCompareBtn.click();
		compareBtn.click();
		
		
}
	}

