/*********************************************************************
 * TSForums.java
 *   
 *   
 *   basic testcases related to Forums, checking menus load correct page, etc.
 * 	some issue when run in QA env is a bit different.  works in prod
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
import org.openqa.selenium.Keys;
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
//import pageObjects.ForumsPage;
import pageObjects.ForumPostPage;
import pageObjects.ForumsPage;
import pageObjects.HomePage;
import pageObjects.logInPage;
import appModule.SendEmail;
//Some basic Forums tests.  invoking each tab checking on add comment

public class TSForums {
	WebDriver driver = null;
	
	String sTestClass = "TSForums";
	
@Test(dataProvider = "getForumsSearch")
  public void SearchForums(String sSearchTerm, String sCount) throws InterruptedException {
	  
	  //chrome
	  	System.out.println("Testing discourse");

		
		System.out.println("**Checking Forums**");
		HomePage.invokeForums(driver);
		if (ForumsPage.btnLogIn(driver).isDisplayed()) {
			
			ForumsPage.btnLogIn(driver).click();
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, false);
		}
		ForumsPage.searchForums(driver, sSearchTerm, sCount);
		ForumsPage.lnkReturnToTechsoup(driver).click();
		//LogOutAction.execute(driver, false);
		
		
		
		
		
		
  }

/*
 * launch forums, not logged in login
 * login to reply
 * 
 * login SSO from TS.org
 * login SSO post
 * 
 * search--specific result
 * search multi results like office "more than"
 * login search--
 * 
 * like post
 * 
 * 
 * */
//@Test
  public void NewPost () throws InterruptedException{
	if (Glob.gsEnv == "Prod") {
		driver.quit();
	}
	HomePage.invokeForums(driver);
	System.out.println("Running test for New Post");
	if (ForumsPage.btnLogIn(driver).isDisplayed()) {
		
		ForumsPage.btnLogIn(driver).click();
		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, false);
	}
		ForumsPage.btnNewTopic(driver).click();
		ForumsPage.txtTitle(driver).clear();
		ForumsPage.txtTitle(driver).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
//		ForumsPage.txtBody(driver).clear();
		ForumsPage.lstCategory(driver).click();
		ForumsPage.lstCategory(driver).sendKeys(Keys.SPACE);
		ForumsPage.lstCategory(driver).sendKeys(Keys.SPACE);
//		ForumsPage.lstElement(driver).click();
		ForumsPage.txtBody(driver).sendKeys("a aliqua. This is the topic body, there are many like it but this one is mine");
		ForumsPage.btnCreateTopic(driver).click();
	 //ForumsPage.NewForumPost(sPostSubject, sPostDetail, bMobile);
  }
  
  
  @DataProvider
  public Object[][] getForumsSearch(){
	  Object [][] data= new Object [2][2];



		data [0][0] = "Amazon AI" ;
		data [0][1] =  "12 results for";
								
		
	 
		data [1][0] = "Office";
		data [1][1] = "50+ results for";
		
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
