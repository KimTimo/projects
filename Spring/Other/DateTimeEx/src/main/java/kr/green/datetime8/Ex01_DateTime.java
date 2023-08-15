package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

// now()메서드
public class Ex01_DateTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		ZonedDateTime dateTimeWithZone  = ZonedDateTime.now();
	    System.out.println(dateTimeWithZone);
	}
}
