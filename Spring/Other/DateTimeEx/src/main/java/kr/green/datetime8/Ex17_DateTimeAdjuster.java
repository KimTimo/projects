package kr.green.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

// Date Time Adjuster
/*
next(DayOfWeek dayOfWeek)
nextOrSame(DayOfWeek dayOfWeek)
previous(DayOfWeek dayOfWeek)
previousOrSame(DayOfWeek dayOfWeek)
firstInMonth(DayOfWeek dayOfWeek)
lastInMonth(DayOfWeek dayOfWeek)
dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek)
firstDayOfMonth()
lastDayOfMonth()
firstDayOfYear()
lastDayOfYear()
firstDayOfNextMonth()
firstDayOfNextYear()
ofDateAdjuster(UnaryOperator<LocalDate> dateBasedAdjuster)
 */
public class Ex17_DateTimeAdjuster {
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2021, Month.OCTOBER, 1);
		LocalDate ld2 = ld1.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		LocalDate ld3 = ld1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ld1);
		System.out.println(ld2);
		System.out.println(ld3);
		System.out.println();

		// TemporalAdjusters
		ld2 = ld1.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));
		System.out.println(ld2);
		ld3 = ld1.with(TemporalAdjusters.dayOfWeekInMonth(5, DayOfWeek.SUNDAY));
		System.out.println(ld3);
		System.out.println();

		// Custom Adjusters
		TemporalAdjuster adjuster = TemporalAdjusters.ofDateAdjuster((LocalDate date) -> date.plusMonths(3).plusDays(2));

		LocalDate today = LocalDate.now();
		LocalDate dayAfter3Mon2Day = today.with(adjuster);
		System.out.println("Today: " + today);
		System.out.println("After 3  months  and  2  days: " + dayAfter3Mon2Day);
	}
}
