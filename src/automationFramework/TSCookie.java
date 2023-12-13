/*********************************************************************
 * TSCookie.java
 * might be deprecated.  cookie is encrypted.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
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
import pageObjects.cartPage;
import pageObjects.SelectOrgPage;



public class TSCookie {
	WebDriver driver = null;
	String sTestClass = "TSCookie";
	
  @Test  //added to verifypages
  public void CheckCookie() throws InterruptedException, IOException {
//	  System.out.println("find check");

	
	   
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
		 
		 
	  //driver.
	 
		 
//		 __CSUserNameCookie
		 Cookie sCookie = driver.manage().getCookieNamed("__CSUserNameCookie");
		 Cookie sCookie2 = driver.manage().getCookieNamed("CSFUser");
		 Cookie sCookie3 = driver.manage().getCookieNamed("WSS_FullScreenMode");
		 Cookie sCookie4 = driver.manage().getCookieNamed("__CSOrderGroupIdCookie");//cookie populated after add to cart.  will get expired
		 
		 
		// 
		 
		 System.out.println(sCookie2);
		 
		// System.out.println(sCookie2.getExpiry());
		 String sGotCookieValue = sCookie2.getValue();
				 
		 assertEquals(sCookie2.getValue(), "username=madmattpaddles&emailAddress=madmattpaddles@gmail.com&fullName=madmattpaddles");
//		 username=madmattpaddles&emailAddress=madmattpaddles@gmail.com&fullName=madmattpaddles
		// assertEquals(sCookie2.getValue(), "encrypted cookie");
		 
//		 LMkB24iogDWWRkCfu1OyLGBpSkvX9wP/J7x2TRN/2w6pd9xfaRkvRqJdDa7lEJnHla1hRlzr+eI=
		// assertEquals(sCookie.getValue(), "MadMattPaddles");
		 assertEquals(sCookie.getValue(), "encrypted cookie");
		 assertEquals(sCookie3.getValue(), "false");
		 assertEquals(sCookie4.getValue(), "");
		 
		 
		 System.out.println(sCookie2.getValue());
		 
	   
	   driver.get(Glob.gsUrl + "/sitemap.xml");
	  //String sCanonical = driver.findElement(By.partialLinkText("test-matt-content-g-51486")).getText();
	  
	 
	   
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