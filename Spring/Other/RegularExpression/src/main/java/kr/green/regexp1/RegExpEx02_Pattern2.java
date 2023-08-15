package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx02_Pattern2 {
	public static void main(String[] args) {
		System.out.println("\".한\" : 두 글자이면서 두번째 글자가 \"한\"인지를 검사한다.\n");
		// Pattern 클래스 사용법 1
		System.out.println("1. Pattern.matches(String regex, CharSequence input)");
		// boolean java.util.regex.Pattern.matches(String regex, CharSequence input)
		for(String word : new String[] {"대한","소한","소백","대한민국"}) {
			System.out.println(word + " : " + Pattern.matches(".한", word));
		}
		System.out.println();
		
		// Pattern 클래스 사용법 2
		System.out.println("2. pattern.matches(CharSequence input)");
		Pattern pattern = Pattern.compile(".한");
		for(String word : new String[] {"대한","소한","소백","대한민국"}) {
			// Matcher java.util.regex.Pattern.matcher(CharSequence input)
			Matcher matcher = pattern.matcher(word);
			// boolean java.util.regex.Matcher.matches()
			System.out.println(word + " : " + matcher.matches());
		}
		System.out.println();
		
		// Pattern 클래스 사용법 3
		System.out.println("3. Pattern.compile(String regex).matcher(CharSequence input).matches()");
		for(String word : new String[] {"대한","소한","소백","대한민국"}) {
			System.out.println(word + " : " + Pattern.compile(".한").matcher(word).matches());
		}
		System.out.println();
	}
}
