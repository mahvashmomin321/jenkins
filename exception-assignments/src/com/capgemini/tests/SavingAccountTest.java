package com.capgemini.tests;

import org.junit.Test;

import com.capgemini.exception.DebitLimitExceeded;
import com.capgemini.exception.LowBalanceException;
import com.capgemini.model.SavingAccount;

public class SavingAccountTest {

	private SavingAccount account;

	@Test(expected=LowBalanceException.class)
	public void testWithdrawWithSalaryAccountAndInSufficientBalance() throws LowBalanceException, DebitLimitExceeded {
		account = new SavingAccount(101, "John", 45000, true);
		account.withdraw(50000);
	}

	
	@Test(expected=LowBalanceException.class)
	public void testWithdrawWithNotSalaryAndInSufficientBalance() throws LowBalanceException, DebitLimitExceeded {
		account = new SavingAccount(101, "John", 45000, false);
		account.withdraw(50000);
	}



}
