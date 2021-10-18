package kr.green.regexp1;

import java.util.regex.Pattern;
/*
주민등록번호 구성은 아래와 같습니다. 
예) 123456 - 1234567

1. 첫 6자리
12 : 출생년도 마지막 두자리
34 : 출생 월
56 : 출생 일

2. 마지막 7자리
1 : 성별 (1: 남자, 2: 여자, 3: 2000년 이후 출생자 남자, 4: 2000년 이후 출생자 여자)
2345 : 지역코드
6 : 출생신고지 기준 접수 순번
7 : 검증번호 (앞 12 자리 숫자를 특정 공식에 대입 시 딱 하나의 숫자만 나올 수 있음)
*/
public class RegExpEx29_JuminNumber2 {
	public static void main(String[] args) {
		// 앞 6자리 패턴 만들기
		// 1. 출생년도 : 년도는 00~99까지 가능하다. ===>  ^\\d{2}	또는 ^[0-9]{2}
		// 위 두가지 표현식 모두 동일한 의미 입니다. 0 ~ 9 사이 두자릿수 숫자 허용
		String yearPattern = "^\\d{2}";
		System.out.println("년도");
		System.out.println(Pattern.matches(yearPattern, "00"));
		System.out.println(Pattern.matches(yearPattern, "99"));
		// 2. 출생 월  : 01 ~ 12
		String monthPattern = "(0[1-9]|1[0-2])";
		System.out.println("월");
		System.out.println(Pattern.matches(monthPattern, "00"));
		System.out.println(Pattern.matches(monthPattern, "01"));
		System.out.println(Pattern.matches(monthPattern, "12"));
		System.out.println(Pattern.matches(monthPattern, "23"));
		// 2. 출생 일  : 01 ~ 31
		String datePattern = "(0[1-9]|[12][0-9]|3[01])";
		System.out.println("일");
		System.out.println(Pattern.matches(datePattern, "00"));
		System.out.println(Pattern.matches(datePattern, "01"));
		System.out.println(Pattern.matches(datePattern, "31"));
		System.out.println(Pattern.matches(datePattern, "32"));
		System.out.println("주민앞자리");
		String juminPattern1 = yearPattern + monthPattern + datePattern;
		System.out.println(Pattern.matches(juminPattern1, "000101"));
		System.out.println(Pattern.matches(juminPattern1, "991231"));
		System.out.println(Pattern.matches(juminPattern1, "990031"));
		System.out.println(Pattern.matches(juminPattern1, "990044"));
		// 뒤 7자리 : 성별은 1234중1개 나머지 6자리숫자는 000000-999999
		String juminPattern2 = "[1-4]\\d{6}"; 
		System.out.println("뒷자리");
		System.out.println(Pattern.matches(juminPattern2, "0111111"));
		System.out.println(Pattern.matches(juminPattern2, "1111111"));
		System.out.println(Pattern.matches(juminPattern2, "2111111"));
		System.out.println(Pattern.matches(juminPattern2, "3111111"));
		System.out.println(Pattern.matches(juminPattern2, "4111111"));
		System.out.println(Pattern.matches(juminPattern2, "5111111"));
		
		String juminPattern = juminPattern1 + "-" + juminPattern2;
		System.out.println("주민번호패턴 : " + juminPattern);
		System.out.println(Pattern.matches(juminPattern, "111111-1111111"));
		System.out.println(Pattern.matches(juminPattern, "111111-4111111"));
		System.out.println(Pattern.matches(juminPattern, "111111-5111111"));
		System.out.println(Pattern.matches(juminPattern, "110019-1111111"));	
	}
}
