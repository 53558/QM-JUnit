package com.qmjunit.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

	protected Date currentDate;
	protected Date birthdate;

	public int getAge() {
		if (birthdate == null) {
			return 0;
		} else {
			int yearToday;
			Calendar calendar = new GregorianCalendar();

			if (currentDate == null) {
				yearToday = Calendar.getInstance().get(Calendar.YEAR);
			} else {
				calendar.setTime(currentDate);
				yearToday = calendar.get(Calendar.YEAR);
			}

			calendar.setTime(birthdate);
			int birthYear = calendar.get(Calendar.YEAR);
			return yearToday - birthYear;
		}
	}

	public void setBirthDate(Date aBirthDate) {
		this.birthdate = aBirthDate;
	}
}
