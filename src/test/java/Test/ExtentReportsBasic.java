package Test;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasic {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		

	  String ProjectPath = System.getProperty("user.dir");
	  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
		
	  ExtentReports extent = new ExtentReports();
	  
	  extent.attachReporter(htmlReporter);

	  ExtentTest test = extent.createTest("Google Search", "Search Facebook");
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test.log(Status.INFO, "Open Browser");
		driver.get("https://google.com");
		if(GoogleSearchPage.cookies_accept(driver).isDisplayed()) {
				GoogleSearchPage.cookies_accept(driver).click();
		} else {};
		GoogleSearchPage.textbox_search(driver).sendKeys("facebook"+Keys.RETURN);
	//	GoogleSearchPage.button_search(driver).click();
		Thread.sleep(2000);
		test.pass("Searched browsre");
		
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
		test.info("completed");
		extent.flush();
	}  
}
