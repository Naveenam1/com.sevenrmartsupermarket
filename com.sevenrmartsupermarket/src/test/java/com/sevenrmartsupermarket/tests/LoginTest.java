package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;

	ExcelReader excelreader = new ExcelReader();

	ScreenshotCapture screenshot = new ScreenshotCapture();

	@Test()

	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);

		loginpage.login();
		String actualProfileName = homepage.getprofileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		// screenshot.takeScreenshot(driver, "phone");
		System.out.println(GeneralUtility.getRandomname());
	}

	@Test

	public void verifyData() {
		excelreader.setExcelFile("logindata", "login");
		System.out.println(excelreader.getCell_Data(1, 1));
	}

	@Test(groups = "regression")

	public void verifyLogin_Excel() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login_Excel();
		String actualProfileName = homepage.getprofileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}
}
