package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EINPage {
	
	private static WebElement element = null;
	static WebDriver driver;

	public static WebElement lblEINPageHeader(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > header > div > div > div > h1"));
		
		return element;
	}
	
	public static WebElement btnOrgStatus(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset.form-group.radio-set > legend > button"));
		
		return element;
	}

	public static WebElement lblEINRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset.nonpublic > div.nonpublic > fieldset > p"));
		
		
		return element;
	}
	//after clicking 501c3
	public static String sEinRequired = "If you have a tax-exempt parent organization, your organization may be covered by a group exemption. Use their EIN for faster validation. See how to find your parent organization’s EIN.";

	public static WebElement lblReligiousText (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset:nth-child(1) > div.religious > fieldset > p"));
				//("#warningtxt"));
		
		
		return element;
	}
	
	public static WebElement lblLibraryText (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset:nth-child(1) > div.fscslibrary > fieldset > p"));
				//("#warningtxt"));
		
		
		return element;
	}
	
	public static String sLibraryText = "Your eligibility for certain offers may vary depending on your 501(c)(3) status with the IRS.";

	
	//primary radio options
	//Nonprofit with 501(c)(3) status
	public static WebElement rdo501C3NonProfit(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_OrgStatusList_0"));
		
		return element;
	}
	
	String sNonprofitWith501CText = "Nonprofit with 501(c)(3) status";
	
	//rdo 1, public library #ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_PublicLibraryOrgsList > label:nth-child(2)
	public static WebElement rdoPublicLibrary (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_OrgStatusList_1"));
		
		return element;
		
	}
	String sPublicLibraryText = "Public Library";

	//you can provide an irs 501
	public static WebElement rdo501Library (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_PublicLibraryOrgsList_0"));
		
		return element;
	}
	
	String sLibraryCan = "You can provide an IRS 501(c)(3) determination letter.";
	//you cannot provide
	public static WebElement rdoNon501Library (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_PublicLibraryOrgsList_1"));
		
		return element;
	}

	String sLibraryCannot = "You cannot provide an IRS 501(c)(3) determination letter, but you have an FSCS ID.";
	
	public static WebElement txtLibraryEIN (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_PublicLibraryEINText"));
		//#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_PublicLibraryEINText
		return element;
	}
	

	public static WebElement txtFSCSIDtext (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_FSCSIDText"));
		
		return element;
		
	}
	
	public static WebElement txtFSCSID2text (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_FSCSID2Text"));
	
		return element;
		
	}
	
	//religious	
	public static WebElement rdoChurch (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_OrgStatusList_2"));
		
		return element;
	}
	
public static String sReligiousText = "While all places of worship are tax-exempt, TechSoup can only serve those that have received an IRS 501(c)(3) determination letter.";
	//You Can provide 501 letter
	public static WebElement rdoReligious501c(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_ReligiousOrgsList_0"));
		
		return element;
	}
	
	public static String sReligiousRdo1 = "You can provide an IRS 501(c)(3) determination letter.";
	
	//You assume tax exempt
	public static WebElement rdoReligiousNo501c(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_ReligiousOrgsList_1"));
		
		return element;
	}
	
	public static String sReligiousRdo2 = "You assume automatic tax exemption and cannot provide an IRS 501(c)(3) determination letter.";
	//text for items post assume choice
	public static WebElement txtReligiousNo501c1(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset.religious.form-group.radio-set > div > div.religious > fieldset > p:nth-child(1)"));
		
		return element;
	}
	public static String sAssumeTxt1 = "You may request a determination letter, or equivalent, from the IRS to prove tax-exempt status by calling (877) 829-5500.";
	//matt:  updates to text for orgs...You may request a determination letter, or equivalent, from the IRS to prove tax-exempt status by calling (877) 829-5500.
	
	public static WebElement txtReligiousNo501c2(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset.religious.form-group.radio-set > div > div.religious > fieldset > p:nth-child(2)"));
		
		return element;
	}
	public static String sAssumeTxt2 = "– OR –";
	
	public static WebElement txtReligiousNo501c3(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_Panel1 > fieldset.religious.form-group.radio-set > div > div.religious > fieldset > p:nth-child(3)"));
		
		return element;
	}
	
	
	public static String sAssumeTxt3 = "Your national parent organization is probably on TechSoup — use their EIN for faster validation. See how to find your national parent organization’s EIN.";
	
	
	public static WebElement rdoNone (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_chkNoneOfThese"));
		//#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_chkNoneOfThese
		//mwr text updated to Other
		return element;
		
	}
	
	public static WebElement btnEinOrFscs (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_EINLabel > button"));
		
		return element;
		
	}
	
	public static WebElement txtEin (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_EINText"));
		
		
		return element;
		
	}
	
	public static WebElement btnContinue (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_ContinueButton"));
		
		return element;
		
	}
	
}
