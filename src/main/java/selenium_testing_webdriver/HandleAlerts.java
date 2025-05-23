package selenium_testing_webdriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='content']/div/ul/li/button)[1]"))).click();
		
		//get text of alert box
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		
		//accept alerts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='content']/div/ul/li/button)[2]"))).click();
		//Thread.sleep(5000);
		driver.switchTo().alert().accept();
		String getTxt = driver.findElement(By.xpath("//*[@id='result']")).getText();
		boolean result = (getTxt.equalsIgnoreCase("You clicked: Ok"));
		System.out.println("Alert is accepted : " +result);
		
		//dismiss alerts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='content']/div/ul/li/button)[2]"))).click();
		//Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		getTxt = driver.findElement(By.xpath("//*[@id='result']")).getText();
		result = (getTxt.equalsIgnoreCase("You clicked: Cancel"));
		System.out.println("Alert is dismissed : " +result);
		
		//Send values to the alert box
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='content']/div/ul/li/button)[3]"))).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Rohit");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		getTxt = driver.findElement(By.xpath("//*[@id='result']")).getText();
		result = (getTxt.equalsIgnoreCase("Rohit"));
		System.out.println("Value in alert is correct : " +result);
		
		//using explicit wait 
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		driver.quit();
		
	}

}
