package com.TestCases;

import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.RunnerClass.CucumberRunner;
import com.ScreenFunctions.ContactDetails;
import com.ScreenFunctions.Navigation;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TC_02_US101_EditContactDetails extends CucumberRunner
{

	@Given("^Login to Application with valid credentials$")
	public static void LaunchAppilicationAndLogin()
	{

		driver = new FirefoxDriver();
		System.out.println("Firefox Browser is launched");
		
		driver.get("http://www.testingmasters.com/hrm");
		System.out.println("Entered URL");
		
		driver.manage().window().maximize();
		
		
		Navigation logn = PageFactory.initElements(driver, Navigation.class);
		logn.LoginToAppilication("user01","pass1234");
		
		
	}
	@And("Navigate to My Info Page")
	public static void GotoMyInfo()
	{
		Navigation NavigateMI = PageFactory.initElements(driver, Navigation.class);
		NavigateMI.NavigateToMyInfo();
	}
	@Then("Navigate to Contact Details Page")
	public static void GotoContactDetails()
	{
		Navigation NavigateCD = PageFactory.initElements(driver, Navigation.class);
		NavigateCD.NavigateToContactDetails();
	}
/*	@And("Click on Edit button")
	public static void ClickEdit()
	{
		ContactDetails cd = PageFactory.initElements(driver, ContactDetails.class);
		cd.ClickOnEdit();
	}
	@Then("^Clear all the existing values in all fields$")
	public static void ClearData()
	{
		ContactDetails clrDetails = PageFactory.initElements(driver, ContactDetails.class);
		clrDetails.ClearAllValues();
	}
	@Then("Enter valid details one by one in all fields")*/
	@Then("Edit contact details and verify the success message and verify that saved fields are disabled")
	public static void EnterData(DataTable fieldValues)
	{
		List<List<String>> val=fieldValues.raw();
		
		for (int i=0;i<val.size();i++)
		{
		System.out.println("******Editing contact details for "+(i+1)+" set of data******");	
		ContactDetails cd = PageFactory.initElements(driver, ContactDetails.class);
		cd.ClickOnEdit();
		cd.ClearAllValues();
		cd.EnterAllValues(val.get(i).get(0),val.get(i).get(1),val.get(i).get(2),val.get(i).get(3),val.get(i).get(4),val.get(i).get(5),val.get(i).get(6),val.get(i).get(7),val.get(i).get(8),val.get(i).get(9),val.get(i).get(10));
		cd.ClickOnSaveAndVerifySuccessMessage();
		cd.VerifyIfFieldsAreDisabled();
		
		}
	}
	/*@And("^Click on Save button and Verify for the success message$")
	public static void SaveAndVerifySuccessMsg()
	{
		ContactDetails verifymsg = PageFactory.initElements(driver, ContactDetails.class);
		verifymsg.ClickOnSaveAndVerifySuccessMessage();
	}
	@Then("After Success message is displayed validate if saved fields are disabled")
	public static void VerifyAllFieldsAreDisabled()
	{
		ContactDetails VerifyDisFields = PageFactory.initElements(driver, ContactDetails.class);
		VerifyDisFields.VerifyIfFieldsAreDisabled();
	}*/
	
	@Then("Logout of the Application")
	public static void LogoutOfApplication()
	{
		Navigation logn = PageFactory.initElements(driver, Navigation.class);
		logn.Logout();
	}
}
