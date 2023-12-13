/*********************************************************************
 * TSMobileJoin.java
 * Area for testing new methods, etc.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import pageObjects.JoinTSPage;
import pageObjects.MobileHomePage;

public class TSMobileJoin {
	 private static WebDriver driver = null;
	 
	 String sTestClass = "TSMobileJoin";
	 
//	 Username: uzmafathima1
//	 Access Key: nyR7HXaaQySXGoYpZQwW
	  public static final String USERNAME = "uzmafathima1";//"matthewradford1";
	  public static final String AUTOMATE_KEY = "nyR7HXaaQySXGoYpZQwW"; //"HjtSygHwoZs6p4wSHUTN";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
  @Test
  public void Join_TS () throws MalformedURLException {
	  System.out.println("in the Test");
	  //test on phone, click help, etc.
//	    DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("os_version", "11");
//	    caps.setCapability("device", "iPhone X");
//	    caps.setCapability("real_mobile", "true");
//	    caps.setCapability("browserstack.local", "false");
//	 //   caps.setCapability("browserstack.local", "true");
//	    
//		 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    

	  System.out.println("Running Join TS page.  Verify entry to fields allowed.  Cannot join owing to captcha");	

	  	MobileHomePage.mnuHamburger(driver).click();
	  	MobileHomePage.btnJoin(driver).click();
	  	
		JoinTSPage.txtFirstName(driver).sendKeys("TestFirstName");
		JoinTSPage.txtLastName(driver).sendKeys("TestLastName");
		JoinTSPage.txtEmail(driver).sendKeys("testemail@foobar.net");
		JoinTSPage.txtConfirmEmail(driver).sendKeys("testemail@foobar.net");
		JoinTSPage.txtCommunityNickname(driver).sendKeys("TestCommunityNickname");
		JoinTSPage.txtPassword(driver).sendKeys("B00ker99!");
		JoinTSPage.txtConfirmPassword(driver).sendKeys("B00ker99!");
/* security question and answer removed*/
//		JoinTSPage.txtSecurityQuestion(driver).sendKeys("Black");
//		JoinTSPage.txtSecurityAnswer(driver).sendKeys("BLaCK");
		JoinTSPage.chkByTheCup(driver).click();
		JoinTSPage.chkProductAlerts(driver).click();
		JoinTSPage.chkTermsOfUse(driver).click();
		//JoinTSPage.chkTermsOfUse(driver).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.SPACE);
		//Keys.ARROW_DOWN, Keys.ARROW_DOWN,  Keys.ENTER
		//JoinTSPage.chkCaptcha(driver).click();
//		int m=gotoframe(driver, By.xpath(".//*[id='recaptcha-anchor']"));
//		driver.switchTo().frame(m);
		//driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
		
		
		JoinTSPage.btnContinue(driver).click();
		//driver.quit();	
		
			
				
		

	  
  }
  @Test
  public void VerifyJoinTS () throws MalformedURLException {
	  System.out.println("in the Test");
//	  //test on phone, click help, etc.
//	    DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("browserstack.debug", "true");
//	    caps.setCapability("browserName", "iPhone");
//	    caps.setCapability("device", "iPhone 7");
//	    caps.setCapability("realMobile", "true");
//	    caps.setCapability("os_version", "10.3");
//	   // caps.setCapability("browserstack.local", "true");
//	    
//		 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("Running Verify required messages" );
	 // String sUrl = "https://www.techsoup.org";
	  //driver.get(sUrl);
	  MobileHomePage.mnuHamburger(driver).click();
	  MobileHomePage.btnJoin(driver).click();
	  JoinTSPage.btnContinue(driver).click();
	  
	  String sFoundNameRequired = JoinTSPage.lblFirstNameRequired(driver).getText();
	  Glob.VerifyText(sFoundNameRequired, JoinTSPage.sFirstNameRequired);
	  
	  String sFoundLastNameRequired = JoinTSPage.lblLastNameRequired(driver).getText();
	  Glob.VerifyText(sFoundLastNameRequired, JoinTSPage.sLastNameRequired);
	  
	  String sFoundEmailRequired = JoinTSPage.lblEmailRequired(driver).getText();
	  Glob.VerifyText(sFoundEmailRequired, JoinTSPage.sEmailRequired);
	  
	  String sFoundConfirmEmailRequired = JoinTSPage.lblConfirmEmailRequired(driver).getText();
	  Glob.VerifyText(sFoundConfirmEmailRequired, JoinTSPage.sConfirmEmailRequired);
	  
	  String sFoundNickNameRequired = JoinTSPage.lblCommunityNickNameRequired(driver).getText();
	  Glob.VerifyText(sFoundNickNameRequired, JoinTSPage.sCommunityNickNameRequired);
	  
	  String sFoundPasswordRequired = JoinTSPage.lblPasswordRequired(driver).getText();
	  Glob.VerifyText(sFoundPasswordRequired, JoinTSPage.sPasswordRequired);
	  
	  String sFoundConfirmPasswordRequired = JoinTSPage.lblConfirmPasswordRequired(driver).getText();
	  Glob.VerifyText(sFoundConfirmPasswordRequired, JoinTSPage.sConfirmPasswordRequired);
	  
	  /* security question and answer removed */
//	  String sFoundSecurityQuestionRequired = JoinTSPage.lblSecurityQuestionRequired(driver).getText();
//	  Glob.VerifyText(sFoundSecurityQuestionRequired, JoinTSPage.sSecurityQuestionRequired);
//	  
//	  String sFoundAnswerRequired = JoinTSPage.lblSecurityAnswerRequired(driver).getText();
//	  Glob.VerifyText(sFoundAnswerRequired, JoinTSPage.sAnswerRequired);

	  /*removed*/
//	  String sFoundTermsRequired = JoinTSPage.lblTermsRequired(driver).getText();
//	  Glob.VerifyText(sFoundTermsRequired, JoinTSPage.sTermsRequired);
//	  
	  String sFoundCaptchaRequired = JoinTSPage.lblCaptchaRequired(driver).getText();
	  Glob.VerifyText(sFoundCaptchaRequired, JoinTSPage.sCaptchaRequired);
	  
	  //driver.get(sUrl);
	  
  }
  
  @Test
  public void VerifyJoinErrorMessages () throws MalformedURLException {
//	    DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("browserstack.debug", "true");
//	    caps.setCapability("browserName", "iPhone");
//	    caps.setCapability("device", "iPhone 7");
//	    caps.setCapability("realMobile", "true");
//	    caps.setCapability("os_version", "10.3");
//	   // caps.setCapability("browserstack.local", "true");
//	    
//		 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  System.out.println("Running Verify required messages" );
//	  String sUrl = "https://www.techsoup.org";
//	  driver.get(sUrl);
	  
	  MobileHomePage.mnuHamburger(driver).click();
	  MobileHomePage.btnJoin(driver).click();
	  System.out.println("Running verify errors");
	  //HomePage.btn_Join(driver).click();
	  
	  JoinTSPage.txtEmail(driver).sendKeys("ASDF");
	  JoinTSPage.txtConfirmEmail(driver).click();
	  JoinTSPage.lblEmailInvalid(driver).click();
	  
	  String sFoundEmailInvalid = JoinTSPage.lblEmailInvalid(driver).getText();
	  Glob.VerifyText(sFoundEmailInvalid, JoinTSPage.sEmailInvalid);
	  
	  JoinTSPage.txtConfirmEmail(driver).sendKeys("asdf@foo.com", Keys.TAB);
	  String sMatchConfirmError = JoinTSPage.lblEmailEmailMatch(driver).getText();
	  Glob.VerifyText(sMatchConfirmError, JoinTSPage.sEmailMustMatch);
	 
	  JoinTSPage.txtPassword(driver).sendKeys("xU3", Keys.RETURN); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchLengthError = JoinTSPage.lblPasswordLength(driver).getText();
	  Glob.VerifyText(sMatchLengthError, JoinTSPage.sPasswordLength);
	  JoinTSPage.txtPassword(driver).clear();
	  
	  JoinTSPage.txtPassword(driver).sendKeys("xupp3rsx", Keys.RETURN); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchUpperError = JoinTSPage.lblPasswordUpper(driver).getText();
	  Glob.VerifyText(sMatchUpperError, JoinTSPage.sPasswordUpper);
	  JoinTSPage.txtPassword(driver).clear();
	  
	  JoinTSPage.txtPassword(driver).sendKeys("XLOW3RSX", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchLowerError = JoinTSPage.lblPasswordLower(driver).getText();
	  Glob.VerifyText(sMatchLowerError, JoinTSPage.sPasswordLower);
	  JoinTSPage.txtPassword(driver).clear();
	  
	  JoinTSPage.txtPassword(driver).sendKeys("XLOWeRSX", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchNumberError = JoinTSPage.lblPasswordNumber(driver).getText();
	  Glob.VerifyText(sMatchNumberError, JoinTSPage.sPasswordNumber);
	  JoinTSPage.txtPassword(driver).clear();
	  
	  
  }
  
  @BeforeClass
	public void beforeClass() {
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
  			
  			Glob.setOutPutDirectory(sTestClass);
  			
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
