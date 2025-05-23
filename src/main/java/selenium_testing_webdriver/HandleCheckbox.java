package selenium_testing_webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleCheckbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();

		// get all the days
		List<WebElement> allDays = driver
				.findElements(By.xpath("//*[contains(@class, 'post-body entry-content')]/child::div[4]/div"));

		//int n = 0;
		for (WebElement days : allDays) {

			//n++;
			String dayName = days.getText();
			if (dayName.contains("Monday") || dayName.contains("Wednesday") || dayName.contains("Friday") ) {

				days.click();
			}
		}

		Thread.sleep(5000);

		for (WebElement days : allDays) {

			if (days.isSelected()) {

				days.click();
			}
		}

		driver.quit();

		// xpath = //*[contains(@class, 'post-body entry-content')]/child::div[4]/div
	}

}
