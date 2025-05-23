package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\sampletesting.xlsx");

		// workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// getting the sheet name i.e., Sheet1
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int numOfRows = sheet.getLastRowNum();
		int numOfCells = sheet.getRow(0).getLastCellNum();

		System.out.println("Number of Rows : " + numOfRows);
		System.out.println("Number of cells : " + numOfCells);

		for (int r = 0; r <= numOfRows; r++) {
			
			//getting the row
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < numOfCells; c++) {
				
				//fetching the cell value
				XSSFCell currentCell = currentRow.getCell(c);
				//String newCurrCell = currentCell.getStringCellValue();
				System.out.print(currentCell+ "\t");
				//System.out.println("begujnaoik :" +newCurrCell);
			}
			System.out.println();
		}

	}

}
