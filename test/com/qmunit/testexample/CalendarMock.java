package com.qmunit.testexample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import mockit.Mock;
import mockit.MockUp;

public final class CalendarMock extends MockUp<Calendar> {
	
	private int day;
	private int month;
	private int year;
	private Date date;
	
	public CalendarMock(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		date = new GregorianCalendar(year, month, day).getTime();
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
	
	@Mock
	public Date getTime() {
		return date;
	}
}
