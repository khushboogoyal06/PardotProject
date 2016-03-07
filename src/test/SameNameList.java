package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.TestUtil;

@RunWith(Parameterized.class)
public class SameNameList extends TestBase {
	
	public String name;
	
	public SameNameList(String name){	
			this.name=name;
		
		}
	
	@Parameters
	public static Collection<Object[]> dataSupplier(){
		System.out.println("Collecting data");
		
		// read data from temp xls file and write in into Object array.
		Object[][] data =TestUtil.getData("List");
			
		return Arrays.asList(data);	
	}
	
	@Test
	public void sameListName() throws InterruptedException{
		TestUtil.navigateL();
		
		getObject("add_list_button").click();
		getObject("addlist_name_input").sendKeys(name);
		getObject("choose_folder_button").click();
		getObject("select_email_button").click();	
		getObject("choose_selected_button").click();
		Thread.sleep(2000);
		getObject("create_list_submit_button").click();

		WebElement errorMessage=driver.findElement(By.xpath("//*[@id='error_for_name']"));
		String errActual=errorMessage.getText();
		
		String errExpected="Please input a unique value for this field";
		if(errExpected.equals(errActual)){
			driver.findElement(By.xpath("//*[@id='dynamicList-form']/div[3]/a")).click();
		}else
			System.out.println("Not Equal");
		}		
}

