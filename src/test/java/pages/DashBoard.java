package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import generics.TestBase;

public class DashBoard extends TestBase{
	
	public DashBoard(RemoteWebDriver driver){
		
		this.driver = driver;
	}
	
	public boolean verifyBalanceInDashBoard(String amount){
		
		String balanceAmount = getBalanceAmount();
		
		if(amount.equals(balanceAmount)){
			return true;
		}else{
			return false;
		}
	}
	
	public DashBoard moveToPayments(){
		
		mouseOverByXpath("//a[text()='PAYMENTS']");
		
		wait(5000);
		
		return this;
	}
	
	public TransferFunds clickTransferFunds(){
		
		clickByXpath("(//div[@id='accountsCallout'])[2]/descendant::a");
		
		return new TransferFunds(driver);
	}

}
