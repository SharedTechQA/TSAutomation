/*********************************************************************
 * TSCommunity.java
 *   
 *   
 *   basic testcases related to community, checking menus load correct page, etc.
 *   
 *   !!!!!!deprecaated for discourse!!!!!
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.CommunityPage;
import pageObjects.ForumPostPage;
import pageObjects.HomePage;
import pageObjects.logInPage;
//Some basic community tests.  invoking each tab checking on add comment

public class TSCommunity {
	private static WebDriver driver = null;
	
	String sTestClass = "TSCommunity";
	
@Test
  public void Community_PageChecks() throws InterruptedException {
	  
	  //chrome
	  	System.out.println("Testing Community tabs");

		
		System.out.println("**Checking Community menu**");
		//HomePage.invokeEvents(driver);
		//HomePage.invokeForums(driver);
		HomePage.invokeCommunityPage(driver);

		
		System.out.println("**Checking page Headers or Tab text **");
					
		CommunityPage.invokeFeaturedTopics(driver);
		CommunityPage.invokeForums(driver);
		CommunityPage.invokeBlogArchive(driver);
		CommunityPage.invokeRecentActivity(driver);
						
		
  }
@Test
  public void NewPost () throws InterruptedException{
	System.out.println("Running test for New Post");
	LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	//HomePage.invokeCommunityPage(driver);
	if (Glob.gbMobile) {
	 ForumPostPage.NewForumPost(driver, "Mobile subject", "Some Longer text than subject", true);
	}
	else {
		ForumPostPage.NewForumPost(driver, "one", "Description for full size browser screen", false);
	}	
	 //CommunityPage.NewForumPost(sPostSubject, sPostDetail, bMobile);
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
