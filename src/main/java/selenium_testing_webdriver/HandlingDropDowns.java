package selenium_testing_webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
		
		//Select class
		Select select = new Select(dropDown);
		Thread.sleep(3000);
		select.selectByVisibleText("India");
		Thread.sleep(3000);
		select.selectByIndex(5);
		Thread.sleep(3000);
		select.selectByValue("canada");
		
		List<WebElement> options = select.getOptions();
		
		for(WebElement option: options) {
			System.out.println(option.getText());
			
		}
		
		driver.quit();
	}

}
