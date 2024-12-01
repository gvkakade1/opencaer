package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderss {

	//data provider1
	
	@DataProvider(name="logindata")
	public String[][]getData()throws IOException
	{
		String path="C:\\Workplaces\\Automation\\opencaer\\testData\\opencar_loginData.xlsx";
		ExcelUtility xutil=new ExcelUtility(path);
		
		int totalrows=xutil.getRowCount("Sheet1");
		int totalcols=xutil.getCellCount("sheet1",1);
		
		String log1[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			
			for(int j=0;j<totalcols;j++)
			{
				log1[i-1][j]=xutil.getcellData("sheet1",i,j);
				
			}
		}
		return log1;
		
		
		
	}
	
	
	
}
