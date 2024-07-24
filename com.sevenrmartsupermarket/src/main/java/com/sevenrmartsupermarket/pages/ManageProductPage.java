package com.sevenrmartsupermarket.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageProductPage {

	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	JavascriptExecutor js;

	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Manage Product')]")
	private WebElement manageProduct;

	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Manage Product')]")
	private WebElement listProduct;

	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table[@class='table table-bordered table-hover table-sm']//thead//tr[1]//th[1]")
	private WebElement manageProducttabletitle;

	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table[@class='table table-bordered table-hover table-sm']//tr[1]//td")
	List<WebElement> fullrowheadings;

	@FindBy(xpath = "//a[contains(text(),' New')]")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleclick;

	@FindBy(xpath = "//input[@id='purpose']")
	private WebElement pricetype;

	@FindBy(xpath = "//input[@type='radio' and @value='Veg']")
	private WebElement productType;

	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categorySelect;

	@FindBy(xpath = "//input[@id='m_weight']")
	private WebElement weightvalue;

	@FindBy(xpath = "//select[@id='w_unit']")
	private WebElement weightUnit;

	@FindBy(xpath = "//input[@id='max_weight']")
	private WebElement maxWeight;

	@FindBy(xpath = "//input[@id='w_price']")
	private WebElement price;

	@FindBy(xpath = "//input[@id='w_stock']")
	private WebElement stock;

	@FindBy(xpath = "//input[@id='w_stock']")
	private WebElement stockcheckbox;

	@FindBy(xpath = "//input[@name='combo' and @checked='checked']")
	private WebElement compoClick;

	@FindBy(xpath = "//input[@name='featured' and @checked='checked']")
	private WebElement featuredClick;

	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUpload;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveClick;

	@FindBy(xpath = "//a[contains(text(),' Reset')]")
	private WebElement reset;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageproduct() {
		manageProduct.click();
		;
	}

	public void getTextOfListproducts() {
		System.out.println(listProduct.getAttribute("class"));
	}

	public String print_css_Fontstyle() {
		String css1 = "fontStyle";
		css1 = generalutility.get_cssValue(listProduct, css1);
		System.out.println(css1);
		return css1;
	}

	public void getTabletitle() {
		String titlecell = manageProducttabletitle.getText();
		System.out.println(titlecell);

	}

	public void getFullrow() {
		for (WebElement firstfullrowlist : fullrowheadings) {
			System.out.println(firstfullrowlist.getText());
		}
	}

	public void ClickonnewButton() {
		newButton.click();
		titleclick.click();
		titleclick.sendKeys("Orange");
		boolean radiopricetype = pricetype.isEnabled();
		System.out.println(radiopricetype);

		boolean radioproducttype = pricetype.isEnabled();
		System.out.println(radioproducttype);
		Select select = new Select(categorySelect);
		select.selectByIndex(0);
		// select.selectByValue("Select");
		select.selectByVisibleText("Select");

		weightvalue.sendKeys("aa");

		Select select1 = new Select(weightUnit);
		select1.selectByVisibleText("g");
		select1.selectByValue("g");

		maxWeight.sendKeys("20");
		price.sendKeys("2000");

		stock.sendKeys("10");

		boolean stockcheck = stockcheckbox.isEnabled();
		System.out.println(stockcheck);

	}

	public void Reset() {
		reset.click();
		String css2 = "fontStyle";
		generalutility.get_cssValue(reset, css2);
		System.out.println(css2);

	}

}
