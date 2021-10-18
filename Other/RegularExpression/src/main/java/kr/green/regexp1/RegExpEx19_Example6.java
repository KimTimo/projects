package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx19_Example6 {
	public static void main(String[] args) {
		String inputStr = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라만세";
		System.out.println("원본 : " + inputStr);

		// 특정 문자열을 포함하는지 판단
		// .* : 임의의 문자가 0개 이상
		String findStr = "나라";
		boolean isIncluded = inputStr.matches(".*" + findStr + ".*");
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));

		isIncluded = inputStr.contains(findStr);
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));

		isIncluded = Pattern.matches(".*" + findStr + ".*", inputStr);
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));

		Pattern pattern = Pattern.compile(".*" + findStr + ".*");
		Matcher matcher = pattern.matcher(inputStr);
		isIncluded = matcher.matches();
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));
		System.out.println();

		findStr = "국가";
		isIncluded = inputStr.matches(".*" + findStr + ".*");
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));

		isIncluded = inputStr.contains(findStr);
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));

		isIncluded = Pattern.matches(".*" + findStr + ".*", inputStr);
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));
		
		pattern = Pattern.compile(".*" + findStr + ".*");
		matcher = pattern.matcher(inputStr);
		isIncluded = matcher.matches();
		System.out.println(findStr + " " + (isIncluded ? "포함" : "미포함"));
		System.out.println();

		// contains()와 matches()의 차이점
		// contains()는 단순히 인자로 전달된 문자열이 존재하는지 여부를 리턴합니다.
		// 반면에 matches()는 정규표현식을 인자로 받고 동일한 패턴의 문자열이라면 true를 리턴합니다.
		// 대소문자 구분없이 일치하는지 검사하고 싶다.
		// [Tt] : T 또는 t
		System.out.println("contains() 사용");
		inputStr = "True";
		System.out.println("원본 : " + inputStr);
		boolean isMatches = inputStr.contains("true") || inputStr.contains("True");
		System.out.println(isMatches ? "일치" : "불일치");
		isMatches = inputStr.toLowerCase().contains("true");
		System.out.println(isMatches ? "일치" : "불일치");
		System.out.println();

		System.out.println("정규표현식 사용");
		isMatches = inputStr.matches("[Tt]rue");
		System.out.println(isMatches ? "일치" : "불일치");
		isMatches = Pattern.matches("[Tt]rue", inputStr);
		System.out.println(isMatches ? "일치" : "불일치");
		System.out.println();

	}
}
