package automationFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LoginAction;
import pageObjects.ProductPage;

public class TSVerifyPages {
	 static WebDriver driver = null;
	 
	 public static String sTestClass = "TSVerifyPages";
	 

//@Test  moved to separate script
public static void aiteratePages () throws InterruptedException {
	String sTestGroup = "/DonorList/";
	LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	for (int i = 0; i < 1000; i++) {
		System.out.println(i);
		System.out.println("***** running aIterate*******");
		driver.get(Glob.gsUrl +	    "Adobe"); 
		driver.get(Glob.gsUrl +	    "ADP"); 
		driver.get(Glob.gsUrl +	    ""); 
		driver.get(Glob.gsUrl +	    "support/articles-and-how-tos"); 
		driver.get(Glob.gsUrl +	    "computers-and-electronics");
		
		/*
		driver.get(Glob.gsUrl +	    "airbnb-social-impact-experiences"); 
		driver.get(Glob.gsUrl +	    "alpha-software"); 
		driver.get(Glob.gsUrl +	    "amazon-web-services"); 
		driver.get(Glob.gsUrl +	    "arreva"); 
		driver.get(Glob.gsUrl +	    "asana"); 
		driver.get(Glob.gsUrl +	    "atlas-business-solutions"); 
		driver.get(Glob.gsUrl +	    "autodesk"); 
		driver.get(Glob.gsUrl +	    "avepoint"); 
		driver.get(Glob.gsUrl +	    "azavea"); 
		driver.get(Glob.gsUrl +	    "bitdefender"); 
		driver.get(Glob.gsUrl +	  "blackbaud"); 
		driver.get(Glob.gsUrl +	    "bloomerang"); 
		driver.get(Glob.gsUrl +	     "boost"); 
		driver.get(Glob.gsUrl +	     "box"); 
		driver.get(Glob.gsUrl +	  "bytes-of-learning"); 
		driver.get(Glob.gsUrl +	   "caravan-studios"); 
		driver.get(Glob.gsUrl +	     "cisco"); 
		driver.get(Glob.gsUrl +	     "cisco-meraki"); 
		driver.get(Glob.gsUrl +	    "citysoft"); 
		driver.get(Glob.gsUrl +	    "clicktime"); 
		driver.get(Glob.gsUrl +	    "comodo"); 
		driver.get(Glob.gsUrl +	   "connect2give"); 
		driver.get(Glob.gsUrl +	    "dell"); 
		driver.get(Glob.gsUrl +	     "dharma-merchant-services"); 
		driver.get(Glob.gsUrl +	    "docusign"); 
		driver.get(Glob.gsUrl +	     "donorperfect"); 
		driver.get(Glob.gsUrl +	     "efficient-elements"); 
		driver.get(Glob.gsUrl +	     "filemaker"); 
		driver.get(Glob.gsUrl +	     "flixbus"); 
		driver.get(Glob.gsUrl +	     "goodwings"); 
		driver.get(Glob.gsUrl +	     "google-for-nonprofits"); 
		driver.get(Glob.gsUrl +	     "grantstation"); 
		driver.get(Glob.gsUrl +	     "headsets"); 
		driver.get(Glob.gsUrl +	     "horizon-datasys"); 
		driver.get(Glob.gsUrl +	     "hp-inc"); 
		driver.get(Glob.gsUrl +	     "hr-solutions-partners"); 
		driver.get(Glob.gsUrl +	   "infocus"); 
		driver.get(Glob.gsUrl +	     "intuit"); 
		driver.get(Glob.gsUrl +	     "journeyed"); 
		driver.get(Glob.gsUrl +	     "kintone"); 
		driver.get(Glob.gsUrl +	    "lenovo"); 
		driver.get(Glob.gsUrl +	     "linksys"); 
		driver.get(Glob.gsUrl +	     "little-green-light"); 
		driver.get(Glob.gsUrl +	     "mailshell"); 
		driver.get(Glob.gsUrl +	     "microsoft-discount"); 
		driver.get(Glob.gsUrl +	     "microsoft-catalog"); 
		driver.get(Glob.gsUrl +	     "mileiq"); 
		driver.get(Glob.gsUrl +	     "mimo-monitors"); 
		driver.get(Glob.gsUrl +	     "mobile-beacon"); 
		driver.get(Glob.gsUrl +	     "nortonlifelock"); 
		driver.get(Glob.gsUrl +	     "notejoy"); 
		driver.get(Glob.gsUrl +	    "how-okta-helps-nonprofits"); 
		driver.get(Glob.gsUrl +	     "payanywhere"); //was oracle netsuite....fixing for now
		driver.get(Glob.gsUrl +	     "otter-ai"); 
		driver.get(Glob.gsUrl +	     "paya"); 
		driver.get(Glob.gsUrl +	     "payanywhere"); 
		driver.get(Glob.gsUrl +	     "people-onthego"); 
		driver.get(Glob.gsUrl +	     "pluralsight"); 
		driver.get(Glob.gsUrl +	     "priority"); 
		driver.get(Glob.gsUrl +	     "questionpro"); 
		driver.get(Glob.gsUrl +	     "quickbooks-made-easy"); 
		driver.get(Glob.gsUrl +	     "rain-design"); 
		driver.get(Glob.gsUrl +	     "reading-eggs"); 
		driver.get(Glob.gsUrl +	     "refurbished-computers-catalog"); 
		driver.get(Glob.gsUrl +	   "sap-litmos"); 
		driver.get(Glob.gsUrl +	    "shutterstock"); 
		driver.get(Glob.gsUrl +	     "skillsoft"); 
		driver.get(Glob.gsUrl +	     "snpo"); 
		driver.get(Glob.gsUrl +	    "sparrow"); 
		driver.get(Glob.gsUrl +	     "slack"); 
		driver.get(Glob.gsUrl +	     "tableau"); 
		driver.get(Glob.gsUrl +	     "tech-impact"); 
		driver.get(Glob.gsUrl +	     "techbridge"); 
		driver.get(Glob.gsUrl +	     "techsoup-services"); 
		driver.get(Glob.gsUrl +	     "ultralingua"); 
		driver.get(Glob.gsUrl +	     "usb-memory-direct"); 
		driver.get(Glob.gsUrl +	     "veritas"); 
		driver.get(Glob.gsUrl +	     "vmware"); 
		driver.get(Glob.gsUrl +	    "western-digital"); 
		driver.get(Glob.gsUrl +	     "wework"); 
		driver.get(Glob.gsUrl +	     "workplace-by-facebook"); 
		driver.get(Glob.gsUrl +	     "zoner"); 
		driver.get(Glob.gsUrl +	     "zoom");
		driver.get(Glob.gsUrl +	     "wix");
		driver.get(Glob.gsUrl +	     "pagerduty");
		driver.get(Glob.gsUrl +	     "sparkol");
		driver.get(Glob.gsUrl +	    "teamviewer");*/

	}
}
@Test(dataProvider = "DonorList")	 
public static void checkDonorPages(String sPageToLoad) throws IOException {
		//check all pages load.  WSo2 issues verify.
	String sTestGroup = "/Donor/";
	
		driver.get(Glob.gsUrl +sPageToLoad);
		String sCurrentUrl = driver.getCurrentUrl();
		if (sCurrentUrl.contains("error500.html")||sCurrentUrl.contains("404") ){
			Glob.GetScreenShot(driver, sTestClass, Glob.gsEnv+sPageToLoad);//gsenv
			System.out.println("***** ERROR  ***** got " + sCurrentUrl);
			assertEquals(true, false);
		}
		else {
			System.out.println("***** Loading Donor page: " + sPageToLoad);

			//			FileUtils.copyFile(src, new File("c://testautoimages/"+GetDate()+sTestClass+"_" + sFileName + ".png"));
			Glob.GetScreenShot(driver, sTestGroup+sTestClass, Glob.gsEnv+sPageToLoad);
			
		}
		 
	 }
	
//@Test(dataProvider = "CategoryList")	 
public static void checkCategoryPages(String sPageToLoad) throws IOException {
	//check all pages load.  WSo2 issues verify.
	String sTestGroup = "/Category/";
	driver.get(Glob.gsUrl +sPageToLoad);
	String sCurrentUrl = driver.getCurrentUrl();  //https://www-qa.techsoup.org/error500?aspxerrorpath=/Pages/databases-and-analytics.aspx
	if (sCurrentUrl.contains("error500?aspxerrorpath")||sCurrentUrl.contains("404")){
		Glob.GetScreenShot(driver, sTestClass, Glob.gsEnv+sPageToLoad);
		assertEquals(true, false);
	}
	else {
		System.out.println("***** Loading Category page: " + sPageToLoad);
		Glob.GetScreenShot(driver, sTestGroup+sTestClass, Glob.gsEnv+sPageToLoad);
		}
	}
	
@Test(dataProvider = "BoostList")	 
public static void checkBoostPages(String sPageToLoad, String sFormatValue) throws IOException {
	//check all pages load.  WSo2 issues verify.
	String sTestGroup = "/BoostPages/";
	driver.get(Glob.gsUrl +sPageToLoad);
	String sCurrentUrl = driver.getCurrentUrl();
	if (sCurrentUrl.contains("error500.html")||sCurrentUrl.contains("404")){
		Glob.GetScreenShot(driver, sTestClass, Glob.gsUrl+sPageToLoad);
		assertEquals(true, false);
	}
	else {
		System.out.println("***** Loading Boost page: " + sPageToLoad);
		Glob.GetScreenShot(driver, sTestGroup+sTestClass, Glob.gsEnv+sPageToLoad);
		String sFoundFormatValue = ProductPage.lblFormat(driver).getText();
		System.out.println(ProductPage.lblBoostTxt(driver).getText());
		System.out.println(ProductPage.lnkGetItWithBoost(driver).getText());
		
		Glob.VerifyText(sFoundFormatValue, sFormatValue);
		if (! sFoundFormatValue.equals(sFormatValue)){
			Glob.GetScreenShot(driver, sTestClass, Glob.gsEnv+sPageToLoad);
			//assertEquals(true, false);
			}
	}
}
//@Test (dataProvider = "Disc")
public static void checkDiscontinuedEPDP (String sPageToLoad) throws IOException {
	driver.get(Glob.gsUrl +sPageToLoad);
	String sCurrentUrl = driver.getCurrentUrl();
	
//	Glob.Scroll();
	
	String sSeeAll = ProductPage.btnSeeAll(driver).getText();
	
	if (sSeeAll.contains("SEE ALL")){
		System.out.println("Is see all there?  " + sSeeAll);
	}
	else
		System.out.println("There is no See All, but check page for ");
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1500);");
	
		ProductPage.btnFirstCard(driver).click();
		System.out.println("Found:  " + driver.getCurrentUrl());
}
// @Test
  public static void checkPageCononical() {
//		  System.out.println("find check");

//			Random rand = new Random ();
//			System.out.println("random??: " + rand.nextInt(999));
//			
//		   System.out.println("glob get int = " + Glob.getInt());
//		   
		   driver.get(Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-�-the-essentials-(discounted)-g-51486-");
		  //String sCanonical = driver.findElement(By.partialLinkText("test-matt-content-g-51486")).getText();
		  
		   System.out.println("is bTwitterTitle there?");
//		  boolean bTwitterTitle = driver.getPageSource().contains("<meta name=\"twitter:title\" content=\"QuickBooks Made Easy for Nonprofits � The Essentials (Discounted)\" />");
		  
		  boolean bTwitterTitle = driver.getPageSource().contains("<meta name=\"twitter:title\" content=\"QuickBooks Made Easy for Nonprofits � The Essentials (Discounted)\"");
		  
		  
		  assertTrue(bTwitterTitle);
			 
		  System.out.println("bTwitterTitle is there");
		  
		  	
		  boolean bOGTitle = driver.getPageSource().contains("<meta property=\"og:title\" content=\"QuickBooks Made Easy for Nonprofits � The Essentials (Discounted)\"");

		  System.out.println("is bOGTitle there?");
		  	assertTrue(bOGTitle);
		  System.out.println("bOGTitle is there");
		  
		  boolean bCanonical = driver.getPageSource().contains(Glob.gsCanonical);

		  System.out.println("is bCanonical there?");
		  		  assertTrue(bCanonical);
		  System.out.println("bCanonical is there");
		  
		  	  
		  
		//<link rel="canonical" href="https://www-qa.techsoup.org/products/test-matt-content-hello-g-51486" />
			
		  
		   
	  }
	 

// @Test(dataProvider = "BlogList")	 
 public static void checkBlogPages(String sPageToLoad) throws IOException {
	//check all pages load.  WSo2 issues verify.
String sTestGroup = "/BlogList/";
	driver.get(Glob.gsEnvForums +sPageToLoad);
	String sCurrentUrl = driver.getCurrentUrl();
	if (sCurrentUrl.contains("error500.html")||sCurrentUrl.contains("404") ){
		Glob.GetScreenShot(driver, sTestClass, Glob.gsEnv+sPageToLoad);//gsenv
		System.out.println("***** ERROR  ***** got " + sCurrentUrl);
		assertEquals(true, false);
	}
	else {
		System.out.println("***** Loading Blog/forum page: " + sPageToLoad);
		System.out.println("Got: "+ driver.getCurrentUrl());
//		FileUtils.copyFile(src, new File("c://testautoimages/"+GetDate()+sTestClass+"_" + sFileName + ".png"));
//		Glob.GetScreenShot(driver, sTestGroup+sTestClass, Glob.gsEnv+sPageToLoad);

	}
 }
	
// @Test(dataProvider = "UrlList")	 
 public static void checkURLRedriect(String sPageToLoad, String sRedirect) throws IOException {
		//check all pages load.  WSo2 issues verify.
String sTestGroup = "/UrlList/";
	System.out.println("loading: " + Glob.gsEnv+sPageToLoad);
	driver.get(Glob.gsUrl +sPageToLoad);
	String sCurrentUrl = driver.getCurrentUrl();
	if (sCurrentUrl.contains("error500.html")||sCurrentUrl.contains("404") ){
		Glob.GetScreenShot(driver, sTestClass, Glob.gsUrl+sPageToLoad);//gsenv
		System.out.println("***** ERROR  ***** got " + sCurrentUrl);
		assertEquals(true, false);
	}
	else {
		System.out.println("***** loading page:  " + sPageToLoad);
		System.out.println("Got: "+ driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(),Glob.gsUrl+sRedirect);
//			FileUtils.copyFile(src, new File("c://testautoimages/"+GetDate()+sTestClass+"_" + sFileName + ".png"));
//			Glob.GetScreenShot(driver, sTestGroup+sTestClass, Glob.gsEnv+sPageToLoad);

		}
		
			
	 
 }
@DataProvider
public Object [][] Disc(){
	Object [][] data = new Object [2][1];
		data [0][0] = "techsoup-boost-catalog";
		data [1][0] = "techsoup-services";
		return data;
}
		
@DataProvider
public Object[][] DonorList(){
	  Object [][] data= new Object [89][1];  //x datasets of y
	    data [0][0] = "Adobe"; 
	    data [1][0] = "ADP"; 
	    data [2][0] = "airbnb-social-impact-experiences"; 
	    data [3][0] = "alpha-software"; 
	    data [4][0] = "amazon-web-services"; 
	    data [5][0] = "arreva"; 
	    data [6][0] = "asana"; 
	    data [7][0] = "atlas-business-solutions"; 
	    data [8][0] = "autodesk"; 
	    data [9][0] = "avepoint"; 
	    data [10][0] = "azavea"; 
	    data [11][0] = "bitdefender"; 
	    data [12][0] = "blackbaud"; 
	    data [13][0] = "bloomerang"; 
	    data [14][0] = "boost"; 
	    data [15][0] = "box"; 
	    data [16][0] = "bytes-of-learning"; 
	    data [17][0] = "caravan-studios"; 
	    data [18][0] = "cisco"; 
	    data [19][0] = "cisco-meraki"; 
	    data [20][0] = "citysoft"; 
	    data [21][0] = "clicktime"; 
	    data [22][0] = "comodo"; 
	    data [23][0] = "connect2give"; 
	    data [24][0] = "dell"; 
	    data [25][0] = "dharma-merchant-services"; 
	    data [26][0] = "docusign"; 
	    data [27][0] = "donorperfect"; 
	    data [28][0] = "efficient-elements"; 
	    data [29][0] = "filemaker"; 
	    data [30][0] = "flixbus"; 
	    data [31][0] = "goodwings"; 
	    data [32][0] = "google-for-nonprofits"; 
	    data [33][0] = "grantstation"; 
	    data [34][0] = "headsets"; 
	    data [35][0] = "horizon-datasys"; 
	    data [36][0] = "hp-inc"; 
	    data [37][0] = "hr-solutions-partners"; 
	    data [38][0] = "infocus"; 
	    data [39][0] = "intuit"; 
	    data [40][0] = "journeyed"; 
	    data [41][0] = "kintone"; 
	    data [42][0] = "lenovo"; 
	    data [43][0] = "linksys"; 
	    data [44][0] = "little-green-light"; 
	    data [45][0] = "mailshell"; 
	    data [46][0] = "microsoft-discount"; 
	    data [47][0] = "microsoft-catalog"; 
	    data [48][0] = "mileiq"; 
	    data [49][0] = "mimo-monitors"; 
	    data [50][0] = "mobile-beacon"; 
	    data [51][0] = "nortonlifelock"; 
	    data [52][0] = "notejoy"; 
	    data [53][0] = "how-okta-helps-nonprofits"; 
	    data [54][0] = "payanywhere"; //was oracle netsuite....fixing for now
	    data [55][0] = "otter-ai"; 
	    data [56][0] = "paya"; 
	    data [57][0] = "payanywhere"; 
	    data [58][0] = "people-onthego"; 
	    data [59][0] = "pluralsight"; 
	    data [60][0] = "priority"; 
	    data [61][0] = "questionpro"; 
	    data [62][0] = "quickbooks-made-easy"; 
	    data [63][0] = "rain-design"; 
	    data [64][0] = "reading-eggs"; 
	    data [65][0] = "refurbished-computers-catalog"; 
	    data [66][0] = "sap-litmos"; 
	    data [67][0] = "shutterstock"; 
	    data [68][0] = "skillsoft"; 
	    data [69][0] = "snpo"; 
	    data [70][0] = "sparrow"; 
	    data [71][0] = "slack"; 
	    data [72][0] = "tableau"; 
	    data [73][0] = "tech-impact"; 
	    data [74][0] = "techbridge"; 
	    data [75][0] = "techsoup-services"; 
	    data [76][0] = "ultralingua"; 
	    data [77][0] = "usb-memory-direct"; 
	    data [78][0] = "veritas"; 
	    data [79][0] = "vmware"; 
	    data [80][0] = "western-digital"; 
	    data [81][0] = "wework"; 
	    data [82][0] = "workplace-by-facebook"; 
	    data [83][0] = "zoner"; 
	    data [84][0] = "zoom";
	    data [85][0] = "wix";
	    data [86][0] = "pagerduty";
	    data [87][0] = "sparkol";
	    data [88][0] = "teamviewer";
	    
	    
	    
	    
	    return data;

}

@DataProvider
public Object[][] CategoryList(){
	  Object [][] data= new Object [22][1];  //x datasets of y elements
	    data [0][0] = "accounting"; 
	    data [1][0] = "security";
		data [2][0] = "business-and-technology-planning";
		data [3][0] = "cloud-computing";
		data [4][0] = "communications";
		data [5][0] = "computers-and-electronics"; 
	    data [6][0] = "databases-and-analytics";
		data [7][0] = "donor-and-grants-management";
		data [8][0] = "fundraising";
		data [9][0] = "green-technology";
		data [10][0] = "human-resources"; 
	    data [11][0] = "it-services";
		data [12][0] = "libraries";
		data [13][0] = "mobile";
		data [14][0] = "operating-systems";
		data [15][0] = "phone-service"; 
	    data [16][0] = "security";  //security and antivirus same page
		data [17][0] = "servers-and-networks";
		data [18][0] = "telecommuting";
		data [19][0] = "training-and-education";
		data [20][0] = "web-and-graphic-design";  //security and antivirus same page
		data [21][0] = "website-management";
		
		return data;

}

@DataProvider
public Object[][] BoostList(){
	  Object [][] data= new Object [6][2];  //x datasets of y
	    data [0][0] = "products/sap-litmos-learning-management-system-access-to-discounted-rates--G-49225--";
	    data [0][1] = "Online";
	    data [1][0] = "products/hotspot-for-mobile-beacon-4g-lte-internet-service-for-nonprofits--G-51472--";
	    data [1][1] = "Hardware";
	    data [2][0] = "products/mimo-7-inch-touch-display-HW-51468-";
	    data [2][1] = "Hardware";
	    data [3][0] = "products/hotspot-for-mobile-beacon-4g-lte-internet-service-for-nonprofits-G-51472-";
	    data [3][1] = "Hardware";
	    data [4][0] = "products/tableau-desktop-and-tableau-prep-builder-2-year-subscription-G-49474-";
	    data [4][1] = "Download";
	    data [5][0] = "products/docusign-standard-edition-G-49950-";
	    data [5][1] = "Online";
	    		
	    
	    return data;
}

@DataProvider
public Object[][] BlogList(){
	  Object [][] data= new Object [52][1];  //x datasets of y
	  	data [0][0] = "/cs/community/b/tsblog/archive/2016/12/14/adobe-premiere-elements-15-vs-adobe-premiere-pro-cc.aspx"; 
//	  	https://blog.techsoup.org/posts/adobe-premiere-elements-15-vs-adobe-premiere-pro-cc
	    data [1][0] = "/cs/community/b/tsblog/archive/2011/04/14/how-to-burn-downloaded-software-to-a-dvd.aspx"; 
	    data [2][0] = "/cs/community/b/tsblog/archive/2016/12/14/adobe-photoshop-elements-15-vs-adobe-photoshop-cc.aspxs"; 
	    data [3][0] = "/cs/community/b/tsblog/archive/2017/07/14/nonprofit-websites-5-ways-to-keep-them-fresh.aspx"; 
	    data [4][0] = "/cs/community/b/tsblog/archive/2017/08/14/ai-with-a-social-impact-the-top-5-reasons-why-nonprofits-should-explore-chatbots.aspx"; 
	    data [5][0] = "/cs/community/b/tsblog/archive/2009/01/21/thinking-about-a-new-phone-system.aspx"; 
	    data [6][0] = "/cs/community/b/tsblog/archive/2016/10/20/6-must-haves-for-your-nonprofit-website.aspx"; 
	    data [7][0] = "/cs/community/b/tsblog/archive/2017/05/18/hidden-gems-for-nonprofits-in-the-techsoup-catalog.aspx"; 
	    data [8][0] = "/cs/community/b/tsblog/archive/2016/01/13/top-10-technology-donations-for-religious-charities.aspx"; 
	    data [9][0] = "/cs/community/b/tsblog/archive/2017/07/19/an-offline-social-media-exercise-that-improves-online-content.aspx"; 
	    data [10][0] = "/cs/community/b/tsblog/archive/2015/09/30/microsoft-office-2016-is-now-available.aspx"; 
	    data [11][0] = "/cs/community/b/tsblog/archive/2014/12/08/10-best-practices-for-email-security.aspx"; 
	    data [12][0] = "/cs/community/b/tsblog/archive/2014/04/22/the-nine-steps-of-planning-a-successful-technology-project.aspx"; 
	    data [13][0] = "/cs/community/b/tsblog/archive/2017/03/23/techsoup-global-network-a-unique-force-for-social-change.aspx"; 
	    data [14][0] = "/cs/community/b/tsblog/archive/2015/01/29/can-i-use-that-image-for-my-website-or-newsletter.aspx"; 
	    data [15][0] = "/cs/community/b/tsblog/archive/2015/06/04/adobe-premiere-elements-13-vs-adobe-premiere-pro-cc.aspx"; 
	    data [16][0] = "/cs/community/b/tsblog/archive/2015/06/04/adobe-premiere-elements-13-vs-adobe-premiere-pro-cc.aspx"; 
	    data [17][0] = "/cs/community/b/tsblog/archive/2017/06/16/3-steps-to-building-your-communications-strategy-in-the-digital-era.aspx"; 
	    data [18][0] = "/cs/community/b/tsblog/archive/2017/09/07/grant-writing-and-the-perfect-storytelling.aspx"; 
	    data [19][0] = "/cs/community/b/tsblog/archive/2017/08/22/artificial-intelligence-in-nonprofit-tech.aspx"; 
	    data [20][0] = "/cs/community/b/tsblog/archive/2016/10/13/how-to-get-adobe-acrobat-pro-dc-through-techsoup.aspx"; 
	    data [21][0] = "/cs/community/b/tsblog/archive/2017/07/25/9-tips-to-maximize-your-fundraising-with-social-media.aspx"; 
	    data [22][0] = "/cs/community/b/tsblog/archive/2015/02/03/top-10-sources-for-free-images.aspx"; 
	    data [23][0] = "/cs/community/b/tsblog/archive/2016/06/27/storymakers-2016-winners.aspx"; 
	    data [24][0] = "/cs/community/b/tsblog/archive/2017/09/12/6-tips-to-improve-your-next-fundraising-campaign-using-digital-storytelling.aspx"; 
	    data [25][0] = "/cs/community/b/tsblog/archive/2016/07/07/5-uses-adobe-acrobat-pro-dc.aspx"; 
	    data [26][0] = "/cs/community/b/tsblog/archive/2016/01/21/adobe-photoshop-elements-14-vs-adobe-photoshop-cc.aspx"; 
	    data [27][0] = "/cs/community/b/tsblog/archive/2016/06/20/how-to-improve-your-donation-page.aspx"; 
	    data [28][0] = "/cs/community/b/tsblog/archive/2016/11/08/what-you-need-to-know-about-windows-10-in-2016.aspx"; 
	    data [29][0] = "/cs/community/b/tsblog/archive/2017/08/17/whats-new-in-adobe-acrobat-pro-2017.aspx"; 
	    data [30][0] = "/cs/community/b/tsblog/archive/2015/02/20/church-and-religious-organization-frequently-asked-questions.aspx"; 
	    data [31][0] = "/cs/community/b/tsblog/archive/2015/10/20/3-cool-things-to-try-in-excel-2016.aspx"; 
	    data [32][0] = "/cs/community/b/tsblog/archive/2017/06/13/how-nonprofits-can-improve-their-email-deliverability.aspx"; 
	    data [33][0] = "/cs/community/b/tsblog/archive/2017/08/10/how-nonprofits-are-successfully-using-chatbots.aspx"; 
	    data [34][0] = "/cs/community/b/tsblog/archive/2016/04/06/5-ways-nonprofits-can-use-sms.aspx"; 
	    data [35][0] = "/cs/community/b/tsblog/archive/2017/07/11/record-highs-for-gifts-to-nonprofits.aspx"; 
	    data [36][0] = "/cs/community/b/tsblog/archive/2015/11/06/3-onenote-2016-tips-to-keep-you-organized.aspx"; 
	    data [37][0] = "/cs/community/b/tsblog/archive/2015/09/20/blackbauds-raisers-edge-nxt-launches.aspx"; 
	    data [38][0] = "/cs/community/b/tsblog/archive/2016/04/18/how-techsoup-helped-to-build-the-refurbishment-industry.aspx"; 
	    data [39][0] = "/cs/community/b/tsblog/archive/2016/10/18/you-can-tech-plan-new-online-training-shows-you-how.aspx"; 
	    data [40][0] = "/cs/community/b/tsblog/archive/2017/05/16/what-you-can-do-about-ransomware.aspx"; 
	    data [41][0] = "/cs/community/b/tsblog/archive/2016/02/15/building-a-monthly-giving-program-with-your-supporters.aspx"; 
	    data [42][0] = "/cs/community/b/tsblog/archive/2017/08/04/6-device-security-tips-to-keep-your-data-safe.aspx"; 
	    data [43][0] = "/cs/community/b/tsblog/archive/2016/11/15/10-tips-to-improve-your-giving-tuesday-and-year-end-donation-pages.aspx"; 
	    data [44][0] = "/cs/community/b/tsblog/archive/2015/03/17/techsoup-tools-for-desktop-publishing-and-presentations.aspx"; 
	    data [45][0] = "/cs/community/b/tsblog/archive/2017/04/13/what-the-new-isp-law-means-for-your-internet-privacy-and-how-to-protect-yourself.aspx"; 
	    data [46][0] = "/cs/community/b/tsblog/archive/2014/09/22/new-infographic-shoot-video-like-a-pro.aspx"; 
	    data [47][0] = "/cs/community/b/tsblog/archive/2015/05/13/4-things-non-designers-should-know-about-graphic-design.aspx"; 
	    data [48][0] = "/cs/community/b/tsblog/archive/2017/02/13/techsoup-boost-an-easy-way-to-boost-your-techsoup-love.aspx"; 
	    data [49][0] = "/cs/community/b/tsblog/archive/2014/12/10/7-easy-ideas-to-give-your-next-presentation-oomph.aspx"; 
	    data [50][0] = "/cs/community/b/tsblog/archive/2014/02/18/charity-cell-phone-donation-programs.aspx"; 
	    data [51][0] = "/cs/community/b/tsblog/archive/2017/01/18/how-to-up-your-digital-marketing-and-fundraising-game-in-2017.aspx"; 


	    return data;
}

@DataProvider
public Object[][] UrlList(){
	  Object [][] data= new Object [7][2];  //x datasets of y
	  	data [0][0] = "products/-g-45103-";
	  	data [0][1] = "products/photoshop-elements-2023-and-premiere-elements-2023-bundle-g-45103-";
	  	data [1][0] = "products/-g-49935-";
	  	data [1][1] = "products/adobe-acrobat-pro-dc-1-year-individual-membership-access-to-discounted-rates-g-49935-";
	  	data [2][0] = "microsoft?test=test";
	  	data [2][1] = "microsoft?test=test";
	    data [3][0] = "microsoft/microsoft-cloud-subscriptions?test=test";
	    data [3][1] = "microsoft/microsoft-cloud-subscriptions?test=test";
	       
	    data [4][0] = "products/old-product-name-g-12345?utm_campaign=campaign_name";
	    data [4][1] = "get-product-donations?utm_campaign=campaign_name";
	    
	    data [5][0] = "products/-g-50593-";
	    data [5][1] = "products/slugtest-zoner-photo-studio-x-1-year-initial-subscription-g-50593-";
	    
	    data [6][0] = "products/sharepoint-online-diy-migration-workshop-g-48941-";
	    data [6][1] = "it-services"; 		
	    
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
	  			
	  			//Glob.setOutPutDirectory(sTestClass);
	  			
	  			
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
