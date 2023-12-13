package pageObjects;

///not a valid page right now....4/26/19


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class CheckOutPage {
	private static WebElement element = null;
	//public static String sSubscribeHeader = "Subscribe to Our Free Newsletters";
	
	public static void invoke(WebDriver driver) {
	driver.get(Glob.gsUrl + "my-account");
		//HomePage.btn_MyAccount(driver).click();
	//MyAccountPage.btnMyAccount(driver).click ();
	}
	
	//boost message
	//#divMainCtl > div.container > p
	
	//button page header part
	public static WebElement lblMemberName(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#myAccount > div.dropdown-menu > dl > dd.user-fullname.login-user-fullname.lo_sensitive"));
		
	return element;
		
	}
	
	public static WebElement pgContainer (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#myAccount > div.dropdown-menu"));
		
	return element;
	
	}
	
	public static WebElement btnMyAccount (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#myAccount"));
		
	return element;
		
	}
	
	public static WebElement btnLogOut (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#signOut"));
		
	return element;
		
	}

	public static WebElement lnkMemberOrg (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#login-user-orgname"));
		
	return element;
	}
	
	//account details page 
	
	public static WebElement lblTitle (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
		
	return element;
	}
	
	public static WebElement liAccountDetails (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#accountMenu > li.active"));
		
	return element;
	}
	
	public static WebElement btnAddOrg (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_RegisterOrgLink"));
		
	return element;
	}
	
	public static WebElement btnEditMemberDetails (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ProfileDisplay_EditInformation"));
		
	return element;
	}
	
	public static WebElement btnChangePassword (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ProfileDisplay_ChangePassword"));
		
	return element;
	}	
	///org table
	public static WebElement tblMyOrganizations (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#my_organizations"));//("#myOrgs"));
		
	return element;
		
	}
}
