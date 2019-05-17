package com.capgemini.tests;

import org.junit.Test;

import com.capgemini.exception.AgeNotWithinRangeException;
import com.capgemini.exception.NameNotValidException;
import com.capgemini.model.Student;

public class StudentTest {

	
	@Test(expected=AgeNotWithinRangeException.class)
	public void testAgeIsNotWithRangeException() throws AgeNotWithinRangeException, NameNotValidException {
	Student student1= new Student(101,"John",22,"Math");
	}
	
	
	@Test(expected=NameNotValidException.class)
	public void testNameNotValideException() throws NameNotValidException, AgeNotWithinRangeException {
		Student student1= new Student(101,"John@",17,"Math");
	}	
}
