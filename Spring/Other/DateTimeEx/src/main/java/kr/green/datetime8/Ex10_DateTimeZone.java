package kr.green.datetime8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.Set;

// Java Date Time Zone
public class Ex10_DateTimeZone {
	public static void main(String[] args) {
		ZoneOffset zoneOffset1 = ZoneOffset.ofHours(-1);
		System.out.println(zoneOffset1);
		ZoneOffset zoneOffset2 = ZoneOffset.ofHoursMinutes(6, 30);
		System.out.println(zoneOffset2);
		ZoneOffset zoneOffset3 = ZoneOffset.ofHoursMinutesSeconds(9, 30, 45);
		System.out.println(zoneOffset3);
		System.out.println();

		ZoneOffset zoneOffset4 = ZoneOffset.of("+05:00");
		ZoneOffset zoneOffset5 = ZoneOffset.of("Z"); // Same as ZoneOffset.UTC
		System.out.println(zoneOffset4);
		System.out.println(zoneOffset5);
		System.out.println();

		// 상수
		System.out.println("ZoneOffset.UTC: " + ZoneOffset.UTC);
		System.out.println("ZoneOffset.MIN: " + ZoneOffset.MIN);
		System.out.println("ZoneOffset.MAX: " + ZoneOffset.MAX);
		System.out.println();

		// Time Zone ID
		ZoneId usChicago = ZoneId.of("America/Chicago");
		System.out.println(usChicago);
		ZoneId fixedZoneId = ZoneId.of("+01:00");
		System.out.println(fixedZoneId);
		ZoneId asiaSeoul = ZoneId.of("Asia/Seoul");
		System.out.println(asiaSeoul);
		fixedZoneId = ZoneId.of("+09:00");
		System.out.println(fixedZoneId);
		System.out.println();

		// 모든 zoneIds
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		for (String zoneId : zoneIds) {
			System.out.println(zoneId);
		}
		System.out.println();
		
		// ZoneRules 영역 오프셋이 어떻게 변하는지 추적합니다.
		// 다음 코드는 를 사용 ZoneRules 하여 ZoneId에 대한 시간 오프셋 및 시간 변경에 대한 
		// 정보를 가져오는 방법을 보여줍니다 .
		LocalDateTime  now = LocalDateTime.now(); 
	    usChicago   = ZoneId.of("America/Chicago");
	    System.out.println("Zone ID:  "  + usChicago.getId());

	    ZoneRules  rules = usChicago.getRules();
	    System.out.println("isFixedOffset(): "  + rules.isFixedOffset());
	    ZoneOffset offset = rules.getOffset(now); 
	    System.out.println("Zone offset: "  + offset);

	    List<ZoneOffsetTransition> transitions = rules.getTransitions(); 
	    System.out.println(transitions);
	}
}
