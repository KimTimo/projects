package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public int getMaximum(int field)
// public int getMinimum(int field)
public class Ex19_Calendar {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(sdf.format(calendar.getTime()));

		int maxYear = calendar.getMaximum(Calendar.YEAR);
		int minYear = calendar.getMinimum(Calendar.YEAR);
		System.out.println("year:" + minYear + " ~ " + maxYear);
		
		int maxMonth = calendar.getMaximum(Calendar.MONTH);
		int minMonth = calendar.getMinimum(Calendar.MONTH);
		System.out.println("month:" + minMonth + " ~ " + maxMonth);

		int maxDate = calendar.getMaximum(Calendar.DATE);
		int minDate = calendar.getMinimum(calendar.DATE);
		System.out.println("date:" + minDate + " ~ " + maxDate);
		
		calendar.set(Calendar.MONTH, 1);
		System.out.println(sdf.format(calendar.getTime()));

		maxDate = calendar.getMaximum(Calendar.DATE);
		minDate = calendar.getMinimum(calendar.DATE);
		System.out.println("date:" + minDate + " ~ " + maxDate);

		calendar.set(Calendar.YEAR, 2000);
		System.out.println(sdf.format(calendar.getTime()));
		
		maxDate = calendar.getMaximum(Calendar.DATE);
		minDate = calendar.getMinimum(calendar.DATE);
		System.out.println("date:" + minDate + " ~ " + maxDate);
	}
}