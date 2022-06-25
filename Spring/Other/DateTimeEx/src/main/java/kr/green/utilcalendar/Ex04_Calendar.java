package kr.green.utilcalendar;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Ex04_Calendar {
	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		Calendar calendar = null;
		double num = 123456789.123456;
		NumberFormat numberFormat = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		for(Locale locale : locales) {
			dateFormat = new SimpleDateFormat("MMM", locale);
			numberFormat = NumberFormat.getInstance(locale);
			calendar = Calendar.getInstance(locale);
			System.out.println(locale + "(" + locale.getDisplayCountry() + ")" + " : "+ numberFormat.format(num) + " : " + dateFormat.format(calendar.getTime()));
		}
	}
}
