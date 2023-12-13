package pageObjects;
import org.openqa.selenium.*;

import pageObjects.HomePage;

public class logInPage {
		private static WebElement element = null;
		//static WebDriver driver;
		
	public static WebElement lblUpdateEmail(WebDriver driver) {
		element =driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_PasswordAndEmailUpdate > div"));
		
		return element;
	}
	
	public static String sUpdateEmailText = "Your updates have been saved. Log in with your new email address.";

	public static WebElement txtEmail(WebDriver driver) { 
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_UserName"));
			
			//#ctl00_PlaceHolderMain_LoginBox_login_UserName
			//#ctl00_PlaceHolderMain_LoginBox_login_UserName
	
		return element;
	}

	public static WebElement txtPassword(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_Password"));
	
	return element;
	}
	
	public static WebElement btnLogin(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_Login"));
		//#ctl00_PlaceHolderMain_LoginBox_login_Login
		//#ctl00_PlaceHolderMain_LoginBox_login_Login
	
	return element;
	}
	
	public static WebElement btnJoinTS(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div > div > div.row.row-eq-height > section:nth-child(2) > div > a"));
	
	return element;
	}

	//forgot pw
	public static WebElement lnkForgotPassword (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_lnkForgetPassword"));
		
	return element;
	}

	//forgot pw email address
	public static WebElement txtForgotPWEmail (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPForgotPasswordWebPart1_ctl00_PasswordSender_UserNameContainerID_UserName"));
		
	return element;
	}
	
	public static WebElement btnSubmitEmailAddress (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPForgotPasswordWebPart1_ctl00_PasswordSender_UserNameContainerID_SubmitButton"));
		
	return element;
	}
	
	public static WebElement txtSecurityAnswer (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_SPForgotPasswordWebPart1_ctl00_PasswordSender_QuestionContainerID_Answer"));
		
	return element;
	}
	
	public static WebElement lstError (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_vldLoginFailed"));
//		#ctl00_PlaceHolderMain_LoginBox_login_vldLoginFailed
		
	return element;
	}
	
	public static WebElement lstEmailError (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_requiredUserName"));
		
	return element;
	}
	
	public static WebElement lstPasswordError (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_LoginBox_login_requiredPassword"));
		
	return element;
	}
	
	
}
