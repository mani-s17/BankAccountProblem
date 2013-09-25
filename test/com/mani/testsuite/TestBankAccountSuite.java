package com.mani.testsuite;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/25/13
 * Time: 11:25 AM
 */

import com.mani.accounts.TestAccount;
import com.mani.common.TestBank;
import com.mani.common.TestEntireModule;
import com.mani.common.TestUser;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestBank.class, TestUser.class, TestAccount.class, TestEntireModule.class})

public class TestBankAccountSuite
{
}
