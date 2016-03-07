package test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import util.TestUtil;

public class LoginTest extends TestBase{
	
	@Before
	public void beforeTest() throws IOException{
		initialize();
	}
	
	// this anotations tell Junit  that this is a test case		
	@Test 
	public void loginTest(){
	driver.navigate().to(CONFIG.getProperty("testSiteName"));
	driver.manage().window().maximize();
	//selenium login code - in Utility function.
	TestUtil.dologin("pardot.applicant@pardot.com", "Applicant2012");
	}
}
