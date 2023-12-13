/*********************************************************************
 * TSGeneralHomePage.java
 * TestCases for General home page
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;
import org.openqa.selenium.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import appModule.GetProductAction;
import appModule.Glob;
import appModule.LoginAction;
import appModule.SearchAction;
import pageObjects.BoostSignUpPage;
import pageObjects.CommunityPage;
import pageObjects.HelpPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.ProductCatalogPage;
import pageObjects.SubscribePage;
import pageObjects.cloudCatalogPage;


public class TSGeneralHomePage {
	  private static WebDriver driver = null;
	
	  String sTestClass = "TSGeneralHomePage";
	  
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

// @Test	
 public void VerifyMenusTest() throws InterruptedException{

	 		System.out.println("Running Verify Menus test");
		  	String sFound;
		  	String sFoundURL = driver.getCurrentUrl();
			System.out.println("number of links on home page is:  " + driver.findElements(By.tagName("a")).size());
			System.out.println("footer number links:  " + HomePage.lblFooter(driver).findElements(By.tagName("a")).size());

			//Set<Cookie> sCookies = driver.manage().getCookies();
			
			//System.out.println("cookies" + sCookies);
			
			//boost
			HomePage.mnu_Services(driver).click();
			//Boost checks for values on page
			HomePage.miBoost(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsBoost);
			String sFoundButtonText = BoostSignUpPage.btnLoginToUpgrade(driver).getText();
			Glob.VerifyText(sFoundButtonText, BoostSignUpPage.sBoostButtonText);
//			String sFoundLblText = BoostSignUpPage.lblBoostMembers(driver).getText();  //changed from QA version in stage, will not be there in prod
//			Glob.VerifyText(sFoundLblText, BoostSignUpPage.sLblBoostMemberText);
//			String sFoundLnkText = BoostSignUpPage.lnkCheckOutTheBoostCatalog(driver).getText();
//			Glob.VerifyText(sFoundLnkText, BoostSignUpPage.sLnkCheckOutCatalogText);
			
			//overview
			HomePage.mnu_Services(driver).click();
			HomePage.miOverview(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsOverview);
			
			//helpDesk
			HomePage.mnu_Services(driver).click();
			HomePage.miHelpDesk(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsHelpDesk);
				
			//office 365
			HomePage.mnu_Services(driver).click();
			HomePage.miOffice365(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsOffice365);
			
			HomePage.mnu_Services(driver).click();
			HomePage.miTechImplementation(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsTechImplementation);
			
			
			HomePage.mnu_Services(driver).click();
			HomePage.mi_ManagedITServices(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsManagedIT);
			
			HomePage.mnu_Services(driver).click();
			HomePage.miCourses(driver).click();
			Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsCourses);
			
			
			HomePage.mnu_Services(driver).click();
			//HomePage.miConsultantConnection(driver).click();
			//Glob.VerifyText(driver.getCurrentUrl(), HomePage.gsConsultantConnection);
			
		
	  }
					
			
@Test
public void GeneralTest() throws InterruptedException{
			System.out.println("** Running General Test of home page items");
			String sFound = null;
			driver.findElement(By.cssSelector("#page-header > nav > div > a")).click();
			
			System.out.println("click browse catalog");
			
		
			HomePage.btnBrowseCatalog(driver).click();
			
			sFound = driver.getCurrentUrl();
			Glob.VerifyText(sFound, ProductCatalogPage.sCatalogPageURL);
			
			driver.navigate().back();
			
			System.out.println("click cloud offers");
			  
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			Thread.sleep(1000);
			HomePage.btnCloudOffers(driver).click();
			System.out.println("in the cloud offers");
			
			sFound = driver.getCurrentUrl();
			System.out.println(sFound);
			Glob.VerifyText(sFound, cloudCatalogPage.sCloudPageURL);
			
//		not valid any longer	cloudCatalogPage.lstCategory(driver).sendKeys("Infrastructure as a Service");
//			System.out.println("switch dropdown items");
//			cloudCatalogPage.lstCategory(driver).sendKeys("Software as a Service");
			
			

			driver.navigate().back();
			
	
			//***Have to navigate back to home url, as the selector changes if on blog page for community menu
			System.out.println("Back to Home page: " + Glob.gsUrl);
			driver.get(Glob.gsUrl);
//			HomePage.invokeCommunityPage(driver);
			driver.get(Glob.gsUrl + "/community");
			System.out.println("current url should be community is: "  + driver.getCurrentUrl());
			HomePage.invokeEvents(driver);
				
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);		
			
			SubscribePage.invoke(driver);
			SubscribePage.btnByTheCup(driver).click();
			SubscribePage.btnTechSoupforLibraries(driver).click();
	
				
			MyAccountPage.invoke(driver);
			
			System.out.println("number of orgs:  " + MyAccountPage.tblMyOrganizations(driver).findElements(By.tagName ("a")).size());
			
			
			
			//System.out.println("login and logout Successful");
			
	  }
//@Test  not possible as of yet
public void TestAdminPage () throws InterruptedException, IOException{
	System.out.println("****!!!!! Launching Admin Site, totally useless.  cannot intereact with login box !!!!!****");
	
	driver.get(Glob.gsAdminSite);
	
	System.out.println(driver.getCurrentUrl());
	
	Glob.GetScreenShot(driver, sTestClass, "admin_grab");

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
	public void afterTest() throws InterruptedException {
		System.out.println("after Test");
		
	
		driver.quit();
	}

}
