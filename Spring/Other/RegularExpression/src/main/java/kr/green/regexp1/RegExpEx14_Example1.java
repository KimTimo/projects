package kr.green.regexp1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegExpEx14_Example1 {
	public static void main(String[] args) {
		String inputStr = "0사과1배2수박3바나나123-qwerty&$#@45QWERTY77~!@#$%";
		System.out.println("원본 : " + inputStr);
		System.out.println();
		// 1. 바꾸기
		System.out.println("1. 숫자만 뽑고싶다.");
		// 숫자가 아닌 문자만 지우기
		System.out.println(inputStr.replaceAll("[^0-9]+", ""));
		System.out.println(inputStr.replaceAll("\\D+", ""));
		System.out.println();
		
		System.out.println("2. 숫자가 아닌 문자만 뽑고싶다.");
		// 숫자만 지우기
		System.out.println(inputStr.replaceAll("[0-9]+", ""));
		System.out.println(inputStr.replaceAll("\\d+", ""));
		System.out.println();
		
		// 2. 나누기
		System.out.println("3. 숫자를 구분자로 배열 만들기");
		System.out.println(Arrays.toString(inputStr.split("\\d+")));
		System.out.println(Arrays.toString(Pattern.compile("\\d+").split(inputStr)));
		System.out.println();
		
		System.out.println("4. 숫자가 아닌 문자를 구분자로 배열 만들기");
		System.out.println(Arrays.toString(inputStr.split("\\D+")));
		System.out.println(Arrays.toString(Pattern.compile("\\D+").split(inputStr)));
		System.out.println();
		
		// 3. 검사하기
		String str1 = "1234567890";
		String str2 = "123456789a";
		System.out.println("5. 숫자만으로 이루어졌는지 검사하기");
		System.out.print(str1 + " : " + Pattern.matches("[0-9]+", str1));
		System.out.println(" : " + (Pattern.matches("[0-9]+", str1)? "숫자로만 구성":"숫자가 아닌 문자포함"));
		System.out.print(str2 + " : " + Pattern.matches("\\d+", str2));
		System.out.println(" : " + (Pattern.matches("\\d+", str2)? "숫자로만 구성":"숫자가 아닌 문자포함"));
	}
}
