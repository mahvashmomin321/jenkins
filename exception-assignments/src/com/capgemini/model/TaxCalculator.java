package com.capgemini.model;

import com.capgemini.exception.CountryNotValidException;
import com.capgemini.exception.EmployeeNameInvalidException;
import com.capgemini.exception.TaxNotEligibleException;

public class TaxCalculator {
	private String employeeName;
	private Boolean isIndian;
	private double employeeSalary;
	private double taxAmount;

	public TaxCalculator() {
		super();
	}



	public double calculateTax(String employeeName,Boolean isIndian,double employeeSalary) throws TaxNotEligibleException, CountryNotValidException, EmployeeNameInvalidException {
		
		if(employeeName==null || employeeName.isEmpty()) {
			throw new EmployeeNameInvalidException("The employee name cannot be empty");
		}
		if(isIndian) {
			if (employeeSalary >= 100000) {
				this.taxAmount = employeeSalary * (8 / 100);
			}
			else if (employeeSalary >= 50000 && employeeSalary<=100000) {
				this.taxAmount = employeeSalary * (6 / 100);
			}
			else if (employeeSalary >= 30000 && employeeSalary<=50000) {
				this.taxAmount = employeeSalary * (5 / 100);
			}
			else if (employeeSalary >= 10000 && employeeSalary<=30000) {
				this.taxAmount = employeeSalary * (4 / 100);
			}
			else {
				throw new TaxNotEligibleException("The employee does not need to pay tax");
			}
		}
		else {
			throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
		}
		

		return this.taxAmount;
	}
	

	public double getTaxAmount() {
		return taxAmount;
	}



	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	
	
	public String toString() {
		return "Tax amount is" + getTaxAmount();
		
	}

}
