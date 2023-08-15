package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public static final int java.util.Calendar.SUNDAY : 1
// public static final int java.util.Calendar.MONDAY : 2
// public static final int java.util.Calendar.TUESDAY : 3
// public static final int java.util.Calendar.WEDNESDAY : 4
// public static final int java.util.Calendar.THURSDAY : 5
// public static final int java.util.Calendar.FRIDAY : 6
// public static final int java.util.Calendar.SATURDAY : 7
public class Ex08_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("E(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK) + " : " + sdf.format(calendar.getTime()));

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK) + " : " + sdf.format(calendar.getTime()));
	    System.out.println();
	}
}