package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public  boolean after(Object when)
// public  boolean before(Object when)
public class Ex16_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar1 = Calendar.getInstance(locale);
		Calendar calendar2 = Calendar.getInstance(locale);
		calendar2.roll(Calendar.DATE, -5);

		System.out.println(sdf.format(calendar1.getTime()));
		System.out.println(sdf.format(calendar2.getTime()));
		
		if(calendar2.after(calendar1)) System.out.println("오늘보다 이후입니다.");
		if(calendar2.before(calendar1)) System.out.println("오늘보다 이전입니다.");

		calendar2.roll(Calendar.DATE, 5);
		System.out.println(sdf.format(calendar1.getTime()));
		System.out.println(sdf.format(calendar2.getTime()));
		
		if(calendar2.after(calendar1)) System.out.println("오늘보다 이후입니다.");
		if(calendar2.before(calendar1)) System.out.println("오늘보다 이전입니다.");

		calendar2.roll(Calendar.DATE, 1);
		System.out.println(sdf.format(calendar1.getTime()));
		System.out.println(sdf.format(calendar2.getTime()));
		
		if(calendar2.after(calendar1)) System.out.println("오늘보다 이후입니다.");
		if(calendar2.before(calendar1)) System.out.println("오늘보다 이전입니다.");
	}
}