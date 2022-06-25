package kr.green.utilcalendar;

import java.util.Calendar;
import java.util.TimeZone;

public class Ex03_Calendar {
	public static void main(String[] args) {
		String[] timeZones = TimeZone.getAvailableIDs();
		Calendar calendar = Calendar.getInstance();
		for(String tz : timeZones) {
			calendar.setTimeZone(TimeZone.getTimeZone(tz));
			System.out.print(calendar.getTimeZone().getDisplayName() + " : ");
			viewCalendar(calendar);
		}
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
	}
}
