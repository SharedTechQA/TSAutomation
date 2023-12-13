/*********************************************************************
 * TSContactUs.java
 *   
 * temporarily disabled
 * 
 *	Matt Radford 
 * ********************************************************************/


package automationFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;

import pageObjects.ContactUs;

public class TSContactUs {
	 private static WebDriver driver = null;
	 
	 String sTestClass = "TSContactUs";
	 
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	    
 @Test(dataProvider = "contact" )
 public void ContactUs (String sSubject, String sFirstName, String sLastName, String sEmailAddress, String sOrganization, String sEIN, String OrderNum, String sMessage, String sPassFail) throws InterruptedException {

		//String sExpectedTitle = "Join TechSoup";
	  System.out.println("Running contact us.  Cannot contact owing to captcha");	
	  
	  	driver.get(Glob.gsUrl+"about-us/contact-us");	
	  //Thread.sleep(5000);
	  	System.out.println("Status for this iteration: " + sPassFail);
	  	
	  	ContactUs.ContactForm(driver, sSubject, sFirstName, sLastName, sEmailAddress, sOrganization, sEIN, OrderNum, sMessage);
		
	  	
 }
 @DataProvider
 public Object[][] contact (){
 	  Object [][] data= new Object [4][9];  //x datasets of y
 	    data [0][0] = "Association Code and Authorized Agents"; 
 	    data [0][1] = "FirstName"; 
 	    data [0][2] = "LastName"; 
 	    data [0][3] = "EMail Address"; 
 	    data [0][4] = "Organization"; 
 	    data [0][5] = "EIN"; 
 	    data [0][6] = "OrderNum"; 
 	    data [0][7] = "Rudy, a message to you Rudy";
 	    data [0][8] = "should pass";
 	    
 	    data [1][0] = "Association Code and Authorized Agents"; 
	    data [1][1] = "FirstName"; 
	    data [1][2] = "LastName"; 
	    data [1][3] = "EMail Address"; 
	    data [1][4] = "Organization"; 
	    data [1][5] = "EIN"; 
	    data [1][6] = "OrderNum"; 
	    data [1][7] = ""; 
	    data [1][8] = "should fail, no message";

 	    data [2][0] = "Microsoft Changes"; 
	    data [2][1] = "FirstName"; 
	    data [2][2] = "LastName"; 
	    data [2][3] = "EMail Address"; 
	    data [2][4] = "Organization"; 
	    data [2][5] = "EIN"; 
	    data [2][6] = "OrderNum"; 
	    data [2][7] = "message"; 
	    data [2][8] = "should pass";
 	    
 	    data [3][0] = "Microsoft Expired Link Help"; 
	    data [3][1] = "FirstName"; 
	    data [3][2] = "LastName"; 
	    data [3][3] = "EMail Address"; 
	    data [3][4] = "Organization"; 
	    data [3][5] = "EIN"; 
	    data [3][6] = "OrderNum"; 
	    data [3][7] = ""; 
	    data [3][8] = "should fail, no message";
 	    
 	    
return data;
 }
 @Parameters({ "Glob.gsBrowser"})
 @BeforeClass
	public void beforeClass(String sBrowser) throws IOException {

	 	Glob.setOutPutDirectory(sTestClass, "txt");
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +"!!!!!****");
 }
 
 @Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
 @BeforeTest(alwaysRun = true)
 	public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException {
 		  	Glob.setEnv(sEnv);
 		  	Glob.gbMobile = bMobile;
 		  	//System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );;
 		
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
 	public void afterTest() throws InterruptedException {
 		System.out.println("after Test");
 		
 	
 		driver.quit();
 	}
}
