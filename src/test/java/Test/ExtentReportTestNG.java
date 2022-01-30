package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportTestNG {

	static WebDriver driver = null;
	
	ExtentSparkReporter htmlReporter; ExtentReports extent;
	@BeforeSuite
	public void setup() { 
		String ProjectPath = System.getProperty("user.dir");
		  htmlReporter = new ExtentSparkReporter("extentreport.html");	
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
	}
	
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ExtentTest test = extent.createTest("Google Search", "Search Facebook");
		test.log(Status.INFO, "Open Browser");
		driver.get("https://google.com");
		if(GoogleSearchPage.cookies_accept(driver).isDisplayed()) {
				GoogleSearchPage.cookies_accept(driver).click();
		} else {};
		GoogleSearchPage.textbox_search(driver).sendKeys("facebook"+Keys.RETURN);
	//	GoogleSearchPage.button_search(driver).click();
		Thread.sleep(2000);
		test.pass("Searched browser");
	   //  test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build()); 
	  //   test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
		extent.flush();
	}
}
