package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public int getActualMaximum(int field)
// public int getActualMinimum(int field)
public class Ex18_Calendar {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(sdf.format(calendar.getTime()));

		int maxYear = calendar.getActualMaximum(Calendar.YEAR);
		int minYear = calendar.getActualMinimum(Calendar.YEAR);
		System.out.println("year:" + maxYear + " ~ " + minYear);
		
		int maxMonth = calendar.getActualMaximum(Calendar.MONTH);
		int minMonth = calendar.getActualMinimum(Calendar.MONTH);
		System.out.println("month:" + minMonth + " ~ " + maxMonth);

		int maxDate = calendar.getActualMaximum(Calendar.DATE);
		int minDate = calendar.getActualMinimum(calendar.DATE);
		System.out.println("date:" + minDate + " ~ " + maxDate);
		
		calendar.set(Calendar.MONTH, 1);
		System.out.println(sdf.format(calendar.getTime()));

		maxDate = calendar.getActualMaximum(Calendar.DATE);
		minDate = calendar.getActualMinimum(calendar.DATE);
		System.out.println("date:" + minDate + " ~ " + maxDate);

		calendar.set(Calendar.YEAR, 2000);
		System.out.println(sdf.format(calendar.getTime()));
		
		maxDate = calendar.getActualMaximum(Calendar.DATE);
		minDate = calendar.getActualMinimum(calendar.DATE);
		System.out.println("date:" + minDate + " ~ " + maxDate);
		
	}
}