package com.capgemini.model;

import com.capgemini.exception.DebitLimitExceeded;

public class CurrentAccount extends BankAccount {
	private double debitLimit=20000;
	private double borrowedAmount;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(double accountId, String accountHolderName, double accountBalance) {
		super(accountId, accountHolderName, "CURRENT", accountBalance);

	}

	public double getDebitLimit() {
		return debitLimit;
	}

	public void setDebitLimit(double debitLimit) {
		this.debitLimit = debitLimit;
	}

	public double getBorrowedAmount() {
		return borrowedAmount;
	}

	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}

	@Override
	public double withdraw(double amount) throws DebitLimitExceeded {
		double temp = getAccountBalance() - amount;
		if (temp >= 0)
			setAccountBalance(temp);
		else if (Math.abs(temp) <= (debitLimit - borrowedAmount)) {
			setAccountBalance(0);
			borrowedAmount = borrowedAmount + Math.abs(temp);
		} else
			throw new DebitLimitExceeded("Debit Limit exceeded");

		return getAccountBalance();
	}

	@Override
	public double deposit(double amount) {
		if (borrowedAmount == 0)
			return super.deposit(amount);
		else if (amount >= borrowedAmount) {
			setAccountBalance(amount - borrowedAmount);
			borrowedAmount = 0;
		} else {
			borrowedAmount = borrowedAmount - amount;
		}
		return getAccountBalance();
	}
}
