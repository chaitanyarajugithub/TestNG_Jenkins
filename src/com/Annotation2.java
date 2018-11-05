package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class Annotation2 {
	public static String DEVKEY="8477b785ee88f5b2d2b7995729415eb4";
	public static String URL="http://127.0.0.1/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

	public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{
	TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);
	api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);
	}
	@Test
	public void Test1()throws Exception
	{
	Annotation2 a=new Annotation2();
	WebDriver driver=new FirefoxDriver();
	WebDriverWait wait=new WebDriverWait(driver, 6);
	String testProject="Gmail";
	String testPlan="SampleTestPlan";
	String testCase="GmailLogin1";
	String build="SampleBuild";
	String notes=null;
	String result=null;
	try{
	driver.manage().window().maximize();
	driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
	/*driver.findElement(By.id("Email")).sendKeys("testlink.msoftgp");
	driver.findElement(By.id("Passwd")).sendKeys("*******");
	driver.findElement(By.id("signIn")).click();
	driver.switchTo().defaultContent();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+Testlink")));*/
	result= TestLinkAPIResults.TEST_FAILED;
	notes="Executed successfully";
	}
	catch(Exception e){
	result=TestLinkAPIResults.TEST_FAILED;
	notes="Execution failed";
	}
	finally{

	a.reportResult(testProject, testPlan, testCase, build, notes, result);
	driver.quit();
	}
	}
}