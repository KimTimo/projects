package kr.green.regexp1;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class RegExpEx03_Pattern3 {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("한");
		// Predicate<String> java.util.regex.Pattern.asPredicate()
		// Predicate는 Type T 인자를 받고 boolean을 리턴하는 함수형 인터페이스입니다.
		Predicate<String> predicate = pattern.asPredicate();
		System.out.println(predicate);
		for(String word : new String[] {"한","대한","대한민국","우리나라"}) {
			// test()에 인자를 전달하면 boolean이 리턴됩니다.
			// boolean java.util.function.Predicate.test(String t)
			System.out.println(word + " : " + predicate.test(word));
		}
		System.out.println();
	}
}
