package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProviderTestNG {
	static WebDriver driver = null;
	
	@Test(dataProvider="test1data")
	public void Test1(String username, String password) throws InterruptedException {
		System.out.println(username+" | "+password);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	@DataProvider (name="test1data")
	public Object[][] getData() {
		String ProjectPath = System.getProperty("user.dir");
		Object data[][] = TestData(ProjectPath+"/Excel/data.xlsx","Sheet1");
		return data;
	}
	public Object[][] TestData(String ExcelPath, String SheetName) {
		ExcelUtils excel = new ExcelUtils(ExcelPath,SheetName);
		int rowcount = ExcelUtils.getrowcount();
		int columncount = ExcelUtils.getcolumncount();
		Object data[][] = new Object[rowcount-1][columncount];
		for(int i = 1; i < rowcount; i++) {
			for(int j = 0; j <columncount; j ++) {
				String celldata = ExcelUtils.getCellDataString(i, j); //System.out.println(celldata);
				data[i-1][j] = celldata;
			}
		} return data;
	}
}
