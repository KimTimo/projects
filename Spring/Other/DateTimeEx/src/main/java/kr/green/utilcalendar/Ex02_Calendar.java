package kr.green.utilcalendar;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/*
Java Calendar.getInstance()
Java Calendar.getInstance(Locale aLocale)
Java Calendar.getInstance(TimeZone zone)
Java Calendar.getInstance(TimeZone zone, Locale aLocale)
 */
public class Ex02_Calendar {
	public static void main(String[] args) {
		// 추상클래스이므로 new 명령어로 객체를 생설할 수 없다.
		// Calendar calendar = new Calendar();
		Calendar calendar1 = Calendar.getInstance();
		viewCalendar(calendar1);
		
		Locale locale = Locale.getDefault();
		System.out.println("Locale : " + locale);
		Calendar calendar2 = Calendar.getInstance(locale);
		viewCalendar(calendar2);
		
		TimeZone timeZone = TimeZone.getDefault();
		System.out.println("TimeZone : " + timeZone);
		Calendar calendar3 = Calendar.getInstance(timeZone);
		viewCalendar(calendar3);
		System.out.println();
		
		Calendar calendar4 = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.CANADA);
		System.out.println("TimeZone : " + TimeZone.getTimeZone("GMT"));
		System.out.println("Locale : " + Locale.CANADA);
		viewCalendar(calendar4);
		
	}

	private static void viewCalendar(Calendar calendar) {
		System.out.print(calendar.get(Calendar.YEAR));
		System.out.print("-" + (calendar.get(Calendar.MONTH)+1));
		System.out.print("-" + calendar.get(Calendar.DATE));
		System.out.print("(" + calendar.get(Calendar.DAY_OF_WEEK) + ") ");
		System.out.print(calendar.get(Calendar.HOUR));
		System.out.print(":" + calendar.get(Calendar.MINUTE));
		System.out.print(":" + calendar.get(Calendar.SECOND));
		System.out.println("." + calendar.get(Calendar.MILLISECOND));
		System.out.println();
	}
}
