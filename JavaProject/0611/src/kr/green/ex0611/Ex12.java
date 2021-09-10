package kr.green.ex0611;

public class Ex12 {

	public static void main(String[] args) {

		// 반올림 함수 : Math.round(숫자)
		double d = 56789.56789;
		System.out.println("d = " + d);
		
		// 소수 첫째자리에서 반올림됨
		System.out.println("d = " + Math.round(d)); 
		
		// 소수 둘째 자리에서 반올림하여 소수 첫째 자리까지 출력
		System.out.println("d = " + Math.round(d*10)/10.0); 
		System.out.println("d = " + Math.round(d*100)/100.0); 
		System.out.println("d = " + Math.round(d*1000)/1000.0); 
		// 1의 자리에서 반올림하여 몇10원까지 출력
		System.out.println();
		System.out.println("d = " + Math.round(d/10)*10); 
		System.out.println("d = " + Math.round(d/100)*100); 
		System.out.println("d = " + Math.round(d/1000)*1000); 
		
		System.out.println();
		// 8이상 올림 7이하 버림
		int m = 5677;
		System.out.println("m = " + m); // 5677
		System.out.println("m = " + Math.round((m-3)/10.0)*10); // 5670

		m = 5678;
		System.out.println("m = " + m);
		System.out.println("m = " + Math.round((m-3)/10.0)*10); // 5680
		
		System.out.println();
		System.out.println((10 ^ 10) == 0); // 같은 수를 xor 연산하면 0이다.
		System.out.println((10 ^ 9) == 0); // 다른 수를 xor 연산하면 1이상이다.
	}

}
