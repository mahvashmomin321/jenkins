package com.capgemini.tests;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exception.DebitLimitExceeded;
import com.capgemini.model.CurrentAccount;

public class CurrentAccountTest {

	private CurrentAccount account;
	
	@Before
	public void setUp() {
		account = new CurrentAccount(101, "John", 45000);
	}


	
	@Test(expected=DebitLimitExceeded.class)
	public void testWithdrawWithDebitLimitExceed() throws DebitLimitExceeded {
		 account.withdraw(65000);
		account.withdraw(5000);


	}

}
