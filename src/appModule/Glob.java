/*********************************************************************
 * Glob.java
 * 
 * Element locators and methods for use with general  functionality in TS.org
 * common and shared methods, get screen shot, etc.
 * Set Browser/environment methods and variables as well
 ****methods
 * GetScreenShot
 * GetDate
 * SetBrowser
 * SetEnv
 * LoadFullCatalog
 * VerifyText
 * 
 *	Matt Radford 
 * ********************************************************************/

// new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selector));
package appModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.xml.transform.Source;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.OrderDetailsPage;
import pageObjects.OrderSummary;
import pageObjects.ProductCatalogPage;
import pageObjects.RequestHistoryPage;
import pageObjects.cartPage;

public class Glob {
	private static WebElement element = null;
	static WebDriver driver;
	/*******************  Set environment to run ***************/
	public static String gsEnv;// = "QA";
	public static String gsEmail;
	public static String gsExpireEmail;
	public static String gsPWEmail = "matttest@foobar.net";
	public static String gsPassword = "B00ker99!";
	public static String gsPWUrl;// = Glob.gsUrl +"/my-account";
	public static String gsUrl;
	public static String gsAdminSite;
	public static String gsCreditNum;
	public static String gsExpMo;
	public static String gsExpYr;
	public static String gsCVV;
	public static String gsEnvCommunity;
	public static String gsBrowser;//= "Chrome";
	public static String gsZipCode = "98199";
	public static String gsPartialLogin;// = "MadMattPaddles@gmail.com";
	public static String gsPartialOrderID;
	public static String gsBoostUrl = Glob.gsUrl + "boost";
	public static String gsBoostLogin;
	public static String gsQuestProd;
	public static Boolean gbMobile = false;
	public static String gsCloudMgrLogin;
	public static String gsCloudMgrPassword;
	public static String gsSqlDb;
	public static String gsQuantity;
	public static String gsOrderId;
	public static String gsOrderIdAch;
	public static String gsOrderIdCheck;
	public static String gsCoupon;
	public static String gsCanonical;
	public static String gsNewEmail;
	public static String gsCheckoutEmail;
	
	public static String gsControl = ".//ControlData//";
	public static String gsEmailUpdateAccct;
	public static String gsReportFolder = "//ltmradford01/testreports";
	public static String gsEnvForums;
	
	 

	
//
	
//bad url request
	
	public static WebElement lblBadURL (WebDriver driver) {
		element = driver.findElement(By.cssSelector("body > h2"));
		//#DeltaPlaceHolderMain > div.grid-line-align > section > div > div:nth-child(4) > ul > li:nth-child(1) > div.card > a > div > p
	return element;
		
	}
	public static String gsBadUrl = "Bad Request - Invalid URL";
	
//	
	public static int getInt () {
		
		Random random = new Random ();
		return random.nextInt(999);
		
	}
	public static void GetScreenShot(WebDriver driver, String sTestClass, String sFileName) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		FileUtils.copyFile(src, new File("c://testautoimages/"+GetDate()+sTestClass+"_" + sFileName + ".png"));
		//FileUtils.copyInputStreamToFile(arg0, arg1);
		
		System.out.println("capturing screen shot, file can be located here:  " + "c://testautoimages/"+GetDate()+ sTestClass+"_" + sFileName + ".png" );
		}
	
	
	public static String GetDate() {
		DateFormat dateFormat = new SimpleDateFormat ("MMddyy");

		Date date = new Date();
		String sDate = dateFormat.format(date);
		return sDate;
	}

	public static String GetDateTime() {
		DateFormat dateFormat = new SimpleDateFormat ("MMddyyhhmm");

		Date date = new Date();
		String sDate = dateFormat.format(date);
		return sDate;
	}
public static String getProps (String sProp) throws IOException {//mwr...not currently being used TESTNG functionality
	String sValue = null;
	Properties prop=new Properties ();
	FileInputStream fis=new FileInputStream("C:\\Users\\mradford\\eclipse-workspace\\TSGitTests\\src\\testngFiles\\package-info.java");
	
	prop.load(fis);
	
	return sValue;
}

public static void setOutPutDirectory (String sTest) throws IOException {
	Path pRootDir = Files.createDirectories(Paths.get("C:/TSTestOutPut" + Glob.GetDate()+"/"+gsEnv+"/"+sTest));
	System.setOut(new PrintStream(new FileOutputStream(pRootDir+"\\testoutput.txt")));
}

public static void setOutPutDirectory (String sTest, String sFileType) throws IOException {
	Path pRootDir = Files.createDirectories(Paths.get("C:/TSTestOutPut" + Glob.GetDate()+"/"+gsEnv+"/"+ sTest));
	System.setOut(new PrintStream(new FileOutputStream(pRootDir+"\\testoutput." + sFileType)));
}

//After test item  mwr..not currently being used.
public static void setTestNGOutPutDirectory (String sTest) throws IOException {  
	Path pRootDir = Files.createDirectories(Paths.get("C:/TSTestOutPut" + Glob.GetDate()+"/"+gsEnv+"/"+sTest));
	//System.setOut(new PrintStream(new FileOutputStream(pRootDir+"\\testoutput.txt")));
	
	File source = new File(".//test-output//emailable-report.html");
	
	File dest = new File (pRootDir +"/"+GetDateTime()+"-SuiteReport.html");//emailable-report.html
	//, "C:/TSTestOutPut" + Glob.GetDate()+"/"+sTest)
	com.google.common.io.Files.copy(source, dest);
}


//C:\Users\mradford\eclipse-workspace\TSGitTests\test-output
public static WebDriver setBrowser(String sBrowser) throws IOException  {

	switch (sBrowser) {
	case "Chrome":
	 	System.setProperty("webdriver.chrome.driver", ".//sdrivers//chromedriver.exe");
////	 	System.setProperty("webdriver.chrome.driver", "C://opt//WebDriver//bin//chromedriver.exe");
//		driver = new ChromeDriver();
		//System.out.println("setting browser to:  " + sBrowser);
		//System.out.println(driver);
		 ChromeOptions options = new ChromeOptions();
	        driver = new ChromeDriver(options);
	        
	        
		break;
	
	case "Firefox":
		System.setProperty("webdriver.gecko.driver", ".//sdrivers//geckodriver.exe");

		driver = new FirefoxDriver();
	
		break;
		
	case "IE":
		System.setProperty("webdriver.ie.driver", ".//sdrivers//iedriverserver.exe");
		//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		driver = new InternetExplorerDriver();
//		System.out.println("setting browser to:  " + sBrowser);
//		System.out.println(driver);
		
		break;
	
	case "Edge":
		System.setProperty("webdriver.edge.driver", ".//sdrivers//msedgedriver.exe");
		//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		driver = new EdgeDriver();
//		System.out.println("setting browser to:  " + sBrowser);
//		System.out.println(driver);
		
		break;
	
	}
	return driver;
	
}

public static void loadFullCatalog () {
	//System.out.println("load catalog senv is " + sEnv);
	driver.get(gsUrl + "/get-product-donations/");
	if (gbMobile) {
		driver.get(gsUrl + "/get-product-donations/product-catalog");
	}
	else {
		ProductCatalogPage.lnkBrowseFull(driver).click();
	}
	
	
//	switch (Glob.gsEnv) {
//		
//	case "Stage":
//		driver.get(gsUrl + "/get-product-donations");
//		ProductCatalogPage.lnkBrowseFull(driver).click();
//		break;
//	case "QA":
//		driver.get(gsUrl + "/get-product-donations/");
//		if (gbMobile) {
//			driver.get(gsUrl + "/get-product-donations/product-catalog");
//		}
//		else {
//			ProductCatalogPage.lnkBrowseFull(driver).click();
//		}
//		break;
//	case "Prod":
//		driver.get(gsUrl + "/get-product-donations");
//		ProductCatalogPage.lnkBrowseFull(driver).click();
//		break;
//	
//	}
//	
}
/*********** set shared variables for environment values...anything that might need to be set in the beginning of the test***********/
public static String setEnv (String sEnv){
//	System.out.println("in set env");
	switch (sEnv) {
	
	case "Dev":
		System.out.println("running in " + sEnv + " from switch");
		gsEmail = "matttest@foobar.net";
		gsExpireEmail = "expire@foobar.net";
		//gsNewEmail = "MattStage1@foobar.net";
		gsEmailUpdateAccct = "mattradford1@outlook.com";
		gsNewEmail = "madmattford@foobar.net";
		gsPassword = "B00ker99!";
		gsUrl = "https://www-dv.techsoup.org/";
		gsPWUrl = Glob.gsUrl +"my-account";
		gsEnv = "Stage";
		gsPassword = "B00ker99!";
		gsBoostLogin = "MattBoostDev@foobar.net";
		gsCreditNum = "4111111111111111";
		gsExpMo ="12";
		gsExpYr = "23";
		gsCVV = "123";
		gsEnvCommunity = "https://dv-forums.techsoup.org/cs/community/";
		gsEnvForums = "https://dev-forums.techsoup.org/";
		
	    gsQuestProd = "/products/5-hp-elitedesk-800-g1-desktops-hw-51638-";
	    gsSqlDb = "jdbc:jtds:sqlserver://10.10.103.31:1433/Onyx;database=Onyx;useNTLMv2=true;domain=Compumentor";
	    gsOrderId ="1301623";  // "1302986";
	    gsCoupon = "10PerOff";
	    gsQuantity = "20";
	    gsAdminSite = "www-dv.techsoup.org:46000";
	    gsPartialLogin = "matttest@foobar.net";
//	    gsCanonical = "<link rel=\"canonical\" href=\"https://www-stage.techsoup.org/products/-g-51486-\"";
	    gsCanonical = "<link rel=\"canonical\" href=\"https://www-dv.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-\"";
		break;
	
	case "Stage":
		System.out.println("running in " + sEnv + " from switch");
		gsEmail = "MattStage@foobar.net";
		//gsNewEmail = "MattStage1@foobar.net";
		gsEmailUpdateAccct = "mattradford1@outlook.com";
		gsCheckoutEmail = "mattstage@foobar.net";
		gsExpireEmail = "expire@foobar.net";
		gsNewEmail = "madmattford@foobar.net";
		gsPassword = "B00ker99!";
		//gsUrl = "https://www-stage.techsoup.org/";
		gsPWUrl = Glob.gsUrl +"my-account";
//		gsUrl = "https://stage-www.techsoup.org/";
		gsUrl = "https://www-stage.techsoup.org/";
		gsEnv = "Stage";
		gsBoostLogin = "MattBoostStage@foobar.net";
		gsCreditNum = "4111111111111111";
		gsExpMo ="12";
		gsExpYr = "23";
		gsCVV = "123";
		gsEnvCommunity = "https://stage-forums.techsoup.org/cs/community/";
		gsEnvForums = "https://stage-forums.techsoup.org";
	    gsQuestProd = "/products/5-hp-elitedesk-800-g1-desktops-hw-51638-";
	    gsSqlDb = "jdbc:jtds:sqlserver://10.10.103.31:1433/Onyx;database=Onyx;useNTLMv2=true;domain=Compumentor";
	    gsOrderId ="1301623";  // "CC order id";
		gsOrderIdAch = "1309099";
		gsOrderIdCheck = "1309100";
	    gsCoupon = "10PerOff";
	    gsQuantity = "20";
	    gsAdminSite = "www-stage.techsoup.org:46000";
	    gsPartialLogin = "Mattstage@foobar.net";
	    gsCanonical = "<link rel=\"canonical\" href=\"https://www-stage.techsoup.org/products/-g-51486-\"";
	    //this tests the custom slug in stage
	   //gsCanonical = "<link rel=\"canonical\" href=\"https://www-stage.techsoup.org/products/testmattcontent-g-51486-\"";
	    
	    
		break;
	case "Prod":
		System.out.println("running in " + sEnv + " from switch");
		gsEmail = "matthewradford@sbcglobal.net";
		//gsNewEmail = "mradfordathome1@hotmail.com";
		String gsEditOrgEmail = "mattadford1@outlook.com";
		gsEmailUpdateAccct = "mattradford1@outlook.com";
		gsNewEmail = "madmattford@foobar.net";
		gsCheckoutEmail = "mradfordathome@hotmail.com";
		gsPassword = "B00ker99!";
		gsUrl = "https://www.techsoup.org/";
		gsPWUrl = Glob.gsUrl +"my-account";
		gsEnv = "Prod";
		gsCreditNum = "452";//need real cc
		gsExpMo ="02";
		gsExpYr = "27";
		gsCVV = "855";
		gsEnvCommunity = "https://forums.techsoup.org/cs/community/";
		gsEnvForums = "https://forums.techsoup.org/";
		gsQuestProd = "/products/5-hp-elitedesk-800-g1-desktops-hw-51638-";
		gsQuantity = "25";
		gsAdminSite = "www.techsoup.org:46000";
//		gsCanonical = "<link rel=\"canonical\" href=\"https://www.techsoup.org/products/-g-51486-\"";
//		https://www-stage.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-
		gsCanonical = "<link rel=\"canonical\" href=\"https://www-stage.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-\"";
		//href="https://www-stage.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-
		break; 
	case "QA":
		System.out.println("running in " + sEnv + " from switch");
		gsUrl = "https://www-qa.techsoup.org/";
		gsPWUrl = Glob.gsUrl +"my-account";
		gsEmail = "madmattpaddles@gmail.com";
		gsCheckoutEmail = "checkout@techsoup.org";
		gsExpireEmail = "expire@foobar.net";
		gsEmailUpdateAccct = "mattradford1@outlook.com";
		gsNewEmail = "madmattford@foobar.net";
		gsPassword = "B00ker99!";
		gsBoostLogin = "MattBoost@foobar.net";
		gsCloudMgrLogin = "i.w.t.e.c.h.s.o.u.pt.esting@gmail.com";
		gsCloudMgrPassword = "Sameer11";
		gsEnv = "QA";
		gsPartialLogin = "MadMattPaddles@gmail.com";
		//return gsEnv = "QA";
		gsCreditNum = "4111111111111111";
		gsExpMo ="12";
		gsExpYr = "23";
		gsCVV = "123";
		gsEnvCommunity = "https://qa-forums.techsoup.org/";//redirects in prod to forums...in QA get oops	
		gsEnvForums = "https://qa-forums.techsoup.org";
		gsPartialLogin = "Matttest@foobar.net";
		gsPartialOrderID = "1303147";
		gsQuestProd = "/products/5-hp-elitedesk-800-g1-desktops-hw-51638-";
		gsSqlDb = "jdbc:jtds:sqlserver://10.25.96.156:1433/Onyx;database=Onyx;useNTLMv2=true;domain=Compumentor";
		gsOrderId = "1317187";  //CC orderid
		gsOrderIdAch = "1317189";
		gsOrderIdCheck = "1317188";
		gsCoupon = "11Off";
		gsQuantity = "20";
		gsAdminSite = "www-qa.techsoup.org:46000";
//		gsCanonical = "<link rel=\"canonical\" href=\"https://www-qa.techsoup.org/products/-g-51486-\"";
		gsCanonical = "<link rel=\"canonical\" href=\"https://www-stage.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-\"";
//		href="https://www-stage.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-
											   //href="https://www-qa.techsoup.org/products/quickbooks-made-easy-for-nonprofits-the-essentials-discounted-g-51486-" 
		break;
	}
	return gsEnv;
	}

public static boolean VerifyText (String sFound, String sExpected) {
//assertEquals(sFound, ProductCatalogPage.sCatalogPageURL);
if (sFound.equals(sExpected)) {
	System.out.println("********** VERIFICATION PASS: " + sFound + " MATCHES EXPECTED:  " + sExpected);
	return true;
		}
else {
	System.out.println("********** ERROR: " + sFound + " NOT EQUAL TO EXPECTED:  " + sExpected);
	return false;
		}

	}

//Actions move = new Actions(driver);
public static void Scroll () {
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,5700);");
}

public static void CancelOrder (String sOrderID) throws InterruptedException {
	System.out.println("Attempting to cancel "  + sOrderID);
		FindOrder(sOrderID);
	
//		Actions move = new Actions(driver);
//		move.moveToElement(HomePage.btnSubscribe(driver));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		
		
		
		Thread.sleep(6000);
		RequestHistoryPage.btnCancel(driver).click();
		RequestHistoryPage.btnCancelThisRequest(driver).click();
		System.out.println("Canceled order " + sOrderID);
		driver.get(gsUrl);

	}
	

public static void FindOrder (String sOrderID) throws InterruptedException {
	System.out.println("Searching for order: "  + sOrderID);
	MyAccountPage.invoke(driver);
	RequestHistoryPage.invoke(driver);
	Thread.sleep(3000);
	RequestHistoryPage.txtRequestNumber(driver).sendKeys(sOrderID);
	RequestHistoryPage.btnFindRequest(driver).click();
	
	int i = driver.findElements(By.partialLinkText(sOrderID)).size();
	//System.out.println("found " + i +" number of elements");
	boolean bExists = true;
	while (i<1) {
		
		RequestHistoryPage.txtRequestNumber(driver).clear();  //gotta clear the text field
		RequestHistoryPage.txtRequestNumber(driver).sendKeys(sOrderID);
		RequestHistoryPage.btnFindRequest(driver).click();
		bExists = false;
		i = driver.findElements(By.partialLinkText(sOrderID)).size();
	}

		System.out.println("Found order " + sOrderID);

	

	}

public static void EditOrder (String sOrderID ) throws InterruptedException {  //, Boolean bIsCreditCard, Boolean bPayByCheck
		FindOrder(sOrderID);
		int i = driver.findElements(By.cssSelector("#stsHeader > a")).size();
		if (i >=1){
			//}RequestHistoryPage.btnAddPayment(driver).isDisplayed()) {		//this was a check order
			RequestHistoryPage.btnAddPayment(driver).click();               
			System.out.println("Loading Check order for edit " + sOrderID);
			OrderDetailsPage.rdoCreditCard(driver).click();
			OrderDetailsPage.txtCreditCardNumber(driver).sendKeys(Glob.gsCreditNum);
			OrderDetailsPage.txtCVV(driver).sendKeys(Glob.gsCVV);
			OrderDetailsPage.txtExireMonth(driver).sendKeys(Glob.gsExpMo);
			OrderDetailsPage.txtExpireYear(driver).sendKeys(Glob.gsExpYr);
			OrderDetailsPage.txtZipCode(driver).sendKeys(Glob.gsZipCode);
			OrderDetailsPage.btnPayWithCard(driver).click();
		}
		else {
			driver.findElement(By.partialLinkText(sOrderID)).click();        //else this was a CC order
			System.out.println("Loading CC order for edit " + sOrderID);
			OrderDetailsPage.btnEditDetails(driver).click();
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true)",  OrderDetailsPage.rdoMailACheck(driver));
			OrderDetailsPage.rdoMailACheck(driver).click();
			OrderDetailsPage.btnRemovePayment(driver).click();
			
			
			//update order to check
			
		}
	}
	
public static void VerifyOrderDetails (String sOrderID, boolean bPartial) throws InterruptedException {
	FindOrder(sOrderID);
	driver.findElement(By.partialLinkText(sOrderID)).click();
	String sFoundNote = OrderDetailsPage.lblPaymentNote(driver).getText();
	VerifyText(sFoundNote, OrderDetailsPage.sPartialPaymentText);
	
	String sFoundStatus = OrderDetailsPage.lblRequestStatus(driver).getText();
	VerifyText(sFoundStatus, OrderDetailsPage.sPartialStatus);
	
	String sFoundOrderBalance = OrderDetailsPage.lblOrderBalance(driver).getText();
	VerifyText(sFoundOrderBalance, OrderDetailsPage.sOrderBalance);
	
	String sFoundItem2Status = OrderDetailsPage.lblItem2Status(driver).getText();
	VerifyText(sFoundItem2Status, OrderDetailsPage.sItem2Status);
	
	
	if (bPartial) {
		if (OrderDetailsPage.btnCancel(driver).isDisplayed()) {
			System.out.println("[Cancel] should not be here");
		}
		else {
			System.out.println("******** PASS, no [Cancel] button ");
			
		
		OrderDetailsPage.btnEditDetails(driver).click();
//		
		if (OrderDetailsPage.rdoMailACheck(driver).isDisplayed()) {
			

			System.out.println("OOPS, found mail a check RDO but did not expect it");
		}
		else {
			System.out.println("******** PASS no <mail a check> RDO ");
			}
	
	
			}
		}	
	}
public static String ModifyPayment (String sOrderID, String sUpdateTo) throws InterruptedException {
	//System.out.println("Modify Payment for Existing Order " );
	Glob.FindOrder(sOrderID);
	driver.findElement(By.partialLinkText(sOrderID)).click();
//	
			
	Actions move = new Actions(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 120);
	
	String sPayMethod = OrderDetailsPage.lblPaymentMethod(driver).getText();
	String sUpdateBack = OrderDetailsPage.lblPaymentMethod(driver).getText();
	String sStatus = OrderDetailsPage.lblRequestStatus(driver).getText();
	//String sPaymentStatus = OrderDetailsPage.lblPaymentStatus(driver).getText();
	//System.out.println("Current Payment Method = " + sPayMethod);
	//"Credit Card";
	if (sPayMethod.equals("Visa ending in 1111") && sUpdateTo.equals("Pending Payment")) {
		Thread.sleep(1000);
		System.out.println("****Modify CC Payment to Check");
		OrderDetailsPage.btnEditDetails(driver).click();
		OrderDetailsPage.rdoMailACheck(driver).click();
		OrderDetailsPage.btnRemovePayment(driver).click();
		//OrderDetailsPage.
//		wait.until(ExpectedConditions.visibilityOf(OrderDetailsPage.lblUpdatePayment(driver)));
		
		return sPayMethod;
		
	}else if(sStatus.equals("Pending Payment") && sUpdateTo.equals("Visa ending in 1111")) {
		System.out.println("****Modify Check Payment to CC");
		Thread.sleep(1000);
		//OrderDetailsPage.btnEditDetails(driver).click();  no edit button for checks
		move.moveToElement(OrderDetailsPage.rdoCreditCard(driver));
		OrderDetailsPage.rdoCreditCard(driver).click();
		OrderDetailsPage.txtCreditCardNumber(driver).sendKeys(Glob.gsCreditNum);
		OrderDetailsPage.txtExireMonth(driver).sendKeys(Glob.gsExpMo);
		OrderDetailsPage.txtExpireYear(driver).sendKeys(Glob.gsExpYr);
		OrderDetailsPage.txtCVV(driver).sendKeys(Glob.gsCVV);
		OrderDetailsPage.txtZipCode(driver).sendKeys(Glob.gsZipCode);
		Thread.sleep(1000);
		OrderDetailsPage.btnPayWithCard(driver).click();
//		wait.until(ExpectedConditions.visibilityOf(OrderDetailsPage.lblUpdatePayment(driver)));
		
		return sStatus;
		
	}else if(sPayMethod.equals("Electronic Check") && sUpdateTo.equals("Visa ending in 1111")) {
		System.out.println("****Modify ACH Payment to CC");
		Thread.sleep(1000);
		OrderDetailsPage.btnEditDetails(driver).click();
		OrderDetailsPage.rdoCreditCard(driver).click();
		OrderDetailsPage.txtCreditCardNumber(driver).sendKeys(Glob.gsCreditNum);
		OrderDetailsPage.txtExireMonth(driver).sendKeys(Glob.gsExpMo);
		OrderDetailsPage.txtExpireYear(driver).sendKeys(Glob.gsExpYr);
		OrderDetailsPage.txtCVV(driver).sendKeys(Glob.gsCVV);
		OrderDetailsPage.txtZipCode(driver).sendKeys(Glob.gsZipCode);
		Thread.sleep(1000);
		OrderDetailsPage.btnPayWithCard(driver).click();
//		wait.until(ExpectedConditions.visibilityOf(OrderDetailsPage.lblUpdatePayment(driver)));
		
		return sPayMethod;
	
	}else if(sPayMethod.equals("Electronic Check") && sUpdateTo.equals("Pending Payment")) {
		System.out.println("****Modify ACH Payment to Check");
		Thread.sleep(1000);
		OrderDetailsPage.btnEditDetails(driver).click();
		OrderDetailsPage.rdoMailACheck(driver).click();
		OrderDetailsPage.btnRemovePayment(driver).click();
//		wait.until(ExpectedConditions.visibilityOf(OrderDetailsPage.lblUpdatePayment(driver)));
		
		return sPayMethod;
		
	}else if(sPayMethod.equals("Visa ending in 1111") && sUpdateTo.equals("Electronic Check")) {
		System.out.println("****Modify CC Payment to ACH");
		Thread.sleep(1000);
		OrderDetailsPage.btnEditDetails(driver).click();
		OrderDetailsPage.rdoACHPayment(driver).click();
		OrderDetailsPage.txtACHAccount(driver).sendKeys("1000000000");
		OrderDetailsPage.txtACHRouting(driver).sendKeys("011000015");
		OrderDetailsPage.rdoChecking(driver).click();
		OrderDetailsPage.rdoBusiness(driver).click();
		
		OrderDetailsPage.btnPayACH(driver).click();
//		wait.until(ExpectedConditions.visibilityOf(OrderDetailsPage.lblUpdatePayment(driver)));
//		Thread.sleep(2000);
		return sPayMethod;
		
	}else if (sStatus.equals("Pending Payment") && sUpdateTo.equals("Electronic Check")) {
		System.out.println("****Modify Check Payment to ACH");
		Thread.sleep(1000);
		//OrderDetailsPage.btnEditDetails(driver).click();
		OrderDetailsPage.rdoACHPayment(driver).click();
		OrderDetailsPage.txtACHAccount(driver).sendKeys("1000000000");
		OrderDetailsPage.txtACHRouting(driver).sendKeys("011000015");
		OrderDetailsPage.rdoChecking(driver).click();
		OrderDetailsPage.rdoBusiness(driver).click();
		
		OrderDetailsPage.btnPayACH(driver).click();
//		wait.until(ExpectedConditions.visibilityOf(OrderDetailsPage.lblUpdatePayment(driver)));
		
//		Thread.sleep(2000);
		return sStatus;
	}
	return sPayMethod;
	
	
}
	
		

}




	

		
	
