package kr.green.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;

// Dates and Times Parsing
// 문자열에서 날짜 시간 개체를 만듬
public class Ex26_DatesAndTimesParsing2 {
	public static void main(String[] args) {
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM- dd['T'HH:mm:ss[Z]]");
		parseStr(parser, "2014-06-31");
		parseStr(parser, "2014-06-31T15:31:12");
		parseStr(parser, "2014-06-31T15:31:12-0500");
		parseStr(parser, "2014-06-31Hello");
		System.out.println();
		
		parser = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
		parseStr(parser, "2014-06-31");
		parseStr(parser, "2014-06-31T15:31:12");
		parseStr(parser, "2014-06-31T15:31:12-0500");
		parseStr(parser, "2014-06-31Hello");
		System.out.println();
		
		parser = DateTimeFormatter.ofPattern("yyyy-MM-dd'Hello'");
		parseStr(parser, "2014-06-31Hello");
		System.out.println();
	}

	public static void parseStr(DateTimeFormatter formatter, String text) {
		try {
			TemporalAccessor ta = formatter.parseBest(text, OffsetDateTime::from, LocalDateTime::from, LocalDate::from);
			if (ta instanceof OffsetDateTime) {
				OffsetDateTime odt = OffsetDateTime.from(ta);
				System.out.println("OffsetDateTime: " + odt);
			} else if (ta instanceof LocalDateTime) {
				LocalDateTime ldt = LocalDateTime.from(ta);
				System.out.println("LocalDateTime: " + ldt);
			} else if (ta instanceof LocalDate) {
				LocalDate ld = LocalDate.from(ta);
				System.out.println("LocalDate: " + ld);
			} else {
				System.out.println("Parsing returned: " + ta);
			}
		} catch (DateTimeParseException e) {
			System.out.println(e.getMessage());
		}
	}
}
