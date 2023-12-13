package automationFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.OrderSummary;
import pageObjects.OrgPage;
import pageObjects.cartPage;

public class TSBoostAutoFill {

	 WebDriver driver = null;
	 String sTestClass = "TSBoostAutoFill";
	 //create org
	 //update org to validated
	 //buy boost  //checkou
@Test(dataProvider = "BoostOrgData")	 
	  public void AddBoostOrg(Boolean bLibrary, String sOrgLegalName, String sEIN, String sBudget, String sOrgEmail, String sConfirmOrgEmail,String sWebsite, String sStreetAddress,
				
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
				Boolean bLib501c3, String sExpectedUser4, String sExpectedUser8) throws InterruptedException, ClassNotFoundException, SQLException, IOException{

		
		  
		    
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
						
			//System.out.println("Date is " + Glob.GetDate());
			//LogOutAction.execute(driver);
			
		if (Glob.gbMobile) {
//			LogOutAction.executeMobile(driver);
		}
		else {
			
//		LogOutAction.execute(driver, Glob.gbMobile);//
//		System.out.println("logged out from add org tests");
		}
			
		if (! bDuplicate && ! Glob.gsEnv.equals("Prod") ) {//	
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
							"Update customercampaign SET vchUser1 = 101849 where iTrackingId = 8 and iOwnerId = @onyxId";
//							"DELETE FROM dbo.CustomerAddress WHERE iOwnerID = @onyxId\r\n";
				st.executeUpdate(Sql);
				
				Thread.sleep(13000);
				System.out.println("***** Checkout with Credit Card *****");
				  String sProduct = Glob.gsUrl + "products/-g-49423-";
				  String sQuantity = "0";



						LogOutAction.execute(driver, Glob.gbMobile);			
			
		}
		
	
	  }
@Test
public void BoostCCCheckout() throws InterruptedException, IOException {
	System.out.println("***** Checkout with Credit Card *****");
	  String sProduct = Glob.gsUrl + "products/-g-49423-";
	  String sQuantity = "0";


	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  
//			for (String sproduct : sProduct) {
				//cartPage.AddItemToCart (driver, sProduct, sQuantity);
				cartPage.AddItemToCart(driver, sProduct, sQuantity);
				cartPage.rdoCreditCard(driver).click();
				cartPage.txtCardNumber(driver).sendKeys(Glob.gsCreditNum);
				cartPage.txtExpirationMonth(driver).sendKeys(Glob.gsExpMo);
				cartPage.txtExpirationYear(driver).sendKeys(Glob.gsExpYr);
				cartPage.txtCVV(driver).sendKeys(Glob.gsCVV);
				cartPage.txtZipCode(driver).sendKeys("98199");
				cartPage.btnPayWithCard(driver).click();
				Glob.GetScreenShot(driver, "/CreditCard/", "CC_Orders");
				String sOrderId = OrderSummary.lblOrderID(driver).getText();
				System.out.println("Created Order:  "+ sOrderId);
//				cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
				

				
			LogOutAction.execute(driver, Glob.gbMobile);
		}
@Test
public void BoostOrgRemove () throws SQLException, ClassNotFoundException {
	
	String sOrgLegalName = "TESTTEST BOOST AutoFill";
	
	String connectionUrl = Glob.gsSqlDb;
	Class.forName("net.sourceforge.jtds.jdbc.Driver");
	Connection con = DriverManager.getConnection (connectionUrl);
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

@DataProvider
public Object[][] BoostOrgData(){
	  Object [][] data= new Object [1][35];
	    data [0][0] = false;
	    //data [0][1] = Glob.GetDate() + " Auto TEST Org";
	    data [0][1] = "TESTTEST BOOST AutoFill";
	    data [0][2] = "691111111";
	    data [0][3] = "500,000";
	    data [0][4] = "boostautoorg@org.org"; 
	    data [0][5] = "boostautoorg@org.org";
	    data [0][6] = "www.org.org"; 
	    data [0][7] =  Glob.getInt() + " Street Address";
	    
	    data [0][8] = "optional 2"; 
	    data [0][9] = "Some City"; 
	    data [0][10] = "Kansas"; 
	    data [0][11] = "25944";
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
