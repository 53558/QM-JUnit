package com.qmunit.testexample;

import java.util.Calendar;

import mockit.Mock;
import mockit.MockUp;

public final class CalendarMock extends MockUp<Calendar> {
	
	private int day;
	private int month;
	private int year;
	
	public CalendarMock(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Mock
	public int get(int id) {
		if (id == Calendar.DAY_OF_MONTH) {
			return day;
		}
		
		if (id == Calendar.MONTH) {
			return month;
		}
		
		if (id == Calendar.YEAR) {
			return year;
		}
		
		return -1;
	}
}
