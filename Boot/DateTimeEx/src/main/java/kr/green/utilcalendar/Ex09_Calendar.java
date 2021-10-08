package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public static final int java.util.Calendar.JANUARY : 0
// public static final int java.util.Calendar.FEBRUARY
// public static final int java.util.Calendar.MARCH
// public static final int java.util.Calendar.APRIL
// public static final int java.util.Calendar.MAY
// public static final int java.util.Calendar.JUNE
// public static final int java.util.Calendar.JULY
// public static final int java.util.Calendar.AUGUST
// public static final int java.util.Calendar.SEPTEMBER
// public static final int java.util.Calendar.OCTOBER
// public static final int java.util.Calendar.NOVEMBER
// public static final int java.util.Calendar.DECEMBER : 11
public class Ex09_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM(MMM)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(Calendar.MONTH) + " : " + sdf.format(calendar.getTime()));

		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(Calendar.MONTH) + " : " + sdf.format(calendar.getTime()));
	    System.out.println();
	}
}