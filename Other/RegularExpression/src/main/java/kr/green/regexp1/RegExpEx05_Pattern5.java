package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx05_Pattern5 {
	public static void main(String[] args) {
		// "[abc"을 포함하는지 검색하고 싶다. 하지만 다음은 에러가 발생한다.
		// java.util.regex.PatternSyntaxException: Unclosed character class near index 7
		
		// Pattern pattern5 = Pattern.compile("[abc");
		// System.out.println(pattern5);
		
		// 이럴때 사용하는 메서드가 quote이다.
		// \Q 는 정규 표현식의 시작 표시
		// \E 는 정규 표현식의 끝을 표시
		// String java.util.regex.Pattern.quote(String s)
		String regex = Pattern.quote("[abc");
		Pattern pattern = Pattern.compile(regex);
		System.out.println(regex + " : " + pattern);
		System.out.println("[abc : " + pattern.matcher("[abc").matches());
		System.out.println();
	}
}
