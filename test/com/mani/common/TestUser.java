package com.mani.common;

import com.mani.accounts.Savings;
import com.mani.exceptions.InvalidAccountNumberException;
import com.mani.users.User;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/24/13
 * Time: 10:29 PM
 */
public class TestUser extends TestCase
{
	private User user;
	private String firstName = "Mani";
	private String lastName = "S";
	private String address = "Kanyakumari";
	private long mobileNumber = 9480200580L;

	@Override
	public void setUp() throws Exception
	{
		user = new User("Subramaniam", "Srinivasan", "Bangalore", 9480200530L);
	}

	public void testGetFirstName()
	{
		user.setFirstName(firstName);
		assertEquals(firstName, user.getFirstName());
	}

	public void testGetLastName()
	{
		user.setLastName(lastName);
		assertEquals(lastName, user.getLastName());
	}

	public void testGetAddressTest()
	{
		user.setAddress(address);
		assertEquals(address, user.getAddress());
	}

	public void testGetMobileNumberTest()
	{
		user.setMobileNumber(mobileNumber);
		assertEquals(mobileNumber, user.getMobileNumber());
	}

	public void testGetAccounts() throws Exception
	{
		Savings savings = new Savings(user);
		user.addAccount(savings);
		assertEquals(1, user.getAccounts().size());
		assertEquals(savings, user.getAccount(savings.getAccountNumber()));
	}

	public void testWithdraw() throws Exception
	{
		try
		{
			user.withdraw("SA_2", 100);
			user.withdraw("CU_2", 5000);
			assertTrue("Expecting excpetion but not occured", false);
		}
		catch (InvalidAccountNumberException e)
		{
		}
	}

	public void testDeposit() throws Exception
	{
		try
		{
			user.deposit("SA_2", 1000);
			user.deposit("CU_2", 5000);
			assertTrue("Expecting excpetion but not occured", false);
		}
		catch (InvalidAccountNumberException e)
		{
		}
	}
}
