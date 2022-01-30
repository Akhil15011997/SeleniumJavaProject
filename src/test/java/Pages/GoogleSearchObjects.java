package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchObjects {
	WebDriver driver = null;
	public GoogleSearchObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By textbox_search = By.name("q");
	By cookies_accept = By.xpath("(//div[@class='QS5gu sy4vM'])[2]");
	By button_search = By.name("btnk");
	
	public void setTextinsearchbox(String text) {
		if(GoogleSearchPage.cookies_accept(driver).isDisplayed()) {
			GoogleSearchPage.cookies_accept(driver).click();
		} else {};
		driver.findElement(textbox_search).sendKeys(text+Keys.RETURN);
	}

}
