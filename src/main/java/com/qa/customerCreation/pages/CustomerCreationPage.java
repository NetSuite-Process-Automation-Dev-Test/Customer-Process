package com.qa.customerCreation.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.customerCreation.util.TestBase;

public class CustomerCreationPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='inpt_customform4']")
	WebElement form;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> selectForm;
	
	@FindBy(xpath = "//div[@id='isperson_F']//input")
	WebElement companyRadioBtn;
	
	@FindBy(xpath = "//div[@id='isperson_T']//input")
	WebElement individualRadioBtn;
	
	@FindBy(xpath = "//span[@id='firstname_fs']//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//span[@id='lastname_fs']//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement companyName;
	
	@FindBy(xpath = "//span[@id='parent_actionbuttons_parent_fs']//a[2]")
	WebElement parentCompArrowBtn;
	
	@FindBy(xpath = "//div[@id='parent_fs_tooltipMenu']//a[1]")
	WebElement parentCompListBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='st']")
	WebElement parentCompSearchBox;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='Search']")
	WebElement parentCompSearchBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//div[@id='inner_popup_div']//table//tr//td//following-sibling::td//a")
	List<WebElement> parentList;
	
	@FindBy(xpath = "//input[@id='btn_secondarymultibutton_submitter']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//input[@id='btn_multibutton_submitter']")
	WebElement primarySaveBtn;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement confirmationMsg;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement customer;
	
	@FindBy(xpath = "//input[@name='inpt_salesrep']")
	WebElement salesRepDropdown;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdownList;
	
	@FindBy(xpath = "//span[@id='email_fs']//input[@id='email']")
	WebElement emailBox;
	
	@FindBy(xpath = "//span[@id='phone_fs']//input[@id='phone']")
	WebElement phoneBox;
	
	@FindBy(xpath = "//textarea[@id='defaultaddress']")
	WebElement addressBox;
	
	@FindBy(xpath = "//span[@id='contact_entityid_fs']//input[@id='entityid']")
	WebElement contactBox;
	
	@FindBy(xpath = "//table[@id='contact_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='contact_headerrow']//div[text()='Email']//parent::td//preceding-sibling::td)+1]")
	WebElement contactEmailDiv;
	
	@FindBy(xpath = "//table[@id='contact_splits']//input[@id='email']")
	WebElement contactEmailBox;
	
	@FindBy(xpath = "//table[@id='contact_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='contact_headerrow']//div[text()='Role']//parent::td//preceding-sibling::td)+1]")
	WebElement contactRoleDiv;
	
	@FindBy(xpath = "//table[@id='contact_splits']//input[@name='inpt_contactrole']")
	WebElement contactRoleDropdown;
	
	@FindBy(xpath = "//input[@id='contact_addedit']")
	WebElement contactAddBtn;
	
	@FindBy(xpath = "//a[@id='addresstxt']")
	WebElement addressTab;
	
	@FindBy(xpath = "//tr[contains(@class,'uir-machine-row-focused')]//a[@id='addressbookaddress_helper_popup']")
	WebElement addressEditBtn;
	
	@FindBy(xpath = "//iframe[@id='childdrecord_frame']")
	WebElement addressFrame;
	
	@FindBy(xpath = "//input[@name='inpt_country']")
	WebElement addressCountryDropdown;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement addressCityBox;
	
	@FindBy(xpath = "//input[@name='inpt_dropdownstate']")
	WebElement addressStateDropdown;
	
	@FindBy(xpath = "//textarea[@name='addrtext']")
	WebElement addressTextarea;
	
	@FindBy(xpath = "//input[@name='ok']")
	WebElement addressOkBtn;
	
	@FindBy(xpath = "//input[@name='close']")
	WebElement addressCancelBtn;
	
	@FindBy(xpath = "//table[@id='addressbook_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='addressbook_headerrow']//div[text()='Default Shipping']//parent::td//preceding-sibling::td)+1]")
	WebElement addressDefaultShippingDiv;
	
	@FindBy(xpath = "//span[@id='addressbook_defaultshipping_fs']//img")
	WebElement addressDefaultShippingCheckbox;
	
	@FindBy(xpath = "//table[@id='addressbook_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='addressbook_headerrow']//div[text()='Default Billing']//parent::td//preceding-sibling::td)+1]")
	WebElement addressDefaultBillingDiv;

	@FindBy(xpath = "//span[@id='addressbook_defaultbilling_fs']//img")
	WebElement addressDefaultBillingCheckbox;
	
	@FindBy(xpath = "//input[@id='addressbook_addedit']")
	WebElement addressAddBtn;
	
	@FindBy(xpath = "//table[@id='addressbook_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='addressbook_headerrow']//div[text()='Address']//parent::td//preceding-sibling::td)+1]//div")
	WebElement addressLineLevelDiv;
	
	@FindBy(xpath = "//a[@id='financialtxt']")
	WebElement FinancialTab;
	
	@FindBy(xpath = "//span[@id='currency_fs_lbl_uir_label']//following-sibling::span//input[@name='inpt_currency']")
	WebElement primaryCurrencyDropdown;
	
	@FindBy(xpath = "//span[@id='currency_currency_fs']//input[@name='inpt_currency']")
	WebElement secondaryCurrencyDropdown;
	
	@FindBy(xpath = "//input[@id='currency_addedit']")
	WebElement currencyAddBtn;
	
	@FindBy(xpath = "//a[text()='k Payment Details (Credit)']")
	WebElement bankCreditTab;
	
	@FindBy(xpath = "//td[@class='bdtabblock']/div[contains(@id,'_wrapper')][count(//a[text()='k Payment Details (Credit)']//parent::td//preceding-sibling::td[@class='formtaboff'])+1]//input[@value='New Entity Bank Details']")
	WebElement newBankBtn;
	
	@FindBy(xpath = "//h1[text()='Entity Bank Details']")
	WebElement bankEntityLabel;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement bankNameBox;
	
	@FindBy(xpath = "//input[contains(@name,'entity_file_format') and @type='text']")
	WebElement paymentFileFormatDropdown;
	
	@FindBy(xpath = "//input[contains(@name,'entity_bank_type') and @type='text']")
	WebElement bankTypeDropdown;
	
	@FindBy(xpath = "//input[contains(@name,'entity_acct_no') and @type='text']")
	WebElement bankAccountNoBox;
	
	@FindBy(xpath = "//input[contains(@name,'entity_bank_no') and @type='text']")
	WebElement bankFinancialNoBox;
	
	@FindBy(xpath = "//input[contains(@name,'entity_branch_no') and @type='text']")
	WebElement bankTransitNoBox;
	
	@FindBy(xpath = "//div[contains(@id,'parent_cust_ref_layer')]//tr[contains(@id,'parent_cust_refrow')]//td[count(//div[contains(@id,'parent_cust_ref_layer')]//tr[contains(@class,'headerrow')]//div[contains(text(),'Name')]//parent::td//preceding-sibling::td)+1]//a")
	List<WebElement> bankNamesList;
	
	@FindBy(xpath = "//table[@id='contact__tab']//tr[contains(@id,'contactrow')]")
	List<WebElement> contactRows;
	
	@FindBy(xpath = "//a[@id='s_relationtxt']")
	WebElement relationshipsTab;
	
	@FindBy(xpath = "//table[@id='addressbook_splits']//tr[contains(@class,'uir-machine-row')]")
	List<WebElement> addressRows;
	
	public CustomerCreationPage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public void verifyContactAddition(String customer, String customerType, String contactName, String contactEmail,
			String contactRole, ExtentTest logInfo) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		relationshipsTab.click();
		if (customerType.equals("COMPANY")) {
			if (contactName.contains(",")) {
				String[] contactNameList = contactName.split(",");
				String[] contactEmailList = contactEmail.split(",");
				String[] contactRoleList = contactRole.split(",");
				for (int i = 0; i < contactNameList.length; i++)
					verifySingleContact(customer, contactNameList[i], contactEmailList[i], contactRoleList[i], logInfo);
			} else {
				verifySingleContact(customer, contactName, contactEmail, contactRole, logInfo);
			} 
		}
	}
	
	public void verifySingleContact(String customer, String contactName, String contactEmail, String contactRole, ExtentTest logInfo) {
		boolean contactFlag = false;
		for (int i = 0; i < contactRows.size(); i++) {
			String contactRowText = contactRows.get(i).getText().trim();
			if(contactRowText.contains(contactName) && contactRowText.contains(contactEmail) && contactRowText.contains(contactRole))
				contactFlag = true;
		}
		if (contactFlag) {
			System.out.println("Contact: '"+contactName+"' added to the Customer: '"+customer+"'");
			logInfo.pass("Contact: '"+contactName+"' added to the Customer: '"+customer+"'");
		}else {
			System.out.println("Contact: '"+contactName+"' unable to add for the Customer: '"+customer+"'");
			logInfo.fail("Contact: '"+contactName+"' unable to add for the Customer: '"+customer+"'");
		}
	}

	public void addBankingDataForCustomer(String customer, String bankName, String bankType, String bankAccountNo,
			String bankFinancialNo, String bankTransitNo, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		bankCreditTab.click();
		je.executeScript("window.scrollBy(-1000,0)");
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		if(bankName.contains(",")) {
			String[] bankNameList = bankName.split(",");
			String[] bankTypeList = bankType.split(",");
			String[] bankAccountNoList = bankAccountNo.split(",");
			String[] bankFinancialNoList = bankFinancialNo.split(",");
			String[] bankTransitNoList = bankTransitNo.split(",");
			for (int i = 0; i < bankNameList.length; i++) {
				boolean bankFlag;
				bankFlag = addSingleBankAccount(customer, bankNameList[i].trim(), bankTypeList[i].trim(), bankAccountNoList[i].trim(), bankFinancialNoList[i].trim(), bankTransitNoList[i].trim(), logInfo);
				if(!bankFlag)
					break;
			}
		} else {
			addSingleBankAccount(customer, bankName, bankType, bankAccountNo, bankFinancialNo, bankTransitNo, logInfo);
		}
		
	}
	
	public boolean addSingleBankAccount(String customer, String bankName, String bankType, String bankAccountNo,
			String bankFinancialNo, String bankTransitNo, ExtentTest logInfo) throws InterruptedException {
		boolean bankFlag = true;
		try {
			WebElement loadingEle = driver.findElement(By.xpath("//table[contains(@id,'parent_cust_ref_splits')]//td[contains(text(),'Loading')]"));
			eleToBeInvisible(driver, loadingEle, 10);
		} catch (Exception e) {}
		newBankBtn.click();
	    try {
			WebElement loadingEle = driver.findElement(By.xpath("//table[@id='usernotes_splits']//td[contains(text(),'Loading')]"));
			eleToBeInvisible(driver, loadingEle, 10);
		} catch (Exception e) {}
		paymentFileFormatDropdown.sendKeys("CPA-005");
		bankEntityLabel.click();
		try {
			WebElement loadingEle = driver.findElement(By.xpath("//table[@id='usernotes_splits']//td[contains(text(),'Loading')]"));
			eleToBeInvisible(driver, loadingEle, 10);
		} catch (Exception e) {}
		
		// Enter Banking Data
		bankNameBox.sendKeys(bankName);
		boolean bankTypeFlag = false;
		eleClickable(driver, bankTypeDropdown, 10);
		bankTypeDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals(bankType)) {
				dropdownList.get(i).click();
				bankTypeFlag = true;
				break;
			}
		}
		if(bankTypeFlag) {
			bankAccountNoBox.sendKeys(bankAccountNo);
			bankFinancialNoBox.sendKeys(bankFinancialNo);
			bankTransitNoBox.sendKeys(bankTransitNo);
			primarySaveBtn.click();
			if(isAlertPresent()) {
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				if(alertMsg.contains("Please correct the values of the following fields before submitting the form")
						|| alertMsg.contains("Please enter value")) {
					bankFlag = false;
					System.out.println("Bank Data unable to add to the Customer: '"+customer+"' <br/> Alert occured: "+alertMsg);
					logInfo.fail("Bank Data unable to add to the Customer: '"+customer+"' <br/> Alert occured: "+alertMsg);
				}
				alert.accept();
			}else {
				Thread.sleep(1500);
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				bankCreditTab.click();
				je.executeScript("window.scrollBy(-1000,0)");
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				try {
					WebElement loadingEle = driver.findElement(By.xpath("//table[contains(@id,'parent_cust_ref_splits')]//td[contains(text(),'Loading')]"));
					eleToBeInvisible(driver, loadingEle, 10);
				} catch (Exception e) {}
				boolean bankFlag2 = false;
				for (int i = 0; i < bankNamesList.size(); i++) {
					if(bankNamesList.get(i).getText().equals(bankName)) {
						bankFlag2 = true;
						break;
					}
				}
				if(bankFlag2) {
					System.out.println("Bank Account: '"+bankName+"' added to the Customer: '"+customer+"' record");
					logInfo.pass("Bank Account: '"+bankName+"' added to the Customer: '"+customer+"' record");
				}
			}
		}else {
			bankFlag = false;
			System.out.println("Bank Type: '"+bankType+"' not available in the list. Bank data unable to add for the Customer: '"+customer+"'");
			logInfo.fail("Bank Type: '"+bankType+"' not available in the list. Bank data unable to add for the Customer: '"+customer+"'");
		}
		
		return bankFlag;
	}

	public boolean createNewCustomer(String customerType, String customerFirstName, String customerLastName,
			String customerCompany, String customerParentCompany, String salesRep, String email,
			String currency, String contactName, String contactEmail, String contactRole, String country,
			String city, String state, String shippingFlag, String billingFlag,ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleSelectionStateToBe(driver, companyRadioBtn, 10, true);
		Thread.sleep(1000);
		boolean customerCreationFlag = false;
		// Handling customer type & entering customer name
		if(customerType.equals("COMPANY")) {
			companyRadioBtn.click();
			// Enter company name
			Thread.sleep(1500);
			companyName.sendKeys(customerCompany);
		}
		else {
			individualRadioBtn.click();
			// Enter first name, last name
			Thread.sleep(1500);
			firstName.sendKeys(customerFirstName);
			lastName.sendKeys(customerLastName);
			companyName.sendKeys(customerCompany);
		}
		
		// Enter Parent Company
		boolean parentCompanyFlag = false;
		parentCompArrowBtn.click();
		parentCompListBtn.click();
		eleAvailability(driver, parentCompSearchBox, 20);
		parentCompSearchBox.sendKeys(customerParentCompany);
		parentCompSearchBtn.click();
		Thread.sleep(5000);
		for(int j=0;j<parentList.size();j++) {
			String parentCustomer = parentList.get(j).getText().trim();
			if(parentCustomer.equals(customerParentCompany.trim())) {
				parentList.get(j).click();
				parentCompanyFlag = true;
				break;
			}
		}
		Thread.sleep(5000);
		if(!parentCompanyFlag) {
			driver.findElement(By.xpath("//textarea[@id='comments']")).click();
			System.out.println("Customer unable to create. Parent Company: "+customerParentCompany+" not available in the list & unable to select");
			logInfo.fail("Customer unable to create. Parent Company: "+customerParentCompany+" not available in the list & unable to select");
		}
		
		// Select Sales Rep
		boolean salesRepFlag = false;
		action.moveToElement(salesRepDropdown).build().perform();
		eleClickable(driver, salesRepDropdown, 10);
		salesRepDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals(salesRep)) {
				dropdownList.get(i).click();
				salesRepFlag = true;
				break;
			}
		}
		if(!salesRepFlag) {
			System.out.println("Customer unable to create. Sales Rep: "+salesRep+" not available in the list & unable to select");
			logInfo.fail("Customer unable to create. Sales Rep: "+salesRep+" not available in the list & unable to select");
		}
		driver.findElement(By.xpath("//textarea[@id='comments']")).click();
		
		// Enter email
		boolean emailFlag = true;
		action.moveToElement(emailBox).build().perform();
		emailBox.sendKeys(email);
		addressBox.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			if (alertMsg.contains("Please enter a valid email address")) {
				emailFlag = false;
				System.out.println("Customer unable to create. Email: '"+email+"' is invalid");
				logInfo.fail("Customer unable to create. Email: '"+email+"' is invalid");
			}
			alert.accept();
			emailBox.clear();
			addressBox.click();
			Thread.sleep(1500);
		}
		
		
		if (parentCompanyFlag && salesRepFlag && emailFlag) {
			// Add contact(s) for the Customer
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			boolean contactFlag;
			if (customerType.equals("COMPANY")) {
				contactFlag = addContact(contactName, contactEmail, contactRole, logInfo);
			}else {
				contactFlag = true;
			}
			if(contactFlag) {
				// Add Address for the Customer
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				boolean addressFlag;
				addressFlag = addAddresses(country, city, state, shippingFlag, billingFlag, logInfo);
				
				if (addressFlag) {
					// Add Currency for the Customer
					boolean currencyFlag;
					currencyFlag = addCurrency(currency, logInfo);
					
					if (currencyFlag) {
						// Click on save button
						je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
						saveBtn.click();
						try {
							eleAvailability(driver, By.xpath("//div[@class='descr']"), 10);
							String confirmationMessage = confirmationMsg.getText().trim();
							String customer = customerFirstName + " " + customerLastName + " " + customerCompany;
							if (confirmationMessage.equals("Customer successfully Saved")) {
								customerCreationFlag = true;
								System.out.println("Customer '" + customer.trim() + "' created successfully");
								logInfo.pass("Customer '"+customer.trim()+"' created successfully");
							} else {
								System.out.println("Customer '" + customer.trim() + "' unable to create");
								logInfo.fail("Customer '"+customer.trim()+"' unable to create");
							}
						} catch (NoSuchElementException | TimeoutException e) {
							String notice = driver.findElement(By.xpath("//td[@class='text']//img//parent::td"))
									.getText();
							String customer = customerFirstName + " " + customerLastName + " " + customerCompany;
							System.out.println(notice);
							if (notice.contains("A customer record with this ID already exists")) {
								System.out.println("Customer '" + customer.trim() + "' already exists");
								logInfo.fail("Customer '"+customer+"' already exists");
							}
						}
					}
				}
			}
		}
		
		return customerCreationFlag;
	}
	
	public boolean addCurrency(String currency, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean currencyFlag = false;
		FinancialTab.click();
		if(currency.contains(",")) {
			int count = 0;
			String[] currencyList = currency.split(",");
			
			// Add Primary currency
			boolean primaryCurrencyFlag = false;
			action.moveToElement(primaryCurrencyDropdown).build().perform();
			eleClickable(driver, primaryCurrencyDropdown, 10);
			primaryCurrencyDropdown.click();
			for(int i=0;i<dropdownList.size();i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if(formValue.equals(currencyList[0])) {
					dropdownList.get(i).click();
					primaryCurrencyFlag = true;
					count++;
					break;
				}
			}
			
			if (primaryCurrencyFlag) {
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				// Add remaining currencies in Currencies sublist
				for (int i = 1; i < currencyList.length; i++) {
					boolean currencyFlag2 = false;
					action.moveToElement(secondaryCurrencyDropdown).build().perform();
					eleClickable(driver, secondaryCurrencyDropdown, 10);
					secondaryCurrencyDropdown.click();
					for(int i1=0;i1<dropdownList.size();i1++) {
						String formValue = dropdownList.get(i1).getText().trim();
						if(formValue.equals(currencyList[i])) {
							dropdownList.get(i1).click();
							Thread.sleep(1500);
							currencyFlag2 = true;
							break;
						}
					}
					if(currencyFlag2) {
						currencyAddBtn.click();
						count++;
					} else {
						System.out.println("Customer unable to create. Currency: "+currencyList[i]+" not available in the list & unable to select");
						logInfo.fail("Customer unable to create. Currency: "+currencyList[i]+" not available in the list & unable to select");
						break;
					}
				}
				if (count == currencyList.length)
					currencyFlag = true;
			}else {
				System.out.println("Customer unable to create. Primary Currency: "+currencyList[0]+" not available in the list & unable to select");
				logInfo.fail("Customer unable to create. Primary Currency: "+currencyList[0]+" not available in the list & unable to select");
			}
		}else {
			// Add Primary currency
			action.moveToElement(primaryCurrencyDropdown).build().perform();
			eleClickable(driver, primaryCurrencyDropdown, 10);
			primaryCurrencyDropdown.click();
			for(int i=0;i<dropdownList.size();i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if(formValue.equals(currency)) {
					dropdownList.get(i).click();
					currencyFlag = true;
					break;
				}
			}
			if(!currencyFlag) {
				System.out.println("Customer unable to create. Primary Currency: "+currency+" not available in the list & unable to select");
				logInfo.fail("Customer unable to create. Primary Currency: "+currency+" not available in the list & unable to select");
			}
		}
		
		return currencyFlag;
	}
	
	private boolean addAddresses(String country, String city, String state, String shippingFlag,
			String billingFlag, ExtentTest logInfo) throws InterruptedException {
		boolean addressFlag = false;
		addressTab.click();
		if(country.contains(",")) {
			int count = 0;
			String[] countryList = country.split(",");
			String[] cityList = city.split(",");
			String[] stateList = state.split(",");
			String[] shippingFlagList = shippingFlag.split(",");
			String[] billingFlagList = billingFlag.split(",");
			for (int i = 0; i < countryList.length; i++) {
				boolean addressFlag2;
				addressFlag2 = addSingleAddress(countryList[i], cityList[i], stateList[i], shippingFlagList[i], billingFlagList[i], logInfo);
				if(addressFlag2)
					count++;
				else
					break;
			}
			if (count == countryList.length)
				addressFlag = true;
		}else {
			addressFlag = addSingleAddress(country, city, state, shippingFlag, billingFlag, logInfo);
		}
		
		return addressFlag;
	}
	
	public boolean addSingleAddress(String country, String city, String state, String shippingFlag,
			String billingFlag, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean addressFlag = true;
		addressTab.click();
		eleClickable(driver, addressEditBtn, 10);
		je.executeScript("arguments[0].click();", addressEditBtn);
		driver.switchTo().frame(addressFrame);
		eleAvailability(driver, addressTextarea, 10);
		boolean countryFlag = false;
		eleClickable(driver, addressCountryDropdown, 10);
		addressCountryDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals(country)) {
				dropdownList.get(i).click();
				Thread.sleep(1500);
				eleattributeContainsText(driver, addressCountryDropdown, 10, "title", country);
				countryFlag = true;
				break;
			}
		}
		if(countryFlag) {
			addressCityBox.sendKeys(city);
			boolean stateFlag = false;
			eleClickable(driver, addressStateDropdown, 10);
			addressStateDropdown.click();
			for(int i=0;i<dropdownList.size();i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if(formValue.equals(state)) {
					dropdownList.get(i).click();
					Thread.sleep(1500);
					eleattributeContainsText(driver, addressStateDropdown, 10, "title", state);
					stateFlag = true;
					break;
				}
			}
			if(stateFlag) {
				addressOkBtn.click();
				driver.switchTo().defaultContent();
				Thread.sleep(1500);
				eleContainsText(driver, addressLineLevelDiv, 10, country);
				
				// Check or uncheck 'Default Shipping' checkbox
				addressDefaultShippingDiv.click();
				if(shippingFlag.equals("Yes"))
					enableCheckbox(addressDefaultShippingCheckbox);
				else if(shippingFlag.equals("No"))
					disableCheckbox(addressDefaultShippingCheckbox);
				
				// Check or uncheck 'Default Billing' checkbox
				addressDefaultBillingDiv.click();
				if(billingFlag.equals("Yes"))
					enableCheckbox(addressDefaultBillingCheckbox);
				else if(billingFlag.equals("No"))
					disableCheckbox(addressDefaultBillingCheckbox);
				
				addressAddBtn.click();
				Thread.sleep(1500);
			}else {
				addressFlag = false;
				System.out.println("Customer unable to create. State: "+state+" not available in the list & unable to select");
				logInfo.fail("Customer unable to create. State: "+state+" not available in the list & unable to select");
			}
		}else {
			addressFlag = false;
			System.out.println("Customer unable to create. Country: "+country+" not available in the list & unable to select");
			logInfo.fail("Customer unable to create. Country: "+country+" not available in the list & unable to select");
		}
		
		if(!addressFlag) {
			addressCancelBtn.click();
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
		}
		
		return addressFlag;
	}

	private boolean addContact(String contactName, String contactEmail, String contactRole, ExtentTest logInfo) throws InterruptedException {
		boolean contactFlag = false;
		if(contactName.contains(",")) {
			int count = 0;
			String[] contactNameList = contactName.split(",");
			String[] contactEmailList = contactEmail.split(",");
			String[] contactRoleList = contactRole.split(",");
			for (int i = 0; i < contactNameList.length; i++) {
				boolean contactFlag2;
				contactFlag2 = addSingleContact(contactNameList[i], contactEmailList[i], contactRoleList[i], logInfo);
				if(contactFlag2)
					count++;
			}
			if (count == contactNameList.length)
				contactFlag = true;
		}else {
			contactFlag = addSingleContact(contactName, contactEmail, contactRole, logInfo);
		}
		
		return contactFlag;
	}
	
	public boolean addSingleContact(String contactName, String contactEmail, String contactRole, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean contactFlag = true;
		boolean contactEmailFlag = true;
		contactBox.sendKeys(contactName);
		je.executeScript("arguments[0].click();", contactEmailDiv);
		je.executeScript("arguments[0].click();", contactEmailDiv);
		contactEmailBox.sendKeys(contactEmail);
		je.executeScript("arguments[0].click();", contactRoleDiv);
		if(isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			if (alertMsg.contains("Please enter a valid email address")) {
				contactEmailFlag = false;
				contactFlag = false;
				System.out.println("Customer unable to create. Contact Email: '"+contactEmail+"' is invalid");
				logInfo.fail("Customer unable to create. Contact Email: '"+contactEmail+"' is invalid");
			}
			alert.accept();
			contactEmailBox.clear();
			Thread.sleep(1500);
		}
		if(contactEmailFlag) {
			// Select Contact Role
			je.executeScript("arguments[0].click();", contactRoleDiv);
			boolean contactRoleFlag = false;
			action.moveToElement(contactRoleDropdown).build().perform();
			eleClickable(driver, contactRoleDropdown, 10);
			contactRoleDropdown.click();
			for(int j=0;j<dropdownList.size();j++) {
				String formValue = dropdownList.get(j).getText().trim();
				if(formValue.equals(contactRole)) {
					dropdownList.get(j).click();
					contactRoleFlag = true;
					break;
				}
			}
			
			if(contactRoleFlag) {
				// Click "Add" button
				contactAddBtn.click();
			}else {
				System.out.println("Customer unable to create. Contact Role: '"+contactRole+"' not available in the list & unable to select");
				logInfo.fail("Customer unable to create. Contact Role: '"+contactRole+"' not available in the list & unable to select");
				contactFlag = false;
			}
		}
		
		if(!contactFlag) {
			driver.findElement(By.xpath("//input[@id='contact_clear']")).click();
		}
		
		return contactFlag;
	}
	
	public void enableCheckbox(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}

	public void disableCheckbox(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(!parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}
}
