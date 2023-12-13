/*	Forum post dialog page elements and methods
 * 
 * new post method
 * 
 * matt
 */

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appModule.Glob;

public class ForumPostPage {
	
	private static WebElement element = null;
	static WebDriver driver;
	
	/****   forum post dialog elements ****/
	public static WebElement txtSubject (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-13341_PostSubject"));
//		#fragment-13341_PostSubject
//		#fragment-13341_PostSubject
		return element;
	}

	public static WebElement txtDescription (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#tinymce"));
		
		
		return element;
	}

	public static WebElement txtTags (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-13804_TagBox"));
		
		return element;
	}

	public static WebElement btnSelectTags (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-13804_SelectTags"));
		
		return element;
	}

	public static WebElement btnPost (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-13804 > div > div.content-fragment-content > fieldset > ul > li > span > a"));
		
		return element;
	}

	public static WebElement chkEmailMe (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-13804_SubscribeToThread"));
		
		return element;
	}


	/*
	 * Shared methods
	 */
	public static void NewForumPost (WebDriver driver, String sPostSubject, String sPostDetail, boolean bMobile) throws InterruptedException {
		  //NewForumPost
		  bMobile = Glob.gbMobile;
		  HomePage.invokeCommunityPage(driver);
		  if (bMobile) {
			  System.out.println("newforumpost.bmobile is " + bMobile);
			  driver.get("http://qa-forums.techsoup.org/cs/community/f/19/p/addpost.aspx");
		  }
		  else {
			  CommunityPage.btnNewPost(driver).click();
			  CommunityPage.liIntroduceYourSelf(driver).click();
		  }
		  
		  ForumPostPage.txtSubject(driver).sendKeys(Glob.GetDate() +" " + sPostSubject);
		  ForumPostPage.txtSubject(driver).sendKeys(Keys.TAB, Keys.TAB, Glob.GetDate() +" " + sPostDetail);
		  
		 // ForumPostPage.txtDescription(driver).sendKeys(sPostDetail);
		  if (Glob.gsEnv.equals("Prod")){
				  driver.get(Glob.gsUrl);
		  }
		  else {
		  ForumPostPage.btnPost(driver).click();
		  Thread.sleep(5000);
		  }
		  
/*		  
		  // CommunityPage.mnuMyControlCorner(driver).click();
//		  //CommunityPage.miNewPost(driver).click();
//		  driver.get("http://qa-forums.techsoup.org/cs/community/f/19/p/addpost.aspx");
//		  //CommunityPage.btnNewPost(driver).click();
//		  System.out.println("**Load New Post**");
		  
//		  CommunityPage.btnLogIn(driver).click();
//		  logInPage.txtEmail(driver).sendKeys(Glob.gsEmail);
//		  logInPage.txtPassword(driver).sendKeys(Glob.gsPassword);
//		  logInPage.btnLogin(driver).click();
		  
//		  LoginAction.login(driver, Glob.gsEmail, Glob.gsPassword);
//		  CommunityPage.btnNewPost(driver).click();
//		  
//		  System.out.println("**Click New Post**"); 
//		  //System.out.println("size: " + CommunityPage.lstNewPosts(driver).);possible get screen shot
//		  CommunityPage.liIntroduceYourSelf(driver).click();
		  
		  //System.out.println("number of new post items:  " + CommunityPage.lstNewPosts(driver).getText());
		  //System.out.println(CommunityPage.lstNewPosts(driver).findElements(By.className("navigation-item")).size());
		  //.findElements(By.tagName ("a")).size());
		   * 
		   */
	}

}
