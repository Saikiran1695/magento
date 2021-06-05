package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.genericlib.BaseTest;

public class CreateNewCustomerAccountPage {

	
	@FindBy(id="firstname") private WebElement fname;
	@FindBy(id="lastname") private WebElement lname;
	@FindBy(id="email_address") private WebElement email;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="confirmation") private WebElement confirmPassword;
	@FindBy(xpath="//span[text()='Register']") private WebElement registerBtn;
	
	
	public CreateNewCustomerAccountPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void createCustomerAccount(String fn,String ln,String emal,String pwd,String confirmpwd) {
		fname.clear();
		fname.sendKeys(fn);
		lname.clear();
		lname.sendKeys(ln);
		email.clear();
		email.sendKeys(emal);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmpwd);
		registerBtn.click();
		
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	
}
