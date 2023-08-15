package kr.green.ex0611;

public class Ex02 {

	public static void main(String[] args) {

		int x = 10, y = 20;
		System.out.println("x = " + x + ", y = " + y);
		
		int temp = x; // x값을 임시 변수에 피신
		x = y;
		y = temp; // 피신시킨 x의 값을 y에 넣는다.
		System.out.println("x = " + x + ", y = " + y);

		// 임시 변수를 사용하지 말고 교환
		// XOR 연산 사용
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x = " + x + ", y = " + y);
	}
}
