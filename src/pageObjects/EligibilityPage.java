package pageObjects;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;

public class EligibilityPage {
	private static WebElement element = null;
	static WebDriver driver;
	
	
	public static WebElement rdo501C (WebDriver driver) {
	
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgStatusList_0"));

	return element;
}
	public static WebElement rdo501CLibrary (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgStatusList_1"));

	return element;
}
	
	public static WebElement rdoNon501C (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgStatusList_2"));

	return element;
}
	
	public static WebElement  lstState (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgLocation"));

	return element;
}

	public static WebElement  lstOrgType (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_orgMission"));

	return element;
}
	
	public static WebElement  lstOrgSubType (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_orgSubType"));

	return element;
}

	public static WebElement  txtBudget (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgBudgetTextBox"));

	return element;
}	
	
	public static WebElement  btnCheckEligibility (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_ContinueButton"));

	return element;
	}	
	public static String sRequiredStatus = "Please select one of the above Organization Status";
	public static WebElement  lblRequiredStatus (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_ReqFiledOrgType"));

	return element;
		
	}
	public static String sRequiredState = "Please select a U.S. state or territory.";
	public static WebElement  lblRequiredState (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgLocationRequired"));

	return element;
	
	}
	
	public static String sRequiredOrgType = "Please select an organization type.";
	public static WebElement  lblRequiredType (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_OrgMissionRequired"));

	return element;
	
	}
	
	public static String sRequiredOrgSubType = "Please select a subtype.";
	public static WebElement  lblRequiredSubType (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_orgSubTypeRequired"));

	return element;
	
	}
	
	public static String sBudget = "Please enter a numeric budget value.";
	public static WebElement  lblBudget (WebDriver driver) {
		
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_EligibilityQuizWebPart_ctl00_BudgetFieldRequired"));

	return element;
	
	}
	
	public static WebElement lstOrgs (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_RegisteredOrgsWebPart_ctl00_orgsDropDownList"));
//		#ctl00_PlaceHolderMain_RegisteredOrgsWebPart_ctl00_orgsDropDownList
		
	return element;
	}
	
	public static WebElement lblEligible (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_RegisteredOrgsWebPart > div > p:nth-child(2) > strong"));
//		#ctl00_PlaceHolderMain_RegisteredOrgsWebPart_ctl00_orgsDropDownList
		
	return element;
	}	
	public static String sEligibleText = "Your nonprofit or library is likely eligible to request products from the donation programs listed below.";
	
	
	
	public static void CheckEligibility(WebDriver driver, String sOrg, String sState, String sOrgType, String sOrgSubType, String sBudget, boolean bLogin, String sOrgToValidate) throws InterruptedException, IOException {
		if (bLogin) {
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			if (Glob.gbMobile) {
				MobileHomePage.mnuHamburger(driver).click();
				MobileHomePage.lnkHelp(driver).click();
			}
			else {
				driver.get((Glob.gsUrl + "EligibilityQuiz"));
//				HomePage.mnu_Help(driver).click();
			}
			
//		  	HelpPage.lnkCheckEligibility(driver).click();mw  upate as cintact us chane
		  	
		  	driver.get((Glob.gsUrl + "EligibilityQuiz"));
		  	
		  	EligibilityPage.lstOrgs(driver).sendKeys(sOrgToValidate, Keys.TAB);
		  				
		  	String sFound = EligibilityPage.lblEligible(driver).getText();
		  	Glob.VerifyText(sFound, EligibilityPage.sEligibleText);
		  	
		  	LogOutAction.execute(driver, Glob.gbMobile);
		  	
		}
		else {
			if (Glob.gbMobile) {
				MobileHomePage.mnuHamburger(driver).click();
				MobileHomePage.lnkHelp(driver).click();
			}
			else {
//				HomePage.mnu_Help(driver).click();
				driver.get((Glob.gsUrl + "EligibilityQuiz"));
			}
			
//		  	HelpPage.lnkCheckEligibility(driver).click();
		  	
		  	switch (sOrg) {
			
			case "501C":
				EligibilityPage.rdo501C(driver).click();;
				break;
			case "501CLibrary":
				EligibilityPage.rdo501CLibrary(driver).click();
				break;
			case "non501CLibrary":
				EligibilityPage.rdoNon501C(driver).click();
				break;
		  	
	  	}	
		  	
	  	
//	  	EligibilityPage.btnCheckEligibility(driver).click();
	  	
	  	EligibilityPage.lstState(driver).sendKeys(sState);
	  	//EligibilityPage.lstState(driver).sendKeys(Keys.TAB);
	  	Thread.sleep(1000);	
	  	//EligibilityPage.btnCheckEligibility(driver).click();
	  	
	  	EligibilityPage.lstOrgType(driver).sendKeys(Keys.PAGE_DOWN);
	//  	
	//  	EligibilityPage.lstOrgType(driver).click();
	  	
	
	  	EligibilityPage.lstOrgType(driver).sendKeys(sOrgType); // Directed to Individuals");
		Thread.sleep(1000);		
	  	EligibilityPage.lstOrgType(driver).sendKeys(Keys.TAB);
	  	
		Thread.sleep(2000);
		
	  	EligibilityPage.lstOrgSubType(driver).click();
	  	EligibilityPage.lstOrgSubType(driver).sendKeys(sOrgSubType);//, goods or services to the poor");
	  	EligibilityPage.lstOrgSubType(driver).sendKeys(Keys.TAB);
	 	Thread.sleep(1000);
	  	
	  	EligibilityPage.txtBudget(driver).sendKeys(sBudget);
	  	EligibilityPage.txtBudget(driver).sendKeys(Keys.TAB);
	  	
	  	EligibilityPage.btnCheckEligibility(driver).click();
	  	Thread.sleep(1000);
	  	
	  	String sFound = driver.getCurrentUrl();
	  	//String sExpected = "https://www.techsoup.org/EligibilityList?state=WA.S&status=501c3nonprofit&type=20&subtype=560&budget=15000";
//	  	Glob.VerifyText(sFound, sExpected);
	  	System.out.println(sFound);
	  	Glob.GetScreenShot(driver, "/eligibility/", "eligquiz");
	  	
		}
	}
	
}
