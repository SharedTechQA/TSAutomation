/*********************************************************************
 * TSEligibilityQuiz.java
 * Tests for eligibility quiz, etc.
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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.EligibilityPage;
import pageObjects.HelpPage;

public class TSEligibilityQuiz {
	 WebDriver driver = null;
	 
	 String sTestClass = "TSEligibilityQuiz";
	 
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
  @Test(dataProvider = "QuizData")
  public void TSEligQuiz ( String sOrg, String sState, String sOrgType, String sOrgSubType, String sBudget, boolean bLogin, String sOrgToValidate) throws IOException, InterruptedException {
	  System.out.println("******* elig Quiz basic test");
		//String sExpectedTitle = "Join TechSoup";
	  	
	  	//driver.get(Glob.gsUrl);
	  	EligibilityPage.CheckEligibility(driver, sOrg, sState, sOrgType, sOrgSubType, sBudget, bLogin, sOrgToValidate);
	  
  }
@Test 
  public void TSEligQuizVerifyRequired () throws IOException, InterruptedException {
	  System.out.println("****** elig Quiz Verify Required field Text");
		//String sExpectedTitle = "Join TechSoup";
	  	
	  	driver.get(Glob.gsUrl);
	  	
	  	driver.get((Glob.gsUrl + "EligibilityQuiz"));

	  /*	HelpPage.invokeHelp(driver);
	  	HelpPage.lnkCheckEligibility(driver).click();
	  	EligibilityPage.btnCheckEligibility(driver).click();
		Thread.sleep(2000);
	  	EligibilityPage.btnCheckEligibility(driver).click();
	  	Thread.sleep(2000);
	 */ 	//driver.w
	  	
	  	String sStatus = EligibilityPage.lblRequiredStatus(driver).getText();
	  	Glob.VerifyText(sStatus, EligibilityPage.sRequiredStatus);
	  	
	  	String sState = EligibilityPage.lblRequiredState(driver).getText ();
	  	Glob.VerifyText(sState, EligibilityPage.sRequiredState);
	  	
	  	String sType = EligibilityPage.lblRequiredType(driver).getText ();
	  	Glob.VerifyText(sType, EligibilityPage.sRequiredOrgType);

	  	String sSubType = EligibilityPage.lblRequiredSubType(driver).getText ();
	  	Glob.VerifyText(sSubType, EligibilityPage.sRequiredOrgSubType);
	  	
	  	String sBudget = EligibilityPage.lblBudget(driver).getText ();
	  	Glob.VerifyText(sBudget, EligibilityPage.sBudget);
	  	


	 

	  
  }

//	EligibilityPage.CheckEligibility("501C", "Washington", "Mutual", "Credit Union", "5588", false, "null");
//  	EligibilityPage.CheckEligibility("501CLibrary", "Nevada", "", "", "5588", true, "WWW.RVWA");
//  	EligibilityPage.CheckEligibility("non501CLibrary", "Delaware", "", "", "5588", true, "boost");
//  	EligibilityPage.CheckEligibility("501C", "California", "Mutual", "Credit Union", "999999", false, "null");
@DataProvider
public Object[][] QuizData(){
	  Object [][] data= new Object [4][7];  //4 datasets of 7
	    data [0][0] = "501C"; 
	    data [0][1] = "Washington";
	    data [0][2] = "Mutual";
	    data [0][3] = "CreditUnion";
	    data [0][4] = "5588";
	    data [0][5] = false;
	    data [0][6] = "some org";

	    data [1][0] = "null";
	    data [1][1] = "null";
	    data [1][2] = "null";
	    data [1][3] = "null";
	    data [1][4] = "null"; 
	    data [1][5] = true;
	    data [1][6] = "located in seattle";
	    
	    data [2][0] = "null"; 
	    data [2][1] = "null";
	    data [2][2] = "null";
	    data [2][3] = "null";
	    data [2][4] = "null";
	    data [2][5] = true;
	    data [2][6] = "remove";
	    
	    data [3][0] = "501C"; 
	    data [3][1] = "Washington";
	    data [3][2] = "Mutual";
	    data [3][3] = "CreditUnion";
	    data [3][4] = "120000"; 
	    data [3][5] = false;
	    data [3][6] = "null";


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
	public void afterTest() throws InterruptedException {
		System.out.println("after Test");
		
	
		driver.quit();
	}


}
