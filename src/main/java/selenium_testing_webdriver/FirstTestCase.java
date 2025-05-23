package selenium_testing_webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		//open the url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		
		//Maximize window
		driver.manage().window().maximize();
		
		//get title of the webpage
		String title = driver.getTitle();
		System.out.println(title);
		
		//print title of current url
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		
		//to check a element is present or not
		boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img")).isDisplayed();
		System.out.println("Element is preent: "+ logo);
		
		//to check a element is enabled or not
		boolean eleEnabled = driver.findElement(By.xpath("(//*[@class='oxd-form-row']/div)[1]/div[2]")).isEnabled();
		System.out.println("Element is Enabled : "+eleEnabled);
		
		//to check a element is selected or not(.isSelected)
		
		driver.quit();

	}

}
