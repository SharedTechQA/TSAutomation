/*********************************************************************
 * RequestHistoryPage.java
 * 
 * Element locators for use with Request History Page functionality in TS.org
 *
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class RequestHistoryPage {
	private static WebElement element = null;
	static WebDriver driver;
	
	public static void invoke(WebDriver driver) {
		if (Glob.gbMobile) {
			driver.get("https://www-qa.techsoup.org/OrderHistory");
			}
		else {
			MyAccountPage.lnkRequestHistory(driver).click();
		}
	}

	
	public static WebElement txtRequestNumber(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderHistory_txtRequestNumber"));
		
	return element;
		
	}
	
	public static WebElement btnFindRequest(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderHistory_btnSearchRequestNumber"));
		
	return element;
		
	}
	
	public static WebElement lnkOrderDetails(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.container > div:nth-child(3) > table > tbody > tr > td:nth-child(1) > a"));
		
	return element;
		
	}
	
	
	public static WebElement btnCancel(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#stsHeader > button"));
		
		
	return element;
		
	}

	public static WebElement btnCancelThisRequest(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_CancelOrder_ContinueButton"));
		
	return element;
		
	}

	public static WebElement btnAddPayment(WebDriver driver) {
		//#sts-align > a > strong
		element = driver.findElement(By.cssSelector("#stsHeader > a"));
		
		//element = driver.findElement(By.xpath("//*[@id='stsHeader']/a")); //*[@id="stsHeader"]/a
		//#sts-align > a > strong
		
		
	return element;
		
	}
	
	public static WebElement lstStartDate(WebDriver driver) {
		//#sts-align > a > strong
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderHistory_txtRequestStart"));
		
	
	return element;
		
	}
	
	public static WebElement lstEndDate(WebDriver driver) {
		//#sts-align > a > strong
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderHistory_txtRequestEnd"));
		
	
	return element;
		
	}  //#ctl00_PlaceHolderMain_OrderHistory_btnSearchRequestDateRange
	
	public static WebElement btnViewRequests(WebDriver driver) {
		//#sts-align > a > strong
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderHistory_btnSearchRequestDateRange"));
		
	
	return element;
		
	}
}
