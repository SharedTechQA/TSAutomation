package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	
	private static WebElement element = null;
	static WebDriver driver;

	//browse catalog button on page
	public static WebElement btnBrowseCatalog (WebDriver driver) {	
		element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > a"));
		
		return element;
	}

}
