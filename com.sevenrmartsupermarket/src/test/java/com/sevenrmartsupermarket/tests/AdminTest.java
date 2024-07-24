package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.AdminPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminTest extends Base {

	AdminPage adminpage;
	LoginPage loginpage;

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)

	public void verifyAdminpage() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminpage = new AdminPage(driver);
		
		adminpage.adminpageClick();
		String actualProfileName = adminpage.getProfilenameofAdminpage();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		adminpage.clickNewbutton();

	}

	@Test(dataProvider = "usercreate", dataProviderClass = DataProviders.class)
	public void userCreate(String userName, String password, String usertype) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminpage = new AdminPage(driver);
		adminpage.adminpageClick();
		adminpage.clickNewbutton();

		adminpage.createUser(userName, password, usertype);
		adminpage.clickSave();

	}

}
