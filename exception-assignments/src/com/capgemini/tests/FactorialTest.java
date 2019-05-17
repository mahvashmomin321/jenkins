package com.capgemini.tests;

import org.junit.Test;

import com.capgemini.exception.FactorialException;
import com.capgemini.exception.InvalidInputException;
import com.capgemini.model.Factorial;

public class FactorialTest {

	@Test(expected = InvalidInputException.class)
	public void throwsExceptionWithInvalidInput() throws InvalidInputException, FactorialException {
		Factorial factorial1 = new Factorial();
		factorial1.getFactorial(1);
	}
	
//	
//	@Test(expected= FactorialException.class)
//	public void throwsFactorialExceptionWithInvalidInput() throws InvalidInputException, FactorialException {
//		Factorial factorial1 = new Factorial();
//		factorial1.getFactorial();
//	}
}