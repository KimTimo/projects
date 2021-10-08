package kr.green.datetime8;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/*
// Predefined Date Time Format
미리 정의된 포맷터는 DateTimeFormatter클래스 에서 상수로 정의됩니다 .

BASIC_ISO_DATE
두 날짜 구성 요소 사이에 구분 기호를 사용하지 않고 날짜 형식을 지정하고 구문 분석합니다.
예:20140209
20140221-0600
ISO_DATE
ISO 구분 기호를 사용하여 날짜, 시간 및 날짜 시간 형식을 지정하고 구문 분석합니다.
예:2014-02-09
ISO_TIME
ISO 구분 기호를 사용하여 날짜, 시간 및 날짜 시간 형식을 지정하고 구문 분석합니다.
예:15:21:32.927
15:21:32.123-06:00
ISO_DATE_TIME
ISO 구분 기호를 사용하여 날짜, 시간 및 날짜 시간 형식을 지정하고 구문 분석합니다.
예:2014-02-09-06:00
2014-02-09T15:20:07.123-06:00
2014-02-09T15:20:07.123-06:00[미국/시카고]
ISO_INSTANT
UTC 형식의 ZonedDateTime과 같은 인스턴트 또는 인스턴트를 나타내는 날짜/시간 객체의 형식을 지정하고 구문 분석합니다.
예:2014-02-09T21:23:56.870Z
ISO_LOCAL_DATE
오프셋 없이 날짜 형식을 지정하거나 구문 분석합니다.
예:2014-02-09
ISO_LOCAL_TIME
오프셋 없이 시간을 형식화하거나 구문 분석합니다.
예:15:30:12.123
ISO_LOCAL_DATE_TIME
오프셋 없이 날짜/시간 형식을 지정하거나 구문 분석합니다.
예:2014-02-09T15:29:11.214
ISO_OFFSET_DATE
ISO 형식을 사용하여 오프셋으로 날짜를 형식화하고 구문 분석합니다.
예:2014-02-09-06:00
ISO_OFFSET_TIME
ISO 형식을 사용하여 오프셋으로 시간을 형식화하고 구문 분석합니다.
예:15:12:29.123-06:00
ISO_OFFSET_DATE_TIME
ISO 형식을 사용하여 오프셋으로 날짜 시간을 형식화하고 구문 분석합니다.
예:2014-02-09T15:33:07.07-06:0
ISO_ZONED_DATE_TIME
사용 가능한 경우 영역 ID로 날짜/시간 형식을 지정하고 구문 분석합니다.
예:2014-02-09T15:45:49.123-06:00
2014-02-09T15:45:12.112-06:00[미국/시카고]
ISO_ORDINAL_DATE
연도와 날짜를 사용하여 날짜를 형식화하고 구문 분석합니다.
예:2014-009
ISO_WEEK_DATE
주 기반 날짜의 형식을 지정하고 구문 분석합니다. '2014-W02-4'는 2014년 둘째 주의 넷째 날을 의미합니다.
예:2014-W02-4
2014-W02-4-06:00
RFC_1123_DATE_TIME
RFC1123 사양을 사용하여 전자 메일의 날짜/시간 형식을 지정하고 구문 분석합니다.
예: 2014년 1월 9일 목요일 15:12:12 -060

String format(TemporalAccessor temporal)
void formatTo(TemporalAccessor temporal, Appendable  appendable)
*/
public class Ex20_PredefinedDateTimeFormat {
	public static void main(String[] args) {
		String ldStr = DateTimeFormatter.ISO_DATE.format(LocalDate.now());
	    System.out.println(ldStr);
	    String odtStr = DateTimeFormatter.ISO_DATE.format(OffsetDateTime.now());
	    System.out.println(odtStr);
	    String zdtStr = DateTimeFormatter.ISO_DATE.format(ZonedDateTime.now());
	    System.out.println(zdtStr);
	    System.out.println();
	    
	    LocalDate ld = LocalDate.now();
	    ldStr = ld.format(DateTimeFormatter.ISO_DATE);
	    System.out.println("Local  Date: " + ldStr);

	    OffsetDateTime odt = OffsetDateTime.now();
	    odtStr = odt.format(DateTimeFormatter.ISO_DATE);
	    System.out.println("Offset  Datetime: " + odtStr);

	    ZonedDateTime zdt = ZonedDateTime.now();
	    zdtStr = zdt.format(DateTimeFormatter.ISO_DATE);
	    System.out.println("Zoned  Datetime: " + zdtStr);
	}
}
