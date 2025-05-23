package TestingUsingTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginOrangeHRM {
	
	WebDriver driver;
	
	//when xml file is executed, report is generated
  @Test(priority = 1)
  public void openWebPage() {
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
  }
  
  @Test(priority = 2)
  public void testLogo() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  System.out.println("Logo displayed : " +status);
  }
  
  @Test(priority = 3)
  public void logIn() {
	  
	  driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type = 'submit']")).click();
  }
  
  @Test(priority = 4)
  public void closeBrowser()
  {
	  driver.close();
  }
  
}
