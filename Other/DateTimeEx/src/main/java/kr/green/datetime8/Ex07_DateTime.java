package kr.green.datetime8;

import java.lang.reflect.Method;
import java.time.LocalDate;

// plusXXX() Methods
public class Ex07_DateTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		Method[] methods = localDate.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("plus"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();

		LocalDate localDate1  = localDate.plusDays(5);   
	    System.out.println(localDate1);
	    localDate1  = localDate.plusMonths(3);
	    System.out.println(localDate1);
	    localDate1  = localDate.plusWeeks(3);        
	    System.out.println(localDate1);
	    localDate1  = localDate.plusYears(10);        
	    System.out.println(localDate1);
	    
	}
}
