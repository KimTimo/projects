package kr.green.exception1;

import java.util.Scanner;

// 두개의 정수를 입력받아 나눗셈의 결과를 보여주는 프로그램을 작성하시오.
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두개의 정수를 입력하세요.");
		int x = sc.nextInt();
		int y = sc.nextInt();

		int result = x / y;

		System.out.println(x + "/" + y + "=" + result);
		sc.close();
	}

}
