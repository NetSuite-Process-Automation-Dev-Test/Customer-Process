package com.qa.customerCreation.stepDefinition;

import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.qa.customerCreation.pages.AuthenticationPage;
import com.qa.customerCreation.pages.CustomerCreationPage;
import com.qa.customerCreation.pages.HomePage;
import com.qa.customerCreation.pages.LoginPage;
import com.qa.customerCreation.util.ExcelDataToDataTable;
import com.qa.customerCreation.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;

public class customerCreationStepDef extends TestBase{
	
	LoginPage loginPage;
	AuthenticationPage authPage;
	HomePage homePage;
	CustomerCreationPage customerCreationPage;
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	@Then("^Create a Customer using excel data at \"([^\"]*)\"$")
	public void create_a_Customer_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable customerData)
			throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Customer creation in NetSuite");
			loginfo = test.createNode("login");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("roleText"), prop.getProperty("roleType"));
			loginfo.pass("Login Successful in Netsuite");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "login");
		}
		
		ExtentTest loginfo2 = null;
		for(Map<String,String> data: customerData.asMaps(String.class, String.class)) {
			try {
				String customerType = data.get("Type");
				String customerFirstName = data.get("First Name");
				String customerLastName = data.get("Last Name");
				String customerCompany = data.get("Company Name");
				String customerParentCompany = data.get("Parent Company");
				String salesRep = data.get("Sales Rep");
				String email = data.get("Email");
				String currency = data.get("Currency");
				String contactName = data.get("Contact Name");
				String contactEmail = data.get("Contact Email");
				String contactRole = data.get("Contact Role");
				String country = data.get("Address: Country");
				String city = data.get("Address: City");
				String state = data.get("Address: State");
				String shippingFlag = data.get("Shipping Flag");
				String billingFlag = data.get("Billing Flag");
				String bankName = data.get("Bank: Name");
				String bankType = data.get("Bank: Type");
				String bankAccountNo = data.get("Bank: Account No");
				String bankFinancialNo = data.get("Bank: Financial No");
				String bankTransitNo = data.get("Bank: Transit No");
								
				String customer = customerFirstName+" "+customerLastName+" "+customerCompany;
				loginfo2 = test.createNode("Verify creating a Customer '"+customer.trim()+"' in NetSuite");
				boolean customerCreationFlag;
				customerCreationPage = homePage.clickOnNewCustomerLink();
				customerCreationFlag = customerCreationPage.createNewCustomer(customerType, customerFirstName,
						customerLastName, customerCompany, customerParentCompany, salesRep,
						email, currency, contactName, contactEmail, contactRole, country,
						city, state, shippingFlag, billingFlag, loginfo2);
				if(customerCreationFlag) {
					customerCreationPage.verifyContactAddition(customer.trim(), customerType, contactName,
							contactEmail, contactRole, loginfo2);
					customerCreationPage.addBankingDataForCustomer(customer.trim(), bankName, bankType, bankAccountNo,
							bankFinancialNo, bankTransitNo, loginfo2);
				}
			} catch (Exception e) {
				testStepHandle("FAIL", driver, loginfo2, e, "Verification of Customer creation in NetSuite");
			}
		}
	}
	
	@Then("^Verification of Update Primary feature for contacts in the Customer record using excel data at \"([^\"]*)\"$")
	public void verification_of_Update_Primary_feature_for_contacts_in_the_Customer_record(@Transform(ExcelDataToDataTable.class)
	DataTable customerData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Update Primary contact feature for the Customer");
			for(Map<String,String> data: customerData.asMaps(String.class, String.class)) {
				String customer = data.get("Customer");
				String primaryContact = data.get("Primary Contact");
				loginfo = test.createNode("Verify updating the Contact: '"+primaryContact+"' as Primary contact for the Customer: "+customer);
				homePage.verifyUpdatePrimaryContactFunctionality(customer, primaryContact, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Update Primary contact feature for the Customer");
		}
	}
	
	@Then("^Verify updating primary bank account for customer using excel data at \"([^\"]*)\"$")
	public void verification_of_Update_Primary_account_for_Customer(@Transform(ExcelDataToDataTable.class)
	DataTable customerData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Update Primary Bank Account feature for the Customer");
			for(Map<String,String> data: customerData.asMaps(String.class, String.class)) {
				String customer = data.get("Customer");
				String primaryAccount = data.get("Primary Bank Account");
				loginfo = test.createNode("Verify updating a Bank account: '"+primaryAccount+"' as Primary bank account for the Customer: "+customer);
				homePage.verifyUpdatePrimaryAccountFunctionality(customer, primaryAccount, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Update Primary Bank Account feature for the Customer");
		}
	}
	
	@Then("^Verification of Custom form changes in the Customer using excel data at \"([^\"]*)\"$")
	public void verification_of_Custom_form_changes_in_Purchase_order(@Transform(ExcelDataToDataTable.class) DataTable customerData) 
			throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Custom form changes in Customer record");
			loginfo = test.createNode("Test Data >> Category: Mandatory, Default Order Priority: Don't display, Comments: Disable");
			homePage.verifyCustomFormChanges("Custom Entry Form", customerData, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Custom form changes in Customer record");
		}
	}
}