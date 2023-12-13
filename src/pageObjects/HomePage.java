package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import appModule.Glob;

import org.openqa.selenium.WebDriver;

//Main home page declarations, menus, menu items, login buttons, etc


public class HomePage {

		private static WebElement element = null;
		static WebDriver driver;

		//browse catalog button on page
		public static WebElement btnBrowseCatalog (WebDriver driver) {	
			element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > a"));
			//#WebPartWPQ1 > div.ms-rtestate-field > section > div > a
			
			
			
			return element;
		}
		
		//find cloud button
		public static WebElement btnCloudOffers (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#div-bg-img > section > div > a.btn.btn-black-white.margin-top-small"));
//			#div-bg-img > section > div > a.btn.btn-black-white.margin-top-small
			return element;
		}
		
	
		public static WebElement dlgModal (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#modaltitl"));
			
			return element;
		}
		
		public static WebElement btnCloseModal (WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id=\'dpoModalDialog\']/div/div/div[1]/button/span/span"));
			//#dpoModalDialog > div > div > div.modal-header.noindex > button > span > span
			//*[@id="dpoModalDialog"]/div/div/div[1]/button/span/span
			
			return element;
			
		}
		
		public static WebElement txtTimer (WebDriver driver) {
			//element = driver.findElement(By.cssSelector("#loadTotal"));
			element = driver.findElement(By.xpath("/html/body/div/div[11]/span[4]"));
			//#dpoModalDialog > div > div > div.modal-header.noindex > button > span > span
			//*[@id="dpoModalDialog"]/div/div/div[1]/button/span/span
			
			return element;
			
		}
		
		
		public static WebElement lblHomePageHeader(WebDriver driver) { 
//			//element = driver.findElement(By.cssSelector("#WebPartWPQ1 > div.ms-rtestate-field > section > div > h2"));
			element = driver.findElement(By.cssSelector(".navbar-brand"));
			return element;
		}
///******************nav bar buttons for login/join		
		//login;
	public static WebElement btn_Login(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#SignInID"));
		//#SignInID
	
		return element;
	}
	
	//Join
	public static WebElement btn_Join(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#JoinInID"));
		//#SignInID
	
		return element;
	}

	
	
	//my account
	public static WebElement btn_MyAccount(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navAccount > span.user-icon.login-user-icon"));
	//	#navAccount > span.user-icon.login-user-icon
		//element = driver.findElement(By.xpath("//*[@id='navAccount']/span[1]"));
	//	("//*[@id='cartNum']/text()"))
		///html/body/form/div[3]/div[1]/div/div[1]/div[3]/div/div/div[1]/header/nav/ul[2]/li[3]/a[1]/span[1]
				//*[@id="navAccount"]/span[1]
				
		//span.user-icon
		//#navAccount > span.user-icon.login-user-icon
	
		return element;
	}

//logout
	public static WebElement btn_LogOut(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#signOut"));
		//"//*[@test-id='test-username']"
	
		return element;
	}
////**********************	
	//product catalog page
	public static WebElement mnuProductCatalog(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navDonation > a"));
		//#navDonation > a
	
		return element;
	}
	
	public static WebElement miDonorOrCompany(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > ul > li:nth-child(1) > button > span"));  
	
		return element;
	}
	
	public static WebElement miCategory(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > ul > li:nth-child(2) > button > span"));  
	
		return element;
	}
	
	public static WebElement miHardware(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > ul > li:nth-child(3) > a")); 
		
		return element;
	}
	
	public static WebElement btnBrowseFullCatalog(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > nav > a")); 
		
		return element;
	}
	
	
	//Services Menu--working
	public static WebElement mnu_Services(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > a")); 
	
		return element;
	}
	
	public static String gsOverview = Glob.gsUrl + "services";
	public static WebElement miOverview(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(1) > a"));  
		
	
		return element;
	}
	
	public static String gsHelpDesk = Glob.gsUrl + "help-desk-services";
	public static WebElement miHelpDesk(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(2) > a"));  
	
		return element;
	}
	
	public static String gsOffice365 = Glob.gsUrl + "microsoft-office-365-nonprofit-support";
	public static WebElement miOffice365(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(3) > a"));  
	
		return element;
	}
	
	public static String gsTechImplementation = Glob.gsUrl + "cloud-experts";
		public static WebElement miTechImplementation(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(4) > a"));  
	
		return element;
	}
	
	public static String gsManagedIT = Glob.gsUrl + "managed-it";
	public static WebElement mi_ManagedITServices(WebDriver driver) {
	
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(5) > a"));  
	
		return element;
	}
	
	public static String gsWebsiteDev = "https://page.techsoup.org/website-services";
	public static WebElement miWebSiteDev(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(6) > a"));  
	
		return element;
	}
	public static String gsDigMarketing =  "https://page.techsoup.org/digital-marketing-services";
	public static WebElement miDigMaketing (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(7) > a"));  
	
		return element;
	}
	
	public static String gsCourses = Glob.gsUrl + "courses";
	public static WebElement miCourses(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(8) > a"));  
	
		return element;
	}
	
	public static String gsBoost = Glob.gsUrl + "boost";
	public static WebElement miBoost(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navServices > ul > li:nth-child(9) > a"));
		
		//#navServices > ul > li:nth-child(7) > a
		
		return element;
	}
	
	//community menu
	
	public static void invokeCommunityPage (WebDriver driver) {

		driver.get(Glob.gsEnvCommunity);
			
				
			}
				
	
	
	
	public static void invokeEvents (WebDriver driver) {
		
		HomePage.mnu_Community(driver).sendKeys(Keys.ARROW_DOWN,  Keys.ENTER);
		String sEvents = CommunityPage.lstEvents(driver).getText();
		System.out.println("Checking for value of text? events label found: " + sEvents + " " + driver.getCurrentUrl());
	}
	
	public static void invokeForums (WebDriver driver) {
	
		driver.get(Glob.gsEnvForums);
		
//		//HomePage.mnu_Community(driver).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		HomePage.mnu_Community(driver).click();
//		HomePage.mnu_Forums(driver).click();
//		String sForum = CommunityPage.lstForum(driver).getText();
//		System.out.println("Checking for value of text? label found: " + sForum);
//		
	}
	
	public static WebElement mnu_Community(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navCommunity > a")); 
//		#navCommunity > a
		return element;
	}
	
	public static WebElement mi_CommunityHome(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navCommunity > ul > li:nth-child(1) > a")); 
	
		return element;
	}
	
	public static WebElement mi_Events(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navCommunity > ul > li:nth-child(2) > a")); 
	
		return element;
	}
	
	public static WebElement mnu_Forums(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navCommunity > ul > li:nth-child(3) > a")); 
	
		return element;
	}
	
	//resources menu--menu items not clickable...??
	public static WebElement mnu_Resources(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navResources > a")); 
		
		return element;
	}
	
	public static WebElement mi_ArticlesAndHowTos(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navResources > ul > li:nth-child(1) > a"));  
		
		return element;
	}
	
	public static WebElement lblArticles (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_Label3"));
		
		return element;
	}
	public static void invokeArticlesAndHowTos (WebDriver driver) {
		
		HomePage.mnu_Resources(driver).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}
	
	public static WebElement mi_Blogs(WebDriver driver) {
		element = driver.findElement(By.linkText("Blogs"));
	
		return element;
	}
	
	public static WebElement lblBlogs (WebDriver driver) {
		
		element = driver.findElement(By.cssSelector("#custom_hero > div > div > div > div > div > div > div > div > div > h1"));

		
		return element;
	}
	
	
	
	public static void invokeBlogs (WebDriver driver) {
		System.out.println("Blogs invoke from " + Glob.gsEnv);
		//driver.get("https://blog.techsoup.org/posts");
		if (Glob.gsEnv.equals("Prod")) {
			HomePage.mnu_Resources(driver).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
			String sBlogs = HomePage.lblBlogs(driver).getText();
			System.out.println("Checking for value of text? label found: " + sBlogs);
		}
		else {
			System.out.println("in the blog invoke else");
			driver.get("http://"+Glob.gsEnv+ "-forums.techsoup.org/cs/community/b/tsblog/");
			String sBlogs = HomePage.lblBlogs(driver).getText();
			System.out.println("Checking for value of text? label found: " + driver.getCurrentUrl());
			System.out.println("Checking for value of text? label found: " + sBlogs);
		}
	}
	
	public static WebElement mi_StoryMakers(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navResources > ul > li:nth-child(3) > a"));  
	
	
		return element;
	}
	
	public static WebElement lblStoryMakers (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#carouselHomepage > div > div.item.sfimage.active > div.caption-box > p"));
		
		return element;
	}
	
	public static void invokeStoryMakers (WebDriver driver) {
		
		HomePage.mnu_Resources(driver).click();
		HomePage.mi_StoryMakers(driver).click();
		String sStoryMakers = HomePage.lblStoryMakers(driver).getText();
		System.out.println("Checking for value of text? label found: " + sStoryMakers);
	}
	
	public static WebElement mi_Webinars(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navResources > ul > li:nth-child(4) > a"));  
	
		return element;
	}
	
	public static WebElement lblWebinars (WebDriver driver) {
//		element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > header > div > div > div > h1"));
		element = driver.findElement(By.cssSelector("#navResources > ul > li:nth-child(3) > a"));
//		#navResources > ul > li:nth-child(3) > a
		
		return element;
	}
	
	public static void invokeWebinars (WebDriver driver) {
		
		HomePage.mnu_Resources(driver).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		String sWebinars = HomePage.lblWebinars(driver).getText();
	}
	
	//Help
	public static WebElement mnu_Help(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#navHelp > a"));
	
		return element;
	}
	
	//Search
	public static WebElement btn_Search(WebDriver driver) {
//		element = driver.findElement(By.cssSelector("#navSearch > span.glyphicon"));  
		/*2019*/ element = driver.findElement(By.cssSelector("#navSearch > span.fa.fa-search.closeicon"));
		return element;
	}
	
	public static WebElement txt_Search(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#searchContent"));  
		
		return element;
	}
	
	public static WebElement btn_SearchforTxt(WebDriver driver) {
		/*2019*/		element = driver.findElement(By.cssSelector("#RWDSearchID > fieldset > button > span.fa.fa-search"));  
//		
		//element = driver.findElement(By.cssSelector("#RWDSearchID > fieldset > button > span.glyphicon.glyphicon-search"));  
//		#RWDSearchID > fieldset > button > span.fa.fa-search
		return element;
	}
	
	//mobile home page items
	
//cart
	
	public static WebElement lnk_Cart(WebDriver driver) {
//		element = driver.findElement(By.cssSelector("#navCart > span.glyphicon.glyphicon-shopping-cart"));
		element = driver.findElement(By.cssSelector("#cartNum"));
//		#cartNum	
		return element;
	}
	
	
	
	public static WebElement txt_CartValue(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='cartNum']/text()"));
	
		return element;
	}
	
	
//FOOTER Items 
	
	public static WebElement lblFooter (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#page-footer"));
		
	return element;
	}
	//heading more techsoup
	
	
	public static WebElement lnkMoreTechsoup(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#footer-header"));
	
		return element;
	}
	
	//about us
	public static WebElement lnkAboutUs(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl0_link"));
	
		return element;
	}
	
	//our Mission
	public static WebElement lnkOurMission(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl1_link"));
	
		return element;
	}	
	
	//TechSoup Global Network
	public static WebElement lnkTechSoupGlobalNetwork(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl2_link"));
	
		return element;
	}	
	
	//Testimonials
	public static WebElement lnkTestimonials(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl3_link"));
	
		return element;
	}	

	//Meet our Donor Partners
	public static WebElement lnkMeetOurDonorPartners(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl4_link"));
	
		return element;
	}
	
	//Meet our Funders
	public static WebElement lnkMeetOurFunders(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl5_link"));
	
		return element;
	}	
	
	//Anti-Discrimination Policy
	public static WebElement lnkAntiDiscriminationPolicy(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl0_LinkList_ctrl6_link"));
	
		return element;
	}	



//get in touch

public static WebElement lnkGetInTouch(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#footer-header"));

	return element;
	}

//donate
public static WebElement lnkDonate(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl0_link"));

	return element;
	}

//become donor partner
public static WebElement lnkBecomeADonorPartner(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl1_link"));

	return element;
	}

//volunteer
public static WebElement lnkVolunteer(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl2_link"));

	return element;
	}

//careers
public static WebElement lnkCareers(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl3_link"));

	return element;
	}

//contact us
public static WebElement lnkContactUs(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl4_link"));

	return element;
	}

//returns and refunds
public static WebElement lnkReturnsAndRefunds (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl5_link"));

	return element;
	}

//media and press
public static WebElement lnkMediaAndPress(WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_footer_MasterFooter_LinkCategoryList_ctrl1_LinkList_ctrl6_link"));

	return element;
	}

//Subscribe button 
public static WebElement btnSubscribe (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#page-footer > div > div:nth-child(1) > div.col-md-3.col-sm-5.Newheadingcol > a"));

	return element;
	}
/* widgets for cloud an boost check*/
public static WebElement lnkBoost (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#boostOffer > a"));

	return element;
	}

public static WebElement lnkCloud (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#cloudOffer > a"));

	return element;
	}

/*  dialog boxes save for later.  loads after login  */
public static WebElement dlgFinishAddingOrg (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#modalpopup > div > div > div.modal-header"));
	
	return element;
	}

public static WebElement btnDiscardSavedOrg (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#buttonBack"));
	
	return element;
	
}

public static WebElement btnFinishOrg (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#buttonContinue"));
	
	return element;
	
}

public static WebElement btnDiscardOrg (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder_header_ctl01_LoginView_buttonDiscard"));
	
	return element;
	
}

public static WebElement btnGoBack (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#buttonDiscardCancel"));
	
	return element;
	
}

//Expired org pop-ups
public static WebElement popExpired (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#requalpopup > div > div > div.modal-header"));
	
	return element;
	
}

String sPopExpiredText = "Your Organization's Validation Has Expired";

public static WebElement lstExpiredOrgText (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#requalpopup > div > div > div.modal-body.popupText > p:nth-child(1)"));
//	#requalpopup > div > div > div.modal-body.popupText > p:nth-child(1)	
	
	return element;
	
}

public static String sExpiredOrgText = "Either your organization hasn't been validated in more than five years, or our systems could not confirm your nonprofit status. Any requests that you place can only be fulfilled after one of our team members successfully re-validates your organization.";

public static WebElement cmdYesPlease (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#reQualSubmit"));
	
	return element;
	
}
public static WebElement cmdNotNow (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#reQualBack"));
	
	return element;
	
}
public static WebElement popRequalInitiated (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#requalsuccesspopup > div > div"));
	
	return element;
	
}

public static WebElement lstExpiredDetailsText (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#requalsuccesspopup > div > div > div.modal-body.popupText"));
//	#requalsuccesspopup > div > div > div.modal-body.popupText > p:nth-child(1)
	return element;
	
}

public static String sRequalInitiated = "We will email your organization, at expireorg@foobar.net, once re-validation is complete or if additional information is needed. This should only take a few days.\n" + "You are free to place requests from our catalog. We will fulfill your requests after a successful re-validation.";

public static WebElement cmdCloseReQualPopup (WebDriver driver) {
	element = driver.findElement(By.cssSelector("#requalsuccesspopup > div > div > div.modal-footer > button"));

	return element;
}

}

