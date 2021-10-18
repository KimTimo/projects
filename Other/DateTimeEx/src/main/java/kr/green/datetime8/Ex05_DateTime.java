package kr.green.datetime8;

import java.lang.reflect.Method;
import java.time.LocalDate;

// toXXX() Methods
public class Ex05_DateTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		Method[] methods = localDate.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("to"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();

		long toEpochDay = localDate.toEpochDay();
		System.out.println(toEpochDay);
		System.out.println();
		
		localDate = LocalDate.ofEpochDay(1);
		System.out.println(localDate);
		toEpochDay = localDate.toEpochDay();
		System.out.println(toEpochDay);
		
	}
}
