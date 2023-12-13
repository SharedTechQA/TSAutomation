package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.HomePage;

public class ShipQuestionnaire {
	private static WebElement element = null;
	
	public static WebElement pgShipPage (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-header.header-backcolor > h2"));
		
		return element;
	}
	
	//#fsModal > div > div > div.modal-body.form.form-horizontal.container
	public static WebElement  chkYesShip(WebDriver driver) {
		element = driver.findElement(By.cssSelector("css=span.chkbox-text"));
		////*[@id="fsModal"]/div/div/div[2]/fieldset[1]/div[1]/div[1]/label/span
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;
	
	}
	
	public static WebElement chkNoAddress(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div.form-group.no-margin > div:nth-child(2) > label > span"));
													 //#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div.form-group.no-margin > div:nth-child(1) > label > span
	return element;
	}
	public static WebElement chkAddressYes(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div.form-group.no-margin > div:nth-child(1) > label > span"));
		
	return element;
	}

	public static WebElement txtAddress(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div > input"));
		
	return element;
	}

	public static WebElement txtCity(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div:nth-child(3) > div:nth-child(3) > div > input"));
		
	return element;
	}
	
	public static WebElement lstState(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div:nth-child(3) > div:nth-child(4) > div > select"));
		
	return element;
	}
	
	public static WebElement txtZip(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(2) > div:nth-child(3) > div:nth-child(4) > div > input"));
		
	return element;
	}
	
	public static WebElement chkDateYes(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(3) > div > div:nth-child(2) > label > span"));
		
	return element;
	}

	public static WebElement chkDateNo(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(3) > div > div:nth-child(4) > label > span"));
		
	return element;
	}
	
	public static WebElement lstMonth(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(3) > div > div.form-group.select-div > div > select:nth-child(1)"));
		
	return element;
	}
	
	public static WebElement lstDay(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(3) > div > div.form-group.select-div > div > select:nth-child(2)"));
		
	return element;
	}
	
	public static WebElement lstYear(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(3) > div > div.form-group.select-div > div > select:nth-child(3)"));
		
	return element;
	}
	
	public static WebElement chkPalletYes(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(5) > div > div:nth-child(1) > label > span"));
		
	return element;
	}

	public static WebElement chkPalletno(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(5) > div > div:nth-child(2) > label > span"));
		
	return element;
	}
	public static WebElement chkMultiYes(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(4) > div > div:nth-child(2) > label > span"));
		
	return element;
	}

	public static WebElement chkMultiNo(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(4) > div > div:nth-child(3) > label > span"));
		
	return element;
	}
	
	
	public static WebElement chkConfirm(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-body.form.form-horizontal.container > fieldset:nth-child(6) > div > div > label > span"));
		
	return element;
	}
	
	public static WebElement  btnCancel(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fsModal > div > div > div.modal-footer.form.form-horizontal.container > div > div > button"));
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;
	
	}
	
	public static WebElement  btnContinue(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_PopUpAddToCart"));
		//#ctl00_PlaceHolderMain_RelatedBlogs_ResultsListView_ctrl0_block > a > div > p
	
	return element;
	
	}
	
	

}