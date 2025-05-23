package chromeOptions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		//run in headless mode
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		//create screenshot object
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//takes fullpage screenshot
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		//saves the screenshot in the mentioned path
		File targetFile = new File(System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");
		
		//copy source file to target file
		sourceFile.renameTo(targetFile);
		
		//taking screenshot of a particuler section
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement staticTable = driver.findElement(By.xpath("//*[@id='HTML1']"));
		
		File sourceFile1 = staticTable.getScreenshotAs(OutputType.FILE);
		File tagetFile1 = new File(System.getProperty("user.dir")+"\\Screenshot\\partialpage.png");
		sourceFile1.renameTo(tagetFile1);
		
		driver.quit();
	}

}
