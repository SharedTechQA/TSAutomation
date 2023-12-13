/*********************************************************************
 * TSCatalogTest.java
 * Test cases for Catalog area.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import appModule.Glob;
import pageObjects.HomePage;
import pageObjects.ProductCatalogPage;


public class TSCatalogTest {
	WebDriver driver = null;
	
	String sTestClass = "TSCatalogTest";
  @Test
  public void CatalogTest() throws InterruptedException, IOException {
	  //HomePage.setEnv("Prod");
	  
	 HomePage.mnuProductCatalog(driver).click();
	 
	 //test donor list
	 ProductCatalogPage.mnuDonorOrCompany(driver).click();
	 ProductCatalogPage.liDonorCompany(driver).click();
	 String sDonorList = ProductCatalogPage.liDonorCompany(driver).getText();
	 
	
	 try (PrintWriter out = new PrintWriter("c://testautoimages//DonorCompanyList.txt")){
		 out.println(sDonorList);	
	 }
	 catch (IOException e) {
		 e.printStackTrace();
	 }
	 
	 //test category list
	 ProductCatalogPage.mnuCategory(driver).click();
	 //ProductCatalogPage.liCategory(driver).click();
	 String sCategoryList = ProductCatalogPage.liCategory(driver).getText(); 
	 System.out.println("checking catalog page list ");
	 
	 try (PrintWriter out = new PrintWriter("c://testautoimages//CategoryList.txt")){
		 out.println(sCategoryList);	
	 }
	 catch (IOException e) {
		 e.printStackTrace();
	 }
	 
	 
	 
	 //verify hardware page
	 ProductCatalogPage.mnuHardware(driver).click();
//	 System.out.println("checking Hardware page H2 ");
	 System.out.println("checking Hardware page H2, URL= " + driver.getCurrentUrl());
	 
//	 String sHardwareH2 = ProductCatalogPage.lblHardware(driver).getText();
//	 Glob.VerifyText(sHardwareH2, "Hardware");;
	 
  //end
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
