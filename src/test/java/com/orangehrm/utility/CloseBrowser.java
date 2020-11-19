package com.orangehrm.utility;

import com.orangehrm.config.Config;

public class CloseBrowser 
{
	public void closeBrowser()
	{
		System.out.println("In closeBrowser method");
		Config.driver.close();
	}

}
