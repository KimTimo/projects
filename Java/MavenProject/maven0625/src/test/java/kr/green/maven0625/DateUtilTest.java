package kr.green.maven0625;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class DateUtilTest {
	/*
	@Test
	public void testLastDay() {
		assertEquals(DateUtil.getLatDay(2000, 1), 31);
		assertEquals(DateUtil.getLatDay(2001, 2), 28);
		assertEquals(DateUtil.getLatDay(2000, 8), 31);
		assertEquals(DateUtil.getLatDay(2004, 2), 29);
		assertNotEquals(DateUtil.getLatDay(2004, 2), 28);
	}*/
	
	
	//@Ignore
	@Test
	public void testLeapYear() {
		assertTrue(DateUtil.isLeapYear(2000));
		assertTrue(DateUtil.isLeapYear(2004));
		assertFalse(DateUtil.isLeapYear(2002));
		assertTrue(DateUtil.isLeapYear(2008));
	}
	

}
