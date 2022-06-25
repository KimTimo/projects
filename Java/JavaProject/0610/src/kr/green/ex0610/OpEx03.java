package kr.green.ex0610;

import java.util.Scanner;

public class OpEx03 {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수 1개를 입력하시오");
		int n = sc.nextInt();
		//입력된 정수의 홀짝을 판단하여 출력해보시오
		
		System.out.println(n + "은 " + (n % 2 == 0 ? "짝" : "홀") + "수입니다.");
		
		
		
		sc.close();
	}

}
