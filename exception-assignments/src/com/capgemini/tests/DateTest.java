package com.capgemini.tests;

import org.junit.Test;

import com.capgemini.exception.InvalidDayException;
import com.capgemini.exception.InvalidMonthException;
import com.capgemini.model.Date;

public class DateTest {

	
	
	@Test(expected=InvalidMonthException.class)
	public void testWithInvalidMonth() throws InvalidMonthException, InvalidDayException {
		Date date=new Date(21,13,2018);
		date.dateValiditon();
	}
	
	@Test(expected=InvalidDayException.class)
	public void testWithInvalidDay() throws InvalidMonthException, InvalidDayException {
		Date date=new Date(32,12,2018);
		date.dateValiditon();
	}
	
	@Test(expected=InvalidDayException.class)
	public void testWithLeapYearAndInvalidDate() throws InvalidMonthException, InvalidDayException {
		Date date=new Date(28,2,2016);
		date.dateValiditon();
	}
}
