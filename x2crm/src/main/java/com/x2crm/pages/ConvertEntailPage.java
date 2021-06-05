package com.x2crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.x2crm.genericlib.BaseTest;

public class ConvertEntailPage {

	@FindBy(xpath="//img[@onclick=\"showCal('Calendar1')\"]") private WebElement showCalender;
	
	
	public ConvertEntailPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickCalenderIcon() {
		showCalender.click();
	}
	
	
	
	
	
	
	
	
	
	
}
