/*********************************************************************
 * TSCheckout.java
 *This is a test for using groups to run only certain test cases within a test file class
 *via testNG groups
 *
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

import java.io.IOException;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.OrderDetailsPage;
import pageObjects.cartPage;
import appModule.LogOutAction;


public class TSCheckoutgroup {
	WebDriver driver = null;
	String sTestClass = "TSCheckoutgroup";
	
 @Test(groups={"smoke"})
  public void BasicCheckout() throws InterruptedException, IOException {
	  	  
	  //***  will may need different products for each environment..so possibly parameterize
	  
	  
	 //String [] sProduct = {HomePage.gsUrl + "products/autodesk-autocad--1-year-subscription--G-49990--", HomePage.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	   
	  String [] sProduct = {Glob.gsUrl + "products/exceed!-basic-4.1-(donated)--G-47265--"};
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  boolean bRestriction = false;
	  String sShipping = "$0.00";
		for (String sproduct : sProduct) {
			
			cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
			
		}
  }
 @Test(groups={"smoke"})
  public void CCCheckout() throws InterruptedException, IOException {
	  String [] sProduct = {Glob.gsUrl + "products/bitdefender-antivirus-for-mac--1-user--G-48606--"};
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = true;
	  boolean bRestriction = false;	
	  String sShipping = "$0.00";

			for (String sproduct : sProduct) {
				
				cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate,  bCreditCard, bRestriction, sShipping, false, false);
				
			}
		}




	  
 @Test  //checkoutandverify
 public void CheckoutandVerify() throws InterruptedException, IOException{
	  String [] sProduct = {Glob.gsUrl + "products/filemaker-17-platform--1-year-subscription-for-5-users--G-50737--"};
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
		

			for (String sproduct : sProduct) {
				
				cartPage.CheckOutVerify( driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sSubTotal, sSalesTaxes, sTotal, sShipping, sCoupon, false);

				
				
			}
	 
 }
 
 @Test 
 public void CheckoutVerifyShipping() throws InterruptedException, IOException{
	 System.out.println("running CheckoutVerifyShipping");
//	  String [] sProduct = {Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	  String sProduct = Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--";
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
	  
	  cartPage.CheckOutVerify( driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon, false);
	  sCoupon = "11OFF";
	  System.out.println("****Test with coupon and Shipping--bug that clears shipping when coupon applied*** ");
	  cartPage.CheckOutVerify( driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon, false);
	  
	  sProduct = Glob.gsUrl + "products/box-starter-edition--10-user-licenses--G-49256--";
	  sTotal = "$73.00";
	  sSalesTaxes  = "$0.00";
	  sTotalDue = "$73.00";
	  sCoupon = "11OFF";
	  sShipping = "$0.00";
	  cartPage.CheckOutVerify( driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon, false);
	 //https://www-qa.techsoup.org/products/office-for-mac--LS-3013--
 }
 
 @Test 
 public void CheckoutVerifyDiscounted () throws InterruptedException, IOException{
	 System.out.println("running CheckoutVerifyShipping");
//	  String [] sProduct = {Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	  String sProduct = Glob.gsUrl + "products/office-for-mac-(discounted)--LS-50449--";
	  String sQuantity = "5";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  String sShipping = "$0.00";
	  Boolean bRestriction = false;
	  
	  
	 // cartPage.CheckOut( driver, sProduct, sQuantity,  bLarge, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon);
	  cartPage.CheckOut(driver, sProduct, sQuantity, bLarge,bAddress, bDate, bCreditCard, bRestriction, sShipping, true, false);
	  

 }

 
 
 
 @Test
 public void CheckoutUpdatePayment() throws InterruptedException, IOException{
//	String [] sProduct = {Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	String sQAOrderId = "1303089";//"1303081";
	
	Glob.ModifyPayment(sQAOrderId, "Payment Pending"); 
 }
  
  /**** check on partial payments
 * @throws InterruptedException *****/
 @Test
 public void VerifyPartialPayment ( ) throws InterruptedException {
	 System.out.println("Verifying Partial Payment information");
	 
	 Glob.VerifyOrderDetails(Glob.gsPartialOrderID, true);
 }

 @BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
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
		 	
		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);


 }

@AfterTest(alwaysRun = true)
public void afterTest() throws InterruptedException, IOException {
	System.out.println("after Test");
		
	LogOutAction.execute(driver, Glob.gbMobile);

	driver.quit();
}


 
  
  
}

