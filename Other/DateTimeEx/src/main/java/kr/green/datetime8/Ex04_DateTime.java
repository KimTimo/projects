package kr.green.datetime8;

import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

// getXXX() Methods
public class Ex04_DateTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		Method[] methods = localDate.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("get"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();

		int year = localDate.getYear();
		System.out.println(year);
		
		Month month = localDate.getMonth();
		System.out.println(month);

		int monthValue = localDate.getMonthValue();
		System.out.println(monthValue);
		
		int day = localDate.getDayOfMonth();
		System.out.println(day);

		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		System.out.println(dayOfWeek);
		
		int dayOfYear = localDate.getDayOfYear();
		System.out.println(dayOfYear);
	}
}
