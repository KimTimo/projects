package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx13_Matcher7 {
	public static void main(String[] args) {
		String inputStr = "아 지리산 아~ 금강산 아아~~ 한라산 아아아~~~ 백두산 아아아아~ 뒷동산";
		Pattern pattern = Pattern.compile("~");
		Matcher matcher = pattern.matcher(inputStr);
		
		// String java.util.regex.Matcher.replaceAll(String replacement)
		System.out.println("원본 : " + inputStr);
		String outputStr1 = matcher.replaceAll("!!");
		System.out.println("변경 : " + outputStr1);
		System.out.println();
		
		// String java.lang.String.replaceAll(String regex, String replacement)
		// replaceAll메서드 에서도 정규 표현식 사용가능
		System.out.println("원본 : " + inputStr);
		String outputStr2 = inputStr.replaceAll("아", "오");
		System.out.println("변경 : " + outputStr2);
		outputStr2 = inputStr.replaceAll("~", "!!");
		System.out.println("변경 : " + outputStr2);
	}
}
