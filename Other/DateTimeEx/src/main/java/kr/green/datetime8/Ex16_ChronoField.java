package kr.green.datetime8;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// ChronoField
public class Ex16_ChronoField {
	public static void main(String[] args) {
		LocalDateTime  now = LocalDateTime.now(); 
	    System.out.println(now.get(ChronoField.YEAR)); 
	    System.out.println(now.get(ChronoField.MONTH_OF_YEAR)); 
	    System.out.println(now.get(ChronoField.DAY_OF_MONTH)); 
	    System.out.println(now.get(ChronoField.HOUR_OF_DAY));
	    System.out.println(now.get(ChronoField.HOUR_OF_AMPM)); 
	    System.out.println(now.get(ChronoField.AMPM_OF_DAY));
	    System.out.println();
	    
	    System.out.println(now.isSupported(ChronoField.YEAR)); 
	    System.out.println(now.isSupported(ChronoField.HOUR_OF_DAY));
	    System.out.println();
	    System.out.println(ChronoField.YEAR.isSupportedBy(now)); 
	    System.out.println(ChronoField.HOUR_OF_DAY.isSupportedBy(now));
	    System.out.println();
	    
	    LocalDateTime localDateTime = now.minus(10, ChronoUnit.DAYS);
	    System.out.println(now);
	    System.out.println(localDateTime);
	    System.out.println();
	}
}
