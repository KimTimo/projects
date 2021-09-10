package kr.green.exam;
/*
자릿수를 출력하는 프로그램
양의 정수만 입력으로 받고 그 수의 자릿수를 출력해보자. 
ex1) 3 > 1자리수, 
ex2) 649 > 3자리수 ....
 */
public class Ex03 {
	public static void main(String[] args) {
		System.out.println(length(1));
		System.out.println(length(12));
		System.out.println(length(123));
		System.out.println(length(1234));
		System.out.println(length(12345));
	}
	
	public static int length(int n) {
		int len = 0;
		while(n>0) {
			n/=10;
			++len;
		}
		return len;
	}
}
