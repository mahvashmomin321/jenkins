package com.capgemini.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.CountryNotValidException;
import com.capgemini.exception.EmployeeNameInvalidException;
import com.capgemini.exception.TaxNotEligibleException;
import com.capgemini.model.TaxCalculator;

public class TaxCalculatorTest {

	
	@Test(expected=CountryNotValidException.class)
	public void testInvalidCountry() throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee1= new TaxCalculator();
		employee1.calculateTax("Ron", false, 34000);
		
	}
	
	
	@Test(expected=TaxNotEligibleException.class)
	public void testNotEligibleForTax() throws TaxNotEligibleException, EmployeeNameInvalidException, CountryNotValidException {
		TaxCalculator employee2= new TaxCalculator();
		employee2.calculateTax("Tim",true,1000);
	}
	
	@Test(expected=EmployeeNameInvalidException.class)
	public void testInvalidEmployeeName() throws EmployeeNameInvalidException, CountryNotValidException, TaxNotEligibleException {
		TaxCalculator employee2= new TaxCalculator();
		employee2.calculateTax(null, true, 24000);
	}
	
	@Test
	public void testValidTaxAmount() throws TaxNotEligibleException, CountryNotValidException, EmployeeNameInvalidException {
		TaxCalculator employee2= new TaxCalculator();
		employee2.calculateTax("Jack",true, 55000.0);
		employee2.toString();
		assertEquals("Tax amount is 3300.0",employee2.getTaxAmount());
	}
	


}
