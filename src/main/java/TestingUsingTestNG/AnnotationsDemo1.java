package TestingUsingTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo1 {

	//it will execute before every @Test
	@BeforeSuite
	public void beforeEverySuite() {
		System.out.println("Executed before every suite present in xml file");
	}
	
	@BeforeTest
	public void beforeEveryTest() {
		System.out.println("Executed before every Test present in xml file");
	}
	
	@BeforeMethod
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
	
	//it will execute after every @Test
	@AfterMethod
	public void logOut() {
		System.out.println("Logout successfull....");
	}
	
	@AfterSuite
	public void afterEverySuite() {
		System.out.println("Executed after every suite present in xml file");
	}
	
	@AfterTest
	public void afterEveryTest() {
		System.out.println("Executed after every Test present in xml file");
	}

}
