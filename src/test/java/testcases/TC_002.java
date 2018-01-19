package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generics.TestBase;
import pages.AxisLaunchPage;

public class TC_002 extends TestBase{
	
	/*
	 * TC_002: Add Beneficiary for IMT services
	 */
	@BeforeClass
	public void setValues(){
		
		browserName = "chrome";
		
		dataSheetName = "TC002";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String beneficciarName, String beneficiaryNickName, String BeneficiaryType, String mobile, String address, String pincode){
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
			.waitForInstantMoneyTransferObjectsToLoad()
			.enterMobileNumber(mobile)
			.enterBeneficiayAddress(address)
			.enterBeneficiaryPin(pincode)
			.clickProceed()
			.clickLogout();
			
			
	}


}
