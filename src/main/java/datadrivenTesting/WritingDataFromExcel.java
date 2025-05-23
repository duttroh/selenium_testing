package datadrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\myfile.xlsx");
		
		//Creating workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Creating sheet
		XSSFSheet sheet = workbook.createSheet("NewSheet");
		
		//Adding data to the 1st row
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Language");
		row1.createCell(1).setCellValue("Name");
		row1.createCell(2).setCellValue("ID");
		
		//Adding data to 2nd row
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Java");
		row2.createCell(1).setCellValue("Rohit");
		row2.createCell(2).setCellValue(2129637);
		
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
