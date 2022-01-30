package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigFiles.PropertiesFile;
import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Config_Test1_GoogleSearch2 {
	
	private static WebDriver driver = null;
	public static String BrowserName = null;

	@BeforeTest
	public void setupTest() {
		PropertiesFile.getProperties();
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("InternetExplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
	}
	
	@Test
	public static void googlesearch() throws InterruptedException {
		driver.get("https://google.com");
		if(GoogleSearchPage.cookies_accept(driver).isDisplayed()) {
				GoogleSearchPage.cookies_accept(driver).click();
		} else {};
		GoogleSearchPage.textbox_search(driver).sendKeys("facebook"+Keys.RETURN);
	//	GoogleSearchPage.button_search(driver).click();
		Thread.sleep(2000);
		}
	
	@Test
	public static void googlesearch2() throws InterruptedException {
		driver.get("https://google.com");
		try {
			if(GoogleSearchPage.cookies_accept(driver).isDisplayed()) {
				GoogleSearchPage.cookies_accept(driver).click(); }
		} catch (Exception e) {
			System.out.println(e + "Cookies question does not exist");
		}
		GoogleSearchPage.textbox_search(driver).sendKeys("facebook"+Keys.RETURN);
	//	GoogleSearchPage.button_search(driver).click();
		Thread.sleep(2000);
		}
		
	@AfterTest
	public void teardownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}

}
