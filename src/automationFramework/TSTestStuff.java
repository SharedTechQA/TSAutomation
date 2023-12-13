/*********************************************************************
 * TSTestStuff.java
 * Area for testing new methods, etc.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import appModule.FileRename;
import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.AssociateOrgPage;
import pageObjects.EINPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.OrderDetailsPage;
import pageObjects.OrgPage;
import pageObjects.ProductPage;
import pageObjects.cartPage;
import pageObjects.SelectOrgPage;
import pageObjects.BITPage;
import pageObjects.BoostSignUpPage;



public class TSTestStuff {
	WebDriver driver = null;
	String sTestClass = "TSTestStuff";
	String sTestEnv = Glob.gsEnv;
	
	
	public static void AddItemToCart (WebDriver driver, List<String> lsProducts, String sProduct, String sQuantity ) throws InterruptedException {
		//EmptyCart(driver);
		System.out.println("add item to cart function, adding " + sProduct);
		
		
		driver.get(sProduct);
//		JavascriptExecutor je = (JavascriptExecutor) driver;
		if (Glob.gbMobile) {
			((JavascriptExecutor)driver).executeScript("scroll(0,350)");
			ProductPage.txtQuantity(driver).click();
			ProductPage.txtQuantity(driver).clear();
			ProductPage.txtQuantity(driver).sendKeys(sQuantity);
			ProductPage.btnAddToCart(driver).click();
			ProductPage.btnAddToCart(driver).click();
			System.out.println("adding: "+sProduct+ " to cart");
		}
		else {
			if (sQuantity.equals("0")) {//Purchasing boost is the only place i know of so far where quantity will be zero
				ProductPage.btnUpgradeToBoost(driver).click();
				BoostSignUpPage.btnUpgradeToBoost(driver).click();
					
			}else {
			ProductPage.txtQuantity(driver).clear();
			ProductPage.txtQuantity(driver).sendKeys(sQuantity);
			ProductPage.btnAddToCart(driver).click();
			System.out.println("adding: "+sProduct+ " to cart");

		
		  
			}
		}
		}
	
//	@Test  //--order needs modification.
	public void BoostAutoFill ( ) throws InterruptedException {
		 LoginAction.login(driver, "testjoin@foobar.net", Glob.gsPassword, Glob.gbMobile);
		 
		// driver.findElement(By.partialLinkText(sOrgLegalName)).click();  pick org
		 
		 driver.get("https://www-qa.techsoup.org/boost-sign-up");
		 driver.findElement(By.cssSelector("#div-bg-img > section > div > a")).click();
		 
		 cartPage.txtCardNumber(driver).sendKeys(Glob.gsCreditNum);
		 cartPage.txtExpirationMonth(driver).sendKeys(Glob.gsExpMo);
		 cartPage.txtExpirationYear(driver).sendKeys(Glob.gsExpYr);
		 cartPage.txtCVV(driver).sendKeys(Glob.gsCVV);
		 cartPage.txtZipCode(driver).sendKeys(Glob.gsZipCode);
		 cartPage.btnPayWithCard(driver).click();
	}
//@Test	
	 public void CheckoutUpdatePayment(String sOrderID, String sUpdateTo) throws InterruptedException, IOException{

//			String sQAOrderId = "1308367";//Glob.gsOrderId;    //"1302986"; //"1303089";//"1303081" 1302986;
//			String sUpdateTo = "Electronic Check";  //Visa ending in 1111";
			String sUpdateBack;
			
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			
			//Glob.ModifyPayment(sQAOrderId, sUpdateTo); 
			sUpdateBack = Glob.ModifyPayment("1308366", "Visa ending in 1111");
		    
			Thread.sleep(1000);
			driver.get(Glob.gsUrl);
			
			System.out.println("***** update back value = "+ sUpdateBack);
//			LogOutAction.execute(driver, Glob.gbMobile);
//			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			

		//	
			Glob.ModifyPayment("1308366", sUpdateBack); 
			
			LogOutAction.execute(driver, Glob.gbMobile);
			
		 }

	
//  @Test  //added to verifypages
  public void CompareFile() throws InterruptedException, IOException {
//	  System.out.println("find check");

		Random rand = new Random ();
		System.out.println("random??: " + rand.nextInt(999));
		
	   System.out.println("glob get int = " + Glob.getInt());
	   
		 LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
//		 __CSUserNameCookie
		 Cookie sCookie = driver.manage().getCookieNamed("__CSUserNameCookie");
		 Cookie sCookie2 = driver.manage().getCookieNamed("CSFUser");
		 Cookie sCookie3 = driver.manage().getCookieNamed("WSS_FullScreenMode");
		 Cookie sCookie4 = driver.manage().getCookieNamed("__CSOrderGroupIdCookie");
		 
		 
		// 
		 
		 System.out.println(sCookie2);
		 
		 System.out.println(sCookie2.getExpiry());
		 String sGotCookieValue = sCookie2.getValue();
				 
		 assertEquals(sCookie2.getValue(), "username=madmattpaddles&emailAddress=madmattpaddles@gmail.com");
		 assertEquals(sCookie.getValue(), "MadMattPaddles");
		 assertEquals(sCookie3.getValue(), "false");
		 assertEquals(sCookie4.getValue(), "");
		 
		 
		 System.out.println(sCookie2.getValue());
		 
	   
	   driver.get(Glob.gsUrl + "/sitemap.xml");
	  //String sCanonical = driver.findElement(By.partialLinkText("test-matt-content-g-51486")).getText();
	  
	 
	   
  }
  
 // public class SampleCompare {
//@SuppressWarnings("deprecation")
//@Test  //String[] args
	    public void VerifySiteMap () throws IOException, InterruptedException {
			String sUserHome = System.getProperty("user.home");
			String sTestDir = sUserHome + "\\Downloads\\";
			String sTestFile = Glob.gsEnv + "sitemap.xml";
			String sTempExt = "crdownload";
			String sControlFile = Glob.gsEnv + "sitemap_controltest.xml";
			

			
	        long start = System.nanoTime();
	       
	        System.out.println("user home is " + System.getProperty("user.home"));
	        //delete file if it exists
	        File f= new File(sTestDir + sTestFile);   
	        if (f.delete()) {
	      	  
	        	System.out.println("sitemap file for test env: " + Glob.gsEnv + " existed, deleting before test");
	        }
	       
	        driver.get(Glob.gsUrl + "/sitemap.xml");
	       
	       
	       Thread.sleep(2000);
	       
	       FileRename.renameX(sTestDir, sTempExt, sTestFile);
	       FileRename.renameX("C:/Windows/System32/drivers/etc", "hosts", "hostsauto");
	       FileRename.renameX("C:/Windows/System32/drivers/etc", "hosts", "hostsauto");
	       
	       //file compare
	        BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream(sTestDir + sTestFile));
	        BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream(sTestDir + sControlFile));
	
	        int b1 = 0, b2 = 0, pos = 1;
	        while (b1 != -1 && b2 != -1) {
	            if (b1 != b2) {
	                System.out.println("Files differ at position " + pos);
	            }
	            pos++;
	            b1 = fis1.read();
	            b2 = fis2.read();
	        }
	        if (b1 != b2) {  //assert?
	            System.out.println("Files have different length");
	           
	        } else {
	            System.out.println("Files are identical, you can delete one of them.");
	        }
	        fis1.close();
	        fis2.close();
	        
	        long end = System.nanoTime();
	        System.out.print("Execution time: " + (end - start)/1000000 + "ms ");
	    }
	
	  
//	  @Test 
	  public void CheckoutVerifyDiscounted () throws InterruptedException, IOException{
	 	 System.out.println("running CheckoutVerifyShipping");
	 	LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
//	 	  String [] sProduct = {Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	 	  String sProduct = Glob.gsUrl + "products/office-for-mac-(discounted)--LS-50449--";
	 	  String sQuantity = "5";
	 	  boolean bLarge = false;
		  boolean bAddress = true;
		  boolean bDate = false;
	 	  boolean bCreditCard = false;
	 	  String sTotal = "$835.00";
	 	  String sSalesTaxes  = "$0.00";
	 	  String sTotalDue = "$835.00";
	 	  String sCoupon = "";
	 	  String sShipping = "$0.00";
	 	  Boolean bRestriction = false;
	 	  
	 	 // cartPage.CheckOut( driver, sProduct, sQuantity,  bLarge, bCreditCard, sTotal, sSalesTaxes, sTotalDue, sShipping, sCoupon);
	 	  cartPage.CheckOut(driver, sProduct, sQuantity, bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, true, false);
	 	  

	  }
	  
	 // @Test
	  public void CheckoutUpdatePayment() throws InterruptedException {
//	 	String [] sProduct = {Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--"};
	 	String sQAOrderId = "1303089";//"1303081";
		Glob.FindOrder(sQAOrderId);
		driver.findElement(By.partialLinkText(sQAOrderId)).click();
	 	
//	 	Glob.ModifyPayment(sQAOrderId); 
	  }
	  
//@SuppressWarnings("unlikely-arg-type")
//@Test
	  public void genericTest () throws InterruptedException, SQLException, ClassNotFoundException, IOException{
		  driver.get(Glob.gsUrl);
		  String sOrgLegalName = "Remove Association";
		  
			//LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			//OrgPage.removeOrgAssociation(driver, sOrgLegalName);
		  driver.get("https://www.techsoup.org");
		  driver.get("https://www.techsoup.org/products/onboard-board-management-software-1-year-subscription-access-to-discounted-rates-g-52298-");
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,400)", "");
		  
		  ProductPage.lnkRules(driver).click();
		 //System.out.println( "location is " + HomePage.lblFooter(driver).getLocation());
			 System.out.println( "location is " + HomePage.lblFooter(driver).getLocation());
			// Point sfoundLocation = HomePage.lblFooter(driver).getLocation();
			 Point pFooter = HomePage.lblFooter(driver).getLocation();
			 String sCasted = String.valueOf(pFooter);
			 String sExpected = "(0, 2148)";
			 if (! sCasted.equals(sExpected)){
				 System.out.println("page broken");
				 System.out.println(sCasted + "  * "+ sExpected);
			 }else {
				 System.out.println("page is not broken");
			 }
			
		 
		  driver.get("https://www.techsoup.org/products/autodesk-media-and-entertainment-collection-1-year-subscription-g-49250-");
			
		  JavascriptExecutor js2 = (JavascriptExecutor) driver;
		  js2.executeScript("window.scrollBy(0,400)", "");
		  
		  ProductPage.lnkRules(driver).click();
		 System.out.println( "location is " + HomePage.lblFooter(driver).getLocation());
		 Point sfoundLocation = HomePage.lblFooter(driver).getLocation();
		 Point pFooter2 = HomePage.lblFooter(driver).getLocation();
		 String sCasted2 = String.valueOf(pFooter2);
		 String sExpected2 = "(0, 2148)";
		 if (! sCasted2.equals(sExpected2)){
			 System.out.println("page broken");
			 System.out.println(sfoundLocation + "  * "+ pFooter2);
		 }else {
			 System.out.println("page is not broken");
		 }
		 
		 
			
	  }
@Test
	public void renameHosts () throws IOException {

    File oldName = new File("C:/windows/system32/drivers/etc/hostswfe1.foo");
    File newName = new File("C:/windows/system32/drivers/etc/hostsrename1.foo");
    
    if(oldName.renameTo(newName)) {
        System.out.println("renamed");
     } else {
        System.out.println("Error");
     }
//	FileRename.renameX("C:/testfolder", "matt.txt", "mattold.txt");
//    FileRename.renameX("C:/testfolder", "matt1.txt", "matt.txt");
}
	  
	  
		
 


 
 @BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
//		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!**** IN " + Glob.gsEnv );
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
	  	System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );
	  	
	  	
	
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