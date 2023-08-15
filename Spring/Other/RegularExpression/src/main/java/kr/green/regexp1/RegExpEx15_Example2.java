package kr.green.regexp1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegExpEx15_Example2 {
	public static void main(String[] args) {
		String inputStr = "0사과1배2수박3바나나123-qwerty&$#@45QWERTY77~!@#$%";
		System.out.println("원본 : " + inputStr);
		System.out.println();
		// 1. 바꾸기
		System.out.println("1. 영문자만 뽑고싶다.");
		// 영문자가 아닌 문자만 지우기
		System.out.println(inputStr.replaceAll("[^a-zA-Z]+", ""));
		System.out.println();
		
		System.out.println("2. 영문자가 아닌 문자만 뽑고싶다.");
		// 영문자만 지우기
		System.out.println(inputStr.replaceAll("[a-zA-Z]+", ""));
		System.out.println();
		
		// 2. 나누기
		System.out.println("3. 영문자를 구분자로 배열 만들기");
		System.out.println(Arrays.toString(inputStr.split("[a-zA-Z]+")));
		System.out.println(Arrays.toString(Pattern.compile("[a-zA-Z]+").split(inputStr)));
		System.out.println();
		
		System.out.println("4. 영문자가 아닌 문자를 구분자로 배열 만들기");
		System.out.println(Arrays.toString(inputStr.split("[^a-zA-Z]+")));
		System.out.println(Arrays.toString(Pattern.compile("[^a-zA-Z]+").split(inputStr)));
		System.out.println();
		
		// 3. 검사하기
		String str1 = "qwertyQWERTY";
		String str2 = "qwertyQWERTY2";
		System.out.println("5. 영문자만으로 이루어졌는지 검사하기");
		System.out.print(str1 + " : " + Pattern.matches("[a-zA-Z]+", str1));
		System.out.println(" : " + (Pattern.matches("[a-zA-Z]+", str1)? "영문자로만 구성":"영문자가 아닌 문자포함"));
		System.out.print(str2 + " : " + Pattern.matches("[a-zA-Z]+", str2));
		System.out.println(" : " + (Pattern.matches("[a-zA-Z]+", str2)? "영문자로만 구성":"영문자가 아닌 문자포함"));
	}
}
