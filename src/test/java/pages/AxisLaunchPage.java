package pages;

import java.util.Set;

import org.openqa.selenium.remote.RemoteWebDriver;

import generics.TestBase;

public class AxisLaunchPage extends TestBase{
	
	public AxisLaunchPage(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	public AxisLaunchPage moveToLoginButton(){
		
		mouseOverByCss("button[class='login']");
		
		try {
			wait(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	public LoginPage clickLoginLink(){
		
		clickByXpath("(//a[text()='Login'])[1]");
		//clickByLinkText("Login");
		
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new LoginPage(driver);
	}

}
