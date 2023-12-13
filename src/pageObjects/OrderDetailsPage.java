/*********************************************************************
 * OrderDetailsPage.java
 * 
 * Element locators and methods for use with order details page in TS.org
 *
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/
package pageObjects;

//package PageObjects;
import org.openqa.selenium.*;

import appModule.Glob;




public class OrderDetailsPage {
	private static WebElement element = null;
	static WebDriver driver;
	/********  Variables and similar data ********/
	public static String sPartialPaymentText = "We couldn't fulfill some of the items in your request. You haven't been charged for those items.";
	public static String sPartialStatus = "Partially Shipped";
	public static String sOrderBalance = "$835.00";
	public static String sItem2Status = "Pending program eligibility approval";

	
	
	public static WebElement btnCancel(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#btncanceledit"));
		

	return element;
	}
	
	public static WebElement rdoCreditCard(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#creditCard"));
		

	return element;
	}
	
	public static WebElement rdoACHPayment(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#eCheck"));
		

	return element;
	}	
	
	

	public static WebElement rdoMailACheck(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#editMailACheck"));
		

	return element;
	}

	public static WebElement rdoChecking(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#checking"));
		

	return element;
	}
	public static WebElement rdoSavings(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#savings"));
		

	return element;
	}
	
	public static WebElement rdoPersonal(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#personal"));
		

	return element;
	}

	public static WebElement rdoBusiness(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#business"));
		

	return element;
	}

	public static WebElement txtACHAccount(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#accountNumber"));
		

	return element;
	}
	
	public static WebElement txtACHRouting(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#routingNumber"));
		

	return element;
	}
	
	public static WebElement txtCreditCardNumber(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#cardNumber"));

	return element;
	}

	public static WebElement txtExireMonth(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#expmonth"));

	return element;
	}

	public static WebElement txtExpireYear(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#expyear"));

	return element;
	}
	
	public static WebElement txtCVV(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#cvc"));

	return element;
	}	
	
	public static WebElement txtZipCode(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#zipCode"));

	return element;
	}	

	public static WebElement btnEditDetails(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderDetail_editPaymentSection > div > fieldset.col-xs-12.col-lg-6.text-right.position > button:nth-child(2)"));
		
	return element;
	}	

	
	
	/******** changing to CC payment ********/
	public static WebElement btnPayWithCard(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#submit"));

	return element;
	}	

	/******** changing to Check payment ********/
	public static WebElement btnRemovePayment(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#removepay"));

	return element;
	}	

	public static WebElement btnPayACH(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#submitEC"));

	return element;
	}
	
	/******** changing to ACH payment ********/
	
	
	public static WebElement lblRequestStatus(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#OrderType"));
		//#OrderType

	return element;
	}
	
	public static WebElement lblUpdatePayment (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#subtext > div > span > strong"));
//		#subtext > div > span > strong
	return element;
	}
	
	/******** Partial Payment Details ********/
	public static WebElement lblPaymentNote(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#partialStatustext > div > span > strong"));

	return element;
	}

	public static WebElement lblOrderBalance(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#OrderBalance"));

	return element;
	}
	
	public static WebElement lblItem2Status(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_OrderDetail_ltvOrderDetail_ctrl1_OrderItemDetail_StatusCell"));

	return element;
	}
	
	public static WebElement lblPaymentMethod (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fullcontainerdiv > section:nth-child(4) > div > div:nth-child(2) > dl:nth-child(4) > dd:nth-child(4)"));
			
	return element;
		
	}
	
	public static WebElement lblPaymentStatus (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#paymentType"));
		//*[@id="paymentType"]/text()
		//#ecpaymentStatus
		
		
		
		
	return element;
		
	}
	
	
	//Modify payment information method
	public static void ModifyPayment () {
		System.out.println("Modify Payment for Existing Order " );
//		Glob.FindOrder(sOrderID);
//		driver.findElement(By.partialLinkText(sOrderID)).click();
		
//		OrderDetailsPage.lblPaymentMethod(driver).click();
//		String sPayMethod = OrderDetailsPage.lblPaymentMethod(driver).getText();
//		System.out.println("Payment Method = " + sPayMethod);
		//"Credit Card";
/*		if (OrderDetailsPage.rdoCreditCard(driver).isSelected()) {
			System.out.println("Modify Payment to Check");
			OrderDetailsPage.btnEditDetails(driver).click();
			OrderDetailsPage.rdoMailACheck(driver).click();
			OrderDetailsPage.btnRemovePayment(driver).click();
		}
		else {
			System.out.println("Modify Payment to CC");
			OrderDetailsPage.btnEditDetails(driver).click();
			OrderDetailsPage.rdoCreditCard(driver).click();
			OrderDetailsPage.txtCreditCardNumber(driver).sendKeys(Glob.gsCreditNum);
			OrderDetailsPage.txtExireMonth(driver).sendKeys(Glob.gsExpMo);
			OrderDetailsPage.txtExpireYear(driver).sendKeys(Glob.gsExpYr);
			OrderDetailsPage.txtCVV(driver).sendKeys(Glob.gsCVV);
			
			OrderDetailsPage.btnPayWithCard(driver).click();
		}
			*/
		System.out.println("Modify Payment to Check");
		OrderDetailsPage.btnCancel(driver).sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);
		System.out.println(OrderDetailsPage.lblPaymentMethod(driver).getText());
		OrderDetailsPage.btnEditDetails(driver).click();
		System.out.println("did i edit?");
		
		OrderDetailsPage.rdoMailACheck(driver).click();
		OrderDetailsPage.btnRemovePayment(driver).click();
		
	}
	
	
}
