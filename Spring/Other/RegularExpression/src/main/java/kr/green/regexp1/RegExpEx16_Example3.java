package kr.green.regexp1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegExpEx16_Example3 {
	public static void main(String[] args) {
		String inputStr = "0사과1배2수박3바나나123ㄱㄹ나ㅑㅕㅡㅣqwerty";
		System.out.println("원본 : " + inputStr);
		System.out.println();
		// 1. 바꾸기
		System.out.println("1. 한글만 뽑고싶다.");
		// 한글이 아닌 문자만 지우기
		System.out.println(inputStr.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힁]+", ""));
		System.out.println();
		
		System.out.println("2. 한글이 아닌 문자만 뽑고싶다.");
		// 한글만 지우기
		System.out.println(inputStr.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힁]+", ""));
		System.out.println();
		
		// 2. 나누기
		System.out.println("3. 한글을 구분자로 배열 만들기");
		System.out.println(Arrays.toString(inputStr.split("[ㄱ-ㅎㅏ-ㅣ가-힁]+")));
		System.out.println(Arrays.toString(Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힁]+").split(inputStr)));
		System.out.println();
		
		System.out.println("4. 한글이 아닌 문자를 구분자로 배열 만들기");
		System.out.println(Arrays.toString(inputStr.split("[^ㄱ-ㅎㅏ-ㅣ가-힁]+")));
		System.out.println(Arrays.toString(Pattern.compile("[^ㄱ-ㅎㅏ-ㅣ가-힁]+").split(inputStr)));
		System.out.println();
		
		// 3. 검사하기
		String str1 = "한글만으로구성됨";
		String str2 = "한글만으로구성됨2";
		System.out.println("5. 한글로만 이루어졌는지 검사하기");
		System.out.print(str1 + " : " + Pattern.matches("[ㄱ-ㅎㅏ-ㅣ가-힁]+", str1));
		System.out.println(" : " + (Pattern.matches("[ㄱ-ㅎㅏ-ㅣ가-힁]+", str1)? "한글만으로 구성":"한글이 아닌 문자포함"));
		System.out.print(str2 + " : " + Pattern.matches("[ㄱ-ㅎㅏ-ㅣ가-힁]+", str2));
		System.out.println(" : " + (Pattern.matches("[ㄱ-ㅎㅏ-ㅣ가-힁]+", str2)? "한글만으로 구성":"한글이 아닌 문자포함"));
		// 잘못된 정규 표현식
		str1 = "한글만으로구성됨ㄱㄴㄷㄹ";
		str2 = "한글만으로구성됨ㅏㅑㅓㅕ";
		System.out.print(str1 + " : " + Pattern.matches("[가-힁]+", str1));
		System.out.println(" : " + (Pattern.matches("[가-힁]+", str1)? "한글만으로 구성":"한글이 아닌 문자포함"));
		System.out.print(str2 + " : " + Pattern.matches("[가-힁]+", str2));
		System.out.println(" : " + (Pattern.matches("[가-힁]+", str2)? "한글만으로 구성":"한글이 아닌 문자포함"));
	}
}
