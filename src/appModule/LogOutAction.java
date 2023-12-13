/*********************************************************************
 * LogoutAction.java
 * Area for logout related methods.
 * not sure if we should adapt this overall method, or methods in the page file
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package appModule;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.logInPage;
import pageObjects.MobileHomePage;

public class LogOutAction {

	public static void execute(WebDriver driver, Boolean bMobile) {
		//System.out.println("logging out");
		driver.get(Glob.gsUrl);
		
		if (!bMobile) {
			if (HomePage.btn_MyAccount(driver).isEnabled())	{	
					HomePage.btn_MyAccount(driver).click();
					HomePage.btn_LogOut(driver).click();
			}else {
				driver.get(Glob.gsUrl);
				HomePage.btn_MyAccount(driver).click();
				HomePage.btn_LogOut(driver).click();
			}
		}
		else {
			driver.get(Glob.gsUrl);
			MobileHomePage.mnuHamburger(driver).click();
			MobileHomePage.btnLogOut(driver).click();
		}
	}

	
	public static void executeMobile (WebDriver driver) {
		System.out.println("mobile logout");
		driver.get(Glob.gsUrl);
		MobileHomePage.mnuHamburger(driver).click();
		MobileHomePage.btnLogOut(driver).click();
	}

}
