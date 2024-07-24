package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	ExcelReader excelreader = new ExcelReader();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signinButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		try {
			FileInputStream file = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {

		signinButton.click();
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();
	}

	public void login() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();

	}

	public void login_Excel() {
		excelreader.setExcelFile("logindata", "login");
		String userName = excelreader.getCell_Data(1, 0);
		String password = excelreader.getCell_Data(1, 1);
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();
	}

}
