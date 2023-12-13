package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

import appModule.Glob;

public class cloudCatalogPage extends ProductCatalogPage {

	private static WebElement element = null;
	static WebDriver driver;
	
	
	public static String sCloudPageURL = Glob.gsUrl + "cloud-computing";
	//https://www-qa.techsoup.org/cloud-computing?cg=hp
	
	public static WebElement lstCategory(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ProductsTasksList_CategoryList"));
		
		//#navDonation > a
	
		return element;
	}	
	
//	public static Select lstCategory2 = new Select(driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ProductsTasksList_CategoryList")));
	
			
	
	

}
