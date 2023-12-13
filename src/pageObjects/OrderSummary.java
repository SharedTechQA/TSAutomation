package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummary {
	private static WebElement element = null;

	public static WebElement lblOrderID(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#divMainCtl > div.container > h2 > em"));
		
	return element;
	}
	
	public static WebElement lblAmount(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("dl.dl-horizontal:nth-child(2) > dd:nth-child(12)"));

	return element;
	}
	
	public static WebElement lblAddress(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("dl.dl-horizontal:nth-child(2) > dd:nth-child(14)"));

	return element;
	}

	public static WebElement btnConfirmEligibility(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#divMainCtl > div.container > div > a"));

	return element;
	}
	
	public static String sEligiblity = "CONFIRM YOUR ELIGIBILITY NOW";
	
}
