package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx01_Pattern1 {
	public static void main(String[] args) {
		// "^[0-9]*$" : 숫자만
		Pattern pattern = Pattern.compile("^[0-9]*$");
		System.out.println(pattern);
		// String java.util.regex.Pattern.toString()
		System.out.println(pattern.toString());
		// String java.util.regex.Pattern.pattern()
		System.out.println(pattern.pattern());
		System.out.println();
	}
}
