package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.Login;

public class Tc_login extends Baseclass{
	@Test
	public void verifytheliginfunctionality() {
		
		
		logger.info("loginfunctionality test starting");
		
		try {
		Login lg= new Login(driver);
		
		logger.info("User Data Input start");
		logger.info("username input");
		lg.username();
		logger.info("passwd input");
		lg.passward();
		logger.info("click on T&C Radio button");
		lg.radiobutton();
		logger.info("Click On Signin button");
		lg.signinbutton();
		
		logger.info("verify the login sucessful or not ");
		String text=lg.text();
		String msg="ProtoCommerce";
		Assert.assertEquals(text, msg);
		}
		catch(Exception e){
			
			logger.error("Test case failed");
			Assert.fail();
			
			
		}
		
		logger.info("loginfunctionality test finished");
		
		
	
	}

}
