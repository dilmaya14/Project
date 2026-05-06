package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_DDT extends BasePage {
	
public login_DDT(WebDriver driver) {
		
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
	
	
	public void username(String email) {
		
		username.sendKeys(email);
	}
	
	public void passward(String passwd) {
		password.sendKeys(passwd);
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
