package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base {

	ManageProductPage manageproduct;
	LoginPage loginpage;

	@Test(groups = "smoke")

	public void verifyManageproduct() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproduct = new ManageProductPage(driver);
		manageproduct.clickOnManageproduct();
		manageproduct.getTextOfListproducts();

	}

	@Test(groups = { "Smoke", "regresion" })

	public void manageproductverifyTable() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproduct = new ManageProductPage(driver);
		manageproduct.clickOnManageproduct();
		manageproduct.print_css_Fontstyle();
		manageproduct.getTabletitle();
		manageproduct.getFullrow();

	}

	@Test(groups = "regression")

	public void verifynewButton() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproduct = new ManageProductPage(driver);
		manageproduct.clickOnManageproduct();
		manageproduct.ClickonnewButton();

	}

	@Test
	public void verifyReset() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproduct = new ManageProductPage(driver);
		manageproduct.clickOnManageproduct();
		manageproduct.Reset();
	}

}
