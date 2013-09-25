package com.mani.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mani.accounts.Account;
import com.mani.users.User;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 12:29 AM
 */
public class Bank implements ManiBank
{
	private static Bank bank;
	private List<User> users;

	private Bank()
	{
		users = new ArrayList<User>();
	}

	public static Bank getBank()
	{
		if (bank == null)
		{
			synchronized (Bank.class)
			{
				if(bank == null)
					bank = new Bank();
			}
		}
		return bank;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void addUser(User users)
	{
		this.users.add(users);
	}

	public boolean doTransfer(Account source, Account destination, long amountToTransfer)
	{
		if(source.withdraw(amountToTransfer + getServiceCharge(destination, amountToTransfer)))
		{
			boolean isSuccess = destination.deposit(amountToTransfer);
			if(isSuccess)
			{
				source.setTransactionHistory("Transfered " + amountToTransfer + " to account number " + destination.getAccountNumber() + ", at " + source.dateFormat.format(new Date()));
				destination.setTransactionHistory("Credited " + amountToTransfer + " from account number " + source.getAccountNumber() + ", at " + destination.dateFormat.format(new Date()));
			}
			return isSuccess;
		}
		else
			return false;
	}

	public int getServiceCharge(Account destination, long amountToTransfer)
	{
		if(destination instanceof ManiBank)
		{
			return 0;
		}
		else
		{
			if(amountToTransfer < 5000)
				return 15;
			else if(amountToTransfer >= 5000 && amountToTransfer < 150000)
				return 50;
			else if(amountToTransfer >= 150000 && amountToTransfer < 500000)
				return 150;
			else
				return 500;
		}
	}
}
