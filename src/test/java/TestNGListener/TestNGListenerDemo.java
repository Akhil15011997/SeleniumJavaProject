package TestNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenerDemo implements ITestListener{
	
	public void onTestStart(ITestResult result) { System.out.println("Test Started \t"+result.getName()); }
	
	public void onTestSuccess(ITestResult result) { }
	
	public void onTestFailure(ITestResult result) { System.out.println("Test Failed \t"+result.getName()); }
	
	public void onTestSkipped(ITestResult result) { System.out.println("Test Skipped \t"+result.getName()); }
	
	public void onTestFailedWithinSuccessPercentage(ITestResult result) { }
	
	public void onStart(ITestContext context) { }
	
	public void onFinish(ITestContext context) { }

}
