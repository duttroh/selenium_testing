package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import datadrivenTesting.ExcelUtils;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// Reading the config.properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\config.properties");

		// creating properties class object
		Properties prop = new Properties();
		// loading the property file
		prop.load(file);

		String URL = prop.getProperty("url");

		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// clicking on Reject All cookies
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll down to 350pixels
		js.executeScript("window.scrollBy(0,350);", "");

		// zoom out to 90%
		js.executeScript("document.body.style.zoom='90%'");

		// storing file path in string
		String filePath = System.getProperty("user.dir") + "\\Testdata\\Testingpurpose.xlsx";
		// storing sheet name is string
		String sheetName = "Sheet1";

		// getting total number of rows present in the excel
		int totalRowNum = ExcelUtils.getRowsCount(filePath, sheetName);
		
		//String dep_amt = ExcelUtils.getCellData(filePath, sheetName, 1, 0);
		//System.out.println(dep_amt);

		// rotating till total rows
		for (int r = 1; r <= totalRowNum; r++) {

			//storing the intial deposit amount WebElement in variable
			WebElement initial_Deposit_amount = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			//clearing the data before entering the value
			initial_Deposit_amount.clear();
			initial_Deposit_amount.sendKeys(ExcelUtils.getCellData(filePath, sheetName, r, 0));
			
			WebElement length_CD = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			//clearing the data before entering the value
			length_CD.clear();
			length_CD.sendKeys(ExcelUtils.getCellData(filePath, sheetName, r, 1));
			
			WebElement interest_Rate = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			//clearing the data before entering the value
			interest_Rate.clear();
			interest_Rate.sendKeys(ExcelUtils.getCellData(filePath, sheetName, r, 2));
//			
			String compounding = ExcelUtils.getCellData(filePath, sheetName, r, 3);
			driver.findElement(By.xpath("//*[@id='mat-select-0']")).click();  
			driver.findElement(By.xpath("//span[text()=' "+compounding+" ']")).click();
			
			//clearing the data before entering the value
			//initial_Deposit_amount.clear();
			//initial_Deposit_amount.sendKeys(ExcelUtils.getCellData(filePath, sheetName, r, 0));
			
			driver.findElement(By.xpath("//*[@id='CIT-chart-submit']/div")).click();
			
			String result = driver.findElement(By.xpath("//*[@id='displayTotalValue']")).getText();
			System.out.println(result);
			if(result.equals(ExcelUtils.getCellData(filePath, sheetName, r, 4))) {
				System.out.println("Passed");
				ExcelUtils.setCellData(filePath, sheetName, r, 6, "Passed");
				ExcelUtils.fillGreenColor(filePath, sheetName, r, 6);
			}
			else {
				System.out.println("Failed");
				ExcelUtils.setCellData(filePath, sheetName, r, 6, "Failed");
				ExcelUtils.fillRedColor(filePath, sheetName, r, 6);
			}
			Thread.sleep(3000);
		}
		driver.quit();
	}

}
