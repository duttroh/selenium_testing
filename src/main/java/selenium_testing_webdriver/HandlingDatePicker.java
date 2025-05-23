package selenium_testing_webdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDatePicker {

	public void getFutureDate(WebDriver driver, String year, String month, String date) {

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {
			String getYear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[2]")).getText();

			String getMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[1]")).getText();
			// System.out.println(getMonth);

			if (year.equalsIgnoreCase(getYear) && month.equalsIgnoreCase(getMonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//a[2]")).click();
			}
		}
		List<WebElement> alldays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement day : alldays) {
			if (date.equalsIgnoreCase(day.getText())) {
				// System.out.println(day.getText());
				day.click();
			}
		}
	}
	
	public void getPastDate(WebDriver driver, String year, String month, String date) {

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {
			String getYear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[2]")).getText();

			String getMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[1]")).getText();
			// System.out.println(getMonth);

			if (year.equalsIgnoreCase(getYear) && month.equalsIgnoreCase(getMonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//a[1]")).click();
			}
		}
		List<WebElement> alldays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement day : alldays) {
			if (date.equalsIgnoreCase(day.getText())) {
				// System.out.println(day.getText());
				day.click();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");

		// Explicit wait
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		// Thread.sleep(5000);
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(5000);

		// directly passing date
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/29/2025");

		// 2nd method
		// create two methods past date and future date
		String date = "2";
		String month = "July";
		String year = "2020";

		int yearNum = Integer.parseInt(year);

		//driver.findElement(By.xpath("//input[@id='datepicker']")).click();

//		while (true) {
//			String getYear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[2]")).getText();
//			// System.out.println(getYear);
//
//			int getYearNum = Integer.parseInt(getYear);
//			if (yearNum >= getYearNum) {
//				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//a[2]")).click();
//
//				String getMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[1]")).getText();
//				// System.out.println(getMonth);
//
//				if (year.equalsIgnoreCase(getYear) && month.equalsIgnoreCase(getMonth)) {
//					break;
//				}
//			} else if (yearNum < getYearNum) {
//				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//a[1]")).click();
//
//				String getMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']/span[1]")).getText();
//				// System.out.println(getMonth);
//
//				if (year.equalsIgnoreCase(getYear) && month.equalsIgnoreCase(getMonth)) {
//					break;
//				}
//			}
//		}
//
//		List<WebElement> alldays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
//		for (WebElement day : alldays) {
//			if (date.equalsIgnoreCase(day.getText())) {
//				// System.out.println(day.getText());
//				day.click();
//			}
//		}
		HandlingDatePicker obj = new HandlingDatePicker();
		obj.getPastDate(driver,year,month,date);

		// System.out.println(driver.findElement(By.xpath("//input[@id='datepicker']")).getText());
		driver.quit();

	}

}
