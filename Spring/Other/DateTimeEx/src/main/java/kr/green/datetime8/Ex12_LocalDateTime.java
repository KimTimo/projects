package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

// Java Local Date Time
public class Ex12_LocalDateTime {
	public static void main(String[] args) {
		// LocalDate
		LocalDate localDate1 = LocalDate.now();
		System.out.println(localDate1);
		LocalDate localDate2 = LocalDate.of(2014, Month.JUNE, 21);
		System.out.println(localDate2);
		LocalDate localDate3 = LocalDate.ofEpochDay(365);
		System.out.println(localDate3);
		System.out.println();

		MonthDay dec25 = MonthDay.of(Month.DECEMBER, 25);
		Year year = Year.now();

		for (int i = -5; i < 5; i++) {
			LocalDate ld = year.plusYears(i).atMonthDay(dec25);
			String weekDay = ld.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
			System.out.println(ld + " : " + weekDay);
		}
		System.out.println();
		
		// LocalTime
	    LocalTime  localTime1 = LocalTime.now();
	    System.out.println(localTime1);
	    LocalTime  localTime2 = LocalTime.of(9, 30);
	    System.out.println(localTime2);
	    LocalTime  localTime3 = LocalTime.of(9, 30, 50);
	    System.out.println(localTime3);
	    LocalTime  localTime4 = LocalTime.of(9, 30, 50, 5678);
	    System.out.println(localTime4);
	    System.out.println();
	    
	    // LocalDateTime
	    LocalDateTime  localDateTime1 = LocalDateTime.now();
	    System.out.println(localDateTime1);
	    
	    LocalDateTime  localDateTime2 = LocalDateTime.of(2021, Month.JUNE, 21, 16, 12, 34);
	    System.out.println(localDateTime2);
	    LocalDate localDate  = LocalDate.of(2021, 5, 10); 
	    LocalTime  localTime= LocalTime.of(16, 18,   41);
	    LocalDateTime  localDateTime3 = LocalDateTime.of(localDate, localTime);
	    System.out.println(localDateTime3);	    
	}
}
