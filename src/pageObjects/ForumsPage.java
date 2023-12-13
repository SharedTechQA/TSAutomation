/*
 * forums elements and basic methods
 * 
 * 
 * 
 * discourse basic check
 * 
 * 
 * 
 * */

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class ForumsPage {
	
	private static WebElement element = null;
	static WebDriver driver;
	public static String sUrl = Glob.gsUrl;

	public static WebElement lblCommunityPageHeader(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#fragment-11410 > div > div.content-fragment-content > h1"));

		return element;
	}
	public static WebElement btnLogIn(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#login"));
		//element = driver.findElement(By.xpath("/html/body/div[1]/button[1]"));
		//#login
				
		return element;
	}
	
	public static WebElement lblForumsPageHeader(WebDriver driver) { 
//		//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
		element = driver.findElement(By.cssSelector("#site-logo"));
		return element;
	}
	public static WebElement btnSearch(WebDriver driver) { 
//		//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
		element = driver.findElement(By.cssSelector("#search-button > svg"));
		return element;
	}
	public static WebElement txtSearchTerm(WebDriver driver) { 
//		//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
		element = driver.findElement(By.cssSelector("#search-term"));
		return element;
	}
	
	public static WebElement lblSearchCount(WebDriver driver) { 
//		//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
		element = driver.findElement(By.cssSelector("#search-result-count > span:nth-child(1)"));
//		#search-result-count > span:nth-child(1)
		return element;
	}
	
	public static WebElement lnkReturnToTechsoup(WebDriver driver) { 
//		//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
		element = driver.findElement(By.cssSelector("body > div.navtopdiv > a > span"));
		
		return element;
	}
	public static WebElement btnNewTopic(WebDriver driver) { 
//		//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
		element = driver.findElement(By.cssSelector("#create-topic > span"));
		return element;
	}
	
	public static WebElement txtTitle (WebDriver driver) {
		return element = driver.findElement(By.cssSelector("#reply-title"));
	}
	public static WebElement txtBody (WebDriver driver) {
		return element = driver.findElement(By.cssSelector("#ember264"));
	}
	public static WebElement btnCreateTopic (WebDriver driver) {
		return element = driver.findElement(By.cssSelector("#ember271 > span"));
	}
	
	public static WebElement lstCategory (WebDriver driver) {
		return element = driver.findElement(By.cssSelector("#reply-control > div.reply-area.with-tags > div.composer-fields > div.title-and-category.with-preview > div.category-input"));
	}
	public static WebElement lstElement (WebDriver driver) {
		return element = driver.findElement(By.cssSelector("#ember665elector"));
	}
//methods
	public static void searchForums (WebDriver driver, String sSearchTerm, String sExpectedCount) throws InterruptedException {
		String sFound;
		ForumsPage.btnSearch(driver).getLocation();
		ForumsPage.btnSearch(driver).click();
		ForumsPage.txtSearchTerm(driver).sendKeys(sSearchTerm);
		ForumsPage.txtSearchTerm(driver).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		ForumsPage.txtSearchTerm(driver).sendKeys(Keys.ENTER);
//		ForumsPage.txtSearchTerm(driver).sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		sFound = ForumsPage.lblSearchCount(driver).getText();

		System.out.println("found " + ForumsPage.lblSearchCount(driver).getText() + " Expected: " + sExpectedCount);
		
	}
	
}
