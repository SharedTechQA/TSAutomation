package pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//package PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import appModule.Glob;
import pageObjects.HomePage;

public class ContactUs {

	private static WebElement element = null;
	static WebDriver driver;
	
	public static WebElement lstSubject(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_drpSubject"));
	
		
		return element;
	}

	public static WebElement txtFirstName(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtFirstName"));
		
		return element;
	}
	public static WebElement txtLastName(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtLastName"));
		
		return element;
	}
	public static WebElement txtEmail(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtEmail"));
		
		return element;
	}
	public static WebElement txtAreaCode(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_AreaCode"));
		
		return element;
	}
	public static WebElement txtPrefix(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_PhoneNumber"));
		
		return element;
	}
	public static WebElement txtNumber(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_Extension"));
		
		return element;
	}
	public static WebElement chkAffiliated(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_FormPanel > div > section.form.form-horizontal > fieldset > div:nth-child(6) > div > label > span"));
		
		return element;
	}
	public static WebElement txtOrgName(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtOrganizationName"));
		
		return element;
	}
	public static WebElement txtEIN(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtEinTaxId"));
		
		return element;
	}
	public static WebElement txtOrderNumber(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtOrderNumber"));
		
		return element;
	}
	public static WebElement txtMessage(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtMessage"));
		
		return element;
	}
	public static WebElement cmdSendEmail(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_BtnFormSubmit"));
		
		return element;
	}
	
	public static WebElement lblForgotFields(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_rfvTask"));
		
		return element;
	}
	
	

	//************Methods********//
	
	public static void ContactForm (WebDriver driver, String sSubject, String sFirstName, String sLastName, String sEmailAddress, String sOrganization, String sEIN, String sOrderNum, String sMessage) throws InterruptedException {
		//System.out.println("in the contact us method");
		ContactUs.lstSubject(driver).sendKeys(sSubject);
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtFirstName"));
		txtFirstName(driver).sendKeys(sFirstName);
		ContactUs.txtLastName(driver).sendKeys(sLastName);
		ContactUs.txtEmail(driver).sendKeys(sEmailAddress);
		ContactUs.txtAreaCode(driver).sendKeys("415");
		ContactUs.txtPrefix(driver).sendKeys("555");
		ContactUs.txtNumber(driver).sendKeys("1212");
		//leave affiliated for now as selected
		ContactUs.txtOrgName(driver).sendKeys(sOrganization);
		ContactUs.txtEIN(driver).sendKeys(sEIN);
		ContactUs.txtOrderNumber(driver).sendKeys(sOrderNum);
		ContactUs.txtMessage(driver).sendKeys(sMessage);
		ContactUs.cmdSendEmail(driver).click();
		String sError = lblForgotFields(driver).getText();
		if (sError.equals("You forgot required fields. Please fill in the missing fields before submitting the form again. Thanks!")) {
			System.out.println("got this, check pass/fail value:   " + sError);
		}else {
			System.out.println("success" + sError);
		}
		
		
	}
}
