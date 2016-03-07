package test;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Logout extends TestBase {
	
	@Test
	public void logOut() throws InterruptedException{
		
		Thread.sleep(5000);
		WebElement elementLogout=getObject("logout_button");
		Actions actLogout = new Actions(driver);
		actLogout.moveToElement(elementLogout).build().perform();
		Thread.sleep(2000);
		getObject("logout_button_click").click();		
	}

}
