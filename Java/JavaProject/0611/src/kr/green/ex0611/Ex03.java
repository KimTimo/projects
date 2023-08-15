package kr.green.ex0611;

public class Ex03 {

	public static void main(String[] args) {

		int n = 1;
		System.out.println("n = " + n); // n = 0000 0001 2진수로 표현할때
		System.out.println("n = " + (n << 1)); // n = 0000 0010
		System.out.println("n = " + (n << 2)); // n = 0000 0100
		System.out.println();
		// n << m : n * 2의 m승

		n = 32;
		System.out.println("n = " + n); // n = 0000 0001 2진수로 표현할때
		System.out.println("n = " + (n >> 1)); // n = 0000 0010
		System.out.println("n = " + (n >> 2)); // n = 0000 0100
		System.out.println();

		n = -32;
		System.out.println("n = " + n); // n = 0000 0001 2진수로 표현할때
		System.out.println("n = " + (n >>> 1)); // n = 0000 0010
		System.out.println("n = " + (n >>> 2)); // n = 0000 0100
		System.out.println();
		
		n = -32;
		System.out.println("n = " + n); // n = 0000 0001 2진수로 표현할때
		System.out.println("n = " + (n >> 1)); // n = 0000 0010
		System.out.println("n = " + (n >> 2)); // n = 0000 0100
		System.out.println();
	}

}
