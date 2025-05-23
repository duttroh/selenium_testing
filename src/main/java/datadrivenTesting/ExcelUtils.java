package datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowsCount(String fileName, String sheetName) throws IOException {

		int rowCount;

		fi = new FileInputStream(fileName);

		workbook = new XSSFWorkbook(fi);

		sheet = workbook.getSheet(sheetName);

		rowCount = sheet.getLastRowNum();

		workbook.close();
		fi.close();

		return rowCount;
	}

	public static int getCellsCount(String fileName, String sheetName) throws IOException {

		int cellCount;

		fi = new FileInputStream(fileName);

		workbook = new XSSFWorkbook(fi);

		sheet = workbook.getSheet(sheetName);

		cellCount = sheet.getRow(0).getLastCellNum();

		workbook.close();
		fi.close();

		return cellCount;
	}

	public static String getCellData(String fileName, String sheetName, int rowNum, int colNum) throws IOException {

		fi = new FileInputStream(fileName);

		workbook = new XSSFWorkbook(fi);

		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rowNum);

		cell = row.getCell(colNum);

		String data;

		// use try catch block, if cell is empty then it will throw exception
		try {
			//data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fi.close();

		return data;

	}

	public static void setCellData(String fileName, String sheetName, int rowNum, int colNum, String data) throws IOException {

		fi = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);

		//row = sheet.createRow(rowNum);
		row.createCell(colNum).setCellValue(data);
        //cell = row.getCell(colNum);
		// write the data in cell
        fo = new FileOutputStream(fileName);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public static void fillGreenColor(String fileName, String sheetName, int rowNum, int colNum) throws IOException {

		fi = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		
        fo = new FileOutputStream(fileName);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public static void fillRedColor(String fileName, String sheetName, int rowNum, int colNum) throws IOException {

		fi = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		
        fo = new FileOutputStream(fileName);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}
}
