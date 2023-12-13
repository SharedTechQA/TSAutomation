package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class MyAccountPage {
	private static WebElement element = null;
	//public static String sSubscribeHeader = "Subscribe to Our Free Newsletters";
	
	static WebDriver driver;
	
	public static void invoke(WebDriver driver) {
	System.out.println("invoking my-account: " + Glob.gsUrl + "my-account" );
	driver.get(Glob.gsUrl + "my-account");
		//HomePage.btn_MyAccount(driver).click();
	//MyAccountPage.btnMyAccount(driver).click ();
	}
	
	public static WebElement lblAccountPageTitle(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
		
	return element;
		
	}
	
	public static String sAccountPageTitle = "Account Details";
	
	/* ************************* Top Link Items ************** */
	public static WebElement lnkRequestHistory(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DonationHistoryLink"));
		
	return element;
		
	}
	
	public static WebElement lnkFulfillmentEmails(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_fullfillemail > a"));
		
	return element;
		
	}
	
	public static WebElement lnkTokens(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ValidationTokensLink > a"));
		
	return element;
		
	}
	
	
	
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
		//#my_organizations
		
	return element;
		
	}
	
	//setting active org, have to set a specific org, and then update back to first org.  probably first is expired, second is qualified
	public static void SetActiveOrg (String sOrg) {
		MyAccountPage.invoke(driver);
		driver.findElement(By.partialLinkText("sOrg"));
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl4_MakeActive")).click();
		//#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl4_MakeActive
	
	}
	
	public static void SetDefaultOrg (String sOrg) {
		MyAccountPage.invoke(driver);
		driver.findElement(By.partialLinkText("sOrg"));
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl0_MakeActive")).click();
		//#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl4_MakeActive
	
	}
	//reset to first
	//#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl0_MakeActive
	

	
}

