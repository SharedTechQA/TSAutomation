package pageObjects;
//package PageObjects;
import org.openqa.selenium.*;
import appModule.Glob;



public class ProductCatalogPage {
	private static WebElement element = null;
	static WebDriver driver;
	public static String sCatalogPageURL = Glob.gsUrl + "get-product-donations";
	//********deprecated********
	public static WebElement lblWhatAreYouLookingFor (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > h4"));
	
		return element;
	}

	
	public static WebElement pgDonorList (WebDriver driver) {
		//element = driver.findElement(By.className("modal-body"));
		element = driver.findElement(By.cssSelector("#modalDonors > div > div > div.modal-body"));
//		#modalSolutions > div > div > div.modal-body
		
		
		
		return element;
	}
	
	
	/********Donor or Company********/
	public static WebElement mnuDonorOrCompany (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > ul > li:nth-child(1) > button > span"));
	
		return element;
	}
	
	public static WebElement liDonorCompany (WebDriver driver) {
		element = driver.findElement(By.id("ProductSortList"));
		
		return element;
	}
	/********Category********/
	public static WebElement mnuCategory (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > ul > li:nth-child(2) > button > span"));
														
		return element;
	}
	
		
	public static WebElement liCategory (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalSolutions > div > div > div.modal-body > ul"));
		
		return element;
	}
	
//	#modalSolutions > div > div > div.modal-body > ul
	
	
	/********Hardware********/
	public static WebElement mnuHardware (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > ul > li:nth-child(3) > a"));
	
		return element;
	}
	
	public static WebElement lblHardware (WebDriver driver) {
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_fe386e1a_64a9_4e63_9786_bcfe356d6608 > div > header > div > div > div > h1"));
//		element = driver.findElement(By.xpath(
//		#ctl00_SPWebPartManager1_g_272ab6b7_0ac4_4779_80e2_d63ebac6ff85 > div > header > div > div > div > h1
		
		element = driver.findElement(By.xpath("//input[@class='row']"));
//		//
		return element;
	}
	
	
	/********Browse Full Catalog********/
	public static WebElement lnkBrowseFull (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > a"));
		
		
		return element;
	}
	

	
}//end
	
		
	
