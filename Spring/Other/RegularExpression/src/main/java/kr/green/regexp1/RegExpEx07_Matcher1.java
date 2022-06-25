package kr.green.regexp1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx07_Matcher1 {
	public static void main(String[] args) {
		String inputStr = "아름다운 금강산";
		// Matcher java.util.regex.Pattern.matcher(CharSequence input)
		Matcher matcher = Pattern.compile(".*금강산.*").matcher(inputStr);
		if(matcher.matches()) {
			System.out.println("일치하는 내용 찾음");
			System.out.println(matcher.group());
		}else {
			System.out.println("일치하는 내용 못찾음");
		}
		System.out.println();
		matcher = Pattern.compile(".*한라산.*").matcher(inputStr);
		if(matcher.matches()) {
			System.out.println("일치하는 내용 찾음");
			System.out.println(matcher.group());
		}else {
			System.out.println("일치하는 내용 못찾음");
		}
	}
}
