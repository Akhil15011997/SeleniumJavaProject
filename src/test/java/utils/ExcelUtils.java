package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFSheet sheet; static XSSFWorkbook workbook; 
		public ExcelUtils (String ExcelPath, String SheetName) {
			try {
			workbook = new XSSFWorkbook(ExcelPath);
			sheet = workbook.getSheet(SheetName); }
			catch (Exception e) {
				e.printStackTrace(); System.out.println(e.getMessage()+"\n"+e.getCause()); }
		}
	public static void main(String[] args) {
		getCellDataString(1,0);
	}
	
	public static int getrowcount() {
		int rowcount = 0;
		try {
			rowcount = sheet.getPhysicalNumberOfRows();// System.out.println(rowcount+" is the number of rows");
		} catch (Exception e) {
			e.printStackTrace(); System.out.println(e.getMessage()+"\n"+e.getCause());
		} return rowcount;
	}
	public static int getcolumncount() {
		int colcount =0;
		try {
			colcount = sheet.getRow(0).getPhysicalNumberOfCells(); //System.out.println(colcount+" is the number of rows");
		} catch (Exception e) {
			e.printStackTrace(); System.out.println(e.getMessage()+"\n"+e.getCause()); } return colcount;
	}
	public static String getCellDataString(int rownum, int colnum) {
		String cellData = null;
		try {
			cellData= sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			e.printStackTrace(); System.out.println(e.getMessage()+"\n"+e.getCause());
		} return cellData;
	}
	public static void getCellDataNumber(int rownum, int colnum) {
		try {
			Double cellData = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			e.printStackTrace(); System.out.println(e.getMessage()+"\n"+e.getCause());
		}
	}

}
