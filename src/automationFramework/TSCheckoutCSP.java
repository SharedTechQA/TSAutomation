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

import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.CSPDomainPage;
import pageObjects.HomePage;
import pageObjects.OrderDetailsPage;
import pageObjects.cartPage;
import appModule.LogOutAction;


public class TSCheckoutCSP {
	WebDriver driver = null;
	
	String sTestClass = "TSCheckoutCSP";
@Test(dataProvider = "CSPData", groups ="core")
  public void cspAddToCart(Boolean bCSP, String sDomainName, String sProduct, String sQuantity ) throws InterruptedException, IOException {
	System.out.println("***** Checkout with Check *****");
	  	  
	   
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  	
	  
	  cartPage.AddItemToCart(driver, bCSP, sDomainName, sProduct, sQuantity, false);
	  
	 LogOutAction.execute(driver, Glob.gbMobile);
	 
		
		
  }
@Test()
public void cspBadDomain() throws InterruptedException, IOException {
//	System.out.println("***** Checkout with Check *****");
	  	  
	   
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  	
	  
	  cartPage.AddItemToCart(driver, true, "somerandomtext", Glob.gsUrl + "products/-l-54932-/", "1", false );
	  CSPDomainPage.btnVerifyDomain(driver).click();
	  
	  assertEquals(CSPDomainPage.lstVerifyError(driver).getText(),"Your onmicrosoft.com domain and authorization could not be verified.", "random text url should error");
	  
	  
	 LogOutAction.execute(driver, Glob.gbMobile);
	 
		
		
}
@Test()
public void cspCustomDomain() throws InterruptedException, IOException {
//	System.out.println("***** Checkout with Check *****");
	  	  
	   
	  LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);
	  	
	  
	  cartPage.AddItemToCart(driver, true, "customdomain.org", Glob.gsUrl + "products/-l-54932-/", "1", true );
//	  CSPDomainPage.btnDomainToggle(driver).click();
//	  CSPDomainPage.txtDomainName(driver).sendKeys("aCustomDomain.org");
	  CSPDomainPage.btnVerifyDomain(driver).click();
	  
	  assertEquals(CSPDomainPage.lstVerifyError(driver).getText(),"Your onmicrosoft.com domain and authorization could not be verified.", "random text url should error");
	  
	  
	 LogOutAction.execute(driver, Glob.gbMobile);
	 
		
		
}
@BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}
 @DataProvider
 public Object[][] CSPData(){
	  Object [][] data= new Object [5][4];
	  data [0][0] = true;   //bcsp
	  data [0][1] = "SampleApplication319692891";//domain name
	  data [0][2] = Glob.gsUrl + "products/-l-54932-/";//sprod
	  data [0][3] = "1";//quantity

	  
	  data [1][0] = true;   //bcsp
	  data [1][1] = "SampleApplication319692891";//domain name
	  data [1][2] = Glob.gsUrl + "products/-l-54932-/";//sprod
	  data [1][3] = "1";//quantity

	  data [2][0] = true;   //bcsp
	  data [2][1] = "SampleApplication319692891";//domain name  SampleApplication319692891.on
	  data [2][2] = Glob.gsUrl + "products/-l-54932-/";//sprod
	  data [2][3] = "1";//quantity

	  data [3][0] = true;   //bcsp
	  data [3][1] = "SampleApplication319692891";//domain name
	  data [3][2] = Glob.gsUrl + "products/-l-54932-/";//sprod
	  data [3][3] = "1";//quantity
	  
	  data [4][0] = true;   //bcsp
	  data [4][1] = "SampleApplication319692891";//domain name
	  data [4][2] = Glob.gsUrl + "products/-l-54932-/";//sprod
	  data [4][3] = "1";//quantity

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

