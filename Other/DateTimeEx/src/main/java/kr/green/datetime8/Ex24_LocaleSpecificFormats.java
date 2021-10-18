package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

// Locale Specific Formats
// DateTimeFormatter ofLocalizedDate(FormatStyle  dateStyle)
// DateTimeFormatter ofLocalizedDateTime(FormatStyle dateTimeStyle)
// DateTimeFormatter ofLocalizedDateTime(FormatStyle dateStyle, FormatStyle timeStyle)
// DateTimeFormatter ofLocalizedTime(FormatStyle timeStyle)
public class Ex24_LocaleSpecificFormats {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.of(ld, lt);

		DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println("Formatter  Default Locale: " + fmt.getLocale());
		System.out.println("Short  Date: " + fmt.format(ld));

		fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println("Medium Date: " + fmt.format(ld));

		fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println("Long  Date: " + fmt.format(ld));

		fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println("Full  Date: " + fmt.format(ld));

		fmt = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println("Short Time:  " + fmt.format(lt));

		fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println("Short  Datetime: " + fmt.format(ldt));

		fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println("Medium Datetime: " + fmt.format(ldt));
		System.out.println();
		
		// Use German locale to format the datetime in medius style
		fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
		System.out.println(fmt.format(ldt));

		// Use Indian(English) locale to format datetime in short style
		fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("en", "IN"));
		System.out.println(fmt.format(ldt));

		// Use Indian(English) locale to format datetime in medium style
		fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("en", "IN"));
		System.out.println(fmt.format(ldt));

	}
}
