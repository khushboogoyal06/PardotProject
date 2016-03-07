package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import util.TestUtil;


@RunWith(Parameterized.class)
public class CreateProspectList extends TestBase {
	
	public String firstname;
	public String lastname;
	public String emailname;
	public String companyname;
	public String campaign;
	public String profilename;
	public String score;
	public String listname;
	
	
	public CreateProspectList(String firstname,
							  String lastname,
							  String emailname,
							  String companyname,
							  String campaign,
							  String profilename,
							  String score,
							  String listname){
		
			this.firstname=firstname;
			this.lastname=lastname;
			this.emailname=emailname;
			this.companyname=companyname;
			this.campaign=campaign;
			this.profilename=profilename;
			this.listname=listname;
			
		
		}
		

	@Parameters
	public static Collection<Object[]> dataSupplier(){
		System.out.println("Collecting data");
		
		// read data from temp xls file and write in into Object array.
		Object[][] data =TestUtil.getData("Prospect");
			
		return Arrays.asList(data);	
	}


	@Test
	public void createPospectList() throws InterruptedException{
		
		getObject("add_prospect_button").click();
		getObject("prospect_first_name_input").sendKeys(firstname);
		getObject("prospect_last_name_input").sendKeys(lastname);
		getObject("prospect_emailid-input").sendKeys(emailname);
		getObject("prospect_company_input").sendKeys(companyname);
		getObject("prospect_compaign_dropdown").sendKeys(campaign);
		getObject("prospect_profile_dropdown").sendKeys(profilename);
		getObject("prospect_score_input").sendKeys(score);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 800)");
		
		getObject("list_click").click();
		//System.out.println("Before Success");
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/div/div/div[1]/div/form/div[20]/div/div/div/div/div[1]/a/span")).click();
		//System.out.println("After Success");
		WebElement keys=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/div/div/div[1]/div/form/div[20]/div/div/div/div/div[1]/div/div/input"));
		keys.sendKeys(listname);
		keys.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		getObject("create_prospect_submit_button").click();
		Thread.sleep(2000);
}
}