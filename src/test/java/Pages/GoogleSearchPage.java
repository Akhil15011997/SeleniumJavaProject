package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	private static WebElement element = null;

	public static WebElement textbox_search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement cookies_accept(WebDriver driver) {
		element = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
		return element;
	}
	public static WebElement button_search(WebDriver driver) {
		element = driver.findElement(By.name("btnk"));
		return element;
	}
}
