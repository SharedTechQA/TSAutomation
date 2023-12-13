package automationFramework;
import org.openqa.selenium.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

//import tsGlob;

import java.util.concurrent.TimeUnit;

import appModule.Glob;
import pageObjects.searchPage;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TSFullCatalog {
	  //private static WebDriver driver = null;
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  private static WebDriver driver = null;
	  
	  String sTestClass = "TSFullCatalog";
  @Test(groups={"smoke"})
  public void TS_VerifyCatalog() {
	
	//HomePage.btnCloseModal(driver).click(); 
	//System.out.println(driver.getCurrentUrl());
	System.out.println(Glob.gsEnv);
	//ProductCatalogPage.lnkBrowseFull(driver).click();
	Glob.loadFullCatalog();
	
		searchPage.lnkFormat(driver).click();
		String sExpectedFormat = "Download (161)\n" + 
				"DVD-ROM (2)\n" + 
				"DVD-ROM and Book (3)\n" + 
				"Hardware (113)\n" + 
				"In-person (1)\n" + 
				"License (17)\n" + 
				"License only (45)\n" + 
				"Online (97)\n" + 
				"Online and telephone (1)\n" + 
				"Phone (1)\n" + 
				"Service (7)\n" + 
				"Telephone and download (1)\n" + 
				"Telephone and email (1)";
		String sformatTxt = searchPage.lstContents(driver).getText();
		System.out.println("Verifying FORMAT VALUES");
		Glob.VerifyText(sformatTxt, sExpectedFormat);
		//Assert.assertEquals(sformatTxt, sExpectedFormat);   ***
			
		searchPage.lnkPartner(driver).click();
		String spartnerTxt = searchPage.lstContents(driver).getText();
		
		System.out.println("PARTNER VALUES: " + spartnerTxt);
		
		searchPage.lnkPlatform(driver).click();
		String splatformTxt = searchPage.lstContents(driver).getText();
		
		System.out.println("PLATFORM VALUES: " + splatformTxt);
		

		searchPage.lnkCategory(driver).click();
		String scategoryTxt = searchPage.lstContents(driver).getText();
		
		System.out.println("Category VALUES: " + scategoryTxt);
		
	
		
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

