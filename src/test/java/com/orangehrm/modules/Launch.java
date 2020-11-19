package com.orangehrm.modules;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.utility.LaunchApp;

public class Launch {
  
  @Parameters({"browser","url","timeoutsec"})
  @Test
  public void executeLaunch(String browsernm,String urlnm,int timeoutsec) throws IOException
  {
	  LaunchApp lc= new LaunchApp();
	  lc.openBrowser(browsernm);
	  lc.enterApplicationURL(urlnm);
	  lc.waittillLoginpageloaded(timeoutsec);
	  lc.maximizeBrowser();
	  
  }
}
