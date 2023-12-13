/*********************************************************************
 * TSCheckoutdomain.java
 * basic checkout and verification tests for dot org reselling
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

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.DomainsPage;
import pageObjects.cartPage;
import appModule.LogOutAction;


public class TSCheckoutDomain {
	WebDriver driver = null;
	
	String sTestClass = "TSCheckoutDomain";
@Test(dataProvider = "cartDomain")//not available //logged in
  public void AddDomainToCart(boolean blogin, String sDomain ) throws InterruptedException, IOException {  //login boolean, text searchdomain, 
//	System.out.println("***** Domain Search Unavailable *****");
	
	  	  
	  //if blogin 

	  if  (blogin){
//		  
		//LoginAction.login(driver, "qabuyorg@techsoup.org", "B00ker99!", Glob.gbMobile);
		  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  }  	
	  else {}
	  
	  driver.get(Glob.gsUrl +"Domain-names-nonprofits");
	  Thread.sleep(2000);
	  DomainsPage.btnPickaDomain(driver).click();
	
	  String sDomainPrices = DomainsPage.lblDomainPrice(driver).getText();
	  Assert.assertEquals(sDomainPrices, "Domain names are $9.89 for the first year, then $13.89 per year.");
	  
	  DomainsPage.txtDomainName(driver).sendKeys(sDomain);
	  Thread.sleep(1000);
	  DomainsPage.btnSearch(driver).click();
	  
//	  String sFound = DomainsPage.lblDomainNotAvailable(driver).getAttribute("value");
//	  
//	  Glob.VerifyText(sFound, DomainsPage.sDomainNotAvailableText);
	 
	 
	  if  (blogin){
//		  
		  LogOutAction.execute(driver, Glob.gbMobile);
			 
		   }  	
	  else {
		  driver.get("http://www.google.com");
	  }
	 
		
		
  }
@Test
public void VerifyPrivacyData () throws InterruptedException {
	System.out.println("***** TestCase Verify Privacy Text *****");
//	driver.get("https://www-qa.techsoup.org/Domain-names-nonprofits");	
	  driver.get(Glob.gsUrl +"Domain-names-nonprofits");

//	LoginAction.login(driver, "qabuyorg@techsoup.org", "B00ker99!", Glob.gbMobile);
	LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	DomainsPage.btnPickaDomain(driver).click();
	  DomainsPage.txtDomainName(driver).sendKeys("CheckPrivacy");
	  Thread.sleep(1000);
	  DomainsPage.btnSearch(driver).click();
	  //
	  DomainsPage.btnRequestDomain(driver).click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,400)");
	  
	
	DomainsPage.btnPrivacyHelp(driver).click();
	  
	  DomainsPage.dlgModalHelp(driver).click();
//	  System.out.println("got:  " + DomainsPage.txtPrivacy1(driver).getText());
	  
	  String sFound1 = DomainsPage.txtPrivacy1(driver).getText();
	  Glob.VerifyText(sFound1, DomainsPage.sPrivacyHelpText1);
	  
	  String sFound2 = DomainsPage.txtPrivacy2(driver).getText();
	  Glob.VerifyText(sFound2, DomainsPage.sPrivacyHelpText2);
	  
	  String sFound3 = DomainsPage.txtPrivacy3(driver).getText();
	  Glob.VerifyText(sFound3, DomainsPage.sPrivacyHelpText3);
	  
	  DomainsPage.btnPrivacyDismiss(driver).click();
//	  DomainsPage.dlgModalHelp(driver).sendKeys(Keys.ESCAPE);
}

@Test(dataProvider = "getValidDomain")//not available //logged in
public void PurchaseDomain(boolean blogin, String sDomain ) throws InterruptedException, IOException {  //login boolean, text searchdomain, 
	System.out.println("***** TestCase Purchase Domain *****");
	
//	driver.get("https://www-qa.techsoup.org/Domain-names-nonprofits");
	  driver.get(Glob.gsUrl +"Domain-names-nonprofits");
	  //if blogin 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	  if  (blogin){
//		  
//		LoginAction.login(driver, "qabuyorg@techsoup.org", "B00ker99!", Glob.gbMobile);
		  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  }  	
	  else {}
	  
	  
	  DomainsPage.txtDomainName(driver).sendKeys(sDomain);
	  DomainsPage.btnPickaDomain(driver).click();
	  
	  DomainsPage.btnSearch(driver).click();
	  Thread.sleep(500);
	  //String sFound = DomainsPage.lblDomainNotAvailable(driver).getText();
//	  if (DomainsPage.btnRequestAltDomain(driver).isDisplayed()) {
//		  //DomainsPage.btnRequestDomain(driver).isDisplayed() && 
//		  System.out.println("Cannot add " + sDomain + " because it is unavailable");
//		 Assert.fail("break out");
//	  	
//	  	}
//	  else {
	  
	  DomainsPage.btnRequestDomain(driver).click();
	  js.executeScript("window.scrollBy(0,805)");
	  DomainsPage.chkPrivacy(driver).click();
	  
	  js.executeScript("window.scrollBy(0,450)");
	  Thread.sleep(1000);
	  DomainsPage.lblAgreement(driver).click();
//	  js.executeScript("window.scrollBy(0,400)");
	  
	  DomainsPage.btnCheckout(driver).click();
//	  cartPage.rdoCreditCard(driver)
	  cartPage.txtCardNumber(driver).sendKeys("4111111111111111");
	  cartPage.txtCVV(driver).sendKeys("555");
	  cartPage.txtExpirationMonth(driver).sendKeys("12");
	  cartPage.txtExpirationYear(driver).sendKeys("26");
	  js.executeScript("window.scrollBy(0,200)");
	  cartPage.txtZipCode(driver).sendKeys("45213");
	  js.executeScript("window.scrollBy(0,400)");
	  Thread.sleep(1000);
	  cartPage.btnPayWithCard(driver).click();
	  System.out.println("pay with Card??");
  
	  new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_PlaceHolderMain_hyperlinkURL\"]")));
	  
	  
	  if  (blogin){
//		  
		  LogOutAction.execute(driver, Glob.gbMobile);
			 
		   }  	
	  else {
		  
	   }
	  }
		
		



@DataProvider
public Object[][] cartDomain()
{
	Object [][] data= new Object [2][2];


	data [0][0] = true;
	data [0][1] = "buytest" ;

	
	
	data [1][0] = false ;
	data [1][1] = "buytest" ;
	
	return data;
}

@DataProvider
public Object[][] getValidDomain()
{
	Object [][] data= new Object [2][2];


	data [0][0] = true;
	data [0][1] = "QATestStage91423" ;
	
	data [1][0] = true ;
	data [1][1] = "QATEST12345TSmoo3" ;
	return data;
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
		 	
//		LoginAction.login(driver, Glob.gsCheckoutEmail, Glob.gsPassword, Glob.gbMobile);


 }

@AfterTest(alwaysRun = true)
public void afterTest() throws InterruptedException, IOException {
	System.out.println("after Test");
		
//	LogOutAction.execute(driver, Glob.gbMobile);

	driver.quit();
}


 
  
  
}

