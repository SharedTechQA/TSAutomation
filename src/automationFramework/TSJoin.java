/*********************************************************************
 * TSJoin.java
 * Test case Area for join page, etc.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package automationFramework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import pageObjects.HomePage;
import pageObjects.JoinTSPage;
import pageObjects.MemberDetailsPage;

public class TSJoin {
	 private static WebDriver driver = null;
	 
	 String sTestClass = "TSJoin";
	 
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	    
  @Test
  public void Join_TS () throws InterruptedException {

		//String sExpectedTitle = "Join TechSoup";
	  System.out.println("Running Join TS page.  Verify entry to fields allowed.  Cannot join owing to captcha");	
	  
	  	driver.get(Glob.gsUrl);	
		
	  	JoinTSPage.Join(driver, Glob.gbMobile);
	  	
	  	//mobileHomePage.btnJoin(driver).click();
	  	
//	  	String sFoundTitle = JoinTSPage.lblTitle(driver).getText();
//	  	assertEquals(sFoundTitle, JoinTSPage.sJoinPageTitle);
	  	
		JoinTSPage.txtFirstName(driver).sendKeys("TestFirstName");
		JoinTSPage.txtLastName(driver).sendKeys("TestLastName", Keys.TAB);
		System.out.println("Community Nickname is:  " + JoinTSPage.txtCommunityNickname(driver).getText());
		
		String sFoundCommLabel = JoinTSPage.lblCommunityNicknameText(driver).getText();
		Glob.VerifyText(sFoundCommLabel, JoinTSPage.sNickNameText);
		
		JoinTSPage.txtEmail(driver).sendKeys("testemail@foobar.net");
		JoinTSPage.txtConfirmEmail(driver).sendKeys("testemail@foobar.net");
		//System.out.println("Community Nickname is:  " + JoinTSPage.txtCommunityNickname(driver).getText());
		JoinTSPage.txtCommunityNickname(driver).sendKeys("TestCommunityNickname");
		JoinTSPage.txtPassword(driver).sendKeys("B00ker99!");
		JoinTSPage.txtConfirmPassword(driver).sendKeys("B00ker99!", Keys.TAB, Keys.TAB, Keys.SPACE);
/* removed the security answer and question, 7/11 story PT120*/		
//		JoinTSPage.txtSecurityQuestion(driver).sendKeys("Black");
//		JoinTSPage.txtSecurityAnswer(driver).sendKeys("BLaCK");
//		JoinTSPage.chkByTheCup(driver).click();
//		JoinTSPage.chkProductAlerts(driver).click();
		
		
		//deprecated, 4/15/2019
		/*****  JoinTSPage.chkTermsOfUse(driver).click();****/  
		
		//JoinTSPage.chkTermsOfUse(driver).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.SPACE);
		//Keys.ARROW_DOWN, Keys.ARROW_DOWN,  Keys.ENTER
		//JoinTSPage.chkCaptcha(driver).click();
//		int m=gotoframe(driver, By.xpath(".//*[id='recaptcha-anchor']"));
//		driver.switchTo().frame(m);
		//driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000);");
		
		Thread.sleep(1000);
		JoinTSPage.btnContinue(driver).click();
			
  }
  
  @Test
  public void VerifyJoinTS () {
	  System.out.println("Running Verify required messages" );
	  
	  JoinTSPage.Join(driver, Glob.gbMobile);
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2500);");
	  
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
	  
	  String sFoundPasswordRequired = JoinTSPage.lblPasswordLength(driver).getText();
	  //String sFoundPasswordRequired = JoinTSPage.lblPasswordRequired(driver).getText();
	  Glob.VerifyText(sFoundPasswordRequired, JoinTSPage.sPasswordLength);
	  
	  String sFoundConfirmPasswordRequired = JoinTSPage.lblConfirmPasswordRequired(driver).getText();
	  Glob.VerifyText(sFoundConfirmPasswordRequired, JoinTSPage.sConfirmPasswordRequired);
	
	  /* removed the security answer and question, 7/11 story PT120*/	
//	  String sFoundSecurityQuestionRequired = JoinTSPage.lblSecurityQuestionRequired(driver).getText();
//	  Glob.VerifyText(sFoundSecurityQuestionRequired, JoinTSPage.sSecurityQuestionRequired);
//	  
//	  String sFoundAnswerRequired = JoinTSPage.lblSecurityAnswerRequired(driver).getText();
//	  Glob.VerifyText(sFoundAnswerRequired, JoinTSPage.sAnswerRequired);
	
	  /*  Removed */  
//	  String sFoundTermsRequired = JoinTSPage.lblTermsRequired(driver).getText();
//	  Glob.VerifyText(sFoundTermsRequired, JoinTSPage.sTermsRequired);
	  
	  String sFoundCaptchaRequired = JoinTSPage.lblCaptchaRequired(driver).getText();
	  Glob.VerifyText(sFoundCaptchaRequired, JoinTSPage.sCaptchaRequired);
	  
	  driver.get(Glob.gsUrl);
	  
  }
  
  @Test
  public void VerifyJoinNoErrorMessage () {
	  System.out.println("Running verify NO errors");
	  
	  JoinTSPage.Join(driver, Glob.gbMobile);
	  
	  JoinTSPage.txtEmail(driver).sendKeys("matt@foo.org");
	  JoinTSPage.txtConfirmEmail(driver).click();
	  if (JoinTSPage.lblEmailEmailMatch(driver).isDisplayed()) {
		  System.out.println("Emails must match displayed in ERROR");
	  }
	  System.out.println("Basic Email Verification");
	  String sFoundEmailInvalid = JoinTSPage.lblEmailInvalid(driver).getText();
	  Glob.VerifyText(sFoundEmailInvalid, JoinTSPage.sEmailInvalid);
	  
	  System.out.println("Confirm email Verification");
	  JoinTSPage.txtConfirmEmail(driver).sendKeys("asdf@foo.com", Keys.TAB);
	  String sMatchConfirmError = JoinTSPage.lblEmailEmailMatch(driver).getText();
	  Glob.VerifyText(sMatchConfirmError, JoinTSPage.sEmailMustMatch);
	 
	  System.out.println("Confirm PW Length errors Verification");
	  JoinTSPage.txtPassword(driver).sendKeys("xU3", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchLengthError = JoinTSPage.lblPasswordLength(driver).getText();
	  Glob.VerifyText(sMatchLengthError, JoinTSPage.sPasswordLength);
	  JoinTSPage.txtPassword(driver).clear();

	  System.out.println("Confirm PW SPACE error Verification");
	  JoinTSPage.txtPassword(driver).sendKeys("B00ker 99!", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchPasswordSpace = JoinTSPage.lblPasswordSpace(driver).getText();
	  Glob.VerifyText(sMatchPasswordSpace, JoinTSPage.sPasswordSpace);
	  JoinTSPage.txtPassword(driver).clear();
  }
  
  @Test
  public void VerifyJoinErrorMessages () {
	  System.out.println("Running verify errors");
	  
	  JoinTSPage.Join(driver, Glob.gbMobile);
	  
	  JoinTSPage.txtEmail(driver).sendKeys("ASDF");
	  JoinTSPage.txtConfirmEmail(driver).click();
	  JoinTSPage.lblEmailInvalid(driver).click();
	  System.out.println("Basic Email Verification");
	  String sFoundEmailInvalid = JoinTSPage.lblEmailInvalid(driver).getText();
	  Glob.VerifyText(sFoundEmailInvalid, JoinTSPage.sEmailInvalid);
	  
	  System.out.println("Confirm email Verification");
	  JoinTSPage.txtConfirmEmail(driver).sendKeys("asdf@foo.com", Keys.TAB);
	  String sMatchConfirmError = JoinTSPage.lblEmailEmailMatch(driver).getText();
	  Glob.VerifyText(sMatchConfirmError, JoinTSPage.sEmailMustMatch);
	 
	  System.out.println("Confirm PW Length errors Verification");
	  JoinTSPage.txtPassword(driver).sendKeys("xU3", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchLengthError = JoinTSPage.lblPasswordLength(driver).getText();
	  Glob.VerifyText(sMatchLengthError, JoinTSPage.sPasswordLength);
	  JoinTSPage.txtPassword(driver).clear();

	  System.out.println("Confirm PW SPACE error Verification");
	  JoinTSPage.txtPassword(driver).sendKeys("B00ker 99!", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
	  String sMatchPasswordSpace = JoinTSPage.lblPasswordSpace(driver).getText();
	  Glob.VerifyText(sMatchPasswordSpace, JoinTSPage.sPasswordSpace);
	  JoinTSPage.txtPassword(driver).clear();
  }
  
  @Test(dataProvider = "getPWData")
  public void VerifyPWMessages (String sCharacter, String sPassword) {
	  System.out.println("******Running verify PW Messages errors");
	  
	  JoinTSPage.Join(driver, Glob.gbMobile);
	  
	  System.out.println("Confirm PW Character, " + sCharacter +", errors Verification");
	  JoinTSPage.txtPassword(driver).sendKeys(sPassword, Keys.TAB); //should raise one message for invalid character //XLOW3RSx* 
	  String sColor = JoinTSPage.lblPasswordCharacter(driver).getCssValue("color"); 
	  if ( sColor.equals("rgba(0, 128, 0, 1)")){
		  System.out.println("*****ERROR*** Character should have raised a RED error");
	  }
	  String sMatchCharacterError = JoinTSPage.lblPasswordCharacter(driver).getText();
	  Glob.VerifyText(sMatchCharacterError, JoinTSPage.sPasswordCharacter);
	  
	  JoinTSPage.txtPassword(driver).clear();
  }
 
  @Test(dataProvider = "getValidPWData")
  public void VerifyValidPW (String sCharacter, String sPassword) {
	  System.out.println("******Running verify PW Messages errors");
	  
	  JoinTSPage.Join(driver, Glob.gbMobile);
	  
	  System.out.println("Confirm PW Character, " + sCharacter +", is Valid");
	  JoinTSPage.txtPassword(driver).sendKeys(sPassword, Keys.TAB); //should raise one message for invalid character //XLOW3RSx* 
	  if (JoinTSPage.lblPasswordCharacter(driver).isDisplayed()) {
		  String sColor = JoinTSPage.lblPasswordCharacter(driver).getCssValue("color");
		  if (! sColor.equals("rgba(0, 128, 0, 1)")){
			  System.out.println("*****ERROR***Character should not have raised this error!");
		  }
//		  System.out.println("color is: " + sColor);
//		  String sMatchCharacterError = JoinTSPage.lblPasswordCharacter(driver).getText();
//		  Glob.VerifyText(sMatchCharacterError, "none");
		  
	  }
	  else {
	  JoinTSPage.txtPassword(driver).clear();
	  System.out.println("**PASS**--Character allowed in Password");
	  }
  }
  
  @DataProvider
  public Object[][] getPWData()
  {
	Object [][] data= new Object [7][2];
	//1
	data[0][0] = "Hash #";
	data[0][1] = "XLOW3RSx#";
	//2
	data[1][0] = "back slash /";
	data[1][1] = "XLOW3RSx/";
	//3
	data[2][0] = "ampersand &";
	data[2][1] = "XLOW3RSx&";
	//4
	data[3][0] = "less than <";
	data[3][1] = "XLOW3RSx<";
	//5
	data[4][0] = "greater than >";
	data[4][1] = "XLOW3RSx3>";
	//6
	data[5][0] = "All disallowed chars";
	data[5][1] = "XLOW3RSx3<>/&#";
	
	data[6][0] = "no lower case";
	data[6][1] = "XLOW3RSE";
	

		  
	  return data;
	  
  }
  
  @DataProvider
  public Object[][] getValidPWData()
  {
	Object [][] data= new Object [9][2];
	//1
	data[0][0] = "Carat ^";
	data[0][1] = "XLOW3RSx^";
	//2
	data[1][0] = "Exclamation point, !";
	data[1][1] = "XLOW3RSx!";
	//3
	data[2][0] = "At sign @";
	data[2][1] = "XLOW3RSx@";
	//4
	data[3][0] = "Dollar $";
	data[3][1] = "XLOW3RSx$";
	//5
	data[4][0] = "Percent %";
	data[4][1] = "XLOW3RSx3%";
	//6
	data[5][0] = "Open Paren (";
	data[5][1] = "XLOW3RSx3(";
	//7
	data[6][0] = "Close Paren )";
	data[6][1] = "XLOW3RSx3)";
	//8
	data[7][0] = "Dash/hyphen -";
	data[7][1] = "XLOW3RSx3-";	
	//9
	data[8][0] = "Under_Score _ ";
	data[8][1] = "XLOW3RSx3_";		  
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
