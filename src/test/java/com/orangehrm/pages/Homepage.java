package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.config.Config;
import com.orangehrm.utility.LaunchApp;

public class Homepage 
{
	
	@FindBy(how=How.XPATH,using="//input[@id='MP_link']")
	WebElement objMarketplace;
	
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
	WebElement objWelcome;
	
	@FindBy(how=How.LINK_TEXT,using="Logout")
	WebElement objLogout;

	
	public void loadHomepage()
	{
		PageFactory.initElements(Config.driver, this);
	}
	
	public void verifyMarketplace()
	{
		System.out.println("In verifyMarketplace method");
		boolean flag1=objMarketplace.isDisplayed();
		System.out.println("Marketplace is displayed");
	}
	
	public void clickonWelcome()
	{
		System.out.println("In clickonWelcome method");
		objWelcome.click();
		System.out.println("ClickonWelcome");
	}
	
	public void waittillLogout(int timeoutsec)
	{
		System.out.println("In waittillLogout method");
		WebDriverWait wait= new WebDriverWait(Config.driver,timeoutsec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		System.out.println("WaittillLogout");
	}
	
	public void clickonLogout() throws InterruptedException
	{
		System.out.println("In clickonLogout method");	
		Thread.sleep(5000);
		objLogout.click();
		System.out.println("clickonLogout");
	}
	
	public static void main(String[] args) throws IOException, InterruptedException
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
		
		
		Homepage hm= new Homepage();
		hm.loadHomepage();
		hm.verifyMarketplace();
		hm.clickonWelcome();
		hm.waittillLogout(15);
		hm.clickonLogout();

	}

}
