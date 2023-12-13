/*********************************************************************
 * TSSiteMap.java
 * Area for testing new methods, etc.
 * 
 * 
 * 
 *	Matt Radford 
 * ********************************************************************/

package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import appModule.FileRename;
import appModule.Glob;



public class TSSiteMap {
	WebDriver driver = null;
	String sTestClass = "TSSiteMap";
	

@Test  
    public void VerifySiteMap () throws IOException, InterruptedException {
		String sUserHome = System.getProperty("user.home");
		String sTestDir = sUserHome + "\\Downloads\\";
		String sTestFile = Glob.gsEnv + "sitemap.xml";
		String sTempExt = "crdownload";
		String sControlFile = Glob.gsEnv + "sitemap_controltest.xml";
		
        long start = System.nanoTime(); 
        
        //delete file if it exists
        File f= new File(sTestDir + sTestFile);   
        if (f.delete()) {
      	  
        	System.out.println("sitemap file for test env: " + Glob.gsEnv + " existed, deleting before test");
        }
       
        driver.get(Glob.gsUrl + "/sitemap.xml");
       
       
       Thread.sleep(2000);
       
       FileRename.renameX(sTestDir, sTempExt, sTestFile);
      
       //file compare
        BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream(sTestDir + sTestFile));
        BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream(Glob.gsControl + sControlFile));
        System.out.println("Checking files at: " + sTestDir+sTestFile + " and " + Glob.gsControl + sControlFile);

        int b1 = 0, b2 = 0, pos = 1;
        while (b1 != -1 && b2 != -1) {
            if (b1 != b2) {
                System.out.println("Files differ at position " + pos);
            }
            pos++;
            b1 = fis1.read();
            b2 = fis2.read();
        }
        if (b1 != b2) {  //assert?
            System.out.println("Files have different length");
           
        } else {
            System.out.println("Files are identical, you can delete one of them.");
        }
        fis1.close();
        fis2.close();
        
        long end = System.nanoTime();
        System.out.print("Execution time: " + (end - start)/1000000 + "ms ");
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
 	public void afterTest() throws InterruptedException, IOException {
 		System.out.println("after Test");
 		
 		
 	
 		driver.quit();
 	}


}