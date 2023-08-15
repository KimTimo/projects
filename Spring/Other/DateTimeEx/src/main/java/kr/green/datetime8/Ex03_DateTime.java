package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;

// from() Methods
// with() Methods
public class Ex03_DateTime {
	public static void main(String[] args) {
		LocalDateTime  localDateTime = LocalDateTime.of(2015, 6,  21,  13, 40);
	    System.out.println(localDateTime);
	    
	    LocalDate localDate1  = LocalDate.from(localDateTime);
	    System.out.println(localDate1);
	    
	    LocalDate localDate2  = localDate1.withYear(2020);
	    System.out.println(localDate2);
	    
	    LocalDate localDate3  = localDate1.withYear(2020).withMonth(7);
	    System.out.println(localDate3);
	}
}
