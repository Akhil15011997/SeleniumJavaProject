package utils;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		String ProjectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(ProjectPath+"/Excel/data.xlsx","Sheet1");
		excel.getCellDataNumber(1, 1); excel.getCellDataString(0, 0);
	}

}
