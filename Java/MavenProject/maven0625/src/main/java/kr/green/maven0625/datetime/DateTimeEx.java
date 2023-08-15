package kr.green.maven0625.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeEx {

	public static void main(String[] args) {
		// JDK 1.8에 추가된 향상된 날짜와 시간 클래스들. 불변객체이다.
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getDayOfYear());
		
		System.out.println();
		
		LocalDate date2 = LocalDate.of(2000, 5, 5);
		System.out.println(date2);
		System.out.println(date2.getYear());
		System.out.println(date2.getMonth());
		System.out.println(date2.getDayOfMonth());
		System.out.println(date2.getDayOfWeek());
		System.out.println(date2.getDayOfYear());
		
		System.out.println();
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
	}

}
