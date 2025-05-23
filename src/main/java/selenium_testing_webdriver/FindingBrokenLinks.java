package selenium_testing_webdriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingBrokenLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links: " +allLinks.size());
		
		int brokenLinksCount = 0;
		int notBrokenLinksCount = 0;
		
		for(WebElement link: allLinks) {
//			Thread.sleep(2000);
			String hrefvalue = link.getAttribute("href");
			if(hrefvalue == null || hrefvalue.isEmpty()) {
				System.out.println("No href attribute is present. So, it is not a link");
				continue;
			}
			try {
				URL linkURL = new URL(hrefvalue);
				HttpURLConnection con = (HttpURLConnection)linkURL.openConnection();
				
				//getting response code
				if(con.getResponseCode()>=400) {
					System.out.println(hrefvalue+ "=====> Broken Link");
					brokenLinksCount++;
				}
				else {
					System.out.println(hrefvalue+ "=====> Not Broken Link");
					notBrokenLinksCount++;
				}
			}
			catch(Exception e) {
				
			}
		}
		System.out.println("Number of broken links: " +brokenLinksCount);
		System.out.println("Number of not broken links count: " +notBrokenLinksCount);
		
		driver.quit();
	}

}
