package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.MyAccountPage;


public class MemberDetailsPage {
	private static WebElement element = null;
	
	//vrs
	public static String sFirstName = "Main QA Automation user";
	public static String sLastName = "Main QA Automation user";
	public static String sSecurityQuestion;
	public static String sSecurityAnswer;
	
	public static WebElement txtFirstName(WebDriver driver) { 
		//prod
	//element =  driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_6a32f33b_2a95_45ab_98b1_475bb33d9928_ctl00_FirstName"));
		element = driver.findElement(By.xpath("//input[@tabindex= 1][@class='form-control']"));//contains(text(), 'ct100_FirstName')]"));
		//*[@id="ctl00_SPWebPartManager1_g_6a32f33b_2a95_45ab_98b1_475bb33d9928_ctl00_FirstName"]
	return element;
	}
	
	public static WebElement txtLastName(WebDriver driver) { 
		element = driver.findElement(By.xpath("//input[@tabindex= 2][@class='form-control']"));
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_LastName"));
	//	#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_LastName
		//#ctl00_SPWebPartManager1_g_6a32f33b_2a95_45ab_98b1_475bb33d9928_ctl00_LastName
	return element;
	}
	
	public static WebElement txtEmailAddress(WebDriver driver) { 
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_Email"));
		element = driver.findElement(By.xpath("//input[@tabindex= 3][@class='form-control']"));
		
	return element;
	}
	
	public static WebElement txtConfirmEmailAddress(WebDriver driver) { 
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_ConfirmEmail"));
		element = driver.findElement(By.xpath("//input[@tabindex= 4][@class='form-control']"));
		
	return element;
	}
	
	public static WebElement txtSecurityQuestion(WebDriver driver) { 
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_SecurityQuestion"));
		element = driver.findElement(By.xpath("//input[@tabindex= 8][@class='form-control']"));
		
	return element;
	}
	
	public static WebElement txtSecurityAnswer(WebDriver driver) { 
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_SecurityAnswer"));
		element = driver.findElement(By.xpath("//input[@tabindex= 9][@class='form-control']"));
		
	return element;
	}
	
	public static WebElement btnSave(WebDriver driver) { 
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_saveButton"));
		element = driver.findElement(By.xpath("//input[@tabindex= 9][@class='btn btn-primary btn-wide ']"));
		//#ctl00_SPWebPartManager1_g_6a32f33b_2a95_45ab_98b1_475bb33d9928_ctl00_saveButton
		//btn btn-primary btn-wide 
	return element;
	}
	
	public static WebElement btnCancel(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_00b49cdb_6495_4c52_94fb_472a4a3911c8_ctl00_cancelButton"));
		
	return element;
	}
	
	public static void  EditMember (WebDriver driver, String sFirstNameEdit, String sLastNameEdit) throws InterruptedException {
		MyAccountPage.invoke(driver);
		String sActual = MyAccountPage.lblAccountPageTitle(driver).getText();
		assertEquals(sActual, MyAccountPage.sAccountPageTitle);
		MyAccountPage.btnEditMemberDetails(driver).click();
		//
		MemberDetailsPage.txtFirstName(driver).click();
//		MemberDetailsPage.sFirstName = MemberDetailsPage.txtFirstName(driver).getAttribute("value");
		MemberDetailsPage.txtFirstName(driver).clear();
		MemberDetailsPage.txtFirstName(driver).sendKeys(sFirstNameEdit);
//		MemberDetailsPage.sLastName = MemberDetailsPage.txtLastName(driver).getAttribute("value");
		MemberDetailsPage.txtLastName(driver).clear();
		MemberDetailsPage.txtLastName(driver).sendKeys(sLastNameEdit);
		
		Thread.sleep(1000);
		
		MemberDetailsPage.btnSave(driver).click();
		MemberDetailsPage.btnSave(driver).click();
		
		Thread.sleep(2000);
		String sCurrenturl = driver.getCurrentUrl();
		System.out.println("done editing " + sCurrenturl);
		//changing email will force user to re-login
		
		if (sCurrenturl.equals(Glob.gsUrl+"my-account")) {
			System.out.println("edits Successful");
		}
		else
		{
			System.out.println("Edit fails, got " + sCurrenturl + " Expected: " + Glob.gsUrl+"my-account");
		}
		//System.out.println("vars: " + sFirstName + sLastName);
		
	}
	public static void  VerifyMember (WebDriver driver, String sFirstNameEdit, String sLastNameEdit) {
		MyAccountPage.invoke(driver);
		MyAccountPage.btnEditMemberDetails(driver).click();
		//
		MemberDetailsPage.txtFirstName(driver).click();
		MemberDetailsPage.sFirstName = MemberDetailsPage.txtFirstName(driver).getAttribute("value");
		assertEquals(sFirstName, sFirstNameEdit);
		
		MemberDetailsPage.sLastName = MemberDetailsPage.txtLastName(driver).getAttribute("value");
		assertEquals(sLastName, sLastNameEdit);

	
	}

	public static void ResetMember(WebDriver driver, String sFirst, String sLast) {
		System.out.println("post edit clean up");
		MyAccountPage.invoke(driver);
		MyAccountPage.btnEditMemberDetails(driver).click();
		//
		System.out.println("in reset member should be " + sFirstName);
		MemberDetailsPage.txtFirstName(driver).clear();
		MemberDetailsPage.txtFirstName(driver).sendKeys(sFirstName);
		MemberDetailsPage.txtLastName(driver).clear();
		MemberDetailsPage.txtLastName(driver).sendKeys(sLastName);
		

		MemberDetailsPage.btnSave(driver).click();
		
		String sCurrenturl = driver.getCurrentUrl();
		System.out.println("done cleaning up member data " + sCurrenturl);
		//changing email will force user to re-login
	  
		}
	
	//change password page declarations
	
	public static WebElement txtCurrentPassword(WebDriver driver) { 
		//element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_cce9b422_5f89_4568_a5f3_299b85e52b45_ctl00_CurrentPassword"));
	
		element = driver.findElement(By.xpath("//input[@tabindex= 6][@class='form-control']"));
	
		
	//xpath //*[@id="ctl00_SPWebPartManager1_g_f62a9763_0094_4b18_b806_49a6b24936a7_ctl00_CurrentPassword"]
		
	return element;
	}
	
	public static WebElement txtNewPassword(WebDriver driver) { 
	element = driver.findElement(By.xpath("//input[@type= 'password'][@class='form-control']"));
		
	return element;
	}
	
	public static WebElement txtConfirmPassword(WebDriver driver) { 
		element = driver.findElement(By.xpath("//input[@tabindex= 8][@class='form-control']"));
		
	return element;
	}
	
	public static WebElement btnSavePassword(WebDriver driver) { 
		element = driver.findElement(By.xpath("//input[@tabindex= 9][@value='SAVE']"));
		
	return element;
	}
	
	public static WebElement btnCancelPassword(WebDriver driver) { 
		element = driver.findElement(By.xpath("//input[@tabindex= 9][@value='Cancel']"));
		
	return element;
	}
	
	public static WebElement lblPwdTitle(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_cb0440f7_17f5_4a8c_9dee_65d98895465a > header > div > div > div > h1"));
													
		//#ctl00_SPWebPartManager1_g_cb0440f7_17f5_4a8c_9dee_65d98895465a > header > div > div > div > h1//qa
		//*[@id="ctl00_SPWebPartManager1_g_cb0440f7_17f5_4a8c_9dee_65d98895465a"]/header/div/div/div/h1
		//#ctl00_SPWebPartManager1_g_3240ee03_6242_4746_bd06_3d6dc98a01ba > header > div > div > div > h1//stage css
		
	return element;
	}
	
	public static WebElement lblSamePasswords(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_11147e3d_1d76_4993_bb10_62f3dbeeefbe_ctl00_pnlConfirmBanner > div.myprofile-confirm-banner-main-container > div"));
													
	return element;
	}
	
	public static WebElement lblPWMisMatch(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_c675dd36_f7c7_4fb7_89b5_0e2531e39d87_ctl00_PasswordCompare"));
//		#ctl00_SPWebPartManager1_g_c675dd36_f7c7_4fb7_89b5_0e2531e39d87 > div.form.container.form-horizontal.ext-mod-simple-form--changepassword > fieldset > div:nth-child(4) > div > div
//		#ctl00_SPWebPartManager1_g_c675dd36_f7c7_4fb7_89b5_0e2531e39d87 > div.form.container.form-horizontal.ext-mod-simple-form--changepassword > fieldset > div:nth-child(4) > div > div
//		#ctl00_SPWebPartManager1_g_edc26044_ae90_481a_ac8f_147fe03da261_ctl00_PasswordCompare
				//"#ctl00_SPWebPartManager1_g_11147e3d_1d76_4993_bb10_62f3dbeeefbe_ctl00_PasswordCompare"));
													
	return element;
	}
	public static WebElement lblSamePW(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_SPWebPartManager1_g_c675dd36_f7c7_4fb7_89b5_0e2531e39d87_ctl00_pnlConfirmBanner > div.myprofile-confirm-banner-main-container > div"));
//		#ctl00_SPWebPartManager1_g_edc26044_ae90_481a_ac8f_147fe03da261_ctl00_PasswordCompare
				//"#ctl00_SPWebPartManager1_g_11147e3d_1d76_4993_bb10_62f3dbeeefbe_ctl00_PasswordCompare"));
													
	return element;
	}
	//#ctl00_SPWebPartManager1_g_c675dd36_f7c7_4fb7_89b5_0e2531e39d87_ctl00_pnlConfirmBanner > div.myprofile-confirm-banner-main-container > div
	
	public static String  sPwdTitle = "Change Your Password";
	
	public static void ChangePassword(WebDriver driver, String sCurrentPassword, String sNewPassword, String sConfirmPassword) throws InterruptedException {
		//String sExpectedURL = Glob.gsUrl + "Login?ReturnUrl=%2fChangePassword";
		MyAccountPage.invoke(driver);
		MyAccountPage.btnChangePassword(driver).click();

		
			
		MemberDetailsPage.txtCurrentPassword(driver).sendKeys(sCurrentPassword, Keys.TAB, sNewPassword, Keys.TAB, sConfirmPassword);
		
		
		MemberDetailsPage.btnSavePassword(driver).click();
//		System.out.println("Change PW, click save");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);

		String  sCurrentURL = driver.getCurrentUrl();
		if (sCurrentURL.equals(Glob.gsUrl+"ChangePassword")) {  //https://www-qa.techsoup.org/ChangePassword
			System.out.println("Page is unchanged, still on pw change page");
			LogOutAction.execute(driver, Glob.gbMobile);
//			if (sCurrentPassword.equals(sNewPassword)) {
//				System.out.println("Found *** : " + MemberDetailsPage.lblSamePW(driver).getText()); 
//				LogOutAction.execute(driver, Glob.gbMobile);
//				
//			}else {
//				System.out.println("Found *** :  " + MemberDetailsPage.lblPWMisMatch(driver).getText());
//				LogOutAction.execute(driver, Glob.gbMobile);
//			}

	


			}

		}
}




