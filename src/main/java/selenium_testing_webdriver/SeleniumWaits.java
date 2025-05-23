package selenium_testing_webdriver;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Thread.sleep(5000);
        
        //implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        //Fluent wait
        //Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        
		//Maximize window
		driver.manage().window().maximize();
	
		//Fetch user name
		//String username = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--p'][1]")).getText();
		
		//enter username
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
		username.sendKeys("Admin");
		//driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		
		//enter password
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
		password.sendKeys("admin123");
		//driver.findElement(By.xpath("//*[@class='oxd-input oxd-input--active' and @name='password']")).sendKeys("admin123");
		
		//press login button
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")));
		login.click();
		//driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		
		driver.quit();
	}

}
