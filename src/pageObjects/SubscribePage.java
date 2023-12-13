package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscribePage {
	private static WebElement element = null;
	public static String sSubscribeHeader = "Subscribe to Our Free Newsletters";
	
	public static void invoke(WebDriver driver) {
	HomePage.btnSubscribe(driver).click();
	}
	
	
	public static WebElement lblHeader(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div:nth-child(3) > main > header > div > div > div > h1"));
		
	return element;
		
	}
	
	public static WebElement btnByTheCup (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#RadioOne"));
	
	return element;
	}
	
	public static WebElement btnProductAlert (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#RadioTwo"));
				
	return element;
	}
	
	public static WebElement btnTechSoupforLibraries (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div:nth-child(3) > main > div.container.spcontainer > div.form.margin-top-bottom > fieldset:nth-child(1) > div.col-xs-12.col-sm-6.col-sm-offset-3.col-md-4.col-md-offset-2.col-lg-3.col-lg-offset-3 > label > span"));
		//#DeltaPlaceHolderMain > div:nth-child(3) > main > div.container.spcontainer > div.form.margin-top-bottom > fieldset:nth-child(1) > div.col-xs-12.col-sm-6.col-sm-offset-3.col-md-4.col-md-offset-2.col-lg-3.col-lg-offset-3 > label > span
		////*[@id="DeltaPlaceHolderMain"]/div[1]/main/div[1]/div[2]/fieldset[1]/div[2]/label/span
				
	return element;
	}
	
	public static WebElement txtEmailAddress (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContent1_NewsLetterSubscribe_EmailNewsLetterTxtBox"));
	
	return element;
	}

	public static WebElement txtConfirmEmailAddress (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContent1_NewsLetterSubscribe_ConfirmEmailNewsLetterTxtBox"));
		
	return element;
	}
	
	public static WebElement chkCaptcha (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#recaptcha-anchor-label"));
	
	return element;
	}
	
	public static WebElement btnSubscribe (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContent1_NewsLetterSubscribe_ConfirmEmailNewsLetterTxtBox"));
		
	return element;
	}
}
