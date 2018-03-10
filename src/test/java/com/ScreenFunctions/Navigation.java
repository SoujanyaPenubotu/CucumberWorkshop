package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.RunnerClass.CucumberRunner;

public class Navigation extends CucumberRunner
{
	@FindBy(how=How.XPATH,using="//input[@id='txtUsername']")
	public static WebElement Edt_UserName;
	
	@FindBy(how=How.NAME,using="txtPassword")
	public static WebElement Edt_Password;
	
	@FindBy(how=How.ID,using="btnLogin")
	public static WebElement Btn_Login; 
	
	@FindBy(how=How.ID,using="welcome")
	public static WebElement Lnk_Welcome;
	
	@FindBy(how=How.XPATH,using="//a[text()='Logout']")
	public static WebElement Lnk_Logout;
	
	@FindBy(how=How.XPATH,using="//b[text()='My Info']")
	public static WebElement Lnk_MyInfo;
	
	@FindBy(how=How.LINK_TEXT,using="Contact Details")
	public static WebElement Lnk_ContactDetails;

	public boolean LoginToAppilication(String UserName,String Password)
	{
		boolean status=true;
		try
		{
				
		Edt_UserName.sendKeys(UserName);
		System.out.println("UserName:"+UserName+" entered ");
		waitForElement(Edt_Password);
		Edt_Password.sendKeys(Password);
		System.out.println("Password:"+Password+" entered ");
		Btn_Login.click();
		System.out.println("Login button is clicked");
					
		
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			status=false;
		}
		return status;
	}
	public boolean NavigateToMyInfo()
	{
		boolean status=true;
		try 
		{
			Lnk_MyInfo.click();
			System.out.println("Clicked on My Info link");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public boolean NavigateToContactDetails()
	{
		boolean status=true;
		try 
		{
			Lnk_ContactDetails.click();
			System.out.println("Clicked on Contact Details link");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public boolean Logout()
	{
		boolean status=true;
		try 
		{	//Click on welcome link before clicking on Logout link
			Lnk_Welcome.click();
			Lnk_Logout.click();
			System.out.println("Logout Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	
}
