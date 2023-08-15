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

// Custom Time Format Patterns
public class Ex22_CustomTimeFormatPatterns {
	public static void main(String[] args) {
		LocalTime lt = LocalTime.now();
		format(lt, "HH:mm:ss");
		format(lt, "KK:mm:ss a");
		format(lt, "[MM-dd-yyyy][' at' HH:mm:ss]");

		ZoneId usCentral = ZoneId.of("America/Chicago");
		ZonedDateTime zdt = ZonedDateTime.of(LocalDate.now(), lt, usCentral);
		format(zdt, "MM/dd/yyyy HH:mm:ssXXX");
		format(zdt, "MM/dd/yyyy VV");
		format(zdt, "[MM-dd-yyyy][' at' HH:mm:ss]");
		System.out.println();
		
		String pattern = "[yyyy'년' MM'월' dd'일'] [HH'시' mm'분' ss'초']";
	    DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

	    LocalDate ld = LocalDate.of(2014, Month.JUNE, 30);
	    LocalTime lt2 = LocalTime.of(17, 30, 12);
	    LocalDateTime ldt = LocalDateTime.of(ld, lt2);

	    String str1 = fmt.format(ld);
	    System.out.println(str1);

	    String str2 = fmt.format(ldt);
	    System.out.println(str2);
	    System.out.println();
	    // DateTimeFormatterBuilder
	    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
	    	    .appendLiteral("New Year in ")
	    	    .appendValue(ChronoField.YEAR)
	    	    .appendLiteral(" is  on  ")
	    	    .appendText(ChronoField.DAY_OF_WEEK,TextStyle.FULL_STANDALONE)
	    	    .toFormatter(); 
	    	    ld  = LocalDate.of(2014, Month.JANUARY, 1); 
	    	    String str = ld.format(formatter); 
	    	    System.out.println(str);  
	}

	public static void format(Temporal co, String pattern) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern, Locale.KOREA);
		String str = fmt.format(co);
		System.out.println(pattern + ": " + str);
	}
}
