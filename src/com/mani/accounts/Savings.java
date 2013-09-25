package com.mani.accounts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import com.mani.common.Constant;
import com.mani.users.User;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/24/13
 * Time: 11:18 PM
 *
 * Savings account will implement its own way to generate account number and minimum balance
 */
public class Savings extends Account
{
	private static int counter;
	private String accountNumber;
	private User user;

	public Savings(User user)
	{
		++counter;
		this.accountNumber = Constant.SAVING_ACCOUNT + counter;
		this.user = user;
		String message = user.getFirstName() + " Opened Savings account - Account number " + getAccountNumber() + ", with balance " + Constant.SAVINGS_ACCOUNT_MIN_BAL + " at " + dateFormat.format(new Date());
		deposit(Constant.SAVINGS_ACCOUNT_MIN_BAL);
		setTransactionHistory(message);

		System.out.println(message);
	}

	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}

	@Override
	public long getMinimumBalance()
	{
		return Constant.SAVINGS_ACCOUNT_MIN_BAL;
	}

	@Override
	public User getUser()
	{
		return user;
	}
}
