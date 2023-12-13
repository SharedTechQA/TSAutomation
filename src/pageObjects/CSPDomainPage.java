/*********************************************************************
 * cspdomainPage.java
 * 
 * Element locators and methods for use with Cart functionality in TS.org
 *

 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import appModule.Glob;
import pageObjects.HomePage;


//cart and checkout pages objects, methods, etc.

public class CSPDomainPage {

	private static WebElement element = null;
	static WebDriver driver;
	public static String sPageUrl = "https://www-qa.techsoup.org/csp-verification";

	public static WebElement btnGoToMSFT(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.ng-scope > section.container.addToCartCSPPopup > div.row.text-center.margin-top-bottom.bg-lightest-gray > div > div > a"));

	return element;
	}
	
	public static WebElement btnDomainToggle(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.ng-scope > section.container.addToCartCSPPopup > div.row.text-center.margin-top-bottom.whiteBoxContent > div.tog > span.off > img"));

	return element;
	}
	
	public static WebElement txtDomainName(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#domainnameAddToCart"));
//		was domainname
	return element;
	}

	public static WebElement txtCustomDomainName(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#customDomainName"));

	return element;
	}
	public static WebElement btnUseThisDomain(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.ng-scope > section.container.addToCartCSPPopup > div.row.text-center.margin-top-bottom.whiteBoxContent > div.ng-valid.ng-valid-pattern.ng-dirty.ng-valid-parse > div.microsoftDomain > div:nth-child(3) > input")); 
												
		return element;
	}
	
	public static WebElement btnUseThisCustomDomain(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.ng-scope > section.container.addToCartCSPPopup > div.row.text-center.margin-top-bottom.whiteBoxContent > div.ng-dirty.ng-valid-parse.ng-valid.ng-valid-pattern > div.customDomain > div:nth-child(3) > input")); 
													 
		return element;
	}
	
	public static WebElement btnVerifyDomain(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#verifyUser")); 
	
		return element;
	}
	
	public static WebElement lstVerifyError(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#retryUser > p:nth-child(1)")); 
	
		return element;
	}
	
	
}
	
	

