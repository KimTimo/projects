package kr.green.ex0610;

import java.util.Scanner;

public class OpEx05 {

	public static void main(String[] args) {

		int ko, mt, si;
		int sum, avg;
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하시오.");
		
		ko = sc.nextInt();
		mt = sc.nextInt();
		si = sc.nextInt();
		
		sum = ko + mt + si;
		avg = sum/3;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
		sc.close();
		
	}

}
