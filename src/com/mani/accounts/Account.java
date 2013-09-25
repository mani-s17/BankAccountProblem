package com.mani.accounts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
 *
 * Account class is a abstract for all type of accounts, which implements common behaviour across accounts
 * like withdraw, deposit, generate reports. Also it provides a hook for implementing specific behaviour
 * like account number, minimum balance and user details.
 */
public abstract class Account implements ManiBank
{
	private long accountBalance;
	private Stack<String> history = new Stack<String>();
	public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

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

	public void generateReport()
	{
		File reportsDir = new File("reports");
		if (!reportsDir.exists())
			reportsDir.mkdir();
		File report = new File(reportsDir.getAbsolutePath() + File.separator + this.getAccountNumber() + "_" + new Date().getTime() + ".txt");
		try
		{
			FileWriter writer = new FileWriter(report);
			BufferedWriter out = new BufferedWriter(writer);
			while(!this.getTransactionHistory().isEmpty())
			{
				out.write(this.getTransactionHistory().pop());
				out.write("\n");
			}
			out.close();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

	public abstract String getAccountNumber();

	public abstract long getMinimumBalance();

	public abstract User getUser();
}
