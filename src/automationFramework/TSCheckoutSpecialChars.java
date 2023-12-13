/*********************************************************************
 * TSCheckout.java
 * basic checkout tests and verifications
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.OrderDetailsPage;
import pageObjects.cartPage;
import appModule.LogOutAction;


public class TSCheckoutSpecialChars {
	WebDriver driver = null;
	
	String sTestClass = "TSCheckoutSpecialChars";
	
	
@Test(dataProvider = "checkoutData")
  public void BasicCheckout(String sOrgName) throws InterruptedException, IOException, ClassNotFoundException, Throwable {
	System.out.println("***** Checkout with Check *****");
	  	  
	   
	  //String [] sProduct = {Glob.gsUrl + "products/exceed!-basic-4.1-(donated)--G-47265--"};
	  String [] sProduct = {Glob.gsUrl + "products/photoshop-element-20-20-and-premiere-elements-2020-bundle-g-45103-"};
	  
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  boolean bRestriction = false;
	  String sShipping = "$0.00";
	  
	  String connectionUrl = Glob.gsSqlDb;
	  Class.forName("net.sourceforge.jtds.jdbc.Driver");
	  Connection con = DriverManager.getConnection (connectionUrl);

	 
	  //update org name via sql here
		Statement st = con.createStatement();
		
		String Sql = 
				"USE Onyx " + 
						
						"update company set vchCompanyName = '" +sOrgName+"' where vchCompanyName like 'TestTestSpecial%'";
						
		
			st.executeUpdate(Sql);
	  
	  System.out.println("running " + Sql);
	  
	  LoginAction.login(driver, "special@foobar.net", Glob.gsPassword, Glob.gbMobile);
	  //gotta set to the correct org, or use different login
//	  MyAccountPage.tblMyOrganizations(driver).findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPAssocOrgList1_ctl00_OrgListView_ctrl14_Tr1 > td:nth-child(4) > span > span")).click();
		
	  for (String sproduct : sProduct) {
			
			cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
			
		}
		
		LogOutAction.execute(driver, Glob.gbMobile);
  }
//@Test(groups="core")
  public void CCCheckout() throws InterruptedException, IOException {
	System.out.println("***** Checkout with Credit Card *****");
	  String [] sProduct = {Glob.gsUrl + "products/bitdefender-antivirus-for-mac--1-user--G-48606--"};
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = true;
	  boolean bRestriction = false;	
	  String sShipping = "$0.00";

	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  
			for (String sproduct : sProduct) {
				
				cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
				
			}
			LogOutAction.execute(driver, Glob.gbMobile);
		}


//@Test(dataProvider = "ACHData", groups = "ACH")
public void testACH (String sProduct, String sQuantity, Boolean bDate,Boolean bRestriction, String sShipping, String sACHAccount, String sACHRouting, Boolean bChecking, Boolean bBusiness, String sCoupon) throws IOException, InterruptedException {
	 System.out.println("***** ACH Checkout Tests *****");

	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  	
	  
	 cartPage.CheckOut(driver, sProduct, sQuantity, bDate, bRestriction, sShipping, sACHAccount, sACHRouting, bChecking, bBusiness, sCoupon);
	 LogOutAction.execute(driver, Glob.gbMobile);
	 
}


 @BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}
 @DataProvider
 public Object[][] checkoutData(){
	  Object [][] data= new Object [8][1];
	  data [0][0] = "Special Char\"";
	  data [1][0] = "Special Char#";
	  data [2][0] = "Special Char^" ;	
	  data [3][0] = "Special Char@";
	  data [4][0] = "Special Char+" ;
	  data [5][0] = "Special Char$";
	  data [6][0] = "Special Char&";
	  data [7][0] = "Special Char\\";
	  
	  

//	  
	  return data;
 }
 
 //https://www-qa.techsoup.org/products/quickbooks-online-plus-1-year-subscription-5-users-g-49616-
 @DataProvider
 public Object[][] ACHData(){
	  Object [][] data= new Object [6][10];
	  data [0][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";  //no agreements with this product.  also goes out of stock regularly, 
	  data [0][1] = "1";
	  data [0][2] = false;
	  data [0][3] = false;
	  data [0][4] = "$20.00";
	  data [0][5] = "1000000000";
	  data [0][6] = "011000015";
	  data [0][7] = true;  //checking
	  data [0][8] = false;  //true business
	  data [0][9] = "";
	  
	 // data [1][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	  data [1][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	  data [1][1] = "1";
	  data [1][2] = false;
	  data [1][3] = false;
	  data [1][4] = "$20.00";
	  data [1][5] = "1000000000";
	  data [1][6] = "011000015";
	  data [1][7] = false;	//savings
	  data [1][8] = true;  //business
	  data [1][9] = "";
	  
	  data [2][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	  data [2][1] = "1";
	  data [2][2] = false;
	  data [2][3] = false;
	  data [2][4] = "$20.00";
	  data [2][5] = "1000000000";
	  data [2][6] = "011000015";
	  data [2][7] = true;   //checking
	  data [2][8] = false;  //personal
	  data [2][9] = "";
	  	  
	  data [3][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	  data [3][1] = "1";
	  data [3][2] = false;  
	  data [3][3] = false;  
	  data [3][4] = "$20.00";
	  data [3][5] = "1000000000";
	  data [3][6] = "011000015";
	  data [3][7] = false;  //savings
	  data [3][8] = false;  //personal
	  data [3][9] = Glob.gsCoupon;  //coupon test case
	  
	  
//	  products/filemaker-17-platform--1-year-subscription-for-5-users--G-50737--
	  data [4][0] = Glob.gsUrl + "products/filemaker-17-platform--1-year-subscription-for-5-users--G-50737--";
	  data [4][1] = "1";
	  data [4][2] = false;  
	  data [4][3] = false;  
	  data [4][4] = "$20.00";
	  data [4][5] = "1000000000";
	  data [4][6] = "011000015";
	  data [4][7] = false;  //savings
	  data [4][8] = false;  //personal
	  data [4][9] = "";
	  
//	  products/filemaker-17-platform--1-year-subscription-for-5-users--G-50737--
	  data [5][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	  data [5][1] = "1";
	  data [5][2] = false;  
	  data [5][3] = false;  
	  data [5][4] = "$20.00";
	  data [5][5] = "1000000001";//approved with risk
	  data [5][6] = "011000015";
	  data [5][7] = false;  //savings
	  data [5][8] = false;  //personal
	  data [5][9] = "";
	  
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

