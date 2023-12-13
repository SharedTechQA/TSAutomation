package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MajorMarketsPage {
	private static WebElement element = null;
	static WebDriver driver;
	
	public static WebElement txtYourName (WebDriver driver) {
		element =driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtFirstName"));
//		#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_txtFirstName
		return element;
	}
	
	public static WebElement txtAreaCode (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_AreaCode"));
		
		return element;
	}
	
	public static WebElement txtPefix (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_PhoneNumber"));
		
		return element;
	}
	
	public static WebElement txtNumber (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_Extension"));
		
		return element;
	}
	
	public static WebElement lstNumberOfLocations (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_LocationNumber"));
		
		return element;
	}
	
	public static WebElement btnRequestMulti (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Editmodepanel2_ctl00_BtnFormSubmit"));
		
		return element;
	}
	
	
	
}
