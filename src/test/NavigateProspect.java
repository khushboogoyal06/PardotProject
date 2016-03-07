package test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigateProspect extends TestBase{
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	
	@Test 
	public void navigateToProspect(){
	WebElement elementprospect =	getObject("prospect_link");
	Actions act = new Actions(driver);
	act.moveToElement(elementprospect).build().perform();
	driver.findElement(By.xpath("//*[@id='dropmenu-prospects']/li[2]/a")).click();
	}

}
