package com.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities 
{
/*Function Name: createResultsFolder
 * 
 * Description: Create a results folder with current date 
 * 
 * Author: Soujanya
 * 
 * Date: 10-Feb-2018
 * 
 * Reviewer: NA
 * 
 * Comments: 
 */
		
	public static String createResultsFolder()
	{
		//Get the system test directory path
		String path="";
		String	Currentdir =System.getProperty("user.dir");
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-YYYY");
		Date d= new Date();
		// Format the date into dd-MM-YYYY
		System.out.println(sdf.format(d));
		System.out.println(Currentdir);
		
		File f= new File(Currentdir+"\\Results\\"+sdf.format(d));
		if(! f.exists())
			{
				f.mkdirs();	
				path=Currentdir+"\\Results\\"+sdf.format(d);
			}
		else
		{
			path=Currentdir+"\\Results\\"+sdf.format(d);
		}
		return path;
	}

}
