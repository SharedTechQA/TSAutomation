/*********************************************************************
 * TSAddOrg.java
 * 
 * Add Organization TestCases
 *
 * works as is, but needs modification to delete created org.  SQL exists, however 
 * the connection from java to sql2000 is no longer supported.
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.Random;



import javax.rmi.CORBA.Util;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.AssociateOrgPage;
import pageObjects.EINPage;
import pageObjects.MajorMarketsPage;
import pageObjects.MyAccountPage;
import pageObjects.OrgPage;
import pageObjects.SelectOrgPage;

 
//import appModule.LoginAction.LogOutAction;


public class TSAddOrg {
	 //private static WebDriver driver = null;
	 WebDriver driver = null;
	 
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  
	 
	//  Glob.gsEmail = Glob.gsEmail;
	  
	  String sTestClass = "TSAddOrg";
	  /****** *******************************************************************************			
	   * System.setProperty("webdriver.chrome.driver", "c://sdrivers//geckodriver.exe");
	   * 
	   *			driver = new FirefoxDriver();
	   *			
	   *		 	System.setProperty("webdriver.chrome.driver", "c://sdrivers//chromedriver.exe");
	   *			driver = new ChromeDriver();
	   *			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   *		    DesiredCapabilities caps = new DesiredCapabilities();
	   *		    caps.setCapability("browser", "Edge");
	   *		    caps.setCapability("browser_version", "16.0");
	   *		    caps.setCapability("os", "Windows");
	   *		    caps.setCapability("os_version", "10");
	   * 		    caps.setCapability("resolution", "1024x768");
	   *		    
	   *		    caps.setCapability("browser", "Safari");
	   *		    caps.setCapability("browser_version", "11.0");
	   *		    caps.setCapability("os", "OS X");
	   *		    caps.setCapability("os_version", "High Sierra");
	   *		    caps.setCapability("resolution", "1024x768");
	   *
	   *		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	 
	   ********** ******************************************************************************/	
 
 @Test(dataProvider = "addOrgData", groups="addorgs")	 
	  public void Add_org(Boolean bLibrary, String sOrgLegalName, String sEIN, String sBudget, String sOrgEmail, String sConfirmOrgEmail,String sWebsite, String sStreetAddress,
				
				String sAddress2, 
				String sCity, 
				String sState ,
				String sZipCode,
				String sOrgType,
				String sSubType,
				String sAreaCode, 
				String sPrefix,
				String sNumber,
				String sExtension, 
				String sFaxArea,
				String sFaxnumber,  
				String sRole,
				String sNumberOfStaff,
				String sCommunityType,
				String sPopulationServed ,
				String sLibraryInternetConnection, 
				String sNumberComputerForStaff,
				String sNumberOfTerminals,
				String sHowDidYouHearAboutUs, 
				Boolean bSaveForLater,
				Boolean bDuplicate,
				String sFSCStxt,
				String sFSCSnum,
				Boolean bLib501c3, String sExpectedUser4, String sExpectedUser8) throws InterruptedException, ClassNotFoundException, SQLException{

		
		  
		    
		    //get date, convert to string
		    /*public static void GetDate() {
		    	DateFormat dateFormat = new SimpleDateFormat ("MM/dd/yyy HH:mm:ss");
		    
		    	Date date = new Date();
		    	String sDate = dateFormat.format(date);
		    	return sDate;
		    }*/
		  
		
			driver.get(Glob.gsUrl);
			
			if (bLibrary) {
				
				System.out.println("Creating a library Org for " +sOrgLegalName);

			}
			else
			{
				System.out.println("Creating a Traditional Org for " +sOrgLegalName);
			}
			
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			
			
//some update for git hub...test
			
		OrgPage.createOrg(driver, bLibrary, sEIN, sOrgLegalName, sBudget, sOrgEmail, sConfirmOrgEmail, sWebsite, sStreetAddress, sAddress2, sCity, sState, sZipCode, sOrgType, sSubType, sAreaCode, sPrefix, sNumber, sExtension, sFaxArea, sFaxnumber, sRole, sNumberOfStaff, sCommunityType, sPopulationServed, sLibraryInternetConnection, sNumberComputerForStaff, sNumberOfTerminals, sHowDidYouHearAboutUs, bSaveForLater, bDuplicate, sFSCStxt, sFSCSnum, bLib501c3);
		
		//System.out.println("Date is " + Glob.GetDate());
			//LogOutAction.execute(driver);
			
		if (Glob.gbMobile) {
			LogOutAction.executeMobile(driver);
		}
		else {
			
		LogOutAction.execute(driver, Glob.gbMobile);
		System.out.println("logged out from add org tests");
		}
			
	/***************************		
		for (int i = 0; i<1 ; i++) {  //for making many orgs
			//int iIterator = 0;
			//iIterator++;
			//String sOrgLegalName =i+  "SteveE";
			//String sOrgLegalName = "TESTTEST Edit";
			OrgPage.createOrg(driver, bLibrary, sEIN, sOrgLegalName, sBudget, sOrgEmail, sConfirmOrgEmail, sWebsite, sStreetAddress, sAddress2, 
					sCity, sState, sZipCode, sOrgType, sSubType, sAreaCode, sPrefix, sNumber, sExtension, sFaxArea, sFaxnumber, sRole, sNumberOfStaff, 
					sCommunityType, sPopulationServed, sLibraryInternetConnection, sNumberComputerForStaff, sNumberOfTerminals, sHowDidYouHearAboutUs, bSaveForLater);
			System.out.println("value of i is " + i);
			}
			********************/
//			&& Glob.gsEnv.equals("QA")|| Glob.gsEnv.equals("Stage")
		if (! bDuplicate && !Glob.gsEnv.equals("Prod") ) {//	
			System.out.println("in the sql *DELETE* for " + sOrgLegalName);
//			String connectionUrl = "jdbc:jtds:sqlserver://10.25.96.156:1433/Onyx;database=Onyx;useNTLMv2=true;domain=Compumentor";  //user=compumentor/mradford;password=JUNE2018mr%";
			String connectionUrl = Glob.gsSqlDb;
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection (connectionUrl);
			
			String SqlVerify =
					"USE Onyx SELECT vchuser4, vchuser8 FROM company WHERE vchCompanyName like '"+ sOrgLegalName + "'" 		
					;
			
			try {
				
			
			Statement st = con.createStatement();
			ResultSet rsResultx = st.executeQuery(SqlVerify);
			while (rsResultx.next()) {
				String user4 = rsResultx.getString("vchuser4");
				System.out.println("got vchuser4 = " +user4 + " expected " + sExpectedUser4 );
				assertEquals(user4, sExpectedUser4);
				String user8 = rsResultx.getString("vchuser8");
				System.out.println("got vchuser4 = " +user8 + " expected " + sExpectedUser8 );
				assertEquals(user8, sExpectedUser8);
				
				}
			
			}
			catch (SQLException e) {
				System.out.println("Sql Error???");
			//	JDBCTutorialUtilities.printSQLException(e);
			}
			finally {
				
			}
			
			
			Statement st = con.createStatement();
			
			String Sql = 
					
				"USE Onyx\r\n" + 
				"DECLARE @onyxId int\r\n" + 
				"SELECT @onyxId = iCompanyId FROM company WHERE vchCompanyName = '"+ sOrgLegalName + "'" + 
				"DELETE FROM dbo.CustomerAddress WHERE iOwnerID = @onyxId\r\n" + 
				"DELETE FROM dbo.CustomerPhone WHERE iOwnerID = @onyxId\r\n" + 
				"DELETE FROM dbo.csuAuditCompany WHERE iCompanyId = @onyxId\r\n" + 
				"DELETE FROM dbo.csuIncidentExtension WHERE iIncidentId in\r\n" + 
				"      (SELECT iIncidentId FROM dbo.incident WHERE iOwnerID = @onyxId)\r\n" + 
				"DELETE FROM dbo.incident WHERE iOwnerID = @onyxId\r\n" + 
				"DELETE FROM dbo.CustomerCampaignAction WHERE  iCampaignId in \r\n" + 
				"      (SELECT iCampaignId FROM dbo.CustomerCampaign WHERE iOwnerID = @onyxId)\r\n" + 
				"DELETE FROM dbo.CustomerCampaign where iOwnerID = @onyxId\r\n" + 
				"DELETE FROM dbo.Contact WHERE iOwnerId = @onyxId\r\n" + 
				"DELETE FROM dbo.Contact WHERE iContactId = @onyxId\r\n" + 
				"DELETE FROM dbo.note WHERE owner_id = @onyxId\r\n" + 
				"DELETE FROM dbo.email_association WHERE associated_with_id = @onyxId\r\n" + 
				"DELETE FROM dbo.company WHERE iCompanyId = @onyxId\r\n" + 
				"DELETE FROM dbo.MergeCompMC WHERE iCompanyId = @onyxId";
				
			//System.out.println(Sql);
			
			st.executeUpdate(Sql);
			
			
		}
	
	  }
  @Test(groups="verifydata")
	  public void VerifyRequiredOrgValues () throws InterruptedException, SQLException, ClassNotFoundException{
			System.out.println("*********  Verifying Required Field Text");
			
			driver.get(Glob.gsUrl);
			
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
		  	
			MyAccountPage.invoke(driver);
		  	MyAccountPage.btnAddOrg(driver).click();
			
		  	//Cycle through each radio option
		  	EINPage.rdo501C3NonProfit(driver).click();
		  	//EINPage.btnContinue(driver).click();
		  	String sEinRequiredFound = EINPage.lblEINRequired(driver).getText();
		  	Glob.VerifyText(sEinRequiredFound, EINPage.sEinRequired);
		  	
		  	EINPage.rdoChurch(driver).click();
		  	
		  	//EINPage.btnContinue(driver).click();
		  	String sChurchText = EINPage.lblReligiousText(driver).getText();
		  	Glob.VerifyText(sChurchText, EINPage.sReligiousText);
		  	
		  	EINPage.rdoReligiousNo501c(driver).click();
		  	String sNoEINReligious1 = EINPage.txtReligiousNo501c1(driver).getText();
		  	Glob.VerifyText(sNoEINReligious1, EINPage.sAssumeTxt1);
		  	
		  	//EINPage.rdoReligiousNo501c(driver).click();
		  	String sNoEINReligious2 = EINPage.txtReligiousNo501c2(driver).getText();
		  	Glob.VerifyText(sNoEINReligious2, EINPage.sAssumeTxt2);
		  	
		  	//EINPage.rdoReligiousNo501c(driver).click();
		  	String sNoEINReligious3 = EINPage.txtReligiousNo501c3(driver).getText();
		  	Glob.VerifyText(sNoEINReligious3, EINPage.sAssumeTxt3);
		  	
		  			  	
		  	EINPage.rdoPublicLibrary(driver).click();
		  	String sLibrary= EINPage.lblLibraryText(driver).getText();
		  	Glob.VerifyText(sLibrary, EINPage.sLibraryText);
		  	
		  	
		  	  	
			EINPage.rdo501C3NonProfit(driver).click();
			EINPage.txtEin(driver).sendKeys("887654321");
			EINPage.btnContinue(driver).click();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,4000);");
	
			OrgPage.btnContinue(driver).click();
			
			String sFoundName = OrgPage.lblLegalNameRequired(driver).getText();
			Glob.VerifyText(sFoundName, OrgPage.sNameRequired);
			
			String sFoundBudget = OrgPage.lblBudgetRequired(driver).getText();
			Glob.VerifyText(sFoundBudget, OrgPage.sBudgetRequired);
			
			String sFoundEmail = OrgPage.lblEmailRequired(driver).getText();
			Glob.VerifyText(sFoundEmail, OrgPage.sEmailRequired);
			
			String sFoundConfirmEmail = OrgPage.lblConfirmEmailRequired(driver).getText();
			Glob.VerifyText(sFoundConfirmEmail, OrgPage.sConfirmEmailRequired);
			
			String sFoundStreet = OrgPage.lblStreetRequired(driver).getText();
			Glob.VerifyText(sFoundStreet, OrgPage.sStreetRequired);
			
			String sFoundCity = OrgPage.lblCityRequired(driver).getText();
			Glob.VerifyText(sFoundCity, OrgPage.sCityRequired);
			
			String sFoundState = OrgPage.lblStateRequired(driver).getText();
			Glob.VerifyText(sFoundState, OrgPage.sStateRequired);
			
			String sFoundZip = OrgPage.lblZipCodeRequired(driver).getText();
			Glob.VerifyText(sFoundZip, OrgPage.sZipRequired);
			
			String sFoundRole = OrgPage.lblRoleRequired(driver).getText();
			Glob.VerifyText(sFoundRole, OrgPage.sRoleRequired);
			
			String sFoundType = OrgPage.lblOrgTypeRequired(driver).getText();
			Glob.VerifyText(sFoundType, OrgPage.sOrgTypeRequired);
			
			String sFoundOrgSubType = OrgPage.lblOrgSubTypeRequired(driver).getText();
			Glob.VerifyText(sFoundOrgSubType, OrgPage.sOrgSubTypeRequired);
			//
			
			if (Glob.gbMobile) {
				LogOutAction.executeMobile(driver);
			}
			else {
				
			LogOutAction.execute(driver, Glob.gbMobile);
			}
	  }

 @Test(dataProvider = "associateData", groups = "associateorg")
  	  public void AssociateToOrg (String sEin, String sOrgName, String sAssocCode, String sRole) throws InterruptedException, ClassNotFoundException, IOException{
		System.out.println("********* Associate to Existing org test");
		
		//driver.get("www.techsoup.org");
		driver.get(Glob.gsUrl);
		
		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  	
		MyAccountPage.invoke(driver);
	  	MyAccountPage.btnAddOrg(driver).click();
	  	EINPage.rdo501C3NonProfit(driver).click();
	  	EINPage.txtEin(driver).sendKeys(sEin);
	  	EINPage.btnContinue(driver).click();
	  	
	  	if (SelectOrgPage.lstAlreadyAssociated(driver).isDisplayed()) {
	  		System.out.println("Already associated displaying");
	  		OrgPage.removeOrgAssociation(driver, sOrgName);
	  		//remove association
			MyAccountPage.invoke(driver);
		  	MyAccountPage.btnAddOrg(driver).click();
		  	EINPage.rdo501C3NonProfit(driver).click();
		  	EINPage.txtEin(driver).sendKeys(sEin);
		  	EINPage.btnContinue(driver).click();
		  	SelectOrgPage.rdoFirstOrg(driver).click();
		  	AssociateOrgPage.txtAssociationCode(driver).sendKeys(sAssocCode);
		  	AssociateOrgPage.lstRole(driver).sendKeys(sRole);
		  	AssociateOrgPage.btnContinue(driver).click();
		  	
	  		}
	  	else {
	  		
		  	SelectOrgPage.rdoFirstOrg(driver).click();
		  	AssociateOrgPage.txtAssociationCode(driver).sendKeys(sAssocCode);
		  	AssociateOrgPage.lstRole(driver).sendKeys("Other");
		  	AssociateOrgPage.btnContinue(driver).click();
	  	}
	  	if (Glob.gbMobile) {
			LogOutAction.executeMobile(driver);
		}
		else {
			
		LogOutAction.execute(driver, Glob.gbMobile);
		}
	  	
  }
  
 @Test(dataProvider = "verifyAssocData", groups = "associateorg")
  	  public void AssociateToOrgValidate (String sEin, String sCode, String sRole, String sExpected ) throws InterruptedException, SQLException, ClassNotFoundException, IOException{
 		System.out.println("*********  Associate to org validate errors test");

 		String sErrorText = sExpected ;
 		
 		driver.get(Glob.gsUrl);
// 		
 		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
 	  	
 		MyAccountPage.invoke(driver);
 	  	MyAccountPage.btnAddOrg(driver).click();
 	  	EINPage.rdo501C3NonProfit(driver).click();
 	  	EINPage.txtEin(driver).sendKeys(sEin);
 	  	EINPage.btnContinue(driver).click();
 	  	SelectOrgPage.rdoFirstOrg(driver).click();
 	  	AssociateOrgPage.txtAssociationCode(driver).sendKeys(sCode);
 	  	AssociateOrgPage.lstRole(driver).sendKeys(sRole);
 	  	AssociateOrgPage.btnContinue(driver).click();
 	  	
 	  	String sFoundText = AssociateOrgPage.lblAssocCodeError(driver).getText();
 	  	if (Glob.VerifyText(sFoundText, sErrorText)) {
 	  		
 	  	}
 	  	else {
 	  		//Assert.assertEquals(true, false);
 	  		Assert.assertEquals(sFoundText, sErrorText);
 	  		
 	  	}
 	  	
 	  
// 	  	if (Glob.gbMobile) {
//			LogOutAction.executeMobile(driver);
//		}
//		else {
//			
//		LogOutAction.execute(driver, Glob.gbMobile);
//		}
// 	  	
 	  	LogOutAction.execute(driver, Glob.gbMobile);
//		
  } 
 
// @Test(dataProvider = "multiData", groups = "multi")//major markets test case
 @Test(dataProvider = "multiData", groups = "mmd")
 	public void MMDCheck(String sYourName, String sAreaCode, String sPrefix, String sNumber, String sLocations) throws InterruptedException {
	 
	 driver.get(Glob.gsUrl);
	 
	 LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	 
		MyAccountPage.invoke(driver);
		
		//System.out.println("in the org create function");
		MyAccountPage.btnAddOrg(driver).click();
		OrgPage.lnkWeCanHelp(driver).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
//		System.out.println(sYourName + " " + sAreaCode + sPrefix +  sNumber + sLocations);
		
//		System.out.println(MajorMarketsPage.txtYourName(driver).getText());
		MajorMarketsPage.txtYourName(driver).clear();
		MajorMarketsPage.txtYourName(driver).sendKeys(sYourName);
		MajorMarketsPage.txtAreaCode(driver).click();
		js.executeScript("window.scrollBy(0,200)", "");
		MajorMarketsPage.txtAreaCode(driver).sendKeys("415");
		MajorMarketsPage.txtPefix(driver).sendKeys("777");
		MajorMarketsPage.txtNumber(driver).sendKeys("1234");
		js.executeScript("window.scrollBy(0,400)", "");
		MajorMarketsPage.lstNumberOfLocations(driver).sendKeys("2");
		MajorMarketsPage.btnRequestMulti(driver).click();
		
		LogOutAction.execute(driver, Glob.gbMobile);
		
 }
 @DataProvider
 public Object[][] multiData(){
	  Object [][] data= new Object [1][5];
	  	data [0][0] = "Name for MMD TEST";
	  	data [0][1] = "415";
	  	data [0][2] = "555";
	  	data [0][3] = "1212";
	  	data [0][4] = "2";
	  	
	  return data;
 }
 
 //https://www-qa.techsoup.org/products/-g-49423-
	  @DataProvider
	  public Object[][] addOrgData(){
		  Object [][] data= new Object [12][35];
		    data [0][0] = false;
		    data [0][1] = "TESTTEST SQL TEST DELETE";
		    data [0][2] = "961212121";
		    data [0][3] = "500,000";
		    data [0][4] = "org@org.org"; 
		    data [0][5] = "org@org.org";
		    data [0][6] = "www.org.org"; 
		    data [0][7] =  Glob.getInt() + " Street Address";
		    
		    data [0][8] = "optional address 2"; 
		    data [0][9] = "Phoenix"; 
		    data [0][10] = "Arizona"; 
		    data [0][11] = "85004";
		    data [0][12] = "Other Activities Directed to Individuals";
		    data [0][13] = "Supplying money, goods or services to the poor";
		    data [0][14] = "415"; 
		    data [0][15] = "777";
		    data [0][16] = "1234";
		    data [0][17] = "9999"; 
		    data [0][18] = "222";
		    data [0][19] = "6663333";  
		    data [0][20] = "Volunteer";
		    data [0][21] = "123";
		    data [0][22] = "Rural";
		    data [0][23] = "5000 - 24999";
		    data [0][24] = "Broadband - cable";
		    data [0][25] = "44";
		    data [0][26] = "123";
		    data [0][27] = "Direct mail";
		    data [0][28] = false;
		    data [0][29] = false;
		    data [0][30] = "WA1234"; //new fscs format
		    data [0][31] = "999";
		    data [0][32] = true;
		    data [0][33] = "560";
		    data [0][34] = "20";
		    
		        
		    data [1][0] = true;
		    data [1][1] = "TESTTEST Auto TEST Library";
		    data [1][2] = "WA1234-999";

		    data [1][3] = "5,000";
		    data [1][4] = "libraryorg@org.org"; 
		    data [1][5] = "libraryorg@org.org";
		    data [1][6] = "www.libraryorg.org"; 
		    data [1][7] = Glob.getInt() + " FStreet Address";
		    data [1][8] = "optional address 2"; 
		    data [1][9] = "city Field"; 
		    data [1][10] = "Washington"; 
		    data [1][11] = "98199";
		    data [1][12] = "Other Activities Directed to Individuals";
		    data [1][13] = "Supplying money, goods or services to the poor";
		    data [1][14] = "415"; 
		    data [1][15] = "777";
		    data [1][16] = "1234";
		    data [1][17] = "9999"; 
		    data [1][18] = "222";
		    data [1][19] = "6663333";  
		    data [1][20] = "Volunteer";
		    data [1][21] = "123";
		    data [1][22] = "Rural";
		    data [1][23] = "5000 - 24999";
		    data [1][24] = "Broadband - cable";
		    data [1][25] = "44";
		    data [1][26] = "123";
		    data [1][27] = "Direct mail";
		    data [1][28] = false;
		    data [1][29] = false;
		    data [1][30] = "WA1234"; //new fscs format
		    data [1][31] = "999";
		    data [1][32] = false;
		    data [1][33] = "009";
		    data [1][34] = "03";
		    
		    data [2][0] = true;
		    data [2][1] = "TESTTEST Auto TEST Library 501";
		    data [2][2] = "961212121";

		    data [2][3] = "5,000";
		    data [2][4] = "libraryorg@org.org"; 
		    data [2][5] = "libraryorg@org.org";
		    data [2][6] = "www.libraryorg.org"; 
		    data [2][7] = Glob.getInt() + " FStreet Address";
		    data [2][8] = "optional address 2"; 
		    data [2][9] = "city Field"; 
		    data [2][10] = "Washington"; 
		    data [2][11] = "98199";
		    data [2][12] = "Other Activities Directed to Individuals";
		    data [2][13] = "Supplying money, goods or services to the poor";
		    data [2][14] = "415"; 
		    data [2][15] = "777";
		    data [2][16] = "1234";
		    data [2][17] = "9999"; 
		    data [2][18] = "222";
		    data [2][19] = "6663333";  
		    data [2][20] = "Volunteer";
		    data [2][21] = "123";
		    data [2][22] = "Rural";
		    data [2][23] = "5000 - 24999";
		    data [2][24] = "Broadband - cable";
		    data [2][25] = "44";
		    data [2][26] = "123";
		    data [2][27] = "Direct mail";
		    data [2][28] = false;
		    data [2][29] = false;
		    data [2][30] = "WA1234"; //new fscs format
		    data [2][31] = "999";
		    data [2][32] = true;
		    data [2][33] = "061";
		    data [2][34] = "03";
		    
		    data [3][0] = false;
		    data [3][1] = "TESTTEST Duplicate";
		    data [3][2] = "223535353";
		    data [3][3] = "500,000";
		    data [3][4] = "org@org.org"; 
		    data [3][5] = "org@org.org";
		    data [3][6] = "www.org.org"; 
		    data [3][7] = "223 A Street Address";
		    data [3][8] = "optional address 2"; 
		    data [3][9] = "Phoenix"; 
		    data [3][10] = "Arizona"; 
		    data [3][11] = "85004";
		    data [3][12] = "Other Activities Directed to Individuals";
		    data [3][13] = "Supplying money, goods or services to the poor";
		    data [3][14] = "415"; 
		    data [3][15] = "777";
		    data [3][16] = "1234";
		    data [3][17] = "9999"; 
		    data [3][18] = "222";
		    data [3][19] = "6663333";  
		    data [3][20] = "Volunteer";
		    data [3][21] = "123";
		    data [3][22] = "Rural";
		    data [3][23] = "5000 - 24999";
		    data [3][24] = "Broadband - cable";
		    data [3][25] = "44";
		    data [3][26] = "123";
		    data [3][27] = "Direct mail";
		    data [3][28] = false;
		    data [3][29] = true;
		    data [3][30] = "WA1234"; //new fscs format
		    data [3][31] = "999";
		    data [3][32] = true;
		    data [3][33] = "560";
		    data [3][34] = "20";
		    
		    data [4][0] = false;
		    data [4][1] = "TESTTEST SQL TEST DELETE DiffType";
		    data [4][2] = "691234567";
		    data [4][3] = "500,000";
		    data [4][4] = "org@org.org"; 
		    data [4][5] = "org@org.org";
		    data [4][6] = "www.org.org"; 
		    data [4][7] =  Glob.getInt() + " Street Address";
		    
		    data [4][8] = "optional address 2"; 
		    data [4][9] = "Phoenix"; 
		    data [4][10] = "Arizona"; 
		    data [4][11] = "85004";
		    
		    data [4][12] = "Other Purposes and Activities";
		    data [4][13] = "Patriotic activities";
		    data [4][14] = "415"; 
		    data [4][15] = "777";
		    data [4][16] = "1234";
		    data [4][17] = "9999"; 
		    data [4][18] = "222";
		    data [4][19] = "6663333";  
		    data [4][20] = "Volunteer";
		    data [4][21] = "123";
		    data [4][22] = "Rural";
		    data [4][23] = "5000 - 24999";
		    data [4][24] = "Broadband - cable";
		    data [4][25] = "44";
		    data [4][26] = "123";
		    data [4][27] = "Direct mail";
		    data [4][28] = false;
		    data [4][29] = false;
		    data [4][30] = "WA1234"; //new fscs format
		    data [4][31] = "999";
		    data [4][32] = true;
		    data [4][33] = "908";
		    data [4][34] = "22";
		    
		    data [5][0] = false;
		    data [5][1] = "TESTTEST SQL TEST DELETE";
		    data [5][2] = "961212121";
		    data [5][3] = "500,000";
		    data [5][4] = "org@org.org"; 
		    data [5][5] = "org@org.org";
		    data [5][6] = "www.org.org"; 
		    data [5][7] =  Glob.getInt() + " Street Address";
		    
		    data [5][8] = "optional address 2"; 
		    data [5][9] = "US Minor City"; 
		    data [5][10] = "US Minor Outlying Islands"; 
		    data [5][11] = "85004";
		    data [5][12] = "Other Activities Directed to Individuals";
		    data [5][13] = "Supplying money, goods or services to the poor";
		    data [5][14] = "415"; 
		    data [5][15] = "777";
		    data [5][16] = "1234";
		    data [5][17] = "9999"; 
		    data [5][18] = "222";
		    data [5][19] = "6663333";  
		    data [5][20] = "Volunteer";
		    data [5][21] = "123";
		    data [5][22] = "Rural";
		    data [5][23] = "5000 - 24999";
		    data [5][24] = "Broadband - cable";
		    data [5][25] = "44";
		    data [5][26] = "123";
		    data [5][27] = "Direct mail";
		    data [5][28] = false;
		    data [5][29] = false;
		    data [5][30] = "WA1234"; //new fscs format
		    data [5][31] = "999";
		    data [5][32] = true;
		    data [5][33] = "560";
		    data [5][34] = "20";
		    
		    
		    data [6][0] = false;
		    data [6][1] = "TESTTEST SQL TEST DELETE";
		    data [6][2] = "961212121";
		    data [6][3] = "500,000";
		    data [6][4] = "org@org.org"; 
		    data [6][5] = "org@org.org";
		    data [6][6] = "www.org.org"; 
		    data [6][7] =  Glob.getInt() + " Street Address";
		    
		    data [6][8] = "optional address 2"; 
		    data [6][9] = "Samoa City"; 
		    data [6][10] = "American Samoa"; 
		    data [6][11] = "85004";
		    data [6][12] = "Other Activities Directed to Individuals";
		    data [6][13] = "Supplying money, goods or services to the poor";
		    data [6][14] = "415"; 
		    data [6][15] = "777";
		    data [6][16] = "1234";
		    data [6][17] = "9999"; 
		    data [6][18] = "222";
		    data [6][19] = "6663333";  
		    data [6][20] = "Volunteer";
		    data [6][21] = "123";
		    data [6][22] = "Rural";
		    data [6][23] = "5000 - 24999";
		    data [6][24] = "Broadband - cable";
		    data [6][25] = "44";
		    data [6][26] = "123";
		    data [6][27] = "Direct mail";
		    data [6][28] = false;
		    data [6][29] = false;
		    data [6][30] = "WA1234"; //new fscs format
		    data [6][31] = "999";
		    data [6][32] = true;
		    data [6][33] = "560";
		    data [6][34] = "20";
		
		    
		    data [7][0] = false;
		    data [7][1] = "TESTTEST SQL TEST DELETE";
		    data [7][2] = "961212121";
		    data [7][3] = "500,000";
		    data [7][4] = "org@org.org"; 
		    data [7][5] = "org@org.org";
		    data [7][6] = "www.org.org"; 
		    data [7][7] =  Glob.getInt() + " Street Address";
		    
		    data [7][8] = "optional address 2"; 
		    data [7][9] = "NMI city"; 
		    data [7][10] = "Northern Mariana Islands"; 
		    data [7][11] = "85004";
		    data [7][12] = "Other Activities Directed to Individuals";
		    data [7][13] = "Supplying money, goods or services to the poor";
		    data [7][14] = "415"; 
		    data [7][15] = "777";
		    data [7][16] = "1234";
		    data [7][17] = "9999"; 
		    data [7][18] = "222";
		    data [7][19] = "6663333";  
		    data [7][20] = "Volunteer";
		    data [7][21] = "123";
		    data [7][22] = "Rural";
		    data [7][23] = "5000 - 24999";
		    data [7][24] = "Broadband - cable";
		    data [7][25] = "44";
		    data [7][26] = "123";
		    data [7][27] = "Direct mail";
		    data [7][28] = false;
		    data [7][29] = false;
		    data [7][30] = "WA1234"; //new fscs format
		    data [7][31] = "999";
		    data [7][32] = true;
		    data [7][33] = "560";
		    data [7][34] = "20";
		    
		    data [8][0] = false;
		    data [8][1] = "TESTTEST SQL TEST DELETE";
		    data [8][2] = "961212121";
		    data [8][3] = "500,000";
		    data [8][4] = "org@org.org"; 
		    data [8][5] = "org@org.org";
		    data [8][6] = "www.org.org"; 
		    data [8][7] =  Glob.getInt() + " Street Address";
		    
		    data [8][8] = "optional address 2"; 
		    data [8][9] = "Puerto Rico city"; 
		    data [8][10] = "Puerto Rico"; 
		    data [8][11] = "85004";
		    data [8][12] = "Other Activities Directed to Individuals";
		    data [8][13] = "Supplying money, goods or services to the poor";
		    data [8][14] = "415"; 
		    data [8][15] = "777";
		    data [8][16] = "1234";
		    data [8][17] = "9999"; 
		    data [8][18] = "222";
		    data [8][19] = "6663333";  
		    data [8][20] = "Volunteer";
		    data [8][21] = "123";
		    data [8][22] = "Rural";
		    data [8][23] = "5000 - 24999";
		    data [8][24] = "Broadband - cable";
		    data [8][25] = "44";
		    data [8][26] = "123";
		    data [8][27] = "Direct mail";
		    data [8][28] = false;
		    data [8][29] = false;
		    data [8][30] = "WA1234"; //new fscs format
		    data [8][31] = "999";
		    data [8][32] = true;
		    data [8][33] = "560";
		    data [8][34] = "20";
		    
		    data [9][0] = false;
		    data [9][1] = "TESTTEST SQL TEST DELETE";
		    data [9][2] = "961212121";
		    data [9][3] = "500,000";
		    data [9][4] = "org@org.org"; 
		    data [9][5] = "org@org.org";
		    data [9][6] = "www.org.org"; 
		    data [9][7] =  Glob.getInt() + " Street Address";
		    
		    data [9][8] = "optional address 2"; 
		    data [9][9] = "FM Micronesia city"; 
		    data [9][10] = "Federated States of Micronesia"; 
		    data [9][11] = "85004";
		    data [9][12] = "Other Activities Directed to Individuals";
		    data [9][13] = "Supplying money, goods or services to the poor";
		    data [9][14] = "415"; 
		    data [9][15] = "777";
		    data [9][16] = "1234";
		    data [9][17] = "9999"; 
		    data [9][18] = "222";
		    data [9][19] = "6663333";  
		    data [9][20] = "Volunteer";
		    data [9][21] = "123";
		    data [9][22] = "Rural";
		    data [9][23] = "5000 - 24999";
		    data [9][24] = "Broadband - cable";
		    data [9][25] = "44";
		    data [9][26] = "123";
		    data [9][27] = "Direct mail";
		    data [9][28] = false;
		    data [9][29] = false;
		    data [9][30] = "WA1234"; //new fscs format
		    data [9][31] = "999";
		    data [9][32] = true;
		    data [9][33] = "560";
		    data [9][34] = "20";
		    
		    data [10][0] = false;
		    data [10][1] = "TESTTEST SQL TEST DELETE";
		    data [10][2] = "961212121";
		    data [10][3] = "500,000";
		    data [10][4] = "org@org.org"; 
		    data [10][5] = "org@org.org";
		    data [10][6] = "www.org.org"; 
		    data [10][7] =  Glob.getInt() + " Street Address";
		    
		    data [10][8] = "optional address 2"; 
		    data [10][9] = "Guam city"; 
		    data [10][10] = "Guam"; 
		    data [10][11] = "85004";
		    data [10][12] = "Other Activities Directed to Individuals";
		    data [10][13] = "Supplying money, goods or services to the poor";
		    data [10][14] = "415"; 
		    data [10][15] = "777";
		    data [10][16] = "1234";
		    data [10][17] = "9999"; 
		    data [10][18] = "222";
		    data [10][19] = "6663333";  
		    data [10][20] = "Volunteer";
		    data [10][21] = "123";
		    data [10][22] = "Rural";
		    data [10][23] = "5000 - 24999";
		    data [10][24] = "Broadband - cable";
		    data [10][25] = "44";
		    data [10][26] = "123";
		    data [10][27] = "Direct mail";
		    data [10][28] = false;
		    data [10][29] = false;
		    data [10][30] = "WA1234"; //new fscs format
		    data [10][31] = "999";
		    data [10][32] = true;
		    data [10][33] = "560";
		    data [10][34] = "20";

		    data [11][0] = false;
		    data [11][1] = "TESTTEST SQL TEST DELETE";
		    data [11][2] = "961212121";
		    data [11][3] = "500,000";
		    data [11][4] = "org@org.org"; 
		    data [11][5] = "org@org.org";
		    data [11][6] = "www.org.org"; 
		    data [11][7] =  Glob.getInt() + " Street Address";
		    
		    data [11][8] = "optional address 2"; 
		    data [11][9] = "USVI city"; 
		    data [11][10] = "US Virgin Islands"; 
		    data [11][11] = "85004";
		    data [11][12] = "Other Activities Directed to Individuals";
		    data [11][13] = "Supplying money, goods or services to the poor";
		    data [11][14] = "415"; 
		    data [11][15] = "777";
		    data [11][16] = "1234";
		    data [11][17] = "9999"; 
		    data [11][18] = "222";
		    data [11][19] = "6663333";  
		    data [11][20] = "Volunteer";
		    data [11][21] = "123";
		    data [11][22] = "Rural";
		    data [11][23] = "5000 - 24999";
		    data [11][24] = "Broadband - cable";
		    data [11][25] = "44";
		    data [11][26] = "123";
		    data [11][27] = "Direct mail";
		    data [11][28] = false;
		    data [11][29] = false;
		    data [11][30] = "WA1234"; //new fscs format
		    data [11][31] = "999";
		    data [11][32] = true;
		    data [11][33] = "560";
		    data [11][34] = "20";
		    return data;
	  }
	  
	  @DataProvider
		public Object[][] verifyAssocData(){
				  Object [][] data= new Object [3][4];
				  data [0][0] = "336969696";
				  data [0][1] = "8675309";
				  data [0][2] = "Other";
				  data [0][3] = AssociateOrgPage.sAssocCodeError;
				  
				  data [1][0] = "336969696";
				  data [1][1] = "ASDV";
				  data [1][2] = "Administrator";
				  data [1][3] = AssociateOrgPage.sAssocCodeReqError;
				  
				  data [2][0] = "336969696";
				  data [2][1] = "";
				  data [2][2] = "Administrator";
				  data [2][3] = AssociateOrgPage.sEnterAssocCode;
				  
				  
	  
				  return data;
		}
	  
	  @DataProvider
		public Object[][] associateData(){
				  Object [][] data= new Object [1][4];
				  data [0][0] = "346969696";
				  data [0][1] = "Remove Association";
				  data [0][2] = "8675309";
				  data [0][3] = "Other";
				  
				  return data;
	  }
	
	  @BeforeClass
	  	public void beforeClass() throws IOException {
		  Glob.setOutPutDirectory(sTestClass);
		  System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
	  		
	  }
	  
	  @Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
	  @BeforeTest(alwaysRun = true)
	  	public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException {
	  		  	Glob.setEnv(sEnv);
	  		  	Glob.gbMobile = bMobile;
	  		  	System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );;
	  		  	
	  		  	driver = Glob.setBrowser(sBrowser);
	  		  	
	  			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  			
	  			//Glob.setOutPutDirectory(sTestClass);
	  			
	  			
	  			if (bMobile) {
	  				driver.get(Glob.gsUrl);
	  				driver.manage().window().setSize(new Dimension(375,812));//iPhoneX size
	  			}
	  			else{
	  				driver.manage().window().maximize();
	  				driver.get(Glob.gsUrl);
	  			}
	  			 	


	  	  }

	  @AfterTest(alwaysRun = true)
	  	public void afterTest() throws InterruptedException, IOException {
	  		System.out.println("after Test");
	 		
	  	
	  		driver.quit();
	  	}


	}

