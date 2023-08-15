package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public final void clear()
// public final void clear(int field)
public class Ex17_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar.clear(Calendar.MONTH);
		System.out.println(sdf.format(calendar.getTime()));

		calendar.clear();
		System.out.println(sdf.format(calendar.getTime()));
	}
}