package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Test1_GoogleSearch {
	
	private static WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
