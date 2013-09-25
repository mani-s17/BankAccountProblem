package com.mani.accounts;

import com.mani.common.Constant;
import com.mani.users.User;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 1:08 AM
 */
public class TestAccount extends TestCase
{
	private Account savings, current;
	private User user = new User("Subramaniam", "Srinivasan", "Bangalore", 9480200530L);

	@Override
	public void setUp() throws Exception
	{
		savings = new Savings(user);
		current = new Current(user);
		super.setUp();
	}

	public void testWithdraw() throws Exception
	{
		assertEquals(Constant.SAVINGS_ACCOUNT_MIN_BAL, savings.getAccountBalance());
		assertEquals(false, savings.withdraw(600));
		assertEquals(true, savings.deposit(500));
		assertEquals(true, savings.withdraw(400));
		assertEquals(600, savings.getAccountBalance());

		// Testing Transaction History
		assertEquals(4, savings.getTransactionHistory().size());
	}

	public void testDeposit() throws Exception
	{
		assertEquals(500, savings.getAccountBalance());
		assertEquals(true, savings.deposit(500));
		assertEquals(1000, savings.getAccountBalance());

		// Testing Transaction History
		assertEquals(3, savings.getTransactionHistory().size());
		savings.generateReport();
		current.generateReport();
	}

	public void testGetAccountBalance() throws Exception
	{
		assertEquals(Constant.SAVINGS_ACCOUNT_MIN_BAL, savings.getAccountBalance());
		assertNotSame(Constant.CURRENT_ACCOUNT_MIN_BAL, savings.getAccountBalance());
	}

	public void testGetMinimumBalance() throws Exception
	{
		assertEquals(Constant.SAVINGS_ACCOUNT_MIN_BAL, savings.getMinimumBalance());
		assertEquals(Constant.CURRENT_ACCOUNT_MIN_BAL, current.getMinimumBalance());
	}

	public void testGetAccountNumber() throws Exception
	{
		assertEquals(true, savings.getAccountNumber().startsWith(Constant.SAVING_ACCOUNT));
		assertEquals(false, current.getAccountNumber().startsWith(Constant.SAVING_ACCOUNT));
	}

	public void testGetUser() throws Exception
	{
		assertEquals(user, savings.getUser());
		assertEquals(user, current.getUser());
	}
}
