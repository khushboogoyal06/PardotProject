package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.Xls_Reader;
import test.TestBase;

public class TestUtil extends TestBase{

	public static void dologin(String username,String password){
		
		if (Isloggedin){
			return;
		}
		getObject("username_signin_input").sendKeys(username);
		getObject("password_signing_input").sendKeys(password);
		getObject("login_button").click();
		
		//getobject(Xpathval) - getodject method calling from testbase.
		//getObject("//*[@id='email_address']").sendKeys(username);
		//getObject(OR.getProperty("username_signin_input")).sendKeys(username);
}
	public static void navigateL(){
		WebElement elementmarketing =getObject("marketing_link");
		Actions act = new Actions(driver);
		act.moveToElement(elementmarketing).build().perform();
		
		//WebElement elementsegment =driver.findElement(By.xpath("//*[@id='dropmenu-marketing']/li[12]/a"));
		WebElement elementsegment =	getObject("//*[@id='dropmenu-marketing']/li[12]/a");
		act = new Actions(driver);
		act.moveToElement(elementsegment).build().perform();
		driver.findElement(By.xpath("//*[@id='dropmenu-marketing']/li[12]/ul/li[1]/a")).click();

	}
	
	
	// get the data from xls file
		public static Object[][] getData(String testName){
			// return test data;
			// read test data from xls
			if(datatable == null){
				// load the suite 1 sheet
				//datatable = new Xls_Reader("C:\\Users\\anupam\\Downloads\\xls_file\\temp.xlsx");
				//datatable = new Xls_Reader("C:\\Khushboo's Workspace\\Copy of Module12_saleforce\\Suite1.xlsx");
				//datatable = new Xls_Reader(System.getProperty("user.dir")+"\\src\\Config\\temp.xlsx");
				datatable = new Xls_Reader(System.getProperty("user.dir")+"//src//Config//Suite1.xlsx");
				
			}
			
			int rows=datatable.getRowCount(testName)-1;
			if(rows <=0){
				Object[][] testData =new Object[1][0];
				return testData;
				
			}
		    rows = datatable.getRowCount(testName);  // 3
			int cols = datatable.getColumnCount(testName);
			System.out.println("Test Name -- "+testName);
			System.out.println("total rows -- "+ rows);
			System.out.println("total cols -- "+cols);
			Object data[][] = new Object[rows-1][cols];
			
			
			for(int rowNum = 2 ; rowNum <= rows ; rowNum++){
				
				for(int colNum=0 ; colNum< cols; colNum++){
					data[rowNum-2][colNum]=datatable.getCellData(testName, colNum, rowNum);
				}
			}
			
			return data;
			
		}
}
