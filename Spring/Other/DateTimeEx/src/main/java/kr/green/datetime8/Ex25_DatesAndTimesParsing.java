package kr.green.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

// Dates and Times Parsing
// 문자열에서 날짜 시간 개체를 만듬
public class Ex25_DatesAndTimesParsing {
	public static void main(String[] args) {
		// parse() method from datetime class
		LocalDate ld1 = LocalDate.parse("2014-06-10");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate ld2 = LocalDate.parse("06/10/2014", formatter);

		TemporalAccessor ta = formatter.parse("06/10/2014");
	    LocalDate ld3 = LocalDate.from(ta);
	    System.out.println(ld3);
	    
	    LocalDate ld4 = formatter.parse("06/10/2014", LocalDate::from);
	    
		System.out.println("ld1: " + ld1);
		System.out.println("ld2: " + ld2);
		System.out.println("ld3: " + ld3);
		System.out.println("ld4: " + ld4);
		
	}
}
