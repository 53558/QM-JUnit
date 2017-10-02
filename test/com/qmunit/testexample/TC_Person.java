package com.qmunit.testexample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TC_Person {

	protected Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person();
	}

	@Test
	public void testGetAge() {
		int actual = person.getAge();
		assertEquals(0, actual);
	}

	@After
	public void tearDown() throws Exception {
	}

}
