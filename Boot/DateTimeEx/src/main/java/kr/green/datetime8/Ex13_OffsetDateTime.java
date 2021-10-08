package kr.green.datetime8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

// Java Offset Date Time
public class Ex13_OffsetDateTime {
	public static void main(String[] args) {
		// OffsetTime
	    OffsetTime offsetTime1 = OffsetTime.now();
	    System.out.println(offsetTime1);

	    ZoneOffset zoneOffset = ZoneOffset.ofHoursMinutes(1, 30);
	    System.out.println(zoneOffset);

	    OffsetTime offsetTime2 = OffsetTime.of(16, 40, 28, 0, zoneOffset);
	    System.out.println(offsetTime2);
	    System.out.println();
	    
	    LocalTime localTime1 = offsetTime1.toLocalTime();
	    LocalTime localTime2 = offsetTime2.toLocalTime();
	    System.out.println(localTime1);
	    System.out.println(localTime2);
	    System.out.println();
	    
	    // OffsetDateTime
	    OffsetDateTime odt1 = OffsetDateTime.now();
	    OffsetDateTime odt2 = OffsetDateTime.of(2012, 5, 11, 18, 10, 30, 0, ZoneOffset.UTC);
	    System.out.println(odt1);
	    System.out.println(odt2);
	    
	    LocalDate localDate = odt1.toLocalDate();
	    LocalTime localTime = odt1.toLocalTime();
	    System.out.println(localDate);
	    System.out.println(localTime);	  
	    System.out.println();
	    
	    Instant i1 = Instant.now();
	    System.out.println(i1);
	    ZoneId usChicago = ZoneId.of("America/Chicago");
	    OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(i1, usChicago);
	    System.out.println(offsetDateTime);
	}
}
