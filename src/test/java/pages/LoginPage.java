package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import generics.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage(RemoteWebDriver driver){
		
		this.driver = driver;
	}
	
	public LoginPage enterUserName(String username){
		
		enterById("loginId", username);
		
		return this;
		
	}
	
	public LoginPage enterPassword(String password){
		
		enterById("newPassword", password);
		
		return this;
	}
	
	public DashBoard clickSignIn(){
		
		clickByCss("input[value='Login']");
		
		return new DashBoard(driver);
	}

}
