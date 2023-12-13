/*********************************************************************
 * TSOrgQualStatus.java
 * verify text for org qual status
 *
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.OrderDetailsPage;
import pageObjects.OrgPage;
import pageObjects.cartPage;
import appModule.LogOutAction;


public class TSOrgQualStatus {
	WebDriver driver = null;
	
	String sTestClass = "TSOrgQualStatus";
	int CompanyID;
	
	
@Test(dataProvider = "QualStatusData")
  public void UpdateQualStatus(String sOrgName, int sQualStatus, String sQualText) throws InterruptedException, IOException, ClassNotFoundException, Throwable {
	System.out.println("***** Update Qual Status *****");
	  	  	  
	  String connectionUrl = Glob.gsSqlDb;
	  if (Glob.gsEnv == "Stage") {
		  System.out.println("*****************  IMPORTANT:  Set value for mission to stage value in data provider  ***********");
	  }
	  Class.forName("net.sourceforge.jtds.jdbc.Driver");
	  
	  Connection con = DriverManager.getConnection (connectionUrl);
		
		String SqlVerify =
				"USE Onyx SELECT iCompanyId FROM company WHERE vchCompanyName like '"+ sOrgName + "'" 		
				;
		
		try {
			
		
		Statement st = con.createStatement();
		ResultSet rsResultx = st.executeQuery(SqlVerify);
		while (rsResultx.next()) {
			CompanyID = rsResultx.getInt("iCompanyId");
			System.out.println("got onyxID = " + CompanyID );
			
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
							"SELECT @onyxId = iCompanyId FROM company WHERE vchCompanyName = '"+ sOrgName + "'" + 
							"Update incident SET iStatusId =" + sQualStatus + " where iIncidentcategory = 12 and iOwnerId = @onyxId";
//							"DELETE FROM dbo.CustomerAddress WHERE iOwnerID = @onyxId\r\n";
				st.executeUpdate(Sql);
	  
	  //System.out.println("running " + Sql);
	  
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  //need to add a wait as the code needs to catch up
	  //load the specific org to check the status after updating
	  Thread.sleep(5000);
	  driver.get(Glob.gsUrl + "OrganizationProfile?mode=display&orgId=" + CompanyID + "&returnUrl=/my-account");
	  String sOrgStatusText = OrgPage.lblOrgQualStatus(driver).getText();
	  
	  //System.out.println("Found: " + sOrgStatusText);
	  
	 try {
		 
		 assertEquals(sOrgStatusText, sQualText);
	 }
	 catch(Exception e) {
		 System.out.println("Found: " + sOrgStatusText + " expected: " + sQualText);
	 }finally {
		 //System.out.println("Found: " + sOrgStatusText + " expected: " + sQualText);
	 }
	  

	  LogOutAction.execute(driver, Glob.gbMobile);
  }





 @BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}

 
 
 //https://www-qa.techsoup.org/products/quickbooks-online-plus-1-year-subscription-5-users-g-49616-
 @DataProvider
 public Object[][] QualStatusData(){
	  Object [][] data= new Object [5][3];
//	  https://www-qa.techsoup.org/OrganizationProfile?mode=display&orgId='"+ iOwnerId + "'" + "&returnUrl=/my-account"
	  data [0][0] = "Auto Qual Test";//"Update Qual Status";  // 
	  data [0][1] = 102052; //tax
	  //data [0][2] = Glob.gsUrl + "OrganizationProfile?mode=display&orgId='"+ iOwnerId + "'" + "&returnUrl=/my-account";
	  data [0][2] = "Awaiting Documentation\n" + 
	  		"Send us your 501(c)(3) determination letter from the IRS to qualification@techsoup.org.";

	  data [1][0] = "Auto Qual Test";  // 
	  data [1][1] = 102053; //Agent
	  //data [0][2] = Glob.gsUrl + "OrganizationProfile?mode=display&orgId='"+ iOwnerId + "'" + "&returnUrl=/my-account";
	  data [1][2] = "Qualification Pending\n"+ //"Requalification Pending\n" + 
//	  		"We are verifying that you may act on behalf of your organization.";
			   
			  "We are verifying that you may act on behalf of your organization.";
	  
	  data [2][0] = "Auto Qual Test";  // 
	  data [2][1] = 102051; //Cust
	  //data [0][2] = Glob.gsUrl + "OrganizationProfile?mode=display&orgId='"+ iOwnerId + "'" + "&returnUrl=/my-account";
	  data [2][2] = "Awaiting Your Response\n" + 
	  		"We have reached out to you for some clarification and are awaiting a response.";

	  data [3][0] = "Auto Qual Test";  // 
	  data [3][1] = 102054; //name
	  //data [0][2] = Glob.gsUrl + "OrganizationProfile?mode=display&orgId='"+ iOwnerId + "'" + "&returnUrl=/my-account";
	  data [3][2] = "Awaiting Name Clarification\n" + 
	  		"Your organization's name on TechSoup doesn't match IRS records. We are awaiting clarification.";

	  data [4][0] = "Auto Qual Test";  // 
//	  data [4][1] = 102257; //Mission 102257 for QA
	  data [4][1] = 102258;  //Mission 102258 for stage
	  data [4][2] = "Awaiting Mission Clarification\n" + 
	  		"We need to confirm your organization's mission. This is necessary for determining your eligibility for offers.";
	  	
	  return data;
	
 }
 
 @Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
 @BeforeTest(alwaysRun = true)
 public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException, InterruptedException {
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
		 	
//		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);


 }

@AfterTest(alwaysRun = true)
public void afterTest() throws InterruptedException, IOException {
	System.out.println("after Test");
		
//	LogOutAction.execute(driver, Glob.gbMobile);

	driver.quit();
}


 
  
  
}

