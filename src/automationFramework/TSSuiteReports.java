package automationFramework;

import org.testng.annotations.Test;

import appModule.Glob;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class TSSuiteReports {
	String sTestClass = "SuiteReports";
  @Test
  public void fSuiteReport() {
	  System.out.println("after suite method");
	  
  }
  @BeforeClass
	public void beforeClass() {
		System.out.println("****!!!!! Running Test Class: "+ sTestClass +" !!!!!****");
}
  @BeforeTest
  public void beforeTest() throws IOException {
	  Glob.setOutPutDirectory(sTestClass);
  }

  @AfterTest
  public void afterTest() {
  }

  @AfterSuite
  public void afterSuite() throws IOException, InterruptedException {
	  Thread.sleep(10000);
	  System.out.println("after suite");
	  Glob.setTestNGOutPutDirectory(sTestClass);
  }

}
