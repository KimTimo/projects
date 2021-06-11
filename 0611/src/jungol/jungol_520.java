package jungol;

import java.util.Scanner;

public class jungol_520 {

	public static void main(String[] args) {

		System.out.println("정수를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		
		System.out.println(x++);
		System.out.println(++x);
		sc.close();
		
		
	}

}
