package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenshotCapture {

	TakesScreenshot takescreenshot;

	public void takeScreenshot(WebDriver driver, String imagename) {
		try {
			takescreenshot = (TakesScreenshot) driver;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);

			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination = Constants.SCREENSHOT_FILE_PATH + imagename + "_" + timeStamp + ".png";
			File finalDestination = new File(destination);
			FileHandler.copy(screenshot, finalDestination);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
