package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeTest {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[2]/div/a/i")
	private WebElement adminmoreInfolink;
	
	public HomeTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void adminpageClick() {
		adminmoreInfolink.click();
	}

}
