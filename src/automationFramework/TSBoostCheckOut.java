/*********************************************************************
 * TSBoostCheckout.java
 * basic checkout tests and verifications for boost products, NOT
 * upgrading to Boost.  See TSBoostAutoFill for upgrade to Boost
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.BoostSignUpPage;
import pageObjects.HomePage;
import pageObjects.cartPage;
import pageObjects.MobileHomePage;
import appModule.LogOutAction;


public class TSBoostCheckOut {
	WebDriver driver = null;
	
 	String sTestClass = "TSBoostCheckout";
 
// @Test
  public void BoostCheckoutNotBoostMember() throws InterruptedException, IOException {
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile); 	  
	  //***  will may need different products for each environment..so possibly parameterize
	  
	  System.out.println("** TC for Non Boost Member, verify Restriction when added to cart");
//	  System.out.println("** TC for Non Boost Member, verify Restriction when added to cart");
//	  https://www-qa.techsoup.org/products/adp-payroll-for-nonprofits-with-49-or-fewer-employees-access-to-discounted-rates-boost-g-50065-
	 	   
	  String [] sProduct = {Glob.gsUrl + "products/adp-payroll-for-nonprofits-with-49-or-fewer-employees-access-to-discounted-rates-boost-g-50065-"};
//	  String [] sProduct = {Glob.gsUrl + "products/lenovo-affinity-program-1-year-membership-%E2%80%93-access-to-discounted-rates-(boost)--G-50913--"};
	  //String [] sProduct = {Glob.gsUrl + "products/autodesk-autocad--1-year-subscription--G-49990--"};  //QA
	 
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  boolean bRestriction = true;
	  String sShipping = "$0.00";
	  Boolean bBoost = false;
		for (String sproduct : sProduct) {
			System.out.println("running boost checkout not boost member" );
			cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, bBoost);
			
		}
		LogOutAction.execute(driver, Glob.gbMobile);
		driver.get(Glob.gsUrl);
  }

 
 @Test
 public void BoostAssertValidPage() throws InterruptedException, IOException {
	  System.out.println("** TC for Boost Member, verify BOOST CAN be added to cart");
	  String sBoostExpected = Glob.gsUrl + "boost-sign-up";
	  driver.get(Glob.gsUrl);	  
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  driver.get(Glob.gsUrl + "boost");
	  BoostSignUpPage.btnUpgradeToBoost(driver).click();
	  System.out.println("Upgrade to boost loaded this page:  " + driver.getCurrentUrl());
	  String sBoostUpgradeFound = driver.getCurrentUrl();
	  
	  assertEquals(sBoostUpgradeFound, sBoostExpected);
	  LogOutAction.execute(driver, Glob.gbMobile);
		driver.get(Glob.gsUrl);
 }
//  @Test
  public void BoostCheckoutBoostMember() throws InterruptedException, IOException {
	  System.out.println("** TC for Boost Member, verify item CAN be added to cart");
	  
	  driver.get(Glob.gsUrl);	  
	  LoginAction.login(driver, Glob.gsBoostLogin, Glob.gsPassword, Glob.gbMobile);
	  
	  
	 //String [] sProduct = {HomePage.gsUrl + "products/autodesk-autocad--1-year-subscription--G-49990--", HomePage.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	   
//	  String [] sProduct = {Glob.gsUrl + "products/asana-premium-or-business-g-50828-"};//stage
	  String [] sProduct = {Glob.gsUrl + "products/autodesk-autocad--1-year-subscription--G-49990--"};  //QA
	  
	  String sQuantity = "1";
	  boolean bLarge = false;
	  boolean bAddress = true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  boolean bRestriction = false;
	  String sShipping = "$0.00";
	  boolean bBoost = true;
		for (String sproduct : sProduct) {
			System.out.println("running boost checkout Boost member" );
			cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, bBoost);
			
		}
		LogOutAction.execute(driver, Glob.gbMobile);
		driver.get(Glob.gsUrl);
  }
  
//  @Test //page no longer exists
  public void VerifyBoostMember() throws InterruptedException, IOException {
	  System.out.println("** TC verify Boost join and renewal dates ");
	  
	  driver.get(Glob.gsUrl);	  
	  LoginAction.login(driver, Glob.gsBoostLogin, Glob.gsPassword, Glob.gbMobile);
	  
	  	  driver.get(Glob.gsUrl + "/boost-member");

	  String sBoostStart = BoostSignUpPage.lblBoostMemberStart(driver).getText();
	  Glob.VerifyText(sBoostStart, BoostSignUpPage.sBoostStart);
	  
	  String sBoostRenew = BoostSignUpPage.lblBoostMemberRenewal(driver).getText();
	  Glob.VerifyText(sBoostRenew, BoostSignUpPage.sBoostRenewal);
	  
	  LogOutAction.execute(driver, Glob.gbMobile);
	  
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
  			
  			
  			
  			
  			//Glob.setEnv(Glob.gsEnv);
  			
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

