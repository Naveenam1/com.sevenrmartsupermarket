package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver;
	JavascriptExecutor js;

	public PageUtility() {
		this.driver=driver;
		js=(JavascriptExecutor) driver;
	}

	public void select_byindex(WebElement element , int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
		
		
	}
	
	public void select_ByVisibleTesxt(WebElement element , String visibleText)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void select_ByVisibleValue(WebElement element , String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void js_Click(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public boolean is_Clicked(WebElement element)
	{
		try {
			element.click();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public void js_ScrollAndClick(WebElement element)
	{
		while(! is_Clicked(element))
		{
			int x=0;
			js.executeScript("\"window.scrollBy(0,\" + x + \")\"");
		}
	}
}
