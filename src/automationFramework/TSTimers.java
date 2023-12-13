/*********************************************************************
 * TSTestStuff.java
 * Area for testing new methods, etc.
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

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.AssociateOrgPage;
import pageObjects.EINPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.OrderDetailsPage;
import pageObjects.OrgPage;
import pageObjects.ProductPage;
import pageObjects.RequestHistoryPage;
import pageObjects.cartPage;
import pageObjects.SelectOrgPage;



public class TSTimers {
	WebDriver driver = null;
	String sTestClass = "TSTimers";

@Test
public void ATimersCaptcha() throws InterruptedException, IOException {
	driver.get(Glob.gsUrl);
	Thread.sleep(15000);
}
  @Test  //added to verifypages
  public void TimersLoggedIn() throws InterruptedException, IOException {
	  System.out.println("****** Timers Member ******");

	  	//Login
	  	long start = System.currentTimeMillis();
	  	long timeToLoad;
	  	LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
		
	  	if (HomePage.btn_MyAccount(driver).isDisplayed()) {
	  		timeToLoad= (System.currentTimeMillis()-start);
	  			  
	  		System.out.println("Login Time, " + timeToLoad);
	  	}
		//Member Org
		start = System.currentTimeMillis();
		
		HomePage.btn_MyAccount(driver).click();
		
		MyAccountPage.lnkMemberOrg(driver).click();
		
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Member Org Page, " + timeToLoad);
		
		//My Account
		start = System.currentTimeMillis();
		
		MyAccountPage.invoke(driver);
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("My Account Page, " + timeToLoad);
		
		//Catalog
		start = System.currentTimeMillis();
		
		HomePage.mnuProductCatalog(driver).click();
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Catalog, "+ timeToLoad);
		
		//HomePage
		//reset
		driver.get("https://www.google.com");
		
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl);
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "TS Homepage, " + timeToLoad);
		
		
		/*//HomePage--amazon compare test
		
		start = System.currentTimeMillis();
		
		driver.get("https://www.Amazon.com");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "amazon Homepage, " + timeToLoad);
		*/
		//Articles
		driver.get(Glob.gsUrl);
		start = System.currentTimeMillis();
		
		HomePage.invokeArticlesAndHowTos(driver);
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Articles, " + timeToLoad);
		
		//Webinars
		start = System.currentTimeMillis();
		
		HomePage.invokeWebinars(driver);
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Webinars, "+ timeToLoad);
		
		//Adobe		
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"adobe");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Adobe, " + timeToLoad);
		
		//MSFT Catalog
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"microsoft");//microsoft-catalog
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Microsoft, " + timeToLoad );
		
		//Boost Page
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"boost");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Boost, " + timeToLoad );
		
		//Accounting Category
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"accounting");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Accounting, " + timeToLoad);
		
		//search Adobe
		start = System.currentTimeMillis();
		
		HomePage.btn_Search(driver).click();
		HomePage.txt_Search(driver).sendKeys("Adobe");
		HomePage.btn_SearchforTxt(driver).click();
				
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Adobe Search , " + timeToLoad);	
		
		//Request History
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"OrderHistory");
		//requesthistorypage.
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Request History, " + timeToLoad);
		
		
		//Request History year
//		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"OrderHistory");
		
		RequestHistoryPage.lstStartDate(driver).click();

		RequestHistoryPage.lstStartDate(driver).sendKeys(Keys.TAB);
		
		RequestHistoryPage.lstEndDate(driver).sendKeys("08/01/2019");
		RequestHistoryPage.lstEndDate(driver).sendKeys(Keys.SHIFT, Keys.TAB);
		RequestHistoryPage.lstStartDate(driver).sendKeys("08/01/2018");
		
		start = System.currentTimeMillis();
		
		RequestHistoryPage.btnViewRequests(driver).click();
		
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("1 yr Request History, " + timeToLoad);
		
//		//Request History Month
//		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"OrderHistory");
//		one month is the default
		//Request History Month
		start = System.currentTimeMillis();
		RequestHistoryPage.btnViewRequests(driver).click();
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("1 mo Request History, " + timeToLoad);
	/*	
		Request History 1 year	8141	NA
		Request History 1 month	6467	NA
		Adobe Search	10563	6821

		 */

	   LogOutAction.execute(driver, Glob.gbMobile);
  }
//lighthouse command line
//  @Test  //added to verifypages
  public void LightHouse() throws InterruptedException, IOException {
	  System.out.println("******  Lighthouse  ******");

//	  Process process = Runtime.getRuntime().exec("lighthouse https://www.techsoup.org/products/office-standard-ls-48332- --preset=desktop");
	  @SuppressWarnings("unused")
	Process process = Runtime.getRuntime().exec("foo.bat");
  }  
  @Test  //added to verifypages
  public void Timers() throws InterruptedException, IOException {
	  System.out.println("******  Timers Anonymous ******");
	  
	  	//vars
	  	long start; 
		long timeToLoad;
		  

		
		//Catalog
		start = System.currentTimeMillis();
		
		HomePage.mnuProductCatalog(driver).click();
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Catalog, " + timeToLoad);
		
		driver.get("https://www.google.com/");//resets to base page
		
		//Homepage
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl);
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Homepage, " + timeToLoad);

//		//Homepage
//		start = System.currentTimeMillis();
//		
//		driver.get("https://www.amazon.com");
//		
//		timeToLoad= (System.currentTimeMillis()-start);
//		
////		System.out.println( "anon Amazon, " + timeToLoad);
////		driver.get(Glob.gsUrl);
		
		//Articles
		start = System.currentTimeMillis();
		
		HomePage.invokeArticlesAndHowTos(driver);
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Articles, " + timeToLoad);
		
		//Webinars
		start = System.currentTimeMillis();
		
		HomePage.invokeWebinars(driver);
	
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Webinars, " + timeToLoad);
		System.out.println(driver.getCurrentUrl());
			
		//Adobe Page
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"adobe");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Adobe, " + timeToLoad);
		
		//MSFT Catalog
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"microsoft-catalog");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Microsoft, " + timeToLoad);
		
		//Boost Page
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"boost");
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println("Boost, " + timeToLoad);
		
		//Accounging Category
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+"accounting");
			
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Accounting, " + timeToLoad);
		
		
		//search Adobe
		start = System.currentTimeMillis();
		
		HomePage.btn_Search(driver).click();
		HomePage.txt_Search(driver).sendKeys("Adobe");
		HomePage.btn_SearchforTxt(driver).click();
				
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println( "Adobe Search, " + timeToLoad);	
		
		
		
	   
  }

  @Test (dataProvider = "getPerfPages") //added to verifypages
  public void TenWorstPages(String sPage, String sProductID) throws InterruptedException, IOException {
	 // System.out.println("******  Timers Anonymous ******");
	  
	  	//vars
	  	long start; 
		long timeToLoad;
		
		
		
		
		start = System.currentTimeMillis();
		
		driver.get(Glob.gsUrl+sPage);
		
		
		
		timeToLoad= (System.currentTimeMillis()-start);
		
		System.out.println(sProductID +", " + timeToLoad);
  }
  
  @Test
  public void VerifyLoginOnScroll () throws InterruptedException {
	  driver.get(Glob.gsUrl + "products/little-green-light-g-51461-");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,300)", "");
//	  ProductPage.btnAddToCart(driver).click();
	  Thread.sleep(1500);	  
	  
	  ProductPage.btnLogIn(driver).click();			

	  System.out.println("Scroll down login and this page loads:  "+ driver.getCurrentUrl());
  }
  
  @Test
  public void VerifyAddToCartOnScroll () throws InterruptedException {
	  
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  
	  driver.get(Glob.gsUrl + "products/little-green-light-g-51461-");
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,300)", "");
//	  ProductPage.btnAddToCart(driver).click();
	  Thread.sleep(1500);	  
	  
	  ProductPage.btnAddToCart(driver).click();			

	  System.out.println("Scroll down add to cart this page loads:  "+ driver.getCurrentUrl());
	  
	  LogOutAction.execute(driver, Glob.gbMobile);
  }
  @DataProvider
  public Object[][] getPerfPages()
  {
	Object [][] data= new Object [10][2];

  
	data [0][0] = "products/office-standard-l-55184-" ;
//	data [0][1] = "ls-48332-" ;
	data [0][1] = "l-55184-" ;
	
	data [1][0] = "products/office-for-mac-ls-3013-" ;
	data [1][1] = "ls-3013-" ;
	
	data [2][0] = "products/lenovo-for-nonprofits-access-to-discounted-rates-g-50386-" ;
	data [2][1] = "g-50386-" ;
	
	data [3][0] = "products/adobe-creative-cloud-for-individuals-all-apps-plan-1-year-individual-membership-access-to-discounted-rates-g-49388-" ;
	data [3][1] = "g-49388-" ;
	
	data [4][0] = "products/quickbooks-online-plus-g-49616-" ;
	data [4][1] = "g-49616-" ;
	
	data [5][0] = "products/adobe-acrobat-pro-dc-1-year-individual-membership-access-to-discounted-rates-g-49935-" ;
	data [5][1] = "g-49935-" ;
	
	data [6][0] = "products/windows-operating-system-upgrade-ls-47919-" ;
	data [6][1] = "ls-47919-" ;
	
	data [7][0] = "products/amazon-web-services-credits-for-nonprofits-g-50197-" ;
	data [7][1] = "g-50197-" ;
	
	data [8][0] = "products/hpcom-for-nonprofits-access-to-discounted-rates-g-50903-" ;
	data [8][1] = "g-50903-" ;
	
	data [9][0] = "products/photoshop-elements-2023-and-premiere-elements-2023-bundle-g-45103-products/photoshop-elements-2021-and-premiere-elements-2021-bundle-g-45103-" ;
	data [9][1] = "g-45103-" ;

	return data;
  }

 
  @BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass, "csv");
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