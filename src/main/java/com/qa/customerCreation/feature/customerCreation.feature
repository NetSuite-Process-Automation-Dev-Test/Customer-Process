Feature: Creation of Customers in Netsuite

Scenario: Test scenario for customer creation
Then Create a Customer using excel data at "C:\Users\Sravan Kumar\Desktop\Process Automation Excel Data\Customer Data.xlsx,Customer"
Then Verification of Update Primary feature for contacts in the Customer record using excel data at "C:\Users\Sravan Kumar\Desktop\Process Automation Excel Data\Customer Data.xlsx,Update Primary Contact"
Then Verify updating primary bank account for customer using excel data at "C:\Users\Sravan Kumar\Desktop\Process Automation Excel Data\Customer Data.xlsx,Update Primary Account"
Then Verification of Custom form changes in the Customer using excel data at "C:\Users\Sravan Kumar\Desktop\Process Automation Excel Data\Customer Data.xlsx,Custom Form"