package kr.green.datetime8;

import java.lang.reflect.Method;
import java.time.LocalDate;

// minusXXX() Methods
public class Ex08_DateTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		Method[] methods = localDate.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("minus"))
				System.out.println(m.getName() + " : " + m);
		}
		System.out.println();

		LocalDate localDate1  = localDate.minusDays(5);   
	    System.out.println(localDate1);
	    localDate1  = localDate.minusMonths(3);
	    System.out.println(localDate1);
	    localDate1  = localDate.minusYears(3);        
	    System.out.println(localDate1);
	    localDate1  = localDate.minusWeeks(10);        
	    System.out.println(localDate1);
	    
	}
}
