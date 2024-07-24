package com.sevenrmartsupermarket.constants;




import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {
	ExcelReader excelreader=new ExcelReader();
	
	@DataProvider(name="createadmin")
	public Object[][] verifyadmincreate()
	{
	return new Object [][] {{"admin","admin1","Admin"},{"ammu","ammu1","Admin"}};
		
		
			//return new Object [][] {{"admin"},{"admin1"},{"Admin"}};
		}
	
	@DataProvider(name="usercreate")
	public Object[][] verifycreate()
	{
		excelreader.setExcelFile("Usercreation", "Sheet1");
		return excelreader.getMultidimentionalData(2, 3);
	}
	
	

}
