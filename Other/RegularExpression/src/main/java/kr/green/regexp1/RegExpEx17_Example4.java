package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx17_Example4 {
	// 문자열에서 공백 제거하기
	public static void main(String[] args) {
		String str1 = "   공백 공백 공백   ";
		String str2 = "		탭		탭	탭	";
		String str3 = "공백 \f탭\t탭\n탭\r\n개행";
		System.out.println("문자열 1 : " + str1);
		System.out.println("문자열 2 : " + str2);
		System.out.println("문자열 3 : " + str3);
		System.out.println();
		
		System.out.println(str1.replaceAll("\\s", ""));
		System.out.println(str1.replaceAll("[\\f\\t\\r\\n ]", ""));
		System.out.println(Pattern.compile("\\s").matcher(str1).replaceAll(""));
		System.out.println();

		System.out.println(str2.replaceAll("\\s", ""));
		System.out.println(str2.replaceAll("[\\f\\t\\r\\n ]", ""));
		System.out.println(Pattern.compile("\\s").matcher(str2).replaceAll(""));
		System.out.println();
		
		System.out.println(str3.replaceAll("\\s", ""));
		System.out.println(str3.replaceAll("[\\f\\t\\r\\n ]", ""));
		System.out.println(Pattern.compile("\\s").matcher(str3).replaceAll(""));
		System.out.println();
	}
}
