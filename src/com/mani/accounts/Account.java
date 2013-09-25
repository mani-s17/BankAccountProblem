package com.mani.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import com.mani.common.ManiBank;
import com.mani.users.User;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/24/13
 * Time: 11:22 PM
 */
public abstract class Account implements ManiBank
{
	private long accountBalance;

	public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Stack<String> history = new Stack<String>();

	public Account()
	{
	}

	public boolean withdraw(long amount)
	{
		if(accountBalance < amount || getMinimumBalance() > accountBalance-amount)
		{
			System.err.println("Insufficient Balance");
			return false;
		}
		else
		{
			accountBalance -= amount;
			String message = "Withdrawn " + amount + " from " + this.getAccountNumber() + " at " + dateFormat.format(new Date());
			setTransactionHistory(message);
			System.out.println(message);
			return true;
		}
	}

	public boolean deposit(long amount)
	{
		accountBalance += amount;
		String message = "Deposited " + amount + " to " + this.getAccountNumber() + " at " + dateFormat.format(new Date());
		setTransactionHistory(message);
		System.out.println(message);
		return true;
	}

	public long getAccountBalance()
	{
		return accountBalance;
	}

	public Stack<String> getTransactionHistory()
	{
		return history;
	}

	public void setTransactionHistory(String message)
	{
		history.push(message);
	}

	public abstract String getAccountNumber();

	public abstract long getMinimumBalance();

	public abstract User getUser();

	public abstract void generateReport();

	@Override
	public boolean equals(Object object)
	{
		boolean result = false;
		if (object == null || object.getClass() != getClass())
			result = false;
		else
		{
			Account account = (Account) object;
			if (this.getAccountNumber() == account.getAccountNumber())
				result = true;
		}
		return result;
	}

	// just omitted null checks
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.getAccountNumber().hashCode();
		return hash;
	}
}
