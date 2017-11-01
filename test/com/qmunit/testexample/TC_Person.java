package com.qmunit.testexample;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qmjunit.example.Person;

import mockit.Mock;
import mockit.MockUp;

public class TC_Person {

	protected Person person;

	public static class GregCalendarMock extends MockUp<GregorianCalendar>{
		@Mock
		public static Calendar getInstance() {
			return new GregorianCalendar(2010, 1, 3);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		person = new Person();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testGetDefaultAge() {
		person.getAge();
	}

	@Test
	public void testGetAgeYesterday() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(0, actual);
	}

	@Test
	public void testGetAgeToday() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(0, actual);
	}

	@Test(expected = IllegalStateException.class)
	public void testGetAgeTomorrow() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);

		person.setBirthDate(calendar.getTime());
	}
	
	@Test
	public void testGetAgeLastMonth() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
				GregorianCalendar.getInstance().get(Calendar.MONTH) - 1, 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(0, actual);
	}

	@Test(expected = IllegalStateException.class)
	public void testGetAgeNextMonth() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
				GregorianCalendar.getInstance().get(Calendar.MONTH) + 1, 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
	}

	@Test
	public void testGetAgeLastYear() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR) - 1,
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(1, actual);
	}

	@Test(expected = IllegalStateException.class)
	public void testGetAgeNextYear() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR) + 1,
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
	}
	
	@Test
	public void testGetOneDayBelowOneYear() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR) - 1,
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(0, actual);
	}
	
	@Test
	public void testGetoneDayAboveOneYear() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR) - 1,
				GregorianCalendar.getInstance().get(Calendar.MONTH), 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(1, actual);
	}
	
	@Test
	public void testGetOneMonthBelowOneYear() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR) - 1,
				GregorianCalendar.getInstance().get(Calendar.MONTH) + 1, 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(0, actual);
	}
	
	@Test
	public void testGetOneMonthAboveOneYear() {
		GregorianCalendar calendar = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR) -1,
				GregorianCalendar.getInstance().get(Calendar.MONTH) - 1, 
				GregorianCalendar.getInstance().get(Calendar.DAY_OF_MONTH));

		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(1, actual);
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
