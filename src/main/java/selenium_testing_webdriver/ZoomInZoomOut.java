package selenium_testing_webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		//zoom out page to 75%
		js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(3000);
		//zoom out page to 50%
		js.executeScript("document.body.style.zoom='80%'");
		
		Thread.sleep(3000);
		//zoom out page to 100%
		js.executeScript("document.body.style.zoom='100%'");
		
		driver.quit();
	}

}
