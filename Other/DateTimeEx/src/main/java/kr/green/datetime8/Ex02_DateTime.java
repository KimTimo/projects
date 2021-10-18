package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

// of() Methods
public class Ex02_DateTime {
	public static void main(String[] args) {
		LocalDate localDate1 = LocalDate.of(2000, 2, 22);// 년도, 월, 일
		System.out.println(localDate1);

		//  epoch의 사전적 의미는 "(중요한 사건, 변화들이 일어난) 시대"입니다.
		LocalDate localDate2 = LocalDate.ofEpochDay(365); // 1970년 1월 1일 이후 일
		System.out.println(localDate2);
		
		LocalDate localDate3 = LocalDate.ofYearDay(2000, 78); // 년도, 일
		System.out.println(localDate3);
		
		LocalTime localTime = LocalTime.of(1, 2, 3);
		System.out.println(localTime);

		LocalDateTime localDateTime = LocalDateTime.of(2000, Month.APRIL, 5, 1, 2, 3);
		System.out.println(localDateTime);

		ZonedDateTime dateTimeWithZone = ZonedDateTime.of(2000, 1, 2, 3, 4, 5, 6, ZoneOffset.UTC);
		System.out.println(dateTimeWithZone);
	}
}
