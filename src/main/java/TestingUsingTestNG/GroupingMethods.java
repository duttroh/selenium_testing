package TestingUsingTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupingMethods {
	@Test(priority = 1, groups = {"team1"})
	public void logIn() {
		Assert.assertTrue(false);
	}

	//on running team2 group, logIn method will also execute
	@Test(priority = 2, dependsOnMethods= {"logIn", "logOut"}, groups = {"team2"})
	public void search() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3, groups = {"team1"})
	public void advancedSearch() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4, groups = {"team2"})
	public void logOut() {
		Assert.assertTrue(true);
	}
}
