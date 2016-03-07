package test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

//import datatable.Xls_Reader;


public class TestBase {

	//Initialzing the property file reading
	
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static WebDriver  dr=null;
	public static EventFiringWebDriver driver=null;
	public static boolean Isloggedin = false;
	public static Xls_Reader datatable=null;
	
	
	public void initialize() throws IOException{
		if (driver == null){
		
// Initialize CONFIG Properties		
		CONFIG = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//config/config.properties");
		CONFIG.load(fn); //Config object all value of property file
		System.out.println(fn);
		
//Initialize OR Properties.
		
		OR = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir")+"//src//config//OR.properties");
		OR.load(fn);
		
		
	
//Initialize webdriver
	if (CONFIG.getProperty("browser").equals("Firefox")){
		
	 dr = new FirefoxDriver();
	}else if (CONFIG.getProperty("browser").equals("IE")){
		 dr = new InternetExplorerDriver();
	}
	
//Use of Event firing WebDriver and not normal Web Driver. 
//Because with this help we can implement listner, mouse	, create odject of eventFiringWebdriver
//and pass 	
	
	 driver = new EventFiringWebDriver(dr);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
}
// Creating get object method to catch all error
//this function accepts the Xpath and return a web element.	
	
	public static WebElement getObject(String Xpathkey){
		try {
			return driver.findElement(By.xpath(OR.getProperty(Xpathkey)));
		} catch (Throwable t) {
			//System.out.println("error encountered");
		}
		//System.out.println("success");
		return driver.findElement(By.xpath(Xpathkey));
		}		
}	
