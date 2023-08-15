package kr.green.ex0610;

public class IntegerTypeEx2 {

	public static void main(String[] args) {

		
		int a = 10; // 숫자가 1~9로 시작되면 10진수로 인식.
		int b = 0b10; // 숫자가 0B로 시작되면 2진수로 인식.
		int c = 010; // 숫자가 0로 시작되면 8진수로 인식.
		int d = 0x10; // 숫자가 0x로 시작되면 16진수로 인식.
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		long e = 5L; // 뒤에 L,l이 붙으면 long형이 된다.
		System.out.println(e);
		
		float f = 10f;
		System.out.println(f);
		
		
	}

}
