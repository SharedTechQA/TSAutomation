package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectOrgPage {

	private static WebElement element = null;
	static WebDriver driver;
	
	public static WebElement lblEINPageHeader(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > header > div > div > div > h1"));
		
		return element;
	}
	
	public static WebElement btnSaveForLater(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(3) > a"));
		
		return element;
	}
	
	public static WebElement lblEINorFSCS(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_OrgEINText > b"));
		
		return element;
	}
	
	public static WebElement lstState(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_RegionCode"));
		
		return element;
	}
	
	
	public static WebElement txtZipCode(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_TxtZipCode"));
		
		return element;
	}
	
	public static WebElement btnSubmit(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_BtnSearch"));
		
		return element;
	}
	
	public static WebElement btnIDontSeeMyOrg(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_NewReg"));
		
		return element;
	}
	
	public static WebElement btnGoBack (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_LinkButton2"));
		
		return element;
	}
	//lower Don't see org

	public static WebElement btnDontSeeOrg2 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_NewReg"));
		
		return element;
	}
	
	//list of orgs
	public static WebElement rdoFirstOrg (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(11) > table > tbody > tr > td.td-bold-mobile.ng-binding"));
		//#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(11) > table > tbody > tr > td.hidden-mobile
		//#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_OrgName
//		#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(8) > table > tbody > tr > td.td-bold-mobile.ng-binding
		//#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgResults1_OrgName
//		#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(8) > table > tbody > tr > td.td-bold-mobile.ng-binding
		
		return element;
	}
	
	public static WebElement lstAlreadyAssociated (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(11) > table > tbody > tr > td.td-bold-mobile.ng-binding > small"));
//													 #ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(11) > table > tbody > tr > td.td-bold-mobile.ng-binding > small
		//#ctl00_PlaceHolderMain_SPAssociateOrg1 > div.container.container-extra.org-container-top-bot.ng-scope > div:nth-child(8) > table > tbody > tr:nth-child(20) > td.td-bold-mobile.ng-binding > small
		return element;
	}
	
	
}
