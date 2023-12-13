package appModule;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.logInPage;



public class GetProductAction {
	
	public static void execute(WebDriver driver) {
		// TODO Auto-generated method stub
		HomePage.mnuProductCatalog(driver).click();
		}

}
//matt not sure this needs product action
