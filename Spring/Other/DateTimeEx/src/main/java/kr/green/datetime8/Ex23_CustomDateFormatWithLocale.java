package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Locale;

// Custom Date Format with Locale
// static DateTimeFormatter ofPattern(String pattern)
// static DateTimeFormatter ofPattern(String pattern, Locale   locale)
public class Ex23_CustomDateFormatWithLocale {
	public static void main(String[] args) {
		LocalTime lt = LocalTime.of(16, 30, 5, 78899);
		Locale locale = Locale.getDefault();
		format(lt, "HH:mm:ss", locale);
		format(lt, "KK:mm:ss a", locale);
		format(lt, "[MM-dd-yyyy][' at' HH:mm:ss]", locale);
		System.out.println();

		ZoneId usCentral = ZoneId.of("America/Chicago");
		ZonedDateTime zdt = ZonedDateTime.of(LocalDate.now(), lt, usCentral);
		format(zdt, "MMM/dd/yyyy EEEE HH:mm:ssXXX a", locale);
		format(zdt, "MM/dd/yyyy VV", locale);
		format(zdt, "[MM-dd-yyyy][' at' HH:mm:ss]", locale);
		System.out.println();

		usCentral = ZoneId.of("Asia/Seoul");
		locale = Locale.GERMAN;
		zdt = ZonedDateTime.of(LocalDate.now(), lt, usCentral);
		format(zdt, "MMM/dd/yyyy EEEE HH:mm:ssXXX a", locale);
		format(zdt, "MM/dd/yyyy VV", locale);
		format(zdt, "[MM-dd-yyyy][' at' HH:mm:ss]", locale);
		System.out.println();

		// Custom Date Format with Optional
		String pattern = "MM/dd/yyyy[ 'at' HH:mm:ss]";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

		LocalDate ld = LocalDate.of(2014, Month.JUNE, 30);
		lt = LocalTime.of(17, 30, 12);
		LocalDateTime ldt = LocalDateTime.of(ld, lt);

		String str1 = fmt.format(ld);
		System.out.println(str1);
		String str2 = fmt.format(ldt);
		System.out.println(str2);
		System.out.println();

		// Java DateTimeFormatterBuilder
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendLiteral("New Year in ")
				.appendValue(ChronoField.YEAR).appendLiteral(" is  on  ")
				.appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE).toFormatter();
		String str = ld.format(formatter);
		System.out.println("formatter : " + formatter);
		System.out.println(str);
		
		pattern = "'New Year in'  yyyy  'is on' EEEE";
		formatter = DateTimeFormatter.ofPattern(pattern);
		str = ld.format(formatter);
		System.out.println("formatter : " + formatter);
		System.out.println(str);
	}

	public static void format(Temporal co, String pattern, Locale locale) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern, locale);
		String str = fmt.format(co);
		System.out.println(pattern + ": " + str);
	}
}
