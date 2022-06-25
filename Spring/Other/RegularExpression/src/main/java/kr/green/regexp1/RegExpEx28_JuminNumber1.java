package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx28_JuminNumber1 {
	// 주민등록번호 정규식
	public static void main(String[] args) {
		// 주민등록번호
		String patternStr = "^\\d{6}-[1234]\\d{6}$";
		System.out.println(Pattern.matches(patternStr, "111111-1111111"));
		System.out.println(Pattern.matches(patternStr, "111111-4111111"));
		System.out.println(Pattern.matches(patternStr, "111111-5111111"));
		System.out.println(Pattern.matches(patternStr, "11111-111111"));
	}
}
