package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import generics.TestBase;
import pages.AxisLaunchPage;

public class TC_001 extends TestBase{
	
	/**
	 * TC_001 : Test case login to the Axis bank application and verify the balance Amount in DashBoard.
	 */
	
	@BeforeClass
	public void setValues(){
		
		browserName = "chrome";
		
		dataSheetName = "TC001";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String amount){
		new AxisLaunchPage(driver)
			.moveToLoginButton()
			.clickLoginLink()
			.enterUserName(username)
			.enterPassword(password)
			.clickSignIn()
			.verifyBalanceInDashBoard(amount);
	}

}
