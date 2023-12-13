package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DomainsPage {
	
	private static WebElement element = null;
	static WebDriver driver;

	//browse catalog button on page
	
	public static WebElement btnPickaDomain (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#chooseDomainBtn"));
		return element;
	}

	public static WebElement txtDomainName (WebDriver driver) {	
		element = driver.findElement(By.cssSelector("#txtDomainName"));
//		#txtDomainName
		
		return element;
	}
	
	public static WebElement lblDomainPrice (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#headerSubText"));
		return element;
	}
	public static WebElement btnChooseYourDomain (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#chooseDomainBtn"));
		return element;
	}
	public static WebElement lblWhatAdress(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#headerText"));
		return element;
	}
	public static WebElement lblWOwnfor10(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#headerSubText"));
		return element;
	}

	public static WebElement btnSearch (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DomainAvailabilityControl_btnSearchDomain"));
		return element;
	}

	//results
	public static WebElement btnRequestDomain (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#requestDomianBtn"));
//		#requestDomianBtn
//		#requestDomianBtn
		return element;
	}
	public static WebElement btnRequestAltDomain (WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/div/div/div[3]/div/div/div[1]/div[4]/div[1]/div/div/div/div[4]/div[2]/div/input[1]"));
		return element;
		
	}
		
	
	public static WebElement lblDomainNotAvailable (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#domain-registration > div:nth-child(5) > div.domain-status > div"));
//		element = driver.findElement(By.cssSelector("#domain-registration > div:nth-child(4) > div.domain-status > div > p"));
//		#domain-registration > div:nth-child(5) > div.domain-status > div
		//#unavailable-btn
		//
		return element;
	}
			
	public static String sDomainNotAvailableText = "Unavailable";
	
	public static WebElement btnShow10More (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#showdMoreBtn"));
		return element;
	}
	
	public static WebElement btnLogIn (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#loginBtn"));
		return element;
	}
	
	//Additional information needed page
	//url https://www-qa.techsoup.org/domain-purchase
	
	public static WebElement lblMoreInfoHeader (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#headerText"));
		return element;
	}
	

	public static String sMoreInfoHeader = "Additional Information Needed for Domain Registration";
	
	public static WebElement lblMoreInfoText (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#additionalInformation > div > p"));
		return element;
	}
	public static String sMoreInfoText = "Domain name registration is powered by TechSoup’s partnership with Newfold Digital, a trusted domain registrar.";
	
	public static WebElement chkPrivacy (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#additionalInformation > div > fieldset > div > div > dl > dd:nth-child(18) > div > label > span"));
		return element;
	}
	
	public static WebElement lblPrivacyText (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#additionalInformation > div > p"));
		return element;
	}
	
	public static WebElement lblAgreement (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.container > div > div.ng-scope > div > div > div.form.form-horizontal.form-group > div > label > span"));
		return element;
	}
	
	
	public static String sPrivacyText = "For an additional $3.00, domain ownership information can be hidden from public view.";
	
	public static WebElement btnCheckout (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrgResellarCustomerDetails_CheckoutBtn"));
//		#ctl00_PlaceHolderMain_OrgResellarCustomerDetails_CheckoutBtn
		return element;
	}
	
	public static WebElement btnPrivacyHelp (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#additionalInformation > div > fieldset > div > div > dl > dt.accountInfo.privacy-protection-label > button"));
		return element;
	}
	
	public static WebElement dlgModalHelp (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalStatus > div > div"));
		return element;
	}
	public static WebElement btnPrivacyDismiss (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalStatus > div > div > div.modal-header > button > span"));
		return element;
	}
	
	public static WebElement txtPrivacy1 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalStatus > div > div > div.modal-body.privacy-model-body > p:nth-child(1)"));
		return element;
	}
	public static WebElement txtPrivacy2 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalStatus > div > div > div.modal-body.privacy-model-body > p:nth-child(2)"));
		return element;
	}
	public static WebElement txtPrivacy3 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalStatus > div > div > div.modal-body.privacy-model-body > p:nth-child(3)"));
		return element;
	}
	
	public static String sPrivacyHelpText1 = "We recommend that you enable privacy protection in order to mask your personal information from fraudsters and spammers.";
	public static String sPrivacyHelpText2 = "By default, when you register a domain name, your contact information becomes available for public viewing on websites like www.whois.com. This includes your organization’s name, address, phone number, and email address as listed in your TechSoup account. This information is, therefore, at risk from being used for nefarious purposes.";		
	public static String sPrivacyHelpText3 = "When you choose Privacy Protection, your publicly accessible Registrant Contact information is replaced with generic contact details.";		
			

	
	
	
}
