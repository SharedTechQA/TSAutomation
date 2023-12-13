/*********************************************************************
 * TSSaveForLater.java
 * Test cases for Save for later in org data
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.openqa.selenium.*;
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
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.OrgPage;

public class TSSaveForLater {
	WebDriver driver = null;		
	String sTestClass = "TSSaveForLater";
	
//	public static final String USERNAME = "matthewradford1";
//	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
//	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
 @Test(dataProvider = "addOrgData", groups="build")	 
	  public void saveOrg(Boolean bLibrary, String sOrgLegalName, String sEIN, String sBudget, String sOrgEmail, String sConfirmOrgEmail,String sWebsite, String sStreetAddress,
				
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
				Boolean bDiscard,
				String sFSCStxt,
	  			String sFSCSnum,
	  			boolean bLib501c3) throws InterruptedException, ClassNotFoundException, SQLException{

		
		  
		    
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
			
			
			
		OrgPage.createOrg(driver, bLibrary, sEIN, sOrgLegalName, sBudget, sOrgEmail, sConfirmOrgEmail, sWebsite, sStreetAddress, sAddress2, sCity, sState, sZipCode, sOrgType, sSubType, sAreaCode, sPrefix, sNumber, sExtension, sFaxArea, sFaxnumber, sRole, sNumberOfStaff, sCommunityType, sPopulationServed, sLibraryInternetConnection, sNumberComputerForStaff, sNumberOfTerminals, sHowDidYouHearAboutUs, bSaveForLater, bDuplicate, sFSCStxt, sFSCSnum, bLib501c3);
		LogOutAction.execute(driver, Glob.gbMobile);
		if (bDiscard) {
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			HomePage.btnDiscardSavedOrg(driver).click();
			HomePage.btnDiscardOrg(driver).click();
			LogOutAction.execute(driver, Glob.gbMobile);
			
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			if (HomePage.btnDiscardSavedOrg(driver).isDisplayed()) {
				boolean bExpected = false; 
				boolean bFound = true;
				assertEquals(true, false);
				//sert.assertEquals(bFound, bExpected);
				LogOutAction.execute(driver, Glob.gbMobile);
			}
			else {
			LogOutAction.execute(driver, Glob.gbMobile);
			}
			
			
		}
			
		else {  //bdiscard false
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			HomePage.btnFinishOrg(driver).click();
			OrgPage.btnStartOver(driver).click();
			OrgPage.btnYesDiscard(driver).click();
			LogOutAction.execute(driver, Glob.gbMobile);
		}
 }			
 
 @DataProvider
 public Object[][] addOrgData(){
	  Object [][] data= new Object [2][34];
	    data [0][0] = false;
	    data [0][1] = "TESTTEST Discard Saved Org";
	    data [0][2] = "691111111";
	    data [0][3] = "500,000";
	    data [0][4] = "org@org.org"; 
	    data [0][5] = "org@org.org";
	    data [0][6] = "www.org.org"; 
	    data [0][7] =  Glob.getInt() + " Street Address";
	    
	    data [0][8] = "optional address 2"; 
	    data [0][9] = "Frankfort"; 
	    data [0][10] = "Kentucky"; 
	    data [0][11] = "25945";
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
	    data [0][28] = true;
	    data [0][29] = false;
	    data [0][30] = true;
	    data [0][31] = "WA1234"; //new fscs format
	    data [0][32] = "999";
	    data [0][33] = false;
	
	    data [1][0] = false;
	    data [1][1] = "TESTTEST Continue Saved Org";
	    data [1][2] = "691111111";
	    data [1][3] = "500,000";
	    data [1][4] = "org@org.org"; 
	    data [1][5] = "org@org.org";
	    data [1][6] = "www.org.org"; 
	    data [1][7] =  Glob.getInt() + " Street Address";
	    
	    data [1][8] = "optional address 2"; 
	    data [1][9] = "Frankfort"; 
	    data [1][10] = "Kentucky"; 
	    data [1][11] = "25945";
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
	    data [1][28] = true;
	    data [1][29] = false;
	    data [1][30] = false;
	    data [1][31] = "WA1234"; //new fscs format
	    data [1][32] = "999";
	    data [1][33] = false;
	   return data;
 }
	
@BeforeClass
  	public void beforeClass() throws IOException {
		Glob.setOutPutDirectory(sTestClass);	
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
  		
  }
@Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
@BeforeTest
	public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException {
	  	Glob.setEnv(sEnv);
	  	Glob.gbMobile = bMobile;
	  	System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );;
	
	  	driver = Glob.setBrowser(sBrowser);
	  	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		if (bMobile) {
			driver.get(Glob.gsUrl);
			driver.manage().window().setSize(new Dimension(375,812));//iPhoneX size
		}
		else{
			driver.manage().window().maximize();
			driver.get(Glob.gsUrl);
		}
			 	


	  }

@AfterTest
	public void afterTest() throws InterruptedException, IOException {
		System.out.println("after Test");
 		
	
		driver.quit();
	}
	
}
