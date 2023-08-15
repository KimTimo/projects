package jungol;

import java.util.Scanner;

public class jungol_519 {

	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오.");
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		a += 100;
		b %= 10;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		sc.close();

	}

}
