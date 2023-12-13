/*********************************************************************
 * TSWebinarPage.java
 * 
 * Verifies the main title, description, etc. are on the article card
 *
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import appModule.Glob;

public class WebinarPage {
	private static WebElement element = null;
	static WebDriver driver;
	public static String sPageTitle = "Community Events and Webinars Archive";
	public static String sWebinarCategory = "TRAINING AND EDUCATION";
	public static String sWebinarTitle = "What Can Adobe Express Do for Your Nonprofit?";
	public static String sWebinarText = "Learn how to use Adobe Express for designing, social media marketing, and publishing for your nonprofit.";
	
	public static void foo () {
		driver.get(Glob.gsUrl + "/community/events-webinars");
	}
	
	public static WebElement lblPageTitle (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
		
	return element;
		
	}
	
	public static WebElement lblWebinarCategory (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > section > div > ul > li:nth-child(1) > div > a > div > small"));
		//#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > small
	return element;
		
	}
	
	public static WebElement mnuCategory (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#categoryName"));
		
	return element;
		
	}
	public static WebElement miCategoryItem (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalCategory > div > div > div.modal-body > ul > ul > li.fn-active > a"));
		
	return element;
		
	}
	public static WebElement btnClose (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalCategory > div > div > div.modal-header > button > span"));
		
	return element;
		
	}
	
	
	
	
	
	public static WebElement lblWebinarTitle (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2__PreviousWebinars_WebinarsList_ctrl0_Title"));
//				+ "#DeltaPlaceHolderMain > section > div > ul > li:nth-child(1) > div > a > div > h3"));
//		#ctl00_PlaceHolderMain_Editmodepanel2__PreviousWebinars_WebinarsList_ctrl0_Title
		
	return element;
		
	}
		
	public static WebElement lblWebinarText (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > section > div > ul > li:nth-child(1) > div > a > div > p"));
		//#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > p
	return element;
		
	}
	
	//body > h2
	
	public static WebElement btnLoadMore (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2__PreviousWebinars_WebinarLoadMore"));
		//#ctl00_PlaceHolderMain_Editmodepanel2__articleListControl_WebinarLoadMore
		
	return element;
		
	}
	
	
}
