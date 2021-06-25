package kr.green.maven0625;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DateUtilTest2 {
	DateUtil2 dateUtil2;
	
	//@Before // 테스트 메소드를 실행하기 전에 먼저 실행할 메소드
	@BeforeClass // 이 테스트 클래스를 실행하기 전에 먼저 실행
	public void before() {
		dateUtil2 = new DateUtil2();
	}
	
	//@After // 테스트 메소드를 실행한 후에 실행할 메소드
	@AfterClass // 이 테스트 클래스가 소멸되기 전에 먼저 실행
	public void after() {
		dateUtil2 = null;
		System.gc();
	}
	
	
	@Test
	public void testLastDay() {
		//DateUtil2 dateUtil2 = new DateUtil2();
		assertEquals(dateUtil2.getLatDay(2000, 1), 31);
		assertEquals(dateUtil2.getLatDay(2001, 2), 28);
		assertEquals(dateUtil2.getLatDay(2000, 8), 31);
		assertEquals(dateUtil2.getLatDay(2004, 2), 29);
		assertNotEquals(dateUtil2.getLatDay(2004, 2), 28);
	}
	
	
	//@Ignore
	@Test
	public void testLeapYear() {
		//DateUtil2 dateUtil2 = new DateUtil2();
		assertTrue(dateUtil2.isLeapYear(2000));
		assertTrue(dateUtil2.isLeapYear(2004));
		assertFalse(dateUtil2.isLeapYear(2002));
		assertTrue(dateUtil2.isLeapYear(2008));
	}
	

}
