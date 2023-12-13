package automationFramework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import appModule.SendEmail;
import pageObjects.ForumsPage;
import pageObjects.HomePage;

public class TSCheckForumsLive {
    
	WebDriver driver = null;
	String sTestClass = "VerifyForumsAlive";
    
@Test()	
    public void firstEmail() throws IOException, MessagingException {


    	
    	SendEmail email = new SendEmail();
        
        // Take screenshot on step failure

        try {

//    
        	
        	System.out.println("**Checking Forums**");
    		HomePage.invokeForums(driver);
    		ForumsPage.btnLogIn(driver).click();
    		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, false);
    		System.out.println("logged in to: "+ driver.getCurrentUrl());
    		//driver.get("www.forums.techsoup.org");
    		//LogOutAction.execute(driver, false);
        } catch (Throwable e) {
                
            //Write code to take screenshot and save it
            File file_error = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(file_error, new File("/testautoimages/scr_error.png"));
            
            //call the email reference
            email.postMail(SendEmail.emailList, SendEmail.emailSubjectTxt, SendEmail.emailMsgTxt, SendEmail.emailFromAddress);
            
        }
       
    }
    
@BeforeClass
	public void beforeClass() throws IOException {
		
	  Glob.setOutPutDirectory(sTestClass);
	  System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
		
}
// @AfterClass
	public void afterClass() throws IOException {
		Glob.setTestNGOutPutDirectory(sTestClass);

}
 @Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
 @BeforeTest(alwaysRun = true)
 	public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException {
 		  	Glob.setEnv(sEnv);
 		  	Glob.gbMobile = bMobile;
 		  	//System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );;
 		
 		  	driver = Glob.setBrowser(sBrowser);
 		  	
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			
// 			Glob.setOutPutDirectory(sTestClass);
 			
 			if (bMobile) {
 				driver.get(Glob.gsUrl);
 				driver.manage().window().setSize(new Dimension(375,812));//iPhoneX size
 			}
 			else{
 				driver.manage().window().maximize();
 				driver.get(Glob.gsUrl);
// 				driver.get("https://www.google.com/");
 			}
 			 	


 	  }

 @AfterTest(alwaysRun = true)
 	public void afterTest() throws InterruptedException {
 		System.out.println("after Test");
 		
 	
 		driver.quit();
 	}

}
