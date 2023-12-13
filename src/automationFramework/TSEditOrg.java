/*********************************************************************
 * TSEditOrg.java
 * Test cases for Editing org data
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.MyAccountPage;
import pageObjects.OrgPage;

public class TSEditOrg {
	WebDriver driver = null;		
	String sTestClass = "TSEditOrg";
	
//	public static final String USERNAME = "matthewradford1";
//	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
//	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	@Test
	public void EditOrg() throws InterruptedException, IOException{

		    //String sOrgLegalName = "8Telligent";
		    String sOrgLegalName = "LOCATED IN"; 
			String sOrgLegalNameEdit = "Edit to Org Name";//cannot edit org legal name from site, have to use onyx
			String sEIN = "226969696";
			//String sOrgLegalName = 
			String sBudget = "500999.12";
			String sOrgEmail = "orgeditfoo@org.org"; 
			String sConfirmOrgEmail =  "orgeditfoo@org.org";
			String sWebsite = "www.orgEditfoo.org"; 
			String sStreetAddress = "123 Street Address Foo";
			String sAddress2 = "optional address 2 Foo"; 
			String sCity = "city Field Foo"; 
			String sState = "Iowa"; 
			String sZipCode = "54321";
			String sOrgType = "Other Activities Directed to Individuals";
			String sSubType = "Supplying money, goods or services to the poor";
			String sAreaCode = "415"; 
			String sPrefix = "778";
			String sNumber = "4321";
			String sExtension = "9989"; 
			String sFaxArea = "321";
			String sFaxnumber = "3336666";  
			String sRole = "Volunteer";
			String sAssociationCode = "8675309";
			//081919TESTTEST Auto ...
			
			
		
			driver.get(Glob.gsUrl);
			
			driver.manage().window().maximize();
			//System.out.println("running add org");
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			
			//System.out.println("logging in");
			
			//OrgPage.editOrg(driver, sOrgLegalName, sBudget, sEmail, sConfirmOrgEmail, sWebsite, sStreetAddress, sAddress2, sCity, sState, sZipCode, sOrgType, sSubType, sAreaCode, sPrefix, sNumber, sExtension, sFaxArea, sFaxnumber, sRole, sAssociationCode);
			OrgPage.editOrg(driver, sOrgLegalName, sBudget, sOrgEmail, sConfirmOrgEmail, sWebsite, sStreetAddress, sAddress2, sCity, sState, sZipCode, sOrgType, sSubType, sAreaCode, sPrefix, sNumber, sExtension, sFaxArea, sFaxnumber, sRole, sAssociationCode);
			
			MyAccountPage.invoke(driver);
			System.out.println("opening account details");
			
			OrgPage.loadOrg(driver, sOrgLegalName);
			System.out.println("loading org legal name " + sOrgLegalName);
			//driver.quit();
			
			OrgPage.verifyOrg(driver, sOrgLegalName, sBudget, sOrgEmail, sConfirmOrgEmail, sWebsite, sStreetAddress, sAddress2, sCity, sState, sZipCode, sOrgType, sSubType, sAreaCode, sPrefix, sNumber, sExtension, sFaxArea, sFaxnumber, sRole, sAssociationCode);
			
			
			
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
