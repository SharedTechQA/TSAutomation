package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class MobileHomePage {
	private static WebElement element = null;
	static WebDriver driver;
	
	
	public static WebElement mnuHamburger(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#page-header > nav > div > button"));  
	
		return element;
	}
	
	//cart
	public static WebElement lnkCart(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#cartNum"));  
	
		return element;
	}
	
	public static WebElement btnLogin(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#SignInID"));  
	
		return element;
	}
	
	public static WebElement btnJoin(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#JoinInID"));  
	
		return element;
	}
	
	public static WebElement btnMyAccount(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#myAccount"));  
	
		return element;
	}
	
	public static WebElement btnLogOut(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#signOut"));  
	
		return element;
	}
	
	//#signOut #myAccount
	
	
	public static WebElement lnkProdCatalog(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navDonation > a"));  
	
		return element;
	}
	
	public static WebElement mnuServices(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > a"));  
	
		return element;
	}
	
	public static WebElement mnuCommunity(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navCommunity > a"));
		
		return element;
	}
	
	public static WebElement mnuResources(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navResources > a"));
		
		return element;
	}
	
	public static WebElement miArticlesAndHowTos(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navResources > ul > li:nth-child(1) > a"));
		
		return element;
	}
	
	
	public static WebElement lnkBoost(WebDriver driver) {
		//element = driver.findElement(By.cssSelector("#boostOffer > a"));
		element = driver.findElement(By.cssSelector("#boostOffer"));
		
		//#boostOffer
		return element;
	}

	public static WebElement lnkCloud(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#cloudOffer"));
		
		return element;
	}
	
	
	//#navResources > ul > li:nth-child(1) > a
	
	public static WebElement lnkHelp(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navHelp > a"));
		
		
		
		return element;
	}
	
	
}
