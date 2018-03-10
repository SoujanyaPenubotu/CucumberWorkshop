package com.ScreenFunctions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.RunnerClass.CucumberRunner;

public class ContactDetails extends CucumberRunner
{

	@FindBy(how=How.ID,using="btnSave")
	WebElement Btn_Edit;
	
	@FindBy(how=How.ID,using="btnSave")
	WebElement Btn_Save;
	
	@FindBy(how=How.XPATH,using="//a[text()='Successfully Saved']")
	WebElement Ele_SuccessfullySaved;
	
	@FindBy(how=How.ID,using="contact_street1")
	WebElement Edt_AddStreet1;
	
	@FindBy(how=How.ID,using="contact_street2")
	WebElement Edt_AddStreet2;	

	@FindBy(how=How.ID,using="contact_city")
	WebElement Edt_City;
	
	@FindBy(how=How.ID,using="contact_province")
	WebElement Edt_State_Province;
	
	@FindBy(how=How.ID,using="contact_emp_zipcode")
	WebElement Edt_Zip_PostalCode;
	
	@FindBy(how=How.ID,using="contact_country")
	WebElement Lst_Country;
	
	@FindBy(how=How.ID,using="contact_emp_hm_telephone")
	WebElement Edt_HomeTelephone;
	
	@FindBy(how=How.ID,using="contact_emp_mobile")
	WebElement Edt_Mobile;
	
	@FindBy(how=How.ID,using="contact_emp_work_telephone")
	WebElement Edt_WorkTelephone;
	
	@FindBy(how=How.ID,using="contact_emp_work_email")
	WebElement Edt_WorkEmail;
	
	@FindBy(how=How.ID,using="contact_emp_oth_email")
	WebElement Edt_OtherEmail;
	
	public boolean ClickOnEdit()
	{
		boolean status=true;
		try
		{			
			Btn_Edit.click();
			System.out.println("Edit button clicked Successfully");	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public boolean ClearAllValues()
	{
		boolean status=true;
		try
		{
			Edt_AddStreet1.clear();
			Edt_AddStreet2.clear();
			Edt_City.clear();
			Edt_State_Province.clear();
			Edt_Zip_PostalCode.clear();
			
			Edt_HomeTelephone.clear();
			Edt_Mobile.clear();
			Edt_WorkTelephone.clear();
			Edt_WorkEmail.clear();
			Edt_OtherEmail.clear();
			
			System.out.println("All field values are cleared");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public boolean EnterAllValues(String Addr1,String Addr2,String City, String State, String Zip, String Country, String HmTelePh,String MobileNum,String WorkTelePh , String WorkEmail, String OtherEmail )
	{
		boolean status=true;
		try
		{
			Edt_AddStreet1.sendKeys(Addr1);
			Edt_AddStreet2.sendKeys(Addr2);
			Edt_City.sendKeys(City);
			Edt_State_Province.sendKeys(State);;
			Edt_Zip_PostalCode.sendKeys(Zip);
			
			Select s1 = new Select(Lst_Country);
			s1.selectByVisibleText(Country);
			
			Edt_HomeTelephone.sendKeys(HmTelePh);
			Edt_Mobile.sendKeys(MobileNum);
			Edt_WorkTelephone.sendKeys(WorkTelePh);
			Edt_WorkEmail.sendKeys(WorkEmail);
			Edt_OtherEmail.sendKeys(OtherEmail);
			System.out.println("Data entered successfully into all fields");			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public boolean ClickOnSaveAndVerifySuccessMessage()
	{
		boolean status=true;
		try
		{			
			Btn_Save.click();
			System.out.println("Save button is clicked");	
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public boolean VerifyIfFieldsAreDisabled()
	{
		boolean status=true;
		try
		{
		/*	//boolean Arr[] = {Edt_AddStreet1.isEnabled(),"Edt_AddStreet2","Edt_City","Edt_State_Province","Edt_Zip_PostalCode","Lst_Country","Edt_HomeTelephone","Edt_Mobile","Edt_WorkTelephone","Edt_WorkEmail","Edt_OtherEmail"};
			boolean Arr[] = {Edt_AddStreet1.isEnabled(),Edt_AddStreet2.isEnabled(),Edt_City.isEnabled(),Edt_State_Province.isEnabled(),Edt_Zip_PostalCode.isEnabled(),Lst_Country.isEnabled(),Edt_HomeTelephone.isEnabled(),Edt_Mobile.isEnabled(),Edt_WorkTelephone.isEnabled(),Edt_WorkEmail.isEnabled(),Edt_OtherEmail.isEnabled()};
			int flagCount=0;
			for(int i=0;i<Arr.length;i++)
			{
				boolean flagEnabled = Arr[i];
				
				if(!flagEnabled)
				{
					flagCount++;
					//System.out.println(flagEnabled);
				}
				
			}
			
			System.out.println("Number of Disabled Fields after clicking on Save = "+flagCount);
			
		//	boolean flagEnabled = Edt_AddStreet1.isEnabled();
		//  System.out.println(flagEnabled);
					*/
			
		List<Boolean> Arr1 = new ArrayList<Boolean>();
		Arr1.add(Edt_AddStreet1.isEnabled());
		Arr1.add(Edt_AddStreet2.isEnabled());
		Arr1.add(Edt_City.isEnabled());
		Arr1.add(Edt_State_Province.isEnabled());
		Arr1.add(Edt_Zip_PostalCode.isEnabled());
		Arr1.add(Lst_Country.isEnabled());
		Arr1.add(Edt_HomeTelephone.isEnabled());
		Arr1.add(Edt_Mobile.isEnabled());
		Arr1.add(Edt_WorkTelephone.isEnabled());
		Arr1.add(Edt_WorkEmail.isEnabled());
		Arr1.add(Edt_OtherEmail.isEnabled());
					
		int flagCount=0;
		
		for(Boolean str:Arr1)
		{
			if (!str)
			{	flagCount++;
				//System.out.println(str);
			}
		}
		System.out.println("Number of Disabled Fields after clicking on Save = "+flagCount);
		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	
	
}
