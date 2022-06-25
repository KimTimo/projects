package kr.green.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

// Date Time Query
public class Ex18_DateTimeQuery {
	public static void main(String[] args) {
		TemporalQuery<TemporalUnit> precisionQuery = TemporalQueries.precision();
		TemporalQuery<LocalDate> localDateQuery = TemporalQueries.localDate();
		System.out.println(precisionQuery);
		System.out.println(localDateQuery);
		System.out.println();

		// Query a LocalDate
		LocalDate ld = LocalDate.now();
		TemporalUnit precision = ld.query(precisionQuery);
		LocalDate queryDate = ld.query(localDateQuery);
		System.out.println("Precision of  LocalDate: " + precision);
		System.out.println("LocalDate of  LocalDate: " + queryDate);
		System.out.println();

		// Query a LocalTime
		LocalTime lt = LocalTime.now();
		precision = lt.query(precisionQuery);
		queryDate = lt.query(localDateQuery);
		System.out.println("Precision of  LocalTime: " + precision);
		System.out.println("LocalDate of  LocalTime: " + queryDate);
		System.out.println();

		// Query a ZonedDateTime
		ZonedDateTime zdt = ZonedDateTime.now();
		precision = zdt.query(precisionQuery);
		queryDate = zdt.query(localDateQuery);
		System.out.println("Precision of  ZonedDateTime:  " + precision);
		System.out.println("LocalDate of  ZonedDateTime:  " + queryDate);
		System.out.println();

		// Custom Query
		Boolean is = ld.query(new MondayQuery());
		System.out.println(is);

		is = ld.query(Ex18_DateTimeQuery::queryFrom);
		System.out.println(is);

	}

	static class MondayQuery implements TemporalQuery<Boolean> {
		@Override
		public Boolean queryFrom(TemporalAccessor temporal) {
			if (temporal.isSupported(ChronoField.DAY_OF_MONTH) && temporal.isSupported(ChronoField.DAY_OF_WEEK)) {
				int dayOfMonth = temporal.get(ChronoField.DAY_OF_MONTH);
				int weekDay = temporal.get(ChronoField.DAY_OF_WEEK);
				DayOfWeek dayOfWeek = DayOfWeek.of(weekDay);
				if (dayOfMonth == 1 && dayOfWeek == DayOfWeek.MONDAY) {
					return Boolean.TRUE;
				}
			}
			return Boolean.FALSE;
		}
	}

	public static Boolean queryFrom(TemporalAccessor temporal) {
		if (temporal.isSupported(ChronoField.DAY_OF_MONTH) && temporal.isSupported(ChronoField.DAY_OF_WEEK)) {
			int dayOfMonth = temporal.get(ChronoField.DAY_OF_MONTH);
			int weekDay = temporal.get(ChronoField.DAY_OF_WEEK);
			DayOfWeek dayOfWeek = DayOfWeek.of(weekDay);
			if (dayOfMonth == 1 && dayOfWeek == DayOfWeek.MONDAY) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}
