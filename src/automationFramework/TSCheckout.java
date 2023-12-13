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

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.OrderDetailsPage;
import pageObjects.cartPage;
import appModule.LogOutAction;


public class TSCheckout {
	WebDriver driver = null;
	
	String sTestClass = "TSCheckout";
@Test(groups ="check")
  public void BasicCheckout() throws InterruptedException, IOException {
	System.out.println("***** Checkout with Check *****");
	  	  
	   
	  String [] sProduct = {Glob.gsUrl + "products/exceed-basic-45-donated-g-47265-"};//, Glob.gsUrl + "products/products/hp-stream-11-pro-g5-laptop-hw-52286-"} ; 
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  boolean bRestriction = false;
	  String sShipping = "$0.00";
	 
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  cartPage.EmptyCart(driver);
		
	  for (String sCurrentproduct : sProduct) {
			System.out.println("what is sProduct: "+sCurrentproduct);
//		  cartPage.AddItemToCart(driver, sCurrentproduct, "1");
			cartPage.CheckOut(driver, sCurrentproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
			
		}
	//cartPage.CheckOut(driver, sCurrentproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
		
		LogOutAction.execute(driver, Glob.gbMobile);
  }
@Test(groups = "core")
  public void CCCheckout() throws InterruptedException, IOException {
	System.out.println("***** Checkout with Credit Card *****");
	  String [] sProduct = {Glob.gsUrl + "products/bitdefender-antivirus-for-mac-1-user-G-48606-"};
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = true;
	  boolean bRestriction = false;	
	  String sShipping = "$0.00";

	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  
			for (String sproduct : sProduct) {
				
				cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
				
			}
			LogOutAction.execute(driver, Glob.gbMobile);
		}




	  
@Test(groups="core")  //checkoutandverify
 public void CheckoutandVerify() throws InterruptedException, IOException{
	System.out.println("***** Checkout with Sales Taxes *****");
	
	  String [] sProduct = {Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-"};
	  
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  String sSubTotal = "$540.00";
	  String sSalesTaxes  = "$39.14";
	  String sTotal = "$579.14";
	  String sCoupon = "";
	  String sShipping = "$0.00";
		
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);

			for (String sproduct : sProduct) {
				
				cartPage.CheckOutVerify( driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sSubTotal, sSalesTaxes, sTotal, sShipping, sCoupon, false);

				
				
			}
			
		LogOutAction.execute(driver, Glob.gbMobile);
	 
 }
 
//@Test(groups="core") //Matt:  no current products in production that have shipping selection enabled.
 public void CheckoutVerifyShipping() throws InterruptedException, IOException{
	 System.out.println("***** Checkout with Shipping Charge *****");

//	 String sProduct = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	 
	 String sProduct = Glob.gsUrl + "products/testmattcontent-g-51486-";
//	 products/testmattcontent-g-51486-
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  String sTotal = "$109.00";
	  String sSalesTaxes  = "$0.00";
	  String sTotalDue = "$139.00";
	  String sCoupon = "";
	  String sShipping = "$30.00";
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  
	  cartPage.CheckOutVerify( driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon, false);
	  LogOutAction.execute(driver, Glob.gbMobile);
	  
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  
	  sCoupon = Glob.gsCoupon;  //"11OFF";
	  System.out.println("****Test with coupon and Shipping--bug that clears shipping when coupon applied*** ");
	  cartPage.CheckOutVerify( driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon, false);
	  
	  sProduct = Glob.gsUrl + "products/box-starter-edition-10-user-licenses-G-49256-";
	  sTotal = "$73.00";
	  sSalesTaxes  = "$0.00";
	  sTotalDue = "$73.00";
	  sCoupon = Glob.gsCoupon; //11off
	  sShipping = "$0.00";
	  
	  cartPage.CheckOutVerify( driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon, false);
	  
	  
	  
	  LogOutAction.execute(driver, Glob.gbMobile);
 }
 
//@Test(groups="disc")
 public void CheckoutVerifyDiscounted () throws InterruptedException, IOException{
	 System.out.println("***** Checkout MSFT Discounted *****");

	  String sProduct = Glob.gsUrl + "products/office-for-mac-(discounted)-LS-50449-";
	  String sQuantity = "5";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  String sShipping = "$0.00";
	  Boolean bRestriction = false;
	 
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  

	  cartPage.CheckOut(driver, sProduct, sQuantity, bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, true, false);
	  
	  LogOutAction.execute(driver, Glob.gbMobile);

 }

 
 

//@Test(dataProvider = "updatePayment", groups = "ACHUpdate")
 public void CheckoutUpdatePayment(String sOrderID, String sUpdateTo) throws InterruptedException, IOException{
	System.out.println("***** Update payment Tests *****");
	
	String sUpdateBack;
	
	LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	
	//Glob.ModifyPayment(sQAOrderId, sUpdateTo); 
	sUpdateBack = Glob.ModifyPayment(sOrderID, sUpdateTo);
    
	Thread.sleep(1000);
	driver.get(Glob.gsUrl);
	LogOutAction.execute(driver, Glob.gbMobile);
	
//	System.out.println("***** update back value = "+ sUpdateBack);
	

	LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	
//	Thread.sleep(4000);
	Glob.ModifyPayment(sOrderID, sUpdateBack); 
	
	LogOutAction.execute(driver, Glob.gbMobile);
	
 }
  

 
 
  /**** check on partial payments
 * @throws InterruptedException *****/
//---@Test  --order needs modification.
 public void VerifyPartialPayment ( ) throws InterruptedException {
	 System.out.println("***** Partial payment order update *****");
	 System.out.println("Verifying Partial Payment information");
	 LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
//	 __CSUserNameCookie
	 Cookie sCookie = driver.manage().getCookieNamed("__CSUserNameCookie");
	 
	 System.out.println(sCookie);
	 
	 Glob.VerifyOrderDetails(Glob.gsPartialOrderID, true);
	 LogOutAction.execute(driver, Glob.gbMobile);
 }


@Test(dataProvider = "ACHData", groups = "ACH")
public void testACH (String sProduct, String sQuantity, Boolean bDate,Boolean bRestriction, String sShipping, String sACHAccount, String sACHRouting, Boolean bChecking, Boolean bBusiness, String sCoupon) throws IOException, InterruptedException {
	 System.out.println("***** ACH Checkout Tests These will fail in PROD, no way to pay for real *****");

	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  	
	  
	 cartPage.CheckOut(driver, sProduct, sQuantity, bDate, bRestriction, sShipping, sACHAccount, sACHRouting, bChecking, bBusiness, sCoupon);
	 LogOutAction.execute(driver, Glob.gbMobile);
	 
}

@Test(dataProvider = "ACHDataFailure", groups = "ACH")
public void testACHFailure (String sProduct, String sQuantity, Boolean bDate,Boolean bRestriction, String sShipping, String sACHAccount, String sACHRouting, Boolean bChecking, Boolean bBusiness, String sCoupon) throws IOException, InterruptedException {
	 System.out.println("***** ACH Checkout REJECTION Tests *****");

	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  	
	  
	 cartPage.CheckOut(driver, sProduct, sQuantity, bDate, bRestriction, sShipping, sACHAccount, sACHRouting, bChecking, bBusiness, sCoupon);
	 LogOutAction.execute(driver, Glob.gbMobile);
	 
}

 @BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}
 @DataProvider
 public Object[][] updatePayment(){
	  Object [][] data= new Object [3][2];
	  data [0][0] = Glob.gsOrderId; // CC->ach->CC
	  data [0][1] = "Electronic Check";
	  
	  data [1][0] = Glob.gsOrderIdCheck; //check->CC->check
	  data [1][1] = "Visa ending in 1111";
	  
	  data [2][0] = Glob.gsOrderIdAch; //ach->check->ach
	  data [2][1] = "Pending Payment";
//	  
	  return data;
 }
 
 //https://www-qa.techsoup.org/products/quickbooks-online-plus-1-year-subscription-5-users-g-49616-
 @DataProvider
 public Object[][] ACHData(){
	  Object [][] data= new Object [7][10];
	  data [0][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";//"products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";  //no agreements with this product.  also goes out of stock regularly, 
	  data [0][1] = "1";  //claris-filemaker-19-platform-g-50737-
//	  data [0][0] = Glob.gsUrl + "products/visual-studio-professional-with-msdn-discounted-ls-50465-microsoftdiscount";
//	  data [0][1] = "4";//for testing ach limit fast
	  data [0][2] = false;
	  data [0][3] = false;
	  data [0][4] = "$0.00";
	  data [0][5] = "1000000000";
	  data [0][6] = "011000015";
	  data [0][7] = true;  //checking
	  data [0][8] = false;  //true business
	  data [0][9] = "";
	  
	 // data [1][0] = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
	  data [1][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [1][1] = "1";
	  data [1][2] = false;
	  data [1][3] = false;
	  data [1][4] = "$0.00";
	  data [1][5] = "1000000000";
	  data [1][6] = "011000015";
	  data [1][7] = false;	//savings
	  data [1][8] = true;  //business
	  data [1][9] = "";
	  
	  data [2][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [2][1] = "1";
	  data [2][2] = false;
	  data [2][3] = false;
	  data [2][4] = "$0.00";
	  data [2][5] = "1000000000";
	  data [2][6] = "011000015";
	  data [2][7] = true;   //checking
	  data [2][8] = false;  //personal
	  data [2][9] = "";
	  	  
	  data [3][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [3][1] = "1";
	  data [3][2] = false;  
	  data [3][3] = false;  
	  data [3][4] = "$0.00";
	  data [3][5] = "1000000000";
	  data [3][6] = "011000015";
	  data [3][7] = true;  //savings
	  data [3][8] = false;  //personal
	  data [3][9] = Glob.gsCoupon;  //coupon test case
	  
	  
//	  products/filemaker-17-platform--1-year-subscription-for-5-users--G-50737--
	  data [4][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [4][1] = "1";
	  data [4][2] = false;  
	  data [4][3] = false;  
	  data [4][4] = "$0.00";
	  data [4][5] = "1000000000";
	  data [4][6] = "011000015";
	  data [4][7] = false;  //savings
	  data [4][8] = false;  //personal
	  data [4][9] = "";
	  
//	  products/filemaker-17-platform--1-year-subscription-for-5-users--G-50737--
	  data [5][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [5][1] = "1";
	  data [5][2] = false;  
	  data [5][3] = false;  
	  data [5][4] = "$0.00";
	  data [5][5] = "1000000001";//approved with risk
	  data [5][6] = "011000015";
	  data [5][7] = false;  //savings
	  data [5][8] = false;  //personal
	  data [5][9] = "";

//	  FAIL over $1500
	  data [6][0] = Glob.gsUrl + "products/visual-studio-professional-with-msdn-discounted-ls-50465-microsoftdiscount";;
	  data [6][1] = "5";
	  data [6][2] = false;  
	  data [6][3] = false;  
	  data [6][4] = "$0.00";
	  data [6][5] = "1000000000";
	  data [6][6] = "011000015";
	  data [6][7] = false;  //savings
	  data [6][8] = false;  //personal
	  data [6][9] = "";
	  return data;
	
 }
 @DataProvider
 public Object[][] ACHDataFailure(){
	  Object [][] data= new Object [6][10];
	  data [0][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";  //no agreements with this product.  also goes out of stock regularly, 
	  data [0][1] = "1";
	  data [0][2] = false;
	  data [0][3] = false;
	  data [0][4] = "$20.00";
	  data [0][5] = "1000000002";
	  data [0][6] = "011000015";
	  data [0][7] = true;  //checking
	  data [0][8] = false;  //true business
	  data [0][9] = "";
	  
	  data [1][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [1][1] = "1";
	  data [1][2] = false;
	  data [1][3] = false;
	  data [1][4] = "$20.00";
	  data [1][5] = "1000000004";
	  data [1][6] = "011000015";
	  data [1][7] = false;	//savings
	  data [1][8] = true;  //business
	  data [1][9] = "";
	  
	  data [2][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [2][1] = "1";
	  data [2][2] = false;
	  data [2][3] = false;
	  data [2][4] = "$20.00";
	  data [2][5] = "1000000005";
	  data [2][6] = "011000015";
	  data [2][7] = true;   //checking
	  data [2][8] = false;  //personal
	  data [2][9] = "";
	  	  
	  data [3][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [3][1] = "1";
	  data [3][2] = false;  
	  data [3][3] = false;  
	  data [3][4] = "$20.00";
	  data [3][5] = "1000000006";
	  data [3][6] = "011000015";
	  data [3][7] = false;  //savings
	  data [3][8] = false;  //personal
	  data [3][9] = Glob.gsCoupon;  //coupon test case

	  data [4][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";
	  data [4][1] = "1";
	  data [4][2] = false;  
	  data [4][3] = false;  
	  data [4][4] = "$20.00";
	  data [4][5] = "1234567896";
	  data [4][6] = "011000015";
	  data [4][7] = false;  //savings
	  data [4][8] = false;  //personal
	  data [4][9] = Glob.gsCoupon;  //coupon test case
	  
	  data [5][0] = Glob.gsUrl + "products/claris-filemaker-19-platform-g-50737-";  //no agreements with this product.  also goes out of stock regularly, 
	  data [5][1] = "1";
	  data [5][2] = false;
	  data [5][3] = false;
	  data [5][4] = "$20.00";
	  data [5][5] = "1000000002";
	  data [5][6] = "011000999";
	  data [5][7] = true;  //checking
	  data [5][8] = false;  //true business
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
		 	
//		LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);


 }

@AfterTest(alwaysRun = true)
public void afterTest() throws InterruptedException, IOException {
	System.out.println("after Test");
		
//	LogOutAction.execute(driver, Glob.gbMobile);

	driver.quit();
}


 
  
  
}

