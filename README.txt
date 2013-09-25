BankAccountProblem
==================

Design of Bank Account Problem

Overview of classes and interface used
=======================================
1. ManiBank
		- Marker Interface to mark all Accounts & Users belongs to Mani Bank. Purpose to distinguish account while calculating service charge for transferring money to other bank account
2. Bank implements ManiBank 
		- Bank class includes method to get and add Users to bank also have method to transfer money across banks
3. Account implents ManiBank
		- Account class is a abstract for all type of accounts, which implements common behaviour across accounts like withdraw, deposit, generate reports. Also it provides a hook for implementing specific behaviour like account number, minimum balance and user details.
	3.1. Savings
		- Savings account will implement its own way to generate account number and minimum balance
	3.2 Current
		- Current account will implement its own way to generate account number and minimum balance
	3.3 Checking
		- Checking account will implement its own way to generate account number and minimum balance
4. User
		- User is a generic class which holds all User information. In future users like NRI User, Senior Citizen User can extend this class and implement its own behaviour. User object is one-to-many relationship with Accounts. User can hold multiple type of accounts
5. Constant
		- Constant class contains all Constants which are used for Bank and its related entities
6. InvalidAccountNumberException
		- If user gives Invalid Account number for doing transaction then InvalidAccountNumberException will raise

Testing
=======
To run test cases Run com.mani.testsuite.TestBankAccountSuite class
