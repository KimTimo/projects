package kr.green.ex0610;

import java.util.Scanner;

public class OpEx8 {

	public static void main(String[] args) {

		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오.");
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		a += 100;
		b = b % 10;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		sc.close();
		
	}

}
