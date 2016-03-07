package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import util.TestUtil;

@RunWith(Parameterized.class)
public class RenameOriginalList extends TestBase {
	
	public String name;
	public String name1;
	
	public RenameOriginalList(String name,String name1){	
		this.name=name;
		this.name1=name1;
		
		}
		

	@Parameters
	public static Collection<Object[]> dataSupplier(){
		System.out.println("Collecting data");
		
		// read data from temp xls file and write in into Object array.
		Object[][] data =TestUtil.getData("List");
		//Object[][] data =TestUtil.getData("Rename");
		           data =TestUtil.getData("Rename");
			
		return Arrays.asList(data);	
	}
		
	@Test
	public void renameOrigList() throws InterruptedException{
		TestUtil.navigateL();
		driver.findElement(By.linkText(name)).click();
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div/ul[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='name']")).clear();
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(name1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='save_information']")).click();
		driver.navigate().back();
		driver.navigate().back();
	}
}
