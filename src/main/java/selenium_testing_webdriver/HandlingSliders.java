package selenium_testing_webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSliders {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		// TO perform mouse actions
		Actions act = new Actions(driver);

		// Storing the min_slider WebElement
		WebElement min_slider = driver.findElement(By.xpath("//*[@id='slider-range']//span[1]"));

		// getting the x and y co-ordinates of the slider
		System.out.println(min_slider.getLocation()); // (59, 257)

		// dragging the slider to the right(x-axis) by 100
		act.dragAndDropBy(min_slider, 100, 257).perform();
		Thread.sleep(3000);
		System.out.println(min_slider.getLocation()); // (157, 250)

		// Storing the min_slider WebElement
		WebElement max_slider = driver.findElement(By.xpath("//*[@id='slider-range']//span[2]"));

		// getting the x and y co-ordinates of the slider
		System.out.println(max_slider.getLocation()); // (639, 257)

		// dragging the slider to the right(x-axis) by 100
		act.dragAndDropBy(max_slider, -100, 257).perform();
		Thread.sleep(3000);
		System.out.println(max_slider.getLocation());  // (540, 257)

		driver.quit();
	}

}
