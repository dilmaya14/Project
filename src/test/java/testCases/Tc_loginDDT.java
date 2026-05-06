package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.login_DDT;
import utility.DataProviders;

public class Tc_loginDDT extends Baseclass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String passwd) {
		
		
		logger.info("loginfunctionality_DDT test starting");
		
		try {
			login_DDT lg= new login_DDT(driver);
		
		logger.info("User Data Input start");
		logger.info("username input");
		lg.username(email);
		System.out.println(email);
		logger.info("passwd input");
		lg.passward(passwd);
		System.out.println(passwd);
		logger.info("click on T&C Radio button");
		lg.radiobutton();
		logger.info("Click On Signin button");
		lg.signinbutton();
		
		logger.info("verify the login sucessful or not ");
		String text=lg.text();
		String msg="ProtoCommerce";
		Assert.assertEquals(text, msg);
		
		
		/*Data valid= login sucessfull - logout
		 			  login failed- test failed
		 			  
		 Data invalid= login sucessfull= testfail=logout
		 			  login failed= test pass
		 */
		
	
		}
		catch(Exception e){
			
			logger.error("Test case failed");
			Assert.fail();
			
			
		}
		
		logger.info("loginfunctionality_DDT test finished");
		
		
	
	}

}
