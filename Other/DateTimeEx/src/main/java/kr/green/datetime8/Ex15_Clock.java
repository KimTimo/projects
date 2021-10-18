package kr.green.datetime8;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/*
Java Clock
----------
Clock 클래스는 실제 시계를 나타냅니다.
Clock클래스 에서 시간대의 현재 순간, 날짜 및 시간에 액세스할 수 있습니다 .
다음과 같이 시스템 기본 시간대에 대한 시계를 만들 수 있습니다.
Clock clock = Clock.systemDefaultZone();
지정된 시간대에 대한 시계를 만들려면.
ZoneId z = ZoneId.of("America/Los_Angeles");
클록 clock2 = Clock.system(z);
시계에서 현재 순간, 날짜 및 시간을 가져오려면 now(Clock c) datetime 관련 클래스 의 메서드를 사용합니다 .
*/
public class Ex15_Clock {
	public static void main(String[] args) {
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock);

		Instant instant1 = clock.instant();
		System.out.println(instant1);

		Instant instant2 = Instant.now(clock);
		System.out.println(instant2);

		LocalDate localDate = LocalDate.now(clock);
		System.out.println(localDate);

		ZonedDateTime zoneDateTime = ZonedDateTime.now(clock);
		System.out.println(zoneDateTime);
		System.out.println();
		/*
		 * static Period of(int years,int months, int days) static Period ofDays(int
		 * days) static Period ofMonths(int months) static Period ofWeeks(int weeks)
		 * static Period ofYears(int years)
		 */
		Period p1 = Period.of(2, 3, 5); // 2 years, 3 months, and 5 days
		Period p2 = Period.ofDays(2); // 2 days
		Period p3 = Period.ofMonths(-3); // -3 months
		Period p4 = Period.ofWeeks(3); // 3 weeks
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println();

		p1 = Period.ofDays(15); // +15일
		System.out.println(p1);
		p2 = p1.plusDays(12); // +12일
		System.out.println(p2);
		p3 = p1.minusDays(12); // -12일
		System.out.println(p3);
		p4 = p1.negated(); // 부호변경
		System.out.println(p4);
		Period p5 = p1.multipliedBy(3); // 곱하기
		System.out.println(p5);
		System.out.println();

		p1 = Period.of(2, 3, 5);
		p2 = Period.of(1, 15, 28);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.minus(p2));
		System.out.println(p1.plus(p2));
		System.out.println(p1.plus(p2).normalized());
		System.out.println();
		
		// Period Between
		LocalDate ld1  = LocalDate.of(2014, Month.JANUARY,  7); 
	    LocalDate ld2  = LocalDate.of(2014, Month.MAY,  21); 
	    long  days  = ChronoUnit.DAYS.between(ld1, ld2);
	    System.out.println(days);
	    
	    LocalTime  lt1 = LocalTime.of(6, 0); 
	    LocalTime  lt2 = LocalTime.of(9, 30); 
	    long  hours   = ChronoUnit.HOURS.between(lt1, lt2);
	    System.out.println(hours);
	    long  minutes = ChronoUnit.MINUTES.between(lt1,   lt2);
	    System.out.println(minutes);	
	    System.out.println();
	    
	    // Period Util
	    ld1 = LocalDate.of(2014, Month.JANUARY, 7);
	    ld2 = LocalDate.of(2014, Month.MAY, 18);
	    System.out.println(ld1);
	    System.out.println(ld2);
	    
	    lt1 = LocalTime.of(7, 0);
	    lt2 = LocalTime.of(9, 30);
	    System.out.println(lt1);
	    System.out.println(lt2);
	    
	    days = ld1.until(ld2, ChronoUnit.DAYS);
	    System.out.println(days);
	    hours = lt1.until(lt2, ChronoUnit.HOURS);
	    System.out.println(hours);
	    minutes = lt1.until(lt2, ChronoUnit.MINUTES);
	    System.out.println(minutes);
	}
}
