package kr.green.datetime8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

// Java ZonedDatetime
public class Ex14_ZonedDatetime {
	public static void main(String[] args) {
		ZoneId usChicago = ZoneId.of("America/Chicago");
	    LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MAY, 21, 9, 30);
	    System.out.println(localDateTime);
	    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, usChicago);
	    System.out.println(zonedDateTime);
	    System.out.println();
	    
	    LocalDateTime ldt1 = LocalDateTime.of(2014, Month.MARCH, 9, 2, 30);
	    ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, usChicago);
	    System.out.println(ldt1);
	    System.out.println(zdt1);
	    System.out.println();

	    LocalDateTime ldt2 = LocalDateTime.of(2013, Month.NOVEMBER, 3, 1, 30);
	    ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, usChicago);
	    System.out.println(ldt2);
	    System.out.println(zdt2);

	    System.out.println(zdt2.withEarlierOffsetAtOverlap());
	    System.out.println(zdt2.withLaterOffsetAtOverlap());
	    System.out.println();
	    
	    ZoneOffset offset5  = ZoneOffset.of("-05:00"); 
	    ZoneOffset offset6  = ZoneOffset.of("-06:00"); 
	    ZoneOffset offset7  = ZoneOffset.of("-07:00");

	    LocalDateTime  ldt3 = LocalDateTime.of(2012, Month.NOVEMBER,  4, 1, 30); 
	    ZonedDateTime zdt5   = ZonedDateTime.ofLocal(ldt3,  usChicago, offset5); 
	    ZonedDateTime zdt6   = ZonedDateTime.ofLocal(ldt3,  usChicago, offset6); 
	    ZonedDateTime zdt7   = ZonedDateTime.ofLocal(ldt3,  usChicago, offset7); 

	    System.out.println("With offset  "  + offset5 + ": "  + zdt5); 
	    System.out.println("With offset  "  + offset6 + ": "  + zdt6); 
	    System.out.println("With offset  "  + offset7 + ": "  + zdt7);
	    System.out.println();
	    
	    ZonedDateTime zdt8   = ZonedDateTime.now(); 
	    System.out.println("Current zoned  datetime:" + zdt8);
	    LocalDateTime  ldt4 = LocalDateTime.of(2020, Month.MARCH,  11,   7, 30);
	    ZonedDateTime zdt9   = ZonedDateTime.of(ldt4, usChicago); 
	    System.out.println(zdt9);
	    System.out.println();
	    
	    // ZonedDateTime and Duration
	    LocalDateTime ldt = LocalDateTime.of(2012, Month.MARCH, 10, 7, 30);
	    ZonedDateTime zdt10 = ZonedDateTime.of(ldt, usChicago);
	    Duration d1 = Duration.ofHours(24);
	    ZonedDateTime zdt11 = zdt10.plus(d1);
	    System.out.println(ldt);
	    System.out.println(zdt10);
	    System.out.println(d1);
	    System.out.println(zdt11);
	    System.out.println();
	    
	    // ZonedDateTime and Period
	    ldt = LocalDateTime.of(2012, Month.MARCH,  10,   7, 30); 
	    ZonedDateTime zdt13   = ZonedDateTime.of(ldt, usChicago);
	    Period p1  = Period.ofDays(1); 

	    ZonedDateTime zdt14   = zdt13.plus(p1); 
	    System.out.println(ldt);
	    System.out.println(zdt13);
	    System.out.println(p1);
	    System.out.println(zdt14);
	}
}
