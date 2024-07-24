package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),' Admin')]")
	private WebElement profilenameElement;
	
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[2]/div/a/i")
	private WebElement adminmoreInfolink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getprofileName() {
		return profilenameElement.getText();
	}
	

	
	
	
	
	
	
	public void adminpageClick() {
		adminmoreInfolink.click();
	}

}
