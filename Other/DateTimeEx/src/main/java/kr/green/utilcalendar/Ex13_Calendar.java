package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public final void java.util.Calendar.set(int,int,int,int,int)
// public final void java.util.Calendar.set(int,int,int,int,int,int)
// public final void java.util.Calendar.set(int,int,int)
// public void java.util.Calendar.set(int,int)
public class Ex13_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE) hh:mm:ss.S");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar.set(2000, 1, 1);
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar.set(2002, 4, 3, 11, 23);
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar.set(2002, 0, 1, 2, 3, 4);
		System.out.println(sdf.format(calendar.getTime()));

		calendar.set(Calendar.DATE, 33);
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar.set(Calendar.MONTH, 13);
		System.out.println(sdf.format(calendar.getTime()));
	}
}