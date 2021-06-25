package kr.green.maven0625.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TimeZone;

public class DateTimeEx2 {

	// JDK 1.8에 추가된 향상된 날짜와 시간 클래스들. 불변객체이다.
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		ZoneId zoneId = ZoneId.of("Asia/Seoul");  // TimeZone
		ZonedDateTime zdt = now.atZone(zoneId);
		System.out.println(zdt);
		
		// 세계 시간표
		Set<String> set = ZoneId.getAvailableZoneIds();
		for(String t : set) {
			ZoneId zoneId2 = ZoneId.of(t);
			ZonedDateTime zonedDateTime = ZonedDateTime.now().withZoneSameInstant(zoneId2);
			System.out.println(zonedDateTime);
		}
	}

}
