package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generics.TestBase;
import pages.AxisLaunchPage;

public class TC_005 extends TestBase{
	
	/*
	 * TC_005: Compare list of payees in account
	 */
	@BeforeClass
	public void setValues(){
		
		browserName = "chrome";
		
		dataSheetName = "TC005";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password){
		new AxisLaunchPage(driver)
			.moveToLoginButton()
			.clickLoginLink()
			.enterUserName(username)
			.enterPassword(password)
			.clickSignIn()
			.moveToPayments()
			.clickTransferFunds()
			.verifyListOfBeneficiars();
	}

}
