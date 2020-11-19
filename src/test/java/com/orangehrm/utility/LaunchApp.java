package com.orangehrm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.orangehrm.config.Config;

public class LaunchApp 
{
	Properties prop= new Properties();
	
	public void openBrowser(String browsernm) throws IOException
	{
		FileInputStream fis= new FileInputStream("F:\\Suvidya_data\\Java_Selenium\\OrangeHRMPOMDemo\\src\\test\\resources\\Config.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equalsIgnoreCase(browsernm))
		{
			System.out.println("In chrome browser");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeexepath"));
			Config.driver= new ChromeDriver();
			System.out.println("Chrome browser is opened successfully");			
		}else if(prop.getProperty("browser").equalsIgnoreCase(browsernm))
		{
			System.out.println("In IE browser");
			System.setProperty("webdriver.ie.driver", prop.getProperty("ieexepath"));
			Config.driver=new InternetExplorerDriver();
			System.out.println("IE browser is opened successfully");		
		}else
		{
			System.out.println("In Firefox browser");
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			Config.driver=new FirefoxDriver();
			System.out.println("Firefox browser is opened successfully");
		}
	}
	
	
	public void enterApplicationURL(String urlnm)
	{
		System.out.println("In enterApplicationURL method");
		Config.driver.get(urlnm);
	}
	
	public void waittillLoginpageloaded(int timeoutsec)
	{
		System.out.println("In waittillLoginpageloaded method");
		Config.driver.manage().timeouts().pageLoadTimeout(timeoutsec,TimeUnit.SECONDS);		
	}
	
	public void maximizeBrowser()
	{
		System.out.println("In maximizeBrowser method");
		Config.driver.manage().window().maximize();
	}
	
	public static void main(String[] args) throws IOException 
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser("chrome");
		lc.enterApplicationURL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		lc.waittillLoginpageloaded(15);
		lc.maximizeBrowser();
		
	} 
	

}
