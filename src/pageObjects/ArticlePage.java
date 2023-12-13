/*********************************************************************
 * TSArticlePage.java
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

public class ArticlePage {
	private static WebElement element = null;
	static WebDriver driver;
	public static String sPageTitle = "Articles and How-tos";
	public static String sArticle1Category = "BUSINESS AND TECHNOLOGY PLANNING";
	public static String sArticle1Title = "What You Need to Know About Microsoft 365 Nonprofit";
	public static String sArticle1Text = "If your nonprofit needs an all-in-one solution for an operating system, Office 365, and next-level mobility and security features, you should consider a Microsoft 365 plan through TechSoup.";
	
	public static void foo () {
		driver.get(Glob.gsUrl + "/support/articles-and-how-tos");
	}
	
	public static WebElement lblPageTitle (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
		
	return element;
		
	}
	
	public static WebElement mnuArticleCategory (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Label2"));
		
	return element;
		
	}
	public static WebElement miCategoryItem (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalCategory > div > div > div.modal-body > ul > li.fn-active > a > span"));
		
	return element;
		
	}
	
	
	
	
	
	public static WebElement lblArticle1Category (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > small"));
		//#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > small
	return element;
		
	}
	
	public static WebElement lblArticle1Title (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > h3"));
		
	return element;
		
	}
		
	public static WebElement lblArticle1Text (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > h3"));
//													 #DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > h3
		//#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > p
	return element;
		
	}
	
	public static WebElement btnLoadMore (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2__articleListControl_WebinarLoadMore"));
		//#ctl00_PlaceHolderMain_Editmodepanel2__articleListControl_WebinarLoadMore
		
	return element;
		
	}
	
	
}
