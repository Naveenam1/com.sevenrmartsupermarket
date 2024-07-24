package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminPage {

	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();

	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[2]/div/a/i")
	private WebElement adminmoreInfolink;

	@FindBy(xpath = "//a[text()=' Admin']")
	private WebElement adminProfilename;

	@FindBy(xpath = "//a[contains(text(),' New')]")
	private WebElement newadminButton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNamefield;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;

	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void adminpageClick() {
		adminmoreInfolink.click();
	}

	public String getProfilenameofAdminpage() {
		return adminProfilename.getText();
	}

	public void clickNewbutton() {
		newadminButton.click();
		

	}

	public String newUsername() {
		return GeneralUtility.getRandomname() + "Ammu";
	}

	public String newPassword() {
		return newUsername() + "@1087";
	}

	public void enterUserName(String userName) {
		userNamefield.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectUsertype(String usertype) {
		Select select = new Select(userType);

		select.selectByIndex(0);
		select.selectByValue("staff");
		select.selectByVisibleText("Staff");
	}

	public void clickSave() {
		saveButton.click();
	}

	public void createUser(String userName, String password, String usertype) {
		enterUserName(userName);
		enterPassword(password);
		selectUsertype(usertype);

	}

	public void admin(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		Select select = new Select(userType);

		select.selectByIndex(0);
		select.selectByValue("staff");
		select.selectByVisibleText("Staff");
		clickSave();
	}

}
