package TestingUsingTestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DependencyMethods {
	
	//only this test case will fail and rest will pass
	@Test(priority = 1)
	public void logIn() {
		Assert.assertTrue(false);
	}

	//this method will skip and below two will pass
	@Test(priority = 2, dependsOnMethods= {"logIn", "logOut"})
	public void search() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3)
	public void advancedSearch() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4)
	public void logOut() {
		Assert.assertTrue(true);
	}
}
