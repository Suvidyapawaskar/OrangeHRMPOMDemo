package com.orangehrm.modules;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.pages.Homepage;
import com.orangehrm.pages.Loginpage;
import com.orangehrm.utility.CloseBrowser;

import org.testng.annotations.Test;

public class Login {
  
  @Parameters({"usernm","passwd"})
  @Test
  public void executeLoginwithValidds(String username,String password) throws InterruptedException 
  {
	  Loginpage lg= new Loginpage();
	  lg.loadLoginpage();
	  lg.enterUsername(username);
	  lg.enterPassword(password);
	  lg.clickonLogin();
	  
	  Homepage hm= new Homepage();
	  hm.loadHomepage();
	  hm.verifyMarketplace();
	  hm.clickonWelcome();
	  hm.clickonLogout();
	  
	  CloseBrowser clbr= new CloseBrowser();
	  clbr.closeBrowser();
			  
  }
  
  @Parameters({"invalidusernm","invalidpasswd"})
  @Test
  public void executeLoginwithInvalidds(String usernm,String passwd) throws InterruptedException
  {
	  Loginpage lg= new Loginpage();
	  lg.loadLoginpage();
	  lg.enterUsername(usernm);
	  lg.enterPassword(passwd);
	  lg.clickonLogin();	   
	  CloseBrowser clbr= new CloseBrowser();
	  clbr.closeBrowser(); 
	  
  }
  
}
