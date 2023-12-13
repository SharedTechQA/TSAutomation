/* TSArticle.java
 * 
 * Articles test class
 *
 * checks article tiele, category, and article text extist on the main page
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
import pageObjects.ArticlePage;
import pageObjects.searchPage;
import appModule.SearchAction;

public class TSArticle {
	private static WebDriver driver = null;
	String sTestClass = "TSArticle";
	
@Test(groups = "build")
	public void CheckArticlePage() throws InterruptedException {

	driver.get(Glob.gsUrl + "support/articles-and-how-tos");
	ArticlePage.mnuArticleCategory(driver).click();
	ArticlePage.miCategoryItem(driver).click();
	
	
	String sFoundPage = ArticlePage.lblPageTitle(driver).getText();
//	String sFoundTitle = ArticlePage.lblArticle1Title(driver).getText();
//	String sFoundCategory = ArticlePage.lblArticle1Category(driver).getText();
	//String sFoundText = ArticlePage.lblArticle1Text(driver).getText();
	
	
		
	if (! ArticlePage.lblArticle1Title(driver).isDisplayed()) {
		System.out.println("Article Title Doesn't exist");
		Assert.assertFalse(true);
		
	}
	else {
		String sFoundTitle = ArticlePage.lblArticle1Title(driver).getText();
		Glob.VerifyText(sFoundTitle, ArticlePage.sArticle1Title);
	}
	
	if (! ArticlePage.lblArticle1Text(driver).isDisplayed()) {
		System.out.println("*****************   Article Text Doesn't exist");
		Assert.assertFalse(true);
	}
	
	else {
		String sFoundText = ArticlePage.lblArticle1Text(driver).getText();
		Glob.VerifyText(sFoundText, ArticlePage.sArticle1Text);
	}
	
	if (! ArticlePage.lblArticle1Category(driver).isDisplayed()) {
		System.out.println("Article Category Doesn't exist");
		Assert.assertFalse(true);
	}
	else {
		String sFoundCategory = ArticlePage.lblArticle1Category(driver).getText();
		Glob.VerifyText(sFoundCategory, ArticlePage.sArticle1Category);
	}
	Glob.VerifyText(sFoundPage, ArticlePage.sPageTitle);

	
//	System.out.println("move to load more");
//	Actions action = new Actions(driver);
//	WebElement we = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2__articleListControl_WebinarLoadMore"));
//	action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2__articleListControl_WebinarLoadMore"))).click().build().perform();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1700);");
	Thread.sleep(500);
	ArticlePage.btnLoadMore(driver).click();	
	Thread.sleep(1000);
	driver.get(Glob.gsUrl);
	}

//@Test
	public void CheckArticlePageLinks() {
	
		
		
		SearchAction.Search(driver, "adobe");
		searchPage.tabResources(driver).click();
//		searchPage.btnArticles(driver).click();
		searchPage.btnAuthor(driver).click();
		//searchPage.lstContents(driver).
		driver.findElement(By.partialLinkText("Kyle Henri Andrei Laura S. Quinn")).click();
		
		String sCurrentUrl = driver.getCurrentUrl();
		System.out.println("current url is:  " + sCurrentUrl);
		
		assertEquals(sCurrentUrl, Glob.gsUrl + "search/articles/adobe/author-Kyle%20Henri%20Andrei%0a%0aLaura%20S.%20Quinn/");
//		String Glob.lblBadURL(driver).getText();
		if (Glob.lblBadURL(driver).isDisplayed()) {
			String sEmpty = "";
			String sFound = Glob.lblBadURL(driver).getText();
			System.out.println("Error!!!!**** found" + Glob.lblBadURL(driver).getText());
			
			assertEquals(sFound, sEmpty);
		}
	
}
@Test
public void CheckArticleSort() {
	driver.get(Glob.gsUrl + "search/articles/adobe/sort-name-asc/");
//	http://www-stage.techsoup.org/search/blogs/adobe/sort-name-desc/
	
	String sTabValue = searchPage.tabResources(driver).getText();
	
if (sTabValue.contains("NAN")){
	System.out.println("ERROR:   *****rut roh...NAN on sort asc");
	
}

	
	driver.get(Glob.gsUrl + "search/articles/adobe/sort-name-desc/");
	if (sTabValue.contains("NAN")){
		System.out.println("ERROR:   *****rut roh...NAN on sort desc");
		
	}
	
	driver.get(Glob.gsUrl + "search/articles/adobe/sort-date/");
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



