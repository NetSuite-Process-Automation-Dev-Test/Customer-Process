package com.qa.customerCreation.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.customerCreation.util.TestBase;

import cucumber.api.DataTable;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//li[contains(@id,'ns-header-menu-userrole-item')]/a/span[@class='ns-role-menuitem-text']")
	List<WebElement> rolesList;
	
	@FindBy(xpath = "//div[@class='ns-role']/span[2]")
	WebElement role;
	
	@FindBy(xpath = "//li[contains(@class,'ns-header') and @data-title='Lists']//span[text()='Lists']")
	WebElement listLink;
	
	@FindBy(xpath = "//span[text()='Relationships']")
	WebElement relationshipsLink;
	
	@FindBy(xpath = "//span[text()='Customers']")
	WebElement customersLink;
	
	@FindBy(xpath = "//span[text()='New']")
	WebElement newLink;
	
	@FindBy(xpath = "//input[@name='inpt_quicksort']")
	WebElement quickSortDropdown;
	
	@FindBy(xpath = "//form//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//thead//div[text()='Name']//parent::td//preceding-sibling::td)+1]//a")
	List<WebElement> customerList;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']")
	WebElement paginationLabel;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']//following-sibling::ul//li")
	List<WebElement> paginationList;
	
	@FindBy(xpath = "//div[@id='contact_layer']//table[@id='contact__tab']//tr[contains(@id,'contactrow')]")
	List<WebElement> contactRows;
	
	@FindBy(xpath = "//table[@id='contacts_splits']//tr[contains(@id,'contactsrow')]")
	List<WebElement> contactRowsInPopUp;
	
	@FindBy(xpath = "//input[@id='updatecontact']")
	WebElement updatePrimaryBtn;
	
	@FindBy(xpath = "//input[@id='edit']")
	WebElement editBtn;
	
	@FindBy(xpath = "//a[text()='k Payment Details (Credit)']")
	WebElement bankCreditTab;
	
	@FindBy(xpath = "//div[contains(@id,'parent_cust_ref_layer')]//tr[contains(@id,'parent_cust_refrow')]")
	List<WebElement> bankAccountRows;
	
	@FindBy(xpath = "//input[contains(@name,'entity_bank_type') and @type='text']")
	WebElement bankTypeDropdown;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdownList;
	
	@FindBy(xpath = "//span[text()='Customization']")
	WebElement customizationLink;
	
	@FindBy(xpath = "//span[text()='Forms']")
	WebElement formsLink;
	
	@FindBy(xpath = "//span[text()='Entry Forms']")
	WebElement EntryFormsLink;
	
	@FindBy(xpath = "//form//tr[contains(@id,'row')]//td[count(//form//table[@id='div__labtab']//div[contains(text(),'Name')]//parent::td//preceding-sibling::td)+1]")
	List<WebElement> customFormsList;
	
	@FindBy(xpath = "//a[@id='FIELDStxt']")
	WebElement fieldsTab;
	
	@FindBy(xpath = "//input[@id='btn_multibutton_submitter']")
	WebElement primarySaveBtn;
	
	@FindBy(xpath = "//div[@id='isperson_F']//input")
	WebElement companyRadioBtn;
	
	@FindBy(xpath = "//input[@name='inpt_customform']")
	WebElement formDropdown;
	
	@FindBy(xpath = "//input[@name='inpt_category']")
	WebElement categoryDropdown;
	
	@FindBy(xpath = "//span[@id='category_fs_lbl']//label[text()='*']")
	WebElement categoryRequiredLabel;
	
	@FindBy(xpath = "//input[@name='defaultorderpriority_formattedValue']")
	WebElement orderPriorityBox;
	
	@FindBy(xpath = "//textarea[@id='comments']")
	WebElement commentsBox;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public void verifyCustomFormChanges(String formName, DataTable formData, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		// Edit Custom Form & configure changes
		clickOnCustomEntryFormsLink();
		editCustomForm(formName);
		fieldsTab.click();
		Thread.sleep(1500);
		
		// Configure Custom form
		for(Map<String,String> data: formData.asMaps(String.class, String.class)) {
			String fieldName = data.get("Field Name");
			String showFlag = data.get("Show Flag");
			String mandatoryFlag = data.get("Mandatory Flag");
			String displayType = data.get("Display Type");
			configureCustomFormForField(fieldName, showFlag, mandatoryFlag, displayType);
		}
		
		// Save the Custom form
		je.executeScript("window.scrollTo(0,0)");
		primarySaveBtn.click();
		if(isAlertPresent())
			driver.switchTo().alert().accept();
		
		// Open Custom form in Purchase order page & verify the fields
		clickOnNewCustomerLink();
		eleSelectionStateToBe(driver, companyRadioBtn, 10, true);
		Thread.sleep(1000);
		eleClickable(driver, formDropdown, 10);
		if (!formDropdown.getAttribute("value").trim().equals(formName)) {
			formDropdown.click();
			for (int i = 0; i < dropdownList.size(); i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if (formValue.equals(formName)) {
					dropdownList.get(i).click();
					break;
				}
			}
		}
		eleSelectionStateToBe(driver, companyRadioBtn, 10, true);
		Thread.sleep(1000);
		
		try {
			if(categoryDropdown.isDisplayed() && categoryRequiredLabel.isDisplayed()) {
				System.out.println("Custom form changes applied correctly. Category dropdown is displayed as mandatory field in the Form: '"+formName+"'");
				logInfo.pass("Custom form changes applied correctly. Category dropdown is displayed as mandatory field in the Form: '"+formName+"'");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Custom form changes not applied correctly. Category dropdown is not displayed in the Form: '"+formName+"'");
			logInfo.fail("Custom form changes not applied correctly. Category dropdown is not displayed in the Form: '"+formName+"'");
		}
		
		try {
			if(orderPriorityBox.isDisplayed()) {
				System.out.println("Custom form changes not applied correctly. Order Priority textbox is displayed in the Form: '"+formName+"'");
				logInfo.fail("Custom form changes not applied correctly. Order Priority textbox is displayed in the Form: '"+formName+"'");
			}
		} catch (Exception e) {
			System.out.println("Custom form changes applied correctly. Order Priority textbox is not displayed in the Form: '"+formName+"'");
			logInfo.pass("Custom form changes applied correctly. Order Priority textbox is not displayed in the Form: '"+formName+"'");
		}
		
		if(commentsBox.isEnabled()) {
			System.out.println("Custom form changes not applied correctly. Comments field is not disabled in the Form: '"+formName+"'");
			logInfo.fail("Custom form changes not applied correctly. Comments field is not disabled in the Form: '"+formName+"'");
		}else {
			System.out.println("Custom form changes applied correctly. Comments field is disabled in the Form: '"+formName+"'");
			logInfo.pass("Custom form changes applied correctly. Comments field is disabled in the Form: '"+formName+"'");
		}
		
		// Enable all the fields again for the custom form
		clickOnCustomEntryFormsLink();
		editCustomForm(formName);
		fieldsTab.click();
		Thread.sleep(1500);
		for(Map<String,String> data: formData.asMaps(String.class, String.class)) {
			String fieldName = data.get("Field Name");
			configureCustomFormForField(fieldName, "Yes", "No", "Normal");
		}
		je.executeScript("window.scrollTo(0,0)");
		primarySaveBtn.click();
	}
	
	public void configureCustomFormForField(String fieldName, String showFlag, String mandatoryFlag,
			String displayType) {

		WebElement fieldEle = driver.findElement(By.xpath("//td[text()='"+fieldName+"']"));
		if(showFlag.equals("Yes"))
			enableOrDisableShowCheckbox(fieldEle, true);
		else
			enableOrDisableShowCheckbox(fieldEle, false);
		
		if(mandatoryFlag.equals("Yes"))
			enableOrDisableMandatoryCheckbox(fieldEle, true);
		else
			enableOrDisableMandatoryCheckbox(fieldEle, false);
		
		// Change Display type
		updateDisplayType(fieldEle, displayType);
	
	}

	public void updateDisplayType(WebElement fieldEle, String displayType) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(fieldEle).build().perform();
		WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", fieldEle);
		String rowId = parentTr.getAttribute("id");
		WebElement displayDropdown = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//td[count(//table[@id='mainflds_splits']//div[text()='Display Type']//parent::td//preceding-sibling::td)+1]//input[@type='text']"));
		if(!displayDropdown.getAttribute("value").equals(displayType))
			displayDropdown.sendKeys(displayType);
	}

	public void enableOrDisableMandatoryCheckbox(WebElement element, boolean checkboxFlag) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		String rowId = parentTr.getAttribute("id");
		WebElement elementCheckbox = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//td[count(//table[@id='mainflds_splits']//div[text()='Mandatory']//parent::td//preceding-sibling::td)+1]//img"));
		if(checkboxFlag)
			enableCheckbox(elementCheckbox);
		else
			disableCheckbox(elementCheckbox);
	}

	public void enableOrDisableShowCheckbox(WebElement element, boolean checkboxFlag) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		String rowId = parentTr.getAttribute("id");
		WebElement elementCheckbox = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//td[count(//table[@id='mainflds_splits']//div[text()='Show']//parent::td//preceding-sibling::td)+1]//img"));
		if(checkboxFlag)
			enableCheckbox(elementCheckbox);
		else
			disableCheckbox(elementCheckbox);
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
		action.moveToElement(element).build().perform();
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(!parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}

	public void editCustomForm(String formName) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean formFlag = false;
		for(int i=0;i<customFormsList.size();i++) {
			WebElement currentForm = customFormsList.get(i);
			String text = currentForm.getText().trim();
			if(text.equals(formName)) {
				formFlag = true;
				action.moveToElement(currentForm).build().perform();
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentForm);
				String rowId = parentTr.getAttribute("id");
				driver.findElement(By.xpath("//form//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='Edit']")).click();
				break;
			}
		}
		if(!formFlag) {
			for (int i = 1; i < paginationList.size(); i++) {
				boolean formFlag2 = false;
				action.moveToElement(paginationLabel).build().perform();
				eleAvailability(driver, paginationList.get(i), 10);
				paginationList.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < customFormsList.size(); j++) {
					WebElement currentForm = customFormsList.get(j);
					String text = currentForm.getText().trim();
					if(text.equals(formName)) {
						formFlag2 = true;
						action.moveToElement(currentForm).build().perform();
						WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentForm);
						String rowId = parentTr.getAttribute("id");
						driver.findElement(By.xpath("//form//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='Edit']")).click();
						break;
					}
				}
				if(formFlag2)
					break;
			}
		}
	}

	public void clickOnCustomEntryFormsLink() throws InterruptedException {
		Thread.sleep(2000);
		eleAvailability(driver, customizationLink, 10);
		action.moveToElement(customizationLink).build().perform();
		eleAvailability(driver, formsLink, 10);
		action.moveToElement(formsLink).build().perform();
		eleAvailability(driver, EntryFormsLink, 10);
		EntryFormsLink.click();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}
	
	public void verifyUpdatePrimaryAccountFunctionality(String customer, String primaryAccount, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		openCustomer(customer);
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		bankCreditTab.click();
		je.executeScript("window.scrollBy(-1000,0)");
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		try {
			WebElement loadingEle = driver.findElement(By.xpath("//table[contains(@id,'parent_cust_ref_splits')]//td[contains(text(),'Loading')]"));
			eleToBeInvisible(driver, loadingEle, 10);
		} catch (Exception e) {}
		boolean bankFlag = false;
		boolean primaryBankFlag = false;
		for (int i = 0; i < bankAccountRows.size(); i++) {
			if(bankAccountRows.get(i).getText().contains(primaryAccount)) {
				bankFlag = true;
				if(bankAccountRows.get(i).getText().contains("Primary"))
					primaryBankFlag = true;
				break;
			}
		}
		
		if(bankFlag) {
			if (primaryBankFlag) {
				System.out.println("Bank account: "+primaryAccount+" is already selected as Primary bank account for the Customer: "+customer);
				logInfo.pass("Bank account: "+primaryAccount+" is already selected as Primary bank account for the Customer: "+customer);
			}else {
			    // Check if any Bank account is Primary & get bank account name
			    String previousPrimaryAccount = null;
			    for (int i = 0; i < bankAccountRows.size(); i++) {
					String currentContact = bankAccountRows.get(i).getText().trim();
					if(currentContact.contains("Primary")) {
						String rowId = bankAccountRows.get(i).getAttribute("id");
						WebElement accountEle = driver.findElement(By.xpath("//div[contains(@id,'parent_cust_ref_layer')]//tr[@id='"
						+rowId+"']//td[count(//div[contains(@id,'parent_cust_ref_layer')]//div[contains(text(),'Name')]"
								+ "//parent::td//preceding-sibling::td)+1]//a"));
						previousPrimaryAccount = accountEle.getText().trim();
						break;
					}
				}
				for (int i = 0; i < bankAccountRows.size(); i++) {
					if(bankAccountRows.get(i).getText().contains(primaryAccount)) {
						String rowId = bankAccountRows.get(i).getAttribute("id");
						WebElement editBtn = driver.findElement(By.xpath("//div[contains(@id,'parent_cust_ref_layer')]//tr[@id='"+rowId+"']//a[text()='Edit']"));
						editBtn.click();
						try {
							WebElement loadingEle = driver.findElement(By.xpath("//table[@id='usernotes_splits']//td[contains(text(),'Loading')]"));
							eleToBeInvisible(driver, loadingEle, 10);
						} catch (Exception e) {}
						bankTypeDropdown.click();
						for(int j=0;j<dropdownList.size();j++) {
							String formValue = dropdownList.get(j).getText().trim();
							if(formValue.equals("Primary")) {
								dropdownList.get(j).click();
								break;
							}
						}
						driver.findElement(By.xpath("//input[@id='btn_multibutton_submitter']")).click();
						if(isAlertPresent())
							driver.switchTo().alert().accept();
						break;
					}
				}
				Thread.sleep(1500);
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				bankCreditTab.click();
				je.executeScript("window.scrollBy(-1000,0)");
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				try {
					WebElement loadingEle = driver.findElement(By.xpath("//table[contains(@id,'parent_cust_ref_splits')]//td[contains(text(),'Loading')]"));
					eleToBeInvisible(driver, loadingEle, 10);
				} catch (Exception e) {}
				boolean primaryBankFlag2 = false;
				for (int i = 0; i < bankAccountRows.size(); i++) {
					String currentContact = bankAccountRows.get(i).getText().trim();
					if(currentContact.contains(primaryAccount) && currentContact.contains("Primary")) {
						primaryBankFlag2 = true;
						break;
					}
				}
				if (primaryBankFlag2) {
					System.out.println("Bank account: "+primaryAccount+" is selected as Primary Bank account for the Customer: "+customer);
					logInfo.pass("Bank account: "+primaryAccount+" is selected as Primary Bank account for the Customer: "+customer);
				}else {
					System.out.println("Bank account: "+primaryAccount+" is not selected as Primary Bank account for the Customer: "+customer);
					logInfo.fail("Bank account: "+primaryAccount+" is not selected as Primary Bank account for the Customer: "+customer);
				}
				
				// Check if Previous primary Bank account type is changed to Secondary or not
				if (!previousPrimaryAccount.trim().isBlank()) {
					for (int i = 0; i < bankAccountRows.size(); i++) {
						String currentContact = bankAccountRows.get(i).getText().trim();
						if(currentContact.contains(previousPrimaryAccount)) {
							String rowId = bankAccountRows.get(i).getAttribute("id");
							String accountTypeValue = driver.findElement(By.xpath("//div[contains(@id,'parent_cust_ref_layer')]//tr[@id='"
									+rowId+"']//td[count(//div[contains(@id,'parent_cust_ref_layer')]//div[contains(text(),'Type')]"
									+ "//parent::td//preceding-sibling::td)+1]")).getText().trim();
							if (accountTypeValue.equals("Secondary")) {
								System.out.println("Bank Type for the Bank account: '"+previousPrimaryAccount+"' changed from Primary to Secondary");
								logInfo.pass("Bank Type for the Bank account: '"+previousPrimaryAccount+"' changed from Primary to Secondary");
							}else {
								System.out.println("Bank Type for the Bank account: '"+previousPrimaryAccount+"' changed from Primary to "+accountTypeValue+". Bank type must be changed to Secondary");
								logInfo.fail("Bank Type for the Bank account: '"+previousPrimaryAccount+"' changed from Primary to "+accountTypeValue+". Bank type must be changed to Secondary");
							}
							break;
						}
					}
				}
			}
		}else {
			System.out.println("Bank account: "+primaryAccount+" not found in the Customer record");
			logInfo.fail("Bank account: "+primaryAccount+" not found in the Customer record");
		}
	}
	
	public void verifyUpdatePrimaryContactFunctionality(String customer, String primaryContact, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		openCustomer(customer);
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		boolean contactFlag = false;
		boolean primaryContactFlag = false;
		for (int i = 0; i < contactRows.size(); i++) {
			String currentContact = contactRows.get(i).getText().trim();
			if(currentContact.contains(primaryContact)) {
				contactFlag = true;
				if(currentContact.contains("Primary Contact"))
					primaryContactFlag = true;
				break;
			}
		}
		if(contactFlag) {
			if (primaryContactFlag) {
				System.out.println("Contact: "+primaryContact+" is already selected as Primary contact for the Customer: "+customer);
				logInfo.pass("Contact: "+primaryContact+" is already selected as Primary contact for the Customer: "+customer);
			}else {
				updatePrimaryBtn.click();
				ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1));
			    
			    // Check if any contact is Primary & get contact name
			    String previousPrimaryContact = null;
			    for (int i = 0; i < contactRowsInPopUp.size(); i++) {
					String currentContact = contactRowsInPopUp.get(i).getText().trim();
					if(currentContact.contains("Primary Contact")) {
						String rowId = contactRowsInPopUp.get(i).getAttribute("id");
						WebElement contactEle = driver.findElement(By.xpath("//tr[@id='"+rowId+
								"']//td[count(//div[contains(text(),'Contact')]//parent::td//preceding-sibling::td)+1]"));
						previousPrimaryContact = contactEle.getText().trim();
						break;
					}
				}
				editBtn.click();
				Thread.sleep(2000);
				eleAvailability(driver, contactRowsInPopUp.get(0), 10);
				for (int i = 0; i < contactRowsInPopUp.size(); i++) {
					String currentContact = contactRowsInPopUp.get(i).getText().trim();
					if(currentContact.contains(primaryContact)) {
						String rowId = contactRowsInPopUp.get(i).getAttribute("id");
						WebElement roleDropdown = driver.findElement(By.xpath("//tr[@id='"+
								rowId+"']//input[contains(@id,'inpt_contactrole')]"));
						roleDropdown.sendKeys("Primary Contact");
						break;
					}
				}
				driver.findElement(By.xpath("//input[@id='submitter']")).click();
				Thread.sleep(1500);
			    driver.switchTo().window(tabs.get(0));
			    Thread.sleep(2500);
			    boolean primaryContactFlag2 = false;
				for (int i = 0; i < contactRows.size(); i++) {
					String currentContact = contactRows.get(i).getText().trim();
					if(currentContact.contains(primaryContact) && currentContact.contains("Primary Contact")) {
						primaryContactFlag2 = true;
						break;
					}
				}
				if (primaryContactFlag2) {
					System.out.println("Contact: "+primaryContact+" is selected as Primary contact for the Customer: "+customer);
					logInfo.pass("Contact: "+primaryContact+" is selected as Primary contact for the Customer: "+customer);
				}else {
					System.out.println("Contact: "+primaryContact+" is not selected as Primary contact for the Customer: "+customer);
					logInfo.fail("Contact: "+primaryContact+" is not selected as Primary contact for the Customer: "+customer);
				}
				
				// Check if Previous primary contact role is changed or not
				if (!previousPrimaryContact.trim().isBlank()) {
					for (int i = 0; i < contactRows.size(); i++) {
						String currentContact = contactRows.get(i).getText().trim();
						if(currentContact.contains(previousPrimaryContact)) {
							String rowId = contactRows.get(i).getAttribute("id");
							String roleValue = driver.findElement(By.xpath("//div[@id='contact_layer']//tr[@id='"+rowId+
									"']//td[count(//div[@id='contact_layer']//div[contains(text(),'Role')]"
									+ "//parent::td//preceding-sibling::td)+1]")).getText().trim();
							if (roleValue.isBlank()) {
								System.out.println("Role of the Contact: '"+previousPrimaryContact+"' changed from Primary to empty value");
								logInfo.pass("Role of the Contact: '"+previousPrimaryContact+"' changed from Primary to empty value");
							}else {
								System.out.println("Role of the Contact: '"+previousPrimaryContact+"' changed from Primary to "+roleValue+". Role must be empty");
								logInfo.fail("Role of the Contact: '"+previousPrimaryContact+"' changed from Primary to "+roleValue+". Role must be empty");
							}
							break;
						}
					}
				}
			}
		}else {
			System.out.println("Contact: "+primaryContact+" not found in the Customer record");
			logInfo.fail("Contact: "+primaryContact+" not found in the Customer record");
		}
		
	}
	
	public void openCustomer(String customerName) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Thread.sleep(1500);
		eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Relationships']"), 10); // Explicit Wait
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Customers']"), 10); // Explicit Wait
		customersLink.click();
		
		// Sort customer list by recently created
		if(!quickSortDropdown.getAttribute("value").equals("Recently Created"))
			quickSortDropdown.sendKeys("Recently Created");
		
		boolean customerFlag = false;
		for(int i=0;i<customerList.size();i++) {
			WebElement currentCustomer = customerList.get(i);
			String text = currentCustomer.getText().trim();
			if(text.equals(customerName)) {
				customerFlag = true;
				action.moveToElement(currentCustomer).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentCustomer);
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", parentTd);
				String rowId = parentTr.getAttribute("id");
				if(rowId.isBlank()) {
					WebElement customerRow = (WebElement)je.executeScript("return arguments[0].parentNode;", parentTr);
					rowId = customerRow.getAttribute("id");
				}
				driver.findElement(By.xpath("//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='View']")).click();
				break;
			}
		}
		if(!customerFlag) {
			for (int i = 1; i < paginationList.size(); i++) {
				boolean customerFlag2 = false;
				action.moveToElement(paginationLabel).build().perform();
				eleAvailability(driver, paginationList.get(i), 10);
				paginationList.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < customerList.size(); j++) {
					if(customerList.get(j).getText().trim().equals(customerName)) {
						customerFlag2 = true;
						customerList.get(j).click();
						break;
					}
				}
				if(customerFlag2)
					break;
			}
		}
		Thread.sleep(1500);
	}
	
	public CustomerCreationPage clickOnNewCustomerLink() throws InterruptedException {
		if(driver.getTitle().equals("Notice")) {
			driver.findElement(By.xpath("//input[@id='goback']")).click();
		}
		eleAvailability(driver, listLink, 10);
		Thread.sleep(5000);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, relationshipsLink, 10);
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, customersLink, 10);
		action.moveToElement(customersLink).build().perform();
		eleAvailability(driver, newLink, 10);
		newLink.click();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
		
		return new CustomerCreationPage();
		
	}
	
	public void changeRole(String roleTextData, String roleTypeData) throws InterruptedException {
		String currentRole = role.getText().trim();
		System.out.println(currentRole);
		if(currentRole.equals(roleTextData)) {
			System.out.println("Role already selected");
		} else {
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath("//div[@id='spn_cRR_d1']/a"))).build().perform();
			
			for(int i=0;i<rolesList.size();i++) {
				WebElement roleElement = rolesList.get(i);
				String roleValue = roleElement.getText().trim();
				if(roleValue.equals(roleTextData)) {
					if(roleTypeData.equals("Production")) {
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						WebElement liTagElement = (WebElement)executor.executeScript("return arguments[0].parentNode.parentNode;", roleElement);
						String id = liTagElement.getAttribute("id");
						try {
							WebElement roleType = driver.findElement(By.xpath("//li[@id='"+id+"']/a/span[@class='ns-role-accounttype']"));
							if(roleType.isDisplayed())
								continue;
						}
						catch(NoSuchElementException e) {
							driver.findElement(By.xpath("//li[@id='"+id+"']/a/span[@class='ns-role-menuitem-text']")).click();
							break;
						}
					}
				}
			}
		}
	}
}
