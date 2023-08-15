package kr.green.ex0610;

import java.util.Scanner;

public class OpEx04 {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.printf("년도를 입력하시오\n");
			int year = sc.nextInt();
			if(year == 0) break;
		
		
		
		// 입력된 년도가 평년인지 윤년인지를 판단하여 출력하시오.
		/*
		 * 윤년 판단 기준
		 * 
		 * 년도가 400의 배수면 윤년
		 * 또는
		 * 년도가 4의 배수이면서 100의 배수가 아니면 윤년
		 */
		
		System.out.println(year + " 년은 " + (year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? "윤" : "평")+ "년입니다.");
		}
		sc.close();
	}

}
