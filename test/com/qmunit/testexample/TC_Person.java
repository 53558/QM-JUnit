package com.qmunit.testexample;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qmjunit.example.Person;

public class TC_Person {

	protected Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person();
	}

	@Test
	public void testGetDefaultAge() {
		int actual = person.getAge();
		assertEquals(0, actual);
	}

	public void testGetAge() {
		GregorianCalendar calendar = new GregorianCalendar(1971, 3, 23);
		person.setBirthDate(calendar.getTime());
		int actual = person.getAge();
		assertEquals(31, actual);
	}

	@After
	public void tearDown() throws Exception {
	}

}
