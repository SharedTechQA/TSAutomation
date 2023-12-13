package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	
public class AssociateOrgPage {

	private static WebElement element = null;
	static WebDriver driver;
	
	public static WebElement txtAssociationCode(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_AssociationCodeText"));
		
		return element;
	}
	
	public static WebElement lblAssociationCode(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_AssociationCodeLabel"));
		
		return element;
	}
//error text
	public static WebElement lblEnterAssocCode(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_AssociationCodeRequired"));
		
		return element;
	}

	public static String sEnterAssocCode = "Please enter an association code.";
	
	public static WebElement lstRole(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_ContactTypeList"));
		
		return element;
	}
	
	public static WebElement lblRole(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_ContactTypeLabel"));
		
		return element;
	}
	
	public static WebElement lblSelectRole(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_ContactTypeRequired"));
			
			return element;
		}
	
	public String sSelectRole = "Please select your role in the organization.";
	
	

	public static WebElement lblAssocCodeError(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > div > div:nth-child(2) > div > section.form.form-horizontal.top-position > div:nth-child(3) > div > div.text-danger"));
		
	return element;
	}
	
	public static String sAssocCodeReqError = "Sorry, the association code you entered does not meet the minimum requirements. Please enter a combination of letters and numbers between 7 and 60 characters in length.";
	public static String sAssocCodeError = "Sorry, the association code you entered doesn't match our records. Please check the code and try again. If you need to obtain your organization's association code, contact one of the authorized agents for your organization.";
	
	
	
	
	public static WebElement btnContinue(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_ContinueButton"));
		
		return element;
	}
	
	public static WebElement btnGoBack(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_AssociateOrgControl1_BackButton"));
			
			return element;
		}
	
	
}
