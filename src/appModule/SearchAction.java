package appModule;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.searchPage;

public class SearchAction {

	  
	public static void Search(WebDriver driver, String sSearchTerm, String sResults, String sShowing, String sInstead) {
		// TODO Auto-generated method stub

		
		
//		System.out.println("Searching for " + sSearchTerm);
		HomePage.btn_Search(driver).click();
		HomePage.txt_Search(driver).clear();
		HomePage.txt_Search(driver).sendKeys(sSearchTerm);
		HomePage.btn_SearchforTxt(driver).click();
		searchPage.tab_Products(driver).click();
		
		String sNumProducts2 = searchPage.tab_productCountTotal(driver).getText();
		System.out.println("Records returned for:  " + sSearchTerm + " was " + sNumProducts2);		
		//assertEquals(sNumProducts2, sResults);
		Glob.VerifyText(sNumProducts2, sResults);
		
		if (sShowing != null) {
		//number of records returned

		String sShowingFor = searchPage.lstShowingResultsFor(driver).getText();
		//showing results for
		System.out.println("Showing Results for :  " + sShowing);		
		assertEquals(sShowingFor, sShowing);
		String sInsteadFor = searchPage.lstSearchInsteadFor(driver).getText();
		//instead term
		System.out.println("Search instead for for:  " + sInsteadFor);		
				Assert.assertEquals(sInsteadFor, sInstead);
				//assertEquals(actual, expected, message);
		}
		
		}
	public static void Search(WebDriver driver, String sSearchTerm) {
		// TODO Auto-generated method stub

		
		
//		System.out.println("Searching for " + sSearchTerm);
		HomePage.btn_Search(driver).click();
		HomePage.txt_Search(driver).clear();
		HomePage.txt_Search(driver).sendKeys(sSearchTerm);
		HomePage.btn_SearchforTxt(driver).click();
		
	}
	
	public static void Search(WebDriver driver, String sSearchTerm, String sResults, String sExpected) {
		// TODO Auto-generated method stub

		
		
		System.out.println("Searching for " + sSearchTerm);
		HomePage.btn_Search(driver).click();
		HomePage.txt_Search(driver).sendKeys(sSearchTerm);
		HomePage.btn_SearchforTxt(driver).click();
		searchPage.tab_Products(driver).click();
	
		String sNumProducts2 = searchPage.tab_productCountTotal(driver).getText();
		System.out.println("Records returned for:  " + sSearchTerm + " was " + sNumProducts2);		
		//assertEquals(sNumProducts2, sResults);
		Glob.VerifyText(sNumProducts2, sResults);
		
		System.out.println("Got: " +searchPage.txtFlag(driver).getAttribute("alt"));
		String sFound = searchPage.txtFlag(driver).getAttribute("alt");
		Assert.assertEquals(sFound, sExpected);
		
	}

}
