package kr.green.ex0611;

public class Ex10 {

	public static void main(String[] args) {

		double pi = 3.141592;
		
		System.out.println("원주율 : " + Math.PI);
		System.out.println("원주율 : " + pi);
		// 원하는 자릿수에서 버림을 해보자
		System.out.println("원주율 : " + (int)pi);
		// 소수 첫째자리 까지만 표시
		double r = (int)(pi*10)/10.0;
		System.out.println("원주율 : " + r);
		r = (int)(pi*100)/100.0;
		System.out.println("원주율 : " + r);
		r = (int)(pi*1000)/1000.0;
		System.out.println("원주율 : " + r);
		// 소수 이하 넷째자리에서 반올림해서 셋째자리까지 출력
		r = (int)((pi + 0.0005)*1000)/1000.0;
		System.out.println("원주율 : " + r);
		
	}

}
