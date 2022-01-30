import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String ProjectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", "C:/Users/akhil/Downloads/chromedriver_win32/chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
//		driver.get("https://google.com");
		//driver.close();
		
		WebDriverManager.chromedriver().setup();
	//	WebDriverManager.chromedriver().browserVersion("2.36").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		WebElement textbox = driver.findElement(By.id("ASDA")); textbox.sendKeys("ABSAD");
		List<WebElement> dummyelements = driver.findElements(By.xpath("//input"));
		int sizeval = dummyelements.size();
		driver.close();

	}

}
