package dataDrivenTestPackage;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class CustomListener extends BaseClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		//ITestListener.super.onTestFailure(result);
		System.out.println("Test Failed");
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is : " + result.getName());
		test.log(Status.FAIL, "Test Case Failed is : " + result.getThrowable());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed is : " + result.getName());
		}
	
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is : " + result.getName());
		}
	
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
