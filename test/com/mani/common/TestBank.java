package com.mani.common;

import com.mani.accounts.Account;
import com.mani.accounts.Current;
import com.mani.accounts.Savings;
import com.mani.users.User;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 2:43 AM
 */
public class TestBank extends TestCase
{
	Bank bank;

	@Override
	public void setUp() throws Exception
	{
		bank = Bank.getBank();
		super.setUp();
	}

	public void testGetBank()
	{
		assertEquals(true, bank instanceof ManiBank);
	}

	public void testGetUsers()
	{
		assertEquals(0, bank.getUsers().size());
	}

	public void testAddUser()
	{
		new User("Subramaniam", "Srinivasan", "Bangalore", 9480200530L);
		new User("Mani", "S", "Kanyakumari", 9480200530L);
		assertEquals(2, bank.getUsers().size());
	}

	public void testDoTransfer() throws Exception
	{
		// Enrolling 2 new users in common
		User user1 = new User("Subramaniam", "Srinivasan", "Bangalore", 9480200530L);
		User user2 = new User("Mani", "S", "Kanyakumari", 9480200530L);
		User user3 = new User("Vinoth", "S", "Kanyakumari", 9480200530L);

		// User1 is interested to open savings & current account
		Account SA_1 = new Savings(user1);
		Account CU_1 = new Current(user1);
		user1.addAccount(SA_1);
		user1.addAccount(CU_1);

		// User2 is interested to open only savings account
		Account SA_2 = new Savings(user2);
		user2.addAccount(SA_2);

		// User3 is interested to open only savings account
		Account SA_3 = new Savings(user3);
		user3.addAccount(SA_3);

		// User1 & User2 Deposits 5000 from his savings account number SA_1 to SA_2 respectively
		assertEquals(true, user1.getAccount("SA_1").deposit(5000));
		assertEquals(5500, user1.getAccount("SA_1").getAccountBalance());

		assertEquals(true, user2.getAccount("SA_2").deposit(6000));
		assertEquals(6500, user2.getAccount("SA_2").getAccountBalance());

		// User1 transfers 2000 from his Savings account to Current account
		assertEquals(5500, user1.getAccount("SA_1").getAccountBalance());
		assertEquals(1000, user1.getAccount("CU_1").getAccountBalance());
		assertEquals(true, bank.doTransfer(SA_1, CU_1, 2000));
		assertEquals(3500, user1.getAccount("SA_1").getAccountBalance());
		assertEquals(3000, user1.getAccount("CU_1").getAccountBalance());

		// Revert Transaction
		assertEquals(true, bank.doTransfer(CU_1, SA_1, 2000));

		// User1 transfers 2000 from his savings account SA_1 to User2 Savings Account SA_2
		assertEquals(5500, user1.getAccount("SA_1").getAccountBalance());
		assertEquals(6500, user2.getAccount("SA_2").getAccountBalance());
		assertEquals(true, bank.doTransfer(SA_1, SA_2, 2000));
		assertEquals(3500, user1.getAccount("SA_1").getAccountBalance());
		assertEquals(8500, user2.getAccount("SA_2").getAccountBalance());
	}
}
