package selenium_testing_webdriver;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        driver.navigate().refresh();
        
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'OrangeHRM, Inc')]"))).click();
		
		String parentID = driver.getWindowHandle();
		System.out.println(parentID);
		
//		Set<String> windowIDs = driver.getWindowHandles();
//		
//		List<String> windowList = new ArrayList(windowIDs);
//		String parent = windowList.get(0);
//		
//		String child = windowList.get(1);
		
//		System.out.println(parent);
//		
//		System.out.println(child);
//		
//		System.out.println("Parent Title : " +driver.getTitle());
//		
//		driver.switchTo().window(child);
//		System.out.println("Parent Title : " +driver.getTitle());
		
		
//		

		//Third Method
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(child);
		
		System.out.println(driver.getTitle());
		

		driver.quit();

	}

}
