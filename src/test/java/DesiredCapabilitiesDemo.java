import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilitiesDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		WebDriverManager.iedriver().setup();
		WebDriver  driver = new InternetExplorerDriver(caps);
		driver.get("https://google.com");
		if(GoogleSearchPage.cookies_accept(driver).isDisplayed()) {
				GoogleSearchPage.cookies_accept(driver).click();
		} else {};
		GoogleSearchPage.textbox_search(driver).sendKeys("facebook"+Keys.RETURN);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	

}
