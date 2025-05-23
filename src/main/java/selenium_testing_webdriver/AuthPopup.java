package selenium_testing_webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// add username and password in the url itself (admin:admin)
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		// Explicit wait
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();

		String txt = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		System.out.println(txt);

		if (txt.contains("Congratulations")) {
			System.out.println("Page open successfully");
		} else {
			System.out.println("Page is not open successfully");
		}
		
		driver.quit();

	}

}
