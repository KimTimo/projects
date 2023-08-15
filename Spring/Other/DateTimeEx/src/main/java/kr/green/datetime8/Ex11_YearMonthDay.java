package kr.green.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

// Java Year Month Day
public class Ex11_YearMonthDay {
	public static void main(String[] args) {
		// Year
		Year y1 = Year.of(2020);
		System.out.println(y1);
		Year y2 = y1.minusYears(1);
		System.out.println(y2);
		Year y3 = y1.plusYears(1);
		System.out.println(y3);
		Year y4 = Year.now();
		System.out.println(y4);
		System.out.println(y1 + "년은 " + (y1.isLeap() ? "윤년" : "평년"));
		System.out.println(y2 + "년은 " + (y2.isLeap() ? "윤년" : "평년"));
		System.out.println();

		// YearMonth
		YearMonth ym = YearMonth.of(2020, Month.JUNE);
		System.out.println(ym);
		int monthLen = ym.lengthOfMonth(); // 월의 일수
		System.out.println(monthLen);
		int yearLen = ym.lengthOfYear(); // 년의 일수
		System.out.println(yearLen);
		System.out.println();

		// Month
		LocalDate localDate = LocalDate.of(2020, Month.AUGUST, 3);
		System.out.println(localDate);
		Month month1 = Month.from(localDate);
		System.out.println(month1);

		Month month2 = Month.of(2);
		System.out.println(month2);

		Month month3 = month2.plus(2);
		System.out.println(month3);

		Month month4 = localDate.getMonth();
		System.out.println(month4);

		int monthIntValue = month2.getValue();
		System.out.println(monthIntValue);
		System.out.println();

		// MonthDay
		MonthDay md1 = MonthDay.of(Month.DECEMBER, 25);
		MonthDay md2 = MonthDay.of(Month.FEBRUARY, 29);
		System.out.println(md1);
		System.out.println(md2);

		if (md2.isValidYear(2021)) {
			System.out.println(md2);
		}
		System.out.println(md1.getDayOfMonth());
		System.out.println();
		
		// DayOfWeek
		System.out.println(localDate);
	    DayOfWeek  dayOfWeek1 = DayOfWeek.from(localDate);
	    System.out.println(dayOfWeek1);
	    int intValue = dayOfWeek1.getValue();
	    System.out.println(intValue);
	    DayOfWeek  dayOfWeek2 = localDate.getDayOfWeek();
	    System.out.println(dayOfWeek2);
	    DayOfWeek  dayOfWeekFromInteger = DayOfWeek.of(7);
	    System.out.println(dayOfWeekFromInteger);
	    DayOfWeek  dayOfWeekAdded = dayOfWeekFromInteger.plus(1);
	    System.out.println(dayOfWeekAdded);
	    DayOfWeek  dayOfWeekSubtracted = dayOfWeekFromInteger.minus(2); 
	    System.out.println(dayOfWeekSubtracted);
	}
}
