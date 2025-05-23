package selenium_testing_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//scroll down page by pixel number
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll the page till element is visible
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Featured products')]"));
		
		js.executeScript("arguments[0].scrollIntoView();", ele);
		//System.out.println(js.executeScript("return window.pageXOffset;"));  //0
		System.out.println(js.executeScript("return window.pageYOffset;"));   //823
		
		//scroll to bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));  //2413
		
		driver.quit();
	}

}
