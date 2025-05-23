package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCheckbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		//Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//get all the page numbers
		List<WebElement> pagination = driver.findElements(By.xpath("//*[@id='pagination']/li/a"));
		//System.out.println(pagination);
		for(WebElement page: pagination) {
			
			page.click();			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("page"))).click();
			List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/input"));
			for(WebElement checkbox : checkboxes) {
				checkbox.click();
				//Thread.sleep(3000);
			}
		}
		 int n = 0;
		for(WebElement page: pagination) {
			n++;
			if(n<3) {
			page.click();			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("page"))).click();
			List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/input"));
			for(WebElement checkbox : checkboxes) {
				checkbox.click();
				//Thread.sleep(3000);
			}
			}
			else {
				break;
			}
		}

	}

}
