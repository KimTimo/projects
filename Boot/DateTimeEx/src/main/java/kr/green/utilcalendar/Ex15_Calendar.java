package kr.green.utilcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// public abstract void roll(int field, boolean up)
// public void roll(int field, int amount)
public class Ex15_Calendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd(EEEE)");
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);
		System.out.println("오늘 : " + sdf.format(calendar.getTime()));

		calendar.roll(Calendar.MONTH, true);
		System.out.println("1개월 후 : " + sdf.format(calendar.getTime()));
		calendar.roll(Calendar.MONTH, false);
		calendar.roll(Calendar.MONTH, false);
		System.out.println("1개월 전 : " + sdf.format(calendar.getTime()));
		calendar.roll(Calendar.MONTH, 2);
		System.out.println("1개월 후 : " + sdf.format(calendar.getTime()));
		calendar.roll(Calendar.MONTH, -6);
		System.out.println("6개월 전 : " + sdf.format(calendar.getTime()));
		

		
	}
}