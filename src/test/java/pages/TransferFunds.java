package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.TestBase;

public class TransferFunds extends TestBase{
	
	public TransferFunds(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	
/*public TransferFunds waitForBeneficiaryNameToLoad(){
		
		WebElement payee =getElementByXpath("//input[@title='PayeeName']");
		
		exlicitWait(10, payee);
		
		return this;
	}*/
	
	/*public TransferFunds enterBeneficiaryName(String name){
		
		//enterByXpath("//input[@title='PayeeName']", name);
		enterByCss("input[title='PayeeName']", name);
		
		return this;
	}*/
	
	public TransferFunds enterBeneficiaryNickName(String name){
		
		enterByXpath("//input[@title='PayeeNickname']", name);
		
		return this;
	}
	
	public TransferFunds selectRgisterBeneficiaryFor(){
		
		clickByClassName("selectboxit-arrow-container");
		
		return this;
	}
	
	public TransferFunds selectRgisterBeneficiaryType(String option){
		
		SelectBeneficiaryType(option);
		
		return this;
	}
	
	public TransferFunds waitForInstantMoneyTransferObjectsToLoad(){
		
		WebElement mobile =getElementByXpath("//input[@title='BnfMobile']");
		
		exlicitWait(10, mobile);
		
		return this;
	}
	
	public TransferFunds enterMobileNumber(String number){
		
		enterByXpath("//input[@title='BnfMobile']", number);
		
		return this;
	}
	
	public TransferFunds  clickandAddNewBeneficiary(String name){
		
		//clickByXpath("//input[@value='Add New Payee']");
		driver.findElement(By.xpath("//input[@value='Add New Payee']")).click();
		driver.findElement(By.cssSelector("input[title='PayeeName']")).sendKeys(name);
		wait(5000);
		
		//return new AddNewBeneficiary(driver);
		return this;
	}
	
	public TransferFunds enterBeneficiayAddress(String address){
		
		enterByXpath("//textarea[@title='BeneAddress']", address);
		
		return this;
	}
	
	public TransferFunds enterBeneficiaryPin(String pincode){
		
		enterByXpath("//input[@title='Pincode']", pincode);
		
		return this;
	}
	
	public ConfirmBeneficiary clickProceed(){
		
		clickByXpath("//input[@value='Proceed']");
		
		return new ConfirmBeneficiary(driver);
	}
	
	public TransferFunds waitForOtherBankAccountObjectToLoad(){
		
		WebElement accountNo = driver.findElement(By.xpath("(//input[@title='AccountNo'])[2]"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(accountNo));
		
		return this;
	}
	
	public TransferFunds enterAccountNumber(String accountNumber){
		
		enterByXpath("//input[@title='AccountNo'])[2]", accountNumber);
		
		return this;
	}
	
	public TransferFunds enterConfirmAccountNo(String confirmAccount){
		
		enterByXpath("//input[@title='ConfAcctNo']", confirmAccount);
		
		return this;
	}
	
	public TransferFunds enterIFSCCode(String ifsccode){
		
		enterByXpath("//input[@title='IFSC code']", ifsccode);
		
		return this;
	}
	
	public TransferFunds enterAccountForOwnBank(String accountNo){
		
		enterByXpath("(//input[@title='AccountNo'])[1]", accountNo);
		
		return this;
	}
	
	public TransferFunds getAccountDetails(){
		
		clickByXpath("//input[@value='Get Account Details']");
		
		return this;
	}
	
	public TransferFunds verifyAccountName(String text){
		
		verifyTextByXpath("(//span[@class='m_searchsimpletext'])[1]", text);
		
		return this;
	}
	
	public TransferFunds verifyListOfBeneficiars(){
		
		compareBeneficiarys();
		
		return this;
	}
	
	
	

}
