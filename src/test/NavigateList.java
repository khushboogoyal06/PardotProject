package test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigateList extends TestBase {

	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	
	// this anotations tell Junit  that this is a test case	
	
	@Test 
	public void navigateToList(){
	
	WebElement elementmarketing =	getObject("marketing_link");
	Actions act = new Actions(driver);
	act.moveToElement(elementmarketing).build().perform();
	
	WebElement elementsegment =	getObject("//*[@id='dropmenu-marketing']/li[12]/a");
	act = new Actions(driver);
	act.moveToElement(elementsegment).build().perform();
	driver.findElement(By.xpath("//*[@id='dropmenu-marketing']/li[12]/ul/li[1]/a")).click();	
	}
}
