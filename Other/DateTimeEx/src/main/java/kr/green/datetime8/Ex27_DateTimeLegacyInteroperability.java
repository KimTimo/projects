package kr.green.datetime8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

// Date Time Legacy Interoperability
// 이전 API와 상호 변환
/*
Java 8 이전에는 Java 날짜와 시간이 java.util.Date, java.util.Calendar, 및 java.util.TimeZone클래스와 해당 하위 클래스(예: as java.util.GregorianCalendar.

기존 날짜 시간 API는 java.util패키지에 정의되고 새로운 Java 8 날짜 시간 API는 java.time패키지에 정의 됩니다.

java.util.Date
java.util.Calendar
java.util.GregorianCalendar
java.util.TimeZone
java.sql.Date
java.sql.Time
java.sql.Timestamp
java.nio.file.attribute.FileTime

JDK 8 날짜 시간 API는 java.util및 java.time개체 간에 변환할 여러 메서드를 정의했습니다 .

Calendar.toInstant()는 Calendar 객체를 Instant로 변환합니다.
java.util.Date toInstant()는 Date 객체를 Instant로 변환합니다.
java.util.Date from() 메소드는 Instant에서 Date 객체를 생성합니다.
GregorianCalendar.toZonedDateTime()은 GregorianCalendar 인스턴스를 ZonedDateTime으로 변환합니다.
GregorianCalendar.from(ZonedDateTime)은 ZonedDateTime 인스턴스의 기본 로케일을 사용하여 GregorianCalendar 객체를 생성합니다.
TimeZone.toZoneId()는 TimeZone 객체를 ZoneId로 변환합니다.
java.sql.Date toLocalDate()는 LocalDate로 변환합니다.
java.sql.Date valueOf()는 LocalDate에서 java.sql.Date를 생성합니다.
java.sql.Time toLocalTime()이 LocalTime으로 변환됩니다.
java.sql.Time valueOf()는 LocalTime에서 java.sql.Time을 생성합니다.
java.sql.Timestamp toInstant()는 Instant로 변환합니다.
java.sql.Timestamp valueOf()는 LocalDateTime에서 변환합니다.
java.nio.file.attribute.FileTime toInstant()는 Instant로 변환합니다.
java.nio.file.attribute.FileTime from()은 Instant에서 변환합니다.

 */
public class Ex27_DateTimeLegacyInteroperability {
	public static void main(String[] args) {
		// convert Date to Instant back and forth
		Date date1 = new Date();
		System.out.println("Date: " + date1);
		Instant instant = date1.toInstant();
		System.out.println("Instant: " + instant);
		Date date2 = Date.from(instant);
		System.out.println("Date: " + date2);
		
		// GregorianCalendar를 ZonedDateTime으로 변환할 수 있으며, 이는 새로운 Date-Time API에서 다른 클래스로 변환될 수 있습니다.
		GregorianCalendar gc = new GregorianCalendar(2014, 1, 11, 15, 45, 50);
	    LocalDate ld = gc.toZonedDateTime().toLocalDate();
	    System.out.println("Local  Date: " + ld);
	 
	    LocalTime lt = gc.toZonedDateTime().toLocalTime();
	    System.out.println("Local Time:  " + lt);
	    
	    LocalDateTime ldt = gc.toZonedDateTime().toLocalDateTime();
	    System.out.println("Local DateTime:  " + ldt);

	    OffsetDateTime od = gc.toZonedDateTime().toOffsetDateTime();
	    System.out.println("Offset  Date: " + od);

	    OffsetTime ot = gc.toZonedDateTime().toOffsetDateTime().toOffsetTime();
	    System.out.println("Offset Time:  " + ot);

	    ZonedDateTime zdt = gc.toZonedDateTime();
	    System.out.println("Zoned DateTime:  " + zdt);
	    System.out.println();
	    
	    ZoneId zoneId = zdt.getZone();
	    TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	    System.out.println("Zone ID:  " + zoneId);
	    System.out.println("Time Zone ID:  " + timeZone.getID());

	    GregorianCalendar gc2 = GregorianCalendar.from(zdt);
	    System.out.println("Gregorian  Calendar: " + gc2.getTime());		
		
	}
}
