package kr.green.regexp1;

import java.util.regex.Pattern;

public class RegExpEx22_Example9 {
	public static void main(String[] args) {
		// ? : 바로 앞의 문자가 없거나 하나임
		// + : 바로 앞의 문자가 하나이상 있음
		// * : 바로 앞의 문자가 없거나 하나이상 있음
		// | : 또는, or, 합집합의 개념으로 사용
		//() : '()'안의 문자열을 하나로 묶어서 다룸
		//[] : '[]'안은 범위와 집합의 개념으로 다룸  
		//{n,m} : 바로 앞의 문자가 n글자 이상 m글자개 반복, m이 없으면 n개 이상
		String[] inputArray = "az,abz,acz,abbz,abbbz".split(",");
		System.out.println("a로시작되고 중간에 임의문자가 없거나 1개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("a.?z", str));
		}
		System.out.println();
		
		System.out.println("a로시작되고 중간에 b가 없거나 1개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("ab?z", str));
		}
		System.out.println();
		
		System.out.println("a로시작되고 중간에 b가 없거나 n개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("ab*z", str));
		}
		System.out.println();

		System.out.println("a로시작되고 중간에 b가 n개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("ab+z", str));
		}
		System.out.println();
		
		System.out.println("a로시작되고 중간에 b 또는 c가 1개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("a(b|c)z", str));
		}
		System.out.println();
		
		System.out.println("a로시작되고 중간에 b 또는 c가 1개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("a[bc]z", str)); // b or c
		}
		System.out.println();

		System.out.println("a로시작되고 중간에 b가 2개있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("ab{2,2}z", str)); // b가 2개
			// System.out.println(str + " : " + Pattern.matches("abbz", str));  //
		}
		System.out.println();
		
		System.out.println("a로시작되고 중간에 b가 2개 이상 있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("ab{2,}z", str)); // b가 2개 이상
		}
		System.out.println();
		
		System.out.println("a로시작되고 중간에 b가 2개 이하 있으며 z로 종료 ");
		for(String str : inputArray) {
			System.out.println(str + " : " + Pattern.matches("ab{0,2}z", str)); // b가 2개 이하
		}
		System.out.println();
	}
}
