package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public WebDriver driver;
	WebDriverWait wait;

	public WaitUtility(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void wait_For_Clickable(WebElement element ,long duration)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void wait_For_Locator(String locator,long duration)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}
	
	//by locator
	public void wait_For_Locator(By locator,long duration)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

}
