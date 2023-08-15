package kr.green.utilcalendar;

import java.util.Calendar;
import java.util.Locale;

// public static final int AM_PM = 9;
// public static final int AM = 0;
// public static final int PM = 1;
public class Ex07_Calendar {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println(calendar.getTime());

		calendar.set(Calendar.AM_PM, Calendar.AM );
		System.out.println(calendar.getTime());
	    
		calendar.set(Calendar.AM_PM, Calendar.PM );
		System.out.println(calendar.getTime());
		
	    System.out.println();
	}
}
