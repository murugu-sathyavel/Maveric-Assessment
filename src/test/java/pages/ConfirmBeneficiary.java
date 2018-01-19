package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import generics.TestBase;

public class ConfirmBeneficiary extends TestBase{
	
	public ConfirmBeneficiary(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	public ExitPage clickLogout(){
		
		clickByLinkText("					Log out				");
		
		return new ExitPage(driver);
	}

}
