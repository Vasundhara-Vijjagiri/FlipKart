package com.FlipKart.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyListener extends BaseTest implements ITestListener {
@Override
public void onTestStart(ITestResult result)
{
	Reporter.log(result.getName()+" method Started",true);
}
@Override
	public void onTestSuccess(ITestResult result)
	{
	Reporter.log(result.getName()+" method PASSED",true);
	}
@Override
public void onTestFailure(ITestResult result)
{
Reporter.log(result.getName()+" method Failed",true);
TakesScreenshot ts=(TakesScreenshot) driver;
File src=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("C:\\Users\\vassu\\git\\repository2\\FlipKart\\src\\main\\resources\\ScreenShots"+result.getName()+".png");
try
{
	Files.copy(src, dest);
}
catch(IOException e)
{

e.printStackTrace();
}
}
@Override
public void onTestSkipped(ITestResult result)
{
	Reporter.log(result.getName()+" method skipped",true);
}
@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		}

@Override
public void onFinish(ITestContext context)
{
	Reporter.log(context.getName()+" ended",true);
}
@Override
public void onStart(ITestContext context)
{
	Reporter.log(context.getName()+" started",true);
}
}