package datadrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicallyWritingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\DynamicValue.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("DataSheet1");
		
		Scanner sc = new Scanner(System.in);
		int rowCount = sc.nextInt();
		int cellCount = sc.nextInt();
		
		for(int r=0;r<=rowCount;r++) {
			
			//select the rows
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<cellCount;c++) {
				
				//set values in the cells
				row.createCell(c).setCellValue(sc.next());
				
			}
			
		}
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created");
		
	}

}
