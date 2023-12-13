package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import appModule.Glob;

public class OrgPage {
	private static WebElement element = null;
	static WebDriver driver;
	public static String sSubscribeHeader = "Tell Us About Your Organization";
	public static String sExpectedUser4;
	
//	public static void invoke(WebDriver driver) {
//	HomePage.btnSubscribe(driver).click();
//	}
	
	public static WebElement lblOrgQualStatus (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_QualStatusPanel > dd"));
		
	return element;
		
	}
	
	
	public static WebElement btnEditDetails (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_EditOrgLink"));
		
	return element;
		
	}
	
	public static WebElement btnSave (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SubmitButtons_ContinueButton"));
		
	return element;
		
	}
	
	
	
	
	public static WebElement lblHeader(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1.edit_hide"));
		
	return element;
		
	}
	
	public static WebElement txtLegalName(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgName"));
		
	return element;
		
	}
	public static WebElement lblLegalNameRequired(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgNameRequiredValidator"));
		
	return element;
		
	}
	public static String sNameRequired = "Please enter the organization name.";
		
	public static WebElement txtBudget(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_Budget"));
		
		
	return element;
		
	}
	
	
	public static WebElement lblBudgetRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_BudgetRequiredValidator"));
		
	return element;
		
	}
	public static String sBudgetRequired = "Please enter a numeric budget value in U.S. dollars. You may use commas and decimal points.";
	
	public static WebElement txtOrgEmail(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_Email"));
		
	return element;
		
	}
	
	public static WebElement lblEmailRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_EmailRequiredValidator"));
		
	return element;
		
	}
	public static String sEmailRequired = "Please enter a valid email address.";
	
	
	public static WebElement txtConfirmOrgEmail(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgConfirmEmail"));
		
	return element;
		
	}
	
	public static WebElement lblConfirmEmailRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_CompareEmailRequiredValidator"));
		
	return element;
		
	}
	public static String sConfirmEmailRequired = "Please re-enter your email address for confirmation.";
	
	public static WebElement txtWebsite (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgUrl"));
		
	return element;
		
	}
	
	
	public static WebElement txtStreetAddress (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_Address1"));
		
	return element;
		
	}
	
	public static WebElement lblStreetRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_StreetRequiredValidator"));
		
	return element;
		
	}
	
	public static String sStreetRequired = "Please enter an address.";
	
	public static WebElement txtAddressLine2 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_Address2"));
		
	return element;
		
	}
	
	public static WebElement txtCity (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_City"));
		
	return element;
		
	}
	
	public static WebElement lblCityRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_CityRequiredValidator"));
		
	return element;
		
	}
	public static String sCityRequired = "Please enter a city.";
	
	public static WebElement lstState (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_RegionCode"));
		
	return element;
	
	}
	
	public static WebElement lblStateRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_RegionRequiredValidator"));
		
	return element;
		
	}
	public static String sStateRequired = "Please select a state or territory.";
	
	public static WebElement txtZipCode (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_PostalCode"));
		
	return element;
	}
	
	public static WebElement lblZipCodeRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_PostalCodeValidator"));
		
	return element;
		
	}
	public static String sZipRequired = "Please enter a valid five-digit zip code.";
	
	public static WebElement txtAreaCode (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_AreaCode"));
		
	return element;
	}
	
	public static WebElement txtPhonePrefix (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_PhoneNumber"));
		
	return element;
	}
	
	public static WebElement txtPhoneNum (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_Extension"));
		
	return element;
	}
	
	public static WebElement txtExt (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ExtensionExtraBox"));
		
	return element;
	}
	
	public static WebElement txtFaxAreaCode (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_FaxAreaCode"));
		
	return element;
	}
	
	public static WebElement txtFaxNumber(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_FaxPhoneNumber"));
		
	return element;
	}
	
	
	public static WebElement lstRole(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_Title"));
		
	return element;
	}
	
	public static WebElement lblRoleRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_UserTitleRequiredValidator"));
		
	return element;
		
	}
	public static String sRoleRequired = "Please select a title.";
	
	
	public static WebElement lstOrgType(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgType1_OrganizationType"));
		
		//#ctl00_PlaceHolderMain_ctl02_OrgType1_OrganizationType
		
	return element;
	}
	
	public static WebElement lblOrgTypeRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgType1_OrgTypeValidator"));
		
	return element;
		
	}
	
//	public static Select drpOrgType = new Select(driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgType1_OrgTypeValidator")));
	
	public static String sOrgTypeRequired = "Please select an organization type";
	
	public static WebElement lstSubType(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgType1_OrganizationSubType"));
		
	return element;
	}
	
//	public static Select drpSubType = new Select(driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgType1_OrganizationSubType")));
	
	public static WebElement lblOrgSubTypeRequired (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_OrgType1_OrgSubTypeValidator"));
		
	return element;
		
	}
	public static String sOrgSubTypeRequired = "Please select an organization subtype.";
	
	//submit button
	public static WebElement btnContinue(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SubmitButtons_ContinueButton"));
//		#ctl00_PlaceHolderMain_SubmitButtons_ContinueButton
	return element;
	}
	
	public static WebElement btnCancel(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SubmitButtons_CancelButton"));
		//#ctl00_PlaceHolderMain_SubmitButtons_CancelMyAccountBtn	
	return element;
	}
	
	//orgdetails save for later
	public static WebElement btnSaveForLater(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_lnlBtnSaveLater_Top"));
		
	return element;
	}
	
	public static WebElement btnSaveForLaterGoBack(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ModalBackButton"));
		
	return element;
	}
	
	public static WebElement btnSaveAndFinishLater(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton"));
		//#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton
		
	return element;
	}
	
	public static WebElement btnStartOver(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_RetrivePanel > section > button"));
		//#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton
		
	return element;
	}
	
	public static WebElement btnYesDiscard(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1_ctl00_SearchOrgControl1_DiscardSubmitButton"));
		//#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton
		
	return element;
	}
	
	
	//see you soon
	public static WebElement lblSeeYouSoon(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
		
	return element;
	}
	
	
		//Library data page
	public static WebElement txtNumberOfStaff(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl00_field_-1"));
	
	return element;	
	}
	
	public static WebElement lstCommunityType(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl01_field_120"));
	
	return element;
	}
	
	public static WebElement lstPopulationServed(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl02_field_121"));

	return element;
	}
	
	public static WebElement lstLibraryInternetConnection(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl03_field_122"));

	return element;
	}
	
	public static WebElement txtNumberOfComputersForStaff(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl04_field_123"));
	
	return element;	
	}

	public static WebElement chkInternet(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl05_ControlRepeater_ctl00_OptionLabel"));
	
	return element;	
	}
	
	public static WebElement txtNumberOfTerminals(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl06_field_126"));
	
	return element;	
	}

	public static WebElement lstHowDidYouHearAboutUs(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl00_ctl07_field_127"));
	
	return element;	
	}
	
	public static WebElement btnSubmit(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SubmitButtons_ContinueButton"));
	
	return element;	
	}
	
	public static WebElement txtAssociationCode(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_AssociationCode"));
		
	return element;
	}
	
	
	//review org page
	
//	public static WebElement btnReviewPageSaveForLater(WebDriver driver) {
//		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_lnlBtnSaveLater_Top"));
//		
//	return element;
//	}
	
	public static WebElement btnGoBack(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SubmitButtons_BackButtonDown"));
		
		
	return element;
	}
	
	public static WebElement btnAddThisOrganization(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SubmitButtons_ContinueButton"));
//		#ctl00_PlaceHolderMain_SubmitButtons_ContinueButton	
	
	return element;
	}
	
	//********org Details page 
	
	public static WebElement lblLegalName (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div:nth-child(11) > section > div.panel-body > div:nth-child(1) > dl > dd:nth-child(2)"));
	
	return element;
	}
	
	public static WebElement lblBudget (WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderMain_ctl02_budgetDiv\"]"));
	
	return element;
	}
	
	public static WebElement lblOrgEmail(WebDriver driver) {
		//element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_emailBlockTR"));
		element = driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderMain_ctl02_emailBlockTR\"]"));
	return element;
	}
	
	public static WebElement lblWebsite(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_websiteBlockTR"));
	
	return element;
	}
			
	public static WebElement lblRole(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_userTitleDiv"));
		
	return element;
	}
	
	public static WebElement lblOrgType(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_orgTypeTR"));
		
	return element;
	}
	
	public static WebElement lblOrgSubType(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_orgSubTypeTR"));
		
		//#ctl00_PlaceHolderMain_ctl02_ctl02 > div > section > div:nth-child(2)
		
	return element;
	}
	public static WebElement lblLibSubType(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl02 > div > section > div:nth-child(2) > div"));
		
		
		
	return element;
	}
	
	public static WebElement lblAddress1(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_addressBlockTR"));
		
		
		
	return element;
	}
	
	public static WebElement lblAddress2(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ctl02 > div > section > div:nth-child(2) > div"));
		
		
		
	return element;
	}
	
	public static WebElement lblAssocCode(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_AssociationCodeText"));
		
	return element;
	}
	
	public static WebElement dlgModal(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#modalSaveLtrTitle"));
		
	return element;
	}
	
	//goes to major-markets page
	public static WebElement lnkWeCanHelp(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssociateOrg1 > div > p > a"));
		
	return element;
	
	}
	//#modalSaveLtrTitle
	//cancel button here is different tag

	public static WebElement btnRemoveOrg (WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/div/div[1]/div[3]/div/div/div[1]/div[4]/div[2]/section/div/div/table/tbody/tr/td[3]/a"));
//		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl03_UpdatePanel1 > table > tbody > tr > td:nth-child(3) > a"));//chrome
//		#ctl00_PlaceHolderMain_ctl03_UpdatePanel1 > table > tbody > tr > td:nth-child(3) > a
//		/html/body/form/div[3]/div[1]/div/div[1]/div[3]/div/div/div[1]/div[4]/div[2]/section/div/div/table/tbody/tr/td[3]/a
		
		
		
	return element;
	}
	public static class dlgAgent {
		
	public static WebElement btnRemove(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl03_ModalSubmitButton"));
	
		return element;
	}
	
	
	}
	public static void createOrg (WebDriver driver, Boolean bLibrary, String sEIN, String sOrgLegalName, String sBudget, String sOrgEmail, String sConfirmOrgEmail, String sWebsite, String sStreetAddress,String sAddress2, 
			String sCity, String sState, String sZipCode, String sOrgType, String sSubType, String sAreaCode, String sPrefix, String sNumber, String sExtension, String sFaxArea, String sFaxnumber,
			String sRole, String sNumberOfStaff, String sCommunityType, String sPopulationServed, String sLibraryInternetConnection, String sNumberComputerForStaff, String sNumberOfTerminals, String sHowDidYouHearAboutUs, Boolean bSaveForLater, Boolean bDuplicate, String sFSCStxt, String sFSCSnum, Boolean bLib501c3) throws InterruptedException {
		
		MyAccountPage.invoke(driver);
		
		//System.out.println("in the org create function");
		MyAccountPage.btnAddOrg(driver).click();
		if (! bLibrary){
			
			//System.out.println("Creating traditional org");
			EINPage.rdo501C3NonProfit(driver).click();
			EINPage.txtEin(driver).sendKeys(sEIN);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,600);");
			EINPage.btnContinue(driver).click();
			//System.out.println("continue clicked");
		}
		else {
			//System.out.println("Creating library org");
			EINPage.rdoPublicLibrary(driver).click();
			if (bLib501c3) {
				EINPage.rdo501Library(driver).click();
				EINPage.txtLibraryEIN(driver).sendKeys(sEIN);
			}
			
			else {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,600);");
				EINPage.rdoNon501Library(driver).click();
				EINPage.txtFSCSIDtext(driver).sendKeys(sFSCStxt);
				EINPage.txtFSCSID2text(driver).sendKeys(sFSCSnum);
			}
			//EINPage.txtEin(driver).sendKeys(sEIN);
			EINPage.btnContinue(driver).click();
			//System.out.println("continue clicked");
		}
		
//		if driver.get
		
		String sCurrentURL = driver.getCurrentUrl();
		String sExistingEINURL = Glob.gsUrl+"Organization";

		if (sCurrentURL.equals(sExistingEINURL)){

			SelectOrgPage.btnDontSeeOrg2(driver).click();
		}
		else {
			System.out.println("No orgs with EIN, creating org " +sOrgLegalName);//SelectOrgPage.btnIDontSeeMyOrg(driver).click();
		}
		
		
		OrgPage.txtLegalName(driver).sendKeys(sOrgLegalName);
		OrgPage.txtBudget(driver).sendKeys(sBudget);
		OrgPage.txtOrgEmail(driver).sendKeys(sOrgEmail);
		OrgPage.txtConfirmOrgEmail(driver).sendKeys(sConfirmOrgEmail);
		OrgPage.txtWebsite(driver).sendKeys(sWebsite);
		OrgPage.txtStreetAddress(driver).sendKeys(sStreetAddress);
		OrgPage.txtAddressLine2(driver).sendKeys(sAddress2);
		if (!bLibrary) {
			OrgPage.lstOrgType(driver).sendKeys(sOrgType);
//			drpOrgType.selectByVisibleText(sOrgType);
			}
		OrgPage.txtCity(driver).sendKeys(sCity);
		OrgPage.lstState(driver).sendKeys(sState);
		OrgPage.txtZipCode(driver).sendKeys(sZipCode);
		
		//OrgPage.lstOrgType(driver).sendKeys(Keys.TAB);
		OrgPage.txtAreaCode(driver).sendKeys(sAreaCode);
		OrgPage.txtPhonePrefix(driver).sendKeys(sPrefix);
		OrgPage.txtPhoneNum(driver).sendKeys(sNumber);
		OrgPage.txtExt(driver).sendKeys(sExtension);
		OrgPage.txtFaxAreaCode(driver).sendKeys(sFaxArea);
		OrgPage.txtFaxNumber(driver).sendKeys(sFaxnumber);
		OrgPage.lstRole(driver).sendKeys(sRole);
		Thread.sleep(5000);
		
		if (!bLibrary) {
			System.out.println("adding a Standard org");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,300);");
			Thread.sleep(700);
			OrgPage.lstSubType(driver).click();
			Thread.sleep(1000);
			OrgPage.lstSubType(driver).sendKeys(sSubType);
//			drpSubType.selectByVisibleText(sSubType);
			//System.out.println("Entered subtype");
		
			//OrgPage.lstSubType(driver).sendKeys(Keys.ENTER);
//			JavascriptExecutor jse = (JavascriptExecutor)driver;
//			jse.executeScript("window.scrollBy(0,1700);");
			
			OrgPage.btnContinue(driver).click();
			
			
			//System.out.println("clicked continue");
			//OrgPage.lstSubType(driver).sendKeys("Supplying money, goods or services to the poor");
			System.out.println("Save for Later is: " + bSaveForLater);
			if (bSaveForLater) {
				OrgPage.btnSaveForLater(driver).click();
				
				Thread.sleep(1000);
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton"));
				action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton"))).click().build().perform();
//				#ctl00_PlaceHolderMain_ctl02_ModalSubmitButton
				
				System.out.println("Saving for Later.");
				System.out.println("got page " + OrgPage.lblSeeYouSoon(driver).getText());
				
			}
			
			else {
				Thread.sleep(1000);
				JavascriptExecutor jse2 = (JavascriptExecutor)driver;
				jse2.executeScript("window.scrollBy(0,500);");
				
				Thread.sleep(1000);
			OrgPage.btnAddThisOrganization(driver).click();
			}
			String sORGurl = driver.getCurrentUrl();
			if (driver.getCurrentUrl().contains("error500")) {
				//boolean bOops = true;
				System.out.println("OOPS page encountered");
				System.out.println("got 500 " + sORGurl);
				//assert bOops;
				//assert.assertFalse(true);
			}
			else {
				System.out.println("got " + driver.getCurrentUrl());
			}
			if (driver.getCurrentUrl().contains("DuplicateOrgThankYou") && bDuplicate) {
				System.out.println("*****PASS Duplicate page expected, Got page " + sORGurl );
				//System.out.println("Got duplicate " + sORGurl);
				
			}
			else if (driver.getCurrentUrl().contains("DuplicateOrgThankYou")){
				System.out.println("****ERROR got unexpected duplicate " + driver.getCurrentUrl());
			}
			else {
				
			}
				
		}
		else {
			//int iNumberOfStaff, String sCommunityType, String sPopulationServed, String sLibraryInternetConnection, int iNumberComputerForStaff, int iNumberOfTerminals, String sHowDidYouHearAboutUs
			//System.out.println("adding a Library org");
			System.out.println(" anything for lib subtype??");
			String sSubTypeValue = OrgPage.lblLibSubType(driver).getText();
			if (sSubTypeValue.equals("")) {
				System.out.println("ERROR******* Missing Libray SubType in UI *******ERROR");
				assertEquals(0, 1);
				
			}
			//assertEquals(sSubTypeValue, "Non-charity library");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,750);");
			Thread.sleep(1000);
			OrgPage.btnContinue(driver).click();
			OrgPage.txtNumberOfComputersForStaff(driver).sendKeys(sNumberComputerForStaff);;
			OrgPage.txtNumberOfStaff(driver).sendKeys(sNumberOfStaff);
			OrgPage.lstCommunityType(driver).sendKeys(sCommunityType);
			OrgPage.lstPopulationServed(driver).sendKeys(sPopulationServed);;
			OrgPage.lstLibraryInternetConnection(driver).sendKeys(sLibraryInternetConnection);
			OrgPage.chkInternet(driver).click();
			OrgPage.txtNumberOfTerminals(driver).sendKeys(sNumberOfTerminals);
			OrgPage.lstHowDidYouHearAboutUs(driver).sendKeys(sHowDidYouHearAboutUs);
			Thread.sleep(2000);
			JavascriptExecutor jse3 = (JavascriptExecutor)driver;
			jse3.executeScript("window.scrollBy(0,1500);");
			
			OrgPage.btnContinue(driver).click();
			
			
			
			System.out.println("clicked continue");
			//OrgPage.lstSubType(driver).sendKeys("Supplying money, goods or services to the poor");
			System.out.println("Save for Later is: " + bSaveForLater);
			if (bSaveForLater) {
				OrgPage.btnSaveForLater(driver).click();
				OrgPage.btnSaveAndFinishLater(driver).click();
				
				System.out.println("Saving for Later.");
			}
			JavascriptExecutor jse4 = (JavascriptExecutor)driver;
			jse4.executeScript("window.scrollBy(0,700);");
			
			Thread.sleep(1000);
			OrgPage.btnAddThisOrganization(driver).click();
			
			System.out.println("Exiting the org edit function");
			
			String sORGurl = driver.getCurrentUrl();
			if (driver.getCurrentUrl().contains("error500")) {
				System.out.println("OOPS page encountered");
				System.out.println("got " + sORGurl);
				driver.quit();
				
			}
			else {
				System.out.println("got " + driver.getCurrentUrl());
			}
		}
	}
	//#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl0_OrgName > a
	//*[@id="ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl0_OrgName"]/a

	public static void loadOrg (WebDriver driver, String sOrgLegalName) {
		System.out.println("in the org find function, looking for " + sOrgLegalName);
		driver.findElement(By.partialLinkText(sOrgLegalName)).click();
		//driver.findElement(By.partialLinkText(sOrgLegalName)).click();
		
	}
	
	public static void removeOrgAssociation (WebDriver driver, String sOrgLegalName) throws InterruptedException {
		System.out.println("In the remove association");
		driver.get(Glob.gsUrl);
		MyAccountPage.invoke(driver);
		OrgPage.loadOrg(driver, sOrgLegalName);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4000);");
		Thread.sleep(1000);
		OrgPage.btnRemoveOrg(driver).click();
		OrgPage.dlgAgent.btnRemove(driver).click();
				
	}
	public static void editOrg (WebDriver driver, String sOrgLegalName, String sBudget, String sEmail, String sConfirmOrgEmail, String sWebsite, String sStreetAddress, String sAddress2, 
			String sCity, String sState, String sZipCode, String sOrgType, String sSubType, String sAreaCode, String sPrefix, String sNumber, String sExtension, String sFaxArea, String sFaxnumber,
			String sRole, String sAssociationCode) throws InterruptedException {
		MyAccountPage.invoke(driver);
		MyAccountPage.invoke(driver);
		System.out.println("in the org edit function");

		//got to find the org we want to edit
		driver.findElement(By.partialLinkText(sOrgLegalName)).click();
		
		OrgPage.btnEditDetails(driver).click();
		
		
		//OrgPage.lstOrgType(driver).sendKeys(sOrgType);
		//OrgPage.txtLegalName(driver).sendKeys(sOrgLegalNameEdit);
//		OrgPage.txtBudget(driver).clear();
//		OrgPage.txtBudget(driver).sendKeys(sBudget);
//		
		OrgPage.txtOrgEmail(driver).clear();
		OrgPage.txtOrgEmail(driver).sendKeys(sEmail);
		
		OrgPage.txtConfirmOrgEmail(driver).clear();
		OrgPage.txtConfirmOrgEmail(driver).sendKeys(sConfirmOrgEmail);
		
		OrgPage.txtWebsite(driver).clear();
		OrgPage.txtWebsite(driver).sendKeys(sWebsite);
		
		OrgPage.txtStreetAddress(driver).clear();
		OrgPage.txtStreetAddress(driver).sendKeys(sStreetAddress);
		
		OrgPage.txtAddressLine2(driver).clear();
		OrgPage.txtAddressLine2(driver).sendKeys(sAddress2);
		
		OrgPage.txtCity(driver).clear();
		OrgPage.txtCity(driver).sendKeys(sCity);
		
		OrgPage.lstState(driver).sendKeys(sState);
		OrgPage.txtZipCode(driver).sendKeys(sZipCode);
		
		//OrgPage.lstOrgType(driver).sendKeys(Keys.TAB);
		OrgPage.txtAreaCode(driver).clear();
		OrgPage.txtAreaCode(driver).sendKeys(sAreaCode);
		
		OrgPage.txtPhonePrefix(driver).clear();
		OrgPage.txtPhonePrefix(driver).sendKeys(sPrefix);
		
		OrgPage.txtPhoneNum(driver).clear();
		OrgPage.txtPhoneNum(driver).sendKeys(sNumber);
		
		OrgPage.txtExt(driver).clear();
		OrgPage.txtExt(driver).sendKeys(sExtension);
		
		OrgPage.txtFaxAreaCode(driver).clear();
		OrgPage.txtFaxAreaCode(driver).sendKeys(sFaxArea);
		
		OrgPage.txtFaxNumber(driver).clear();
		OrgPage.txtFaxNumber(driver).sendKeys(sFaxnumber);
		
		OrgPage.lstRole(driver).sendKeys(sRole);
		Thread.sleep(1000);

//		OrgPage.lstSubType(driver).click();
//		OrgPage.lstSubType(driver).sendKeys(sSubType);
//		System.out.println("Entered subtype");
		
		OrgPage.txtAssociationCode(driver).clear();
		OrgPage.txtAssociationCode(driver).sendKeys(sAssociationCode);
		//OrgPage.lstSubType(driver).sendKeys(Keys.ENTER);
		//OrgPage.btnContinue(driver).click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
		
		OrgPage.btnSave(driver).click();
		
		System.out.println("clicked SAVE");
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
		//submit
		
		OrgPage.btnSubmit(driver).click();
		

		System.out.println("Exiting the edit function");
	}
	
	public static void verifyOrg (WebDriver driver, String sOrgLegalName, String sBudget, String sEmail, String sConfirmOrgEmail, String sWebsite, String sStreetAddress, String sAddress2, 
			String sCity, String sState, String sZipCode, String sOrgType, String sSubType, String sAreaCode, String sPrefix, String sNumber, String sExtension, String sFaxArea, String sFaxnumber,
			String sRole, String sAssociationCode) throws InterruptedException {
		MyAccountPage.invoke(driver);
		//MyAccountPage.btnMyAccount(driver).click();
		//driver.get("https://www-qa.techsoup.org/my-account");//
		//MyAccountPage.pgContainer(driver).click();
		//MyAccountPage.btnMyAccount(driver).click ();
		System.out.println("in the org verify function");

		//got to find the org we want to edit
		driver.findElement(By.partialLinkText(sOrgLegalName)).click();
		
//		OrgPage.btnEditDetails(driver).click();
	
//		
		if ( OrgPage.lblWebsite(driver).getText().equals(sWebsite))	{
			System.out.println("org Website Type verifies");
		}
		else
			System.out.println("org WebSite doesn't match, expected: " +sWebsite+ " got: " + OrgPage.lblWebsite(driver).getText());
			
//		if ( OrgPage.lblBudget(driver).getText().equals(sBudget))	{
//			System.out.println("org budget verifies");
//		}
//		else
//			System.out.println("org budget doesn't match, expected: " +sBudget+ " got: " + "value: " + OrgPage.lblBudget(driver).getText());
//		
		//OrgPage.txtOrgEmail(driver).click();
		if ( OrgPage.lblOrgEmail(driver).getText().equals(sEmail))	{
			System.out.println("org email verifies");
		}
		else
			System.out.println("org email doesn't match, expected: " +sEmail+ " got: " + OrgPage.lblOrgEmail(driver).getText());
	  //  OrgPage.txtOrgEmail(driver).sendKeys(Keys.TAB, Keys.TAB);
		if ( OrgPage.lblAddress1(driver).getText().equals(sStreetAddress))	{
			System.out.println("Org Address verifies");
		}
		else
			System.out.println("Org Address doesn't match, expected: " +sStreetAddress+ " got: " + OrgPage.lblAddress1(driver).getText());
	
//		if ( OrgPage.txtAddressLine2(driver).getText().equals(sAddress2))	{
//			System.out.println("Org Address 2 verifies");
//		}
//		else
//			System.out.println("Org Address 2 doesn't match, expected: " +sAddress2+ " got: " + OrgPage.txtAddressLine2(driver).getText());
	
	
			
//		if ( OrgPage.lblRole(driver).getText().equals(sRole))	{
//			System.out.println("org lstRole verifies");
//		}
//		else
//			System.out.println("org lstRole doesn't match, expected: " +sRole+ " got: " + OrgPage.lblRole(driver).getText());
//		
		if ( OrgPage.lblAssocCode(driver).getText().equals(sAssociationCode))	{
			System.out.println("org Assoc.code verifies");
		}
		else
			System.out.println("org Association code doesn't match, expected: " +sAssociationCode+ " got: " + OrgPage.lblAssocCode(driver).getText());

		Thread.sleep(5000);

		
//		OrgPage.btnCancel(driver).click();
//		
//		System.out.println("clicked cancel");
		System.out.println(driver.getCurrentUrl());
		//OrgPage.lstSubType(driver).sendKeys("Supplying money, goods or services to the poor");
		
		//OrgPage.btnAddThisOrganization(driver).click();
		
		System.out.println("Exiting the org verify function");
	}
	
	
}
