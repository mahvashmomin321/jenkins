package com.capgemini.model;

import com.capgemini.exception.DebitLimitExceeded;
import com.capgemini.exception.LowBalanceException;

public class SavingAccount extends BankAccount {

	private boolean salaryAccount;
	public static final double MINIMUM_BALANCE = 10000;

	public SavingAccount() {
	}

	public SavingAccount(double accountId, String accountHolderName, double accountBalance, boolean salaryAccount) {
		super(accountId, accountHolderName, "SAVING", accountBalance);
		this.salaryAccount = salaryAccount;
	}

	public boolean isSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	@Override
	public double withdraw(double amount) throws LowBalanceException, DebitLimitExceeded{
		if (salaryAccount) {
			return super.withdraw(amount);
		} else {
			if (getAccountBalance() - amount >= MINIMUM_BALANCE)
				setAccountBalance(getAccountBalance() - amount);
			else
				throw new LowBalanceException("Low Balance Exception");
			return getAccountBalance();
		}
	}
	
	@Override
	public double deposit(double amount) {
		return super.deposit(amount);
	}

}
