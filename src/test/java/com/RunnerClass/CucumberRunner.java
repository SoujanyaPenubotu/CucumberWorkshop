package com.RunnerClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utilities;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		monochrome =true,strict=true,
		features = "Features/Tc_01_US101_Login.feature",
		glue= "com.TestCases",
		plugin= {"pretty","html:target/cucumber-html-report"},
		
		tags= {"@Regression"}
		
		)
public class CucumberRunner extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public static Fillo fillo;
	
	public static Connection connection;
	
	public static Recordset recordset;
	
	public static String resultpath;
	
	@BeforeSuite
	public static void LoadTestData()
	{
		//Create results folder on current date
		resultpath = Utilities.createResultsFolder();
		connectToExcel();
	//	extent = new ExtentReports("Tc_01_US101_Login.html");
	}
	

	public static void startTest_Report()
	{
		test=extent.startTest("Test Execution Status");
	}
	
	@AfterTest
	public static void endTest()
	{
		extent.endTest(test);
		driver.quit();
		extent.flush();
	}
	
	public static String takescreenshot()
	{
		String path="";
		
		TakesScreenshot sht=(TakesScreenshot) driver;
		String print=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/jpg;base64, "+print;
	}
	

	
//################################################################################################################	
	/*Method Name: waitForElement
	 *Purpose: This method is developed to maintain a constant wait across all the pages and elements
	 *Input Parameters: User must send WebElement as parameters 
	 *Output Parameters: NA
	 *Designed By: 
	 *Creation Date:
	 *Reviewed Date:
	 *Comments:
	 *Modified Date:
	 */
//################################################################################################################
	public static void waitForElement(WebElement element)
	{
		for(int i=0;i<=15;i++)
		{
			//try to perform mouse hovering action on a web element
			try
			{	
				
				Actions acc = new Actions(driver);
				acc.moveToElement(element).build().perform();
				
				System.out.println("Wait is completed and object is found");
				// if an element is found , break the execution loop
				break;
								
			}
			catch(Exception e)
			{
				// if an element is not found , then wait for 1 second
				try
				{
					Thread.sleep(1000);
				}
				catch(Exception e1)
				{
					System.out.println(e1.getMessage());
				}
			}
		}
	}
	//################################################################################################################
	/*Method name:connectToExcel
	 * 
	 * Purpose: For fast retrival of data we are converting excel as database
	 * 
	 * Plugin Dependencay: Dependency is added in POM.XML
	 * 
	 * Input Parameter: NA
	 * 
	 * Output Parameter: NA
	 * 
	 */
	//################################################################################################################ 	
	public static void connectToExcel()
	{
		fillo=new Fillo();
		try 
		{
			String	Currentdir =System.getProperty("user.dir");
			connection=fillo.getConnection(Currentdir+"\\Testdata\\Testdata.xlsx");
			
			System.out.println("********************Connection Established successfully*************************");
			
		} 
		catch (FilloException e) 
		{
		
			e.printStackTrace();
		}
		
		
	}
	
	//################################################################################################################
	/*Method name:getData
	 * 
	 * Purpose: Get the data for a particular test case with respective to the iteration
	 * * 
	 * Plugin Dependencay: Dependency is added in POM.XML
	 * 
	 * Input Parameter:Testcase name,iteration
	 * 
	 * Output Parameter: String data
	 * 
	 */
	//################################################################################################################ 	

	public static String getData(String sheetname,String Testcasename,String fieldname,int itr)
	{
		String data="";
		try 
		{		
			String strQuery="Select "+fieldname+" from "+sheetname+" where Tc_Name='"+Testcasename+"' and Iteration"+itr;
			recordset=connection.executeQuery(strQuery);
		 
			while(recordset.next())
			{
				System.out.println(recordset.getField(fieldname));
				data=recordset.getField(fieldname);
				break;
			}
	
					
		}
		catch(Exception e)
		{
			System.out.println("No records found");
		}
		finally
		{
			recordset.close();
		}
		return data;
	}
	
	public static int getIterationCount(String sheetname,String Testcasename)
	{ 
		int data=1;
		try 
		{		
			String strQuery="Select "+Testcasename+" from "+sheetname;
			recordset=connection.executeQuery(strQuery);
			System.out.println(recordset.getCount());
			
			while(recordset.next())
			{
				data++;
			}
	
		}
		catch(Exception e)
		{
			System.out.println("No records found");
		}
		finally
		{
			recordset.close();
		}
		return data;
	}
	
	public static String getEnvURL(String Env)
	{
		String data="";
		try 
		{		
			String strQuery="Select URL from CommonDetails where Environment='"+Env+"' and Execute=Yes";
			recordset=connection.executeQuery(strQuery);
		 
			while(recordset.next())
			{
				System.out.println(recordset.getField(Env));
				data=recordset.getField(Env);
				break;
			}
	
		}
		catch(Exception e)
		{
			System.out.println("No URL found");
		}
		
		return data;
	}
	
	public static void initialzeReport(String classname)
	{
			extent = new ExtentReports(resultpath+"\\"+classname+".html");
		
	}
	public static void LogEvent(String status, String Description)
	{
		switch(status.toLowerCase())
		{
		case "pass" :
			test.log(LogStatus.PASS,Description+test.addBase64ScreenShot(takescreenshot()));
			break;
			
		case "fail" :
			test.log(LogStatus.FAIL,Description+test.addBase64ScreenShot(takescreenshot()));
			break;
			
		}
	}

}

