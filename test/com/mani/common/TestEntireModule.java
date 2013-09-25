package com.mani.common;

import com.mani.accounts.Account;
import com.mani.accounts.Checking;
import com.mani.accounts.Current;
import com.mani.accounts.Savings;
import com.mani.users.User;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 2:58 AM
 */
public class TestEntireModule extends TestCase
{
	public void testCreateUser() throws Exception
	{
		// Enrolling 2 new users in common
		User user1 = new User("Subramaniam", "Srinivasan", "Bangalore", 9480200530L);
		User user2 = new User("Mani", "S", "Kanyakumari", 9480200530L);

		// User1 is interested to open savings & current account
		Account savings = new Savings(user1);
		Account checking = new Checking(user2);
		user1.addAccount(savings);
		user1.addAccount(checking);

		// User2 is interested to open only savings account
		Account current = new Current(user2);
		user2.addAccount(current);

		// User1 & User2 Deposits 5000 to their savings account number SA_1 & SA_2 respectively
		assertEquals(true, user1.getAccount(savings.getAccountNumber()).deposit(5000));
		assertEquals(true, user2.getAccount(current.getAccountNumber()).deposit(5000));

		// User1 withdraws 2500 from his Savings & Current account number SA_1 & CU_1 respectively
		assertEquals(true, user1.getAccount(savings.getAccountNumber()).withdraw(2500));
		assertEquals(false, user1.getAccount(checking.getAccountNumber()).withdraw(2500));

	}
}
