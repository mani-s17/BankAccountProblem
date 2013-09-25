package com.mani.accounts;

import java.util.Date;

import com.mani.common.Constant;
import com.mani.users.User;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 2:11 AM
 *
 * Current account will implement its own way to generate account number and minimum balance
 */
public class Current extends Account
{
	private static int counter;
	private String accountNumber;
	private User user;

	public Current(User user)
	{
		++counter;
		this.accountNumber = Constant.CURRENT_ACCOUNT + counter;
		this.user = user;
		String message =  user.getFirstName() + " Opened Current account - Account number " + getAccountNumber() + ", with balance " + Constant.CURRENT_ACCOUNT_MIN_BAL + " at " + dateFormat.format(new Date());
		setTransactionHistory(message);
		deposit(Constant.CURRENT_ACCOUNT_MIN_BAL);
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
		return Constant.CURRENT_ACCOUNT_MIN_BAL;
	}

	@Override
	public User getUser()
	{
		return user;
	}
}
