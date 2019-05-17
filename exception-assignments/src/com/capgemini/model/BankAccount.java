package com.capgemini.model;

import com.capgemini.exception.DebitLimitExceeded;
import com.capgemini.exception.LowBalanceException;

public class BankAccount {
	private double accountId;
	private String accountHolderName;
	private String accountType;
	private double accountBalance;

	public BankAccount() {
		super();
	}

	public BankAccount(double accountId, String accountHolderName, String accountType, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public double withdraw(double amount) throws LowBalanceException, DebitLimitExceeded {
		if (accountBalance > amount)
			accountBalance = accountBalance - amount;
		else
			throw new LowBalanceException("Low Balance Exception");
		return accountBalance;
	}

	public double deposit(double amount) {
		accountBalance = accountBalance + amount;
		return accountBalance;
	}

	public double getAccountId() {
		return accountId;
	}

	public void setAccountId(double accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
