package jungol;

import java.util.Scanner;

/*
 * 두 개의 정수를 입력받아서 다음과 같이 4가지 관계연산자의 결과를 출력하시오.

   이때 입력받은 두 정수를 이용하여 출력하시오.

   (JAVA는 1이면 true, 0이면 false를 출력한다.)
 */
public class jungol_523 {

	public static void main(String[] args) {

		System.out.println("정수를 입력하시오");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println(x + " > " + y + " = " + (x > y));
		System.out.println(x + " < " + y + " = " + (x < y));
		System.out.println(x + " >= " + y + " = " + (x >= y));
		System.out.println(x + " <= " + y + " = " + (x <= y));
		sc.close();
		
	}

}
