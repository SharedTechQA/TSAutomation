package automationFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.Glob;

public class TSTestReport {
	String sTestClass = "TSTestReport";
@Test
	public void copyTestReports() throws IOException {
		Glob.setTestNGOutPutDirectory(sTestClass);

}
@BeforeClass
	public void beforeClass() throws IOException {
	 	Glob.setOutPutDirectory(sTestClass);
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!**** IN " + Glob.gsEnv );
}

@Parameters({"Glob.gsEnv", "Glob.gsBrowser", "Glob.gbMobile"})
@BeforeTest(alwaysRun = true)
	public void beforeTest(String sEnv, String sBrowser, boolean bMobile) throws IOException {
	  	Glob.setEnv(sEnv);
	  	Glob.gbMobile = bMobile;
	  	
	  	
	
//	  	WebDriver driver = Glob.setBrowser(sBrowser);
//	  	
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		
		
			 	

 }

	
			 	



}
