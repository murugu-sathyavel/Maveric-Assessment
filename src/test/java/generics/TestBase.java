package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;



public class TestBase extends GenericMethods{
	
	//Beneficiarys listPayees = new Beneficiarys();
	
	public String browserName;//To get the name of the browser to invoke the application
	
	public String dataSheetName;//To get the excel sheet name for input provider
	
	public List<String> names = null;
	
	String[] beneficiarys = {"Sathish Muthukumaran","Karthik Pollachi","Antony","Deva Kanth","Rajesh Sas","Alagu"
			+"Nitish","Rajesh Vit","Siva Elite","Palani"};

	
	//Before method - Here we are using this annotated method to get the browser name from the
	//Test case class and passed into the invokeApp() Method.
	@BeforeMethod
	public void beforeMethod(){
		
		invokeApp(browserName);
	}
	
	//Quit the web driver instance.
	@AfterMethod
	public void afterMethod(){
		quitBrowser();
	}
	
	//
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}
	
	public String getBalanceAmount(){
		
		WebElement row = getElementByClassName("cm-table-row");
		
		List<WebElement> cols = row.findElements(By.tagName("td"));
		
		System.out.println(cols.size());
		
		String amountString = cols.get(5).getText();
		
		System.out.println(amountString);
		
		int index = amountString.lastIndexOf(")");
		
		String balance = amountString.substring(index+1);
		
		System.out.println(balance);
		
		return balance;
	}
	
	public void SelectBeneficiaryType(String option){
		
		List<WebElement> options = 	getElmentsByXpath("(//ul[@role='listbox'])[1]/li");
		
		// Loop through the options and select the one that matches
        for (WebElement opt : options) {
        	 System.out.println(opt.getText());
           if (opt.getText().equals(options)) {
               opt.click();
              break;
            }
        }
		
	}
	
	public List<String> listOfBeneficiarys(){
		
		names = new ArrayList<String>();
		
		WebElement table = driver.findElement(By.xpath("(//table)[3]"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++){
			
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++){
				
				if(cols.get(j).getText().equalsIgnoreCase("Active")){
					System.out.println(cols.get(j-1).getText());
					names.add(cols.get(j-1).getText());
				}
				
					
				}
			}

		return names;
		
		
	}
	
	public void compareBeneficiarys(){
		
		List<String> expectedPayees = Arrays.asList(beneficiarys);
		
		List<String> name = listOfBeneficiarys();
		
		Assert.assertEquals(name,expectedPayees);
		
	}
	
	
		

		
	}
	
	
	

	
	


