package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx23_Example10 {
	public static void main(String[] args) {
		// ? : 바로 앞의 문자가 없거나 하나임
		// + : 바로 앞의 문자가 하나이상 있음
		// * : 바로 앞의 문자가 없거나 하나이상 있음
		// | : 또는, or, 합집합의 개념으로 사용
		//() : '()'안의 문자열을 하나로 묶어서 다룸
		//[] : '[]'안은 범위와 집합의 개념으로 다룸  
		//{n,m} : 바로 앞의 문자가 n글자 이상 m글자개 반복, m이 없으면 n개 이상 
		String[] inputArray = "1,12,123,1234,a,ab,abc,abcd,A,AB,ABC,ABCD".split(",");
		System.out.println("숫자 만으로 1개 이상");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("[0-9]+", str));
		}
		System.out.println();
		
		System.out.println("알파벳 소문자 만으로 1개 이상");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("[a-z]+", str));
		}
		System.out.println();
		
		System.out.println("알파벳 대, 소문자 구분없이 1개 이상");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("[a-zA-Z]+", str));
		}
		System.out.println();

		System.out.println("알파벳 대, 소문자 구분없이 2,3개");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("[a-zA-Z]{2,3}", str));
		}
		System.out.println();

		System.out.println("숫자, 알파벳 대, 소문자 구분없이 2,3개");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("[0-9a-zA-Z]{2,3}", str));
		}
		System.out.println();

		// []안의 ^는 반대의 개념임
		System.out.println("숫자, 알파벳 대문자가 아닌 2,3개");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("[^0-9A-Z]{2,3}", str));
		}
		System.out.println();
	}
}
