package TestingUsingTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
	
	//it will execute once before executing the test
	@BeforeClass
	public void logIn() {
		System.out.println("Login successfull....");
	}

	@Test(priority = 1)
	public void search() {
		System.out.println("search successfull....");
	}
	
	//TestNG will only consider @Test as actually test. SO, here only 2 methods are considered
	@Test(priority = 2)
	public void advancedSearch() {
		System.out.println("Advanced search successfull....");
	}
	
	
   //Execute only once after all the test are executed.
	@AfterClass
	public void logOut() {
		System.out.println("Logout successfull....");
	}
}
