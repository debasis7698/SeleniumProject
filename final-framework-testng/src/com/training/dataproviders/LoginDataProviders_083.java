package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
//import com.training.readexcel.ApachePOIExcelRead_082;
import com.training.readexcel.ApachePOIExcelRead_083;
//import com.training.readexcel.ApachePOIExcelRead_085;
//import com.training.readexcel.ApachePOIExcelRead;
//import com.training.readexcel.ApachePOIExcelRead_085_old;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders_083 {

	private static final int START_ROW = 107;
	private static final int START_COL = 2;
	private static final int TOTAL_ROWS = 3;
	private static final int TOTAL_COLUMNS = 8;

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		String fileName ="C:\\Debasis\\Reskill\\Selenium\\After Interim\\Retail_complex.xlsx";
		
		//return new ApachePOIExcelRead_085().getExcelContent(fileName);
		return new ApachePOIExcelRead_083().getExcelContent(fileName, "Test Data",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS);
		
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
	// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Debasis\\Reskill\\Selenium\\After Interim\\Retail_complex.xlsx", "Sheet1"); 
	}
}

