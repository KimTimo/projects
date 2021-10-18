package kr.green.utilcalendar;

import java.util.Calendar;
import java.util.Locale;

//get : public int java.util.Calendar.get(int)
public class Ex12_Calendar {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		Calendar calendar = Calendar.getInstance(locale);

		System.out.println("년 : " + calendar.get(Calendar.YEAR));
		System.out.println("월 : " + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + calendar.get(Calendar.DATE));
		System.out.println("요일 : " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("시 : " + calendar.get(Calendar.HOUR));
		System.out.println("분 : " + calendar.get(Calendar.MINUTE));
		System.out.println("초 : " + calendar.get(Calendar.SECOND));
		System.out.println("1/1000초 : " + calendar.get(Calendar.MILLISECOND));
		System.out.println();

		System.out.println("월의 일 : " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("년의 일: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("시 : " + calendar.get(Calendar.HOUR_OF_DAY));
		String displayName = calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, locale);
		System.out.println("오전/오후 : " + calendar.get(Calendar.AM_PM) + ", " + displayName);
		System.out.println(displayName);
		System.out.println();
		
		calendar.set(Calendar.HOUR_OF_DAY,18);
		displayName = calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, locale);
		System.out.println("오전/오후 : " + calendar.get(Calendar.AM_PM) + ", " + displayName);
		System.out.println("12 시 : " + calendar.get(Calendar.HOUR));
		System.out.println("24 시 : " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println();
		
		
	}
}