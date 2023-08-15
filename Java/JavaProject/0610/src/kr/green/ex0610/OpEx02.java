package kr.green.ex0610;

import java.util.Scanner;

public class OpEx02 {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		int birth = 980507;
		String birth2 = "980507";
		
		System.out.println("우리 곤듀는");
		System.out.println(birth/10000 + "년");
		System.out.println(birth%10000/100 + "월");
		System.out.println(birth%100 + "일생");
		
		System.out.print("월급여 액수를 입력하세요");
		int p = sc.nextInt();		
		System.out.println("100,000원권 " + (p/10_0000) + "매");
		p = p % 10_0000;
		System.out.println("50,000원권 " + (p/5_0000) + "매");
		p = p % 5_0000;
		System.out.println("10,000원권 " + (p/1_0000) + "매");
		
		
		
		int m[] = {10_0000, 5_0000, 1_0000, 5000, 1000, 500, 100, 10, 5, 1};
		System.out.print("월급여 액수를 입력하세요");
		p = sc.nextInt();
		for(int i = 0; i < m.length; i++) {
			System.out.printf("%6d원권 : %3d매\n", m[i], p/m[i]);
			p %= m[i];
		}
		sc.close();
	}

}
