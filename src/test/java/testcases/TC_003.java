package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generics.TestBase;
import pages.AxisLaunchPage;

public class TC_003 extends TestBase {
	
	/*
	 * TC_003: Add Beneficiary for Other Bank Account not an axis services
	 */
	@BeforeClass
	public void setValues(){
		
		browserName = "chrome";
		
		dataSheetName = "TC003";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String beneficciarName, String beneficiaryNickName, String BeneficiaryType, String accountNumber, String confirmAccount, String ifsccode){
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
			.selectRgisterBeneficiaryFor()
			.selectRgisterBeneficiaryType(BeneficiaryType)
			.waitForOtherBankAccountObjectToLoad()
			.enterAccountNumber(accountNumber)
			.enterConfirmAccountNo(confirmAccount)
			.enterIFSCCode(ifsccode)
			.clickProceed()
			.clickLogout();
			
			
	}


}
