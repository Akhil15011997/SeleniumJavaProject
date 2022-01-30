package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.GoogleSearchObjects;

public class GoogleSearchPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googlesearchtext();

	}
	private static WebDriver driver = null;
	public static void googlesearchtext() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		GoogleSearchObjects searchobj = new GoogleSearchObjects(driver);
		
		driver.get("https://google.com");
		searchobj.setTextinsearchbox("facebook");
		
	}
}
