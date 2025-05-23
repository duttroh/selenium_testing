package TestingUsingTestNG;

import org.testng.annotations.Test;

public class FirstTestCase {

	//by default testNG will execute all the methods in alphabetical order
	//use priority to control the order of execution
	//if no priority is mentioned then it is consider as zero(0)
	//negative numbers are also allowed in priority
	//TestNG will only execute the methods which have annotations
	@Test(priority = 1)
	void openApp() {
		System.out.println("Open the Application...");
	}
	
	@Test(priority = 2)
	void logIn() {
		System.out.println("Login to Application....");
	}
	
	//@Test(priority = 3)
	//TestNG will not execute it
	void logOut() {
		System.out.println("Logout of the Application...");
	}
}
