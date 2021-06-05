package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.genericlib.BaseTest;

public class CustomerLoginPage {
	@FindBy(xpath="//span[text()='Create an Account']") private WebElement createAnAccountBtn;
	@FindBy(id="email") private WebElement emailTB;
	@FindBy(id="pass") private WebElement passwordTB;
	@FindBy(id="send2") private WebElement loginBtn;
	
	
	
	public CustomerLoginPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickOnCreateAnAccount() {
		createAnAccountBtn.click();
	}
	
	public WebElement getCreateAnAccountBtn() {
		return createAnAccountBtn;
	}

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void enterCredentials(String emal,String pwd) {
		emailTB.clear();
		emailTB.sendKeys(emal);
		passwordTB.clear();
		passwordTB.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	

}
