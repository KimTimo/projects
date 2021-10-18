package kr.green.datetime8;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

// atXXX() Methods
public class Ex06_DateTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		Method[] methods = localDate.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("at"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();

		LocalDateTime localTime1 = localDate.atStartOfDay();
		System.out.println(localTime1);

		LocalDateTime localTime2 = localDate.atTime(16, 21);
		System.out.println(localTime2);
		
		LocalDate localDate2  = Year.of(2020).atMonth(6).atDay(21);
	    System.out.println(localDate2);
	}
}
