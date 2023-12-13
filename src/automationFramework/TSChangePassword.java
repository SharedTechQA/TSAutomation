/*********************************************************************
 * TSChangePassword.java
 * Test cases for changing password.
 * some issues around this functionality and element id, changes between 
 * environments, etc.
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/



package automationFramework;

import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.MemberDetailsPage;


public class TSChangePassword {
	 private static WebDriver driver = null;

	 String sTestClass = "TSChangePassword";

@Test(dataProvider = "PasswordList", groups = "pword")
	  public void ChangePassword (String sCurrentPw, String sNewPassword, String sConfirmNew, Boolean bResetBack) throws InterruptedException, MalformedURLException, ClassNotFoundException, SQLException {
		
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			


			
			//Edit Account 
			LoginAction.login(driver, Glob.gsPWEmail, Glob.gsPassword, Glob.gbMobile);
			
			
			MemberDetailsPage.ChangePassword(driver, Glob.gsPassword, sNewPassword, sConfirmNew);
			System.out.println("Changing password to:  "+ sNewPassword);
		
			if (bResetBack){
			//verify login with new password	
				System.out.println("Password was changed, login with new password");
			
				LoginAction.login(driver, Glob.gsPWEmail, sNewPassword, Glob.gbMobile);
				String sFoo = driver.getCurrentUrl();
				if (! sFoo.equals(Glob.gsPWUrl)) {
					System.out.println("Expected " +Glob.gsPWUrl + " Got " + sFoo);
					assertEquals(sFoo, Glob.gsPWUrl);
					}

				MemberDetailsPage.ChangePassword(driver, sNewPassword , Glob.gsPassword, Glob.gsPassword);
				System.out.println("Resetting password back to gsPassword:  "+ Glob.gsPassword);
			} 
			
				
					  
	  }

  //@Test
  public void ChangePassword2 () throws InterruptedException, MalformedURLException, ClassNotFoundException, SQLException {

		System.out.println("Cannot change password as the button indentifiers are an issue");

		//****make as Data next****		
		//use logged in password, so if user changes, code remains the same and functional
		String sNewPassword = "B0nny99!";
		String sConfirmPassword = "B0nny99!";
		
		//Edit Account 
		LoginAction.login(driver, Glob.gsPWEmail, Glob.gsPassword, Glob.gbMobile);
//		MyAccountPage.invoke(driver);
//		MyAccountPage.btnChangePassword(driver).click();
		
		MemberDetailsPage.ChangePassword(driver, Glob.gsPassword, sNewPassword, sConfirmPassword);
		//MemberDetailsPage.EditMember (driver, sEditFirstName, sEditLastName, sEditSecurityQuestion,  sEditSecurityAnswer);
		
		
		///*****Reset Password back  Cleanup!*****/// 
		System.out.println("cleaning up, putting password for user back");
		//gotta passs in new password as this is after reset
		LoginAction.login(driver, Glob.gsPWEmail, sNewPassword, Glob.gbMobile);
		MemberDetailsPage.ChangePassword(driver, sNewPassword, Glob.gsPassword, Glob.gsPassword);
		
		
				  
  }
  @DataProvider
  public Object[][] PasswordList(){
	  Object [][] data= new Object [3][4];  //x datasets of y
	  	
	  	//correct
	  	data [0][0] = "B00ker99!";
	    data [0][1] = "B0nny99!";
	    data [0][2] = "B0nny99!";
	    data [0][3] = true;
	    
//	    //all same  //slightly different workflow here.  if user updates pword to same pword
	  	data [1][0] = "B00ker99!";
	    data [1][1] = "B00ker99!";
	    data [1][2] = "B00ker99!";
	    data [1][3] = false;
	    
//	    //all bad new
	  	data [2][0] = "B00ker99!";
	    data [2][1] = "B0nny99!";
	    data [2][2] = "B00ker99!";
	    data [2][3] = false;

	
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
