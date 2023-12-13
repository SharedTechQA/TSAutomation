/* TSwebinar.java
 * 
 * webinars test class
 *
 * checks webinar tiele, category, and webinar text extist on the main page
 * there was a bug for this.
 *  
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.sun.corba.se.spi.orbutil.fsm.Action;

import appModule.Glob;
import pageObjects.WebinarPage;
//import pageObjects.WebinarPage;
import pageObjects.searchPage;
import appModule.SearchAction;

public class TSWebinar {
	private static WebDriver driver = null;
	String sTestClass = "TSwebinar";
	
@Test(groups = "build")
	public void CheckWebinarPage() throws InterruptedException {

	driver.get(Glob.gsUrl + "/community/events-webinars");
	
	String sFoundPage = WebinarPage.lblPageTitle(driver).getText();
	
	WebinarPage.mnuCategory(driver).click();
	WebinarPage.miCategoryItem(driver).click();
	String sWebinarCategoryValue = WebinarPage.mnuCategory(driver).getText();
	System.out.println("found value to be: " + sWebinarCategoryValue);
//	Thread.sleep(500);
//	WebinarPage.btnClose(driver).click();
//	Thread.sleep(1000);
	driver.get(Glob.gsUrl + "/community/events-webinars");
	
	if (! WebinarPage.lblWebinarTitle(driver).isDisplayed()) {
		System.out.println("webinar Title Doesn't exist");
		Assert.assertFalse(true);
		
	}
	else {
		String sFoundTitle = WebinarPage.lblWebinarTitle(driver).getText();
		Glob.VerifyText(sFoundTitle, WebinarPage.sWebinarTitle);
	}
	
	if (! WebinarPage.lblWebinarText(driver).isDisplayed()) {
		System.out.println("*****************   webinar Text Doesn't exist");
		Assert.assertFalse(true);
	}
	
	else {
		String sFoundText = WebinarPage.lblWebinarText(driver).getText();
		Glob.VerifyText(sFoundText, WebinarPage.sWebinarText);
	}
	
	if (! WebinarPage.lblWebinarCategory(driver).isDisplayed()) {
		System.out.println("webinar Category Doesn't exist");
		Assert.assertFalse(true);
	}
	else {
		String sFoundCategory = WebinarPage.lblWebinarCategory(driver).getText();
		Glob.VerifyText(sFoundCategory, WebinarPage.sWebinarCategory);
	}
	Glob.VerifyText(sFoundPage, WebinarPage.sPageTitle);

	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1700);");
	Thread.sleep(500);
	
	WebinarPage.btnLoadMore(driver).click();	
	Thread.sleep(9000);
	driver.get(Glob.gsUrl);
	}

@Test
	public void CheckWebinarPageLinks() {
	
		
		
		SearchAction.Search(driver, "adobe");
		searchPage.tabResources(driver).click();
		searchPage.btnWebinars(driver).click();
		
//		searchPage.btnSubject(driver).click();
//		//searchPage.lstContents(driver).
//		driver.findElement(By.partialLinkText("Communications Web")).click();
//		
//		String sCurrentUrl = driver.getCurrentUrl();
//		System.out.println("current url is:  " + sCurrentUrl);
//		
//		assertEquals(sCurrentUrl, Glob.gsUrl + "/search/webinars/adobe/subject-Communications%0a%0aWeb%20and%20Graphic%20Design/");
//		
//		String Glob.lblBadURL(driver).getText();
	driver.get(Glob.gsUrl + "search/webinars/adobe/subject-Communications%0a%0aWeb%20and%20Graphic%20Design/");
		if (Glob.lblBadURL(driver).isDisplayed()) {
			String sEmpty = "";
			String sFound = Glob.lblBadURL(driver).getText();
			System.out.println("Error!!!!**** found" + Glob.lblBadURL(driver).getText());
			
			assertEquals(sFound, sEmpty);
		}
	
	
}

@Test
public void CheckWebinarSort() {
	driver.get(Glob.gsUrl + "search/webinars/adobe/sort-name-asc/");
//	http://www-stage.techsoup.org/search/blogs/adobe/sort-name-desc/
	
	String sTabValue = searchPage.tabResources(driver).getText();
	
if (sTabValue.contains("NAN")){
	System.out.println("ERROR:   *****rut roh...NAN on sort asc");
	
}

	
	driver.get(Glob.gsUrl + "search/webinars/adobe/sort-name-desc/");
	if (sTabValue.contains("NAN")){
		System.out.println("ERROR:   *****rut roh...NAN on sort desc");
		
	}
	
	driver.get(Glob.gsUrl + "search/webinars/adobe/sort-date/");
	if (sTabValue.contains("NAN")){
		System.out.println("ERROR:   *****rut roh...NAN on sort date");
		
	}
	
			
}

@BeforeClass
	public void beforeClass() throws IOException {
		Glob.setOutPutDirectory(sTestClass);

		System.out.println("****!!!!! Running Test Class:  "+ sTestClass +" !!!!!****");
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
		/*setTestNGOutPutDirectory(sTestClass);*/
			

		driver.quit();
	}


}



