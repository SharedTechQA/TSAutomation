/*********************************************************************
 * TSRescrictionCheck.java
 * 
 * basic confirmation that restrictions are working.  could be 
 * integrated with TSCheckout.java
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package automationFramework;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.cartPage;


public class TSRestrictionCheck {
	WebDriver driver = null;
	
	String sTestClass = "TSRestrictionCheck";
	
  @Test
  public void BasicRestrictionCheck() throws InterruptedException, IOException {
	  //HomePage.setEnv("Prod");
	  
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
	  //***  will need different products for each environment..so possibly parameterize
	  	  
//	  /Products/--LS-50438--MicrosoftDiscount
	   
	  String [] sProduct = {Glob.gsUrl + "Products/--G-49693--Veritas"};
	  
//	  https://www-qa.techsoup.org/products/visual-studio-test-professional-with-msdn--LS-45596--
	  String sQuantity = "5";
	  boolean bLarge = false;
	  boolean bAddress= true;
	  boolean bDate = false;
	  boolean bCreditCard = false;
	  boolean bRestriction = true;
	  String sShipping = "$0.00";
	
		for (String sproduct : sProduct) {
			
			cartPage.CheckOut(driver, sproduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
			
		}
		
		LogOutAction.execute(driver, Glob.gbMobile);
  }
  
  @Test(dataProvider = "getRestData")
  public void BasicRestrictionCheckMsft(String sProduct, String sQuantity, boolean bLarge, boolean bAddress, boolean bDate, boolean bCreditCard, boolean bRestriction, String sShipping) throws InterruptedException, IOException {
	  //HomePage.setEnv("Prod");
	  
	  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);

	  System.out.println("Verifying MSFT <=5 units restricion with: " + sQuantity + " items.");
			
	  cartPage.CheckOut(driver, sProduct, sQuantity,  bLarge, bAddress, bDate, bCreditCard, bRestriction, sShipping, false, false);
			
		
		
		LogOutAction.execute(driver, Glob.gbMobile);
  }
  
  @DataProvider
  public Object[][] getRestData(){
	  Object [][] data= new Object [5][8];



		data [0][0] = Glob.gsUrl + "products/visual-studio-test-professional-with-msdn--LS-50493--\"";
		data [0][1] =  "1";  //quantity
		data [0][2] =  false;  // large questionnaire
		data [0][3] =  false; //address
		data [0][4] =  false; //date
		data [0][5] =  false; //credit card
		data [0][6] =  true;  //restriction
		data [0][7] =  "0.00"; //shipping
	
		data [1][0] = Glob.gsUrl + "products/visual-studio-test-professional-with-msdn--LS-50493--\"";
		data [1][1] =  "2";  //quantity
		data [1][2] =  false;  // large questionnaire
		data [1][3] =  false; //address
		data [1][4] =  false; //date
		data [1][5] =  false; //credit card
		data [1][6] =  true;  //restriction
		data [1][7] =  "0.00"; //shipping
		
		data [2][0] = Glob.gsUrl + "products/visual-studio-test-professional-with-msdn--LS-50493--\"";
		data [2][1] =  "3";  //quantity
		data [2][2] =  false;  // large questionnaire
		data [2][3] =  false; //address
		data [2][4] =  false; //date
		data [2][5] =  false; //credit card
		data [2][6] =  true;  //restriction
		data [2][7] =  "0.00"; //shipping
		
		data [3][0] = Glob.gsUrl + "products/visual-studio-test-professional-with-msdn--LS-50493--\"";
		data [3][1] =  "4";  //quantity
		data [3][2] =  false;  // large questionnaire
		data [3][3] =  false; //address
		data [3][4] =  false; //date
		data [3][5] =  false; //credit card
		data [3][6] =  true;  //restriction
		data [3][7] =  "0.00"; //shipping
		
		data [4][0] = Glob.gsUrl + "Products/--G-49693--Veritas";
		data [4][1] =  "5";  //quantity
		data [4][2] =  false;  // large questionnaire
		data [4][3] =  false; //address
		data [4][4] =  false; //date
		data [4][5] =  false; //credit card
		data [4][6] =  true;  //restriction
		data [4][7] =  "0.00"; //shipping
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

