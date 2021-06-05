package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.magento.genericlib.BaseTest;

public class HomePage {
	@FindBy(xpath="//h2") private WebElement text;
	@FindBy(xpath="//a[text()='Mobile']") private WebElement mobilebtn;
	@FindBy(xpath="//a[text()='TV']") private WebElement tvbtn;
	@FindBy(xpath="//span[text()=\"Cart\"]/ancestor::div/preceding-sibling::a//span[text()='Account']")
	private WebElement accountLink;
	@FindBy(xpath="//div[@id='header-account']//a[text()='My Account']") private WebElement myAccountLink;
	
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickMobileBtn() {
		Reporter.log(text.getText(), true);
		mobilebtn.click();
	}
	
	public void setText(WebElement text) {
		this.text = text;
	}

	public void setMobilebtn(WebElement mobilebtn) {
		this.mobilebtn = mobilebtn;
	}

	public void setTvbtn(WebElement tvbtn) {
		this.tvbtn = tvbtn;
	}

	public void setAccountLink(WebElement accountLink) {
		this.accountLink = accountLink;
	}

	public void setMyAccountLink(WebElement myAccountLink) {
		this.myAccountLink = myAccountLink;
	}

	public void clickOnAccount() {
		accountLink.click();
		myAccountLink.click();
	}
	
	public WebElement getText() {
		return text;
	}

	public WebElement getMobilebtn() {
		return mobilebtn;
	}

	public WebElement getTvbtn() {
		return tvbtn;
	}

	public WebElement getAccountLink() {
		return accountLink;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public void clickTVBtn() {
		tvbtn.click();
	}
	

}
