package com.qmjunit.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

	protected Date birthdate;

	public int getAge() throws IllegalStateException {
		if (birthdate == null) {
			throw new IllegalStateException("Birthday was not set!");			
		} else {
			int yearToday = Calendar.getInstance().get(Calendar.YEAR);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(birthdate);
			int birthYear = calendar.get(Calendar.YEAR);
			
			if (Calendar.getInstance().get(Calendar.MONTH) > calendar.get(Calendar.MONTH)  ||
				Calendar.getInstance().get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH) >= calendar.get(Calendar.DAY_OF_MONTH)) {
				
				return yearToday - birthYear;
			
			} else {				
				return yearToday - birthYear - 1;
			}
		}
	}

	public void setBirthDate(Date aBirthDate) throws IllegalStateException {
		if (aBirthDate.after(Calendar.getInstance().getTime())) {
			throw new IllegalStateException("Birthday has to be later than the actual date!");
		}
		
		this.birthdate = aBirthDate;
	}
}