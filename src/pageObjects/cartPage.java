/*********************************************************************
 * cartPage.java
 * 
 * Element locators and methods for use with Cart functionality in TS.org
 *
 *emptycart
 *additemtocart
 *addlargeitemtocart //shipping question
 *checkout	//simple add order CC or check
 *checkoutverify  //verfify values, taxes, shipping, etc.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import appModule.Glob;
import pageObjects.HomePage;


//cart and checkout pages objects, methods, etc.

public class cartPage {

	private static WebElement element = null;
	static WebDriver driver;
	public static String sEmptyCartMessage = "You do not have any items in your cart. You must add products to your cart before completing checkout.";
	
	
	
public static WebElement lblHeader(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_UserName"));

	return element;
}
//#content > div > table > caption > h2

public static WebElement lblEmptyCart(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > div > div"));
	
	return element;
}

public static WebElement btnReturnToCart(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#page-header > nav > a"));
//	#page-header > nav > a

return element;
}



//#content > div > div
public static WebElement lblOrg(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#content > div > table > caption > h2"));

return element;
}

public static WebElement btnChangeOrg(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#content > div > table > caption > h2 > a"));

return element;
}

public static WebElement txtQuantity(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#Quan1"));
	

return element;
}

public static WebElement btnRemoveItem(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#RemoveProductLink"));
	
	return element;
}

public static WebElement lblRestriction(WebDriver driver) {
	element = driver.findElement(By.className("restrictions"));
	
	return element;
}

//#\20 \20 \20 \20 \20 \20 \20 \20 CartTableLineItemRow1 > td:nth-child(1) > div.restrictions > ul > li
public static WebElement btnClearCart(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#Clear1"));
	
	return element;
}

//had to write action for this element
public static WebElement btnContinueAgreements(WebDriver driver) {
	element = driver.findElement(By.id("Button1"));
	
	return element;
}
public static void ContinueAgreements(WebDriver driver) {
	Actions action = new Actions(driver);
	WebElement we = driver.findElement(By.cssSelector("#Button1"));
	action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector("#Button1"))).click().build().perform();
}

public static WebElement btnGoBack(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutControl0_butPrevious"));
	
	return element;
}

//agreements

public static WebElement lnkPrintThisPage(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > section > div > a"));
	
	return element;
}

public static WebElement chkIAgree(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > section > section > div > div.checkbox.ng-scope > label > strong"));
	//#content > section > section > div > div.checkbox.ng-scope > label > strong
	//#content > section > section > div > div:nth-child(1) > label > strong
	//#content > section > section > div > div:nth-child(2) > label > strong
	return element;
	
}

public static WebElement chkIAgree2(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > section > section > div > div:nth-child(2) > label > strong"));
	//#content > section > section > div > div:nth-child(2) > label > strong
	
	return element;
}
public static WebElement formAgreements(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > section > section > div"));
	
	return element;
	
}

public static WebElement txtAgreement(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > section > section > div > div.checkbox.ng-scope > label > p:nth-child(1) > span > p"));
	//#content > section > section > div > div.checkbox.ng-scope > label > p:nth-child(1) > span > p
	return element;
	
}


public static WebElement txtNoAgreements(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > section > section > div > div.checkbox.ng-scope > p:nth-child(1)"));
	//#content > section > section > div > div.checkbox.ng-scope > label > p:nth-child(1) > span > p
	return element;
	
}

public static String sNoAgreements = "There are no agreements necessary for the donations you�ve requested.";


public static WebElement btnContinue (WebDriver driver) {
//	element = driver.findElement(By.cssSelector("#PassDataToBill"));
	element = driver.findElement(By.xpath("//*[@id='PassDataToBill']"));
	
	//*[@id="PassDataToBill"]
	return element;
}

//shipping information page
public static WebElement txtFirstName (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#txtFirstNameAjs"));
	
	return element;
}

public static WebElement txtLastName (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#txtLastNameAjs"));
	
	return element;
}

public static WebElement btnChangeEmail(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > section > div > fieldset:nth-child(4) > a"));
	
	return element;
}

//shipping speeds
public static WebElement rdoGround(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > section > div > fieldset:nth-child(2) > div:nth-child(3) > label"));
	
	return element;
}

public static WebElement rdoThirdBusinessDay(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#userCheck1"));
	
	return element;
}

public static WebElement rdoSecondBusinessDay(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#userCheck2"));
	//card #card-type
	return element;
}

public static WebElement rdoNextBusinessDay(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#userCheck3"));
	
	return element;
}

public static WebElement lblAddress(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > section > div > fieldset:nth-child(3) > em > div"));
//	#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > section > div > fieldset:nth-child(3) > em
//	#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > section > div > fieldset:nth-child(3) > em > div
//	
	return element;
}




//#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > section > div > fieldset:nth-child(2) > div:nth-child(4) > label
public static WebElement btnPlaceOrder(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#update"));
	
	
	return element;
}
public static WebElement btnApply(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > div.ng-scope > section.container > div.row.form.form-inline > div:nth-child(2) > fieldset > div > input.btn.btn-white"));
	
//			+ "#content > div > div.form.form-inline.pull-left > fieldset > div > input.btn.btn-white"));
//	#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutFlowTable > tbody > tr > td > div.ng-scope > section.container > div.row.form.form-inline > div:nth-child(2) > fieldset > div > input.btn.btn-white
	return element;
}


public static WebElement btnUpdateTotals(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > div > div.pull-right-nonxs > input.btn.btn-white.btn-xs-full-width.spacebetbutt"));
	
	return element;
}

//payment
public static WebElement rdoMailACheck(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#mailACheck"));
//	div.radio:nth-child(3) > label:nth-child(1)
	
	return element;
}

public static WebElement rdoCreditCard(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#creditCard"));
		
	return element;
}

public static WebElement rdoACHPayment(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#eCheck")); // "#pnlpaymenttypes > fieldset > div:nth-child(2) > label > strong"));

	return element;
}
public static WebElement rdoNOACHPayment(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#pnlpaymenttypes > fieldset > div.radio.disableEcheck"));
	
	return element;
}

public static WebElement rdoChecking(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#checking"));
//	#shwec > div:nth-child(2) > div > fieldset > div:nth-child(1) > label
	
	return element;
}

public static WebElement rdoSavings(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#savings"));
//	#savings
	
	return element;
}

public static WebElement rdoBusiness(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#business"));
	//#shwec > div:nth-child(3) > div > fieldset > div:nth-child(1) > label
	
	return element;
}

public static WebElement rdoPersonal(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#personal"));
	
	return element;
}
public static WebElement txtAchAccount(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#accountNumber"));
	
	return element;
}

public static WebElement txtAchRouting(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#routingNumber"));
	
	return element;
}

public static WebElement txtBusinessName(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#businessName"));
	
	return element;
}

public static WebElement txtAchFirstName(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#firstName"));
	
	return element;
}

public static WebElement txtAchLastName(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#lastName"));
	
	return element;
}

public static WebElement txtACHStreetAddress (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#streetAddress"));
	
	return element;
}

public static WebElement txtACHAddress2 (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#addressLine2"));
	
	return element;
}

public static WebElement txtACHCity (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#city"));
	
	return element;
}

public static WebElement lstACHState (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#state"));
	
	return element;
}

public static WebElement txtACHZipCode (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#zip"));
	
	return element;
}



public static WebElement lblACHError (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#subtext"));  //"#subtext > div > span > strong"));
	
	
	return element;
}

//#subtext > div > span > strong

public static WebElement lblRoutingError (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#shwec > div:nth-child(5) > div.control-input > div.text-danger"));
//	#shwec > div:nth-child(5) > div.control-input > div.text-danger > div
//	#shwec > div:nth-child(5) > div.control-input > div.text-danger
	return element;
}
//#shwec > div:nth-child(5) > div.control-input > div.text-danger > div
//For ACH/Electronic Check payments
public static WebElement btnPayACH(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#submitECbtn"));
	//from edit order ***#submit //create order #submitbtn
	
	return element;
}

public static WebElement btnCheckout(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#btnchkout"));
	
	return element;
}

public static WebElement txtPromoCode(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPCheckoutWebPart1_ctl00_CheckoutControl2_PromoCode"));
	
	return element;
}

public static WebElement txtCardNumber(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#cardNumber"));
	
	return element;
}

public static WebElement txtExpirationMonth(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#expmonth"));
	
	return element;
}

public static WebElement txtExpirationYear(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#expyear"));
	
	return element;
}

public static WebElement txtCVV(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#cvc"));
	
	return element;
}

public static WebElement txtZipCode (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#zipCode"));
	
	return element;
}



//subscription
public static WebElement rdoPayAutomatically(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#payAuto"));
	
	return element;
}

public static WebElement rdoAskForPayment(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#payManual"));
	
	return element;
}
//For Credit card payments
public static WebElement btnPayWithCard(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#submitbtn"));
	
	return element;
}

public static WebElement dlgRecurringTerms(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#budgetLabel"));
	
	return element;
}

public static WebElement txtRecurringTermsText(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#modalRecurring > div > div > div.modal-body"));
	
	return element;
}

/***************  empty cart page items  *******************/
public static WebElement msgEmptyCart(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > div > div > p"));
	
	return element;
}

public static WebElement btnFindMoreProducts(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#content > div > a"));
	
	return element;
}

/******************* Summary Line Items **************************/

public static WebElement lblSubTotal(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#SubTotalTopValue"));
	
	
	return element;
}

public static WebElement lblTotal(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#GrandTotalAmount"));//"#td:nth-child(5)"));
//	#GrandTotalAmount
//	#td:nth-child(5)

	
	return element;
}

//*[@id="CartTableLineItemRow1"]/td[5]

public static WebElement lblSalesTax(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#TaxTotalAmount"));
	
	return element;
}

public static WebElement lblShipping(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ShippingGrandTotalAmount"));
	
	return element;
}

public static WebElement lblTotalDue(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#GrandTotalAmount"));
	
	return element;
}

public static WebElement lblDiscount(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#divMainCtl > table > tfoot > tr > td > dl > dt:nth-child(4)"));
	
	return element;
}

public static WebElement lblDiscountAlert(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#divMainCtl > table > tfoot > tr > td > dl > dd:nth-child(5)"));
	//element = driver.findElement(By.xpath("//*[@id='divMainCtl']/table/tfoot/tr/td/dl/dd[2]/text()"));
	
	return element;
}

/******  Methods for Cart Related stuff  ******/

public static void EmptyCart (WebDriver driver) {
	HomePage.lnk_Cart(driver).click();
	int f = driver.findElements(By.cssSelector("#content > div > div > p")).size();
	//)lblEmptyCart(driver).size
	if (f > 0) {
		System.out.println("cart is empty");
	} 
	else {
		cartPage.btnClearCart(driver).click();
		System.out.println("cart is being emptied");
	}
}
//multi items
public static void AddMultiItemsToCart (WebDriver driver, String sProducts, String sQuantity ) throws InterruptedException {
//	EmptyCart(driver);
	System.out.println("add item to cart function, adding " + sProducts);
	
	
	driver.get(sProducts);
//	JavascriptExecutor je = (JavascriptExecutor) driver;
	if (Glob.gbMobile) {
		((JavascriptExecutor)driver).executeScript("scroll(0,350)");
		ProductPage.txtQuantity(driver).click();
		ProductPage.txtQuantity(driver).clear();
		ProductPage.txtQuantity(driver).sendKeys(sQuantity);
		ProductPage.btnAddToCart(driver).click();
		ProductPage.btnAddToCart(driver).click();
		System.out.println("adding: "+sProducts+ " to cart");
	}
	else {
		if (sQuantity.equals("0")) {//Purchasing boost is the only place i know of so far where quantity will be zero
			ProductPage.btnUpgradeToBoost(driver).click();
			BoostSignUpPage.btnUpgradeToBoost(driver).click();
				
		}else {
		ProductPage.txtQuantity(driver).clear();
		ProductPage.txtQuantity(driver).sendKeys(sQuantity);
		ProductPage.btnAddToCart(driver).click();
		System.out.println("adding: "+sProducts+ " to cart");

	
	  
		}
	}
	}

public static void AddItemToCart (WebDriver driver, String sProduct, String sQuantity ) throws InterruptedException {
	EmptyCart(driver);
	System.out.println("add item to cart function, adding " + sProduct);
	
	
	driver.get(sProduct);
//	JavascriptExecutor je = (JavascriptExecutor) driver;
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
			Thread.sleep(2000);
		ProductPage.txtQuantity(driver).clear();
		ProductPage.txtQuantity(driver).sendKeys(sQuantity);
		ProductPage.btnAddToCart(driver).click();
		System.out.println("adding: "+sProduct+ " to cart");

	
	  
		}
	}
	}

/**************overloaded CSP add to cart********************/

public static void AddItemToCart (WebDriver driver, boolean bCSP, String sDomainName, String sProduct, String sQuantity, boolean bCustom ) throws InterruptedException {
	EmptyCart(driver);
	System.out.println("add item to cart function, adding " + sProduct);
	
	
	driver.get(sProduct);
//	JavascriptExecutor je = (JavascriptExecutor) driver;
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
		if (bCSP && bCustom) {
			CSPDomainPage.btnDomainToggle(driver).click();
			CSPDomainPage.txtCustomDomainName(driver).sendKeys(sDomainName);
			CSPDomainPage.btnUseThisCustomDomain(driver).click();
		}else {
			CSPDomainPage.txtDomainName(driver).sendKeys(sDomainName);
			CSPDomainPage.btnUseThisDomain(driver).click();
			
		}

	
	  
		}
	}
	}

public static void AddLargeItemToCart (WebDriver driver, String sProduct, String sQuantity, Boolean bAddress, Boolean bDate ) throws IOException, InterruptedException {
	EmptyCart(driver);
	System.out.println("add LARGE item to cart function, adding " + sProduct);
	
	
	driver.get(sProduct);
	if (Glob.gbMobile) {
		((JavascriptExecutor)driver).executeScript("scroll(0,350)");
		ProductPage.txtQuantity(driver).click();
		ProductPage.txtQuantity(driver).clear();
		ProductPage.txtQuantity(driver).sendKeys(sQuantity);
		ProductPage.btnAddToCart(driver).click();
		ProductPage.btnAddToCart(driver).click();
		System.out.println("adding: "+sProduct+ " to cart");
		ShipQuestionnaire.chkAddressYes(driver).click();
		ShipQuestionnaire.chkDateNo(driver).click();
		ShipQuestionnaire.chkMultiYes(driver).click();
		ShipQuestionnaire.chkPalletYes(driver).click();
		ShipQuestionnaire.chkConfirm(driver).click();

	}
	else {
			
		ProductPage.txtQuantity(driver).clear();
		ProductPage.txtQuantity(driver).sendKeys(sQuantity);
		ProductPage.btnAddToCart(driver).click();
		System.out.println("adding: "+sProduct+ " to cart");
		if (bAddress) {
			ShipQuestionnaire.chkAddressYes(driver).click();
		}
		else {
			ShipQuestionnaire.chkNoAddress(driver).click();
			ShipQuestionnaire.txtAddress(driver).sendKeys("123 Question");
			ShipQuestionnaire.txtCity(driver).sendKeys("Seattle");
			ShipQuestionnaire.lstState(driver).sendKeys("Washington");
			ShipQuestionnaire.txtZip(driver).sendKeys("98199");
			
		}
		if (bDate) {
			ShipQuestionnaire.chkDateYes(driver).click();
			ShipQuestionnaire.lstMonth(driver).sendKeys("June");
			ShipQuestionnaire.lstDay(driver).sendKeys("15");
			ShipQuestionnaire.lstYear(driver).sendKeys("2015");
			
		}
		else {
			ShipQuestionnaire.chkDateNo(driver).click();

		}
		ShipQuestionnaire.chkMultiYes(driver).click();
		ShipQuestionnaire.chkPalletYes(driver).click();
		ShipQuestionnaire.chkConfirm(driver).click();

	}

	Glob.GetScreenShot(driver, "/output/", "Questionnaire" );
//	Glob.GetScreenShot(driver, sTestGroup+sTestClass, );
	//ShipQuestionnaire.btnCancel(driver).click();
	ShipQuestionnaire.btnContinue(driver).click();

	  
}
public static String CheckOut (WebDriver driver, String sProduct, String sQuantity, Boolean bLarge, Boolean bAddress, Boolean bDate, Boolean bCreditCard, Boolean bRestriction, String sShipping, Boolean bMSFT, Boolean bBoost  ) throws IOException, InterruptedException {
	String sOrderId = null;
//	System.out.println("checkout ");
	if (bLarge) {
		System.out.println("Adding large item from checkout");
		AddLargeItemToCart(driver, sProduct, sQuantity, bAddress, bDate);
		
		
	}
	else {
		AddItemToCart (driver, sProduct, sQuantity);
	
	//System.out.println("item added, clicking on cart icon ");
	Thread.sleep(1000);
	HomePage.lnk_Cart(driver).click();
	System.out.println("loading cart");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript ("window.scrollBy(0, 700)", "");
	Thread.sleep(1000);
	cartPage.btnCheckout(driver).click();

	int count = 0;
	count = driver.findElements(By.className("restrictions")).size();
//	System.out.println("count " + count);
	switch (count) {
		case 1:
			if (bRestriction) {
				System.out.println("***PASS-- Expected Restriction Encountered:  " + cartPage.lblRestriction(driver).getText());
				break;	
			}
			else {
				System.out.println("***Error-- Did not expect Restriction ******* " + cartPage.lblRestriction(driver).getText());
				break;
			}
		case 0:
			if (bRestriction) {
				System.out.println("**ERROR-- Expected Restriction NOT Encountered");
				break;
			}
			else {
						
	Thread.sleep(1000);
	
		cartPage.chkIAgree(driver).click();

		js.executeScript ("window.scrollBy(0, 500)", "");
		Thread.sleep(1000);
		
//		if (bMSFT) {
//		
//			cartPage.chkIAgree2(driver).click();
//		}
		
			  	  	  
		cartPage.ContinueAgreements(driver);
		  Thread.sleep(5000);
		switch (sShipping) {
		case "$0.00":
			System.out.println("Ground Shipping");
			break;
		case "$30.00":
			cartPage.rdoNextBusinessDay(driver).click();
			
			System.out.println("Physical product, Next day chosen");
			break;
		case "$20.00":
			cartPage.rdoSecondBusinessDay(driver).click();
			System.out.println("Physical product, Second day chosen");
			break;
		case "$10.00":
			cartPage.rdoThirdBusinessDay(driver).click();
			System.out.println("Physical product, Third Business day chosen");
			break;
	}
//		jse.executeScript("window.scrollBy(0,500);");					
		Thread.sleep(1000);
		
		String sAddress= cartPage.lblAddress(driver).getText();
		System.out.println("Shipping Address is: "+sAddress + " not null or code");
		//  {{elements.Line1}}
		if (sAddress.contains("{{elements.Line1}}")) {
			assertEquals(0, 1);
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000);");
		
		Thread.sleep(2000);
		cartPage.btnContinue(driver).click();
		if (!bBoost) {
			if (bCreditCard){
	//
				Thread.sleep(1000);
				
				cartPage.rdoCreditCard(driver).click();
				cartPage.txtCardNumber(driver).sendKeys(Glob.gsCreditNum);
				cartPage.txtExpirationMonth(driver).sendKeys(Glob.gsExpMo);
				cartPage.txtExpirationYear(driver).sendKeys(Glob.gsExpYr);
				cartPage.txtCVV(driver).sendKeys(Glob.gsCVV);
				cartPage.txtZipCode(driver).sendKeys("98199");
				
				Thread.sleep(1000);
				
				jse.executeScript("window.scrollBy(0,500);");
				
				Thread.sleep(1000);
				
				cartPage.btnPayWithCard(driver).click();
				
				Thread.sleep(10000);
				Glob.GetScreenShot(driver, "/CreditCard/", "CC_Orders");
				sOrderId = OrderSummary.lblOrderID(driver).getText();
				System.out.println("Created Order:  "+ sOrderId);
//				Glob.CancelOrder(sOrderId);
			}
			
			else {

				jse.executeScript("window.scrollBy(0,700);");					
				Thread.sleep(2000);
				
				
				cartPage.rdoMailACheck(driver).click();
				
				try {
				cartPage.btnPlaceOrder(driver).click();
				}
				catch (Exception e) {
				System.out.println("something went wrong.  no button click");
				
				break;
				}
				Glob.GetScreenShot(driver, "/CheckOrders/", "Check_Orders");
				Thread.sleep(4000);
				sOrderId = OrderSummary.lblOrderID(driver).getText();
				System.out.println("Created Order:  "+ sOrderId);
				
////				if (bMSFT) {
////					String sFoundButton = OrderSummary.btnConfirmEligibility(driver).getText();
//					
//					Glob.VerifyText(sFoundButton, OrderSummary.sEligiblity);
//					
//				}
		}
		Thread.sleep(5000);
		if (!bRestriction) {
			jse.executeScript("window.scrollBy(0,500);");					
			Thread.sleep(5000);
			
			Glob.CancelOrder(sOrderId);
			//return sOrderId;
		}
		
		}	
	
		
				}
			}
		}
	return sOrderId;
	}
			

public static String CheckOutVerify (WebDriver driver, String sProduct, String sQuantity, Boolean bLarge, Boolean bAddress, Boolean bDate, Boolean bCreditCard, String sTotalExpected, String sSalesTaxExpected, String sTotalDueExpected, String sShipping, String sCoupon, Boolean bMSFT) throws IOException, InterruptedException {
	String sOrderId = null;
//	System.out.println("checkout ");
	if (bLarge) {
		System.out.println("Adding large item from checkout");
		AddLargeItemToCart(driver, sProduct, sQuantity, bAddress, bDate);
		
		
	}
	else {
		AddItemToCart (driver, sProduct, sQuantity);
	
	
	
	HomePage.lnk_Cart(driver).click();
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript ("window.scrollBy(0, 350)", "");
	
	Thread.sleep(1000);
	cartPage.btnCheckout(driver).click();

	int count = driver.findElements(By.className("restrictions")).size();	 
	System.out.println("count " + count);
	if (count >=1) {
		System.out.println("restriction Encountered" + cartPage.lblRestriction(driver).getText());
		//cartPage.lblRestriction(driver).getText();
		Thread.sleep(1000);
		btnReturnToCart(driver).click();
		EmptyCart(driver);
		
	}
	else {
		int countboxes = driver.findElements(By.cssSelector("#content > section > section > div > div.checkbox.ng-scope > label > strong")).size();	 //mwr
		System.out.println("count " + countboxes);
		if (countboxes >=1) {
			//System.out.println("No restriction Encountered" + cartPage.lblRestriction(driver).getText());
			System.out.println("in the agree else");
			cartPage.chkIAgree(driver).click();
			if (bMSFT) {
				cartPage.chkIAgree2(driver).click();
				
			}
			
			cartPage.ContinueAgreements(driver);
			
		}
		//cartPage.chkIAgree(driver).click();
		else {
			cartPage.ContinueAgreements(driver);
				
		}
		
		
		switch (sShipping) {
		case "$0.00":
			System.out.println("Ground Shipping");
			break;
		case "$30.00":
			cartPage.rdoNextBusinessDay(driver).click();
			
			System.out.println("Physical product, Next day chosen");
			break;
		case "$20.00":
			cartPage.rdoSecondBusinessDay(driver).click();
			System.out.println("Physical product, Second day chosen");
			break;
		case "$10.00":
			cartPage.rdoThirdBusinessDay(driver).click();
			System.out.println("Physical product, Third Business day chosen");
			break;
	}

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
		Thread.sleep(1000);
		cartPage.btnContinue(driver).click();


}
		if (sCoupon.isEmpty()) {
			System.out.println("no Coupons");
		}
		else{
			cartPage.txtPromoCode(driver).sendKeys(sCoupon);
			cartPage.btnApply(driver).click();
		}
		
		String sSubTotalFound = lblSubTotal(driver).getText();
		Glob.VerifyText(sSubTotalFound, sTotalExpected);
		
		
		String sSalesTaxesFound = lblSalesTax(driver).getText();
		Glob.VerifyText(sSalesTaxesFound, sSalesTaxExpected);
		
		String sShippingFound = lblShipping(driver).getText();
		Glob.VerifyText(sShippingFound, sShipping);
		
		String sTotalDueFound = lblTotalDue(driver).getText();
		Glob.VerifyText(sTotalDueFound, sTotalDueExpected);
		
		if (sCoupon.isEmpty()) {
			System.out.println("no Coupons");
		}
		else {
			System.out.println("found coupon values: " + cartPage.lblDiscount(driver).getText() + " and " + cartPage.lblDiscountAlert(driver).getText());
		}
		
		if (bCreditCard){
//
			
			cartPage.rdoCreditCard(driver).click();
			cartPage.txtCardNumber(driver).sendKeys(Glob.gsCreditNum);
			cartPage.txtExpirationMonth(driver).sendKeys(Glob.gsExpMo);
			cartPage.txtExpirationYear(driver).sendKeys(Glob.gsExpYr);
			cartPage.txtCVV(driver).sendKeys(Glob.gsCVV);
			cartPage.txtZipCode(driver).sendKeys("98199");
			//cartPage.btnPayWithCard(driver).click();
			Glob.GetScreenShot(driver, "/CreditCard/", "CC_Orders");
		}
		
		else {
			cartPage.rdoMailACheck(driver).click();
		
		if (sShipping.equals("$0.00")) {
			Glob.GetScreenShot(driver, "/Checks/", "Check_Orders");
		}
		else {
			Glob.GetScreenShot(driver, "/NoOrderID/", "Verifying values order, no orderID");
			sOrderId = "shipping NO Orderid";
			
		}
		btnReturnToCart(driver).click();
		EmptyCart(driver);
		
	}
		
	}
	
	return sOrderId;
}

//***************ACH version of checkout overloaded method.***************
public static String CheckOut (WebDriver driver, String sProduct, String sQuantity, Boolean bDate, Boolean bRestriction, String sShipping, String sAchAccount, String sAchRouting, Boolean bChecking, Boolean bBusiness, String sCoupon ) throws IOException, InterruptedException {
	String sOrderId = null;
//	System.out.println("checkout ");

	//AddMultiItemsToCart (driver, sProduct, sQuantity);
	AddItemToCart (driver, sProduct, sQuantity);
	//System.out.println("item added, clicking on cart icon ");
	Thread.sleep(1000);
	HomePage.lnk_Cart(driver).click();
	System.out.println("loading cart");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript ("window.scrollBy(0, 500)", "");
	cartPage.btnCheckout(driver).click();

	int count = 0;
	count = driver.findElements(By.className("restrictions")).size();
//	System.out.println("count " + count);
	switch (count) {
		case 1:
			if (bRestriction) {
				System.out.println("***PASS-- Expected Restriction Encountered:  " + cartPage.lblRestriction(driver).getText());
				break;	
			}
			else {
				System.out.println("***Error-- Did not expect Restriction ******* " + cartPage.lblRestriction(driver).getText());
				break;
			}
		case 0:
			if (bRestriction) {
				System.out.println("**ERROR-- Expected Restriction NOT Encountered");
				break;
			}
			else {
				int countboxes = driver.findElements(By.cssSelector("#content > section > section > div > div.checkbox.ng-scope > label > strong")).size();	 //mwr
				System.out.println("rest count " + countboxes);
				if (countboxes == 1) {
					//System.out.println("No restriction Encountered" + cartPage.lblRestriction(driver).getText());
					System.out.println("in the agree else");
					cartPage.chkIAgree(driver).click();
					cartPage.ContinueAgreements(driver);
					
					}
					else if (countboxes == 2) {
						cartPage.chkIAgree(driver).click();
						cartPage.chkIAgree2(driver).click();
						js.executeScript("window.scrollBy(0,200);");
						cartPage.ContinueAgreements(driver);
						
					}
					else {
						js.executeScript("window.scrollBy(0,500);");
						Thread.sleep(1000);
					cartPage.ContinueAgreements(driver);
					}
					
				}

						
	  	  	  
//		cartPage.ContinueAgreements(driver);
		
		
		  
		switch (sShipping) {
		case "$0.00":
			System.out.println("Ground Shipping");
			break;
		case "$30.00":
			cartPage.rdoNextBusinessDay(driver).click();
			
			System.out.println("Physical product, Next day chosen");
			break;
		case "$20.00":
			cartPage.rdoSecondBusinessDay(driver).click();
			System.out.println("Physical product, Second day chosen");
			break;
		case "$10.00":
			cartPage.rdoThirdBusinessDay(driver).click();
			System.out.println("Physical product, Third Business day chosen");
			break;
	}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
		Thread.sleep(1000);
		cartPage.btnContinue(driver).click();
		
		//cartPage.rdoMailACheck(driver).click();
		if (sCoupon.isEmpty()) {
			System.out.println("no Coupons");
		}
		else{
			cartPage.txtPromoCode(driver).sendKeys(sCoupon);
			cartPage.btnApply(driver).click();
		}
		if (cartPage.rdoACHPayment(driver).isEnabled()) {
		cartPage.rdoACHPayment(driver).click();
		cartPage.txtAchAccount(driver).sendKeys(sAchAccount);
		cartPage.txtAchRouting(driver).sendKeys(sAchRouting);
		cartPage.txtAchRouting(driver).sendKeys(Keys.TAB);
		if (cartPage.lblRoutingError(driver).isDisplayed()) {
			System.out.println("Bad Routing number message displayed, intended?");
			cartPage.txtAchRouting(driver).sendKeys("011000015");
			cartPage.txtAchRouting(driver).sendKeys(Keys.TAB);
//			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//			jse.executeScript("window.scrollBy(0,500);");
			//Thread.sleep(1000);
		}
		if (bChecking) {
			jse.executeScript("window.scrollBy(0,100);");
			Thread.sleep(1000);
			cartPage.rdoChecking(driver).click();
			}else {
				cartPage.rdoSavings(driver).click();
			}
		if (bBusiness) {
			jse.executeScript("window.scrollBy(0,100);");
			Thread.sleep(1000);
			
			cartPage.rdoBusiness(driver).click();
			//uses default org address
		
			}else {
				
				jse.executeScript("window.scrollBy(0,100);");
				
				Thread.sleep(1000);
				
				cartPage.rdoPersonal(driver).click();
				cartPage.txtAchFirstName(driver).clear();
				cartPage.txtAchFirstName(driver).sendKeys("ACH QA FirstName");
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
				cartPage.txtAchLastName(driver).clear();
				cartPage.txtAchLastName(driver).sendKeys("ACH QA LastName");
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
				
				cartPage.txtACHStreetAddress(driver).sendKeys("ACH Street Address");
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
				cartPage.txtACHAddress2(driver).sendKeys("ACH Address 2");
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
				cartPage.txtACHCity(driver).sendKeys("CITYCITY");
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
				cartPage.lstACHState(driver).sendKeys("Washington");
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
				cartPage.txtACHZipCode(driver).sendKeys("98199");  //tab hack for zip code and other address fields doesn't know its entered until tab	pt-616?
				cartPage.txtACHZipCode(driver).sendKeys(Keys.TAB);
			}
		
		
		
		
		jse.executeScript("window.scrollBy(0,500);");
		Thread.sleep(1000);
		
		
		cartPage.btnPayACH(driver).click();
		}
		else if (cartPage.rdoNOACHPayment(driver).isEnabled()){
			System.out.println("*****Unable ACH*****" + cartPage.lblTotal(driver).getText());
			
//			assertTrue(false, "NO ACH...is it over 1500??");
		}
		Thread.sleep(5000);
	
		int countError = 0;
		countError = driver.findElements(By.className("panel-body")).size();

		String sCurrentPage = driver.getCurrentUrl();
//		System.out.println("page is " + sCurrentPage +" and we check "+ Glob.gsUrl + "Checkout");
		if (sCurrentPage.equals(Glob.gsUrl+"Checkout")) {
//		if (countError == 2 && cartPage.lblACHError(driver).isDisplayed()) {
			System.out.println("errors and message: " + cartPage.lblACHError(driver).getText());
			System.out.println("Error sending ACH encountered.  Verify intended result");
			Glob.GetScreenShot(driver, "/ACHOrders/", "ACH_Orders");
			break;
		}
	
		else {
			Glob.GetScreenShot(driver, "/ACHOrders/", "ACH_Orders");
			sOrderId = OrderSummary.lblOrderID(driver).getText();
			System.out.println("Created Order:  "+ sOrderId);
		}		
			Thread.sleep(5000);
			if (!bRestriction && !sCurrentPage.equals(Glob.gsUrl +"Checkout")){   // !sOrderId.equals("")) {
				Glob.CancelOrder(sOrderId);
//			return sOrderId;
		//}
		
		}
			
	
		
						
		
			
	
	
		}
	return sOrderId;
	}
}

	
	





