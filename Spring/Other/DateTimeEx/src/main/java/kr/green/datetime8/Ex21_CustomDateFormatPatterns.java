package kr.green.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

// Custom Date Format Patterns
public class Ex21_CustomDateFormatPatterns {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		format(ld, "MM/dd/yyyy");
		format(ld, "MMM   dd,   yyyy");
		format(ld, "MMMM   dd,   yyyy");
		format(ld, "EEEE, MMMM   dd,   yyyy");
		format(ld, "'Month' q  'in' QQQ");
		format(ld, "yyyy'년' MM'월' dd'일('EEEE')'");
	}

	public static void format(Temporal co, String pattern) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
		String str = fmt.format(co);
		System.out.println(pattern + ": " + str);
	}
}
