package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({
LoginTest.class,
CreateList.class,
SameNameList.class,
RenameOriginalList.class,
CreateList.class,
NavigateProspect.class,
CreateProspectList.class,
TextEmail.class,
Logout.class
})
public class SuiteRunner {
	
	

}
