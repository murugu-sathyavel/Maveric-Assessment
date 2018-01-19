package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generics.TestBase;
import pages.AxisLaunchPage;

public class TC_004 extends TestBase{
	
	/*
	 * TC_003: Add Beneficiary for Same Bank Account
	 */
	@BeforeClass
	public void setValues(){
		
		browserName = "chrome";
		
		dataSheetName = "TC004";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String beneficciarName, String beneficiaryNickName, String BeneficiaryType, String accountNo, String text){
		new AxisLaunchPage(driver)
			.moveToLoginButton()
			.clickLoginLink()
			.enterUserName(username)
			.enterPassword(password)
			.clickSignIn()
			.moveToPayments()
			.clickTransferFunds()
			.clickandAddNewBeneficiary(beneficciarName)
			.enterBeneficiaryNickName(beneficiaryNickName)
			.enterAccountForOwnBank(accountNo)
			.getAccountDetails()
			.verifyAccountName(text)			
			.clickProceed()
			.clickLogout();
			
			
	}

}
