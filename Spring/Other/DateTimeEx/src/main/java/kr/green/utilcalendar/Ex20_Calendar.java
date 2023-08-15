package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public int getFirstDayOfWeek()
public class Ex20_Calendar {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(sdf.format(calendar.getTime()));

		System.out.println("First day is : " + calendar.getFirstDayOfWeek());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale));

		locale = Locale.FRANCE;
		calendar = Calendar.getInstance(locale);
		System.out.println("First day is : " + calendar.getFirstDayOfWeek());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.KOREA));
	}
}