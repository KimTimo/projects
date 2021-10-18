package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public abstract void add(int field, int amount)
public class Ex14_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE) hh:mm:ss.S");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println("오늘 : " + sdf.format(calendar.getTime()));

		calendar.add(Calendar.DATE, 20);
		System.out.println("20일 후 : " + sdf.format(calendar.getTime()));

		calendar.add(Calendar.MONTH, -2);
		System.out.println("2개월 전 : " + sdf.format(calendar.getTime()));
		
		calendar.add(Calendar.YEAR, -5);
		System.out.println("5년 전 : " + sdf.format(calendar.getTime()));
	}
}