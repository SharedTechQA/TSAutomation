package appModule;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import appModule.Glob;

public class Listeners implements ITestListener {
	static WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String sFileName = "failedTest";
		System.out.println(result.getName() + " TEST failed in the listener");
		
		TakesScreenshot ts = (TakesScreenshot)Glob.driver;
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		  
		try {
			FileUtils.copyFile(srcFile, new File("c://testautoimages/"+ Glob.GetDateTime()+ sFileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileUtils.copyInputStreamToFile(arg0, arg1);
		
		System.out.println("capturing screen shot, file can be located here:  " + "c://testautoimages/"+ Glob.GetDateTime()+ sFileName + ".png" + " for  " + result.getName()  );
		driver.navigate().back();
		
		}
	
		
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
