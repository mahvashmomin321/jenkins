package com.capgemini.model;
import com.capgemini.exception.AgeNotWithinRangeException;
import com.capgemini.exception.NameNotValidException;

public class Student {
	private double rollNo;
	private String name;
	private double age;
	private String courseName;

	public Student(double rollNo, String name, double age, String courseName) throws AgeNotWithinRangeException, NameNotValidException {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.courseName = courseName;

		if (!(age >= 15 && age <= 21)) {
			throw new AgeNotWithinRangeException("Age not within Range");
		}
		
		if (!(name.matches("^[a-zA-Z]*$"))){
			throw new NameNotValidException("name not valid");
		}
	}

	
}
