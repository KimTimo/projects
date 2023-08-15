package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx12_Matcher6 {
	public static void main(String[] args) {
		String inputStr = "아 지리산 아~ 금강산 아아~~ 한라산 아아아~~~ 백두산 아아아아~ 뒷동산";
		System.out.println("원본 : " + inputStr);
		Pattern pattern = Pattern.compile("~");
		Matcher matcher = pattern.matcher(inputStr);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			// Matcher java.util.regex.Matcher.appendReplacement(StringBuffer sb, String replacement)
			// 문자열과 패턴이 일치하는 위치에 replacement를 대체하는 데 사용됩니다.
            matcher.appendReplacement(buffer, "!");
            System.out.println(buffer);
        }
		System.out.println(); // 맨뒤 문자열 뒷동산이 사라짐 이때 appendTail()을 사용함
		// StringBuffer java.util.regex.Matcher.appendTail(StringBuffer sb)
		// 뒤에 남은 문자열을 붙여주는데 사용합니다.
		matcher.appendTail(buffer);
		System.out.println(buffer);
		System.out.println();
	}
}
