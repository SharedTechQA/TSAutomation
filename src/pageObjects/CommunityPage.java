/*********************************************************************
 * CommunityPage.java
 *   
 *   
 *   element mapping, basic invoke and other methods
 *   new post for forums method
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/


package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import appModule.Glob;
import appModule.LoginAction;

import org.openqa.selenium.WebDriver;

public class CommunityPage {

	private static WebElement element = null;
	static WebDriver driver;
	public static String sUrl = Glob.gsUrl;

	public static WebElement lblCommunityPageHeader(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#fragment-11410 > div > div.content-fragment-content > h1"));

		return element;
	}
	
//control center
	public static WebElement lnkPrivateMessages (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-11415 > div > div.content-fragment-content > div > ul > li.navigation-item.conversations > a"));
		
		return element;
	}
	
	public static WebElement lnkCommunitySettings (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-11415 > div > div.content-fragment-content > div > ul > li:nth-child(2) > a > span"));
		
		return element;
	}
	
	public static WebElement lnkMyCommunityProfile(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-11415 > div > div.content-fragment-content > div > ul > li:nth-child(3) > a > span"));
		
		return element;
	}

	public static WebElement lnkSubscribe (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#fragment-11415 > div > div.content-fragment-content > div > ul > li.rss"));
		
		return element;
	}
	
public static WebElement tabFeaturedTopics (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(1) > a"));
	
	return element;
}

public static WebElement lblFeatured (WebDriver driver) {
	
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(1) > a"));
	
	return element;
}

public static WebElement lblFeaturedHeader (WebDriver driver) {
	
	element = driver.findElement(By.cssSelector("#fragment-11410 > div > div.content-fragment-content > h1"));
	
	return element;
}


public static void invokeFeaturedTopics (WebDriver driver) {
	System.out.println("invoking featured topics");
	if (Glob.gbMobile) {
		driver.get(Glob.gsEnvCommunity);
		String sFeatured = CommunityPage.lblFeaturedHeader(driver).getText();
		System.out.println("Invoking featured topics. Checking for value of featured Topics?  found: " + sFeatured);

	}
	else {
		CommunityPage.tabFeaturedTopics(driver).click();
		String sFeatured = CommunityPage.lblFeatured(driver).getText();
		System.out.println("Invoking featured topics. Checking for value of featured Topics?  found: " + sFeatured);
	}
	
}


public static WebElement tabForums (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(2) > a"));
	
	return element;
}

public static WebElement lblForums (WebDriver driver) {
	
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(2) > a"));
	
	return element;
}

public static WebElement lblForumsHeader (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#fragment-15590 > div > div.content-fragment-content > h1"));
	//#fragment-15168 > div > div.content-fragment-content > h1
	
	return element;
}
public static void invokeForums (WebDriver driver) throws InterruptedException {
	System.out.println("invoking forums");
	if (Glob.gbMobile) {
		driver.get(Glob.gsEnvCommunity + "f/");
		
		String sForums = CommunityPage.lblForumsHeader(driver).getText();
		System.out.println("Invoking forums.  Checking for value of Forums?  found: " + sForums);

/*		CommunityPage.mnuCommunityMenu(driver).click();
 * 		attempted to interact via menu	
 *	 	System.out.println("clicked on menu");
 *      CommunityPage.miForums(driver).click();
*/		
		
	}
	else {
		CommunityPage.tabForums(driver).click();
		String sForums = CommunityPage.lblForums(driver).getText();
		System.out.println("Invoking forums.  Checking for value of Forums?  found: " + sForums);
	}
	
}

public static WebElement lblBlobArchiveHeader (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#fragment-15168 > div > div.content-fragment-content > h1"));
	//#fragment-15168 > div > div.content-fragment-content > h1
	
	return element;
}
public static WebElement tabBlogArchive (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(3) > a"));
	//#groupAppNav > li:nth-child(3) > a
	
	return element;
}
public static void invokeBlogArchive (WebDriver driver) {
	System.out.println("invoking blog archive" );
	if (Glob.gbMobile) {
		driver.get(Glob.gsEnvCommunity + "b/tsblog/");
		
		String sBlogArchive = CommunityPage.lblBlobArchiveHeader(driver).getText();
		System.out.println("Checking for value of Blog Archives?  found: " + sBlogArchive);
		
//		CommunityPage.mnuCommunityMenu(driver).click();
//		System.out.println("clicked on menu");
//		CommunityPage.miForums(driver).click();
	}
	else {
		CommunityPage.tabBlogArchive(driver).click();
		String sBlogArchive = CommunityPage.tabBlogArchive(driver).getText();
		System.out.println("Checking for value of Blog Archives?  found: " + sBlogArchive);
	}


	
}

public static WebElement lblRecentActivityHeader (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#fragment-13741 > div > div.content-fragment-content > h1"));
	//#fragment-13741 > div > div.content-fragment-content > h1
	//#fragment-13741 > div > div.content-fragment-content > h1
	
	return element;
}

public static WebElement tabRecentActivity (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(4) > a"));
	
	return element;
}
public static void invokeRecentActivity (WebDriver driver) {
	System.out.println("invoking Recent Activity");
	if (Glob.gbMobile) {
		driver.get(Glob.gsEnvCommunity + "p/activity.aspx");
			
		
		String sRecentActivity = CommunityPage.lblRecentActivityHeader(driver).getText();
		System.out.println("Checking for value of Recent Activity?  found: " + sRecentActivity);
		
//		CommunityPage.mnuCommunityMenu(driver).click();
//		System.out.println("clicked on menu");
//		CommunityPage.miForums(driver).click();
	}
	else {
		CommunityPage.tabRecentActivity(driver).click();
		String sRecentActivity = CommunityPage.tabRecentActivity(driver).getText();
		System.out.println("Checking for value of Recent Activity?  found: " + sRecentActivity);
	}
	

	
}
	

public static WebElement txtNewHere (WebDriver driver) {
	
	element = driver.findElement(By.cssSelector("#fragment-11415 > div > div.content-fragment-content > div > h3"));
	
	return element;
}


//good for furums and community home
public static WebElement btnNewPost(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#fragment-11415_newpost"));
	//#fragment-15595_newpost > span
	//#fragment-11415_newpost > span  //this changes by page
	//element = driver.findElement(By.className("button"));//*[@id="fragment-15595_newpost"]/span
	//element = driver.findElement(By.partialLinkText("newpost"));
	//#SignInID

	return element;
}

public static WebElement btnForumsNewPost(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#fragment-13893_newpost"));//#fragment-11415_newpost > span  //this changes by page
	//element = driver.findElement(By.className("button"));//*[@id="fragment-15595_newpost"]/span
	//element = driver.findElement(By.partialLinkText("New Post"));
	//#SignInID

	return element;
}

public static WebElement btnRecentNewPost(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#fragment-14321_newpost"));//#fragment-11415_newpost > span  //this changes by page


	return element;
}




public static WebElement lstNewPosts (WebDriver driver) {
	element = driver.findElement(By.cssSelector("body > div:nth-child(15) > div"));//body > div:nth-child(17) > div > ul
	
	return element;
	
}


public static WebElement liIntroduceYourSelf (WebDriver driver) {
	element = driver.findElement(By.cssSelector("body > div:nth-child(14) > div > ul > li:nth-child(1) > a"));
//	body > div:nth-child(14) > div > ul > li:nth-child(1) > a
	//body > div:nth-child(17) > div > ul
	//body > div:nth-child(15) > div > ul > li:nth-child(1) > a
	return element;
	
}

public static WebElement btnLogIn(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("body > div:nth-child(14) > div > ul > li > a"));
	
	

	return element;
}

//forums

public static WebElement lstForum(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#fragment-13897_list > table > thead > tr > th.table-header-column.application-title"));
	

	return element;
}

//events
public static WebElement lstEvents(WebDriver driver) { 
	element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
	//#SignInID

	return element;
}

/*******  Forums Mobile ******/
//control center
//if logged in
public static WebElement mnuMyControlCorner (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#fragment-15595 > div > div.content-fragment-content > div > h3"));

	return element;
}

//#fragment-15595 > div > div.content-fragment-content > div > h3
//#fragment-15595 > div > div.content-fragment-content > div > h3

//#fragment-15595 > div > div.content-fragment-content > div > h3  //#fragment-15595_newpost > span

public static WebElement miNewPost (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#fragment-15595_newpost > span"));

	return element;
}

public static WebElement mnuCommunityMenu (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#fragment-14324 > div > div.content-fragment-content > button"));
	//element = driver.findElement(By.xpath("//*[@id="fragment-14325"]/div/div[2]/button"))
	//#fragment-14324 > div > div.content-fragment-content > button
	

	return element;
}

public static WebElement miForums (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(2) > a"));
	

	return element;
}

public static WebElement miBlogArchives (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(3) > a"));
	

	return element;
}


public static WebElement miRecentActivity (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(4) > a"));
	

	return element;
}


public static WebElement miFeaturedTopics (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#groupAppNav > li:nth-child(1) > a"));
	

	return element;
}






}
