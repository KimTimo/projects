package kr.green.exam;

import java.io.IOException;
import java.util.Scanner;

/*
문자에 해당하는 아스키코드를 알아내는 코드
철이는 아스키코드에 대해 공부하고있었습니다.
하지만 기억력이 좋지않아 순서를 잊어먹게되는탓에 프로그램을 하나 만들어두려합니다.
문자를 입력받으면 그 문자에 해당하는 아스키코드를 출력하는 코드를 작성해주세요.

출력조건
a는 아스키코드로 97입니다.
d는 아스키코드로 100입니다.
A는 아스키코드로 65입니다.
*/
public class EX02 {
	public static void main(String[] args) throws IOException {
		System.out.println("문자 입력(Q는 종료)");
		Scanner sc = new Scanner(System.in);
		String str="";
		do {
			str = sc.nextLine();
			System.out.println(str.charAt(0) + "는 아스키코드로 " + (str.charAt(0)+0) + "입니다.");
		}while(str.charAt(0)!='q');
		sc.close();
	}
}
