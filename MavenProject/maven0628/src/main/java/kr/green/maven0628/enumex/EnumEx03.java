package kr.green.maven0628.enumex;

import java.util.Date;

/*
열거 타입의 장점
문자열과 비교해 IDE의 지원을 받을 수 있다. (자동완성, 오타 검증, 텍스트 리팩토링)
허용 가능한 값들을 제한
리팩토링 시 변경 범위가 최소화 된다. (내용 추가가 필요해도 Enum 코드 외에 수정할 필요가 없다.)
해당 장점은 모든 언어가 Enum에서 얻을 수 있는 장점이다. 
더 나아가 Java Enum의 경우 C/C++과 다르게 Enum이 int 값이 아니라 완전한 기능을 가진 클래스이다. 
이를 기반한 장점이 더 있다.
*/

public class EnumEx03 {
	
	enum Season {
		SPRING("봄"),
		SUMMER("여름"),
		AUTUMN("가을"),
		WINTER("겨울");
		
		final private String value;
		private Season(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date.toLocaleString());
		
		Season season = Season.SPRING;
		System.out.println(season);
		
		season = Season.SUMMER;
		System.out.println(season.getValue());

		// season = 6; // 에러다!!!!
		
		switch (season) {
		case SPRING:
			System.out.println("봄이다. 놀러가자 산으로~~~");
			break;
		case SUMMER:
			System.out.println("여름이다. 놀러가자 바다로~~~");
			break;
		case AUTUMN:
			System.out.println("가을이다. 놀러가자 계곡으로~~~");
			break;
		case WINTER:
			System.out.println("겨울이다. 춥다 집에있자~~~");
			break;
		}
		
		for(Season s : Season.values()) {
			System.out.println(s + " : " + s.value + " : " + s.ordinal());
		}
		System.out.println(Season.valueOf("WINTER"));
	}
}
