package com.mani.users;

import java.util.HashMap;

import com.mani.accounts.Account;
import com.mani.common.Bank;
import com.mani.exceptions.InvalidAccountNumberException;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/24/13
 * Time: 10:24 PM
 *
 * User is a generic class which holds all User information.
 * In future users like NRI User, Senior Citizen User can extend this class and implement its own behaviour.
 *
 * User object is one-to-many relationship with Accounts
 * User can hold multiple type of accounts
 */
public class User
{
	private String firstName, lastName, address;
	private long mobileNumber;
	private HashMap<String, Account> accounts = new HashMap<String, Account>(10, 0.75F);

	public User()
	{
		Bank.getBank().addUser(this);
	}

	public User(String firstName, String lastName, String address, long mobileNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		Bank.getBank().addUser(this);
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public long getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public HashMap<String, Account> getAccounts()
	{
		return accounts;
	}

	public Account getAccount(String accountNumber) throws InvalidAccountNumberException
	{
		Account account = getAccounts().get(accountNumber);
		if(account == null)
			throw new InvalidAccountNumberException("Account number which you have provided is wrong. Please verify your account number.");
		return account;
	}

	public void addAccount(Account account)
	{
		this.accounts.put(account.getAccountNumber(), account);
	}

	public boolean withdraw(String accountNumber, long amount) throws InvalidAccountNumberException
	{
		return getAccount(accountNumber).withdraw(amount);
	}

	public boolean deposit(String accountNumber, long amount) throws InvalidAccountNumberException
	{
		return getAccount(accountNumber).deposit(amount);
	}
}
