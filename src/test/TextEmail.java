package test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextEmail extends TestBase {
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	
	@Test
	public void testEmail() throws InterruptedException{
		WebElement elementMarketing =getObject("marketing_link");
		Actions act = new Actions(driver);
		act.moveToElement(elementMarketing).build().perform();
		
		WebElement elementlink = getObject("email_link");
		act = new Actions(driver);
		act.moveToElement(elementlink).build().perform();
		getObject("new_email_link").click();
		
		//filling input to send e-mail
		
		getObject("email_name_input").sendKeys("laptop1");
		getObject("email_folder_button").click();
		getObject("select_email_test_button").click();
		getObject("email_choose_selected_button").click();
		getObject("email_choose_campaign_folder_button").click();
		getObject("email_select_campaign").click();
		getObject("email_choose_folder_campaign").click();
		
		Thread.sleep(2000);
		getObject("email_text_only_radio_button").click();
		
		Thread.sleep(2000);
		getObject("email_template_checkbox").click();
		
		Thread.sleep(2000);
		getObject("save_email_button").click();
		
		Thread.sleep(5000);
		getObject("sending_email_button").click();
		
		Thread.sleep(5000);
		}

}
