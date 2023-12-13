/*********************************************************************
 * TSCheckoutQuestionnaire.java
 *   
 * test of the large physical order and shipping questionnaire
 * basically confirms the questionnaire loads, not yet able to interact
 * with the form
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
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.cartPage;
import pageObjects.MobileHomePage;


public class TSCheckoutQuestionnaire {
	WebDriver driver = null;
	String sTestClass = "TSCheckoutQuestionnaire";
	
  @Test(dataProvider = "questionnaireData")
  public void LargeQuestionnaireCheckout(String sLogin, String sPassword, Boolean bCloud, Boolean bAddress, Boolean bDate) throws InterruptedException, IOException {
	  
	  
	  //LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  
	  LoginAction.login(driver, sLogin, sPassword, Glob.gbMobile);
	  
	  if (bCloud) {
		  if (Glob.gbMobile) {
			  System.out.println("in mobile and cloud");
			  MobileHomePage.mnuHamburger(driver).click();
			  String sFoundCloud = MobileHomePage.lnkCloud(driver).getAttribute("id");
//			  #boostOffer
		  	  String sFoundBoost = MobileHomePage.lnkBoost(driver).getAttribute("id");
		  	  System.out.println("Checking for Boost and Cloud flags, found " + sFoundBoost +" and "+ sFoundCloud );
		  }
		  else {
			  String sFoundCloud = HomePage.lnkCloud(driver).getText();
		  	  String sFoundBoost = HomePage.lnkBoost(driver).getText();
		  	  System.out.println("Checking for Boost and Cloud flags, found " + sFoundBoost +" and "+ sFoundCloud );
		  
		  }
	 
	  	}
	  else {
		  System.out.println("in the else not checking cloud items");
	  }
	  
	  
		  
	  String [] sProduct = {Glob.gsUrl + Glob.gsQuestProd};//updated general variable for questionnaire

	  String sQuantity  = Glob.gsQuantity;
	  Boolean bLarge = true;
	  Boolean bCreditCard = false;
	  Boolean bRestriction = false;
	  String sShipping = "$0.00";


		for (String sproduct : sProduct) {
			
			cartPage.CheckOut(driver, sproduct, sQuantity, bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false );
			//cartPage.CheckOut(driver, sProduct, sQuantity, bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, bMSFT, bBoost)
			
		}
	
	LogOutAction.execute(driver, Glob.gbMobile);

	  
  }
  
  @DataProvider
 	public Object[][] questionnaireData(){
 			  Object [][] data= new Object [1][5];
 			  data [0][0] = Glob.gsEmail;
 			  data [0][1] = Glob.gsPassword;
 			  data [0][2] = false;
 			  data [0][3] = true;
 			  data [0][4] = false;
			  
			  
// 			  //not valid in stage or prod
// 			  data [1][0] = Glob.gsCloudMgrLogin;
// 			  data [1][1] = Glob.gsCloudMgrPassword;
// 			  data [1][2] = true;
// 			  data [1][3] = true;
// 			  data [1][4] = false;
//
// 			  data [2][0] = Glob.gsCloudMgrLogin;
// 			  data [2][1] = Glob.gsCloudMgrPassword;
// 			  data [2][2] = true;
// 			  data [2][3] = false;  //diff address
// 			  data [2][4] = true;  //diff date
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
  			
  			
  			
  			
  			if (bMobile) {
  				driver.manage().window().setSize(new Dimension(375,812));//iPhoneX size
  				driver.get(Glob.gsUrl);
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
