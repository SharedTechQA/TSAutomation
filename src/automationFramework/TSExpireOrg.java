/*********************************************************************
 * TSExpireOrg.java
 * Test cases for expired org messaging validation.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package automationFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.MemberDetailsPage;
import pageObjects.MyAccountPage;
import pageObjects.logInPage;


public class TSExpireOrg{
	 private static WebDriver driver = null;
	 
	 
	  String sTestClass = "TSExpireOrg";
	

  @Test //(dataProvider = "getExpiredOrgData")
  public void VerifyPopUpText () throws InterruptedException, SQLException, ClassNotFoundException {
	  Boolean bMobile = false;
	  String sFound;
	  String sOrgLegalName = "expire org test";
	  driver.get(Glob.gsUrl);
	  LoginAction.login(driver, Glob.gsExpireEmail, Glob.gsPassword, false);
	  
	  sFound = HomePage.lstExpiredOrgText(driver).getText();
	  
	  assertEquals(sFound,HomePage.sExpiredOrgText);
	 // assertEquals(actual, expected);
	  HomePage.cmdYesPlease(driver).click();
	  
	  Thread.sleep(3000);
	  sFound = HomePage.lstExpiredDetailsText(driver).getText();
	  
	  assertEquals(sFound,HomePage.sRequalInitiated);
	  
	  HomePage.cmdCloseReQualPopup(driver).click();
	  resetOrgSql(sOrgLegalName, 102082, 8);
//	  //reset status to expired via sql  
	  
	  LogOutAction.execute(driver, bMobile);
	  
  }
  
  
  @Test (dataProvider = "getExpiredOrgData")  //one accept and and one not now
  public void CheckLoginExpired (String sEmail, String sPassword, Boolean bMobile, Boolean bRequal ) throws InterruptedException, ClassNotFoundException, SQLException {
	  String sFound;
	  String sOrgLegalName = "expire org test";
	  driver.get(Glob.gsUrl);
	  LoginAction.login(driver, sEmail, sPassword, bMobile);
	  
	  if (HomePage.popExpired(driver).isDisplayed() && bRequal == true) {
		  HomePage.cmdYesPlease(driver).click();
		  System.out.println("Clicked Yes please");
		  HomePage.cmdCloseReQualPopup(driver).click ();
		  System.out.println("should logout here");
		  LogOutAction.execute(driver, bMobile);
	  }else {
		  HomePage.cmdNotNow(driver).click();
		  System.out.println("Clicked not now");
		  System.out.println("should logout here");
		  LogOutAction.execute(driver, bMobile);
	  }
	  
	  resetOrgSql(sOrgLegalName, 102082, 8);
//		  //reset to expired regardless

  }
  
  @Test (dataProvider = "getPageOrgData")  //one accept and and one not now
  public void CheckLoginExpiredFromPages (String sEmail, String sPassword, Boolean bMobile, Boolean bRequal, String sPage ) throws InterruptedException, ClassNotFoundException, SQLException {
	 // String sFound;
	  String sOrgLegalName = "expire org test";
	  driver.get(sPage);
	  
	  LoginAction.login(driver, sEmail, sPassword, bMobile);
	  
	  if (HomePage.popExpired(driver).isDisplayed() && bRequal == true) {
		  HomePage.cmdYesPlease(driver).click();
		  System.out.println("Clicked Yes please");
		  HomePage.cmdCloseReQualPopup(driver).click ();
		  System.out.println("should logout here");
		  LogOutAction.execute(driver, bMobile);
	  }else {
		  HomePage.cmdNotNow(driver).click();
		  System.out.println("Clicked not now");
		  System.out.println("should logout here");
		  LogOutAction.execute(driver, bMobile);
	  }
		  //reset to expired regardless
	  
	  resetOrgSql(sOrgLegalName, 102082, 8);//expired, reg.510c
		

  }
  
 public void resetOrgSql(String sOrgLegalName, int iVchUser1,int iTrack) throws ClassNotFoundException, SQLException {
	  //reset status to expired via sql  
	  String connectionUrl = Glob.gsSqlDb;
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection con = DriverManager.getConnection (connectionUrl);
		
		Statement st = con.createStatement();
		
//		System.out.println("SQL ZONE *******");
		System.out.println("here are the inputs to sql string: "+sOrgLegalName + iTrack);
		String Sql = 
				"USE Onyx\r\n" + 
						"DECLARE @onyxId int\r\n" + 
						"SELECT @onyxId = iCompanyId FROM company WHERE vchCompanyName = '"+ sOrgLegalName + "'" + 
						"Update customercampaign SET vchUser1 = " + iVchUser1 + " where iTrackingId = " + iTrack+ " and iOwnerId = @onyxId";
	//System.out.println(Sql);
		//102082,8
		st.executeUpdate(Sql);
	 
 }
  
  @DataProvider
  public Object[][] getExpiredOrgData(){
	  Object [][] data= new Object [2][4];

		data [0][0] = Glob.gsExpireEmail;//email
		data [0][1] = Glob.gsPassword;//password
		data [0][2] = Glob.gbMobile;
		data [0][3] = false; //accept dialogs and request requal
				
		data [1][0] = Glob.gsExpireEmail;
		data [1][1] = Glob.gsPassword;
		data [1][2] = Glob.gbMobile;
		data [1][3] = true;
	/*			
		data [2][0] = Glob.gsExpireEmail;
		data [2][1] = Glob.gsPassword;
		data [2][2] =  Glob.gbMobile;
		data [2][3] = false;
		
		data [3][0] = Glob.gsExpireEmail;
		data [3][1] =  Glob.gsPassword;
		data [3][2] =  Glob.gbMobile;
		data [3][3] = false;
		*/
		
	return data;
  }
  
  @DataProvider
  public Object[][] getPageOrgData(){
	  Object [][] data= new Object [4][5];

		data [0][0] = Glob.gsExpireEmail ;//email
		data [0][1] = Glob.gsPassword;//password
		data [0][2] = Glob.gbMobile;
		data [0][3] = false; //accept dialogs and request requal
		data [0][4] = Glob.gsUrl + "my-account";
				
		data [1][0] = Glob.gsExpireEmail;
		data [1][1] = Glob.gsPassword;
		data [1][2] = Glob.gbMobile;
		data [1][3] = true;
		data [1][4] = Glob.gsUrl + "OrderHistory";  //https://www-qa.techsoup.org/Checkout";
				
		data [2][0] = Glob.gsExpireEmail;
		data [2][1] = Glob.gsPassword;
		data [2][2] =  Glob.gbMobile;
		data [2][3] = false;
		data [2][4] = Glob.gsUrl + "FullfillmentMessages";
		
		data [3][0] = Glob.gsExpireEmail;
		data [3][1] =  Glob.gsPassword;
		data [3][2] =  Glob.gbMobile;
		data [3][3] = false;
		data [3][4] = Glob.gsUrl + "boost";
		
		
	return data;
  }
  @BeforeClass
	public void beforeClass() throws IOException {
	  	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}
  
  @AfterClass
	public void afterClass() throws IOException {
		Glob.setTestNGOutPutDirectory(sTestClass);

}
  @Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
  @BeforeTest(alwaysRun = true)
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

  @AfterTest(alwaysRun = true)
  	public void afterTest() throws InterruptedException {
  		System.out.println("after Test");
  		
  	
  		driver.quit();
  	}
 


}
