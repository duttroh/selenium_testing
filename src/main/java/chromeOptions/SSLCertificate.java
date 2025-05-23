package chromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		
		//accepts SSL certificates
		options.setAcceptInsecureCerts(true);
		
		//removes-- Chrome is being controlled by automation software
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		driver.manage().window().maximize();
		
		//get the title 
		System.out.println(driver.getTitle());
		
//		driver.quit();
	}

}
