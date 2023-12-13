package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;
import pageObjects.HomePage;

public class HelpPage {
	private static WebElement element = null;
	public static String sHelpHeader = "What Do You Need Help With?";
	
	
	public static void invokeHelp(WebDriver driver) {
		if (Glob.gbMobile) {
			MobileHomePage.mnuHamburger(driver).click();
			MobileHomePage.lnkHelp(driver).click();
		}
		else {
			HomePage.mnu_Help(driver).click();
		}
	}
	
	public static WebElement lblHeader(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#content > header > div > div > div > h1 > span"));
		
	return element;
		
	}
	
	public static WebElement tabHelpTopics(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#content > ul > li.active > a > abbr"));
		
	return element;
		
	}
	
	public static WebElement lblRequestingDonations(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(1) > div > h3"));
		
	return element;
		
	}
	
	
	public static WebElement lnkCheckEligibility(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(1) > div > ul > li:nth-child(1) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkLearnHowToRequest(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(1) > div > ul > li:nth-child(2) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkFindYourValidationTokens(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(1) > div > ul > li:nth-child(3) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkMicrosoftProgramChanges(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(1) > div > ul > li:nth-child(4) > a"));
		
	return element;
		
	}
	
	
	//managing your donations tab
	public static WebElement lblManaginYourDonations(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(2) > div > h3"));
		
	return element;
		
	}
	
	public static WebElement lnkViewtheStatusOfADonationRequest(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(2) > div > ul > li:nth-child(1) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkLearnAboutReturnsAndRefunds(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(2) > div > ul > li:nth-child(2) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkGetSupportForYourDonations(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(2) > div > ul > li:nth-child(3) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkGetMicrosoftDownloadHelp(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(2) > div > ul > li:nth-child(4) > a"));
		
	return element;
		
	}
	
	//Using your account
	public static WebElement lblUsingYourAccount(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(2) > div > div > h3"));
		
	return element;
		
	}
	
	public static WebElement lnkInviteANewMemberOfYourOrganization(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(3) > div > ul > li:nth-child(1) > a"));
		
	return element;
		
	}
	
	public static WebElement lnkLearnAboutTechsoupBoostSubscriptions(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#helptabportion > div > section > div:nth-child(1) > div:nth-child(3) > div > ul > li:nth-child(2) > a"));
		
	return element;
		
	}
	
	
	public static WebElement tabFAQ(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#content > ul > li:nth-child(2) > a > abbr"));
		
	return element;
		
	}
	
	
}
