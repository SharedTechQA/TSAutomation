/*********************************************************************
 * TSProductDetails.java
 * TestCases for product details, related products, etc.
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.ProductPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TSProductDetailsTest {
	WebDriver driver = null;
	
	String sTestClass = "TSProductDetailsTest";
@Test
	public void TestRelatedProducts() throws InterruptedException {

		 
		  System.out.println("Running Test details of page");
		  String [] sProduct = {Glob.gsUrl + "products/accountedge-basic-7-for-windows-g-41643-" };
		  
		  //String [] sProduct = {Glob.gsUrl + "products/accountedge-pro-for-windows-2017-g-41641-",Glob.gsUrl + "products/accountedge-basic-7-for-windows-g-41643-" };
		  ///G-41637, G-41643, G-41645

			for (String sproduct : sProduct) {
				
				driver.get(sproduct);
				System.out.println("Running validation for : " + sproduct);
				
			
				
			System.out.println("Checking clickable Related Products");	
			ProductPage.tabRelatedProductItem1(driver).click();
			
			//driver.navigate().back();
			
			//ProductPage.tabRelatedContentItem1(driver).click();
			

	/* have to write a case for if content exists, etc.
			ProductPage.tabRelatedContentItem1(driver).click();
			System.out.println("Related content card clickable on page load");
	*/
			
			String sCurrentPage;
			
			sCurrentPage = driver.getCurrentUrl();
			
			System.out.println(sCurrentPage + " is what has loaded");
			driver.get(Glob.gsUrl);
			}
		}	

@Test(dataProvider = "getProductData")
	public void TestProductPageDetails(boolean bLogin, String sAddToCart) throws InterruptedException {
		String sExpectedLink = "http://www.quickbooksmadeeasy.com/";
		String sLinkFound;
		String sCurrentPage;
	
	
		if(bLogin) {
			LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
			System.out.println("Checking Logged in User Values");
		}
		
		else {
			//do nothing
			System.out.println("Checking values when Not Logged in");
		}
			

		
	  System.out.println("Running Test details of page");
	  String [] sProduct = {Glob.gsUrl + "products/quickbooks-online-made-easy-for-nonprofits-the-essentials-discounted-g-51018-"};
	  
	  ///G-41637, G-41643, G-41645, G-41639
	  //Glob.gsUrl + "products/quickbooks-made-easy-for-nonprofits-%E2%80%93-the-essentials-(discounted)--G-47288--", 
//	  https://www.techsoup.org/products/adobe-acrobat-pro-dc-1-year-individual-membership-%E2%80%93-access-to-discounted-rates--G-49935--
	  	//https://www.techsoup.org/products/office-standard-(discounted)--LS-50447--
		//LoginAction.browserlogin(driver, HomePage.gsEmail, HomePage.gsPassword);
		//cartPage.AddItemToCart(driver, sTestProduct);

		for (String sproduct : sProduct) {
			
			driver.get(sproduct);
			System.out.println("Running validation for : " + sproduct);
		
	

		
		
		System.out.println("Currently Admin Fee is: " + ProductPage.lblAdminFee(driver).getText());
		System.out.println("Check if Add to cart or login");
		if (bLogin) {
			Glob.VerifyText(ProductPage.btnAddToCart(driver).getText(), sAddToCart);
		}
		else
			Glob.VerifyText(ProductPage.btnLoginToAdd(driver).getText(), sAddToCart);
		}
		
		sLinkFound = ProductPage.lnkDonorPartner(driver).getAttribute("href");
		System.out.println("Donor partner link = " + sLinkFound);
		Glob.VerifyText(sLinkFound, sExpectedLink);
		
		
		ProductPage.lnkDescription(driver).click();
			System.out.println("Description clickable on page load");
		
		ProductPage.lnkDetails(driver).click();
			System.out.println("Details clickable on page load");
	
		ProductPage.lnkRules(driver).click();
			System.out.println("Rules clickable on page load");
							
//		ProductPage.lblRelatedContent(driver).click();
//			System.out.println("Related content clickable on page load");
			
		ProductPage.tabRelatedProductItem1(driver).click();
		
		driver.navigate().back();
		
		ProductPage.tabRelatedContentItem1(driver).click();
		
		if(bLogin) {
			LogOutAction.execute(driver, Glob.gbMobile);
		
		}
		
		else {
			//do nothing
			
		}

/* have to write a case for if content exists, etc.
		ProductPage.tabRelatedContentItem1(driver).click();
		System.out.println("Related content card clickable on page load");
*/
		
		
		
		sCurrentPage = driver.getCurrentUrl();
		
		System.out.println(sCurrentPage + " is what has loaded from related content");
		//driver.get(Glob.gsUrl);
		driver.navigate().back();
		}
		


  
	
//@Test
	public void TestHardwareQuestionnaire() throws InterruptedException {
	//https://www-qa.techsoup.org/products/dell-ultrasharp-20-inch-flat-panel-lcd-monitor--HW-50192--
	System.out.println("Running hardware questionnaire");
		 String [] sProduct = {Glob.gsUrl + "products/office-standard--LS-48332--"};
//		 		+ "products/dell-ultrasharp-20-inch-flat-panel-lcd-monitor--HW-50192--"};
 
//		 https://www-stage.techsoup.org/products/--HW-50873--
		 for (String sproduct : sProduct) {
		
			 driver.get(sproduct);
			
	}
		 ProductPage.txtQuantity(driver).clear();
		 ProductPage.txtQuantity(driver).sendKeys("12");
		 ProductPage.btnAddToCart(driver).click();
		 
		 ProductPage.dlgHDW(driver).click();
		 System.out.println("Click on Questionnaire, Questionnaire loaded");
		 ProductPage.btnDismiss(driver).click();
			 
}
	
	 @DataProvider
	  public Object[][] getProductData(){
		  Object [][] data= new Object [2][2];



			data [0][0] = false ;
			data [0][1] = "LOG IN" ;
			
			data [1][0] =  true;
			data [1][1] = "ADD TO CART" ;
			
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
