package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.config.Config;
import com.orangehrm.utility.LaunchApp;

public class Loginpage 
{
	@FindBy(how=How.XPATH,using="//input[@name='txtUsername']")
	WebElement objUsername;
	
	@FindBy(how=How.XPATH,using="//input[@name='txtPassword']")
	WebElement objPassword;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnLogin']")
	WebElement objLogin;
  	
	
	public void loadLoginpage()
	{
		PageFactory.initElements(Config.driver, this);
	}
	
	public void enterUsername(String username)
	{
		System.out.println("In enterUsername method");
		objUsername.sendKeys(username);
		
	}
	
	public void enterPassword(String password)
	{
		System.out.println("In enterPassword method");
		objPassword.sendKeys(password);
	}
	
	public void clickonLogin()
	{
		System.out.println("In clickonLogin method");
		objLogin.click();
	}
	
	
	public static void main(String[] args) throws IOException
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser("chrome");
		lc.enterApplicationURL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		lc.waittillLoginpageloaded(15);
		lc.maximizeBrowser();
		
		Loginpage lg= new Loginpage();
		lg.loadLoginpage();
		lg.enterUsername("Admin");
		lg.enterPassword("admin123");
		lg.clickonLogin();
	}
	
	
}
