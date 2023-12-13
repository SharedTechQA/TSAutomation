/*********************************************************************
 * TSCreateLoad.java
 * used to create some page loads for cache testing with sp2019 and imperva changes
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/
package automationFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.ProductPage;

public class TSCreateLoad {
	 static WebDriver driver = null;
	 
	 public static String sTestClass = "TSCreateLoad";
	 

@Test
public static void aiteratePages () throws InterruptedException {
	String sTestGroup = "/loadtest/";
	LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	for (int i = 0; i < 300; i++) {
		System.out.println(i);
		System.out.println("***** running aIterate*******");
		driver.get(Glob.gsUrl +	    "Adobe"); 
		driver.get(Glob.gsUrl +	    "ADP"); 
		driver.get(Glob.gsUrl +	    ""); 
		driver.get(Glob.gsUrl +	    "support/articles-and-how-tos"); 
		driver.get(Glob.gsUrl +	    "computers-and-electronics");
		
		/*
		driver.get(Glob.gsUrl +	    "airbnb-social-impact-experiences"); 
		driver.get(Glob.gsUrl +	    "alpha-software"); 
		driver.get(Glob.gsUrl +	    "amazon-web-services"); 
		driver.get(Glob.gsUrl +	    "arreva"); 
		driver.get(Glob.gsUrl +	    "asana"); 
		driver.get(Glob.gsUrl +	    "atlas-business-solutions"); 
		driver.get(Glob.gsUrl +	    "autodesk"); 
		driver.get(Glob.gsUrl +	    "avepoint"); 
		driver.get(Glob.gsUrl +	    "azavea"); 
		driver.get(Glob.gsUrl +	    "bitdefender"); 
		driver.get(Glob.gsUrl +	  "blackbaud"); 
		driver.get(Glob.gsUrl +	    "bloomerang"); 
		driver.get(Glob.gsUrl +	     "boost"); 
		driver.get(Glob.gsUrl +	     "box"); 
		driver.get(Glob.gsUrl +	  "bytes-of-learning"); 
		driver.get(Glob.gsUrl +	   "caravan-studios"); 
		driver.get(Glob.gsUrl +	     "cisco"); 
		driver.get(Glob.gsUrl +	     "cisco-meraki"); 
		driver.get(Glob.gsUrl +	    "citysoft"); 
		driver.get(Glob.gsUrl +	    "clicktime"); 
		driver.get(Glob.gsUrl +	    "comodo"); 
		driver.get(Glob.gsUrl +	   "connect2give"); 
		driver.get(Glob.gsUrl +	    "dell"); 
		driver.get(Glob.gsUrl +	     "dharma-merchant-services"); 
		driver.get(Glob.gsUrl +	    "docusign"); 
		driver.get(Glob.gsUrl +	     "donorperfect"); 
		driver.get(Glob.gsUrl +	     "efficient-elements"); 
		driver.get(Glob.gsUrl +	     "filemaker"); 
		driver.get(Glob.gsUrl +	     "flixbus"); 
		driver.get(Glob.gsUrl +	     "goodwings"); 
		driver.get(Glob.gsUrl +	     "google-for-nonprofits"); 
		driver.get(Glob.gsUrl +	     "grantstation"); 
		driver.get(Glob.gsUrl +	     "headsets"); 
		driver.get(Glob.gsUrl +	     "horizon-datasys"); 
		driver.get(Glob.gsUrl +	     "hp-inc"); 
		driver.get(Glob.gsUrl +	     "hr-solutions-partners"); 
		driver.get(Glob.gsUrl +	   "infocus"); 
		driver.get(Glob.gsUrl +	     "intuit"); 
		driver.get(Glob.gsUrl +	     "journeyed"); 
		driver.get(Glob.gsUrl +	     "kintone"); 
		driver.get(Glob.gsUrl +	    "lenovo"); 
		driver.get(Glob.gsUrl +	     "linksys"); 
		driver.get(Glob.gsUrl +	     "little-green-light"); 
		driver.get(Glob.gsUrl +	     "mailshell"); 
		driver.get(Glob.gsUrl +	     "microsoft-discount"); 
		driver.get(Glob.gsUrl +	     "microsoft-catalog"); 
		driver.get(Glob.gsUrl +	     "mileiq"); 
		driver.get(Glob.gsUrl +	     "mimo-monitors"); 
		driver.get(Glob.gsUrl +	     "mobile-beacon"); 
		driver.get(Glob.gsUrl +	     "nortonlifelock"); 
		driver.get(Glob.gsUrl +	     "notejoy"); 
		driver.get(Glob.gsUrl +	    "how-okta-helps-nonprofits"); 
		driver.get(Glob.gsUrl +	     "payanywhere"); //was oracle netsuite....fixing for now
		driver.get(Glob.gsUrl +	     "otter-ai"); 
		driver.get(Glob.gsUrl +	     "paya"); 
		driver.get(Glob.gsUrl +	     "payanywhere"); 
		driver.get(Glob.gsUrl +	     "people-onthego"); 
		driver.get(Glob.gsUrl +	     "pluralsight"); 
		driver.get(Glob.gsUrl +	     "priority"); 
		driver.get(Glob.gsUrl +	     "questionpro"); 
		driver.get(Glob.gsUrl +	     "quickbooks-made-easy"); 
		driver.get(Glob.gsUrl +	     "rain-design"); 
		driver.get(Glob.gsUrl +	     "reading-eggs"); 
		driver.get(Glob.gsUrl +	     "refurbished-computers-catalog"); 
		driver.get(Glob.gsUrl +	   "sap-litmos"); 
		driver.get(Glob.gsUrl +	    "shutterstock"); 
		driver.get(Glob.gsUrl +	     "skillsoft"); 
		driver.get(Glob.gsUrl +	     "snpo"); 
		driver.get(Glob.gsUrl +	    "sparrow"); 
		driver.get(Glob.gsUrl +	     "slack"); 
		driver.get(Glob.gsUrl +	     "tableau"); 
		driver.get(Glob.gsUrl +	     "tech-impact"); 
		driver.get(Glob.gsUrl +	     "techbridge"); 
		driver.get(Glob.gsUrl +	     "techsoup-services"); 
		driver.get(Glob.gsUrl +	     "ultralingua"); 
		driver.get(Glob.gsUrl +	     "usb-memory-direct"); 
		driver.get(Glob.gsUrl +	     "veritas"); 
		driver.get(Glob.gsUrl +	     "vmware"); 
		driver.get(Glob.gsUrl +	    "western-digital"); 
		driver.get(Glob.gsUrl +	     "wework"); 
		driver.get(Glob.gsUrl +	     "workplace-by-facebook"); 
		driver.get(Glob.gsUrl +	     "zoner"); 
		driver.get(Glob.gsUrl +	     "zoom");
		driver.get(Glob.gsUrl +	     "wix");
		driver.get(Glob.gsUrl +	     "pagerduty");
		driver.get(Glob.gsUrl +	     "sparkol");
		driver.get(Glob.gsUrl +	    "teamviewer");*/

	}
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
