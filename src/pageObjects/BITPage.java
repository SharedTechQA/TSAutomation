package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BITPage {
	
	private static WebElement element = null;
	static WebDriver driver;

	public static WebElement lstApplicationType(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#_ctl0_ContentPlaceHolder1_AppTypeList"));
		
		return element;
	}
	
	public static WebElement btnChooseFile(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#_ctl0_ContentPlaceHolder1_fuBatchFile"));
		
		return element;
	}
	
	public static WebElement lstImportType(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#_ctl0_ContentPlaceHolder1_ProcessTypeList"));
		
		return element;
	}
	
	public static WebElement btnUpload(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#_ctl0_ContentPlaceHolder1_btnUpload"));
		
		return element;
	}
	
	//load this page
//	http://qacognos.qa.compumentor.org/TSBatchProcessor/FileUpload.aspx
	
}
