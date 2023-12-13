/*********************************************************************
 * BoostSignUpPage.java
 * page elements and functions for Boost
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class BoostSignUpPage {
	private static WebElement element = null;
	
	//main page section
	
	public static WebElement lblBoostProductPageTitle(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#div-bg-img > section > div > h1"));
												     
	return element;
	}
	
	public static String sBoostButtonText = "UPGRADE TO BOOST";
	
	public static WebElement btnUpgradeToBoost (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#div-bg-img > section > div > a"));
//		#div-bg-img > section > div > a
	
	return element;
	
	}
	public static WebElement btnLoginToUpgrade(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#div-bg-img > section > div > a.btn.btn-orange.btn-xs-full-width.margin-top-bottom"));
	
	return element;
	}
	
	public static String sLblBoostMemberText = "Boost Members!";
	public static WebElement lblBoostMembers(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#div-bg-img > section > div > p"));
				
	return element;
	}
	
	public static String sLnkCheckOutCatalogText = "CHECK OUT THE BOOST CATALOG";
	public static WebElement lnkCheckOutTheBoostCatalog(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#div-bg-img > section > div > a.read-more"));
				
	return element;
	}
	
	
	
	//checkout sections
	public static WebElement lblTitle(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
												     
	return element;
	}
	
	public static WebElement rdoBoostForSmall(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_f0380a01_cadc_4514_a0fe_a5ba19aa3874_ctl00_BoostOrgTypes > tbody > tr:nth-child(1) > td > span > label > b"));
												     
	return element;
	}
	
	public static WebElement rdoBoostForMidSize(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_f0380a01_cadc_4514_a0fe_a5ba19aa3874_ctl00_BoostOrgTypes > tbody > tr:nth-child(2) > td > span > label > b"));
												     
	return element;
	}
	
	public static WebElement rdoBoostForLarge(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_f0380a01_cadc_4514_a0fe_a5ba19aa3874_ctl00_BoostOrgTypes > tbody > tr:nth-child(3) > td > span > label > b"));
												     
	return element;
	}

	public static WebElement lblBoostMemberStart (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#div-bg-img > div.container.header-content > div > p.p-margin-top"));
		
	return element;
		
	}
	
	public static String sBoostStart = "newboost org became a Boost member on April 09, 2019";
	
	public static WebElement lblBoostMemberRenewal (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#div-bg-img > div.container.header-content > div > p:nth-child(5)"));
		
	return element;
		
	}
	
	public static String sBoostRenewal = "Your Boost membership is up for renewal on April 08, 2020";
}
