package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		//Actions class
		Actions act = new Actions(driver);
		
		Thread.sleep(4000);
		//Storing the WebElement
		WebElement Register = driver.findElement(By.xpath("//*[contains(text(),'Register')]"));
		
		act.keyDown(Keys.CONTROL).click(Register).keyUp(Keys.CONTROL).perform();
		
		driver.quit();
	}

}
