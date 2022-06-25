package kr.green.regexp1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx20_Example7 {
	public static void main(String[] args) {
		// . : 임의의 한 문자와 매치됩니다.
		Pattern pattern = Pattern.compile("..");
		String inputStr = "대한민국123456qwertyQWERTY";
		System.out.println("원본 : " + inputStr);
		
		// 2글자씩 잘라내기
		Matcher matcher = pattern.matcher(inputStr);
		System.out.print(pattern + " : ");
		while(matcher.find()) {
			System.out.print(matcher.group() + " ");
		}
		System.out.println("\n");
		
		// ".s" : 첫번째 글자는 임의의 1문자이고 두번째 문자가 "s"인 문자인가? 
		inputStr = "s,is,AS,was";
		String[] strArray = inputStr.split(",");
		System.out.println("원본 : " + Arrays.toString(strArray));

		for(String str : strArray) {
			System.out.println(str + " : " + Pattern.compile(".s").matcher(str).matches());
		}
		System.out.println();
		
		// ".[sS]" : 첫번째 글자는 임의의 1문자이고 두번째 문자가 "s" 또는 "S"인 문자인가? 
		for(String str : strArray) {
			System.out.println(str + " : " + Pattern.compile(".[sS]").matcher(str).matches());
		}
		System.out.println();
		
		// Pattern.CASE_INSENSITIVE : 대소문자 무시 옵션
		for(String str : strArray) {
			System.out.println(str + " : " + Pattern.compile(".s", Pattern.CASE_INSENSITIVE).matcher(str).matches());
		}
		System.out.println();
	}
}
