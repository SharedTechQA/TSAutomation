/*********************************************************************
 * LoginAction.java
 * Area for login related methods.
 * not sure if we should adapt this overall method, or methods in the page file
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package appModule;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.logInPage;
import pageObjects.MobileHomePage;


public class LoginAction {
	public static WebDriver driver;

	public static void login(WebDriver driver, String sEmail, String sPassword, Boolean bMobile) throws InterruptedException {
		// TODO Auto-generated method stub
		String sLoginHeader = "TechSoup Home";//Donations and Discounts for Your Nonprofit//Explore Our Nonprofit Tech Marketplace
		
		String sFoundHeader;

		if (!bMobile) {
		
			//if (driver.getCurrentUrl()=="https://www-qa.techsoup.org/Login?ReturnUrl=https://www-qa.techsoup.org/") {
			if  (driver.getCurrentUrl().contains("Login?")) {
				
				logInPage.txtEmail(driver).click();
				logInPage.txtEmail(driver).clear();
				
				logInPage.txtEmail(driver).sendKeys(sEmail);
							
				logInPage.txtPassword(driver).sendKeys(sPassword);
				logInPage.btnLogin(driver).click();
//				System.out.println("if " + driver.getCurrentUrl());
//				
//				sFoundHeader = HomePage.lblHomePageHeader(driver).getText();
//				assertEquals(sFoundHeader, sLoginHeader);
			}else {
				HomePage.btn_Login(driver).click();
				
				logInPage.txtEmail(driver).click();
				logInPage.txtEmail(driver).clear();
				
				logInPage.txtEmail(driver).sendKeys(sEmail);
							
				logInPage.txtPassword(driver).sendKeys(sPassword);
				logInPage.btnLogin(driver).click();
//		matt commented out for forums test
				//System.out.println(driver.getCurrentUrl());
//				System.out.println("Else " + driver.getCurrentUrl());
//				sFoundHeader = HomePage.lblHomePageHeader(driver).getText();
//				assertEquals(sFoundHeader, sLoginHeader);
			}

			
			
		}
		else {
			//System.out.println("in the mobile login");
			MobileHomePage.mnuHamburger(driver).click();
			MobileHomePage.btnLogin(driver).click();

			logInPage.txtEmail(driver).sendKeys(sEmail);
			logInPage.txtPassword(driver).sendKeys(sPassword);
			logInPage.btnLogin(driver).click();
			sFoundHeader = HomePage.lblHomePageHeader(driver).getText();
			assertEquals(sFoundHeader, sLoginHeader);
//			if (sFoundHeader.equals(sLoginHeader)){
//				System.out.println("login success.  Header for page is: " + sFoundHeader);
//				}
		}
			

	}
//public static class LogOutAction {
//
//		public static void execute(WebDriver driver) {
//			// TODO Auto-generated method stub
//			HomePage.btn_MyAccount(driver).click();
//			HomePage.btn_LogOut(driver).click();
//		}
//	}

//handled above with if else.
public static void mobileLogin(WebDriver driver, String sEmail, String sPassword) {
	// TODO Auto-generated method stub
	
	
	MobileHomePage.mnuHamburger(driver).click();
	MobileHomePage.btnLogin(driver).click();

	logInPage.txtEmail(driver).sendKeys(sEmail);
	logInPage.txtPassword(driver).sendKeys(sPassword);
	logInPage.btnLogin(driver).click();
}
}