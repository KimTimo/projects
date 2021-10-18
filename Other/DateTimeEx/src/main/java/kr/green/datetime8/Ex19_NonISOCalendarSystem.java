package kr.green.datetime8;

import java.time.LocalDate;
import java.time.Year;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.chrono.ThaiBuddhistDate;

/*
// Non ISO Calendar System
LocalDate는 그레고리력인 ISO 달력 시스템을 사용합니다.
Java Date-Time API는 태국 불교 달력, , Minguo 달력 및 일본 달력과 같은 다른 달력도 지원합니다.
비 ISO 달력 관련 클래스는 java.time.chrono패키지에 정의되어 있습니다.
사용 가능한 각 비 ISO 달력 시스템에는 사용자 지정 이름의 Chronology 및 사용자 지정 이름의 Date 클래스가 있습니다.
Custom-named Chronology 클래스는 달력 시스템을 나타내는 반면 Custom-named Date 클래스는 사용자 지정 달력 시스템의 날짜를 나타냅니다.
사용자 지정 이름이 지정된 각 Chronology 클래스에는 해당 클래스의 단일 인스턴스를 나타내는 INSTANCE 상수가 포함되어 있습니다. 
*/
public class Ex19_NonISOCalendarSystem {
	public static void main(String[] args) {
		ThaiBuddhistChronology thaiBuddhistChrono = ThaiBuddhistChronology.INSTANCE; // 태국 불교달력
	    ThaiBuddhistDate thaiBuddhistDate = thaiBuddhistChrono.dateNow();
	    ThaiBuddhistDate thaiBuddhistDate2 = ThaiBuddhistDate.now();
	    System.out.println(thaiBuddhistDate);
	    System.out.println(thaiBuddhistDate2);

	    JapaneseDate japaneseDate = JapaneseDate.now(); // 일본 달력
	    System.out.println(japaneseDate);
	    
	    HijrahDate hijrahDate = HijrahDate.now(); // 이슬람력
	    System.out.println(hijrahDate);
	    
	    IsoChronology isoChronology = IsoChronology.INSTANCE;
	    LocalDate localDate =  isoChronology.dateNow();
	    System.out.println(localDate);
	    
	    // 민국기원 또는 민국기년은 중화민국의 건국이 선포된 1912년을 원년으로 하는 기년법이다. 
	    MinguoDate minguoDate =  MinguoDate.now(); // 중국달력
	    System.out.println(minguoDate);
	    System.out.println();
	    
	    System.out.println("서기 : " + (Year.now().getValue()));
	    System.out.println("단기 : " + (Year.now().getValue() + 2333));
	    System.out.println("불기 : " + (Year.now().getValue() + 544));
	    System.out.println();
	    
	    //  convert ISO
	    LocalDate isoNow1 = LocalDate.now();
	    ThaiBuddhistDate thaiBuddhistNow2 = ThaiBuddhistDate.from(isoNow1);
	    LocalDate isoNow2 = LocalDate.from(thaiBuddhistNow2);
	    System.out.println(isoNow1);
	    System.out.println(thaiBuddhistNow2);
	    System.out.println(isoNow2);
	}
}
