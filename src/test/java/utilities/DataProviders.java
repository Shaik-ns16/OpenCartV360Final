package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalRow = xlutil.getRowCount("Sheet1");
		int totalCol = xlutil.getCellCount("Sheet1", 1);
		
		String[][] loginData=new String[totalRow][totalCol];
		
		for(int i=1;i<=totalRow;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				loginData[i-1][j]=xlutil.getcellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
}
