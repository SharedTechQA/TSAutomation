/*********************************************************************
 * JoinTSPage.java
 * page elements and functions for join
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class JoinTSPage {
	
	static WebDriver driver;
	private static WebElement element = null;
	
	public static void Join (WebDriver driver, boolean bMobile) {
		if (bMobile) {
			MobileHomePage.mnuHamburger(driver).click();
			MobileHomePage.btnJoin(driver).click();
		}
		else {
			
			HomePage.btn_Join(driver).click();
		}
	}
	
	public static WebElement lblTitle(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > header > div > div > div > h1"));
												     
	return element;
	}
	
	public static String sJoinPageTitle = "Enter your Information";
	
	public static WebElement txtFirstName(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_FirstName"));
												     
	return element;
	}
	
	public static WebElement lblFirstNameRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_RequiredFieldValidator1"));
												     
	return element;
	}
	
	public static String sFirstNameRequired = "Please enter your first name.";
	
	
	public static WebElement txtLastName(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_LastName"));
												     
	return element;
	}
	public static WebElement lblLastNameRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_LastNameRequired"));
												     
	return element;
	}
	public static String sLastNameRequired = "Please enter your last name.";
	
	
	public static WebElement txtEmail(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_UserName"));
												     
	return element;
	}
	public static WebElement lblEmailRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_UserNameRequired"));
												     
	return element;
	}
	public static String sEmailRequired = "Please enter your email address.";
	
	public static WebElement lblEmailInvalid(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_UserNameValidator"));
		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_UserNameValidator
	return element;
	}
	public static String sEmailInvalid = "Please enter a valid email address.";
	
	public static WebElement lblEmailEmailMatch(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_EmailCompare"));
		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_UserNameValidator
	return element;
	}
	public static String sEmailMustMatch = "The email address and confirmation email address must match.";
	
	
	
	
	
	public static WebElement txtConfirmEmail(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_Email"));
												     
	return element;
	}
	public static WebElement lblConfirmEmailRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_EmailRequired"));
												     
	return element;
	}
	public static String sConfirmEmailRequired = "Please re-enter your email address for confirmation.";
	
	
	public static WebElement txtCommunityNickname(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_TSUserName"));
												     
	return element;
	}
	public static WebElement lblCommunityNickNameRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_TSUserNameRequired"));
												     
	return element;
	}
	public static String sCommunityNickNameRequired = "Please create a community name.";
	
	public static WebElement lblCommunityNicknameText (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_Label3"));
		
		return element;
	}
	public static String sNickNameText = "This is the name that will appear if you make a post in the community forums.";
	
	public static WebElement txtPassword(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_Password"));
												     
	return element;
	}
	//*****  gone  as of 9/6/19  ******
	public static WebElement lblPasswordRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_PasswordRequired"));
												     
	return element;
	}
	public static String sPasswordRequired = "Please enter a password that meets the requirements.";
	
	
	/****** Password Section  ******
	 * error messaging changed as of 9/6/19 */
	//eight char password error
	public static WebElement lblPasswordLength(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_EightCharacters"));
		//											 //old #ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_RangePassword
													 
												     
	return element;
	}
	public static String sPasswordLength = "At least eight characters";//Please enter a password with at least eight characters.
	
	public static WebElement lblPasswordSpace(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_NoSpecialChar"));
				 //"#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_PasswordNoSpaceRegEx"));
							     
	return element;
	}
	public static String sPasswordSpace ="Doesn't include spaces, <, >, /, &, or #"; 
			//"Please enter a password that does not include spaces.";
	
	
	
	public static WebElement lblPasswordLower(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_PasswordStrengthLowerCase"));
												     
	return element;
	}
	public static String sPasswordLower = "At least one lowercase letter.";

	public static WebElement lblPasswordUpper(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_PasswordStrengthUpperCase"));
												    
	return element;
	}
	public static String sPasswordUpper = "At least one uppercase letter.";
	
	public static WebElement lblPasswordNumber(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_PasswordStrengthNumbers"));
												     
	return element;
	}
	public static String sPasswordNumber = "At least one number.";
	
	public static WebElement txtConfirmPassword(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_ConfirmPassword"));
												     
	return element;
	}
	
	
	public static WebElement lblPasswordCharacter(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_NoSpecialChar"));
													//"#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(4) > div > ul > li.EightCharacters > p"
		//		#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(4) > div > ul > li.EightCharacters > p
		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(4) > div > ul > li.OneLowercase > p
		
		//"#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_PasswordStrength"));
		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(4) > div > ul > li.EightCharacters > p
		
												     
	return element;
	}
	public static String sPasswordCharacter ="Doesn't include spaces, <, >, /, &, or #"; 
			//"Please enter a password without using spaces or these special characters: *, <, >, /, & and #.";
	
	
	public static WebElement lblConfirmPasswordRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_ConfirmPasswordRequired"));
												     
	return element;
	}
	public static String sConfirmPasswordRequired = "Please re-enter your password for confirmation. The new password and confirmation password must match.";
	
	
	public static WebElement txtSecurityQuestion(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_Question"));
												     
	return element;
	}
	public static WebElement lblSecurityQuestionRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_QuestionRequired"));
												     
	return element;
	}
	public static String sSecurityQuestionRequired = "Please create a security question.";
	
	
	
	public static WebElement txtSecurityAnswer(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_Answer"));
												     
	return element;
	}
	public static WebElement lblSecurityAnswerRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_AnswerRequired"));
												     
	return element;
	}
	public static String sAnswerRequired = "Please provide an answer to the security question.";
	
	public static WebElement chkByTheCup(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(4) > div:nth-child(2) > div > label > span"));
		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(4) > div:nth-child(2) > div > label > span
		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(2) > div > label > span	//#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(2) > div:nth-child(2) > div > label > span
												     
	return element;
	}
	
	public static WebElement chkProductAlerts(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(4) > div:nth-child(3) > div > label > span"));
//		#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(4) > div:nth-child(3) > div > label > span

		//#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(4) > div > label > span
		
	return element;
	}
	
	
	public static WebElement chkLibNewsletter(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div:nth-child(4) > div > label > span"));
												     
	return element;
	}
	
	public static WebElement chkTermsOfUse(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(3) > div > div > label > span"));
												     
	return element;
	}
	public static WebElement lblTermsRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(7) > div > label"));
	
												     
	return element;
	}
	public static String sTermsRequired = "By continuing, you agree to our Terms of Use and Privacy Policy.";
	
	
	
	public static WebElement btnContinue(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart_ctl00_ContinueButton"));
												     
	return element;
	}

	//captcha--good to verify existence of, or check box
	
	public static WebElement Captcha(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#recaptcha-anchor"));
												     
	return element;
	}
	
	
	public static WebElement chkCaptcha (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-checkmark"));
		//#recaptcha-anchor > div.recaptcha-checkbox-checkmark
		
	return element;
	}
	public static WebElement lblCaptchaRequired(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(7) > div > span > p"));
		
//					#ctl00_SPWebPartManager1_RegistrationWizardWebPart > section > fieldset:nth-child(6) > div > span > p								
	return element;
	}
	public static String sCaptchaRequired = "Please check the I'm not a robot box to continue.";
	
}

/*
System.out.println("Confirm PW Length errors Verification");
JoinTSPage.txtPassword(driver).sendKeys("xU3", Keys.TAB); //should raise one message for Eight characters //xupp3rsx //  XLOW3RSX XnumbersX
String sMatchLengthError = JoinTSPage.lblPasswordLength(driver).getText();
Glob.VerifyText(sMatchLengthError, JoinTSPage.sPasswordLength);
JoinTSPage.txtPassword(driver).clear();

*/

