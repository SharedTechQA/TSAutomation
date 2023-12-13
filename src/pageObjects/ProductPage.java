package pageObjects;
//package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.HomePage;


public class ProductPage {
	private static WebElement element = null;
	String sfoo = "foo";
	//public static WebElement txtFirstName(WebDriver driver)
	
	public static WebElement lblAdminFee(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_feeValue"));
		
	return element;
	}
	
	public static WebElement btnLogIn(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_CartBlockedLink"));
//		#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_CartBlockedLink
		
		return element;
	}
	
	public static WebElement btnTopLogIn(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_outOfStockPanel"));
//		#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_CartBlockedLink
		
		return element;
	}
	public static WebElement lnkDonorPartner (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(1) > a"));
		
	return element;
	
	}
	public static WebElement lblPartner (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(1) > span.prod-value"));
		
	return element;
	}
	
	public static WebElement lblPlatform (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(2) > span.prod-value"));
	
	return element;
	}
	
	public static WebElement lblFormat (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value"));
		//#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value
		//		#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value > span	
//		#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value
	return element;
	}
	
	public static WebElement lblBoostTxt (WebDriver driver) {
		//element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value > div"));
		
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > dd:nth-child(2) > a"));
		
		//#productSummary > div > div.row.imagecontainer > div > span > dl > dd:nth-child(2) > a
		//#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value > div > span

	return element;
	}
	//#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value > div > span
	
	public static WebElement lnkGetItWithBoost (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > dd:nth-child(2) > a"));
		//#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(3) > span.prod-value > div > span

	return element;
	}
	
	
	public static WebElement lblProductID (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(4) > span.prod-value"));
		
	return element;
	}

	public static WebElement lblAvailability (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productSummary > div > div.row.imagecontainer > div > span > dl > ul > li:nth-child(5) > span.prod-value"));
	
	return element;
	}
	
	
	public static WebElement btnAddToCart(WebDriver driver) {
		
		//qa and stage
		element = driver.findElement(By.cssSelector("#AddProducts")); //QA tag
		
		return element;
	}
	
public static WebElement btnUpgradeToBoost(WebDriver driver) {
		
		//qa and stage
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_CartBlockedLink")); //QA tag
		
		
		return element;
	}
	public static WebElement btnLoginToAdd(WebDriver driver) {
		//element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_AddToCartButton"));
		
		//qa and stage
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_CartBlockedLink")); //QA tag
		
		//#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_CartBlockedLink
		
		return element;
	}
	
	public static WebElement lnkDescription (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productInfo > nav > div > ul > li.active.col-sm-3.col-md-4.text-wrap > a"));
		//#productInfo > nav > div > ul > li.col-sm-3.col-md-4.text-wrap > a
		
	return element;
	}

		
	
	//content
	public static WebElement cntDetails (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productInfo > div"));
		//#productInfo > nav > div > ul > li.col-sm-3.col-md-4.text-wrap > a
		
		
	return element;
	
	}

	public static WebElement lnkDetails (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productInfo > nav > div > ul > li.col-sm-4.text-wrap > a"));
	
	return element;
	}

	public static WebElement lnkRules (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#productInfo > nav > div > ul > li.col-sm-5.col-md-4.text-wrap > a"));
		
//		#productInfo > nav > div > ul > li.col-sm-5.col-md-4.text-wrap > a
	
	return element;

	}

	public static WebElement lblRelatedContent (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_containerRightWebPart > div > h2"));
		//#DeltaPlaceHolderMain > div.ng-scope > aside > div > h2  **changed after stage but with flags.
		//*[@id="DeltaPlaceHolderMain"]/div[1]/aside
		//*[@id="ctl00_PlaceHolderMain_containerRightWebPart"]/div/h2
		
	return element;

	}
	//#olProdResults > li:nth-child(10) > a > figure > div > img.cat_coupon
	
	public static WebElement tabRelatedContentItem1 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_RelatedArticles_ResultsListView_ctrl0_block > a > div > p"));
//		#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > small
//		#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
//		#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p"));
//		#ctl00_PlaceHolderMain_RelatedArticles_ResultsListView_ctrl0_block > a > div > p	
		//css selector","selector":"#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p	
		//#ctl00_PlaceHolderMain_RelatedArticles_ResultsListView_ctrl0_block > a > div > p
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;

	}	

	public static WebElement tabRelatedProductItem1 (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#relatedproducts > div > div > li.related-product.slick-slide.slick-current.slick-active > a > figure"));
		//#relatedproducts > div > div > li.related-product.slick-slide.slick-current.slick-active > a > figure
		//#ctl00_PlaceHolderMain_RelatedArticles_ResultsListView_ctrl0_block > a > div > p
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;

	}	
	
	//#DeltaPlaceHolderMain > div.ng-scope > aside > div > h2
	
	public static WebElement txtQuantity (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_QuantityBox"));
//		#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_QuantityBox
		//#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_QuantityBox
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;

	}	
	
	public static WebElement dlgHDW (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-header.header-backcolor > h2"));
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;
	
	}	
	
	public static WebElement btnDismiss (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#save-closetab > span"));
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;
	
	}	
	
	public static WebElement btnSeeAll (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ProductListingDiv > section > div > div:nth-child(1) > div.view-more-pos > div > a"));
		
		return element;
	}
	
	public static WebElement btnFirstCard (WebDriver driver) {
//		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ProductsSubList_ProductList_ctrl0_ctl00_ctrl0_block > a > div > h4.prod-title"));
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ProductsSubList_ProductList_ctrl0_ctl00_ctrl0_block > a > div"));
		return element;
	}
	
	//Shipment Questionnaire
}

		
