package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {
	

	public Login(WebDriver driver) {
		
		super(driver);	
		
	}
	
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="terms")
	WebElement termandcondition ;
	@FindBy(id="signInBtn")
	WebElement signinbutton;
	@FindBy(xpath="//a[normalize-space()='ProtoCommerce']")
	WebElement Text;
	
	
	/*public void username(String email) {
		
		username.sendKeys(email);
	}
	
	public void passward(String passwd) {
		password.sendKeys(passwd);
	}*/
	
public void username() {
		
		username.sendKeys("rahulshettyacademy");
	}
	
	public void passward() {
		password.sendKeys("Learning@830$3mK2");
	}
	
	public void radiobutton() {
		
		termandcondition.click();
	}
	
 public void signinbutton() {
		
	signinbutton.click();
	}

 public String text() {
	return Text.getText();
}
	
	

}
