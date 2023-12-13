/*********************************************************************
 * TSMyAccount.java
 * Area for account related test cases, edit account, etc.
 * 
 * Some comments for git
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;
import appModule.LogOutAction;
import appModule.LoginAction;
import pageObjects.MemberDetailsPage;
import pageObjects.MyAccountPage;
import pageObjects.logInPage;


public class TSMyAccount {
	 private static WebDriver driver = null;
	 
	  public static final String USERNAME = "matthewradford1";
	  public static final String AUTOMATE_KEY = "PDoyEJ6xcFeqnqyqugot";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
	  String sTestClass = "TSMyAccount";
	  //edit member 
	  //change password

	  
/* run carefully, requires AEP  validation*/	  
 //@Test(groups = "email")
	  public void MyAccount_EditEmail () throws InterruptedException, SQLException, ClassNotFoundException {
	  
//	  String sEditEmail = "matttestein99@foobar.net";
//	  String sCurrentEmail = "matttestein@foobar.net";
//	  String sCurrentPword = "B00ker99!";
	  String sFoo;

			
			//Edit Account 
			LoginAction.login(driver, Glob.gsEmailUpdateAccct, Glob.gsPassword, Glob.gbMobile);
			MyAccountPage.invoke(driver);

			MyAccountPage.btnEditMemberDetails(driver).click();
//			
			MemberDetailsPage.txtEmailAddress(driver).clear();
			MemberDetailsPage.txtEmailAddress(driver).sendKeys(Glob.gsNewEmail);
			MemberDetailsPage.txtConfirmEmailAddress(driver).clear();
			MemberDetailsPage.txtConfirmEmailAddress(driver).sendKeys(Glob.gsNewEmail);
			MemberDetailsPage.txtConfirmEmailAddress(driver).sendKeys(Keys.TAB);
			
			MemberDetailsPage.btnSave(driver).click();
				
			String sFoundUpdate;
			sFoundUpdate = logInPage.lblUpdateEmail(driver).getText();
			System.out.println("found "+ sFoundUpdate + " Expected " + logInPage.sUpdateEmailText);
		
			//if (sFoundUpdate.equals(logInPage.sUpdateEmailText)) {
				assertEquals(logInPage.sUpdateEmailText, sFoundUpdate );
				
				//assert.assertEquals(actual, expected);
			
			if (! Glob.gsEnv.equals("Prod") ) {	
				
				//String connectionUrl = "jdbc:jtds:sqlserver://10.25.96.156:1433/Onyx;database=Onyx;useNTLMv2=true;domain=Compumentor";  //user=compumentor/mradford;password=JUNE2018mr%";
				String connectionUrl = Glob.gsSqlDb;
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				Connection con = DriverManager.getConnection (connectionUrl);
				Statement stmt = con.createStatement();
				
				ResultSet resultSet = null;
				
				String Sql = "use onyx select vchuser3 from individual where vchlastname = 'EmailUpdate'";
						
					
				//System.out.println(Sql);
				
				resultSet = stmt.executeQuery(Sql);
				while (resultSet.next()) {
				//System.out.println(resultSet.getString(1));
				sFoo = resultSet.getString(1);
				
				System.out.println("the value for the url will be, https://www-qa.techsoup.org/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3d" + Glob.gsNewEmail + "%26ref_id%3d" + sFoo);
				//https://www-qa.techsoup.org/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3dmadmattford@foobar.net%26ref_id%3d09169830-834753   VAR: 61570555-558865
				
				https://www-qa.techsoup.org/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3dmattradford1@outlook.com%26ref_id%37493290-263599
				driver.get(Glob.gsUrl + "/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3d" + Glob.gsNewEmail + "%26ref_id%3d" + sFoo);
				https://www-qa.techsoup.org/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3dmattradford1@outlook.com%26ref_id%37493290-263599
				LoginAction.login(driver, Glob.gsNewEmail, Glob.gsPassword, Glob.gbMobile);
				//if (driver.getCurrentUrl().equals("https://www-qa.techsoup.org/joining-techsoup/Organization")) {
					assertEquals(driver.getCurrentUrl(), Glob.gsUrl, "****ERROR****Should be home page");
				//}
				MyAccountPage.invoke(driver);
				
//reset back to orginal email address and update via AEV as well but probably not necessary
				MyAccountPage.btnEditMemberDetails(driver).click();
//				
				MemberDetailsPage.txtEmailAddress(driver).clear();
				MemberDetailsPage.txtEmailAddress(driver).sendKeys(Glob.gsEmailUpdateAccct);
				MemberDetailsPage.txtConfirmEmailAddress(driver).clear();
				MemberDetailsPage.txtConfirmEmailAddress(driver).sendKeys(Glob.gsEmailUpdateAccct);
				MemberDetailsPage.txtConfirmEmailAddress(driver).sendKeys(Keys.TAB);
				MemberDetailsPage.btnSave(driver).click();
				
				resultSet = stmt.executeQuery(Sql);
				while (resultSet.next()) {
				//System.out.println(resultSet.getString(1));
				sFoo = resultSet.getString(1);
				//System.out.println("the value for the url will be, https://www-qa.techsoup.org/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3dmatttestein@foobar.net%26" + sFoo +"%3d");
				
				driver.get(Glob.gsUrl + "/Login?ReturnUrl=%2fjoining-techsoup%2fOrganization%3flog_in%3d" + Glob.gsEmailUpdateAccct + "%26ref_id%3d" + sFoo );
				LoginAction.login(driver, Glob.gsEmailUpdateAccct, Glob.gsPassword, Glob.gbMobile);
				MyAccountPage.invoke(driver);
				}	
				
				
			}
		}
			
		
			
	///
			LogOutAction.execute(driver, Glob.gbMobile);
			//driver.get(Glob.gsUrl);
					  

	
}
@Test(dataProvider = "memberData")
  public void MyAccount_Edit (String sEditFirstName, String sEditLastName) throws InterruptedException {

		

		
		//Edit Account 
		LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword, Glob.gbMobile);
//		
		MemberDetailsPage.EditMember (driver, sEditFirstName, sEditLastName);
		Thread.sleep(2000);
		MemberDetailsPage.VerifyMember(driver, sEditFirstName, sEditLastName);
//		
		///*****Cleanup member*****/// 
		MemberDetailsPage.ResetMember (driver, MemberDetailsPage.sFirstName, MemberDetailsPage.sLastName);
		
		LogOutAction.execute(driver, Glob.gbMobile);
		driver.get(Glob.gsUrl);
				  
  }
  
  @DataProvider
	public Object[][] memberData(){
			  Object [][] data= new Object [5][2];
			  data [0][0] = "This is first name but with lots of characters";
			  data [0][1] = "This is the last name but with lots of characters";
			  
			  data [1][0] = "This is first name but with lots of numbers 123456";
			  data [1][1] = "This is the last name but lots of numbers 12345678";
			  
			  data [2][0] = "This is first name with special chars !@#$%^&*()?+";
			  data [2][1] = "This is last name with special chars !@#$%^&*()?+";
			  
			  data [3][0] = "MaxCharactersFirstNameshouldbethenumberfiftywwwww";
			  data [3][1] = "MaxCharacterslastNameshouldbethenumberfiftywwwwww";
			  
			  data [4][0] = "Automation Edit First Name";
			  data [4][1] = "Automation Edit Last Name";
			  
			  
			  return data;
  }
  
  @BeforeClass
	public void beforeClass() throws IOException {
	  	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
		
}
  @Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
  @BeforeTest(alwaysRun = true)
  	public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException {
  		  	Glob.setEnv(sEnv);
  		  	Glob.gbMobile = bMobile;
  		  	System.out.println("what is bmobile and gbmobile " + bMobile +  " " + Glob.gbMobile );;
  		
  		  	driver = Glob.setBrowser(sBrowser);
  		  	
  			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  			
//  				Files.createDirectories(Paths.get("C:/TSTestOutPut" + Glob.GetDate()));
//  			System.setOut(new PrintStream(new FileOutputStream("c:\\TSTestOutput\\TSMyAccount\\testoutput.txt")));
  			
  			if (bMobile) {
  				driver.get(Glob.gsUrl);
  				driver.manage().window().setSize(new Dimension(375,812));//iPhoneX size
  			}
  			else{
  				driver.manage().window().maximize();
  				driver.get(Glob.gsUrl);
  			}
  			 	


  	  }

  @AfterTest(alwaysRun = true)
  	public void afterTest() throws InterruptedException {
  		System.out.println("after Test");
  		
  	
  		driver.quit();
  	}

}
