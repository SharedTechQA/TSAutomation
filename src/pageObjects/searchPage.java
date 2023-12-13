package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appModule.Glob;

import org.openqa.selenium.WebDriver;

public class searchPage {
	private static WebElement element = null;
	static WebDriver driver;
		//slide share page  http://www-stage.techsoup.org/community/events-webinars/digital-divide-during-a-pandemic-how-to-work-toward-inclusion-for-your-nonprofit-community-2020-05-19
		public static WebElement lstFilter (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#filterOrder > li.open > div"));
//			#filterOrder > li.open > div
//			#filterOrder > li.open > div > ul
			return element;
		}
	
		public static WebElement tab_Products(WebDriver driver) { 
//			element = driver.findElement(By.cssSelector("#prodMainTab > a"));//prod //stage
//			
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_prodMainTab")); //QA
//			#ctl00_PlaceHolderMain_DisplayContentName1_prodMainTab > a > span.desktop-title")); //QA
//			#ctl00_PlaceHolderMain_DisplayContentName1_prodMainTab

			return element;
	}
		
		//author value in blog results
		public static WebElement lblBlogAuthor (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_blogsData > section > ul > li:nth-child(1) > a > small > span.author"));
			
//			#ctl00_PlaceHolderMain_DisplayContentName1_knowledgeMainTab > a
//			#ctl00_PlaceHolderMain_DisplayContentName1_knowledgeMainTab	
			return element;
		}
//		
	
		
		
		
		public static WebElement tabResources (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_knowledgeMainTab"));
			
//			#ctl00_PlaceHolderMain_DisplayContentName1_knowledgeMainTab > a
//			#ctl00_PlaceHolderMain_DisplayContentName1_knowledgeMainTab	
			return element;
		}
//		#ctl00_PlaceHolderMain_DisplayContentName1_forumsTab > a > svg > circle

		public static WebElement btnForums (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_forumsTab > a"));

			return element;
		}

		public static WebElement btnBlogs (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_blogsTab > svg > path"));
			
			return element;
		}
		public static WebElement lblBlogTitle (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_blogsData > section > ul > li:nth-child(1) > a > h4"));
			
			return element;
		}

		
		public static WebElement lblBlogCount (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#CommunityMainTabCount"));

			return element;
		}
		public static WebElement lnkBrowseFullCatalog(WebDriver driver) { 
			element = driver.findElement(By.cssSelector("#DeltaPlaceHolderMain > div.bg-light-gray > div > div > div > a"));
			
			return element;
		}
		
		public static WebElement lbxSort (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_ProductSearchResult_SearchDropDowns_SortByDropDown_DropDown"));
//			#ctl00_PlaceHolderMain_DisplayContentName1_ProductSearchResult_SearchDropDowns_SortByDropDown_DropDown
			return element;
		}
		
		public static String sSortAscending = Glob.gsUrl + "search/products/adobe/sort-name-asc/";
		public static String sSortDescending = Glob.gsUrl + "search/products/adobe/sort-name-desc/";
		public static String sSortRelevance = Glob.gsUrl + "search/products/adobe/sort-rank/";
		
		
		public static WebElement txtSearchInput (WebDriver driver) { 
			element = driver.findElement(By.cssSelector("#searchInput")); //#searchInput
			
			return element;
		}
		
		public static WebElement txtSearchInput2 (WebDriver driver) { 
			element = driver.findElement(By.cssSelector("#searchClear")); //#searchInput
			
			return element;
		}	
	
		public static WebElement listRelatedPages (WebDriver driver) {
			element = driver.findElement(By.cssSelector("#filterProducts > section.hidden-xs > ul"));
			
			return element;
		}
		
	public static WebElement tab_productCount(WebDriver driver) { 
		element = driver.findElement(By.xpath("//*[@id='ProdTabCount']"));

	
		return element;
	}
	
	public static WebElement tab_productCountTotal(WebDriver driver) { 
	//	element = driver.findElement(By.cssSelector("#ProdDisplayCountTotal"));
		element = driver.findElement(By.xpath("//*[@id='ProdDisplayCountTotal']"));
		//
		//#SignInID
	
		return element;
	}
		
	//knowledge tab
	public static WebElement tab_Knowledge(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#knowledgeMainTab > a"));
		//#SignInID
	
		return element;
	}
	
	public static WebElement btnArticles(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_articlesTab > a > svg > circle"));
		
		//#SignInID
	
		return element;
	}
	
	public static WebElement btnAuthor(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#Author"));
		
		return element;
	}
	
	public static WebElement btnSubject(WebDriver driver) { 
//		element = driver.findElement(By.cssSelector("#Subject"));
		element = driver.findElement(By.xpath("//*[@id='Subject']"));
		//(By.xpath("//*[@id='ProdTabCount']"));
		
		return element;
	}
	
	public static WebElement btnTopic(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#Topic"));
	
		return element;
	}
	
	
	public static WebElement btnHowTos(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#communityTab > a > svg > circle"));
		//#SignInID
	
		return element;
	}
	
	public static WebElement btnWebinars(WebDriver driver) { 
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_webinarTab > a"));
		
		//#SignInID
	
		return element;
	}
	
	//filter items
	
	public static WebElement lnkFormat (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#Format"));
		
		return element;
	}
	
	public static WebElement liDownload (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_DisplayContentName1_ProductSearchResult_NavigatorSideBar_NavigatorsRepeater_ctl00_Navigator_ListView_ctrl0_NavigatorEntry > a"));
		
		return element;
	}
	public static WebElement lstContents (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#filterOrder > li.open > div"));
		
		return element;
	}
	
	public static WebElement lnkPlatform (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#Platform"));
		
		return element;
	}
	
	//deprecated...11/30/2018
	public static WebElement lnkSolution (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#Solution"));
		
		return element;
	}
	
	public static WebElement lnkCategory (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#Category"));
		
		return element;
	}
	
	public static WebElement lnkPartner (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#Partner"));
		
		return element;
	}
	
	public static WebElement lnkLanguage (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#Language"));
		
		return element;
	}
	
	//#idShowResultUrl
	public static WebElement lstShowingResultsFor (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#idShowResultUrl"));
		
		return element;
	}
	
	public static WebElement lstSearchInsteadFor (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#idSearchInsUrl"));		
		
		return element;
	}
	public static WebElement txtFlag (WebDriver driver) {
		element = driver.findElement(By.cssSelector("#olProdResults > li > a > figure > div > img"));		
		
		return element;
	}
	
}


