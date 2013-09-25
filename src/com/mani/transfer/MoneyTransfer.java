package com.mani.transfer;

import java.util.Date;

import com.mani.accounts.Account;
import com.mani.common.ManiBank;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 5:27 AM
 */
public abstract class MoneyTransfer
{
	/*public boolean doTransfer(Account source, Account destination, long amountToTransfer)
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
	}*/
}
