package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.magento.genericlib.BaseTest;

public class ShoppingCartPage {
	
	@FindBy(xpath="//input[@class='input-text qty']") private WebElement quantityTxtBox;
	@FindBy(xpath="//button[@class='button btn-update']") private WebElement updateBtn;
	@FindBy(xpath="//p[@class='item-msg error']") private WebElement errorMsg;
	@FindBy(id="empty_cart_button") private WebElement emptyCartBtn;
	@FindBy(xpath="//h1") private WebElement text1;
	@FindBy(id="country") private WebElement countryDropDown;
	@FindBy(id="region_id") private WebElement stateDropDown;
	@FindBy(id="postcode") private WebElement zipCodeTB;
	@FindBy(xpath="//span[text()='Estimate']") private WebElement estimateLink;
	@FindBy(xpath="//label[contains(text(),'Fixed')]") private WebElement confirmShippingrateAdded;
	@FindBy(id="s_method_flatrate_flatrate") private WebElement flatRateCheckBox;
	@FindBy(xpath="//span[text()='Update Total']") private WebElement updateBtn2;
	
	public WebElement getCountryDropDown() {
		return countryDropDown;
	}


	public void setCountryDropDown(WebElement countryDropDown) {
		this.countryDropDown = countryDropDown;
	}


	public WebElement getStateDropDown() {
		return stateDropDown;
	}


	public void setStateDropDown(WebElement stateDropDown) {
		this.stateDropDown = stateDropDown;
	}


	public WebElement getZipCodeTB() {
		return zipCodeTB;
	}


	public void setZipCodeTB(WebElement zipCodeTB) {
		this.zipCodeTB = zipCodeTB;
	}


	public ShoppingCartPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	public void verifyQuantityTxtBox(String value) {
		quantityTxtBox.clear();
		quantityTxtBox.sendKeys(value);
		updateBtn.click();
		String text=errorMsg.getText();
		Reporter.log(text, true);
		emptyCartBtn.click();
		Reporter.log(text1.getText(), true);
		
	}
	
	public WebElement getQuantityTxtBox() {
		return quantityTxtBox;
	}


	public WebElement getUpdateBtn() {
		return updateBtn;
	}


	public WebElement getErrorMsg() {
		return errorMsg;
	}


	public WebElement getEmptyCartBtn() {
		return emptyCartBtn;
	}


	public WebElement getText1() {
		return text1;
	}


	public WebElement getEstimateLink() {
		return estimateLink;
	}


	public WebElement getConfirmShippingrateAdded() {
		return confirmShippingrateAdded;
	}


	public WebElement getFlatRateCheckBox() {
		return flatRateCheckBox;
	}


	public WebElement getUpdateBtn2() {
		return updateBtn2;
	}


	public void clickEstimateLink() {
		estimateLink.click();
	}
	
	public void confirmShippingrate() {
		Reporter.log(confirmShippingrateAdded.getText(), true);
		flatRateCheckBox.click();
		updateBtn2.click();
	}
}
