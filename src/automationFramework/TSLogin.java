/*********************************************************************
 * TSlogin.java
 * Test case testing Area for testing login, etc.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package automationFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.MemberDetailsPage;
import pageObjects.MyAccountPage;
import pageObjects.logInPage;


public class TSLogin {
	 private static WebDriver driver = null;
	 
	 
	  String sTestClass = "TSLogin";
	  //edit member 
	  //change password

  @Test (dataProvider = "getLoginData")
  public void CheckLoginError (String sEmail, String sPassword, Boolean bMobile, String sError ) throws InterruptedException {
	  String sFound;
	  driver.get(Glob.gsUrl);
	  LoginAction.login(driver, sEmail, sPassword, bMobile);
	  
	  if (sEmail.equals("")) {
		sFound=logInPage.lstEmailError(driver).getText();
		Glob.VerifyText(sFound, sError);
	 
	  }
	  else if (sPassword.equals("")) {
		  sFound=logInPage.lstPasswordError(driver).getText();
		  Glob.VerifyText(sFound, sError);
		   
	  }
	  else {
		  sFound=logInPage.lstError(driver).getText();
		  Glob.VerifyText(sFound, sError);
	  }
  }
	  
////  @Test
//  public void ChangePassword () throws InterruptedException, MalformedURLException {
//	
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//
//		//****make as Data next****		
//		//use logged in password, so if user changes, code remains the same and functional
//		String sNewPassword = "B0nny99!";
//		String sConfirmPassword = "B0nny99!";
//		//driver.manage().window().maximize();
//		
//		
//		//Edit Account 
//		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
////		MyAccountPage.invoke(driver);
////		MyAccountPage.btnChangePassword(driver).click();
////		
//		
//		MemberDetailsPage.ChangePassword(driver, Glob.gsPassword, sNewPassword, sConfirmPassword);
//		
//		LoginAction.login(driver, Glob.gsEmail, sNewPassword, Glob.gbMobile);
//	
//		
//		MemberDetailsPage.ChangePassword(driver, sNewPassword , Glob.gsPassword, Glob.gsPassword);
//		
//		//MemberDetailsPage.EditMember (driver, sEditFirstName, sEditLastName);
////		
////		
////		///*****Reset Password back  Cleanup!*****/// 
////		System.out.println("cleaning up, putting password for user back");
////		//gotta passs in new password as this is after reset
////		LoginAction.browserlogin(driver, Glob.gsEmail, sNewPassword);
////		MemberDetailsPage.ChangePassword(driver, sNewPassword, Glob.gsPassword, Glob.gsPassword);
//		
//		
//				  
//  }
  
  @DataProvider
  public Object[][] getLoginData(){
	  Object [][] data= new Object [4][4];

		data [0][0] = "matttest@foobar" ;//email
		data [0][1] =  "B00ker99!";//password
		data [0][2] =  Glob.gbMobile;//password
		data [0][3] = "The email address or password you entered doesn't match our records. Please re-enter your information and try again.";
		
		data [1][0] = "matttest@foobar.net" ;//email
		data [1][1] =  "Somepassword";//password
		data [1][2] =  Glob.gbMobile;//password
		data [1][3] = "The email address or password you entered doesn't match our records. Please re-enter your information and try again.";
		
		data [2][0] = "";//email
		data [2][1] = "Somepassword";//password
		data [2][2] =  Glob.gbMobile;//password
		data [2][3] = "Please enter your email address.";
		
		data [3][0] = "matttest@foobar.net" ;//email
		data [3][1] =  "";//password
		data [3][2] =  Glob.gbMobile;//password
		data [3][3] = "Please enter your password.";
		
		
	return data;
  }
  @BeforeClass
	public void beforeClass() throws IOException {
	  	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}
  
  @AfterClass
	public void afterClass() throws IOException {
		Glob.setTestNGOutPutDirectory(sTestClass);

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
  	public void afterTest() throws InterruptedException {
  		System.out.println("after Test");
  		
  	
  		driver.quit();
  	}
 
}
