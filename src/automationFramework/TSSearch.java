/*********************************************************************
 * TSSearch.java
 * TestCases for Search.  Covers the Bing spelling correction, etc., from
 * home page and community
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;
import org.openqa.selenium.*;


//import tsGlob;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

import java.awt.datatransfer.Clipboard;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import appModule.SearchAction;
import pageObjects.ProductPage;
import pageObjects.searchPage;
import appModule.Glob;
import appModule.LogOutAction;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TSSearch {
	WebDriver driver = null;
	boolean bLogin = false;
	String sTestClass = "TSSearch";

 @Test(groups="now")
 	public void SearchAndSort() throws InterruptedException {
			
	 System.out.println("*****Running Single Search test***************" );
	 	driver.get(Glob.gsUrl);
		SearchAction.Search(driver, "adbe", "147", "adobe", "adbe" );
			
		searchPage.lbxSort(driver).sendKeys("Title (Ascending)",Keys.TAB);
		Thread.sleep(3000);
		String sFound = driver.getCurrentUrl();
		assertEquals(sFound, searchPage.sSortAscending);	
		
		//driver.navigate().back();
		Thread.sleep(1000);
		searchPage.lbxSort(driver).sendKeys("Title (Descending)",Keys.TAB);
		Thread.sleep(3000);
		sFound = driver.getCurrentUrl();
		Thread.sleep(3000);	
		assertEquals(sFound, searchPage.sSortDescending);
		
		//driver.navigate().back();
		
		searchPage.lbxSort(driver).sendKeys("Relevance",Keys.TAB);
		Thread.sleep(3000);
		sFound = driver.getCurrentUrl();
		assertEquals(sFound, searchPage.sSortRelevance);
		
		
	  }
	 
 //@Test(groups="now")
  public void Search() {
	 System.out.println("*****Running Single Search test***************" );
		
 		
		SearchAction.Search(driver, "adbe", "147", "adobe", "adbe" );
		//driver.findElement(By.cssSelector("#navSearch > span.fa.fa-search.closeicon")).click();
		driver.findElement(By.cssSelector("#olProdResults > li:nth-child(1) > a > div")).click();
//		#navSearch > span.glyphicon
		//#navSearch > span.fa.fa-search.closeicon
		String sProduct = ProductPage.lblProductID(driver).getText();

		System.out.println("Clicking on first item returned, got productID " +sProduct +" and page "+ driver.getCurrentUrl() );
		
		driver.navigate().back();
		//driver.get("https://www.amazon.com/");
	
  }
// @Test(dataProvider = "getSearchSingle")ignore for now...could not get flag.
// @Test(dataProvider = "basicSearchData", groups="notnow")
 public void AmpSearchForums(String sTerm) {

	 System.out.println("*****Checking filter list looking for amp**********" );
	 
		SearchAction.Search(driver, sTerm);
		
		searchPage.tabResources(driver).click();
		searchPage.btnForums(driver).click();
		searchPage.btnTopic(driver).click();
		String sTopicContent = searchPage.lstFilter(driver).getText();
		
		//System.out.println(sTopicContent); 
		
		if (sTopicContent.contains("&amp;")) {
			System.out.println("***********  ERROR: Ampersand &amp; found in list ************");
		}
		
		
				
		driver.navigate().back();
	
 }
 
 
 
 public void CheckFlag(String sSearchTerm, String sCount, String sExpected) {
	  	
		SearchAction.Search(driver, sSearchTerm, sCount, sExpected);
	
 }
  
  @Test(dataProvider = "getSearchData", groups = "Build")//"getSearchData"
  public void SearchSpellSP(String sSearchTerm, String sFound, String sDiduMean, String sInstead) {
	  System.out.println("********Running TSSearch bing spelling from TS.ORG");  
	  
	  SearchAction.Search(driver, sSearchTerm, sFound, sDiduMean, sInstead);

	  
  }
  
  @Test(dataProvider = "BlogList", groups ="blog")
  public void SearchBlog(String sSearchTerm) {
	  //System.out.println("********Running TSSearch blog");  
	  
	  SearchAction.Search(driver, sSearchTerm);
	  
	  searchPage.tabResources(driver).click();
	  searchPage.btnBlogs(driver).click();
	  String sCount = searchPage.lblBlogCount(driver).getText();
	  if (sCount == "(0)") {
		  
		  System.out.println(driver.getCurrentUrl());
			  
	  }
	  System.out.println("got scount of " + sCount+"," + driver.getCurrentUrl());
//	  System.out.println(driver.getCurrentUrl());
	  System.out.println("Found Author:  " + searchPage.lblBlogAuthor(driver).getText());
	  System.out.println("Found Title:  " + searchPage.lblBlogTitle(driver).getText());
	  
		driver.get(Glob.gsUrl + "search/blogs/adobe/sort-name-asc/");
//		http://www-stage.techsoup.org/search/blogs/adobe/sort-name-desc/
		
		String sTabValue = searchPage.tabResources(driver).getText();
		
	if (sTabValue.contains("NAN")){
		System.out.println("ERROR:   *****rut roh...NAN on sort asc");
		
	}

		
		driver.get(Glob.gsUrl + "search/blogs/adobe/sort-name-desc/");
		if (sTabValue.contains("NAN")){
			System.out.println("ERROR:   *****rut roh...NAN on sort desc");
			
		}
		
		driver.get(Glob.gsUrl + "search/blogs/adobe/sort-date/");
		if (sTabValue.contains("NAN")){
			System.out.println("ERROR:   *****rut roh...NAN on sort date");
			
		}
	  
	  
  }
  
//  @Test(dataProvider = "getCommSearchData")  deprecated as part of Discourse upgrade  NO did u mean search, etc.
  
  public void SearchSpellCommunity(String sSearchTerm, String sFound, String sDiduMean, String sInstead) {

	    System.out.println("*****Running TSSearch bing spelling from Community");
	    
	    driver.get(Glob.gsEnvCommunity);
		 
		 SearchAction.Search(driver, sSearchTerm, sFound, sDiduMean, sInstead);
	  
	  }
  
  @Test
    public void SearchFilterValues () throws InterruptedException {
	  System.out.println("Search Filters ****************");
	  SearchAction.Search(driver, "adobe", "147", "", "" );
	  
	  searchPage.lnkBrowseFullCatalog(driver).click();
	  
	  String sFoundSearch = searchPage.txtSearchInput(driver).getText();
	  
	  assertEquals(sFoundSearch, "");
	  
	  searchPage.lnkFormat(driver).click();
	  searchPage.liDownload(driver).click();
	  
	  Thread.sleep(2000);
	  sFoundSearch = searchPage.txtSearchInput(driver).getText();
	  System.out.println("found: " + sFoundSearch);
	  searchPage.txtSearchInput(driver).click();
	  
	  assertEquals(sFoundSearch, "");
	  
	  
  }
//@Test (dataProvider = "getSearchRelated", groups = "foo")// temporarily reverted to show nothing
  public void SearchRelatedValues (String sSearchTerm, String sFound, String sDiduMean, String sInstead, String sExpectedRelated) throws InterruptedException {
	 
	  SearchAction.Search(driver, sSearchTerm, sFound, sDiduMean, sInstead );//mwr consider overload funcion
	  String sRelated = searchPage.listRelatedPages(driver).getText();
	  System.out.println(sRelated);
	  assertEquals(sRelated, sExpectedRelated);
	  
	  
 }
	
  @DataProvider
  public Object[][] getCommSearchData(){
	  Object [][] data= new Object [16][4];

		data [0][0] = "vritas" ;
		data [0][1] =  "2";
		data [0][2] =  "veritas";
		data [0][3] =  "vritas";
	 
		data [1][0] = "AmZon";
		data [1][1] = "6";
		data [1][2] = "amazon";
		data [1][3] = "AmZon";  

		data [2][0] = "maZon";
		data [2][1] = "6";
		data [2][2] = "amazon";
		data [2][3] = "maZon";
	
		data [3][0] = "adoble";
		data [3][1] = "6";
		data [3][2] = "adobe";
		data [3][3] = "adoble";
	
		data [4][0] = "daobe";
		data [4][1] = "6";
		data [4][2] = "adobe";
		data [4][3] = "daobe";
	
		data [5][0] = "acrobt";
		data [5][1] = "4";
		data [5][2] = "acrobat";
		data [5][3] = "acrobt";
	
		data [6][0] = "word3";
		data [6][1] = "147";
		data [6][2] = "word";
		data [6][3] = "word3";
	
		data [7][0] = "dhrma";
		data [7][1] = "1";
		data [7][2] = "dharma";
		data [7][3] = "dhrma";
		
		data [8][0] = "cr0me";
		data [8][1] = "6";
		data [8][2] = "chrome";
		data [8][3] = "cr0me";
	
		data [9][0] = "chrme";
		data [9][1] = "6";
		data [9][2] = "chrome";
		data [9][3] = "chrme";
	
		data [10][0] = "zo0m";
		data [10][1] = "11";
		data [10][2] = "zoom";
		data [10][3] = "zo0m";
	
		data [11][0] = "zmoo";
		data [11][1] = "0";
		data [11][2] = "zmodo";
		data [11][3] = "zmoo";
		
		data [12][0] = "wewok";
		data [12][1] = "0";
		data [12][2] = "wework";
		data [12][3] = "wewok";
	
		data [13][0] = "sq server";
		data [13][1] = "33";
		data [13][2] = "sql server";
		data [13][3] = "sq server";
	
		data [14][0] = "microsoft";
		data [14][1] = "184";
		data [14][2] = null;
		data [14][3] = null;
	
		data [15][0] = "Microsoft Office 2010: How to Use Sparklines in Excel 2010";
		data [15][1] = "2";
		data [15][2] = null;
		data [15][3] = null;
			  
		  return data;
	  }
  @DataProvider
  public Object[][] getSearchData()
  {
	Object [][] data= new Object [18][4];

	data [0][0] = "vritas" ;
	data [0][1] =  "2";
	data [0][2] =  "veritas";
	data [0][3] =  "vritas";
	 
	data [1][0] = "AmZon";
	data [1][1] = "6";
	data [1][2] = "amazon";
	data [1][3] = "AmZon";  

	data [2][0] = "maZon";
	data [2][1] = "6";
	data [2][2] = "amazon";
	data [2][3] = "maZon";
	
	data [3][0] = "adoble";
	data [3][1] = "6";
	data [3][2] = "adobe";
	data [3][3] = "adoble";

	data [4][0] = "daobe";
	data [4][1] = "6";
	data [4][2] = "adobe";
	data [4][3] = "daobe";
	
	data [5][0] = "acrobt";
	data [5][1] = "4";
	data [5][2] = "acrobat";
	data [5][3] = "acrobt";
	
	data [6][0] = "word3";
	data [6][1] = "147";
	data [6][2] = "word";
	data [6][3] = "word3";
	
	data [7][0] = "dhrma";
	data [7][1] = "1";
	data [7][2] = "dharma";
	data [7][3] = "dhrma";
	
	data [8][0] = "cr0me";
	data [8][1] = "6";
	data [8][2] = "chrome";
	data [8][3] = "cr0me";
	
	data [9][0] = "chrme";
	data [9][1] = "6";
	data [9][2] = "chrome";
	data [9][3] = "chrme";

	data [10][0] = "zo0m";
	data [10][1] = "11";
	data [10][2] = "zoom";
	data [10][3] = "zo0m";

	data [11][0] = "zmoo";
	data [11][1] = "0";
	data [11][2] = "zmodo";
	data [11][3] = "zmoo";

	data [12][0] = "wewok";
	data [12][1] = "0";
	data [12][2] = "wework";
	data [12][3] = "wewok";
	
	data [13][0] = "sq server";
	data [13][1] = "33";
	data [13][2] = "sql server";
	data [13][3] = "sq server";

	data [14][0] = "microsoft";
	data [14][1] = "184";
	data [14][2] = null;
	data [14][3] = null;
	
	data [15][0] = "Microsoft Office 2010: How to Use Sparklines in Excel 2010";
	data [15][1] = "2";
	data [15][2] = null;
	data [15][3] = null;

	data [16][0] = "Nortonlifelock";
	data [16][1] = "2";
	data [16][2] = null;
	data [16][3] = null;
	
	data [17][0] = "cloud fare";
	data [17][1] = "2";
	data [17][2] = null;
	data [17][3] = null;
	  
	  return data;
	  
  }
  
  @DataProvider
  public Object[][] basicSearchData()
  {
	Object [][] data= new Object [18][1];

	data [0][0] = "veritas" ;	 
	data [1][0] = "Amazon";
	data [2][0] = "autodesk";
	data [3][0] = "adobe";
	data [4][0] = "cisco";
	data [5][0] = "acrobat";
	data [6][0] = "word";
	data [7][0] = "dharma";
	data [8][0] = "chrome";
	data [9][0] = "Avast Business";
	data [10][0] = "zoom";
	data [11][0] = "intuit";
	data [12][0] = "docusign";
	data [13][0] = "sql server";
	data [14][0] = "microsoft";
	data [15][0] = "tableau";
	data [16][0] = "Google for Nonprofits";	
	data [17][0] = "cloudflare";
	  
		  
	  return data;
	  
  }
  @DataProvider
  public Object[][] getSearchSingle()
  {
	Object [][] data= new Object [1][3];

	data [0][0] = "G-49764" ;
	data [0][1] =  "1";
	data [0][2] =  "SEE SPECIAL OFFER";
	
	return data;
  }
  
  
  @DataProvider
  public Object[][] getSearchRelated()
  {
		Object [][] data= new Object [2][5];

		data [0][0] = "boost" ;
		data [0][1] =  "35";
		data [0][2] =  "";
		data [0][3] =  "";
		data [0][4] = "TechSoup Boost\n" + 
				"The TechSoup Boost Catalog\n" + 
				"boost-sign-up\n" + 
				"boost\n" + 
				"Test Boost page\n" + 
				"TechSoup Boost Discounted Products\n" + 
				"The TechSoup Boost Catalog Offer Details\n" + 
				"TechSoup Boost Training and Consultants"; 
		
		data [1][0] = "help desk" ;
		data [1][1] =  "45";
		data [1][2] =  "";
		data [1][3] =  "";
		data [1][4] = "Help Desk Services\n" + 
				"Help Desk Services\n" + 
				"TechSoup Help Desk - Managed IT Services\n" + 
				"TechSoup Help Desk Services for Nonprofits\n" + 
				"IT Assist\n" + 
				"Special Programs\n" + 
				"Nonprofit Eligibility Requirements and Donor Partner Restrictions\n" + 
				"About Our Donor Partners";
				
		return data;
		
  }
  @DataProvider
  public Object[][] BlogList(){
	  Object [][] data= new Object [1][1];  //x datasets of y
	  	data [0][0] = "adobe"; 
//	    data [1][0] = "how-to-burn-downloaded-software-to-a-dvd"; 
//	    data [2][0] = "adobe-photoshop-elements-15-vs-adobe-photoshop-cc"; 
//	    data [3][0] = "nonprofit-websites-5-ways-to-keep-them-fresh"; 
//	    data [4][0] = "what-chatbots-can-do-for-nonprofits-top-5-things"; 
//	    data [5][0] = "thinking-about-a-new-phone-system"; 
//	    data [6][0] = "6-must-haves-for-your-nonprofit-website"; 
//	    data [7][0] = "hidden-gems-for-nonprofits-in-the-techsoup-catalog"; 
//	    data [8][0] = "top-10-technology-donations-for-religious-charities"; 
//	    data [9][0] = "offline-social-media-exercise-that-improves-online-content"; 
//	    data [10][0] = "microsoft-office-2016-is-now-available"; 
//	    data [11][0] = "10-best-practices-for-email-security"; 
//	    data [12][0] = "9-steps-of-planning-a-successful-technology-project"; 
//	    data [13][0] = "techsoup-global-network-a-unique-force-for-social-change"; 
//	    data [14][0] = "can-i-use-that-image-for-my-website-or-newsletter"; 
//	    data [15][0] = "adobe-premiere-elements-13-vs-adobe-premiere-pro-cc"; 
//	    data [16][0] = "intro-to-adobe-photoshop-for-nonprofits-part-1"; 
//	    data [17][0] = "3-steps-to-building-your-communications-strategy-in-the-digital-era"; 
//	    data [18][0] = "grant-writing-and-the-perfect-storytelling"; 
//	    data [19][0] = "artificial-intelligence-in-nonprofit-tech"; 
//	    data [20][0] = "how-to-get-adobe-acrobat-pro-dc-through-techsoup"; 
//	    data [21][0] = "9-tips-to-maximize-your-fundraising-with-social-media"; 
//	    data [22][0] = "top-10-sources-for-free-images"; 
//	    data [23][0] = "storymakers-2016-winners"; 
//	    data [24][0] = "6-tips-to-improve-your-next-fundraising-campaign-using-digital-storytelling"; 
//	    data [25][0] = "5-Uses-You-Didn't-Think-Of-for-Adobe-Acrobat-Pro-DC"; 
//	    data [26][0] = "adobe-photoshop-elements-14-vs-adobe-photoshop-cc"; 
//	    data [27][0] = "10-ways-to-improve-your-donation-page-and-raise-more-money"; 
//	    data [28][0] = "what-you-need-to-know-about-windows-10"; 
//	    data [29][0] = "whats-new-in-adobe-acrobat-pro-2017"; 
//	    data [30][0] = "church-and-religious-organization-frequently-asked-questions"; 
//	    data [31][0] = "3-cool-things-to-try-in-excel-2016"; 
//	    data [32][0] = "how-nonprofits-can-improve-their-email-deliverability"; 
//	    data [33][0] = "cases-of-successful-nonprofits-that-use-chatbots"; 
//	    data [34][0] = "5-ways-nonprofits-can-use-text-messages"; 
//	    data [35][0] = "record-highs-for-gifts-to-nonprofits"; 
//	    data [36][0] = "3-onenote-2016-tips-to-keep-you-organized"; 
//	    data [37][0] = "Blackbaud's-Raiser's-Edge-NXT-Launches"; 
//	    data [38][0] = "biggest-technology-program-youve-never-heard-of"; 
//	    data [39][0] = "you-can-tech-plan-new-online-training-shows-you-how"; 
//	    data [40][0] = "what-you-can-do-about-ransomware"; 
//	    data [41][0] = "building-a-monthly-giving-program-with-your-supporters"; 
//	    data [42][0] = "6-device-security-tips-to-keep-your-data-safe"; 
//	    data [43][0] = "10-tips-to-improve-your-giving-tuesday-and-year-end-donation-pages"; 
//	    data [44][0] = "techsoup-tools-for-desktop-publishing-and-presentations"; 
//	    data [45][0] = "how-to-protect-yourself-from-the-new-isp-law"; 
//	    data [46][0] = "new-infographic-shoot-video-like-a-pro"; 
//	    data [47][0] = "4-things-non-designers-should-know-about-graphic-design"; 
//	    data [48][0] = "techsoup-boost-for-nonprofits-an-easy-way-to-boost-your-techsoup-love"; 
//	    data [49][0] = "7-easy-ideas-to-give-your-next-presentation-oomph"; 
//	    data [50][0] = "why-are-charity-mobile-phone-donation-programs-going-extinct"; 
//	    data [51][0] = "how-to-up-your-digital-marketing-and-fundraising-game-in-2017"; 


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
  		  	//System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );;
  		
  		  	driver = Glob.setBrowser(sBrowser);
  		  	
  			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  			
//  			Glob.setOutPutDirectory(sTestClass);
  			
  			if (bMobile) {
  				driver.get(Glob.gsUrl);
  				driver.manage().window().setSize(new Dimension(375,812));//iPhoneX size
  			}
  			else{
  				driver.manage().window().maximize();
  				driver.get(Glob.gsUrl);
//  				driver.get("https://www.google.com/");
  			}
  			 	


  	  }

  @AfterTest(alwaysRun = true)
  	public void afterTest() throws InterruptedException {
  		System.out.println("after Test");
  		
  	
  		driver.quit();
  	}

}

